package devON;


import java.util.Hashtable;

import org.omg.CORBA.ORB;

import generated.DonneesInvalides;
import generated.GestionDesProfils;
import generated.GestionDesVoeux;
import generated.LoadBalancerEtudiantPOA;

public class LBEEtudiantIMPL extends LoadBalancerEtudiantPOA {
	
	Hashtable<Short,GestionDesProfils> listGDP;
	/*********************Costructeur******************************/
	
public LBEEtudiantIMPL(org.omg.CORBA.ORB orb) {
		// TODO Auto-generated constructor stub
 listGDP= new 	Hashtable<Short,GestionDesProfils>();
 NamingServiceTool.putReferenceIntoNS(orb,"LBL", this);
	}
	
	/*********************Fonction généré******************************/
	@Override
	public GestionDesProfils getProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
		if(ine.indexOf("G1")!=-1) //si ine contient "G1"  on renvoi GDP1 sinon GDP2 (on fait deux GDP pour linstant)
	    {
		 return listGDP.get(1);
	    }
		else if(ine.indexOf("G1")!=-1)
		{
		 return listGDP.get(2);	
		}
		
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
		listGDP.put(numero, iorGestionDesProfils);
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
	
	
		
	}
}
