package devON;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import PostLicence.*;
public class MinistereIMPL extends MinistèrePOA {
	
	

	//La liste des rectorats 
	Hashtable<String,Rectorat>ListeRectorat;
	//La liste des formation
	Formation[] ListeFormation;


	/*************************Constructeur***********************************/
	public MinistereIMPL(Hashtable<String, Rectorat> listeRectorat,
			Formation[] listeFormation) {
		super();
		ListeRectorat = listeRectorat;
		ListeFormation = listeFormation;
	}

	public MinistereIMPL() {
		super();
		Hashtable<String,Rectorat>ListeRectorat = new Hashtable<String,Rectorat>();
		//La liste des formation
		ListeFormation=new Formation[0];
	}



	/**********************Fonction Généré*********************/
	@Override
	public Formation[] madDesFormationsFrance() {
		// TODO Auto-generated method stub


		return ListeFormation;
	}

	@Override
	public void depotDesFormationsRectorat(Formation[] ListeFormation) {
		// TODO Auto-generated method stub
		//A chaque fois que l'on rajoute des formations
		//on crée un new tableau on copi les anciennes et les nouvelle données
		//et on remplace le tableau courant
		//pas tres jojo..faudrai modifier IDL pour pa utilisé de Formation[]
		//sa correspond a la liste de formation que l'on a créé
		//elle n'est pas pratique dutt..

		int NombreDeFormationARajouter=ListeFormation.length;
		int NombreDeFormationDejaExistante=this.ListeFormation.length;
		int totale=NombreDeFormationARajouter+NombreDeFormationDejaExistante;
		int j=0;
	
		

		Formation[] tempformation=new Formation[totale];
		
		for (int i=0; i<NombreDeFormationDejaExistante;i++)
		{

			tempformation[i]=ListeFormation[i];
			j=i;
			
		}
		if (j>0)j++;
		
		for (int i=0; i<NombreDeFormationARajouter;i++)
		{

			tempformation[j]=ListeFormation[i];
			j++;
			
			
		}

this.ListeFormation=tempformation;

	}

	@Override
	public void inscriptionRectorat(String nomRectorat, Rectorat iorRectorat)throws DonneesInvalides {
		// TODO Auto-generated method stub
		//On rajoute le rectorat dans le ministère
		ListeRectorat.put(nomRectorat, iorRectorat);


	}

	@Override
	public Rectorat recupererRectorat(String nomRectorat)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		//on retourne tout simplement le rectorat correspondant..
		return ListeRectorat.get(nomRectorat);

	}

	@Override
	public Rectorat rectoratRattacherUniv(String nomAcademie)
			throws DonneesInvalides {
		//fonction redondante avec recupererRectorat...
		return ListeRectorat.get(nomAcademie);

		// TODO Auto-generated method stub

	}

	@Override
	public void deliberationJury() {
		// TODO Auto-generated method stub
		
		//On fait juste passé le message..enfin une appel de fonction quoi
		
		Enumeration ListeRectorat=this.ListeRectorat.elements();
		
		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;
			
			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJury();
		}

	}


	/**********************Le Main pour enregistrer dans le NS*************************/

	public static void main(String[] args) {
		MinistereIMPL ministere	= new MinistereIMPL();
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		//le NamingServiceTool fait le boulot d'enregistrer l'objet ministere dans le NS
		// parametre 1=orb parametre 2= nom dans le NS 3= L'objet
		NamingServiceTool.putReferenceIntoNS(orb,"Ministere", ministere);
		orb.run();
	}











}
