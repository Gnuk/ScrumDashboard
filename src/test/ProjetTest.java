package test;

import static org.junit.Assert.*;
import model.Projet;

import org.junit.Test;

public class ProjetTest {

	/**
	 * Test le constructeur avec des paramètres conformes à ceux attendus
	 */
	@Test
	public void constructeurNormalTest() {
		Projet p;
		
		try {
			p = new Projet("refonte de l'interface graphique", 400f);
			
			assertTrue(p.getEtat() == Projet.Etat.OUVERT);
			assertFalse(p.getNom() == null);
			assertFalse("".equals(p.getNom()));
		} catch (Exception e) { }
	}

	/**
	 * Test le constructeur si le nom passé est vide ou null
	 */
	@Test
	public void constructeurNomVideTest() {
		try {
			Projet p = new Projet("", 400f);
			fail("Nom vide interdit");
		} catch (Exception e) { }
		
		try {
			Projet p = new Projet(null, 400f);
			fail("Nom null interdit");
		} catch (Exception e) { }
	}
}
