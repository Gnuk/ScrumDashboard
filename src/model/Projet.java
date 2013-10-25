package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.UserStory.EtatUserStory;

public class Projet implements Observer {

	public enum Etat {
		OUVERT, FERME
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

	/**
	 * Ajoute une story
	 * @param story
	 */
	public void ajouterStory(UserStory story) {
		// Vérifie si la story n'existe pas déjà, si non, on lève une excéption 
		if (!isStoryAlreadyExisting(story)) {
			// On regarde si la nouvelle tâche fait dépasser le budget, si c'est le cas, son statut passe de PLANIFIER à NOUVELLE
			if (calculerChargeTotale() + story.getCharge() > budget)
				story.setEtatUserStory(EtatUserStory.NOUVELLE);
			this.stories.add(story);
			// Ajout de l'observer
			story.addObserver(this);
		} else
			throw new IllegalArgumentException(
					"Le nom de la story est déjà attribué");
	}

	/**
	 * Calcul de l'avancement total du projet
	 * @return L'avancement
	 */
	public double calculerAvancement() {
		double avancement = 0f;

		for (UserStory story : stories) {
			avancement += story.getResteAFaire();
		}

		return avancement;
	}

	/**
	 * Calcul de la charge totale du projet
	 * @return La charge
	 */
	public double calculerChargeTotale() {
		double charge = 0f;

		for (UserStory story : stories) {
			// On ne compte que les story PLANIFIEE
			if (story.getEtatUserStory() == EtatUserStory.PLANIFIEE)
				charge += story.getCharge();
		}

		return charge;
	}

	@Override
	public void update(Observable o, Object arg) {
		verifierRAF();
	}

	/**
	 * Passe l'état à FERMER lorsque le reste à faire est égal à 0
	 */
	public void verifierRAF() {
		if (this.calculerAvancement() == 0)
			this.setEtat(Etat.FERME);
	}

	/**** PRIVATE ****/

	private boolean isStoryAlreadyExisting(UserStory newStory)
			throws IllegalArgumentException {
		for (UserStory story : stories) {
			if (story.getNom().equals(newStory.getNom()))
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
