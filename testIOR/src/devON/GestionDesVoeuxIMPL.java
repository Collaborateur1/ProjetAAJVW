package devON;

import PostLicence.DonneesInvalides;
import PostLicence.Formation;
import PostLicence.GestionDesVoeuxPOA;
import PostLicence.IEtudiant;
import PostLicence.UtilisationInterdite;
import PostLicence.Voeu;
import PostLicence.decision;

public class GestionDesVoeuxIMPL extends GestionDesVoeuxPOA{

	@Override
	public short numeroGDV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void inscriptionIE(String ine, IEtudiant iorEtudiant)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Formation[] rechercherFormation(String motscles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voeu[] chargerVoeux(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void faireUnVoeu(String ine, Voeu monVoeux, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repondreAuxPropositions(String ine, decision choixEtu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierVoeu(String ine, short numeroVoeu, short ordre)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerVoeux(String ine, short numeroVoeu)
			throws DonneesInvalides, UtilisationInterdite {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transmettreDecisionCandidatureRectorat(String ine, Voeu Reponse)
			throws DonneesInvalides {
		// TODO Auto-generated method stub
		
	}


}
