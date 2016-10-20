package fr.ccavalier.soatchallenge.domain;

public class Coordonnee {
	/**
	 * Ligne
	 */
	int rs;
	/**
	 * Colonne
	 */
	int cs;
	/**
	 * @return la ligne
	 */
	public int getLigne() {
		return rs;
	}
	/**
	 * @param rs la ligne to set
	 */
	public void setRs(int rs) {
		this.rs = rs;
	}
	/**
	 * @return la colonne
	 */
	public int getColonne() {
		return cs;
	}
	/**
	 * @param cs la colonne to set
	 */
	public void setCs(int cs) {
		this.cs = cs;
	} 
	
	public boolean equals(Coordonnee obj) {
		return obj.getColonne()==this.getColonne() && obj.getLigne()==this.getLigne();
	}
}
