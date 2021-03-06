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
import generated.Minist�re;
import generated.Minist�reHelper;
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

	Minist�re ministere;

	/**** Constructeur
	 * @throws DonneesInvalides 
	 * @throws InvalidName 
	 * @throws WrongPolicy 
	 * @throws ServantNotActive 
	 * @throws ServantAlreadyActive 
	 * @throws AdapterInactive ****/
	//On initialise la gestion des profils
	public GestionDesProfilsIMPL(short nGdp,org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive {
		//On lui affecte un num�ro qui servira au LoadBalancer � renvoyer la bonne GDP selon l'ine de l'�tudiant (commencant par 1 ou 2)
		numGDP=nGdp;
		
		etudiantConnecter=new Hashtable<String, IEtudiant>();
		etudiantinscrit=new Hashtable <String,Etudiant>();
		CodeEtudiantInscrit= new  Hashtable <String,String>();
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));


		rootPOA.the_POAManager().activate();
		ministere= Minist�reHelper.narrow(NamingServiceTool.getReferenceIntoNS("Ministere"));
		
		//On inscrit la gestion des profils au LoadBalancer pour qu'il connaisse sont IOR
		loadBalancer.inscriptionGDP(GestionDesProfilsHelper.narrow(rootPOA.servant_to_reference(this)), nGdp);
		//On r�cup�re une instance qui permettra de r�cup�rer les donn�es de la BDD
		bddGDP = new DBGestionDesProfils(numGDP);
		
		ArrayList<BDDEtudiantHelper> le=null;//La classe BDDEtudiantHelper cr�er des objets au format de la BDD et de les convertirs en objet Etudiant par la suite
		try {
			//On charge la base de donn�es dans cette liste "temporaire d'objet"
			le =  bddGDP.ChargerEtudiant();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//On parcours la liste retourner par la BDD pour charger les classes qui ont besoin de ces donn�es
		BDDEtudiantHelper e;
		for(int i=0;i<le.size();i++)
		{
			e = le.get(i);
			//On charge un �tudiant dans la Hashtable etudiantinscrit qui r�pertoris tous �tudiants
			etudiantinscrit.put(e.getEtu().ineEtudiant, e.getEtu());
			//Si un �tudiant a un mot de passe (donc est inscrit) On le charge dans la liste des �tudiants qui sont inscris
			if(e.getMdp()!="")
				CodeEtudiantInscrit.put(e.getEtu().ineEtudiant, e.getMdp());
		}
	}

	/********** Fonctions g�n�r�es **********/	
	
	/****
	 * @name numeroGDP  
	 * @description renvoie le num�rode la GDP
	 * 
	 * @return short (Num�ro GDP)
	 ****/
	@Override
	public short numeroGDP() {
		// TODO Auto-generated method stub
		return numGDP;
	}

	/****
	 * @name autorisationConnexion  
	 * @description V�rification si l'�tudiant peut se connecter 
	 * 
	 * @param String : INE de l'�tudiant
	 * @return boolean: Vrai si l'�tudiant peut se connecter 
	 ****/	
	
	@Override
	public boolean autorisationConnexion(String ine, String mdp)
			throws DonneesInvalides {
		
		//Si l'�tudiant existe
		if(etudiantinscrit.containsKey(ine) )
		{
			//Si l'�tudiant est inscrit (donc poss�de un mot de passe)
		if(CodeEtudiantInscrit.containsKey(ine))
		    {if(CodeEtudiantInscrit.get(ine).equals(mdp))
				return true;
		    }
		}
		
		return false;
	}

	/****
	 * @name connexion  
	 * @description Connexion de l'�tudiant
	 * 
	 * @param String : INE de l'�tudiant
	 * @param String : Mot de passe
	 * @return GestionDesVoeux : Gestion des Veeux r'attach� � l'�tudiant
	 ****/	
	@Override
	public GestionDesVoeux connexion(IEtudiant iorEtudiant, String ine,
			String mdp) throws DonneesInvalides {

		//Si l'�tudiant existe
		if(etudiantinscrit.containsKey(ine) )
		{
			//Si le mot de passe transmis est correct
			if(CodeEtudiantInscrit.get(ine).equals(mdp))
			{
				//On permet � une interface d'�tre connu de la gestion des voeux et de la gestion des profil
				
				GestionDesVoeuxInscrit.inscriptionIE(ine, iorEtudiant);//Inscription a la Gestion des voeux
				//On ajout ou replacons dans la liste des interface connect� l'ior de l'interface qui viens de se connecter
				if(etudiantConnecter.contains(ine))
					etudiantConnecter.replace(ine, iorEtudiant);
				else
					etudiantConnecter.put(ine, iorEtudiant);

				//On retour l'ior de la gestion des voeux rattach� pour qu'il puisse l'int�rroger
				return GestionDesVoeuxInscrit;				
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	/****
	 * @name consulterProfil 
	 * @description Consultation d'un profil
	 * 
	 * @param String : INE de l'�tudiant
	 * @return Etudiant : Fiche de l'�tudiant

	 ****/	
	@Override
	public Etudiant consulterProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub	 
		return  etudiantinscrit.get(ine);
	}

	/****
	 * @name modifierProfil 
	 * @description Modification du profil de l'�tudiant
	 * 
	 * @param String : ine de l'�tudiant
	 * @param String : adresse de l'�tudiant
	 ****/	
	@Override
	public void modifierProfil(String ine, String adr) throws DonneesInvalides {
		// TODO Auto-generated method stub
		if(etudiantinscrit.contains(ine)){
			etudiantinscrit.get(ine).adresse = adr;
		}
	}

	/****
	 * @name inscriptionGestionDesVoeux 
	 * @description Inscription de la gestion des voeux
	 * 
	 * @param GestionDesVoeux : gestion des voeux
	 ****/	
	//On inscrit la gestion des voeux � la gestion des profils rattach�
	@Override
	public void inscriptionGestionDesVoeux(GestionDesVoeux GDesVx) {
		// TODO Auto-generated method stub
		GestionDesVoeuxInscrit=GDesVx;
	}

	/****
	 * @name etudiantInscrit 
	 * @description V�rificiation si l'�tudiant est bien insctrit
	 * 
	 * @param String : Ine de l'�tudiant 
	 * @return Boolean : Vrai si l'�tudiant est bien inscrit
	 ****/	
	//On test si un �tudiant existe 
	@Override
	public boolean etudiantInscrit(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub

		return etudiantinscrit.containsKey(ine);
	}

	/****
	 * @name getFicheEtudiant 
	 * @description Obtenir la fiche de l'�tudiant
	 * 
	 * @param String  : Ine de l'�tudiant 

	 ****/	
	
	//On retourne un etudiant selon sont INE
	@Override
	public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return ministere.GetRectoratEtudiant(ine).getFicheEtudiant(ine);
	}

	/****
	 * @name inscriptionEtudiant 
	 * @description Inscription dans le Base de donn�es
	 * 
	 * @param String  : Ine de l'�tudiant 
	 * @param String  : Mots de passe
	 ****/	
	//On inscrit un etudiant qui n'a pas encore de mot de passe
	@Override
	public boolean inscriptionEtudiant(String ine, String mdp)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		if(CodeEtudiantInscrit.containsKey(ine) == false)
		{
			if(etudiantinscrit.containsKey(ine))
			{
				//On ajout l'�tudiant dans la liste des �tudiant inscris
				CodeEtudiantInscrit.put(ine,mdp);
				//On le met a jour dans la BDD
				bddGDP.ajouterMotDePass(ine,mdp);
				return true;
			}
			else
			{
				System.out.println("Etudiant pas charg� avec la BD");
				return false;
			}
		}
		else
		{
			System.out.println("Mot de passe d�ja rentr�");
			return false;
		}

	}
	
	/****
	 * @name getGDV 
	 * @description R�cup�rer la GDV ratach�e
	 * 
	 * @return GestionDesVoeux:gestion des voeu ratach�
	 ****/	
	//On retourne la GDV rattach�
	@Override
	public GestionDesVoeux getGDV() {
		// TODO Auto-generated method stub
		return GestionDesVoeuxInscrit;
	}
	
	/********** Fonctions rajout�es (local) **********/
	
	/****
	 * @name getLoadBalancer 
	 * @description Retrourner le LoadBalancer
	 * 
	 * @return LoadBalancerEtudiant loadBalancer
	 ****/	
	//On retourne le loadBalancer
	public LoadBalancerEtudiant getLoadBalancer()
	{
		return loadBalancer;
	}









}
