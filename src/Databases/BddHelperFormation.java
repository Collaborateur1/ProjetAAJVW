package Databases;

import java.util.ArrayList;

import generated.Formation;

public class BddHelperFormation {

	Formation fr;
	ArrayList prerequis;
	
	public BddHelperFormation(Formation fr ) {
		super();
		this.fr = fr;
		this.prerequis = new ArrayList<String>();
	}
	
	
	public Formation getFr() {
		return fr;
	}
	public void setFr(Formation fr) {
		this.fr = fr;
	}
	public ArrayList getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(ArrayList prerequis) {
		this.prerequis = prerequis;
	}
	
	public void addPrerequis(String prerequis) {
		this.prerequis.add(prerequis);
	}

	
}
