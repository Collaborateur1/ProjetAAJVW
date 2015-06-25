package classeIMPL;

import generated.DonneesInvalides;
import generated.GestionDesProfils;
import generated.GestionDesVoeux;
import generated.IEtudiant;
import generated.IEtudiantHelper;
import generated.IEtudiantPOA;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.UtilisationInterdite;
import generated.Voeu;
import generated.decision;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JButton;

import generated.Etudiant;
import graphique.Client;
import graphique.SocialNetworkIHM;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import outils.NamingServiceTool;

public class EtudiantIMPl extends IEtudiantPOA{
	Client cl; //il sagit de l'interface principale postbac
	GestionDesProfils gdp;
	SocialNetworkIHM interfaceConnexion;
	org.omg.PortableServer.POA rootPOA;
	GestionDesVoeux gdv;
	LoadBalancerEtudiant loadbalancer;
	ArrayList<Voeu> ListeVoeuxEtu;
	String INE;

	/**********Constructeur
	 * @throws RemoteException ************/	
	public EtudiantIMPl() throws RemoteException
	{
		this.cl=cl;
		cl=new Client(this);
		interfaceConnexion=new SocialNetworkIHM(this,cl);
		//On récupère le LoadBalancer
		loadbalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		ListeVoeuxEtu=new ArrayList<Voeu>();
	}

	/********fonction généré******/
	@Override
	public void notifier(String message) {
		// TODO Auto-generated method stub
		cl.notification(message);

	}

	@Override
	public void majEtatVoeux(Voeu[] Voeux) {
		// TODO Auto-generated method stub
		
		cl.miseAjourJlist2(Voeux);
	}



	/*************Fonction rajouter****************/

	public boolean ConnexionGDP(String INE, String mdp) throws DonneesInvalides, ServantNotActive, WrongPolicy
	{
		IEtudiant etu;
		//ici on récupere la GDP de letudiant selon son ine
		if(setGestionDesProfils(INE))
		{
			//On teste si l'étudiant à le droit de ce connecter
			if(gdp.autorisationConnexion(INE, mdp))
			{
				//On teste si l'étudiant est déjà connecté ou non
				if(gdp.etudiantInscrit(INE))
				{
					etu=IEtudiantHelper.narrow(rootPOA.servant_to_reference(this));
					gdv=gdp.connexion(etu, INE, mdp);
					//Si il possède des voeux on les charges dans l'interface
					if(gdv.possedeVoeux(INE))
						cl.configuration_de_connexion(gdp.consulterProfil(INE),gdv.chargerVoeux(INE));
					else
						cl.configuration_de_connexion(gdp.consulterProfil(INE),null);

					this.INE=INE;
					cl.setVisible(true);
					return true;
				}
				else
					return false;

			}
			return false;
		}


		return false;
	}


	public Client getPostLicenceInterface()
	{
		return this.cl;
	}

	//On charge l'instance du loadBalancer
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
	/***************** Fonction ajouter
	 * @throws UtilisationInterdite 
	 * @throws DonneesInvalides ******************/

	//On envoie un nouveaux voeux à la gestion des voeux et on met à jour l'affichage du client
	public void fairVoeux(Voeu vx, String INE,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.faireUnVoeu(INE, vx, ordre));
	}
	//On modifie l'ordre d'un voeux en l'envoyant à la gestion des voeux et on met à jour l'affichage du client
	public void modifierVoeu( String INE,short numeroVoeux,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.modifierVoeu(INE, numeroVoeux, ordre));
	}
	//On envoit à la gestion des voeux la demande de suppression de ce voeu et on met à jour l'affichage du client
	public void supprimerVoeu( String INE,short numeroVoeux) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.supprimerVoeux(INE, numeroVoeux));
	}
	//On répond OUI, NON, OUI MAIS, NON MAIS à un voeu en le transmettant à la gestion des voeux
	public void repondreAunVoeu(String ine, short numVoeu, decision choixEtu) throws DonneesInvalides, UtilisationInterdite
	{
		gdv.repondreAuxPropositions(ine, choixEtu, numVoeu);
	}
	public String getINE()
	{
		return INE;
	}
	
	//On inscrit un etudiant gràce à son INE. On lui ajout seulement un mot de passe.
	public boolean inscription(String ine, String mdp) throws DonneesInvalides
	{
		
		if(setGestionDesProfils(ine))
		{
			return gdp.inscriptionEtudiant(ine, mdp);
		}
		else
		{
			System.out.println("Probleme récup GDP");
			return false;
		}
	}

	//Cette fonction permet de modifier l'interface d'un etudiant lorsqu'une vague est lancée
	@Override
	public void lancementVague(short numero) {
		// TODO Auto-generated method stub
		if(numero == 1)
		{
			cl.lancementVague1();
		}
		else if(numero == 2)
		{
			cl.lancementVague2();
		}
	}

	//On lance une interface et on l'inscrit à la liste des interfaces connectées
	public static void main(String[] args) throws RemoteException, InvalidName, AdapterInactive {
		EtudiantIMPl etu=new EtudiantIMPl();
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		etu.setPOA(orb);
		etu.getInetfaceConnex().setVisible(true);

		orb.run();
	}

	//On retire l'interface de la liste des interfaces connectées
	public void deconnexion (String ine){
		gdv.deconnexion(ine);
	}


}
