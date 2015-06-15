package Databases;

import generated.Etudiant;
import generated.Formation;

public class BDDEtudiantHelper {
	String mdp;
	Etudiant etu;
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Etudiant getEtu() {
		return etu;
	}
	public void setEtu(Etudiant etu) {
		this.etu = etu;
	}
	
	public BDDEtudiantHelper( String nomEtu, String prenom, String ineetu, String nomUniv ,String nomUnivf , String NomFormation,String typeFormation,String nomRectorat,String mdp,short quota,String adress) {
		super();
		this.mdp = mdp;
		this.etu =new Etudiant(nomEtu, prenom, ineetu, nomUniv, adress, new Formation(nomUnivf, NomFormation, typeFormation, nomRectorat, quota));
	}


}
