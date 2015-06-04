package devON;

import generated.DonneesInvalides;
import generated.GestionDesProfils;
import generated.GestionDesVoeux;
import generated.IEtudiant;
import generated.IEtudiantHelper;
import generated.IEtudiantPOA;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.Voeu;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import generated.Etudiant;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class EtudiantIMPl extends IEtudiantPOA{
	Client cl; //il sagit de l'interface principale postbac
	GestionDesProfils gdp;
	SocialNetworkIHM interfaceConnexion;
	org.omg.PortableServer.POA rootPOA;
	GestionDesVoeux gdv;
	LoadBalancerEtudiant loadbalancer;
	Hashtable <String,Voeu> ListeVoeuxEtu;

	
	/**********Constructeur
	 * @throws RemoteException ************/	
	public EtudiantIMPl() throws RemoteException
	{
		this.cl=cl;
		cl=new Client(this);
		interfaceConnexion=new SocialNetworkIHM(this,cl);
		loadbalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBL"));
		
	}
	
	/********fonction généré******/
	@Override
	public void notifier(String message) {
		// TODO Auto-generated method stub
		System.out.println (message);
		
	}
	@Override
	public void majEtatVoeux(Voeu UnVoeu) {
		// TODO Auto-generated method stub
		ListeVoeuxEtu.get(UnVoeu.numeroVoeu).etatVoeu = UnVoeu.etatVoeu;
		
							
	}

	
		/*************Fonction rajouter****************/
	
	public boolean ConnexionGDP(String INE, String mdp) throws DonneesInvalides, ServantNotActive, WrongPolicy
	{
		IEtudiant etu;
		if(setGestionDesProfils(INE))
		{
			etu=IEtudiantHelper.narrow(rootPOA.servant_to_reference(this));
			//gdv=gdp.connexion(etu, INE, mdp);
			//cl.configuration_de_connexion(gdp.consulterProfil(INE),gdv.chargerVoeux(INE));
			
			gdp.consulterProfil(INE);
			
			cl.configuration_de_connexion(gdp.consulterProfil(INE),null);
		
			cl.setVisible(true);
			return true;
		}
		
		return false;
	}

	
	public Client getPostLicenceInterface()
	{
		return this.cl;
	}
	
	public boolean setGestionDesProfils(String ine) throws DonneesInvalides
	{	
		gdp=loadbalancer.getProfil(ine);
		if(gdp!=null)
		return true;
		
		return false;
	}
	public void setPOA(org.omg.CORBA.ORB orb) throws InvalidName, AdapterInactive
	{
		rootPOA=org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();
	}
	public Client getClient()
	{
		return cl;
	}
	public SocialNetworkIHM getInetfaceConnex()
	{
		return interfaceConnexion;
	}
	public GestionDesProfils getGDP()
	{
		return gdp;
	}
	
	public GestionDesVoeux getGDV()
	{
		return gdv;
	}
	
	public LoadBalancerEtudiant getLoadBalancer()
	{
		return loadbalancer;
	}
	/*
	public ArrayList ConsulterProfilGDP(String INE)
	{
		return null;
	}
	
	public Seq ConsulterProfilGDP(String INE)
	{
		return null;
	}
	**/
public static void main(String[] args) throws RemoteException, InvalidName, AdapterInactive {
	
	EtudiantIMPl etu=new EtudiantIMPl();
	org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
	etu.setPOA(orb);
	etu.getInetfaceConnex().setVisible(true);

	orb.run();
	
	
	
	
	
}


}
