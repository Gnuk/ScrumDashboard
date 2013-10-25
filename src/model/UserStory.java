package model;

import java.util.Observable;

public class UserStory extends Observable{
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
	
	/**
	 * Change le reste à faire
	 * @param resteAFaire
	 * @throws IllegalArgumentException
	 */
	public void setResteAFaire(double resteAFaire) throws IllegalArgumentException{
		
		// La user story est modifiée uniquement si son statut est planifié et que le resteAFaire est > 0
		if(this.getEtatUserStory() == EtatUserStory.PLANIFIEE && resteAFaire>=0){
			
			this.resteAFaire = resteAFaire;
			this.setChanged();
			this.notifyObservers();
			if(this.getResteAFaire() == 0){
				
				this.setEtatUserStory(EtatUserStory.FERMEE);
			}
		}
		else{
			throw new IllegalArgumentException("Le RAF ne peut être changé à cause de sont état");
		}
	}
	/**
	 * Créé une nouvelle userStory
	 * @param nom
	 * @param charge
	 * @throws IllegalArgumentException
	 */
	public UserStory(String nom, double charge)
			throws IllegalArgumentException
	{
		if(nom != null && !nom.equals("")){
			if(charge > 0){
				this.setEtatUserStory(EtatUserStory.PLANIFIEE);
				this.setResteAFaire(charge);
			}else{
				this.setEtatUserStory(EtatUserStory.NOUVELLE);
			}
			this.setCharge(charge);
			this.setNom(nom);
		}else{
			throw new IllegalArgumentException("Nom ne doit pas �tre null");
		}
	}

	/**** GETTERS & SETTERS *****/

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getResteAFaire() {
		return resteAFaire;
	}
	public EtatUserStory getEtatUserStory() {
		return etatUserStory;
	}
	public void setEtatUserStory(EtatUserStory etatUserStory) {
		this.etatUserStory = etatUserStory;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
}
