package model;

public class UserStory {
	private String nom;
	private double resteAFaire;
	private double charge;
	public enum EtatUserStory{
		PLANIFIEE,
		NOUVELLE,
		REJETEE,
		FERMEE
	}
	private EtatUserStory etatUserStory;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getResteAFaire() {
		return resteAFaire;
	}
	public void setResteAFaire(double resteAFaire) {
		this.resteAFaire = resteAFaire;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	public UserStory(String nom, double charge)
			throws IllegalArgumentException
	{
		if(nom != null && !nom.equals("")){
			if(charge > 0){
				this.setEtatUserStory(EtatUserStory.PLANIFIEE);
			}else{
				this.setEtatUserStory(EtatUserStory.NOUVELLE);
			}
			this.setCharge(charge);
			this.setNom(nom);
			this.setResteAFaire(charge);
		}else{
			throw new IllegalArgumentException("Nom ne doit pas être null");
		}
	}

	public EtatUserStory getEtatUserStory() {
		return etatUserStory;
	}

	public void setEtatUserStory(EtatUserStory etatUserStory) {
		this.etatUserStory = etatUserStory;
	}
	
}
