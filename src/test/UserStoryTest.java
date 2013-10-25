package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.Projet;
import model.UserStory;
import model.UserStory.EtatUserStory;

import org.junit.Test;

public class UserStoryTest {

	@Test
	public void testCreerUserStoryPlanifiee() {
		try {
			Projet p = new Projet("Refonte de l'interface pour tablettes",100);
			UserStory us = new UserStory("refonte du tunnel d'achat", 40);
			boolean trouvee = false;
			p.ajouterStory(us);
			for(UserStory usList : p.getStories()){
				if(usList == us){
					trouvee = true;
					assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
				}
			}
			assertTrue(trouvee);
		} catch (Exception e) {
			fail("Test creer user story planifiee");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreerUserStoryNonPlanifiee() {
		try {
			Projet p = new Projet("Refonte de l'interface pour tablettes",100);
			UserStory us = new UserStory("refonte du tunnel d'achat", 0);
			p.ajouterStory(us);
			boolean trouvee = false;
			for(UserStory usList : p.getStories()){
				if(usList == us){
					trouvee = true;
					assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
				}
			}
			assertTrue(trouvee);
		} catch (Exception e) {
			fail("Test creer user story non planifiee");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNomNull(){
		try {
		   UserStory us = new UserStory(null, 40);
		   fail("nom null");
		} 
		catch (Throwable t) {
		}
	}
	
	@Test
	public void testNomVide(){
		try {
			   UserStory us = new UserStory(null, 40);
			   fail("nom vide");
			} 
		catch (Throwable t) {
			}
	}
	
	@Test
	public void testRAFCharge(){
		try {
			   UserStory us = new UserStory(null, 40);
			   assertTrue(us.getCharge() == us.getResteAFaire());
			} 
		catch (Throwable t) {
			}
	}

}
