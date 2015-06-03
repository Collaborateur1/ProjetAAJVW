package devON;

import generated.DonneesInvalides;
import generated.Etudiant;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LancementGDP {

	public static void main(String[] args) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
        short sh=1;
		GestionDesProfilsIMPL gdpimpl=new GestionDesProfilsIMPL(sh,orb);
		Etudiant etu=new Etudiant("patric","francoi","G101","UT3","la rue",null);
		gdpimpl.setProfil(etu);
		 etu=new Etudiant("jv","boss","G102","UT1","la volga",null);
		 gdpimpl.setProfil(etu);
		orb.run();
	}

}
