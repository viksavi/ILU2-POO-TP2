package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;
	private Gaulois bonemine;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 4);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
		
	}

	@Test
	void testVerifierIdentite() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertFalse(controlAcheterProduit.verifierIdentite("Panoramix"));
		assertTrue(controlAcheterProduit.verifierIdentite(bonemine.getNom()));
	}

	@Test
	void testIsVendeur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertFalse(controlAcheterProduit.isVendeur(abraracourcix.getNom()));
		assertTrue(controlAcheterProduit.isVendeur(bonemine.getNom()));
	}

	@Test
	void testProduitExiste() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertNull(controlAcheterProduit.produitExiste("miel"));
		assertNotNull(controlAcheterProduit.produitExiste("fleurs"));
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		assertEquals(controlAcheterProduit.acheterProduit(bonemine.getNom(), 5), 4);
		assertEquals(controlAcheterProduit.acheterProduit(bonemine.getNom(), 2), 0);
	}

	@Test
	void testAfficherVendeurs() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		Gaulois[] vendeurs = { bonemine };
		assertEquals(controlAcheterProduit.afficherVendeurs(vendeurs), "1 - Bonemine\n");
	}

	@Test
	void testTrouverGaulois() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		Gaulois[] vendeurs = { bonemine };
		assertNull(controlAcheterProduit.trouverGaulois(vendeurs, 2));
		assertNotNull(controlAcheterProduit.trouverGaulois(vendeurs, 1));
	}

}
