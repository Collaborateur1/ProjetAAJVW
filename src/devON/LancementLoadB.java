package devON;

import generated.Etudiant;

public class LancementLoadB {
public LancementLoadB(org.omg.CORBA.ORB orb){
		
		LBEEtudiantIMPL lbl=new LBEEtudiantIMPL(orb);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
     
		LBEEtudiantIMPL lbl=new LBEEtudiantIMPL(orb);
		
		
		orb.run();

	}

}
