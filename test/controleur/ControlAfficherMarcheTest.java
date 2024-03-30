package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
	}
	
	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertEquals(controlAfficherMarche.donnerInfosMarche().length, 0);
		village.installerVendeur(bonemine, "fleurs", 5);
		assertEquals(controlAfficherMarche.donnerInfosMarche()[0], bonemine.getNom());
		assertEquals(controlAfficherMarche.donnerInfosMarche()[1], "5");
		assertEquals(controlAfficherMarche.donnerInfosMarche()[2], "fleurs");
		village.partirVendeur(bonemine);
		String[] arrayVide = new String[0];
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(), arrayVide);
	}

}
