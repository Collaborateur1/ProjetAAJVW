package devON;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import PostLicence.DonneesInvalides;
import PostLicence.Rectorat;
import PostLicence.RectoratHelper;

public class LancementServeur {

	public static void main(String[] args) throws InvalidName, DonneesInvalides, ServantNotActive, WrongPolicy {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		MinistereIMPL ministere= new MinistereIMPL(orb);
		RectoratIMPL recto=new RectoratIMPL(orb);
		
		org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		//on a créé recto notre rectorat..mais c'est un RectoratIMPL..or le ministere attend un Rectorat tt cours..
		//on utilise cette fonction pour faire la conversion
		Rectorat rect= RectoratHelper.narrow(rootPOA.servant_to_reference(recto));
		
		ministere.inscriptionRectorat(recto.nomRectorat(),rect);
		
		ministere.test();
		orb.run();
		
		
		
	}

}
