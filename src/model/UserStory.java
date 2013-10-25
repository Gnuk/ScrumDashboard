package model;

public class UserStory {
	private String name;
	private double resteAFaire;
	private double charge;
	public enum Etat{
		PLANIFIEE,
		NOUVELLE,
		REJETEE,
		FERMEE
	}
	
	public UserStory(String name, double resteAFaire, double charge) {
		this.name = name;
		this.resteAFaire = resteAFaire;
		this.charge = charge;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
