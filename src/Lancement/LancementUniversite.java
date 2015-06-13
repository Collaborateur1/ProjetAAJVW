package Lancement;

import java.util.ArrayList;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;
import generated.Resultat;
import generated.Voeu;
import generated.decision;
import generated.dossierEtudiant;
import generated.etatvoeux;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.UniversiteIMPL;

public class LancementUniversite {

	public static void main(String[] args) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		CreationDossierEtudiant dossetu = null;
		
		if(args[0].equals("UT1"))
		{
			

			UniversiteIMPL univ2= new UniversiteIMPL("UT1","rectorat",orb);
			System.out.println("univ UT1 operationel");
			
			Formation fr2= new Formation("UT1","Miage", "TypeFormation", "rectorat", (short)2);
			Formation fr3= new Formation("UT1","NomFormation", "TypeFormation", "rectorat", (short)2);
			
	Etudiant etu=new Etudiant("patric","francoi","G101","UT1","la rue",fr3);
		
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
				
			
			dossierEtudiant detu=new dossierEtudiant(etu, resultt);
			univ2.ajouterEtudiant(etu.ineEtudiant, detu);
			String []ListePrereq = new String[1];
			ListePrereq[0]= "DUT";
			univ2.ajouterFormation(fr2,ListePrereq);
			System.out.println("univ UT1 operationel");
			
		}
		else if(args[0].equals("UT3"))
		{
			UniversiteIMPL univ= new UniversiteIMPL("UT3","rectorat",orb);
			System.out.println("univ UT3 operationel");
			Formation fr= new Formation("UT3","NomFormation", "TypeFormation", "rectorat", (short)2);
			Formation frr= new Formation("UT3","chimi", "TypeFormation", "rectorat", (short)2);
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
			univ.ajouterEtudiant(etu2.ineEtudiant, detu2);
			System.out.println("etudiant 2 rajouter");
			String []ListePrereq = new String[1];
			ListePrereq[0]= "NomFormation";
			univ.ajouterFormation(frr,ListePrereq);
		}
		else if(args[0].equals("UT2"))
		{
			UniversiteIMPL univ= new UniversiteIMPL("UT2","rectorat2",orb);
			System.out.println("univ UT2 operationel");
			Formation fr= new Formation("UT2","NomFormation", "TypeFormation", "rectorat2", (short)2);
			Formation frf= new Formation("UT2","math", "TypeFormation", "rectorat2", (short)2);
			Etudiant etu2=new Etudiant("toto","titi","G105","UT2","lavenue",fr);
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
			univ.ajouterEtudiant(etu2.ineEtudiant, detu2);
			System.out.println("etudiant 2 rajouter");
			String []ListePrereq = new String[1];
			ListePrereq[0]= "NomFormation";
			univ.ajouterFormation(frf,ListePrereq);
		}
		

		orb.run();
	}

}
