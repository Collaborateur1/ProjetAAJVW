package classeIMPL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import Databases.BDDEtudiantHelper;
import Databases.DBGestionDesProfils;
//import Databases.DBGestionDesProfils;
import outils.NamingServiceTool;
import generated.DonneesInvalides;
import generated.Etudiant;
import generated.EtudiantHelper;
import generated.Formation;
import generated.GestionDesProfils;
import generated.GestionDesProfilsHelper;
import generated.GestionDesProfilsPOA;
import generated.GestionDesVoeux;
import generated.IEtudiant;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.Ministère;
import generated.MinistèreHelper;
import generated.Rectorat;

public class GestionDesProfilsIMPL extends GestionDesProfilsPOA {
	short numGDP;
	Hashtable <String,IEtudiant> etudiantConnecter;
	Hashtable <String,Etudiant> etudiantinscrit;
	Hashtable <String,String> CodeEtudiantInscrit;
	GestionDesVoeux GestionDesVoeuxInscrit;
	LoadBalancerEtudiant loadBalancer;
	org.omg.PortableServer.POA rootPOA;
	DBGestionDesProfils bddGDP;

	Ministère ministere;

	/*********************Costructeur
	 * @throws DonneesInvalides 
	 * @throws InvalidName 
	 * @throws WrongPolicy 
	 * @throws ServantNotActive 
	 * @throws ServantAlreadyActive 
	 * @throws AdapterInactive ******************************/
	//On initialise la gestion des profils
	public GestionDesProfilsIMPL(short nGdp,org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive {
		//On lui affecte un numéro qui servira au LoadBalancer à renvoyer la bonne GDP selon l'ine de l'étudiant (commencant par 1 ou 2)
		numGDP=nGdp;
		
		etudiantConnecter=new Hashtable<String, IEtudiant>();
		etudiantinscrit=new Hashtable <String,Etudiant>();
		CodeEtudiantInscrit= new  Hashtable <String,String>();
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));


		rootPOA.the_POAManager().activate();
		ministere= MinistèreHelper.narrow(NamingServiceTool.getReferenceIntoNS("Ministere"));
		
		//On inscrit la gestion des profils au LoadBalancer pour qu'il connaisse sont IOR
		loadBalancer.inscriptionGDP(GestionDesProfilsHelper.narrow(rootPOA.servant_to_reference(this)), nGdp);
		//On récupère une instance qui permettra de récupérer les données de la BDD
		bddGDP = new DBGestionDesProfils(numGDP);
		
		ArrayList<BDDEtudiantHelper> le=null;//La classe BDDEtudiantHelper créer des objets au format de la BDD et de les convertirs en objet Etudiant par la suite
		try {
			//On charge la base de données dans cette liste "temporaire d'objet"
			le =  bddGDP.ChargerEtudiant();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//On parcours la liste retourner par la BDD pour charger les classes qui ont besoin de ces données
		BDDEtudiantHelper e;
		for(int i=0;i<le.size();i++)
		{
			e = le.get(i);
			//On charge un étudiant dans la Hashtable etudiantinscrit qui répertoris tous étudiants
			etudiantinscrit.put(e.getEtu().ineEtudiant, e.getEtu());
			//Si un étudiant a un mot de passe (donc est inscrit) On le charge dans la liste des étudiants qui sont inscris
			if(e.getMdp()!="")
				CodeEtudiantInscrit.put(e.getEtu().ineEtudiant, e.getMdp());
		}
	}

	/*********************Fonction généré******************************/

	//On retourne le numérode la GDP
	@Override
	public short numeroGDP() {
		// TODO Auto-generated method stub
		return numGDP;
	}

	@Override
	public boolean autorisationConnexion(String ine, String mdp)
			throws DonneesInvalides {

		//Si l'étudiant existe
		if(etudiantinscrit.containsKey(ine) )
		{
			//Si l'étudiant est inscrit (donc possède un mot de passe)
			if(CodeEtudiantInscrit.get(ine).equals(mdp))
				return true;
		}
		System.out.println("*************************");
		return false;
	}

	@Override
	public GestionDesVoeux connexion(IEtudiant iorEtudiant, String ine,
			String mdp) throws DonneesInvalides {

		//Si l'étudiant existe
		if(etudiantinscrit.containsKey(ine) )
		{
			//Si le mot de passe transmis est correct
			if(CodeEtudiantInscrit.get(ine).equals(mdp))
			{
				//On permet à une interface d'être connu de la gestion des voeux et de la gestion des profil
				
				GestionDesVoeuxInscrit.inscriptionIE(ine, iorEtudiant);//Inscription a la Gestion des voeux
				//On ajout ou replacons dans la liste des interface connecté l'ior de l'interface qui viens de se connecter
				if(etudiantConnecter.contains(ine))
					etudiantConnecter.replace(ine, iorEtudiant);
				else
					etudiantConnecter.put(ine, iorEtudiant);

				//On retour l'ior de la gestion des voeux rattaché pour qu'il puisse l'intérroger
				return GestionDesVoeuxInscrit;				
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Etudiant consulterProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub	 
		return  etudiantinscrit.get(ine);
	}

	@Override
	public void modifierProfil(String ine, String adr) throws DonneesInvalides {
		// TODO Auto-generated method stub
		if(etudiantinscrit.contains(ine)){
			etudiantinscrit.get(ine).adresse = adr;
		}
	}

	//On inscrit la gestion des voeux à la gestion des profils rattaché
	@Override
	public void inscriptionGestionDesVoeux(GestionDesVoeux GDesVx) {
		// TODO Auto-generated method stub
		GestionDesVoeuxInscrit=GDesVx;
	}

	//On test si un étudiant existe 
	@Override
	public boolean etudiantInscrit(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub

		return etudiantinscrit.containsKey(ine);
	}

	//On retourne un etudiant selon sont INE
	@Override
	public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return ministere.GetRectoratEtudiant(ine).getFicheEtudiant(ine);
	}

	//On inscrit un etudiant qui n'a pas encore de mot de passe
	@Override
	public boolean inscriptionEtudiant(String ine, String mdp)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		if(CodeEtudiantInscrit.containsKey(ine) == false)
		{
			if(etudiantinscrit.containsKey(ine))
			{
				//On ajout l'étudiant dans la liste des étudiant inscris
				CodeEtudiantInscrit.put(ine,mdp);
				//On le met a jour dans la BDD
				bddGDP.ajouterMotDePass(ine,mdp);
				return true;
			}
			else
			{
				System.out.println("Etudiant pas chargé avec la BD");
				return false;
			}
		}
		else
		{
			System.out.println("Mot de passe déja rentrée");
			return false;
		}

	}
	/*********************Fonction rajouté******************************/

	public void setProfil(Etudiant etu)
	{
		/*etudiantinscrit.put(etu.ineEtudiant,etu);

		CodeEtudiantInscrit.put(etu.ineEtudiant,"1234");*/

	}
	
	//On retourne le loadBalancer
	public LoadBalancerEtudiant getLoadBalancer()
	{
		return loadBalancer;
	}

	//On retourne la GDV rattaché
	@Override
	public GestionDesVoeux getGDV() {
		// TODO Auto-generated method stub
		return GestionDesVoeuxInscrit;
	}








}
