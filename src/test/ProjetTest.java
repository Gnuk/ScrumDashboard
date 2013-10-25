package test;

import static org.junit.Assert.*;
import model.Projet;

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
	public void constructeurNomVideTest() throws IllegalArgumentException {
		Projet p = new Projet("", 400f);
	}

	/**
	 * Test le constructeur si le nom passé est null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructeurNomNullTest() throws IllegalArgumentException {
		Projet p = new Projet(null, 400f);
	}
}
