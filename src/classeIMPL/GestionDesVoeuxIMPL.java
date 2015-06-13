
package classeIMPL;

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

import outils.NamingServiceTool;
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
	boolean repondreVoeux=false;
	
	Hashtable<String,Formation>ListeFormation;
	Hashtable<String,IEtudiant>ListeEtudiant;
	Hashtable<String,ArrayList<Voeu>>ListeVoeuxEtudiant;
	GestionDesProfils gdpRattache;
	LoadBalancerEtudiant loadBalancer;
	Ministère ministere;
	Formation[] listeFormation;
	
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
		
		listeFormation =ministere.madDesFormationsFrance();
		gdpRattache = loadBalancer.getServProfil(numServ);
		GestionDesVoeux thisdGdv=GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this));
		
		ministere.InscriptionGDVDansRectorats(numServ, thisdGdv);
		/*3) ici je rajoute la classe GestionDesVoeuxIMPL dans le gestion des profils*/
		//c'est ici que l'on caste GestionDesVoeuxIMPL en GestionDesVoeux GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this))s
		/*3*/gdpRattache.inscriptionGestionDesVoeux(thisdGdv);
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
		if(!ListeEtudiant.containsKey(ine))
		{	
		ListeEtudiant.put(ine, iorEtudiant);
		ListeVoeuxEtudiant.put(ine, new ArrayList<Voeu>());
		}
	}

	@Override
	public Formation[] rechercherFormation(String motscles) {
		// TODO Auto-generated method stub
		int taille=0;
		ArrayList<Formation> array=new ArrayList<Formation>();
		for(int i=0;i<listeFormation.length;i++)
		{
			if(listeFormation[i].NomFormation.contains(motscles))
				array.add(listeFormation[i]);
		}
		
		Formation[] fr =new Formation[array.size()];
		
		for(int i=0;i<fr.length;i++)
		{
			fr[i]=array.get(i);
		}
		return fr;
	}

	@Override
	public boolean existFormation(String ine) {
		// TODO Auto-generated method stub
		for(int i=0;i<listeFormation.length;i++)
		{
			if(listeFormation[i].NomFormation.contains(ine))
				return true;
		}
		
		return false;
	}
	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		Voeu v;
		
		Voeu[] lvc = new Voeu[lv.size()];
		for(int i=0;i<lv.size();i++)
		{
			v =  (Voeu) lv.get(i);
			lvc[i] = v;
		}
		
		return lvc;
	}

	@Override
	public Voeu[] faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
			
		ArrayList lv=ListeVoeuxEtudiant.get(ine);
		if(lv.size()<6)
		{
			monVoeux.numeroVoeu = ordre;
			lv.add(monVoeux);
		}
		
		return chargerVoeux(ine);
		
		
		
	}

	
	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu,
			short numeroVoeu) throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList lv = ListeVoeuxEtudiant.get(ine);
				for(int i = 0;i<lv.size();i++)
				{
					Voeu v = (Voeu) lv.get(i);;
					if(v.numeroVoeu==numeroVoeu)
					{
						v.dcsEtudiant = choixEtu;
					}	
				}
		
	}
	


	@Override
	public Voeu[] modifierVoeu(String ine, short numeroVoeu, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		short tempNumero = 0, flag = 0;
		Voeu va;
		Voeu vb;
		//La liste des voeux est retrié a chaque fin de fonction de modifier voeu
		//on considère donc les voeux comme triés
		for(int i = 0;i<lv.size() && flag == 0;i++)
		{
			va = (Voeu) lv.get(i);
			if(va.numeroVoeu == numeroVoeu)
			{
				if(ordre == 1)
				{
					vb = (Voeu) lv.get(i-1);
					tempNumero = vb.numeroVoeu;
					vb.numeroVoeu = va.numeroVoeu;
					va.numeroVoeu = tempNumero;
				}
				else
				{
					vb = (Voeu) lv.get(i+1);
					tempNumero = va.numeroVoeu;
					va.numeroVoeu = vb.numeroVoeu;
					vb.numeroVoeu = tempNumero;
				}
				flag = 1;
			}
		}
		
		//Fonction de trie des voeux
		Voeu lvt[] = new Voeu[lv.size()];
		Voeu v;
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			lvt[v.numeroVoeu-1] = v;
		}
		
		lv.clear();
		
		for(int i=0;i<lvt.length;i++)
			lv.add(lvt[i]);
		
		return chargerVoeux(ine);
		
	}

	@Override
	public Voeu[] supprimerVoeux(String ine, short numeroVoeu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		Voeu v;
		for(int i = 0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==numeroVoeu)
				v.numeroVoeu = 0;
			else if(v.numeroVoeu>numeroVoeu)
				v.numeroVoeu--;
		}
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==0)
			{
				lv.remove(v);
				System.out.println("voeu 0 : supprimé");
			}
		}
		
		return chargerVoeux(ine);
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
		ListeEtudiant.get(ine).majEtatVoeux(chargerVoeux(ine));
	}

	@Override
	public boolean possedeVoeux(String ine) {
		// TODO Auto-generated method stub
		if (ListeVoeuxEtudiant.containsKey(ine)){
			
			ArrayList<Voeu> lv=ListeVoeuxEtudiant.get(ine);
			if(!lv.isEmpty())
				return true;
			else
				return false;
		}
		else
		return false;
	}


	@Override
	public void lancementVague(short numero) {
		// TODO Auto-generated method stub
		System.out.println("first");
		if(numero == 1)//période 1
		{
			
			Enumeration e = ListeVoeuxEtudiant.keys();
			 
			ArrayList<Voeu> lv;
			Etudiant et=null;
			String ine;
			//Parourir et afficher les valeurs
			while(e.hasMoreElements())
			{
				ine = (String) e.nextElement();
				
				lv = ListeVoeuxEtudiant.get(ine);
				try {
					et = gdpRattache.consulterProfil(ine);
					
				} catch (DonneesInvalides e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Voeu[] tabVoeu = new Voeu[lv.size()];
				
				//transformer arraylist voeu en tableau
				for(int i = 0;i<lv.size();i++)
				{
					tabVoeu[i] = lv.get(i);
				}
				try {
					
					ministere.GetRectoratEtudiant(ine).envoyerListeVoeuxGDV(tabVoeu, et);
					
					ListeEtudiant.get(ine).lancementVague((short) 1);
					
				} catch (DonneesInvalides e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if(numero == 2)//période 2
		{System.out.println("test1");
			ministere.deliberationJury();
		}
	}


	/**************Fonction générer***************/




}

