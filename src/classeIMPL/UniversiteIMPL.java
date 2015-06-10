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



/**************************Constructeur********************************/
public UniversiteIMPL(String nomUniv, String ville, String nomrectorat, Hashtable<String,dossierEtudiant> dossierEtudiant) {
	super();
	NomUniv = nomUniv;
	Ville = ville;
	nomRectorat = nomrectorat;
	
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
public UniversiteIMPL(String nomUniv, String nomAcad,org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
	super();

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
		if (voeu.dcsEtudiant.equals(decision.NONdefinitif)||voeu.dcsEtudiant.equals(decision.NONmais)){
			ListeAdmiParFormation.get(voeu.formationVoeu.NomFormation).remove(ine);
		};		
		
	}
	
	@Override
	public void deliberationJury()  {
		// TODO Auto-generated method stub
		//le comparateur permet de trier par valeur et non par cl�
	    HashMap<String,Double> map = new HashMap<String,Double>();
	    ValueComparator comparateur =  new ValueComparator(map);	    
	    
		TreeMap<String,Double> TreeMapList = new TreeMap<String,Double>(comparateur);
		ArrayList<String> ineAttente = null;
		//Va prendre les ligne de la treemap
		Hashtable <String, Double>ListeCandidatAdmis = null;
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
				//Calcul de la moyenne de l'�tudiant
				Moyenne = Moyenne / nb;
				map.put(ListeCandidature.get(i), Moyenne);
				TreeMapList.putAll(map);
			}
			
		
			Formation formation = ListeDesFormations.get(ListeFormation.nextElement());		
			
			//V�rifier le nombre des candidatures par rapport au quota de la formation
			if (formation.quota >= TreeMapList.size()){
				ListeCandidatAdmis.putAll(TreeMapList);
				ListeAdmiParFormation.put(formation.NomFormation, ListeCandidatAdmis);
				

			}
			else{
				for(int i =0; i<= TreeMapList.size();i++){	
					 for (Entry<String, Double> entry:TreeMapList.entrySet()) {
						 if (i <= formation.quota) {

							 ListeCandidatAdmis.put(entry.getKey(), entry.getValue());
							 ListeAdmiParFormation.put(formation.NomFormation,ListeCandidatAdmis);
						 }
						 else{
							 ineAttente.add(entry.getKey());
							 
							 
						 }				
					 }
				}

				 ListeDattente.put(formation.NomFormation, ineAttente);
								
			}
		
			
			//Maj etatVoeu etudiant admis
			// r�cup�re le voeu de l'�tudiant pour cette formation;			
			Hashtable<String,Double> ListeAdmis = ListeAdmiParFormation.get(ListeFormation.nextElement());
			Enumeration ineAdmis = ListeAdmis.keys();
			while(ineAdmis.hasMoreElements()){
				voeuEtu = ListeVoeux.get(ListeFormation.nextElement()).get(ineAdmis.nextElement());
				voeuEtu.etatVoeu = etatvoeux.accepter;
				if (DossierEtudiant.containsKey(ineAdmis.nextElement())){
					try {
						recto.envoyerDecisionCandidatureUniv(DossierEtudiant.get(ineAdmis.nextElement()).etu, voeuEtu);
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
				}
					
			}
			//Maj etatVoeu etudiant listeAttente
			for(int i=0; i<=ineAttente.size();i++){
				voeuEtu = ListeVoeux.get(ListeFormation.nextElement()).get(ineAttente.get(i));
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
						recto.envoyerDecisionCandidatureUniv(DossierCandidatureEtudiant.get(ineAdmis.nextElement()).etu, voeuEtu);
					} catch (DonneesInvalides e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
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
		//R�cupere la liste des formations
		short nbAdmis;
		short quota;
		short nbdispo;
		Enumeration ListeFormation  = ListeAdmiParFormation.keys();
		while(ListeFormation.hasMoreElements()){
			nbAdmis =(short) ListeAdmiParFormation.get(ListeFormation.nextElement()).size(); 
		    quota = ListeDesFormations.get(ListeFormation.nextElement()).quota;
			if (nbAdmis<quota){
				nbdispo = (short) (quota - nbAdmis);
				for(int i =0; i<=nbdispo; i++){
					//besoin de la moyenne
					//ListeAdmiParFormation.put(ListeDattente.get(ListeFormation.nextElement())), value));
					ListeDattente.remove(key, value);
				}
		}
			
		}
		
	}


/*****************fonction ajouter*******************************/


public void ajouterEtudiant(String ine, dossierEtudiant dossier)
{
		
	DossierEtudiant.put(ine, dossier);
	
}

	

}