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
		
		Runnable ministere = new Runnable() {
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

		Thread mini=new Thread(ministere);
		mini.start();


		Thread.sleep(1000);


		Runnable recto1 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="rectorat";
					LancementRectorat.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread rect1=new Thread(recto1);
		rect1.start();

		Thread.sleep(1000);
		
		Runnable recto2 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="rectorat2";
					LancementRectorat.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread rect2=new Thread(recto2);
		rect2.start();

		Thread.sleep(1000);

		
		Runnable unive1 = new Runnable() {
			public void run() {
				try {
					
					String[]st=new String[1];
					st[0]="UT3";
					
					LancementUniversite.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread univ1=new Thread(unive1);
		univ1.start();

		Thread.sleep(1000);	
		
		Runnable unive2 = new Runnable() {
			public void run() {
				try {
					
					String[]st=new String[1];
					st[0]="UT1";
					LancementUniversite.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};
		
		Thread univ2=new Thread(unive2);
		univ2.start();

		Thread.sleep(1000);	
		
		
		Runnable unive3 = new Runnable() {
			public void run() {
				try {
					
					String[]st=new String[1];
					st[0]="UT2";
					LancementUniversite.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread univ3=new Thread(unive3);
		univ3.start();

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
		
		
		/*Thread.sleep(1000);
		
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
		t7.start();*/
		

	}

}
