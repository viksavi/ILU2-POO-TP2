package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		boolean nomAcheteurConnu = false;
		nomAcheteurConnu = controlVerifierIdentite.verifierIdentite(nomAcheteur);
		return nomAcheteurConnu;
	}
	
	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return (etal != null);
	}
	
	public Gaulois[] produitExiste(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String nomGaulois, int nbAcheter) {
		Gaulois gaulois = village.trouverHabitant(nomGaulois);
		Etal etal = village.rechercherEtal(gaulois);
		return etal.acheterProduit(nbAcheter);
	}
	
	public String afficherVendeurs(Gaulois[] vendeurs) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < vendeurs.length; i++) {
			result.append(i+1);
			result.append(" - ");
			result.append(vendeurs[i].getNom());
			result.append("\n");
		}
		return result.toString();
	}
	
	public Gaulois trouverGaulois(Gaulois[] vendeurs, int numEtal) {
		if(numEtal-1 >= 0 && numEtal - 1 < vendeurs.length) {
			return vendeurs[numEtal-1];
		}
		return null;
	}
}
