package devON;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Resultat;
import generated.UniversitePOA;
import generated.Voeu;
import generated.dossierEtudiant;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
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


Hashtable<String,Hashtable<String,Double>> ListeAdmiParForamtion;

// formation, liste INE
Hashtable<String, ArrayList<String>> ListeCandidatureParFormation;
Hashtable <String, Resultat[] > ListeResultEtu;



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
		return Academie;
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
			temphash.put(ine, voeu);
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
			temphash.put(ine, voeu);
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
		
		
	}
	
	@Override
	public void deliberationJury() {
		// TODO Auto-generated method stub
		TreeMap<String,Double> ListeCandidatAdmis;
		Double Moyenne = null;
		int nb;
		//Récupere la liste des formations
		Enumeration ListeFormation  = ListeCandidatureParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			//récupère la liste des ine des étudiants candidats à cette formation
			ArrayList ListeCandidature = ListeCandidatureParFormation.get(ListeFormation.nextElement());
			for(int i=0 ; i <= ListeCandidature.size() ; i++){
				//Récupère le dossier de l'étudiant
				dossierEtudiant DossEtu = DossierCandidatureEtudiant.get(ListeCandidature.get(i));
				// ListeResultEtu.put(DossEtu.etu.ineEtudiant,DossEtu.listnotes);
				
				//parcours les résultats
				for (nb = 0; nb <=DossEtu.listnotes.length;nb++){
					Resultat resultat = DossEtu.listnotes[nb];
					Moyenne = Moyenne + resultat.moyenne;
				}
				Moyenne = Moyenne / nb;
			//	ListeCandidatAdmis.put(ListeCandidature.get(i), Moyenne);
			}
			
			
					
		}
	
		
		
	}

	@Override
	public boolean estEtudiant(String ine) {
		// TODO Auto-generated method stub
		return DossierEtudiant.containsKey(ine);
	}



	

}
