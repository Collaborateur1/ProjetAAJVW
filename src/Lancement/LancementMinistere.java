
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
		
		Formation fr= new Formation("A","A", "A","A",(short)5);
		Formation fr1= new Formation("b","b", "b","b",(short)6);
		Formation fr2= new Formation("c","c", "c","c",(short)7);
		Formation fr3= new Formation("d","d", "d","d",(short)8);
		Formation fr4= new Formation("e","e", "e","e",(short)10);
		
		Formation[] fr0=new Formation[5];
		
		
			fr0[0]=fr;
			fr0[1]=fr1;
			fr0[2]=fr2;
			fr0[3]=fr3;
			fr0[4]=fr4;
			
		ministere.depotDesFormationsRectorat(fr0);
		
		
		System.out.println("ministere  operationel");
		orb.run();
	}

}
