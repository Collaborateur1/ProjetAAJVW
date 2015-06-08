package devON;


import java.util.Hashtable;

import org.omg.CORBA.ORB;

import generated.DonneesInvalides;
import generated.GestionDesProfils;
import generated.GestionDesVoeux;
import generated.LoadBalancerEtudiantPOA;

public class LBEtudiantIMPL extends LoadBalancerEtudiantPOA {
	
	Hashtable<String,GestionDesProfils> listGDP;
	/*********************Costructeur******************************/
	

	public LBEtudiantIMPL(org.omg.CORBA.ORB orb) {
			// TODO Auto-generated constructor stub
		listGDP= new Hashtable<String,GestionDesProfils>();
		NamingServiceTool.putReferenceIntoNS(orb,"LBE", this);

	}
	
	/*********************Fonction généré******************************/
	@Override
	public GestionDesProfils getProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		if(ine.indexOf("G1")!=-1) //si ine contient "G1"  on renvoi GDP1 sinon GDP2 (on fait deux GDP pour linstant)
	    {

			return listGDP.get("1");
	    }
		else
		{
			System.out.println("oui");
			return listGDP.get("2");	
			
		}

	}

	@Override
	public GestionDesProfils getServProfil(short num) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return listGDP.get(String.valueOf(num));
	}

	@Override
	public void inscriptionGDP(GestionDesProfils iorGestionDesProfils,
			short numero) throws DonneesInvalides {
		listGDP.put(String.valueOf(numero), iorGestionDesProfils);
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
	
	
		
	}
}
