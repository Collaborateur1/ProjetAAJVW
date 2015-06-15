package Lancement;

import java.sql.SQLException;
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

import Databases.BDDEtudiantHelper;
import Databases.BddHelperFormation;
import Databases.DBGestionDesProfils;
import classeIMPL.UniversiteIMPL;

public class LancementUniversite {

	public static void main(String[] args) throws DonneesInvalides, InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		CreationDossierEtudiant dossetu = null;

		UniversiteIMPL univ1= new UniversiteIMPL("UT1","rectorat",orb);
		UniversiteIMPL univ2= new UniversiteIMPL("UT2","rectorat",orb);
		UniversiteIMPL univ3= new UniversiteIMPL("UT3","rectorat",orb);
		System.out.println("Université UT1 opérationnelle");
		System.out.println("Université UT2 opérationnelle");
		System.out.println("Université UT3 opérationnelle");

		orb.run();
	}

}
