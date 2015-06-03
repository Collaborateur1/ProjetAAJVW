package devON;

import java.util.Hashtable;

import generated.DonneesInvalides;
import generated.Etudiant;
import generated.GestionDesProfilsPOA;
import generated.GestionDesVoeux;
import generated.IEtudiant;

public class GestionDesProfilsIMPL extends GestionDesProfilsPOA {
	short numGDP;
	Hashtable <String,IEtudiant>Etu;
	Hashtable<String,GestionDesVoeux>LesGDV;
	GestionDesVoeux GDV;
	EtudiantIMPl UnEtu;

	@Override
	public short numeroGDP() {
		// TODO Auto-generated method stub
		return numGDP;
	}

	@Override
	public GestionDesVoeux connexion(IEtudiant iorEtudiant, String ine,
			String mdp) throws DonneesInvalides {
		// TODO Auto-generated method stub
		if (UnEtu.etu.ineEtudiant.equals(ine) && UnEtu.MotdePasse.equals(mdp)){
		GDV.inscriptionIE(ine, iorEtudiant);
		Etu.put(ine, iorEtudiant);
	    GDV =LesGDV.get(String.valueOf(this.numeroGDP()));
		}
		return GDV;
	}

	@Override
	public Etudiant consulterProfil(String ine) throws DonneesInvalides {
		// TODO Auto-generated method stub
		if (UnEtu.etu.ineEtudiant.equals(ine)){
			return UnEtu.etu;
		}
		return null;
	}

	@Override
	public void modifierProfil(String ine, String adr) throws DonneesInvalides {
		// TODO Auto-generated method stub
		if (UnEtu.etu.ineEtudiant.equals(ine)){
			UnEtu.etu.adresse = adr;
		}
		
	}

	@Override
	public void inscriptionGestionDesVoeux(GestionDesVoeux GDesVx) {
		// TODO Auto-generated method stub
		LesGDV.put(String.valueOf(GDesVx.numeroGDV()),GDesVx);
	}

}
