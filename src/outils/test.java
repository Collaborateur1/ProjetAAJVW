package outils;

import generated.DonneesInvalides;
import generated.Ministère;
import generated.MinistèreHelper;

public class test {

	public static void main(String[] args) throws DonneesInvalides {
		// TODO Auto-generated method stub

		Ministère ministere= MinistèreHelper.narrow(
				NamingServiceTool.getReferenceIntoNS("Ministere"));
	
	}

}
