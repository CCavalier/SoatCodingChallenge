package fr.ccavalier.soatchallenge.domain;

public class Coordonnee {
	/**
	 * Ligne
	 */
	int ligne;
	/**
	 * Colonne
	 */
	int colonne;
	
	
	public Coordonnee(int ligne, int colonne){
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public Coordonnee(){
	}
	
	public int getLigne() {
		return ligne;
	}


	public void setLigne(int ligne) {
		this.ligne = ligne;
	}


	public int getColonne() {
		return colonne;
	}


	public void setColonne(int colonne) {
		this.colonne = colonne;
	}


	public boolean equals(Coordonnee obj) {
		return obj.getColonne()==this.getColonne() && obj.getLigne()==this.getLigne();
	}
	
	public String toString() {
		return "["+this.getLigne()+","+this.getColonne()+"]";
	}
}
