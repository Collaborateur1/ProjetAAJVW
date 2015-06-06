
package devON;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
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
	Hashtable<String,ArrayList<Voeu>>ListeVoeuxEtudiant;
	GestionDesProfils gdpRattache;
	LoadBalancerEtudiant loadBalancer;
	Rectorat rect;
	
	public GestionDesVoeuxIMPL(short numServ, org.omg.CORBA.ORB orb) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides {
		
		ListeFormation = new Hashtable<String,Formation>();
		ListeEtudiant = new Hashtable<String,IEtudiant>();
		ListeVoeuxEtudiant = new Hashtable<String,ArrayList<Voeu>>();
		
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
		ListeVoeuxEtudiant.put(ine, new ArrayList<Voeu>());
	}

	@Override
	public Formation[] rechercherFormation(String motscles) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		Voeu[] lvc = new Voeu[5];
		
		@SuppressWarnings("rawtypes")
		Iterator it = lv.iterator();
		Voeu v = (Voeu) it.next();
		int i =0;
		while(it.hasNext())
		{
			lvc[i] = v;
			v = (Voeu) it.next();
			i++;
		}
		return lvc;
	}

	@Override
	public void faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		if(lv.size()<6)
		{
			monVoeux.numeroVoeu = ordre;
			lv.add(monVoeux);
		}
	}

	@Override
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//IL MANQUE LE NUMERO DE VOEUX ! IDL A REPRENDRE !!
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void repondreAuxPropositions(String ine, decision choixEtu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		
		@SuppressWarnings("rawtypes")
		Iterator it = lv.iterator();
		Voeu v = (Voeu) it.next();
		while(it.hasNext())
		{
			if(v.numeroVoeux==numeroVoeux)
			{
				v.dcsEtudiant = choixEtu;
			}
			v = (Voeu) it.next();
		}
	}

	@Override
	public void modifierVoeu(String ine, short numeroVoeu, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);

		@SuppressWarnings("rawtypes")
		Iterator it = lv.iterator();
		Voeu v = (Voeu) it.next();
		while(it.hasNext())
		{
			if(ordre < numeroVoeu)
			{
				if(v.numeroVoeu==numeroVoeu)
					v.numeroVoeu = ordre;
				else if(v.numeroVoeu>=ordre && v.numeroVoeu<numeroVoeu)
					v.numeroVoeu = (short) (v.numeroVoeu+1);
			}
			else
			{
				if(v.numeroVoeu==numeroVoeu)
					v.numeroVoeu = ordre;
				else if(v.numeroVoeu<=ordre && v.numeroVoeu>numeroVoeu)
					v.numeroVoeu = (short) (v.numeroVoeu-1);
			}
			v = (Voeu) it.next();
		}
		

		
	}

	@Override
	public void supprimerVoeux(String ine, short numeroVoeu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		
		@SuppressWarnings("rawtypes")
		Iterator it = lv.iterator();
		Voeu v = (Voeu) it.next();
		while(it.hasNext())
		{
			if(v.numeroVoeu==numeroVoeu)
				lv.remove(v);
			v = (Voeu) it.next();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void transmettreDecisionCandidatureRectorat(String ine, Voeu Reponse)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		
		Voeu v;
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==Reponse.numeroVoeu)
			{
				lv.set(i, Reponse);
			}
		}
	}


}

