package Lancement;

import java.rmi.RemoteException;

import generated.DonneesInvalides;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import classeIMPL.EtudiantIMPl;

public class LancementGeneral {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Runnable r1 = new Runnable() {
			public void run() {

				try {
					LancementMinistere.main(null);
				} catch (InvalidName | DonneesInvalides | ServantNotActive
						| WrongPolicy | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t1=new Thread(r1);
		t1.start();


		Thread.sleep(1000);


		Runnable r2 = new Runnable() {
			public void run() {
				try {
					LancementRectorat.main(null);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread t2=new Thread(r2);
		t2.start();

		Thread.sleep(1000);

		Runnable r22 = new Runnable() {
			public void run() {
				try {
					LancementUniversite.main(null);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread t22=new Thread(r22);
		t22.start();

		Thread.sleep(1000);	



		Runnable r3 = new Runnable() {
			public void run() {

				LancementLoadB.main(null);

			}
		};

		Thread t3=new Thread(r3);
		t3.start();

		Thread.sleep(1000);

		Runnable r4 = new Runnable() {
			public void run() {
				try {
					LancementGDP.main(null);
				} catch (DonneesInvalides | InvalidName | ServantNotActive
						| WrongPolicy | ServantAlreadyActive | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
			}
		};

		Thread t4=new Thread(r4);
		t4.start();



		Thread.sleep(1000);




		Runnable r5 = new Runnable() {
			public void run() {
				try {
					LancementGDV.main(null);
				} catch (InvalidName | ServantNotActive | WrongPolicy
						| DonneesInvalides | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           
			}
		};

		Thread t5=new Thread(r5);
		t5.start();
		
		Runnable r6 = new Runnable() {
			public void run() {
				LancementVague.main(null);
			}
		};

		Thread t6=new Thread(r6);
		t6.start();
		
		
		Thread.sleep(1000);
		
		Runnable r7 = new Runnable() {
			public void run() {
				try {
					EtudiantIMPl.main(null);
				} catch (RemoteException | InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t7=new Thread(r7);
		t7.start();
		

	}

}
