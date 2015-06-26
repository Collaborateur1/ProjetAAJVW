package classeIMPL;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesVoeux;
import generated.Minist�re;
import generated.Minist�reHelper;
import generated.Rectorat;
import generated.RectoratHelper;
import generated.RectoratPOA;
import generated.RectoratPOATie;
import generated.Universite;
import generated.Voeu;
import generated.decision;
import generated.dossierEtudiant;
import generated.etatvoeux;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import outils.NamingServiceTool;




public class RectoratIMPL extends RectoratPOA {

	Hashtable<String,Universite>ListeListUniversite;
	Hashtable<String,ArrayList<String>>ValidationFormation;
	Hashtable<String,GestionDesVoeux>LesGDV;
	String nomRectorat;
	Minist�re MonMinistere;
	org.omg.PortableServer.POA rootPOA;
	boolean deliberationJury=false;

	/*************************Constructeur
	 * @throws DonneesInvalides 
	 * @throws InvalidName 
	 * @throws AdapterInactive 
	 * @throws WrongPolicy 
	 * @throws ServantNotActive ***********************************/

	public RectoratIMPL(org.omg.CORBA.ORB orb,String nomrectorat) throws DonneesInvalides, ServantNotActive, WrongPolicy, InvalidName, AdapterInactive {
		super();
		ListeListUniversite = new Hashtable<String,Universite>();
		ValidationFormation=new Hashtable<String, ArrayList<String>>();
		MonMinistere= Minist�reHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Ref�r�rence ministere recuperee" );
		LesGDV=new Hashtable<String, GestionDesVoeux>();
		this.nomRectorat=nomrectorat;
	  rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	  rootPOA.the_POAManager().activate();
	  MonMinistere.inscriptionRectorat(this.nomRectorat, RectoratHelper.narrow(rootPOA.servant_to_reference(this)));
	
	}

	/**
	 * name -nomRectorat retourne le nom du rectorat
	 * 
	 * @return String : Le nom de rectorat
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public String nomRectorat() {
		return nomRectorat;
	}

	/**
	 * name -deliberationJuryFinal  d�lib�ration final du jury
	 * 
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void deliberationJuryFinal() {
		Enumeration<Universite> ListeUniv=this.ListeListUniversite.elements();
		//On parcours toutes les universit� pour lancer les d�lib�ration sur chacune d'elle
		while(ListeUniv.hasMoreElements())
		{
			Universite Un=null;

			Un= ListeUniv.nextElement();
			Un.deliberationFinal();
		}
	}
	
	/**
	 * name -transfertDossier retourne le nom du rectorat
	 * 
	 * @param dossierEtudiant : le dossier de l'�tudiant
	 * @param Voeu : le Voeu de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void transfertDossier(dossierEtudiant dossierEtu, Voeu voeu) {
		boolean candiddatureConforme=false;

		//Si la candidature est conforme
		if (CandidatureConforme(dossierEtu.etu.formation.NomFormation,voeu.formationVoeu.NomFormation))
		{	
			//On relai la candidature a l'universit� concern�
			try {
				
				Universite universiteAcontacter;	
				universiteAcontacter =ListeListUniversite.get(voeu.formationVoeu.nomUniv);
				universiteAcontacter.envoyerCandidatureD(dossierEtu,dossierEtu.etu.ineEtudiant, voeu);
				voeu.etatVoeu=etatvoeux.valide;
				this.envoyerDecisionCandidatureRectorat(dossierEtu.etu.ineEtudiant, voeu);

			} catch (DonneesInvalides e) {
				e.printStackTrace();
			}
		}
		else
		{
			//si la candidature n'est pas conforme il faut la renvoyer � l'�tudiant
			try {
				voeu.etatVoeu=etatvoeux.nonValide;
				Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(dossierEtu.etu.formation.nomRectorat);
				recorat_a_Joindre.envoyerDecisionCandidatureRectorat(dossierEtu.etu.ineEtudiant, voeu);
				
			} catch (DonneesInvalides e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	/**
	 * name -envoyerListeVoeuxGDV envoy� la liste de voeux au universit�s 
	 * 
	 * @param Voeu[] : la liste de voeu des �tudiants � envoy�
	 * @param Etudiant : LE dosser de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void envoyerListeVoeuxGDV(Voeu[] lv, Etudiant etu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		dossierEtudiant dossierEtu;

		Universite univEtudiant =GetUniversiteDansRecorat(etu.nomUniv);
	
		String NomFormationEtudiant;
		String NomFormationVoeux;
		

		for(int i=0;i<lv.length;i++)
		{
			//Pour faciliter la compr�hention
			NomFormationEtudiant=etu.formation.NomFormation;
			NomFormationVoeux=lv[i].formationVoeu.NomFormation;
			
			//test si universit� est dans le rectorat de l'�tudiant
			if(lv[i].formationVoeu.nomRectorat.equals(this.nomRectorat))
			{
				
				//Avant tout! la candidature est elle valide?
				if(CandidatureConforme(etu.formation.NomFormation,lv[i].formationVoeu.NomFormation))
				{	

					//postule-t-il dans son universit�? si oui pas de transfert de dossier
					if(lv[i].formationVoeu.nomUniv.equals(etu.nomUniv))
					{	
						
						univEtudiant.envoyerCandidature(etu.ineEtudiant, lv[i]);
					}
					//sinon on r�cupere le dossier dans luniv de letudiant
					//et on lenvoi a lautre univ qui est, elle aussi dans le rectorat
					else
					{
						
						dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
						
						Universite univPostuler =GetUniversiteDansRecorat(lv[i].formationVoeu.nomUniv);
						
						univPostuler.envoyerCandidatureD(dossierEtu, etu.ineEtudiant, lv[i]);
						
					}
					lv[i].etatVoeu = etatvoeux.valide;
					LesGDV.get(String.valueOf(lv[i].numerogdv)).transmettreDecisionCandidatureRectorat(etu.ineEtudiant, lv[i]);
				}
				else
				{
					
					lv[i].etatVoeu = etatvoeux.nonValide;
					LesGDV.get(String.valueOf(lv[i].numerogdv)).transmettreDecisionCandidatureRectorat(etu.ineEtudiant, lv[i]);
					
				}
			}
			
			
			else
			{
				Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(lv[i].formationVoeu.nomRectorat);
				
				dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
		
				recorat_a_Joindre.transfertDossier(dossierEtu, lv[i]);
			}

		}

	}


	/**
	 * name -envoyerDecisionCandidatureRectorat : Un rectorat relai la r�ponse d'une universit� a un autre rectorat qui lui avait transmis cette demande
	 * 
	 * @param String : ine de l'�tudiant
	 * @param Voeu : Voeu de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void envoyerDecisionCandidatureRectorat(String ine, Voeu voeu) throws DonneesInvalides {
		LesGDV.get(String.valueOf(voeu.numerogdv)).transmettreDecisionCandidatureRectorat(ine, voeu);
	}

	/**
	 * name -envoyerDecisionCandidatureUniv : Une universit� renvoie la r�ponse de sa candidature a son rectorat
	 * 
	 * @param Etudiant : Dossier de l'�tudiant
	 * @param Voeu : Voeu de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void envoyerDecisionCandidatureUniv(Etudiant etu, Voeu voeu) throws DonneesInvalides {
		//si il s'agit de ce recorat qui doit r�cup�r� la r�ponse
		if(etu.formation.nomRectorat.equals(nomRectorat))
		{
			
			//Pour faire simple, le numero de voeu correspond a son GDV comme ca
			//facile de le retrouver
			GestionDesVoeux Gdv;
			Gdv=LesGDV.get(String.valueOf(voeu.numerogdv));
			Gdv.transmettreDecisionCandidatureRectorat(etu.ineEtudiant, voeu);
		}
		//sinon le trasnmettre au bon recorat
		else
		{
			Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(etu.formation.nomRectorat);
			//on appel directement le service sur le bon serveur
			recorat_a_Joindre.envoyerDecisionCandidatureUniv(etu,voeu);
		}
	}
	

	/**
	 * name -inscriptionUniv : inscrition des universit�s dans le rectorats
	 * 
	 * @param inscriptionUniv : universit� � inscrire
	 * @param String  : Nom universit�
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void inscriptionUniv(Universite iorLUniversite, String nomUniv) {
		ListeListUniversite.put(nomUniv, iorLUniversite);
	}

	/**
	 * name -repondrePropositionVoeux : La GDV transmet la d�cision de l'�tudiant, la d�cision se trouve dans le voeu
	 * 
	 * @param String: ine de l'�tudiant
	 * @param Voeu : Voeu de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void repondrePropositionVoeux(String ine, Voeu voeu) throws DonneesInvalides {
		Universite univ;
		Enumeration<Universite> e= ListeListUniversite.elements();
		
		while (e.hasMoreElements())
		{
			univ=e.nextElement();
			if(univ.nomUniversite().equals(voeu.formationVoeu.nomUniv))
				univ.repondrePropositionvoeux(ine, voeu);
		}
	}

	/**
	 * name -inscriptionGDV : Inscription de la GDV
	 * 
	 * @param Short: num�ro de la GDV
	 * @param GestionDesVoeux : GestionDesVoeux � inscrire
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void inscriptionGDV(short numeroGDV, GestionDesVoeux Gdv) {
		LesGDV.put(String.valueOf(numeroGDV), Gdv);
	}

	/**
	 * name -deliberationJury() : d�lib�ration jury phase 2
	 * 
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	@Override
	public void deliberationJury() {
		//Parcours de chaque universit� pour faire d�lib�rer le jury
		if(!deliberationJury){
		Enumeration<Universite> ListeUniv=this.ListeListUniversite.elements();

		while(ListeUniv.hasMoreElements())
		{
			Universite Un=null;
			
			Un= ListeUniv.nextElement();
			Un.deliberationJury();
		}
		deliberationJury=true;
		}
	}
	
	/**
	 * name -getFicheEtudiant : Obtenir la fiche de l'�tudiant aupr�s de l'universit�
	 * 
	 * @param String: ine de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
		Universite univ;
		Enumeration<Universite> e= ListeListUniversite.elements();
		while (e.hasMoreElements())
		{
			univ=e.nextElement();
			if(univ.estEtudiant(ine))
			{
				return univ.getFicheEtudiant(ine);
			}
		}
		
		Formation f=new Formation("nada", "nada", "nada", "nada", (short)5);
		Etudiant t=new Etudiant("nada", "nada", "nada", "nada", "nada",f);
		return t;
		
	}

	/*********************Fonction local**************/

	//V�rifier q'une candidature est conforme
	public boolean CandidatureConforme(String NomFormationEtudiant,String Nomformationvoeu)
	{
		//On r�cupere la liste des formations valide pour la formation auquel il a postuler
		ArrayList<String> ListeFormationValidePrCandidature=ValidationFormation.get(Nomformationvoeu);
		System.out.println(ValidationFormation.toString());
		//On cherche si on trouve la formation de l�tudiant dans les formations valide
		for (int i=0;i< ListeFormationValidePrCandidature.size();i++)
		{
			if(ListeFormationValidePrCandidature.get(i).equals(NomFormationEtudiant))
				return true;
		}
		return false;
	}

	// v�rifier si luniv fait parti du recorat
	public boolean UniversiteDansRecorat(String univ)
	{
		if (ListeListUniversite.get(univ)!=null)
			return true;
		else
			return false;
	}

	// r�cup�rer l'univ si elle fait parti du recorat
	public Universite GetUniversiteDansRecorat(String univ)
	{
		return ListeListUniversite.get(univ);
	}

	public static void main(String[] args) throws DonneesInvalides, ServantNotActive, WrongPolicy, InvalidName {
	}

	/**
	 * name -ajoutPrerequis : Ajout des pr�requis d'une formation
	 * 
	 * @param Fromation: formation concern�
	 * @param String[]: tableaux des pr�requis
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void ajoutPrerequis(Formation formation, String[] prerequis) {
		ArrayList<String> Prereq = new ArrayList<String>();
		for(int i =0 ; i<prerequis.length; i++){
			Prereq.add(prerequis[i]);
		}
		
		ValidationFormation.put(formation.NomFormation, Prereq);
		MonMinistere.depotDesFormationsRectorat(formation);
	}

	

	

	

	



}
