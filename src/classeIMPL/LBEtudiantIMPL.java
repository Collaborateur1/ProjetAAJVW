package classeIMPL;


import java.util.Enumeration;
import java.util.Hashtable;

import org.omg.CORBA.ORB;

import outils.NamingServiceTool;
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
	/**
	 * name -getProfil retourne une GDV en fonction du premier chiffre de l'ine passé en paramètre
	 * 
	 * @param String : ine
	 * @return GestionDesProfils: une GDP
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public GestionDesProfils getProfil(String ine) throws DonneesInvalides {
		
		if(ine.startsWith("1")) //si ine commence par "1"
	    {
			return listGDP.get("1");
	    }
		else//si ine commence par "2" ou n'importe quoi d'autre
		{
			return listGDP.get("2");	
		}

	}
	/**
	 * name -getServProfil Retourne la GDV correspondant au numéro passé en paramètre
	 * 
	 * @param short: numéro gdv
	 * @return GestionDesProfils : Une GDP
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public GestionDesProfils getServProfil(short num) throws DonneesInvalides {
		return listGDP.get(String.valueOf(num));
	}

	/**
	 * name -inscriptionGDP Enregistrement de la GDP dans le LoadBalancer
	 * 
	 * @param GestionDesProfils : une GDP
	 * @param : et son numéro associé
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public void inscriptionGDP(GestionDesProfils iorGestionDesProfils, short numero) throws DonneesInvalides {
		listGDP.put(String.valueOf(numero), iorGestionDesProfils);
	}
	
	public static void main(String[] args) {
	}

	/**
	 * name -getAllGDP Permet de connaitre toutes les GDP
	 * 
	 * @return GestionDesProfils[]: tableaux de toutes les GDP
	 * @author jean-vincent
	 * @date 20/05/2015
	 * @note
	 */	
	@Override
	public GestionDesProfils[] getAllGDP() {
		GestionDesProfils[] tabGDP = new GestionDesProfils[listGDP.size()];
		Enumeration<GestionDesProfils> lesGDP = listGDP.elements();
		int i=0;
		
		while(lesGDP.hasMoreElements())
		{
			tabGDP[i] = lesGDP.nextElement();
			i++;
		}
		return tabGDP;
	}

}
