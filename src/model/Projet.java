package model;

import java.util.ArrayList;

public class Projet {

	public enum Etat {
		OUVERT,
		FERME
	}
	
	private String nom;
	private double budget;
	private Etat etat;
	private ArrayList<UserStory> stories;
	
	public Projet(String nom, double budget) throws Exception {
		if (nom == null || "".equals(nom))
			throw new Exception("Le nom n'est pas conforme");
		
		this.nom = nom;
		this.budget = budget;
		
		this.setEtat(Etat.OUVERT);
		this.stories = new ArrayList<UserStory>();
	}
	
	public void ajouterStory(UserStory story) {
		this.stories.add(story);
	}
	
	
	
	/**** GETTERS & SETTERS *****/
	
	public ArrayList<UserStory> getStories() {
		return stories;
	}

	public void setStories(ArrayList<UserStory> stories) {
		this.stories = stories;
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

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
}
