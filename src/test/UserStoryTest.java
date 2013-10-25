package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.Projet;
import model.UserStory;

import org.junit.Test;

public class UserStoryTest {

	@Test
	public void testCreerUserStory() {
		Projet p = new Projet("Refonte de l'interface pour tablettes",100);
		p.ajouterStory(new UserStory("refonte du tunnel d'achat", 40));
		for(UserStoryTest us : p.stories){
			
		}
	}
	
	@Test
	public void testNomNull(){
		Throwable caught = null;
		try {
		   UserStory us = new UserStory(null, 40);
		} catch (Throwable t) {
		   caught = t;
		}
		assertNotNull(caught);
		assertSame(Exception.class, caught.getClass());
	}
	
	@Test
	public void testNomVide(){
		Throwable caught = null;
		try {
		   UserStory us = new UserStory("", 40);
		} catch (Throwable t) {
		   caught = t;
		}
		assertNotNull(caught);
		assertSame(Exception.class, caught.getClass());
	}

}
