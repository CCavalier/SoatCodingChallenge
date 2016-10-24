package fr.ccavalier.soatchallenge.domain;

public class Colis {
	Coordonnee position;
	
	boolean estLivre;
	
	public Colis(){
		
	}
	
	public Colis(Coordonnee position){
		this.position = position;
		estLivre=false;
	}

	/**
	 * @return the position
	 */
	public Coordonnee getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Coordonnee position) {
		this.position = position;
	}

	/**
	 * @return the estLivre
	 */
	public boolean isEstLivre() {
		return estLivre;
	}

	/**
	 * @param estLivre the estLivre to set
	 */
	public void setEstLivre(boolean estLivre) {
		this.estLivre = estLivre;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Colis) {
			return ((Colis)arg0).getPosition().equals(this.getPosition());
		}
		return super.equals(arg0);
	}
}
