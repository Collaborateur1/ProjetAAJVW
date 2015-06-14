package Databases;

import generated.Formation;
import generated.Voeu;
import generated.decision;
import generated.etatvoeux;

import java.util.ArrayList;
import java.util.Hashtable;

public class BddHelperVoeu {

	Hashtable<String,ArrayList<Voeu>>ListeVoeuxEtudiant;
	
	public BddHelperVoeu()
	{
		ListeVoeuxEtudiant= new Hashtable<String, ArrayList<Voeu>>();
	}
	
	public void ajouterVoeu(String ine,String nomUniv,String nomForm,String typForm,String nomRect,short quota,String etaVoeu,String decis,short numV,short numGdv)
	{
		/*struct Voeu {
			Formation formationVoeu;
			etatvoeux etatVoeu;
			decision dcsEtudiant;
			short numeroVoeu;
			short numerogdv;
			
		};
		
		struct Formation {
			string nomUniv;
			string NomFormation;
			string TypeFormation;
			string nomRectorat; //Afin de pouvoir orienter les voeux vers le bon rectorat quand les voeux sont transféré
			short quota;
			*/
		etatvoeux et = null;
		decision deci = null;
		
		switch(etaVoeu)
		{
		case "soumis":
			et=etatvoeux.soumis;
			break;
		case "nonValide":
			et=etatvoeux.nonValide;
			break;
		case "valide":
			et=etatvoeux.valide;
			break;
		case "accepter":
			et=etatvoeux.accepter;
			break;
		case "refuser":
			et=etatvoeux.refuser;
			break;
		case "listeDattente":
			et=etatvoeux.listeDattente;
			break;
			
		}
		
		
		switch(decis)
		{
		case "OUIdefinitif":
			deci=decision.OUIdefinitif;
			break;
		case "OUImais":
			deci=decision.OUImais;
			break;
		case "NONdefinitif":
			deci=decision.NONdefinitif;
			break;
		case "NONmais":
			deci=decision.NONmais;
			break;
		case "NONutilse":
			deci=decision.NONutilse;
			break;
	
			
		}
		
		Voeu v=new Voeu(new Formation(nomUniv, nomForm, typForm, nomRect, quota), et, deci, numV,numGdv);
		if(ListeVoeuxEtudiant.containsKey(ine))
		{
			ListeVoeuxEtudiant.get(ine).add(v);
		}
		else
		{
			ArrayList<Voeu> array= new ArrayList<Voeu>();
			array.add(v);
			
			ListeVoeuxEtudiant.put(ine,array);
		}
		
	}

	public Hashtable<String, ArrayList<Voeu>> getListeVoeuxEtudiant() {
		return ListeVoeuxEtudiant;
	}

	public void setListeVoeuxEtudiant(
			Hashtable<String, ArrayList<Voeu>> listeVoeuxEtudiant) {
		ListeVoeuxEtudiant = listeVoeuxEtudiant;
	}
	
}
