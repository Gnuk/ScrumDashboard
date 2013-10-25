package model;

public class Projet {

	private String nom;
	public enum Etat {
		OUVERT,
		FERME
	}
	private double budget;
	
	public Projet(String nom, double budget) {
		this.nom = nom;
		this.budget = budget;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
}
