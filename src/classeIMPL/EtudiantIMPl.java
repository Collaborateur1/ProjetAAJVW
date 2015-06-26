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
	
   //il sagit de l'interface principale postbac
	Client cl; 
	GestionDesProfils gdp;
	ConnexionIHM interfaceConnexion;
	org.omg.PortableServer.POA rootPOA;
	GestionDesVoeux gdv;
	LoadBalancerEtudiant loadbalancer;
	ArrayList<Voeu> ListeVoeuxEtu;
	String INE;

	/**********Constructeur
	 * @throws RemoteException ************/	
	public EtudiantIMPl() throws RemoteException
	{
		this.cl=cl;
		cl=new Client(this);
		interfaceConnexion=new ConnexionIHM(this,cl);
		//On r�cup�re le LoadBalancer
		loadbalancer= LoadBalancerEtudiantHelper.narrow(NamingServiceTool.getReferenceIntoNS("LBE"));
		ListeVoeuxEtu=new ArrayList<Voeu>();
	}

	/********fonction g�n�r�******/
	
	/**
	 * name -notifier  Notifier l'�tudiant
	 * 
	 * @param String : Message � notifier
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	
	@Override
	public void notifier(String message) {
		// TODO Auto-generated method stub
		cl.notification(message);

	}

	/**
	 * name -majEtatVoeux  Mettre � jour l'�tat des Voeux
	 * 
	 * @param Voeu[] : Liste des voeux � m�ttres � jours
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void majEtatVoeux(Voeu[] Voeux) {
		// TODO Auto-generated method stub
		
		cl.miseAjourJlist2(Voeux);
	}



	

	/**
	 * name -ConnexionGDP  se connecter � la GDP
	 * 
	 * @param String : INE etudiant
	 * @param String : Mots de passe
	 * @return boolean : connexion effectuer ou non
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public boolean ConnexionGDP(String INE, String mdp) throws DonneesInvalides, ServantNotActive, WrongPolicy
	{
		IEtudiant etu;
		//ici on r�cupere la GDP de letudiant selon son ine
		if(setGestionDesProfils(INE))
		{
			//On teste si l'�tudiant � le droit de ce connecter
			if(gdp.autorisationConnexion(INE, mdp))
			{
				//On teste si l'�tudiant est d�j� connect� ou non
				if(gdp.etudiantInscrit(INE))
				{
					etu=IEtudiantHelper.narrow(rootPOA.servant_to_reference(this));
					gdv=gdp.connexion(etu, INE, mdp);
					//Si il poss�de des voeux on les charges dans l'interface
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

	/**
	 * name -getPostLicenceInterface  Obtenir la page principale li� � l'�tudiant
	 * 
	 * @return Client : l'interface graphique du client
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public Client getPostLicenceInterface()
	{
		return this.cl;
	}

	/**
	 * name -setGestionDesProfils  R�cup�r� le GDP avec le loadBalancer
	 * 
	 * @param String : ine de l'�tudiant
	 * @return boolean : ine de l'�tudiant
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	//On charge l'instance du loadBalancer
	public boolean setGestionDesProfils(String ine) throws DonneesInvalides
	{	
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

	public ConnexionIHM getInetfaceConnex()
	{
		return interfaceConnexion;
	}
	

	public GestionDesVoeux getGDV()
	{
		return gdv;
	}

	
	
	/***************** Fonction ajouter
	 * @throws UtilisationInterdite 
	 * @throws DonneesInvalides ******************/
	/**
	 * name -fairVoeux  On envoie un nouveau voeu � la gestion des voeux et on met � jour l'affichage du client
	 * 
	 * @param Voeu : voeu a ajouter
	 * @param String : ine �tudiant
	 * @param short : numero du voeux correspond a l'ordre
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public void fairVoeux(Voeu vx, String INE,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.faireUnVoeu(INE, vx, ordre));
	}
	/**
	 * name -modifierVoeu  On modifie l'ordre d'un voeux en l'envoyant � la gestion des voeux et on met � jour l'affichage du client
	 * 
	 * @param String : ine �tudiant
	 * @param short : position du voeu concern�
	 * @param short : nouvelle position du voeu
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public void modifierVoeu(String INE,short numeroVoeux,short ordre) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.modifierVoeu(INE, numeroVoeux, ordre));
	}
	/**
	 * name -modifierVoeu  On envoit � la gestion des voeux la demande de suppression de ce voeu et on met � jour l'affichage du client
	 * 
	 * @param String : ine �tudiant
	 * @param short : position du voeu concern�
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public void supprimerVoeu(String INE,short numeroVoeux) throws DonneesInvalides, UtilisationInterdite
	{
		int i=0;
		cl.miseAjourJlist2(gdv.supprimerVoeux(INE, numeroVoeux));
	}
	/**
	 * name -modifierVoeu  On r�pond OUI, NON, OUI MAIS, NON MAIS � un voeu en le transmettant � la gestion des voeux
	 * 
	 * @param String : ine �tudiant
	 * @param short : position du voeu concern�
	 * @param decision : r�ponse d'un �tudiant a un voeu
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	public void repondreAunVoeu(String ine, short numVoeu, decision choixEtu) throws DonneesInvalides, UtilisationInterdite
	{
		gdv.repondreAuxPropositions(ine, choixEtu, numVoeu);
	}
	/**
	 * name -getINE  retourne l'ine de l'�tudiant
	 * 
	 * @return String : ine
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	public String getINE()
	{
		return INE;
	}
	/**
	 * name -inscription  On inscrit un etudiant gr�ce � son INE. On lui ajout seulement un mot de passe.
	 * 
	 * @param String : ine
	 * @param String : mot de passe
	 * @return Boolean : validation de l'inscription ou non
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	public boolean inscription(String ine, String mdp) throws DonneesInvalides
	{
		
		if(setGestionDesProfils(ine))
		{
			return gdp.inscriptionEtudiant(ine, mdp);
		}
		else
		{
			System.out.println("Probleme r�cup GDP");
			return false;
		}
	}
	/**
	 * name -lancementVague  Cette fonction permet de modifier l'interface d'un etudiant lorsqu'une vague est lanc�e
	 * 
	 * @param String : numero de vague a lancer
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
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

	//On lance une interface et on l'inscrit � la liste des interfaces connect�es
	public static void main(String[] args) throws RemoteException, InvalidName, AdapterInactive {
		EtudiantIMPl etu=new EtudiantIMPl();
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		etu.setPOA(orb);
		etu.getInetfaceConnex().setVisible(true);

		orb.run();
	}
	/**
	 * name -deconnexion  On retire l'interface de la liste des interfaces connect�es
	 * 
	 * @param String : ine d'un etudiant
	 * @return void
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */
	public void deconnexion (String ine){
		gdv.deconnexion(ine);
	}


}
