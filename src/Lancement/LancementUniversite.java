package Lancement;

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

public class LancementUniversite {

	public static void main(String[] args) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		
		UniversiteIMPL univ= new UniversiteIMPL("UT3","rectorat",orb);
		System.out.println("univ UT3 operationel");
		Formation fr= new Formation("jespere"," NomFormation", "TypeFormation", "nomRectorat", (short)10);
		Etudiant etu=new Etudiant("patric","francoi","G101","UT3","la rue",fr);
		Resultat result=new Resultat((short)1,15, (short)10,(short)5);
		Resultat result2=new Resultat((short)2,14, (short)10,(short)4);
		Resultat result3=new Resultat((short)3,13, (short)10,(short)6);
		Resultat result4=new Resultat((short)4,16, (short)10,(short)1);
		Resultat result5=new Resultat((short)5,12, (short)10,(short)10);
		Resultat result6=new Resultat((short)5,11, (short)10,(short)9);
		
		Resultat[] resultt = new Resultat[6];
		
			resultt[0]=result;
			resultt[1]=result2;
			resultt[2]=result3;
			resultt[3]=result4;
			resultt[4]=result5;
			resultt[5]=result6;
			
		
		
		
		
		
		dossierEtudiant detu=new dossierEtudiant(etu, resultt);
		
		System.out.println("etudiant rajouter");
		orb.run();

	}

}
