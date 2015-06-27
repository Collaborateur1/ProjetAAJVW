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



	/**********************Fonctions Générées*********************/
	/****
	 * @name madDesFormationsFrance 
	 * @description Mise à la disposition de la GDV de toutes les formations existantes
	 * 
	 * @return Formation[] : tableaux contenant toutes les formations
	 ****/	
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

	/****
	 * @name GetRectoratEtudiant 
	 * @description Récupérer le rectorat pour un étudiant donné
	 * 
	 * @param String: ine d'un étudiant
	 * @return Rectorat : un rectorat d'un étudiant
	 ****/	
	@Override
	public Rectorat GetRectoratEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub

		return IneRectorat.get(ine);
	}
	/****
	 * @name containsEtudiant 
	 * @description Vérification si un étudiant possède un rectorat rattache 
	 * (appelé avant de retourner un vrai rectorat pour éviter une valeur null en corba)
	 * 
	 * @param String: ine d'un étudiant
	 * @return Boolean : si rectorat de l'étudiant existe ou pas 
	 ****/
	@Override
	public boolean containsEtudiant(String ine) throws DonneesInvalides {
		return IneRectorat.containsKey(ine);
	}
	/****
	 * @name EnregistrerRectoratEtudiant 
	 * @description Ajoute le Rectorat d'un étudiant dans la liste de cette classe
	 * 
	 * @param String: ine d'un étudiant
	 * @param Rectorat: Rectorat de l'étudiant
	 ****/
	@Override
	public void EnregistrerRectoratEtudiant(String ine, Rectorat recto) {
		IneRectorat.put(ine, recto);
	}

	/****
	 * @name depotDesFormationsRectorat 
	 * @description Ajouter les formations transmises par les rectorats à la liste des formations
	 * 
	 * @param Formation: nouvelle formation
	 ****/
	@Override
	public void depotDesFormationsRectorat(Formation Formation) {
		this.ListeFormation.add(Formation);
	}

	/****
	 * @name deliberationJuryFinal 
	 * @description Permet de délibérer la 2ème vague (cascade jusqu'aux universités)
	 * 
	 * @return void
	 ****/
	@Override
	public void deliberationJuryFinal() {
		Enumeration ListeRectorat=this.ListeRectorat.elements();
		
		//Appel des délibération en cascade de tous les rectorats pour qu'à leurs tours ils appellent les université
		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;

			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJuryFinal();
		}
	}

	/****
	 * @name inscriptionRectorat 
	 * @description On ajoute un rectorat dans le ministère
	 * 
	 * @param String: nom du rectorat
	 * @param Rectorat: ior du rectorat
	 */
	@Override
	public void inscriptionRectorat(String nomRectorat, Rectorat iorRectorat)throws DonneesInvalides {
		//On rajoute le rectorat dans le ministère
		ListeRectorat.put(nomRectorat, iorRectorat);
	}

	/****
	 * @name recupererRectorat 
	 * @description On récupère un rectorat selon un nom donné
	 * 
	 * @param String: nom du rectorat recherché
	 * @return Rectorat : ior du rectorat recherché
	 ****/
	@Override
	public Rectorat recupererRectorat(String nomRectorat)
			throws DonneesInvalides {
		//on retourne tout simplement le rectorat correspondant..
		return ListeRectorat.get(nomRectorat);

	}

	/****
	 * @name rectoratRattacherUniv 
	 * @description Permet de retrouver le rectorat rattaché a une université
	 * 
	 * @param String: nom du rectorat recherché (grace au nom de l'academie car nom academie = nom rectorat)
	 * @return Rectorat : ior du rectorat recherché
	 ****/
	@Override
	public Rectorat rectoratRattacherUniv(String nomAcademie)
			throws DonneesInvalides {
		//fonction redondante avec recupererRectorat mais concervé pour ne pas planter le programme (manque de temps)
		return ListeRectorat.get(nomAcademie);
	}

	/****
	 * @name deliberationJury 
	 * @description Permet de délibéré la première vague (appel des universités en cascade)
	 * 
	 * @return void
	 ****/
	@Override
	public void deliberationJury() {
		//On appel en cascade tous les rectorat qui appelleront à leur tour les université pour les faire délibérer
		Enumeration ListeRectorat=this.ListeRectorat.elements();

		while(ListeRectorat.hasMoreElements())
		{
			Rectorat rt=null;

			rt=(Rectorat) ListeRectorat.nextElement();
			rt.deliberationJury();
		}

	}
	
	/********************** Fonctions rajoutées *********************/


	/********************** Le Main pour enregistrer dans le Naming Service *************************/

	public static void main(String[] args) {

	}
	
	/****
	 * @name InscriptionGDVDansRectorats 
	 * @description Pour chaque rectorat on lui assigne une GDV qui lui transmettra les candidatures
	 * 
	 * @param String: numéro de la GDV assignée
	 * @param GestionDesVoeux : IOR de la GDV assignée
	 ****/
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
