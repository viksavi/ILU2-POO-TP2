package histoire;

import controleur.ControlAcheterProduit;
import controleur.ControlAfficherMarche;
import controleur.ControlAfficherVillage;
import controleur.ControlEmmenager;
import controleur.ControlLibererEtal;
import controleur.ControlPrendreEtal;
import controleur.ControlTrouverEtalVendeur;
import controleur.ControlVerifierIdentite;
import personnages.Chef;
import villagegaulois.Etal;
import villagegaulois.Village;

public class TestControleursDesCas {
	public static void main(String[] args) {
		
		Village village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		String obelix = "Obelix";
		String intrus = "Intrus";
		String separation = "///////////////////////////////";
		village.setChef(abraracourcix);

		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(
				village);


		System.out.println("Cas 2 : Emmenager");
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
		controlEmmenager.ajouterGaulois("Asterix", 6);
		controlEmmenager.ajouterGaulois(obelix, 12);
		String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();
		System.out.println("Les villageois sont : ");
		for (String villageois : nomsVillageois) {
			System.out.println("- " + villageois);
		}

		System.out.println(separation);
		System.out.println("Cas 3 : Verifier Identification");
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(
				village);
		boolean vendeur = controlVerifierIdentite.verifierIdentite("Panoramix");
		System.out.println("Panoramix est un villageois ? " + vendeur);
		vendeur = controlVerifierIdentite.verifierIdentite(intrus);
		System.out.println("Intrus est un villageois ? " + vendeur);

		System.out.println(separation);
		System.out.println("Cas 4 : Prendre etal");
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		int numeroEtal = controlPrendreEtal.prendreEtal(obelix, "fleur", 5);
		System.out.println("Obelix a pris l'étal n°" + numeroEtal);
		
		System.out.println(separation);
		System.out.println("Cas 5 : trouver etal vendeur");
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(
				village);
		Etal etalObelix = controlTrouverEtalVendeur
				.trouverEtalVendeur(obelix);
		Etal etalIntrus = controlTrouverEtalVendeur
				.trouverEtalVendeur(intrus);
		System.out.print("L'étal d'Obélix");
		if (etalObelix != null) {
			System.out.println(" est trouvé");
		} else {
			System.out.println(" n'est pas trouvé");
		}
		System.out.print("L'étal de Intrus");
		if (etalIntrus != null) {
			System.out.println(" est trouvé");
		} else {
			System.out.println(" n'est pas trouvé");
		}
		

		System.out.println(separation);
		System.out.println("Cas 6 : Liberer etal");
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(
				controlTrouverEtalVendeur);
		String[] ventesObelix = controlLibererEtal.libererEtal(obelix);
		System.out.println("Les ventes d'Obelix : ");
		System.out.println("[0] : un boolean indiquant si l'étal est occupé ");
		System.out.println("[1] : nom du vendeur");
		System.out.println("[2] : produit vendu");
		System.out.println(
				"[3] : quantité de produit à vendre au début du marché");
		System.out.println("[4] : quantité de produit vendu");
		for (String string : ventesObelix) {
			System.out.println(string);
		}
		String[] ventesIntrus = controlLibererEtal.libererEtal(intrus);
		System.out.println("Les ventes d'Intrus : " + ventesIntrus);
		
		System.out.println(separation);
		System.out.println("Cas 7 : Afficher Marche");
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(
				village);
		controlPrendreEtal.prendreEtal(obelix, "menhirs", 3);
		controlPrendreEtal.prendreEtal("Asterix", "poissons", 10);
		String[] marche = controlAfficherMarche.donnerInfosMarche();
		for (String etal : marche) {
			System.out.println(etal);
		}


		System.out.println(separation);
		System.out.println("Cas 8 : Acheter Produit");
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		System.out.println("Obelix a 3 menhir sur son etal");
		int nbProduitAcheter = controlAcheterProduit.acheterProduit(obelix,
				2);
		System.out.println("Achat de " + nbProduitAcheter + " menhirs sur 2");
		nbProduitAcheter = controlAcheterProduit.acheterProduit(obelix, 3);
		System.out.println("Achat de " + nbProduitAcheter + " menhirs sur 3");

	}

}
