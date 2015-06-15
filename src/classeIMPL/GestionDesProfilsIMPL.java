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
	int nombreGDV;
	LoadBalancerEtudiant loadBalancer;
	org.omg.PortableServer.POA rootPOA;
	DBGestionDesProfils bddGVP;

	Ministère ministere;

	/*********************Costructeur
	 * @throws DonneesInvalides 
	 * @throws InvalidName 
	 * @throws WrongPolicy 
	 * @throws ServantNotActive 
	 * @throws ServantAlreadyActive 
	 * @throws AdapterInactive ******************************/
	public GestionDesProfilsIMPL(short nGdp,org.omg.CORBA.ORB orb,String monRectorat) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive {
		numGDP=nGdp;
		etudiantConnecter=new Hashtable<String, IEtudiant>();
		etudiantinscrit=new Hashtable <String,Etudiant>();
		CodeEtudiantInscrit= new  Hashtable <String,String>();
		nombreGDV=1;
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));


		rootPOA.the_POAManager().activate();
		ministere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));


		loadBalancer.inscriptionGDP(GestionDesProfilsHelper.narrow(rootPOA.servant_to_reference(this)), nGdp);
		bddGVP = new DBGestionDesProfils();
		
		ArrayList<BDDEtudiantHelper> le=null;
		try {
			le =  bddGVP.ChargerEtudiant(numGDP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BDDEtudiantHelper e;
		for(int i=0;i<le.size();i++)
		{
			e = le.get(i);
			etudiantinscrit.put(e.getEtu().ineEtudiant, e.getEtu());
			//System.out.println("Ajout de l'étudiant : "+e.getEtu().ineEtudiant);
			if(e.getMdp()!="")
				CodeEtudiantInscrit.put(e.getEtu().ineEtudiant, e.getMdp());
		}
	}

	/*********************Fonction généré******************************/

	@Override
	public short numeroGDP() {
		// TODO Auto-generated method stub
		return numGDP;
	}

	@Override
	public boolean autorisationConnexion(String ine, String mdp)
			throws DonneesInvalides {

		if(etudiantinscrit.containsKey(ine) )
		{
			if(CodeEtudiantInscrit.get(ine).equals(mdp))
			{
				return true;
			}
		}
		System.out.println("*************************");
		return false;
	}

	@Override
	public GestionDesVoeux connexion(IEtudiant iorEtudiant, String ine,
			String mdp) throws DonneesInvalides {

		if(etudiantinscrit.containsKey(ine) )
		{

			if(CodeEtudiantInscrit.get(ine).equals(mdp))
			{
				GestionDesVoeuxInscrit.inscriptionIE(ine, iorEtudiant);
				if(etudiantConnecter.contains(ine))
					etudiantConnecter.replace(ine, iorEtudiant);
				else
					etudiantConnecter.put(ine, iorEtudiant);

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

	@Override
	public void inscriptionGestionDesVoeux(GestionDesVoeux GDesVx) {
		// TODO Auto-generated method stub
		GestionDesVoeuxInscrit=GDesVx;

		nombreGDV++;
	}

	@Override
	public boolean etudiantInscrit(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub

		return etudiantinscrit.containsKey(ine);
	}

	@Override
	public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return ministere.GetRectoratEtudiant(ine).getFicheEtudiant(ine);
	}

	@Override
	public boolean inscriptionEtudiant(String ine, String mdp)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		System.out.println("Entree dans comparaison");
		if(CodeEtudiantInscrit.containsKey(ine) == false)
		{
			if(etudiantinscrit.containsKey(ine))
			{
				CodeEtudiantInscrit.put(ine,mdp);
				bddGVP.ajouterMotDePass(ine,mdp);
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
		/*
		if(!etudiantinscrit.containsKey(ine))
		{
			
			Etudiant etu=etudiantinscrit.get(ine);

			if(etu.formation.NomFormation.contains("nada"))
			{
				return false;
			}
			else
			{
				etudiantinscrit.put(etu.ineEtudiant,etu);

				
				return true;
			}
		}

		return false;
		*/

	}
	/*********************Fonction rajouté******************************/

	public void setProfil(Etudiant etu)
	{
		/*etudiantinscrit.put(etu.ineEtudiant,etu);

		CodeEtudiantInscrit.put(etu.ineEtudiant,"1234");*/

	}

	public LoadBalancerEtudiant getLoadBalancer()
	{
		return loadBalancer;
	}

	@Override
	public GestionDesVoeux getGDV() {
		// TODO Auto-generated method stub
		return GestionDesVoeuxInscrit;
	}








}
