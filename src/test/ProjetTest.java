package test;

import static org.junit.Assert.*;
import model.Projet;
import model.UserStory;

import org.junit.Test;

public class ProjetTest {

	/**
	 * Test le constructeur avec des paramètres conformes à ceux attendus
	 * 
	 * @throws Exception
	 */
	@Test
	public void constructeurNormalTest() throws Exception {
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
	public void constructeurNomVideTest() throws Exception {
		Projet p = new Projet("", 400f);
	}

	/**
	 * Test le constructeur si le nom passé est null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructeurNomNullTest() throws Exception {
		Projet p = new Projet(null, 400f);
	}
	
	/**
	 * Test ajouterStory dans les conditions normales
	 * 
	 * @throws Exception
	 */
	@Test
	public void ajouterStoryNormalTest() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);
		
		UserStory story = new UserStory("refonte du tunnel d'achat", 40);
		
		int nbStories = p.getStories().size();
		
		p.ajouterStory(story);
	
		assertTrue(nbStories+1 == p.getStories().size());
		assertEquals(story, p.getStories().get(0));
	}
	
	/**
	 * Test ajouterStory dans les conditions normales
	 * 
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void ajouterStoryDoublonTest() throws Exception {
		Projet p = new Projet("refonte de l'interface graphique", 400f);
		
		UserStory story = new UserStory("refonte du tunnel d'achat", 40);
		UserStory story2 = new UserStory("refonte du tunnel d'achat", 40);
		
		p.ajouterStory(story);
		// Le nom de story2 est identique a story, on attend une illegalArgumentException
		p.ajouterStory(story2);
	}
}
