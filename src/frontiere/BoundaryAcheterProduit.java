package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = false;
		nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		
		if(!nomAcheteurConnu) {
			StringBuilder message = new StringBuilder();
			message.append("Je suis désolée ");
			message.append(nomAcheteur);
			message.append(" mais il faut être un habitant de notre village pour acheter ici.");
			System.out.println(message.toString());
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			Gaulois[] vendeurs = controlAcheterProduit.produitExiste(produit);
			if(vendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				StringBuilder message2 = new StringBuilder();
				message2.append("Chez quel commercant voulez-vous acheter des ");
				message2.append(produit);
				message2.append(" ?\n");
				message2.append(controlAcheterProduit.afficherVendeurs(vendeurs));
				int numEtal = Clavier.entrerEntier(message2.toString());
				Gaulois vendeur = controlAcheterProduit.trouverGaulois(vendeurs, numEtal);
				if(vendeur == null) {
					System.out.println("Ce commercant n'existe pas!\n");
				} else {
					acheterProduit(nomAcheteur, vendeur.getNom(), produit);
				}
			}
		}
	}
	
	public void acheterProduit(String nomAcheteur, String nomVendeur, String produit) {
		StringBuilder message3 = new StringBuilder();
		message3.append(nomAcheteur);
		message3.append(" se déplace jusqu'à l'étal du vendeur Bonemine\n");
		message3.append("Bonjour ");
		message3.append(nomAcheteur);
		message3.append("\n");
		message3.append("Combien de ");
		message3.append(produit);
		message3.append(" voulez-vous acheter ?");
		int nbAchat = Clavier.entrerEntier(message3.toString());
		int nbExist = controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
		produitExist(nbAchat, nbExist, nomVendeur, nomAcheteur, produit);
	}
	
	public void produitExist(int nbAchat, int nbExist, String nomVendeur, String nomAcheteur, String produit) {
		StringBuilder result = new StringBuilder();
		if(nbExist == 0) {
			result.append(nomAcheteur);
			result.append(" veut acheter ");
			result.append(nbAchat);
			result.append(" ");
			result.append(produit);
			result.append(", malheureusement il n'y en a plus !");
		} else if(nbExist == nbAchat) {
			result.append(nomAcheteur);
			result.append(" achete ");
			result.append(nbAchat);
			result.append(" ");
			result.append(produit);
			result.append(" à ");
			result.append(nomVendeur);
		} else if(nbExist < nbAchat) {
			result.append(nomAcheteur);
			result.append(" veut acheter ");
			result.append(nbAchat);
			result.append(" ");
			result.append(produit);
			result.append(", malheureusemnt ");
			result.append(nomVendeur);
			result.append(" n'en a plus que ");
			result.append(nbExist);
			result.append(". ");
			result.append(nomAcheteur);
			result.append(" achète tout le stock de ");
			result.append(nomVendeur);
			result.append(".");
		}
		System.out.println(result.toString());
	}
}
