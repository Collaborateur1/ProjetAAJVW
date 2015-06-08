package devON;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.GestionDesVoeux;
import generated.Ministère;
import generated.MinistèreHelper;
import generated.Rectorat;
import generated.RectoratHelper;
import generated.RectoratPOA;
import generated.RectoratPOATie;
import generated.Universite;
import generated.Voeu;
import generated.dossierEtudiant;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;




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
		MonMinistere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
		System.out.println("Reférérence ministere recuperee" );
		 
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

			} catch (DonneesInvalides e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
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




			//La l'université auquel il postule est t'elle dans son rectorat
			if(lv[i].formationVoeu.nomRectorat.equals(this.nomRectorat))
			{
				//Avant tout! la candidature est elle valide?
				if(CandidatureConforme(etu.formation.NomFormation,lv[i].formationVoeu.NomFormation))
				{	

					//postule til dans son université? si oui pas de transfert de dossier

					if(lv[i].formationVoeu.nomUniv.equals(etu.nomUniv))
					{	

						univEtudiant.envoyerCandidature(etu.ineEtudiant, lv[i]);
					}
					//sinnon bin on récupere le dossier dans luniv de letudiant
					//et on lenvoi a lautre univ qui est elle aussi dans le rectorat
					else
					{
						dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
						Universite univPostuler =GetUniversiteDansRecorat(lv[i].formationVoeu.nomUniv);
						univPostuler.envoyerCandidatureD(dossierEtu, etu.ineEtudiant, lv[i]);
					}
				}
				else
				{
					//il faut la renvoyer a létudiant! A toi de jouer ;)
				}
			}
			//sinnon on fait le transfert vers le bon rectorat
			else
			{


				Rectorat recorat_a_Joindre=MonMinistere.recupererRectorat(lv[i].formationVoeu.nomRectorat);
				dossierEtu=univEtudiant.madDossier(etu.ineEtudiant);
				recorat_a_Joindre.transfertDossier(dossierEtu, lv[i]);



			}

		}

	}



	@Override
	public void envoyerDecisionCandidatureRectorat(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub

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
			Gdv=LesGDV.get(String.valueOf(voeu.numeroVoeu));
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
	public void inscriptionUniv(Universite iorLUniversite) {
		// TODO Auto-generated method stub
		
		ListeListUniversite.put(iorLUniversite.nomUniversite(), iorLUniversite);
	}

	@Override
	public void repondrePropositionVoeux(String ine, Voeu voeu)
			throws DonneesInvalides {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void inscriptionGDV(GestionDesVoeux Gdv) {
		// TODO Auto-generated method stub
		LesGDV.put(String.valueOf(Gdv.numeroGDV()), Gdv);
	}

	@Override
	public void deliberationJury() {
		// TODO Auto-generated method stub
Enumeration ListeUniv=this.ListeListUniversite.elements();
		
		while(ListeUniv.hasMoreElements())
		{
			Universite Un=null;
			
			Un=(Universite) ListeUniv.nextElement();
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
		throw new DonneesInvalides("ine inconnu");
	}

	/*********************Fonction créé par nous**************/

	//Vérifier q'une candidature est conforme

	public boolean CandidatureConforme(String NomFormationEtudiant,String Nomformationvoeu)
	{
		//On récupere la liste des formations valide pour la formation auquel il a postuler
		ArrayList<String> ListeFormationValidePrCandidature=ValidationFormation.get(Nomformationvoeu);

		//On cherche si on trouve la formation de létudiant dans les formations valide
		for (int i=0;i< ListeFormationValidePrCandidature.size();i++)
		{
			if(ListeFormationValidePrCandidature.get(i).equals(NomFormationEtudiant))
			{
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

	

	



}
