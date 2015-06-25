package Lancement;

import java.sql.SQLException;
import java.util.ArrayList;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.Resultat;
import generated.dossierEtudiant;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import Databases.DBGestionDesProfils;
import Databases.DBUniversite;

public class remplissageBDD {

	DBUniversite bddUNIV;
	DBGestionDesProfils bddGDP;
	String nomUniv;
	
	public remplissageBDD(String nomUnivp)
	{
		System.out.println("Création de la BDD "+nomUnivp);
		bddUNIV = new DBUniversite(nomUnivp);
		bddGDP = new DBGestionDesProfils();
		nomUniv = nomUnivp;
		
		Formation fr1= new Formation("UT1","Miage", "Info Gest", "Midi Pyrenees", (short)2);
		Formation fr2= new Formation("UT1","MER", "Info Gest", "Midi Pyrenees", (short)2);
		Formation fr3= new Formation("UT2","Math", "Mathematique appliqué", "Languedoc", (short)2);
		Formation fr4= new Formation("UT2","SIAD", "Decisionnel", "Languedoc", (short)2);
		Formation fr5= new Formation("UT3","Meca", "Mecanique des fluide", "Midi Pyrenees", (short)2);
		Formation fr6= new Formation("UT3","GSI", "Info Gest", "Midi Pyrenees", (short)2);
		
		String []ListePrereq = new String[3];
		ListePrereq[0]= "DUT";
		ListePrereq[1]= "BTS";
		ListePrereq[2]= "Licence 2";
		
		if(nomUniv=="UT1")
		{
			dossierEtudiant detu1 = CreationDossierEtudiant.creerDossierEtudiant("Patrick", "François", "1PF001", nomUniv, fr2);
			dossierEtudiant detu2 = CreationDossierEtudiant.creerDossierEtudiant("DOSSANTOS", "Marc", "1DM001", nomUniv, fr3);
			dossierEtudiant detu3 = CreationDossierEtudiant.creerDossierEtudiant("CARTIER", "Axel", "1CA001", nomUniv, fr2);
			try {
				bddUNIV.ajouterEtudiant(detu1.etu.ineEtudiant, detu1);
				bddUNIV.ajouterEtudiant(detu2.etu.ineEtudiant, detu2);
				bddUNIV.ajouterEtudiant(detu3.etu.ineEtudiant, detu3);
				bddGDP.ajouterEtudiant(detu1.etu.ineEtudiant, detu1.etu);
				bddGDP.ajouterEtudiant(detu2.etu.ineEtudiant, detu2.etu);
				bddGDP.ajouterEtudiant(detu3.etu.ineEtudiant, detu3.etu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bddUNIV.ajouterFormation(fr1, ListePrereq);
				bddUNIV.ajouterFormation(fr2, ListePrereq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(nomUniv=="UT2")
		{
			dossierEtudiant detu4 = CreationDossierEtudiant.creerDossierEtudiant("GAINIER", "Clemence", "1GC001", nomUniv, fr3);
			dossierEtudiant detu5 = CreationDossierEtudiant.creerDossierEtudiant("VACHER", "Simon", "1VS001", nomUniv, fr2);
			dossierEtudiant detu6 = CreationDossierEtudiant.creerDossierEtudiant("LECOEUR", "Elise", "2LE001", nomUniv, fr3);
			try {
				bddUNIV.ajouterEtudiant(detu4.etu.ineEtudiant, detu4);
				bddUNIV.ajouterEtudiant(detu5.etu.ineEtudiant, detu5);
				bddUNIV.ajouterEtudiant(detu6.etu.ineEtudiant, detu6);
				bddGDP.ajouterEtudiant(detu4.etu.ineEtudiant, detu4.etu);
				bddGDP.ajouterEtudiant(detu5.etu.ineEtudiant, detu5.etu);
				bddGDP.ajouterEtudiant(detu6.etu.ineEtudiant, detu6.etu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bddUNIV.ajouterFormation(fr3, ListePrereq);
				bddUNIV.ajouterFormation(fr4, ListePrereq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			dossierEtudiant detu7 = CreationDossierEtudiant.creerDossierEtudiant("BOUBAKOUR", "Malik", "2BM001", nomUniv, fr2);
			dossierEtudiant detu8 = CreationDossierEtudiant.creerDossierEtudiant("DEVANNE", "Lucie", "2DL001", nomUniv, fr3);
			dossierEtudiant detu9 = CreationDossierEtudiant.creerDossierEtudiant("CLAUDIN", "Anthony", "2CA002", nomUniv, fr2);
			dossierEtudiant detu10 = CreationDossierEtudiant.creerDossierEtudiant("PONGE", "Anais", "2PA001", nomUniv, fr3);
			try {
				bddUNIV.ajouterEtudiant(detu7.etu.ineEtudiant, detu7);
				bddUNIV.ajouterEtudiant(detu8.etu.ineEtudiant, detu8);
				bddUNIV.ajouterEtudiant(detu9.etu.ineEtudiant, detu9);
				bddUNIV.ajouterEtudiant(detu10.etu.ineEtudiant, detu10);
				bddGDP.ajouterEtudiant(detu7.etu.ineEtudiant, detu7.etu);
				bddGDP.ajouterEtudiant(detu8.etu.ineEtudiant, detu8.etu);
				bddGDP.ajouterEtudiant(detu9.etu.ineEtudiant, detu9.etu);
				bddGDP.ajouterEtudiant(detu10.etu.ineEtudiant, detu10.etu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bddUNIV.ajouterFormation(fr5, ListePrereq);
				bddUNIV.ajouterFormation(fr6, ListePrereq);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/* JEUX DE TEST AVEC RESULTAT NON ALEATOIRE
			Etudiant etu2=new Etudiant("toto","titi","G102","UT3","lavenue",fr);

			Resultat resultat1=new Resultat((short)1,15, (short)10,(short)5);
			Resultat resultat2=new Resultat((short)2,14, (short)10,(short)4);
			Resultat resultat3=new Resultat((short)3,19, (short)10,(short)6);
			Resultat resultat4=new Resultat((short)4,16, (short)10,(short)1);
			Resultat resultat5=new Resultat((short)5,17, (short)10,(short)10);
			Resultat resultat6=new Resultat((short)6,14, (short)10,(short)9);

			Resultat[] resultats = new Resultat[6];

			resultats[0]=resultat1;
			resultats[1]=resultat2;
			resultats[2]=resultat3;
			resultats[3]=resultat4;
			resultats[4]=resultat5;
			resultats[5]=resultat6;

			dossierEtudiant detu2=new dossierEtudiant(etu2, resultats);

			Resultat result=new Resultat((short)1,15, (short)10,(short)5);
			Resultat result2=new Resultat((short)2,14, (short)10,(short)4);
			Resultat result3=new Resultat((short)3,13, (short)10,(short)6);
			Resultat result4=new Resultat((short)4,16, (short)10,(short)1);
			Resultat result5=new Resultat((short)5,12, (short)10,(short)10);
			Resultat result6=new Resultat((short)6,11, (short)10,(short)9);

			Resultat[] resultt = new Resultat[6];

			resultt[0]=result;
			resultt[1]=result2;
			resultt[2]=result3;
			resultt[3]=result4;
			resultt[4]=result5;
			resultt[5]=result6;
			Etudiant etu=new Etudiant("test","test","G101","UT1","lavenue",fr);
			dossierEtudiant detu=new dossierEtudiant(etu, resultt);
		 */
	}

	public static void main(String[] args) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		System.out.println("Lancement création BDD");
		remplissageBDD rbdd1 = new remplissageBDD("UT1");
		remplissageBDD rbdd2 = new remplissageBDD("UT2");
		remplissageBDD rbdd3 = new remplissageBDD("UT3");
		
	}
}
