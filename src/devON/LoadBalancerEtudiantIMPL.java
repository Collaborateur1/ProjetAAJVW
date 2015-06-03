package devON;
import java.util.Hashtable;

import generated.*;

public class LoadBalancerEtudiantIMPL extends LoadBalancerEtudiantPOA{
	
	static Hashtable<String,GestionDesProfilsIMPL>listeDesServGestProfil;

	public LoadBalancerEtudiantIMPL(org.omg.CORBA.ORB orb) {
		
		super();
		// TODO Auto-generated constructor stub
		NamingServiceTool.putReferenceIntoNS(orb,"LoadBalancerEtudiant", this);
	}

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

	
}
