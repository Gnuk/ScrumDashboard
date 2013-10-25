package test;

import static org.junit.Assert.assertTrue;
import model.UserStory;
import model.UserStory.EtatUserStory;

import org.junit.Test;

public class UserStoryTest {

	@Test
	public void testUserStoryPlanifiee() throws Exception {
		UserStory us = new UserStory("refonte du tunnel d'achat", 40);
		assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
	}

	@Test
	public void testUserStoryNonPlanifiee() throws Exception {
		UserStory us = new UserStory("refonte du tunnel d'achat", 0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUserStoryNull() throws Exception {
		new UserStory(null, 40);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUserStoryVide() throws Exception {
		new UserStory(null, 40);
	}

	/**
	 * s'assure que le RAF initial == charge
	 * @throws Exception
	 */
	@Test
	public void testRAFCharge() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes",
				40);
		assertTrue(us.getCharge() == us.getResteAFaire());
	}

	/**
	 * test de la mise à jour du RAF pour une user story planifié.
	 * @throws Exception
	 */
	@Test
	public void testSetRAFUserStoryPlanifiee() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes",
				40);
		assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
		us.setResteAFaire(0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.FERMEE);
	}
	/**
	 * test de la mise à jour du RAF pour une user story nouvelle.
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetRAFUserStoryNouvelle() throws Exception {
		UserStory us = new UserStory("Refonte de l'interface pour tablettes", 0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
		us.setResteAFaire(10);
		assertTrue(us.getResteAFaire() == 0);
		assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
	}
}
