
package devON;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesProfils;
import generated.GestionDesProfilsHelper;
import generated.GestionDesVoeux;
import generated.GestionDesVoeuxHelper;
import generated.GestionDesVoeuxPOA;
import generated.IEtudiant;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.Ministère;
import generated.MinistèreHelper;
import generated.Rectorat;
import generated.RectoratHelper;
import generated.UtilisationInterdite;
import generated.Voeu;
import generated.decision;
import generated.etatvoeux;

public class GestionDesVoeuxIMPL extends GestionDesVoeuxPOA{
	
	short numGDV;
	
	Hashtable<String,Formation>ListeFormation;
	Hashtable<String,IEtudiant>ListeEtudiant;
	Hashtable<String,ArrayList<Voeu>>ListeVoeuxEtudiant;
	GestionDesProfils gdpRattache;
	LoadBalancerEtudiant loadBalancer;
	Rectorat rect;
	Ministère ministere;
	
	public GestionDesVoeuxIMPL(short numServ, org.omg.CORBA.ORB orb) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides, AdapterInactive {
		
		ListeFormation = new Hashtable<String,Formation>();
		ListeEtudiant = new Hashtable<String,IEtudiant>();
		ListeVoeuxEtudiant = new Hashtable<String,ArrayList<Voeu>>();
		
		numGDV=numServ;
	
		
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		
		//tu avais oublier d'activer le PoA et d'enregister ta classe dans GestionDesProfil, jai rajouter
		
		/*1) ici japel le rootPOA grace à lorb, sa va permettre d'activer le POA
		/*1)*/org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		/*2) ici j'active le POA*/
		/*2*/rootPOA.the_POAManager().activate();
		
		ministere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Reférérence ministere recuperee" );
		
		rect=ministere.recupererRectorat("rectorat");
		gdpRattache = loadBalancer.getServProfil(numServ);
		/*3) ici je rajoute la classe GestionDesVoeuxIMPL dans le gestion des profils*/
		//c'est ici que l'on caste GestionDesVoeuxIMPL en GestionDesVoeux GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this))s
		/*3*/gdpRattache.inscriptionGestionDesVoeux(GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this)));
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
	
		return ministere.madDesFormationsFrance();
	}

	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
			
		Voeu[] lvc = new Voeu[5];
		
		if(!lv.isEmpty())
		{
			
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
		}
		else
		{ //impossible de renvoyer la valeur null toute les cases du tableau doivent etre remplis sinon cela ne marchera pas
		  //quand on détectera ce cas on affichera pas le voeux ou on mettra "choisir votre voeu"	
			Formation fr= new Formation("Choisir un voeux"," Choisir un voeux", "Choisir un voeux", "Choisir un voeux");
			etatvoeux et=etatvoeux.nonValide;
			decision dc=decision.NONdefinitif;
			short temp=0;
			Voeu vx=new Voeu(fr, et, dc, temp);
			for(int j=0;j<5;j++)
			{
				lvc[j]=vx;
			}
		}
		return lvc;
	}

	@Override
	public Voeu[] faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		if(lv.size()<6)
		{
			monVoeux.numeroVoeu = ordre;
			lv.add(monVoeux);
		}
		return chargerVoeux(ine);
	}

	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//IL MANQUE LE NUMERO DE VOEUX ! IDL A REPRENDRE !! ==>C'est fait..
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu,
			short numeroVoeu) throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList lv = ListeVoeuxEtudiant.get(ine);
				
				@SuppressWarnings("rawtypes")
				Iterator it = lv.iterator();
				Voeu v = (Voeu) it.next();
				while(it.hasNext())
				{
					if(v.numeroVoeu==numeroVoeu)
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

