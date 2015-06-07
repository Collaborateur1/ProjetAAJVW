package devON;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LancementGDP {

	public LancementGDP(org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive
	{
		short sh=1;
		GestionDesProfilsIMPL gdpimpl=new GestionDesProfilsIMPL(sh,orb);
		Formation fr= new Formation("jespere"," NomFormation", "TypeFormation", "nomRectorat");
		Etudiant etu=new Etudiant("patric","francoi","G101","UT3","la rue",fr);
		gdpimpl.setProfil(etu);
		Formation fr2= new Formation("jespere2"," NomFormation2", "TypeFormation2", "nomRectorat2");
		 etu=new Etudiant("jv","boss","G102","UT1","la volga",fr2);
		 gdpimpl.setProfil(etu);
	}
	
	
	public static void main(String[] args) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
        short sh=1;
		GestionDesProfilsIMPL gdpimpl=new GestionDesProfilsIMPL(sh,orb);
		Formation fr= new Formation("jespere"," NomFormation", "TypeFormation", "nomRectorat");
		Etudiant etu=new Etudiant("patric","francoi","G101","UT3","la rue",fr);
		gdpimpl.setProfil(etu);

		Formation fr2= new Formation("jespere2"," NomFormation2", "TypeFormation2", "nomRectorat2");
		
		 etu=new Etudiant("Alex","boss2","F423","UT3","far away",fr2);

		 gdpimpl.setProfil(etu);
		orb.run();
	}

}
