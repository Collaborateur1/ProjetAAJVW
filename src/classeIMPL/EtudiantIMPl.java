package classeIMPL;

import generated.DonneesInvalides;
import generated.GestionDesProfils;
import generated.GestionDesVoeux;
import generated.IEtudiant;
import generated.IEtudiantHelper;
import generated.IEtudiantPOA;
import generated.LoadBalancerEtudiant;
import generated.LoadBalancerEtudiantHelper;
import generated.UtilisationInterdite;
import generated.Voeu;
import generated.decision;
import graphique.Client;


import graphique.ConnexionIHM;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import outils.NamingServiceTool;

public class EtudiantIMPl extends IEtudiantPOA{
	
   /****
    * L'interface principale PostLicence
    *****/
	Client cl; 
	GestionDesProfils gdp;
	ConnexionIHM interfaceConnexion;
	org.omg.PortableServer.POA rootPOA;
	GestionDesVoeux gdv;
	LoadBalancerEtudiant loadbalancer;
	ArrayList<Voeu> ListeVoeuxEtu;
	String INE;

	
	/********** Fonctions générées **********/
	/**** Constructeur
	 * @throws RemoteException ****/	
	public EtudiantIMPl() throws RemoteException
	{
		this.cl=cl;
		cl=new Client(this);
		interfaceConnexion=new ConnexionIHM(this,cl);
		//On récupère le LoadBalancer
		loadbalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		ListeVoeuxEtu=new ArrayList<Voeu>();
	}
	
	/****
	 * @name notifier  
	 * @description Notifier l'étudiant
	 * 
	 * @param String : Message à notifier
	 ****/	
	
	@Override
	public void notifier(String message) {
		// TODO Auto-generated method stub
		cl.notification(message);

	}

	/****
	 * @name majEtatVoeux  
	 * @description Mettre à jour l'état des Voeux
	 * @param Voeu[] : Liste des voeux à mettre à jour
	 ****/	
	@Override
	public void majEtatVoeux(Voeu[] Voeux) {
		// TODO Auto-generated method stub
		
		cl.miseAjourJlist2(Voeux);
	}

	

	/****
	 * @name ConnexionGDP 
	 * @description connexion au serveur GestionDeProfils
	 * 
	 * @param String : INE etudiant
	 * @param String : Mots de passe
	 * @return boolean : connexion effectuée ou non
	 ****/	
	public boolean ConnexionGDP(String INE, String mdp) throws DonneesInvalides, ServantNotActive, WrongPolicy
	{
		IEtudiant etu;
		//ici on récupere la GDP de letudiant selon son ine
		if(setGestionDesProfils(INE))
		{
			//On teste si l'étudiant à le droit de ce connecter
			if(gdp.autorisationConnexion(INE, mdp))
			{
				//On teste si l'étudiant est déjà connecté ou non
				if(gdp.etudiantInscrit(INE))
				{
					etu=IEtudiantHelper.narrow(rootPOA.servant_to_reference(this));
					gdv=gdp.connexion(etu, INE, mdp);
					//Si il possède des voeux on les charges dans l'interface
					if(gdv.possedeVoeux(INE))
						cl.configuration_de_connexion(gdp.consulterProfil(INE),gdv.chargerVoeux(INE));
					else
						cl.configuration_de_connexion(gdp.consulterProfil(INE),null);

					this.INE=INE;
					cl.setVisible(true);
					this.interfaceConnexion.setVisible(false);
					
					return true;
				}
				else
					return false;

			}
			return false;
		}


		return false;
	}

	/****
	 * @name getPostLicenceInterface  
	 * @description Obtenir la page principale liée à l'étudiant
	 * 
	 * @return Client : l'interface graphique du client
	 ****/	
	public Client getPostLicenceInterface()
	{
		return this.cl;
	}

	/**
	 * @name setGestionDesProfils  
	 * @description Récupérer le GDP avec le loadBalancer
	 * 
	 * @param String : INE de l'étudiant
	 * @return boolean : Vrai s'il retrouve un profil avec l'INE dans le serveur GestionDeProfils
	 */	
	public boolean setGestionDesProfils(String ine) throws DonneesInvalides
	{	
		//On charge l'instance du loadBalancer
		gdp=loadbalancer.getProfil(ine);
		if(gdp!=null)
			return true;

		return false;
	}
	
	public void setPOA(org.omg.CORBA.ORB orb) throws InvalidName, AdapterInactive
	{
		rootPOA=org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();
	}

	/****
	 * @name getInetfaceConnex 
	 * @description Récupérer l'interface de connexion
	 * 
	 * @return ConnexionIHM interfaceConnexion
	 ****/
	public ConnexionIHM getInetfaceConnex()
	{
		return interfaceConnexion;
	}
	

	/****
	 * @name getGDV 
	 * @description Récupérer le serveur GestionDeProfils
	 * 
	 * @return GestionDesVoeux gdv
	 ****/
	
	public GestionDesVoeux getGDV()
	{
		return gdv;
	}

	
	
	/***************** Fonction ajoutées
	 * @throws UtilisationInterdite 
	 * @throws DonneesInvalides ******************/
	/****
	 * @name fairVoeux  
	 * @description envoie un nouveau voeu à la gestion des voeux et  met à jour l'affichage du client
	 * 
	 * @param Voeu : voeu a ajouter
	 * @param String : ine étudiant
	 * @param short : numero du voeu correspond a l'ordre
	 * @return void
	 ****/	
	public void fairVoeux(Voeu vx, String INE,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.faireUnVoeu(INE, vx, ordre));
	}
	/****
	 * @name modifierVoeu  
	 * @description modifie l'ordre d'un voeu en l'envoyant à la gestion des voeux et met à jour l'affichage du client
	 * 
	 * @param String : ine étudiant
	 * @param short : position du voeu concerné
	 * @param short : nouvelle position du voeu
	 * @return void
	 ****/	
	public void modifierVoeu(String INE,short numeroVoeux,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.modifierVoeu(INE, numeroVoeux, ordre));
	}
	/****
	 * @name modifierVoeu  
	 * @description envoie à la gestion des voeux la demande de suppression de ce voeu et met à jour l'affichage du client
	 * 
	 * @param String : INE étudiant
	 * @param short : position du voeu concerné
	 * @return void
	 ****/	
	public void supprimerVoeu(String INE,short numeroVoeux) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.supprimerVoeux(INE, numeroVoeux));
	}
	/****
	 * @name modifierVoeu  
	 * @description On répond OUI, NON, OUI MAIS, NON MAIS à un voeu en le transmettant à la gestion des voeux
	 * 
	 * @param String : ine étudiant
	 * @param short : position du voeu concerné
	 * @param decision : réponse d'un étudiant a un voeu
	 * @return void
	 ****/	
	public void repondreAunVoeu(String ine, short numVoeu, decision choixEtu) throws DonneesInvalides, UtilisationInterdite
	{
		gdv.repondreAuxPropositions(ine, choixEtu, numVoeu);
	}
	/**
	 * @name getINE  
	 * @description Récupérer l'ine de l'étudiant
	 * 
	 * @return String : ine
	 */
	public String getINE()
	{
		return INE;
	}
	/****
	 * @name inscription  
	 * @description On inscrit un etudiant gràce à son INE. On lui ajoute seulement un mot de passe.
	 * 
	 * @param String : ine
	 * @param String : mot de passe
	 * @return Boolean : Vrai si inscription validée
	 ****/
	public boolean inscription(String ine, String mdp) throws DonneesInvalides
	{
		
		if(setGestionDesProfils(ine))
		{
			return gdp.inscriptionEtudiant(ine, mdp);
		}
		else
		{
			System.out.println("Probleme récup GDP");
			return false;
		}
	}
	/****
	 * @name lancementVague  
	 * @description modifier l'interface d'un etudiant lorsqu'une vague est lancée
	 * 
	 * @param String : numero de vague a lancer
	 * @return void
	 ****/
	@Override
	public void lancementVague(short numero) {
		// TODO Auto-generated method stub
		if(numero == 1)
		{
			cl.lancementVague1();
		}
		else if(numero == 2)
		{
			cl.lancementVague2();
		}
	}

	/* Main : On lance une interface et on l'inscrit à la liste des interfaces connectées */
	public static void main(String[] args) throws RemoteException, InvalidName, AdapterInactive {
		EtudiantIMPl etu=new EtudiantIMPl();
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		etu.setPOA(orb);
		etu.getInetfaceConnex().setVisible(true);

		orb.run();
	}
	/****
	 * @name deconnexion  
	 * @description Retirer l'interface de la liste des interfaces connectées
	 * 
	 * @param String : ine d'un etudiant
	 * @return void
	 ****/
	public void deconnexion (String ine){
		gdv.deconnexion(ine);
	}


}
