package outils;

import generated.DonneesInvalides;
import generated.Minist�re;
import generated.Minist�reHelper;

public class test {

	public static void main(String[] args) throws DonneesInvalides {
		// TODO Auto-generated method stub

		Minist�re ministere= Minist�reHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
	
	}

}
