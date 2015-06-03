package devON;

import generated.DonneesInvalides;
import generated.UniversitePOA;
import generated.Voeu;
import generated.dossierEtudiant;

import java.util.ArrayList;
import java.util.Hashtable;

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

Hashtable<String, ArrayList<Voeu>> ListeCandidatureParFormation;



/**************************Constructeur********************************/
public UniversiteIMPL(String nomUniv, String ville, String academie, Hashtable<String,dossierEtudiant> dossierEtudiant) {
	super();
	NomUniv = nomUniv;
	Ville = ville;
	Academie = academie;
	
	DossierEtudiant=dossierEtudiant;
	ListeVoeux=new Hashtable<String,Hashtable<String,Voeu>>();
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<Voeu>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
}

public UniversiteIMPL() {
	super();

	DossierEtudiant=new Hashtable<String,dossierEtudiant>();
	ListeVoeux=new Hashtable<String,Hashtable<String,Voeu>>();
	
	ListeCandidatureParFormation=new Hashtable<String,ArrayList<Voeu>>();
	DossierCandidatureEtudiant=new Hashtable<String,dossierEtudiant>();
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
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(voeu);//ta un truck a faire pour que sa marche(initialis� arrayliste)
		
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
		
		ListeCandidatureParFormation.get(voeu.formationVoeu.NomFormation).add(voeu);//ta un truck a faire pour que sa marche(initialis� arrayliste)
		
		
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
		
	}

	

}
