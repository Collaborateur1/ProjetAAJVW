package devON;

import java.util.ArrayList;

import generated.Etudiant;
import generated.IEtudiantPOA;
import generated.Voeu;

public class EtudiantIMPl extends IEtudiantPOA{
	Client cli;
	Voeu[] LesVoeux;
	String MotdePasse;
	Etudiant etu;
	/**********Constructeur************/
	
	public EtudiantIMPl(Client cl)
	{
		cli = cl;
	}
	
	/********fonction généré******/
	@Override
	public void notifier(String message) {
		// TODO Auto-generated method stub
		System.out.println (message);
		
	}

	@Override
	public void majEtatVoeux(Voeu[] listeVoeux) {
		// TODO Auto-generated method stub
		for(int i = 0; i<=listeVoeux.length; i++){
			for (int j = 0; j<=LesVoeux.length;j++){
				if(listeVoeux[i].numeroVoeu == LesVoeux[j].numeroVoeu)
					LesVoeux[i].etatVoeu = listeVoeux[i].etatVoeu;
			}
		}
	}
	
	public GestionDesVoeuxIMPL ConnexionGDP(String INE, String mdp)
	{
		//Constructeur Gestion des voeux
		/*GestionDesVoeuxIMPL GestVoeux = new GestionDesVoeux(INE);
		if(this.MotdePasse.equals(mdp)){
			return GestVoeux;
		}*/
		return null;
	}

	
	/*************Fonction rajouter****************/
	/*
	public ArrayList ConsulterProfilGDP(String INE)
	{
		return null;
	}
	
	public Seq ConsulterProfilGDP(String INE)
	{
		return null;
	}
	**/

}
