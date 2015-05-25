package devON;

import PostLicence.DonneesInvalides;
import PostLicence.GestionDesProfils;
import PostLicence.LoadBalancerEtudiantPOA;

public class LBEEtudiantIMPL extends LoadBalancerEtudiantPOA {

	@Override
	public GestionDesProfils getProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GestionDesProfils getServProfil(short num) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscriptionGDP(GestionDesProfils iorGestionDesProfils,
			short numero) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		LBEEtudiantIMPL lbeEtudiant	= new LBEEtudiantIMPL();
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0],null);
		//le NamingServiceTool fait le boulot d'enregistrer l'objet lbeEtudiant dans le NS
		// parametre 1=orb parametre 2= nom dans le NS 3= L'objet
		NamingServiceTool.putReferenceIntoNS(orb,"LBEEtudiant", lbeEtudiant);
		orb.run();
	}
}
