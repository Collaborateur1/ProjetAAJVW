package Lancement;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.Formation;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.GestionDesProfilsIMPL;

public class LancementGDP {

	public LancementGDP(org.omg.CORBA.ORB orb) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive
	{
		
	}
	
	
	public static void main(String[] args) throws DonneesInvalides, InvalidName, ServantNotActive, WrongPolicy, ServantAlreadyActive, AdapterInactive {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
        short numGPD=1;
		GestionDesProfilsIMPL gdpimpl=new GestionDesProfilsIMPL(numGPD,orb,"rectorat");
		
		orb.run();
	}

}
