package devON;

import PostLicence.DonneesInvalides;
import PostLicence.Etudiant;
import PostLicence.GestionDesProfilsPOA;
import PostLicence.GestionDesVoeux;
import PostLicence.IEtudiant;

public class GestionDesProfilsIMPL extends GestionDesProfilsPOA {

	@Override
	public short numeroGDP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GestionDesVoeux connexion(IEtudiant iorEtudiant, String ine,
			String mdp) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant consulterProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierProfil(String ine, String adr) throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inscriptionGestionDesVoeux(GestionDesVoeux GDesVx) {
		// TODO Auto-generated method stub
		
	}

}
