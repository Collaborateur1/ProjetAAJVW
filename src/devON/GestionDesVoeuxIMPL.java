
package devON;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesProfils;
import generated.GestionDesProfilsHelper;
import generated.GestionDesVoeux;
import generated.GestionDesVoeuxPOA;
import generated.IEtudiant;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.Rectorat;
import generated.RectoratHelper;
import generated.UtilisationInterdite;
import generated.Voeu;
import generated.decision;

public class GestionDesVoeuxIMPL extends GestionDesVoeuxPOA{
	
	short numGDV;
	
	Hashtable<String,Formation>ListeFormation;
	Hashtable<String,IEtudiant>ListeEtudiant;
	Hashtable<String,Hashtable<String,Voeu>>ListeVoeuxEtudiant;
	GestionDesProfils gdpRattache;
	LoadBalancerEtudiant loadBalancer;
	Rectorat rect;
	
	public GestionDesVoeuxIMPL(short numServ, org.omg.CORBA.ORB orb) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides {
		
		ListeFormation = new Hashtable<String,Formation>();
		ListeEtudiant = new Hashtable<String,IEtudiant>();
		ListeVoeuxEtudiant = new Hashtable<String,Hashtable<String,Voeu>>();
		
		numGDV=numServ;
		
		rect = RectoratHelper.narrow(NamingServiceTool.getReferenceIntoNS("Rectorat"));
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		gdpRattache = loadBalancer.getServProfil(numServ);
		// TODO Auto-generated constructor stub
	}

	@Override
	public short numeroGDV() {
		// TODO Auto-generated method stub
		return numGDV;
	}

	@Override
	public void inscriptionIE(String ine, IEtudiant iorEtudiant)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		ListeEtudiant.put(ine, iorEtudiant);
		ListeVoeuxEtudiant.put(ine, new Hashtable<String,Voeu>());
	}

	@Override
	public Formation[] rechercherFormation(String motscles) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		Hashtable lv = ListeVoeuxEtudiant.get(ine);
		if(lv.size()<6)
		{
			lv.put(ordre, monVoeux);
		}
	}

	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierVoeu(String ine, short numeroVoeu, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		Hashtable lv = ListeVoeuxEtudiant.get(ine);
		//parcourir la hashtable retrouver le voeu transmis en paramètre et inverser avec celui qui à ce nouvelle ordre
	}

	@Override
	public void supprimerVoeux(String ine, short numeroVoeu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transmettreDecisionCandidatureRectorat(String ine, Voeu Reponse)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	}


}

