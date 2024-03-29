package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		village.installerVendeur(bonemine, "fleurs", 10);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur(bonemine.getNom()));
		assertFalse(controlLibererEtal.isVendeur("Panoramix"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] expectedReturn = {"true", "Bonemine", "fleurs", "10", "0"};
		String[] testReturn = controlLibererEtal.libererEtal(bonemine.getNom());
		assertEquals(expectedReturn[0], testReturn[0]);
		assertEquals(expectedReturn[1], testReturn[1]);
		assertEquals(expectedReturn[2], testReturn[2]);
		assertEquals(expectedReturn[3], testReturn[3]);
		assertEquals(expectedReturn[4], testReturn[4]);
	}

}
