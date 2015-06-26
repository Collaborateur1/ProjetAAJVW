package classeIMPL;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesProfilsHelper;
import generated.Minist�re;
import generated.Minist�reHelper;
import generated.Rectorat;
import generated.Resultat;
import generated.Universite;
import generated.UniversiteHelper;
import generated.UniversitePOA;
import generated.Voeu;
import generated.decision;
import generated.dossierEtudiant;
import generated.etatvoeux;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.lang.model.util.Elements;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.openorb.compiler.parser.Symbole;

import Databases.BDDEtudiantHelper;
import Databases.BddHelperFormation;
import Databases.DBGestionDesProfils;
import Databases.DBUniversite;
import outils.NamingServiceTool;
import outils.ValueComparator;

public class UniversiteIMPL extends UniversitePOA {
String NomUniv;
String Ville;
String nomRectorat;
Rectorat recto;
Minist�re ministere;
Hashtable<String,dossierEtudiant> DossierEtudiant;
Hashtable<String,dossierEtudiant> DossierCandidatureEtudiant;
//Pour chaque Ine on a une hastable qui contien la liste des voeux 
//qui sont identifier par le nom de la formation ..
//concretement..hashtable<INE,Liste<NomFormation,Voeu>>
Hashtable<String,Hashtable<String,Voeu>> ListeVoeux;


Hashtable<String,Hashtable<String,Double>> ListeAdmiParFormation;

// formation, liste INE
Hashtable<String, ArrayList<String>> ListeCandidatureParFormation;
Hashtable <String, Resultat[] > ListeResultEtu;
Hashtable <String, Formation>ListeDesFormations;
Hashtable <String,ArrayList<String>> ListeDattente;

DBUniversite bddUNIV;;


/**************************Constructeur********************************/

public UniversiteIMPL(String nomUniv, String nomAcad,org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
	super();
	
	ListeDesFormations = new Hashtable<String,Formation>();
	ListeAdmiParFormation = new Hashtable<String, Hashtable<String,Double>>();
	ListeDattente = new Hashtable<String, ArrayList<String>>();
	DossierEtudiant=new Hashtable<String,dossierEtudiant>();
	ListeVoeux=new Hashtable<String,Hashtable<String,Voeu>>();
	this.NomUniv=nomUniv;
	org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	rootPOA.the_POAManager().activate();
	
	 ministere= Minist�reHelper.narrow(
			NamingServiceTool.getReferenceIntoNS("Ministere"));
	 
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<String>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
	recto=ministere.rectoratRattacherUniv(nomAcad);
	recto.inscriptionUniv(UniversiteHelper.narrow(rootPOA.servant_to_reference(this)),nomUniv);
	bddUNIV = new DBUniversite(nomUniv);
	ArrayList<dossierEtudiant> le = null;
	ArrayList<BddHelperFormation> bdhf = null;
	try {
		le = bddUNIV.ChargerEtudiant();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	dossierEtudiant de = null;
	for(int i =0;i<le.size();i++)
	{
		de = le.get(i);
		this.ajouterEtudiant(de.etu.ineEtudiant, de);
	}
	
	
	try {
		System.out.println("formation recup�r�");
		bdhf = bddUNIV.getFormation();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	BddHelperFormation b = null;
	for(int i = 0;i<bdhf.size();i++)
	{
		b = bdhf.get(i);
		
		this.ajouterFormation(b.getFr(), bddUNIV.chargerPrerequis(b.getFr().NomFormation));
	}
}


@Override
public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
	// TODO Auto-generated method stub
	if (DossierEtudiant.containsKey(ine))
	{
		return DossierEtudiant.get(ine).etu;
	}
	throw new DonneesInvalides("ine inexistant");
	
	
}
/**************************G�n�r�*************************************/

	@Override
	public String nomUniversite() {
		// TODO Auto-generated method stub
		return NomUniv;
	}

	@Override
	public String villeUniversite() {
		// TODO Auto-generated method stub
		return Ville;
	}

	@Override
	public String academieUniversite() {
		// TODO Auto-generated method stub
		return nomRectorat;
	}

	

	@Override
	public void envoyerCandidature(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		/*
		 * Cas des candidatures pour les �l�ves de l'�tablissement
		 * on regarde si il on deja postuler dans cette universit�e==> ListeVoeux.containsKey(ine)
		 * si oui on rajoute dans la hashtable qui contien la liste des voeux par ine
		 * sinon on rajoute un nouvelle ine dans la hashtable avec un couple <nomformation,voeu>
		 */
		if (ListeVoeux.containsKey(ine))
		{
			ListeVoeux.get(ine).put(voeu.formationVoeu.NomFormation, voeu);
			
			
		}
		else
		{
			Hashtable<String,Voeu> temphash=new Hashtable<String,Voeu>();
			temphash.put(voeu.formationVoeu.NomFormation, voeu);
			ListeVoeux.put(ine,temphash);
	
			
		}
		//un hashtable avec la liste des candidature par formation
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(ine);//ta un truck a faire pour que sa marche(initialis� arrayliste)
		
	}

	@Override
	public void envoyerCandidatureD(dossierEtudiant dossierEtu, String ine,
			Voeu voeu) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		//ou sinon on appel la fonction juste en haut qui fait la meme chose
		//seule probleme je sais pas si sa va le consid�r� comme un service
		//en gros une classe qui utilise ses propre service..c'est louche
		
		if (ListeVoeux.containsKey(ine))
		{
			ListeVoeux.get(ine).put(voeu.formationVoeu.NomFormation, voeu);
			
			
		}
		else
		{
			Hashtable<String,Voeu> temphash=new Hashtable<String,Voeu>();
			temphash.put(voeu.formationVoeu.NomFormation, voeu);
			ListeVoeux.put(ine,temphash);
	
			
		}
	
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(ine);//ta un truck a faire pour que sa marche(initialis� arrayliste)
		
		
		//seule truck en plus que la fonction d'en haut..stoquer le dossier de l�tudiant
		DossierCandidatureEtudiant.put(ine,dossierEtu);
	}

	@Override
	public dossierEtudiant madDossier(String ine) {
		// TODO Auto-generated method stub
		
		return DossierEtudiant.get(ine);
	}

	@Override
	public void repondrePropositionvoeux(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	
		if (voeu.dcsEtudiant==decision.NONdefinitif||voeu.dcsEtudiant==decision.NONmais){
			
			if (ListeAdmiParFormation.get(voeu.formationVoeu.NomFormation).containsKey(ine)){
		System.out.println("Suppr�sion du Voeu"+voeu.formationVoeu.NomFormation+" ave la d�cidion"+voeu.dcsEtudiant);
				ListeAdmiParFormation.get(voeu.formationVoeu.NomFormation).remove(ine);
			}
			else if(ListeDattente.containsKey(voeu.formationVoeu.NomFormation)){
				
				if(ListeDattente.get(voeu.formationVoeu.NomFormation).contains(ine)){
			System.out.println("Suppr�sion du Voeu dans liste attente"+voeu.formationVoeu.NomFormation+" ave la d�cidion"+voeu.dcsEtudiant);
				ListeDattente.get(voeu.formationVoeu.NomFormation).remove(ine);
			   }
			}
		}
		System.out.println("nouvelle liste dadmis "+ListeAdmiParFormation.toString()+"\n\n");
		System.out.println("nouvelle liste dattente "+ListeDattente.toString()+"\n\n");
		
	}
	
	@Override
	public void deliberationJury()  {
	
		// TODO Auto-generated method stub
		//le comparateur permet de trier par valeur et non par cl�
	    HashMap<String,Double> map = new HashMap<String,Double>();
	    ValueComparator comparateur =  new ValueComparator(map);	    
	    
		TreeMap<String,Double> TreeMapList;
		ArrayList<String> ineAttente = new ArrayList<String>();
		//Va prendre les ligne de la treemap
		Hashtable <String, Double>ListeCandidatAdmis = new Hashtable <String, Double>();
		Voeu voeuEtu=null;
		Double Moyenne = (double) 0;
		int nb;
		String nomFormationCourante;
		dossierEtudiant DossEtu;
		//R�cupere la liste des formations
		Enumeration ListeFormation  = ListeCandidatureParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			TreeMapList = new TreeMap<String,Double>(comparateur);
			map.clear();
			nomFormationCourante = (String) ListeFormation.nextElement();
		if(ListeCandidatureParFormation.get(nomFormationCourante).size()!=0)
		 {	
			System.out.println("nom formation courante***************"+nomFormationCourante);
			//r�cup�re la liste des ine des �tudiants candidats � cette formation
			ArrayList<String> ListeCandidature = ListeCandidatureParFormation.get(nomFormationCourante);
			System.out.println("nombre candidat pour formationcourante="+ListeCandidature.size());
			for(int i=0 ; i < ListeCandidature.size() ; i++){
				System.out.println("candidat "+ListeCandidature.get(i));
				//R�cup�re le dossier de l'�tudiant
				//On v�rifie si l'etudiant postule dans son universite
				if (DossierCandidatureEtudiant.containsKey(ListeCandidature.get(i)))
					DossEtu = DossierCandidatureEtudiant.get(ListeCandidature.get(i));
				else 
					DossEtu = DossierEtudiant.get(ListeCandidature.get(i));
				
						
				//parcours les r�sultats
				for (nb = 0; nb <DossEtu.listnotes.length;nb++){
					System.out.println("doss etu"+DossEtu.listnotes.length);
					Resultat resultat = DossEtu.listnotes[nb];
					Moyenne = Moyenne + resultat.moyenne;
				}
				//Calcul de la moyenne de l'�tudiant
				Moyenne = Moyenne / nb;
				map.put(ListeCandidature.get(i), Moyenne);
				
			}
			TreeMapList.putAll(map);
			
		
			Formation formation = ListeDesFormations.get(nomFormationCourante);		
			
			//V�rifier le nombre des candidatures par rapport au quota de la formation
			System.out.println("quota pour la formation "+nomFormationCourante+" = "+formation.quota+" taille trimap"+TreeMapList.size());
			System.out.println("affichage de la trimap "+TreeMapList.toString());
			
			if (formation.quota >= TreeMapList.size()){
				
				
				ListeCandidatAdmis.putAll(TreeMapList);
				
				ListeAdmiParFormation.put(formation.NomFormation, ListeCandidatAdmis);
				TreeMapList=new TreeMap<String, Double>();
				ListeCandidatAdmis=new Hashtable<String, Double>();

			}
			else{
			
				
				Iterator<Entry<String, Double>> it = TreeMapList.entrySet().iterator();
				int nbadmis =0;
				while(it.hasNext()){
					Entry<String, Double>itCourant = it.next();
					if (nbadmis < formation.quota) {
						 ListeCandidatAdmis.put(itCourant.getKey(),itCourant.getValue());
						 ListeAdmiParFormation.put(formation.NomFormation,ListeCandidatAdmis);
						 nbadmis++;
					 }
					 else{
						 ineAttente.add(itCourant.getKey());
						 System.out.println("ine attente"+itCourant.getKey() );
						 
						 
					 }
				}
				TreeMapList=new TreeMap<String, Double>();
				 ListeCandidatAdmis= new Hashtable<String, Double>();
				 
				 ListeDattente.put(formation.NomFormation, ineAttente);
				 System.out.println("nb attente"+ListeDattente.size());
								
			}
		
			System.out.println("juskici ca va");
			//Maj etatVoeu etudiant admis
			// r�cup�re le voeu de l'�tudiant pour cette formation;		
			
			Hashtable<String,Double> ListeAdmis = ListeAdmiParFormation.get(nomFormationCourante);
			System.out.println("chargement hastable ok");
			Enumeration ineAdmis = ListeAdmis.keys();
			while(ineAdmis.hasMoreElements()){
				String unAdmis =(String) ineAdmis.nextElement(); 
				System.out.println("String admi ok "+unAdmis);
				System.out.println("Affichage Liste des Voeux "+ListeVoeux.toString());
				
				voeuEtu = ListeVoeux.get(unAdmis).get(nomFormationCourante);
				System.out.println("Beug ir "+nomFormationCourante);
				voeuEtu.etatVoeu = etatvoeux.accepter;
				System.out.println("Sinon ici");
				DossierEtudiant.containsKey(unAdmis);
				System.out.println("je sais pas..");
				if (DossierEtudiant.containsKey(unAdmis)){
					try {
						System.out.println("Le dossier etudiant contien un admi la c'est pas normal");
						recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(unAdmis).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					try{
						System.out.println("la c'est normal");
						recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(unAdmis).etu, voeuEtu);
						System.out.println("mais sa beug");
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			}
			System.out.println("la on passe dans la liste dattente");
			//Maj etatVoeu etudiant listeAttente
			if (ListeDattente.containsKey(nomFormationCourante)){
				for(int i=0; i<ListeDattente.get(nomFormationCourante).size();i++){
					System.out.println("ine liste d'attente: "+ListeDattente.get(nomFormationCourante).get(i));
					voeuEtu = ListeVoeux.get(ListeDattente.get(nomFormationCourante).get(i)).get(nomFormationCourante);
					voeuEtu.etatVoeu = etatvoeux.listeDattente;
					if (DossierEtudiant.containsKey(ineAttente.get(i))){
						try {
							recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ineAttente.get(i)).etu, voeuEtu);
						} catch (DonneesInvalides e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						try {
							recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ineAttente.get(i)).etu, voeuEtu);
						} catch (DonneesInvalides e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
			
		  }
		}
		
		System.out.println("\n\nListe dattente periode 1"+ListeDattente.toString());
		System.out.println("\n\nList admi periode1 "+ ListeAdmiParFormation);
	}

	

	@Override
	public boolean estEtudiant(String ine) {
		// TODO Auto-generated method stub
		return DossierEtudiant.containsKey(ine);
	}


	public void deliberationFinal() {
		// TODO Auto-generated method stub
		//R�cupere la liste des formations
		short nbAdmis;
		short quota;
		short nbdispo;
		Voeu voeuEtu = null;
		Enumeration <String> ListeFormation  = ListeAdmiParFormation.keys();
	
		while(ListeFormation.hasMoreElements()){
			
			String nomFormationCourante = ListeFormation.nextElement();
			nbAdmis =(short) ListeAdmiParFormation.get(nomFormationCourante).size(); 
		    quota = ListeDesFormations.get(nomFormationCourante).quota;
		    
			if (nbAdmis<quota){
				nbdispo = (short) (quota - nbAdmis);
				for(int i =0; i<nbdispo; i++){ 
					
					System.out.println("test"+ListeDattente.size()+ NomUniv);
					if (ListeDattente.containsKey(nomFormationCourante)){
						if(ListeDattente.get(nomFormationCourante).size()> 0){
							
							System.out.println("test"+ListeDattente.size());
							voeuEtu = ListeVoeux.get(ListeDattente.get(nomFormationCourante).get(i)).get(nomFormationCourante);
							System.out.println("le voeu"+ voeuEtu);
							//envoyer et mettre � jour le voeu seulement
							voeuEtu.etatVoeu = etatvoeux.accepter;
							if (DossierEtudiant.containsKey(ListeDattente.get(nomFormationCourante).get(i))){
								try {
									recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ListeDattente.get(nomFormationCourante).get(i)).etu, voeuEtu);
									ListeAdmiParFormation.get(nomFormationCourante).put(ListeDattente.get(nomFormationCourante).get(i),10.0);
									ListeDattente.get(nomFormationCourante).remove(i);
								} catch (DonneesInvalides e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else{
								try {
									recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ListeDattente.get(nomFormationCourante).get(i)).etu, voeuEtu);
									ListeAdmiParFormation.get(nomFormationCourante).put(ListeDattente.get(nomFormationCourante).get(i),10.0);
									ListeDattente.get(nomFormationCourante).remove(i);
								} catch (DonneesInvalides e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}
					}

				}
			}
			else if (nbAdmis ==quota && ListeDattente.containsKey(nomFormationCourante) ){ 
				if(ListeDattente.get(nomFormationCourante).size()>0){
					
					for(int i =0; i<ListeDattente.get(nomFormationCourante).size();i++){
						
					
						
						voeuEtu = ListeVoeux.get(ListeDattente.get(nomFormationCourante).get(i)).get(nomFormationCourante);
						voeuEtu.etatVoeu = etatvoeux.refuser;
					
						if (DossierEtudiant.containsKey(ListeDattente.get(nomFormationCourante).get(i))){
							try {
								
								recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ListeDattente.get(nomFormationCourante).get(i)).etu, voeuEtu);
								} catch (DonneesInvalides e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else{
							try {
								
								recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ListeDattente.get(nomFormationCourante).get(i)).etu, voeuEtu);								
							} catch (DonneesInvalides e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}
				
			}
			
		}
		
	}


/*****************fonction ajouter*******************************/


public void ajouterEtudiant(String ine, dossierEtudiant dossier)
{
		
	DossierEtudiant.put(ine, dossier);
	ministere.EnregistrerRectoratEtudiant(ine, recto);
}

public void ajouterFormation(Formation fr,String[] frRequises)
{
	ArrayList<String>ListEtu = new ArrayList <String>();
	ListeCandidatureParFormation.put(fr.NomFormation,ListEtu);
	ListeDesFormations.put(fr.NomFormation, fr);
	recto.ajoutPrerequis(fr, frRequises);
}

public void affichage(){
	System.out.println("Liste des etudiants admis : "+ListeAdmiParFormation);
	System.out.println("Liste des etudiants en attente : "+ListeDattente);
}
	

}
