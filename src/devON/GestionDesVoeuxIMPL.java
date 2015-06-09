
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
		
		rect=ministere.recupererRectorat("rectorat");
		listeFormation =ministere.madDesFormationsFrance();
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
			
		Voeu[] lvc = new Voeu[lv.size()];
		
		Iterator<Voeu> it = lv.iterator();
		Voeu v ;
		int i =0;
		while(it.hasNext())
		{
			v =  it.next();
			lvc[i] = v;
			
			i++;
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
	public Voeu[] modifierVoeu(String ine, short numeroVoeu, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
		ArrayList lv = ListeVoeuxEtudiant.get(ine);

		@SuppressWarnings("rawtypes")
		Iterator it = lv.iterator();
		short tempNumero = 0;
		Voeu va;
		Voeu vb;
		for(int i = 0;i<lv.size();i++)
		{
			va = (Voeu) lv.get(i);
			if(va.numeroVoeu == numeroVoeu)
			{
				if(ordre == 1)
				{
					for(int y=0;y<lv.size();y++)
					{
						vb = (Voeu) lv.get(y);
						if(vb.numeroVoeu == numeroVoeu-1)
						{
							tempNumero = va.numeroVoeu;
							va.numeroVoeu = vb.numeroVoeu;
							vb.numeroVoeu = tempNumero;
						}
					}
				}
				else
				{
					for(int y=0;y<lv.size();y++)
					{
						vb = (Voeu) lv.get(y);
						if(vb.numeroVoeu == numeroVoeu+1)
						{
							tempNumero = va.numeroVoeu;
							va.numeroVoeu = vb.numeroVoeu;
							vb.numeroVoeu = tempNumero;
						}
					}
				}
			}
		}
		
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
			{
				lv.remove(v);
			}
			else if(v.numeroVoeu>numeroVoeu)
			{
				v.numeroVoeu--;
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
	}

	@Override
	public boolean possedeVoeux(String ine) {
		// TODO Auto-generated method stub
		if (ListeVoeuxEtudiant.containsKey(ine)){
			
			ArrayList<Voeu> lv=ListeVoeuxEtudiant.get(ine);
			if(!lv.isEmpty())
			return true;
			else
			{
			 return false;
			}
		}
		else
		return false;
	}

	


}

