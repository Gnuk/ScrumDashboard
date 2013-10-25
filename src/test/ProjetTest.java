package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Projet;
import model.Projet.Etat;
import model.UserStory;
import model.UserStory.EtatUserStory;

import org.junit.Test;

public class ProjetTest {

	/**
	 * Test le constructeur avec des paramètres conformes à ceux attendus
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConstructeurNormal() throws Exception {
		Projet p;
		p = new Projet("refonte de l'interface graphique", 400f);

		assertTrue(p.getEtat() == Projet.Etat.OUVERT);
		assertFalse(p.getNom() == null);
		assertFalse("".equals(p.getNom()));
	}

	/**
	 * Test le constructeur si le nom passé est vide
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurNomVide() throws Exception {
		new Projet("", 400f);
	}

	/**
	 * Test le constructeur si le nom passé est null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurNomNull() throws Exception {
		new Projet(null, 400f);
	}

	/**
	 * Test ajouterStory dans les conditions normales
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAjouterStoryNormal() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);

		int nbStories = p.getStories().size();

		p.ajouterStory(story);

		assertTrue(nbStories + 1 == p.getStories().size());
		assertEquals(story, p.getStories().get(0));
	}

	/**
	 * Test ajouterStory avec doublons
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjouterStoryDoublon() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);
		UserStory story2 = new UserStory("refonte du tunnel d'achat", 50);

		p.ajouterStory(story);
		// Le nom de story2 est identique a story, on attend une
		// illegalArgumentException
		p.ajouterStory(story2);
	}

	/**
	 * Test calculerAvancement dans les conditions normales
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalculerAvancementNormal() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory storyTunnel = new UserStory("refonte du tunnel d'achat", 50);
		UserStory storyRespDesign = new UserStory(
				"refonte de l'ergonomie responsive design", 100);

		// On ajoute deux stories au projet
		p.ajouterStory(storyTunnel);
		p.ajouterStory(storyRespDesign);

		assertTrue(p.calculerAvancement() == 150);

		// On modifie le reste a faire, le total doit être modifié
		storyTunnel.setResteAFaire(45);
		assertTrue(p.calculerAvancement() == 145);

		storyRespDesign.setResteAFaire(90);
		assertTrue(p.calculerAvancement() == 135);
	}

	/**
	 * Test qui ferme le projet si les RAF de toutes les US == 0
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVerifierRAFNull() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 10);
		UserStory story2 = new UserStory("refonte de l'ergonomie en responsive design", 40);

		p.ajouterStory(story);
		p.ajouterStory(story2);

		story.setEtatUserStory(EtatUserStory.NOUVELLE);
		assertTrue(p.getEtat() == Etat.OUVERT);
		story2.setResteAFaire(0);
		System.out.println(p.calculerAvancement());
		assertTrue(p.getEtat() == Etat.FERME);

	}


	/**
	 * Test qui calcul la charge total du projet
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalculerChargeTotaleNormal() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);
		UserStory story2 = new UserStory("refonte du tunnel d'achat bis", 40);

		p.ajouterStory(story);
		p.ajouterStory(story2);

		assertTrue(p.calculerChargeTotale() == 80);
	}
	
	/**
	 * Test qui calcul la charge total du projet, en faisant attention de ne compter que les tache plannifiees
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalculerChargeTotalePlannifiee() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);
		UserStory story2 = new UserStory("refonte du tunnel d'achat bis", 40);
		UserStory story3 = new UserStory("refonte du tunnel d'achat bis bis", 40);

		p.ajouterStory(story);
		p.ajouterStory(story2);
		p.ajouterStory(story3);
		

		assertTrue(p.calculerChargeTotale() == 120);
		
		story2.setEtatUserStory(EtatUserStory.NOUVELLE);		
		assertTrue(p.calculerChargeTotale() == 80);
		
		story3.setEtatUserStory(EtatUserStory.FERMEE);		
		assertTrue(p.calculerChargeTotale() == 40);
	}
	
	/**
	 * Test qui verifie qu'il n'y ait pas de memory leak (observer bien supprimé)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSupprimerStoryObserver() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);

		p.ajouterStory(story);

		int nbObs = story.countObservers();
		
		p.supprimerStory(story);
		
		assertTrue(nbObs -1 == story.countObservers());
	}
	
	/**
	 * Test qui verifie la suppression d'une story (story bien supprimée)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSupprimerStoryNormale() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);

		UserStory story = new UserStory("refonte du tunnel d'achat", 40);

		p.ajouterStory(story);
		
		int nbStories = p.getStories().size();
		
		p.supprimerStory(story);
		
		assertTrue(nbStories -1 == p.getStories().size());
	}
}
