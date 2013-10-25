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
		Projet p = new Projet("Refonte de l'interface pour tablettes", 100);
		UserStory us = new UserStory("refonte du tunnel d'achat", 40);
		boolean trouvee = false;
		p.ajouterStory(us);
		for (UserStory usList : p.getStories()) {
			if (usList == us) {
				trouvee = true;
				assertTrue(us.getEtatUserStory() == EtatUserStory.PLANIFIEE);
			}
		}
		assertTrue(trouvee);
	}

	@Test
	public void testCreerUserStoryNonPlanifiee() throws Exception {
		Projet p = new Projet("Refonte de l'interface pour tablettes", 100);
		UserStory us = new UserStory("refonte du tunnel d'achat", 0);
		p.ajouterStory(us);
		boolean trouvee = false;
		for (UserStory usList : p.getStories()) {
			if (usList == us) {
				trouvee = true;
				assertTrue(us.getEtatUserStory() == EtatUserStory.NOUVELLE);
			}
		}
		assertTrue(trouvee);
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

}
