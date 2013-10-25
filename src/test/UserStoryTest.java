package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.Projet;
import model.UserStory;
import model.UserStory.EtatUserStory;

import org.junit.Test;

public class UserStoryTest {

	@Test
	public void testCreerUserStoryPlanifiee() throws Exception {
		UserStory us = new UserStory("refonte du tunnel d'achat", 40);
		assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
	}

	@Test
	public void testCreerUserStoryNonPlanifiee() throws Exception {
		UserStory us = new UserStory("refonte du tunnel d'achat", 0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNomNull() throws IllegalArgumentException {
		UserStory us = new UserStory(null, 40);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNomVide() throws IllegalArgumentException {
		UserStory us = new UserStory(null, 40);
	}

	@Test
	public void testRAFCharge() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes",
				40);
		assertTrue(us.getCharge() == us.getResteAFaire());
	}
	
	@Test
	public void changeRAFUsPlanifiee() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes", 40);
		assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
		us.setResteAFaire(0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.FERMEE);
	}
	
	@Test
	public void changeRAFUsNouvelle() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes", 0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
		us.setResteAFaire(10);
		assertTrue(us.getResteAFaire() == 0);
	}
}
