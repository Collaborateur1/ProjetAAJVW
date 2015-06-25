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
					st[0]="Midi Pyrenees";
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
					st[0]="Languedoc";
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
		
		Runnable recto3 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="Provence";
					LancementRectorat.main(st);
				} catch (DonneesInvalides | ServantNotActive | WrongPolicy
						| InvalidName | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                 
			}
		};


		Thread rect3=new Thread(recto3);
		rect3.start();

		Thread.sleep(1000);

		
		Runnable unive1 = new Runnable() {
			public void run() {
				try {
					
					String[]st=new String[2];
					st[0]="UT3";
					st[1]="Midi Pyrenees";
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
					
					String[]st=new String[2];
					st[0]="UT1";
					st[1]="Midi Pyrenees";
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
					
					String[]st=new String[2];
					st[0]="UT2";
					st[1]="Languedoc";
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
		
		//Lancement de Gestion des Profils 1
		Runnable r41 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="1";
					LancementGDP.main(st);
				} catch (DonneesInvalides | InvalidName | ServantNotActive
						| WrongPolicy | ServantAlreadyActive | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
			}
		};

		Thread t41=new Thread(r41);
		t41.start();

		Thread.sleep(1000);
		
		//Lancement de Gestion des Profils 2
		Runnable r42 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="2";
					LancementGDP.main(st);
				} catch (DonneesInvalides | InvalidName | ServantNotActive
						| WrongPolicy | ServantAlreadyActive | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
			}
		};

		Thread t42=new Thread(r42);
		t42.start();

		Thread.sleep(1000);

		//Lancement Gestion des Voeux 1
		Runnable r51 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="1";
					LancementGDV.main(st);
				} catch (InvalidName | ServantNotActive | WrongPolicy
						| DonneesInvalides | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           
			}
		};

		Thread t51=new Thread(r51);
		t51.start();
		
		Thread.sleep(1000);

		//Lancement Gestion des Voeux 2
		Runnable r52 = new Runnable() {
			public void run() {
				try {
					String[]st=new String[1];
					st[0]="2";
					LancementGDV.main(st);
				} catch (InvalidName | ServantNotActive | WrongPolicy
						| DonneesInvalides | AdapterInactive e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           
			}
		};

		Thread t52=new Thread(r52);
		t52.start();
		
		Thread.sleep(1000);
		
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
