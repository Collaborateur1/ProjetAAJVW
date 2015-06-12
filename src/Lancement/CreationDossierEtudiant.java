package Lancement;

import java.util.ArrayList;
import java.util.Random;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.Resultat;
import generated.dossierEtudiant;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.UniversiteIMPL;

public class CreationDossierEtudiant {
	
	public static dossierEtudiant creerDossierEtudiant(String nom, String prenom, String ine)
	{
		Formation f= new Formation("UT3","MIAGE", "Info-Gestion", "Midi-pyrenees", (short)30);
		Etudiant etu=new Etudiant(nom,prenom,ine,"UT3","adresse test",f);
		
		Random rand = new Random();
		int note = 0, classement =0,nbResultat = 6;
		Resultat[] tabResult = new Resultat[nbResultat];
		for(int i = 0;i<nbResultat;i++)
		{
			classement = rand.nextInt(40 - 0 + 1) + 0;
			note = rand.nextInt(20 - 0 + 1) + 0;
			tabResult[i] = new Resultat((short)i,note, (short)10,(short)classement);
		}
		
		dossierEtudiant de = new dossierEtudiant(etu, tabResult);
		return de;
	}

	public static void main(String[] args) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		System.out.println("Test d'ajout d'étudiant");
		dossierEtudiant de = creerDossierEtudiant("Alex", "Combe", "XB3635");
		System.out.println("Fin Test d'ajout d'étudiant");
	}
}
