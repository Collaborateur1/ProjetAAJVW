package Lancement;

import generated.DonneesInvalides;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.RectoratIMPL;

public class LancementRectorat {
	
public static void main(String[] args) throws DonneesInvalides, ServantNotActive, WrongPolicy, InvalidName, AdapterInactive {
	
	org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);

	RectoratIMPL recto = new RectoratIMPL(orb,"rectorat");
	System.out.println("rectorat operationel");
	orb.run();
}
}