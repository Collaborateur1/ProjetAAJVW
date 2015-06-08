package devON;

import generated.DonneesInvalides;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LancementGDV {

	public static void main(String[] args) throws InvalidName, ServantNotActive, WrongPolicy, DonneesInvalides, AdapterInactive {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		short sh=1;
		GestionDesVoeuxIMPL gdv= new GestionDesVoeuxIMPL(sh, orb);
		orb.run();
	}

}
