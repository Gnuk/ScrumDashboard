package model;

public class UserStory {
	private String name;
	private double resteAFaire;
	private double charge;
	public enum EtatUserStory{
		PLANIFIEE,
		NOUVELLE,
		REJETEE,
		FERMEE
	}
	private EtatUserStory etatUserStory;
	
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
	
	public UserStory(String name, double charge)
			throws Exception
	{
		if(name != null && !name.equals("")){
			if(charge > 0){
				this.setEtatUserStory(EtatUserStory.PLANIFIEE);
			}else{
				this.setEtatUserStory(EtatUserStory.NOUVELLE);
			}
			this.setCharge(charge);
			this.setName(name);
			this.setResteAFaire(charge);
		}else{
			throw new Exception("Nom ne doit pas être null");
		}
	}

	public EtatUserStory getEtatUserStory() {
		return etatUserStory;
	}

	public void setEtatUserStory(EtatUserStory etatUserStory) {
		this.etatUserStory = etatUserStory;
	}
	
}
