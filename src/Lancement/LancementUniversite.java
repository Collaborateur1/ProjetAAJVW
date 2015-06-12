package Lancement;

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
		
		
		UniversiteIMPL univ= new UniversiteIMPL("UT3","rectorat",orb);
		System.out.println("univ UT3 operationel");
		

		dossierEtudiant detu3 = dossetu.creerDossierEtudiant("Dupond", "jean", "G103");
		univ.ajouterEtudiant("G103", detu3);
		dossierEtudiant detu4 =dossetu.creerDossierEtudiant("merde", "PD", "G104");
		univ.ajouterEtudiant("G103", detu4);
		
		Formation fr= new Formation("jespere"," NomFormation", "TypeFormation", "nomRectorat", (short)2);
		
		Voeu voeuEtu = new Voeu(fr,etatvoeux.soumis,decision.NONutilse,(short)1);
		Voeu voeuEtu2 = new Voeu(fr,etatvoeux.soumis, decision.NONutilse,(short)1);
		Voeu voeuEtu3 = new Voeu(fr,etatvoeux.soumis,decision.NONutilse,(short)1);
		Voeu voeuEtu4 = new Voeu(fr,etatvoeux.soumis, decision.NONutilse,(short)1);
		
		Etudiant etu=new Etudiant("patric","francoi","G101","UT3","la rue",fr);
		

		
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
		univ.ajouterEtudiant(etu.ineEtudiant, detu);
		System.out.println("etudiant 2 rajouter");
		
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
		
		System.out.println("etudiant 1 rajouter");
		//univ.ajouterFormation(fr);
		
		univ.envoyerCandidatureD(detu, etu.ineEtudiant, voeuEtu);
		univ.envoyerCandidatureD(detu2, etu2.ineEtudiant, voeuEtu2);
	    univ.envoyerCandidatureD(detu3, "G103", voeuEtu3);
	    univ.envoyerCandidatureD(detu4, "G104", voeuEtu4);
	    univ.deliberationJury();
		univ.affichage();
		System.out.println("etat voeu etudiant G101: " +voeuEtu.etatVoeu);
		System.out.println("etat voeu etudiant G102 " +voeuEtu2.etatVoeu);
		System.out.println("etat voeu etudiant G103: " +voeuEtu3.etatVoeu);
		System.out.println("etat voeu etudiant G104: " +voeuEtu4.etatVoeu);
		fr.quota = 3;
		univ.deliberationFinal();
		System.out.println("etat voeu etudiant G101: " +voeuEtu.etatVoeu);
		System.out.println("etat voeu etudiant G102 " +voeuEtu2.etatVoeu);
		System.out.println("etat voeu etudiant G103: " +voeuEtu3.etatVoeu);
		System.out.println("etat voeu etudiant G104: " +voeuEtu4.etatVoeu);

		
		orb.run();

	}

}
