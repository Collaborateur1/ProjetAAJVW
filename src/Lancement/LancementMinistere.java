
package Lancement;

import generated.DonneesInvalides;
import generated.Formation;
import generated.Rectorat;
import generated.RectoratHelper;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.MinistereIMPL;

public class LancementMinistere {

	public static void main(String[] args) throws InvalidName, DonneesInvalides, ServantNotActive, WrongPolicy, AdapterInactive {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		MinistereIMPL ministere= new MinistereIMPL(orb);
		
	
		System.out.println("ministere  operationel");
		orb.run();
	}

}
