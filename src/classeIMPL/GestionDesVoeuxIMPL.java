
package classeIMPL;

import java.sql.SQLException;
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



import Databases.DBGestionDesVoeux;
//import Databases.DBGestionDesVoeux;
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
	
	/*
	 * Variable
	 */
	short numGDV;
	boolean repondreVoeux=false;
	
	Hashtable<String,Formation>ListeFormation;
	Hashtable<String,IEtudiant>ListeEtudiant;
	Hashtable<String,ArrayList<Voeu>>ListeVoeuxEtudiant;
	GestionDesProfils gdpRattache;
	LoadBalancerEtudiant loadBalancer;
	Ministère ministere;
	Formation[] listeFormation;
	DBGestionDesVoeux bddGDV;
	
	/*
	 * Constructeur
	 */
	public GestionDesVoeuxIMPL(short numServ, org.omg.CORBA.ORB orb) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides, AdapterInactive {
		
		ListeFormation = new Hashtable<String,Formation>();
		ListeEtudiant = new Hashtable<String,IEtudiant>();
		ListeVoeuxEtudiant = new Hashtable<String,ArrayList<Voeu>>();
		numGDV=numServ;
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();
		
		ministere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Reférence ministere recuperee" );
		
		listeFormation = ministere.madDesFormationsFrance();
		gdpRattache = loadBalancer.getServProfil(numServ);
		GestionDesVoeux thisdGdv=GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this));
		
		ministere.InscriptionGDVDansRectorats(numServ, thisdGdv);
		gdpRattache.inscriptionGestionDesVoeux(thisdGdv);
		// TODO Auto-generated constructor stub
		bddGDV = new DBGestionDesVoeux(numGDV);
		
		try {
			ListeVoeuxEtudiant = bddGDV.Chargervoeu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * @name - numeroGDV()
	 * 
	 * description: le numéro de la gdv
	 * 
	 * @return short
	 * @author M2GroupeCorba
	 * @date 20/05/2015
	 * @note
	 */
	
	@Override
	public short numeroGDV() {
		// TODO Auto-generated method stub
		return numGDV;
	}

	/**
	 * name - inscriptionIE Inscription des interfaces étudiants
	 *                            
	 * 
	 * @param String ine : Ine de létudiant
	 * @param IEtudiant iorEtudiant : ior de l'étudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	
	@Override
	public void inscriptionIE(String ine, IEtudiant iorEtudiant)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		if(!ListeEtudiant.containsKey(ine))
		{	
			ListeEtudiant.put(ine, iorEtudiant);		
		}
		if (!ListeVoeuxEtudiant.containsKey(ine)){
			ListeVoeuxEtudiant.put(ine, new ArrayList<Voeu>());
		}
	
	}

	/**
	 * name - rechercherFormation  Recherche de formation
	 * 
	 * 
	 * @param String : mots clé de recherche
	 * @return Formation[]: liste de formation
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
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

	/**
	 * name - existFormation  l'étudiant a t'il des voeux
	 * 
	 * 
	 * @param String : ine de l'étudiant
	 * @return boolean: existance de létudiant dans le SI
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
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
	
	/**
	 * name - chargerVoeux  Charger la liste des voeux de létudiant
	 * 
	 * @param String : ine de l'étudiant
	 * @return Voeu[]: liste des voeux de létudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		Voeu v;
		int nbVoeuxAafficher = 0;
		boolean voeuxValider = false;

		Voeu[] lvc = new Voeu[lv.size()];
		for (int i = 0; i < lv.size(); i++) 
		{
			v = (Voeu) lv.get(i);
			lvc[i] = v;
			if (!voeuxValider && v.etatVoeu == etatvoeux.accepter) 
			{
				nbVoeuxAafficher = i + 1;
				voeuxValider = true;
			}
		}

		if(voeuxValider) 
		{
			Voeu[] lvc2 = new Voeu[nbVoeuxAafficher];
			for (int j = 0; j < nbVoeuxAafficher; j++) 
			{
				lvc2[j] = lvc[j];
			}
			return lvc2;
		}
		return lvc;

	}

	/**
	 * name - faireUnVoeu  Charger la liste des voeux de létudiant
	 * 
	 * @param String : ine de l'étudiant
	 * @param Voeu : Voeu de létudiant
	 * @param Short : ordre
	 * @return Voeu[]: liste des voeux de létudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Voeu[] faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
			
		ArrayList lv=ListeVoeuxEtudiant.get(ine);
		if(lv.size()<6)
		{
			monVoeux.numeroVoeu = ordre;
			lv.add(monVoeux);
			try {
				bddGDV.ajouterVoeux(monVoeux, ine);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return chargerVoeux(ine);
	}

	/**
	 * name - repondreAuxPropositions  Répondre aux propositions faites à l'étudiant
	 * 
	 * @param String : ine de l'étudiant
	 * @param decision : décidion de l'étudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu,
			short numeroVoeu) throws DonneesInvalides, UtilisationInterdite {
		
	
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList lv = ListeVoeuxEtudiant.get(ine);
				Voeu v = null;
				for(int i = 0;i<lv.size();i++)
				{ 
					 v = (Voeu) lv.get(i);;
					if(v.numeroVoeu==numeroVoeu)
					{
						v.dcsEtudiant = choixEtu;
						if(v.etatVoeu==etatvoeux.listeDattente||v.etatVoeu==etatvoeux.accepter)
							{
							ministere.GetRectoratEtudiant(ine);
							
							ministere.recupererRectorat(v.formationVoeu.nomRectorat).repondrePropositionVoeux(ine,v);
							}
					}	
				}
				
				
				if (choixEtu.equals(decision.NONdefinitif)){
					
					for(int i =0; i<ListeVoeuxEtudiant.get(ine).size(); i++){
						ListeVoeuxEtudiant.get(ine).get(i).dcsEtudiant=decision.NONdefinitif;
						System.out.println("sa passe ici dans la boucle"+ListeVoeuxEtudiant.get(ine).get(i));
						
						ministere.recupererRectorat(ListeVoeuxEtudiant.get(ine).get(i).formationVoeu.nomRectorat).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
						
					}
					ListeVoeuxEtudiant.remove(ine);
					try {
						bddGDV.supprimerAllVoeux(ine);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(choixEtu.equals(decision.NONmais)){
					
					for(int i=0;i<numeroVoeu-1;i++)
					{
						if(ListeVoeuxEtudiant.get(ine).get(i).etatVoeu==etatvoeux.nonValide||ListeVoeuxEtudiant.get(ine).get(i).etatVoeu==etatvoeux.refuser)
						{
							try {
								bddGDV.supprimerVoeux(ListeVoeuxEtudiant.get(ine).get(i), ine);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							ListeVoeuxEtudiant.get(ine).remove(i);
							
						}
						
					}
					
					for(int i =v.numeroVoeu-1; i<ListeVoeuxEtudiant.get(ine).size(); i++){
						
						ListeVoeuxEtudiant.get(ine).get(i).dcsEtudiant=decision.NONdefinitif;
						
						ministere.recupererRectorat(ListeVoeuxEtudiant.get(ine).get(i).formationVoeu.nomRectorat).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
						try {
							bddGDV.supprimerVoeux(ListeVoeuxEtudiant.get(ine).get(i), ine);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ListeVoeuxEtudiant.get(ine).remove(i);
						
					}
				}
				else if(choixEtu.equals(decision.OUIdefinitif)){
					for(int i =0; i<ListeVoeuxEtudiant.get(ine).size(); i++){
						if(ListeVoeuxEtudiant.get(ine).get(i).numeroVoeu !=numeroVoeu)
							{
								
							ListeVoeuxEtudiant.get(ine).get(i).dcsEtudiant=decision.NONdefinitif;
							ministere.recupererRectorat(ListeVoeuxEtudiant.get(ine).get(i).formationVoeu.nomRectorat).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
							
							try {
								bddGDV.supprimerVoeux(ListeVoeuxEtudiant.get(ine).get(i), ine);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							ListeVoeuxEtudiant.get(ine).remove(i);
							
							}						
					}
				}
				else{
					
					for(int i=0;i<numeroVoeu-1;i++)
					{
						if(ListeVoeuxEtudiant.get(ine).get(i).etatVoeu==etatvoeux.nonValide||ListeVoeuxEtudiant.get(ine).get(i).etatVoeu==etatvoeux.refuser)
						{
							try {
							bddGDV.supprimerVoeux(ListeVoeuxEtudiant.get(ine).get(i), ine);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							ListeVoeuxEtudiant.get(ine).remove(i);
						}
					}
					
                      for(int i =v.numeroVoeu; i<ListeVoeuxEtudiant.get(ine).size(); i++){
						
						ListeVoeuxEtudiant.get(ine).get(i).dcsEtudiant=decision.NONdefinitif;
						ministere.recupererRectorat(ListeVoeuxEtudiant.get(ine).get(i).formationVoeu.nomRectorat).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
						try {
							bddGDV.supprimerVoeux(ListeVoeuxEtudiant.get(ine).get(i), ine);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ListeVoeuxEtudiant.get(ine).remove(i);
						
					}
					
					
				}
				if(ListeVoeuxEtudiant.containsKey(ine))
				{
					
				ListeEtudiant.get(ine).majEtatVoeux(chargerVoeux(ine));
				
				}
				else{
					ListeEtudiant.get(ine).notifier("vous navez plus de voeux");
				}
	}
	

	/**
	 * name - modifierVoeu  Modifier l'ordre d'un voeu
	 * 
	 * @param String : ine de l'étudiant
	 * @param short : numéro du voeu
	 * @param short : nouveau numéro de voeu
	 * @return Voeu[] : modifier le voeux
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
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
				if(ordre == 1)//On monte le voeu
				{
					vb = (Voeu) lv.get(i-1);
					tempNumero = vb.numeroVoeu;
					try {
						bddGDV.ChangerOrdreVoeux(vb.numeroVoeu, ine, va.numeroVoeu);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					vb.numeroVoeu = va.numeroVoeu;
					va.numeroVoeu = tempNumero;
				}
				else//On déscend le voeu
				{
					vb = (Voeu) lv.get(i+1);
					tempNumero = va.numeroVoeu;
					try {
						bddGDV.ChangerOrdreVoeux(va.numeroVoeu, ine, vb.numeroVoeu);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	

	/**
	 * name - supprimerVoeux  Suppréssion d'un voeux
	 * 
	 * @param String : ine de l'étudiant
	 * @param short : numéro du voeu
	 * @return Voeu[] : modifier le voeux
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
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
				try {
					bddGDV.supprimerVoeux(v, ine);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				v.numeroVoeu = 0;
			}
			else if(v.numeroVoeu>numeroVoeu)
			{
				try {
					bddGDV.ChangerOrdreVoeux(v.numeroVoeu, ine, (short) (v.numeroVoeu-1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				v.numeroVoeu--;
			}
		}
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==0)
			{
				lv.remove(v);
				
			}
		}
		
		return chargerVoeux(ine);
	}

	/**
	 * name - transmettreDecisionCandidatureRectorat  Appeller par le rectorat pour transmetre les résultats aux étudiants
	 * 
	 * @param String : ine de l'étudiant
	 * @param Voeu : le voeu réponse
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
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
				try {
					lv.set(i, Reponse);
					bddGDV.modifierEtatVoeux(Reponse, ine);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(ListeVoeuxEtudiant.containsKey(ine))
		{
			if (ListeEtudiant.containsKey(ine))
				ListeEtudiant.get(ine).majEtatVoeux(chargerVoeux(ine));
			
		}
		else{
			ListeEtudiant.get(ine).notifier("vous navez plus de voeux");
		}
	}
	
	/**
	 * name - possedeVoeux  Savoir si un étudiant possède des voeux
	 * 
	 * @param String : ine de l'étudiant
	 * @return boolean
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
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

	/**
	 * name - lancementVague  Lancement des différentes vagues, étape de postLicence
	 * 
	 * @param Short : phase à éxécuter
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
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
					
					//System.out.println("rectorat"+ministere.GetRectoratEtudiant(ine).nomRectorat());
					ministere.GetRectoratEtudiant(ine).envoyerListeVoeuxGDV(tabVoeu, et);
					
					if(ListeEtudiant.containsKey(ine))
						ListeEtudiant.get(ine).lancementVague((short) 1);
					
				} catch (DonneesInvalides e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if(numero == 2)//période 2
		{
			ministere.deliberationJury();
		}
		else if(numero==3)
		{
			
			
			ministere.deliberationJuryFinal();
		}
	}
	
	/**
	 * name - deconnexion déconnexion de l'étudiant
	 * 
	 * @param String : ine de l'étudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void deconnexion(String ine) {
		// TODO Auto-generated method stub
		ListeEtudiant.remove(ine);
	}

}

