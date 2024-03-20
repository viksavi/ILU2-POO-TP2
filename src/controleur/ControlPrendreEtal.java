package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		boolean etalDisponible = false;
		etalDisponible = village.rechercherEtalVide();
		return etalDisponible;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		int numeroEtal = -1;
		numeroEtal = village.installerVendeur(village.trouverHabitant(nomVendeur), produit, nbProduit) + 1;
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		boolean nomVendeurConnu = false;
		nomVendeurConnu = controlVerifierIdentite.verifierIdentite(nomVendeur);
		return nomVendeurConnu;
	}
}
