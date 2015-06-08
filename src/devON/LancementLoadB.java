package devON;

import generated.Etudiant;

public class LancementLoadB {
public LancementLoadB(org.omg.CORBA.ORB orb){
		
		LBEtudiantIMPL lbl=new LBEtudiantIMPL(orb);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
     
		LBEtudiantIMPL lbl=new LBEtudiantIMPL(orb);
		
		orb.run();
	}

}
