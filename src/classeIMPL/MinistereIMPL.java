package classeIMPL;
import generated.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import outils.NamingServiceTool;


public class MinistereIMPL extends MinistèrePOA {
	
	

	//La liste des rectorats 
	Hashtable<String,Rectorat>ListeRectorat;
	
	Hashtable<String,Rectorat>IneRectorat;
	
	//La liste des formation
	ArrayList<Formation> ListeFormation;

	org.omg.PortableServer.POA rootPOA;

	/**************************Constructeur***********************************/
	public MinistereIMPL(org.omg.CORBA.ORB orb,Hashtable<String, Rectorat> listeRectorat,
			ArrayList listeFormation) {
		super();
		ListeRectorat = listeRectorat;
		ListeFormation = listeFormation;
	}

	public MinistereIMPL(org.omg.CORBA.ORB orb) throws InvalidName, AdapterInactive {
		super();
		ListeRectorat = new Hashtable<String,Rectorat>();
		//La liste des formation
		ListeFormation=new ArrayList<Formation>();
		IneRectorat=new Hashtable<String, Rectorat>();
		NamingServiceTool.putReferenceIntoNS(orb,"Ministere", this);
	/*	rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		rootPOA.the_POAManager().activate();*/
	}



	/**********************Fonction Généré*********************/
	@Override
	public Formation[] madDesFormationsFrance() {
		// TODO Auto-generated method stub
		Formation[] Forma=new Formation[ListeFormation.size()];
		
for(int i=0;i<this.ListeFormation.size();i++)
{
	Forma[i]=this.ListeFormation.get(i);
	System.out.println("test "+ Forma[i].NomFormation);
}


		return Forma;
	}
	

	@Override
	public Rectorat GetRectoratEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		return IneRectorat.get(ine);
	}

	@Override
	public void EnregistrerRectoratEtudiant(String ine, Rectorat recto) {
		// TODO Auto-generated method stub
		IneRectorat.put(ine, recto);
		
	}
	
	@Override
	public void depotDesFormationsRectorat(Formation Formation) {
		// TODO Auto-generated method stub
		this.ListeFormation.add(Formation);
	}
	
	@Override
	public void deliberationJuryFinal() {
		// TODO Auto-generated method stub
		System.out.println("*************************2");
		Enumeration ListeRectorat=this.ListeRectorat.elements();
		
		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;
			
			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJuryFinal();
		}
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
		System.out.println("test2");
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
			System.out.println("sa ka maché3: ");
		
	}

	/**********************Le Main pour enregistrer dans le NS*************************/

	public static void main(String[] args) {
		
	}

	@Override
	public void InscriptionGDVDansRectorats(short num, GestionDesVoeux gdv) {
		// TODO Auto-generated method stub
		Enumeration<Rectorat> ele =ListeRectorat.elements();
		
		while(ele.hasMoreElements())
		{
			ele.nextElement().inscriptionGDV(num, gdv);
		}
		
	}

	














}
