package classeIMPL;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesProfilsHelper;
import generated.Ministère;
import generated.MinistèreHelper;
import generated.Rectorat;
import generated.Resultat;
import generated.Universite;
import generated.UniversiteHelper;
import generated.UniversitePOA;
import generated.Voeu;
import generated.decision;
import generated.dossierEtudiant;
import generated.etatvoeux;

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

import outils.NamingServiceTool;
import outils.ValueComparator;

public class UniversiteIMPL extends UniversitePOA {
String NomUniv;
String Ville;
String nomRectorat;
Rectorat recto;
Ministère ministere;
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
	
	 ministere= MinistèreHelper.narrow(
			NamingServiceTool.getReferenceIntoNS("Ministere"));
	 
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<String>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
	recto=ministere.rectoratRattacherUniv(nomAcad);
	recto.inscriptionUniv(UniversiteHelper.narrow(rootPOA.servant_to_reference(this)),nomUniv);
	
	
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
/**************************Généré*************************************/

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
		 * Cas des candidatures pour les élèves de l'établissement
		 * on regarde si il on deja postuler dans cette universitée==> ListeVoeux.containsKey(ine)
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
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(ine);//ta un truck a faire pour que sa marche(initialisé arrayliste)
		
	}

	@Override
	public void envoyerCandidatureD(dossierEtudiant dossierEtu, String ine,
			Voeu voeu) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		//ou sinon on appel la fonction juste en haut qui fait la meme chose
		//seule probleme je sais pas si sa va le considéré comme un service
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
	
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(ine);//ta un truck a faire pour que sa marche(initialisé arrayliste)
		
		
		//seule truck en plus que la fonction d'en haut..stoquer le dossier de létudiant
		DossierCandidatureEtudiant.put(ine,dossierEtu);
	}

	@Override
	public dossierEtudiant madDossier(String ine) {
		// TODO Auto-generated method stub
		return DossierCandidatureEtudiant.get(ine);
	}

	@Override
	public void repondrePropositionvoeux(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		if (voeu.dcsEtudiant.equals(decision.NONdefinitif)||voeu.dcsEtudiant.equals(decision.NONmais)){
			ListeAdmiParFormation.get(voeu.formationVoeu.NomFormation).remove(ine);
		};		
		
	}
	
	@Override
	public void deliberationJury()  {
		// TODO Auto-generated method stub
		//le comparateur permet de trier par valeur et non par clé
	    HashMap<String,Double> map = new HashMap<String,Double>();
	    ValueComparator comparateur =  new ValueComparator(map);	    
	    
		TreeMap<String,Double> TreeMapList = new TreeMap<String,Double>(comparateur);
		ArrayList<String> ineAttente = new ArrayList<String>();
		//Va prendre les ligne de la treemap
		Hashtable <String, Double>ListeCandidatAdmis = new Hashtable <String, Double>();
		Voeu voeuEtu=null;
		Double Moyenne = (double) 0;
		int nb;
		String nomFormationCourante;
		//Récupere la liste des formations
		Enumeration ListeFormation  = ListeCandidatureParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			nomFormationCourante = (String) ListeFormation.nextElement();
			System.out.println("nom formation"+nomFormationCourante);
			//récupère la liste des ine des étudiants candidats à cette formation
			ArrayList<String> ListeCandidature = ListeCandidatureParFormation.get(nomFormationCourante);
			for(int i=0 ; i < ListeCandidature.size() ; i++){
				//Récupère le dossier de l'étudiant
				dossierEtudiant DossEtu = DossierCandidatureEtudiant.get(ListeCandidature.get(i));
							
				//parcours les résultats
				for (nb = 0; nb <DossEtu.listnotes.length;nb++){
					Resultat resultat = DossEtu.listnotes[nb];
					Moyenne = Moyenne + resultat.moyenne;
				}
				//Calcul de la moyenne de l'étudiant
				Moyenne = Moyenne / nb;
				map.put(ListeCandidature.get(i), Moyenne);
				
			}
			TreeMapList.putAll(map);
			System.out.println("taille treemap" +TreeMapList.size());
		
			Formation formation = ListeDesFormations.get(nomFormationCourante);		
			
			//Vérifier le nombre des candidatures par rapport au quota de la formation
			if (formation.quota >= TreeMapList.size()){
				System.out.println("quota" +formation.quota);
				System.out.println("taille treemap" +TreeMapList.size());
				ListeCandidatAdmis.putAll(TreeMapList);
				ListeAdmiParFormation.put(formation.NomFormation, ListeCandidatAdmis);
				

			}
			else{
				System.out.println("quota" +formation.quota);
				System.out.println("taille treemap" +TreeMapList.size());
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
				
				 ListeDattente.put(formation.NomFormation, ineAttente);
								
			}
		
			
			//Maj etatVoeu etudiant admis
			// récupère le voeu de l'étudiant pour cette formation;			
			Hashtable<String,Double> ListeAdmis = ListeAdmiParFormation.get(nomFormationCourante);
			Enumeration ineAdmis = ListeAdmis.keys();
			while(ineAdmis.hasMoreElements()){
				String unAdmis =(String) ineAdmis.nextElement(); 
				voeuEtu = ListeVoeux.get(unAdmis).get(nomFormationCourante);
				voeuEtu.etatVoeu = etatvoeux.accepter;
				/*if (DossierEtudiant.containsKey(unAdmis)){
					try {
						recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(unAdmis).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					 {
						recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(unAdmis).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
					
			}
			//Maj etatVoeu etudiant listeAttente
			for(int i=0; i<ineAttente.size();i++){
				voeuEtu = ListeVoeux.get(ineAttente.get(i)).get(nomFormationCourante);
				voeuEtu.etatVoeu = etatvoeux.listeDattente;
				/*if (DossierEtudiant.containsKey(ineAttente.get(i))){
					try {
						recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ineAttente.get(i)).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					try {
						recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ineAdmis.nextElement()).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				
			}
			
		}
		
		
	}

	

	@Override
	public boolean estEtudiant(String ine) {
		// TODO Auto-generated method stub
		return DossierEtudiant.containsKey(ine);
	}


	public void deliberationFinal() {
		// TODO Auto-generated method stub
		//Récupere la liste des formations
		short nbAdmis;
		short quota;
		short nbdispo;
		Voeu voeuEtu = null;
		Enumeration ListeFormation  = ListeAdmiParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			String nomFormationCourante = (String) ListeFormation.nextElement();
			nbAdmis =(short) ListeAdmiParFormation.get(nomFormationCourante).size(); 
		    quota = ListeDesFormations.get(nomFormationCourante).quota;
			if (nbAdmis<quota){
				nbdispo = (short) (quota - nbAdmis);
				for(int i =0; i<nbdispo; i++){ 
					voeuEtu = ListeVoeux.get(ListeDattente.get(nomFormationCourante).get(i)).get(nomFormationCourante);
					//envoyer et mettre à jour le voeu seulement
					voeuEtu.etatVoeu = etatvoeux.accepter;
					/*if (DossierEtudiant.containsKey(ListeDattente.get(nomFormationCourante))){
						try {
							recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ListeDattente.get(nomFormationCourante)).etu, voeuEtu);
						} catch (DonneesInvalides e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						try {
							recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ListeDattente.get(nomFormationCourante)).etu, voeuEtu);
						} catch (DonneesInvalides e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}*/
				}
		}
			
		}
		
	}


/*****************fonction ajouter*******************************/


public void ajouterEtudiant(String ine, dossierEtudiant dossier)
{
		
	DossierEtudiant.put(ine, dossier);
	
}

public void ajouterFormation(Formation fr,ArrayList<String> frRequises)
{
	ArrayList<String>ListEtu = new ArrayList <String>();
	
	ListeCandidatureParFormation.put(fr.NomFormation,ListEtu);
	ListeDesFormations.put(fr.NomFormation, fr);
	//recto.
	
}

public void affichage(){
	System.out.println("Liste des etudiants admis : "+ListeAdmiParFormation);
	System.out.println("Liste des etudiants en attente : "+ListeDattente);
}
	

}
