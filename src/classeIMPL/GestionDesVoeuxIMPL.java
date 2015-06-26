
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
import generated.Minist�re;
import generated.Minist�reHelper;
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
	Minist�re ministere;
	Formation[] listeFormation;
	DBGestionDesVoeux bddGDV;
	
	/*
	 * Constructeur
	 */
	//Initialisation des GDV
	public GestionDesVoeuxIMPL(short numServ, org.omg.CORBA.ORB orb) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides, AdapterInactive {
		
		ListeFormation = new Hashtable<String,Formation>();
		ListeEtudiant = new Hashtable<String,IEtudiant>();
		ListeVoeuxEtudiant = new Hashtable<String,ArrayList<Voeu>>();
		//On lui affecte un num�ro
		numGDV=numServ;
		//On r�cum�re le LoadBalancer (pour all� cherch� le serveur de Gestion des Profil fonctionnent en Binome avec la GDV)
		loadBalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootPOA.the_POAManager().activate();
		
        //On r�cup�re le minist�re
		ministere= Minist�reHelper.narrow(NamingServiceTool.getReferenceIntoNS("Ministere"));
		//System.out.println("Ref�rence ministere recuperee" );
		
		//On r�cup�re toutes les formations existante aupr�s du minist�re pour pouvoir permettre au Etudiant de les rechercher
		listeFormation = ministere.madDesFormationsFrance();
		//On r�cup�re la Gestion des Profil qui fonctionne en binome avec notre serveur de gestion des voeux
		gdpRattache = loadBalancer.getServProfil(numServ);
		GestionDesVoeux thisdGdv=GestionDesVoeuxHelper.narrow(rootPOA.servant_to_reference(this));
		
		//On inscrit notre GDV dans un rectorat (celui a qui elle renverra les voeux formul�s par des etudiants)
		ministere.InscriptionGDVDansRectorats(numServ, thisdGdv);
		//On inscrit notre GDV chez la GDP li�
		gdpRattache.inscriptionGestionDesVoeux(thisdGdv);
		//On cr�er une instance qui nous permettra de r�cup�r� ou �crire des informations en BDD
		bddGDV = new DBGestionDesVoeux(numGDV);
		
		try {
			//Ici on r�cup�re tous les voeux de la BDD pour initialiser notre serveur (en remplissant sa Hashtable contenant tous les voeux)
			ListeVoeuxEtudiant = bddGDV.Chargervoeu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * @name - numeroGDV()
	 * 
	 * description: le num�ro de la gdv (On retourne le num�ro de notre GDV)
	 * 
	 * @return short
	 * @author M2GroupeCorba
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public short numeroGDV() {
		return numGDV;
	}

	/**
	 * name - inscriptionIE Inscription des interfaces �tudiants (Pour notifier des �tudiants on r�cup�re les interfaces et on les stock)
	 *                            
	 * 
	 * @param String ine : Ine de l�tudiant
	 * @param IEtudiant iorEtudiant : ior de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void inscriptionIE(String ine, IEtudiant iorEtudiant) throws DonneesInvalides {
		//Si un �tudiant se connect cette m�thode est appel� et ajoute l'interface et une liste de voeux vide si c'est sa premi�re connexion
		if(!ListeEtudiant.containsKey(ine))
		{	
			ListeEtudiant.put(ine, iorEtudiant);		
		}
		if (!ListeVoeuxEtudiant.containsKey(ine)){
			ListeVoeuxEtudiant.put(ine, new ArrayList<Voeu>());
		}
	
	}

	/**
	 * name - rechercherFormation  Recherche de formation (Retourne la liste des formations recherch�s)
	 * 
	 * 
	 * @param String : mots cl� de recherche
	 * @return Formation[]: liste de formation
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Formation[] rechercherFormation(String motscles) {
		//On parcours toutes nos formations
		int taille=0;
		ArrayList<Formation> array=new ArrayList<Formation>();
		for(int i=0;i<listeFormation.length;i++)
		{
			//On regarde si le nom de la formation correspond au mot cl� de recherche
			if(listeFormation[i].NomFormation.contains(motscles))
				array.add(listeFormation[i]);
		}
		
		//On pr�pare un tableau pour le retourner en CORBA (car ArrayList non support�)
		Formation[] fr =new Formation[array.size()];
		for(int i=0;i<fr.length;i++)
		{
			fr[i]=array.get(i);
		}
		return fr;
	}

	/**
	 * name - existFormation  l'�tudiant a t'il des voeux
	 * 
	 * description : 
	 * On teste si une formation existe par rapport au mot cl� d'une recherche (cette fonction permet d'�viter les problemes li� � corba sur le fait que l'on ne peut
	 * pas renvoyer de valeur null). La m�thode est appel� avant de retourner les formations correspondant � une recherche
	 * 
	 * 
	 * @param String : ine de l'�tudiant
	 * @return boolean: existance de l�tudiant dans le SI
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public boolean existFormation(String motcle) {
		// TODO Auto-generated method stub
		for(int i=0;i<listeFormation.length;i++)
		{
			if(listeFormation[i].NomFormation.contains(motcle))
				return true;
		}
		return false;
	}
	
	/**
	 * name - chargerVoeux  Charger la liste des voeux de l�tudiant (Cette m�thode renvoie les voeux (ainsi que leur �tat) � une interface �tudiant)
	 * 
	 * @param String : ine de l'�tudiant
	 * @return Voeu[]: liste des voeux de l�tudiant
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

		//On v�rifie que les voeux renvoy� sont de type accept� ou pas encore valid�
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

		//On stock dans un tableau � renvoyer tous les voeux qui seront � afficher.
		//on retourne uniquement les premier voeux qui son valid� (car les non valid� n'ont pas besoin d'�tre affich�)
		if(voeuxValider) 
		{
			Voeu[] lvc2 = new Voeu[nbVoeuxAafficher];
			for (int j = 0; j < nbVoeuxAafficher; j++) 
			{
				lvc2[j] = lvc[j];
			}
			return lvc2;
		}
		//Si les voeux sont non valid� alors on retourne tout
		return lvc;

	}

	/**
	 * name - faireUnVoeu  Charger la liste des voeux de l�tudiant (On ajoute un voeux formul� par un �tudiant � sa liste)
	 * 
	 * @param String : ine de l'�tudiant
	 * @param Voeu : Voeu de l�tudiant
	 * @param Short : ordre
	 * @return Voeu[]: liste des voeux de l�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Voeu[] faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		//on ajoute un voeu et on assure qu'il ne d�passe pas 5		
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
		//On appel la fonction pour mettre a jour l'interface de l'�tudiant avec le nouveau voeu
		return chargerVoeux(ine);
	}

	/**
	 * name - repondreAuxPropositions  R�pondre aux propositions faites � l'�tudiant (On permet a un �tudiant de r�pondre � un voeu)
	 * 
	 * @param String : ine de l'�tudiant
	 * @param decision : d�cidion de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu, short numeroVoeu) throws DonneesInvalides, UtilisationInterdite {
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
					ministere.GetRectoratEtudiant(ine).repondrePropositionVoeux(ine,v);
				}
			}	
		}

		//On supprime tout les voeux
		if(choixEtu.equals(decision.NONdefinitif))
		{
			for(int i =0; i<ListeVoeuxEtudiant.get(ine).size(); i++){
				ListeVoeuxEtudiant.get(ine).get(i).dcsEtudiant=decision.NONdefinitif;

				ministere.GetRectoratEtudiant(ine).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));

			}
			ListeVoeuxEtudiant.remove(ine);
			try {
				bddGDV.supprimerAllVoeux(ine);
			} catch (SQLException e) {
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

				ministere.GetRectoratEtudiant(ine).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
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
					ministere.GetRectoratEtudiant(ine).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));

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
				ministere.GetRectoratEtudiant(ine).repondrePropositionVoeux(ine,ListeVoeuxEtudiant.get(ine).get(i));
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
	 * @param String : ine de l'�tudiant
	 * @param short : num�ro du voeu
	 * @param short : nouveau num�ro de voeu
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
		//La liste des voeux est retri� a chaque fin de fonction de modifier voeu
		//on consid�re donc les voeux comme tri�s
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
				else//On d�scend le voeu
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
	 * name - supprimerVoeux  Suppr�ssion d'un voeux
	 * 
	 * @param String : ine de l'�tudiant
	 * @param short : num�ro du voeu
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
			//On le supprime d'abords en BD
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
			//On remonte les autres voeu d'une position pour ceux en dessous du voeu supprim�
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
		//On suprrime ensuite celui de la liste de la classe
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==0)
			{
				lv.remove(v);
				
			}
		}
		//On met a jour l'affichage l'interface
		return chargerVoeux(ine);
	}

	/**
	 * name - transmettreDecisionCandidatureRectorat  Appeller par le rectorat pour transmetre les r�sultats aux �tudiants
	 * 
	 * @param String : ine de l'�tudiant
	 * @param Voeu : le voeu r�ponse
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@SuppressWarnings("unchecked")
	@Override
	public void transmettreDecisionCandidatureRectorat(String ine, Voeu Reponse)
			throws DonneesInvalides {
		ArrayList lv = ListeVoeuxEtudiant.get(ine);
		Voeu v;
		//On modifie l'�tat des voeux en fonction de ce qui est re�u de la premi�re vague
		for(int i=0;i<lv.size();i++)
		{
			v = (Voeu) lv.get(i);
			if(v.numeroVoeu==Reponse.numeroVoeu)
			{
				try {
					lv.set(i, Reponse);
					bddGDV.modifierEtatVoeux(Reponse, ine);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(ListeVoeuxEtudiant.containsKey(ine))
		{
			if (ListeEtudiant.containsKey(ine))//On v�rifie que l'interface est connect� pour mettre a jour l'interface sinon on ne fais rien
				ListeEtudiant.get(ine).majEtatVoeux(chargerVoeux(ine));
		}
		else{
			ListeEtudiant.get(ine).notifier("vous navez plus de voeux");
		}
	}
	
	/**
	 * name - possedeVoeux  Savoir si un �tudiant poss�de des voeux
	 * 
	 * @param String : ine de l'�tudiant
	 * @return boolean
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public boolean possedeVoeux(String ine) {
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
	 * name - lancementVague  Lancement des diff�rentes vagues, �tape de postLicence
	 * 
	 * @param Short : phase � �x�cuter
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void lancementVague(short numero) {
		//On lance les vague selon le param�tre num�ro
		if(numero == 1)//p�riode 1 (Vague 1)
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
					e1.printStackTrace();
				}
			}
			
		}
		else if(numero == 2)//p�riode 2 (Vague 2)
		{
			ministere.deliberationJury();
		}
		else if(numero==3)//p�riode 3 (Vague 3)
		{
			ministere.deliberationJuryFinal();
		}
	}
	
	/**
	 * name - deconnexion d�connexion de l'�tudiant
	 * 
	 * @param String : ine de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void deconnexion(String ine) {
		ListeEtudiant.remove(ine);
	}

}

