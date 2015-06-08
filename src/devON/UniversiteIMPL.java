package devON;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.Resultat;
import generated.UniversitePOA;
import generated.Voeu;
import generated.dossierEtudiant;

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

public class UniversiteIMPL extends UniversitePOA {
String NomUniv;
String Ville;
String Academie;

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
public UniversiteIMPL(String nomUniv, String ville, String academie, Hashtable<String,dossierEtudiant> dossierEtudiant) {
	super();
	NomUniv = nomUniv;
	Ville = ville;
	Academie = academie;
	
	DossierEtudiant=dossierEtudiant;
	ListeVoeux=new Hashtable<String,Hashtable<String,Voeu>>();
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<String>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
}

public UniversiteIMPL() {
	super();

	DossierEtudiant=new Hashtable<String,dossierEtudiant>();
	ListeVoeux=new Hashtable<String,Hashtable<String,Voeu>>();
	
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<String>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
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
		return Academie;
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
			temphash.put(ine, voeu);
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
			temphash.put(ine, voeu);
			ListeVoeux.put(ine,temphash);
	
			
		}
		
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(ine);//ta un truck a faire pour que sa marche(initialis� arrayliste)
		
		
		//seule truck en plus que la fonction d'en haut..stoquer le dossier de l�tudiant
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
		
		
	}
	
	@Override
	public void deliberationJury() {
		// TODO Auto-generated method stub
	    HashMap<String,Double> map = new HashMap<String,Double>();
	    ValueComparator comparateur =  new ValueComparator(map);	    
		TreeMap<String,Double> ListeCandidatAdmis = new TreeMap<String,Double>(comparateur);
		ArrayList <String> ineAttente = null;
		Voeu voeuEtu;
		Double Moyenne = null;
		int nb;
		//R�cupere la liste des formations
		Enumeration ListeFormation  = ListeCandidatureParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			//r�cup�re la liste des ine des �tudiants candidats � cette formation
			ArrayList<String> ListeCandidature = ListeCandidatureParFormation.get(ListeFormation.nextElement());
			for(int i=0 ; i <= ListeCandidature.size() ; i++){
				//R�cup�re le dossier de l'�tudiant
				dossierEtudiant DossEtu = DossierCandidatureEtudiant.get(ListeCandidature.get(i));
							
				//parcours les r�sultats
				for (nb = 0; nb <=DossEtu.listnotes.length;nb++){
					Resultat resultat = DossEtu.listnotes[nb];
					Moyenne = Moyenne + resultat.moyenne;
				}
				Moyenne = Moyenne / nb;
				map.put(ListeCandidature.get(i), Moyenne);
				ListeCandidatAdmis.putAll(map);
			}
			
		
			Formation formation = ListeDesFormations.get(ListeFormation.nextElement());
			
			Hashtable <String, Double>TreeMapList = null;
			if (formation.quota >= ListeCandidatAdmis.size()){
				TreeMapList.putAll(ListeCandidatAdmis);
				ListeAdmiParFormation.put(formation.NomFormation, TreeMapList);
				

			}
			else{
				for(int i =0; i<= ListeCandidatAdmis.size();i++){	
					 for (Entry<String, Double> entry:ListeCandidatAdmis.entrySet()) {
						 if (i <= formation.quota) {

							 TreeMapList.put(entry.getKey(), entry.getValue());
							 ListeAdmiParFormation.put(formation.NomFormation,TreeMapList);
						 }
						 else{
							 
							 ineAttente.add(entry.getKey());
						 }				
					 }
				}
				ListeDattente.put(formation.NomFormation, ineAttente);				
			}
			//Maj etatVoeu		
			// r�cup�re le voeu de l'�tudiant pour cette formation;
			Enumeration ListeDesAdmis = ListeAdmiParFormation.elements();
			//for (int i = 0; i<=ListeDesAdmis.size();i++){
				//voeuEtu = ListeVoeux.get(ListeFormation.nextElement()).get(ListeDesAdmis.);
			//}
		}
		
		
	}

	

	@Override
	public boolean estEtudiant(String ine) {
		// TODO Auto-generated method stub
		return DossierEtudiant.containsKey(ine);
	}



	

}
