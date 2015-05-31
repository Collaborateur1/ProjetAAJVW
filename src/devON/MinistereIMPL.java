package devON;
import generated.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
public class MinistereIMPL extends Minist�rePOA {
	
	

	//La liste des rectorats 
	Hashtable<String,Rectorat>ListeRectorat;
	//La liste des formation
	Formation[] ListeFormation;


	/**************************Constructeur***********************************/
	public MinistereIMPL(org.omg.CORBA.ORB orb,Hashtable<String, Rectorat> listeRectorat,
			Formation[] listeFormation) {
		super();
		ListeRectorat = listeRectorat;
		ListeFormation = listeFormation;
	}

	public MinistereIMPL(org.omg.CORBA.ORB orb) {
		super();
		ListeRectorat = new Hashtable<String,Rectorat>();
		//La liste des formation
		ListeFormation=new Formation[0];
		NamingServiceTool.putReferenceIntoNS(orb,"Ministere", this);
		
	}



	/**********************Fonction G�n�r�*********************/
	@Override
	public Formation[] madDesFormationsFrance() {
		// TODO Auto-generated method stub


		return ListeFormation;
	}

	@Override
	public void depotDesFormationsRectorat(Formation[] ListeFormation) {
		// TODO Auto-generated method stub
		//A chaque fois que l'on rajoute des formations
		//on cr�e un new tableau on copi les anciennes et les nouvelle donn�es
		//et on remplace le tableau courant
		//pas tres jojo..faudrai modifier IDL pour pa utilis� de Formation[]
		//sa correspond a la liste de formation que l'on a cr��
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
		//On rajoute le rectorat dans le minist�re
		
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
		
		//On fait juste pass� le message..enfin une appel de fonction quoi
		
		Enumeration ListeRectorat=this.ListeRectorat.elements();
		
		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;
			
			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJury();
		}

	}
	/**********************Fonction rajouter*********************/
	public void test()
	{
		
	
		//un test pour voir si les rectorats vienne bien ce rajouter
			if(!ListeRectorat.isEmpty())
			System.out.println("sa ka mach�3: ");
		
	}

	/**********************Le Main pour enregistrer dans le NS*************************/

	public static void main(String[] args) {
		
	}











}
