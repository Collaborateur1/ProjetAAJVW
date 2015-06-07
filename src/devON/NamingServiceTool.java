package devON;

import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.Servant;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class NamingServiceTool {

	/**
	 * @param args
	 */
	
	public static org.omg.CORBA.Object getReferenceIntoNS(String nameIntoNS) {
		//1
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		// 2
		
		try {
			org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
			// Recherche de l'objet
			org.omg.CosNaming.NameComponent[] Obj = new org.omg.CosNaming.NameComponent[1];
			Obj[0] = new org.omg.CosNaming.NameComponent(nameIntoNS,"");
			org.omg.CORBA.Object distantObject = nameRoot.resolve(Obj);
			System.out.println("Reférérence objet : " + nameIntoNS + " recuperee" );
			return distantObject;
		} catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			System.out.println("PROBLEME DANS LA RECHERCHE DU NOM AUPRES DU NS : " +  nameIntoNS);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}


	}

	public static void putReferenceIntoNS(org.omg.CORBA.ORB orb,String nameIntoNS, Servant objectToSave) {
		try {

			// 2
			org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// 4
			rootPOA.activate_object(objectToSave);

			// 5
			rootPOA.the_POAManager().activate();

			// 6
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];

			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nameIntoNS,"");

			org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(objectToSave));
			
			System.out.println("Reférérence objet : " + nameIntoNS + " enregistree" );
			
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServantAlreadyActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	public static Object activeObject (org.omg.CORBA.ORB orb ,Servant objectToActive) {
		try {

			// 2
			org.omg.PortableServer.POA rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// 4
			rootPOA.activate_object(objectToActive);

			// 5
			rootPOA.the_POAManager().activate();

			// 6
			rootPOA.servant_to_reference(objectToActive);
			
			System.out.println("Reférérence objet activee " );
						
			return rootPOA.servant_to_reference(objectToActive);

		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServantAlreadyActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}




}
