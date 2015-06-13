package classeIMPL;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.GestionDesVoeux;
import generated.Ministère;
import generated.MinistèreHelper;
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
	Ministère MonMinistere;
	org.omg.PortableServer.POA rootPOA;

	/*************************Constructeur
	 * @throws DonneesInvalides 
	 * @throws InvalidName 
	 * @throws AdapterInactive 
	 * @throws WrongPolicy 
	 * @throws ServantNotActive ***********************************/
	public RectoratIMPL(Hashtable<String, Universite> listeListUniversite,String nomrectorat,org.omg.CORBA.ORB orb ) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		super();
		ListeListUniversite = listeListUniversite;
		MonMinistere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Reférérence ministere recuperee" );
        this.nomRectorat=nomrectorat;
        
        rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();
        MonMinistere.inscriptionRectorat(this.nomRectorat, RectoratHelper.narrow(rootPOA.servant_to_reference(this)));
    	

	}

	public RectoratIMPL(org.omg.CORBA.ORB orb,String nomrectorat) throws DonneesInvalides, ServantNotActive, WrongPolicy, InvalidName, AdapterInactive {
		super();
		ListeListUniversite = new Hashtable<String,Universite>();
		ValidationFormation=new Hashtable<String, ArrayList<String>>();
		MonMinistere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Reférérence ministere recuperee" );
		LesGDV=new Hashtable<String, GestionDesVoeux>();
		this.nomRectorat=nomrectorat;
	  rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	  rootPOA.the_POAManager().activate();
	  MonMinistere.inscriptionRectorat(this.nomRectorat, RectoratHelper.narrow(rootPOA.servant_to_reference(this)));
	
	}



	/**********************Fonction Généré*********************/

	@Override
	public String nomRectorat() {
		// TODO Auto-generated method stub
		return nomRectorat;
	}

	@Override
	public void deliberationJuryFinal() {
		// TODO Auto-generated method stub
		System.out.println("****************************4");
		Enumeration<Universite> ListeUniv=this.ListeListUniversite.elements();

		while(ListeUniv.hasMoreElements())
		{
			Universite Un=null;

			Un= ListeUniv.nextElement();
			System.out.println(Un.nomUniversite()+"*******************");
			Un.deliberationFinal();
			
		}
	}
	
	@Override
	public void transfertDossier(dossierEtudiant dossierEtu, Voeu voeu) {

		// TODO Auto-generated method stub

		boolean candiddatureConforme=false;

		//->boolean CandidatureConforme(String NomFormationEtudiant,String Nomformationvoeu)
		if (CandidatureConforme(dossierEtu.etu.formation.NomFormation,voeu.formationVoeu.NomFormation))
		{	

			try {
				
				Universite universiteAcontacter;	
				universiteAcontacter =ListeListUniversite.get(voeu.formationVoeu.nomUniv);
				universiteAcontacter.envoyerCandidatureD(dossierEtu,dossierEtu.etu.ineEtudiant, voeu);
				voeu.etatVoeu=etatvoeux.valide;
				this.envoyerDecisionCandidatureRectorat(dossierEtu.etu.ineEtudiant, voeu);

			} catch (DonneesInvalides e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				voeu.etatVoeu=etatvoeux.nonValide;
				Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(dossierEtu.etu.formation.nomRectorat);
				recorat_a_Joindre.envoyerDecisionCandidatureRectorat(dossierEtu.etu.ineEtudiant, voeu);
				
			} catch (DonneesInvalides e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//si la candidature n'est pas conforme il faut la renvoyer a létudiant...good luck..
		}

	}
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
			/*histoire de vous faciliter la compréhention*/
			NomFormationEtudiant=etu.formation.NomFormation;
			NomFormationVoeux=lv[i].formationVoeu.NomFormation;
			
			//test si université est dans le rectorat de l'étudiant
			if(lv[i].formationVoeu.nomRectorat.equals(this.nomRectorat))
			{
				
				//Avant tout! la candidature est elle valide?
				if(CandidatureConforme(etu.formation.NomFormation,lv[i].formationVoeu.NomFormation))
				{	

					//postule-t-il dans son université? si oui pas de transfert de dossier
					if(lv[i].formationVoeu.nomUniv.equals(etu.nomUniv))
					{	
						
						univEtudiant.envoyerCandidature(etu.ineEtudiant, lv[i]);
					}
					//sinon bin on récupere le dossier dans luniv de letudiant
					//et on lenvoi a lautre univ qui est, elle aussi dans le rectorat
					else
					{
						
						dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
						System.out.println("ici?" );
						Universite univPostuler =GetUniversiteDansRecorat(lv[i].formationVoeu.nomUniv);
						System.out.println("ou encor la" );
						univPostuler.envoyerCandidatureD(dossierEtu, etu.ineEtudiant, lv[i]);
						System.out.println("comprend rien --.-" );
					}
					lv[i].etatVoeu = etatvoeux.valide;
					LesGDV.get(String.valueOf(lv[i].numerogdv)).transmettreDecisionCandidatureRectorat(etu.ineEtudiant, lv[i]);
				}
				else
				{
					System.out.println("222" );
					lv[i].etatVoeu = etatvoeux.nonValide;
					LesGDV.get(String.valueOf(lv[i].numerogdv)).transmettreDecisionCandidatureRectorat(etu.ineEtudiant, lv[i]);
					//il faut la renvoyer a létudiant! A toi de jouer ;)
				}
			}
			//sinnon on fait le transfert vers le bon rectorat
			else
			{

				
				Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(lv[i].formationVoeu.nomRectorat);
				System.out.println("amel theori2"+nomRectorat );
				dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
				System.out.println("amel theori3" );
				recorat_a_Joindre.transfertDossier(dossierEtu, lv[i]);
				System.out.println("amel theori4" );



			}

		}

	}



	@Override
	public void envoyerDecisionCandidatureRectorat(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		LesGDV.get(String.valueOf(voeu.numerogdv)).transmettreDecisionCandidatureRectorat(ine, voeu);
	}

	@Override
	public void envoyerDecisionCandidatureUniv(Etudiant etu, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		//si il s'agit de ce recorat qui doit récupéré la réponse
		if(etu.formation.nomRectorat.equals(nomRectorat))
		{
			
			//Pour faire simple..le numero de voeu correspond a son GDV comme sa
			//facile de le retrouver
			GestionDesVoeux Gdv;
			Gdv=LesGDV.get(String.valueOf(voeu.numerogdv));
			Gdv.transmettreDecisionCandidatureRectorat(etu.ineEtudiant, voeu);
		}
		//sinnon faut le passer au bon recorat
		else
		{
			Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(etu.formation.nomRectorat);
			
			//on ne s'embete pas.. on appel direct le service sur le bon serveur
			recorat_a_Joindre.envoyerDecisionCandidatureUniv(etu,voeu);
		}
	}
	

	@Override
	public void inscriptionUniv(Universite iorLUniversite, String nomUniv) {
		// TODO Auto-generated method stub
	
		ListeListUniversite.put(nomUniv, iorLUniversite);
		
	}

	@Override
	public void repondrePropositionVoeux(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		Universite univ;
		Enumeration<Universite> e= ListeListUniversite.elements();
		while (e.hasMoreElements())
		{
			univ=e.nextElement();
			if(univ.nomUniversite().equals(voeu.formationVoeu.nomUniv))
			{
				univ.repondrePropositionvoeux(ine, voeu);
			}
		}
	}

	@Override
	public void inscriptionGDV(short numeroGDV, GestionDesVoeux Gdv) {
		// TODO Auto-generated method stub
		LesGDV.put(String.valueOf(numeroGDV), Gdv);
	}

	@Override
	public void deliberationJury() {
		// TODO Auto-generated method stub
		System.out.println("test3");
		Enumeration<Universite> ListeUniv=this.ListeListUniversite.elements();

		while(ListeUniv.hasMoreElements())
		{
			Universite Un=null;

			Un= ListeUniv.nextElement();
			Un.deliberationJury();
		}
	}
	
	@Override
	public Etudiant getFicheEtudiant(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
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

	/*********************Fonction créé par nous**************/

	//Vérifier q'une candidature est conforme

	public boolean CandidatureConforme(String NomFormationEtudiant,String Nomformationvoeu)
	{System.out.println(" NomFormationEtudiant: "+ NomFormationEtudiant+" Nomformationvoeu: "+Nomformationvoeu);
		//On récupere la liste des formations valide pour la formation auquel il a postuler
		ArrayList<String> ListeFormationValidePrCandidature=ValidationFormation.get(Nomformationvoeu);

		//On cherche si on trouve la formation de létudiant dans les formations valide
		for (int i=0;i< ListeFormationValidePrCandidature.size();i++)
		{System.out.println(" NomFormationEtudiant: "+ListeFormationValidePrCandidature.get(i));
			if(ListeFormationValidePrCandidature.get(i).equals(NomFormationEtudiant))
			{
				System.out.println(" NomFormationEtudiant: "+ListeFormationValidePrCandidature.get(i));
				return true;
			}	
		}
		return false;
	}

	// vérifier si luniv fait parti du recorat
	public boolean UniversiteDansRecorat(String univ)
	{
		if (ListeListUniversite.get(univ)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// récupérer luuniv si elle fait parti du recorat
	public Universite GetUniversiteDansRecorat(String univ)
	{
		return ListeListUniversite.get(univ);

	}
	


	public static void main(String[] args) throws DonneesInvalides, ServantNotActive, WrongPolicy, InvalidName {

  
    
	}



	@Override
	public void ajoutPrerequis(Formation formation, String[] prerequis) {
		// TODO Auto-generated method stub
		
		ArrayList<String> Prereq = new ArrayList<String>();
		for(int i =0 ; i<prerequis.length; i++){
			Prereq.add(prerequis[i]);
		}
		
		ValidationFormation.put(formation.NomFormation, Prereq);
		MonMinistere.depotDesFormationsRectorat(formation);
	}

	

	

	

	



}
