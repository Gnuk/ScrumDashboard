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
	
	public Projet(String nom, double budget) throws IllegalArgumentException {
		if (nom == null || "".equals(nom))
			throw new IllegalArgumentException("Le nom n'est pas conforme");
		
		this.nom = nom;
		this.budget = budget;
		
		this.setEtat(Etat.OUVERT);
		this.stories = new ArrayList<UserStory>();
	}
	
	public void ajouterStory(UserStory story) {
		if (!isStoryAlreadyExisting(story))
			this.stories.add(story);
		else
			throw new IllegalArgumentException("Le nom de la story est déjà attribué");
	}
	
	public double calculerAvancement() {
		for (UserStory story : stories) {
			
		}
		return 1f;
	}
	
	/**** PRIVATE ****/
	
	private boolean isStoryAlreadyExisting(UserStory newStory) throws IllegalArgumentException {
		for (UserStory story : stories) {
			if ( story.getNom().equals(newStory.getNom()))
				return true;
		}
		return false;
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
