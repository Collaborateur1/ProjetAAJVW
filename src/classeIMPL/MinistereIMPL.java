package classeIMPL;
import generated.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import outils.NamingServiceTool;


public class MinistereIMPL extends Minist�rePOA {



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



	/**********************Fonction G�n�r�*********************/
	/**
	 * name -madDesFormationsFrance Donne au GDV toutes les formations existante
	 * 
	 * @return Formation[] : tableaux contenant toutes les formations
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Formation[] madDesFormationsFrance() {
		// TODO Auto-generated method stub
		Formation[] Forma=new Formation[ListeFormation.size()];

		for(int i=0;i<this.ListeFormation.size();i++)
		{
			Forma[i]=this.ListeFormation.get(i);
		}
		return Forma;
	}

	/**
	 * name -GetRectoratEtudiant Donne le rectorat pour un �tudiant donn�
	 * 
	 * @param String: ine d'un �tudiant
	 * @return Rectorat : un rectorat d'un �tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Rectorat GetRectoratEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub

		return IneRectorat.get(ine);
	}
	/**
	 * name -containsEtudiant Dit si un �tudiant poss�de un rectorat rattache (appel� avant de retourner un vrai rectorat pour �viter une valeur null en corba)
	 * 
	 * @param String: ine d'un �tudiant
	 * @return Boolean : si rectorat de l'�tudiant existe ou pas 
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public boolean containsEtudiant(String ine) throws DonneesInvalides {
		return IneRectorat.containsKey(ine);
	}
	/**
	 * name -EnregistrerRectoratEtudiant Ajoute le Rectorat d'un �tudiant dans la liste de cette classe
	 * 
	 * @param String: ine d'un �tudiant
	 * @param Rectorat: Rectorat de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void EnregistrerRectoratEtudiant(String ine, Rectorat recto) {
		IneRectorat.put(ine, recto);
	}

	/**
	 * name -depotDesFormationsRectorat Ajout les formations transmises par les rectorats
	 * 
	 * @param Formation: nouvelle formation
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void depotDesFormationsRectorat(Formation Formation) {
		this.ListeFormation.add(Formation);
	}

	/**
	 * name -deliberationJuryFinal Permet de d�lib�r� la 2�me vague (cascade jusqu'au universit�)
	 * 
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void deliberationJuryFinal() {
		Enumeration ListeRectorat=this.ListeRectorat.elements();
		
		//Appel des d�lib�ration en cascade de tous les rectorats pour qu'� leurs tours ils appellent les universit�
		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;

			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJuryFinal();
		}
	}

	/**
	 * name -inscriptionRectorat On ajout un rectorat dans le minist�re
	 * 
	 * @param String: nom du rectorat
	 * @param Rectorat: ior du rectorat
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void inscriptionRectorat(String nomRectorat, Rectorat iorRectorat)throws DonneesInvalides {
		//On rajoute le rectorat dans le minist�re
		ListeRectorat.put(nomRectorat, iorRectorat);
	}

	/**
	 * name -recupererRectorat On r�cup�re un rectorat selon un nom donn�
	 * 
	 * @param String: nom du rectorat recherch�
	 * @return Rectorat : ior du rectorat recherch�
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public Rectorat recupererRectorat(String nomRectorat)
			throws DonneesInvalides {
		//on retourne tout simplement le rectorat correspondant..
		return ListeRectorat.get(nomRectorat);

	}

	/**
	 * name -rectoratRattacherUniv Permet de retrouver le rectorat rattach� a une universit�
	 * 
	 * @param String: nom du rectorat recherch� (grace au nom de l'academie car nom academie = nom rectorat)
	 * @return Rectorat : ior du rectorat recherch�
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public Rectorat rectoratRattacherUniv(String nomAcademie)
			throws DonneesInvalides {
		//fonction redondante avec recupererRectorat mais concerv� pour ne pas planter le programme (manque de temps)
		return ListeRectorat.get(nomAcademie);
	}

	/**
	 * name -deliberationJury Permet de d�lib�r� la premi�re vague (appel des universit� en cascade
	 * 
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void deliberationJury() {
		//On appel en cascade tous les rectorat qui appelleront � leur tour les universit� pour les faire d�lib�rer
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
	
	/**
	 * name -InscriptionGDVDansRectorats Pour chaque rectorat on lui assigne une GDV qui lui transmettra les candidatures
	 * 
	 * @param String: num�ro de la GDV assign�
	 * @param GestionDesVoeux : ior de la GDV assign�
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
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
