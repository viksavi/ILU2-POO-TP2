package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = false;
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(!nomVendeurConnu) {
			StringBuilder message = new StringBuilder();
			message.append("Je suis désolée ");
			message.append(nomVendeur);
			message.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(message.toString());
		} else {
			StringBuilder message2 = new StringBuilder();
			message2.append("Bonjour ");
			message2.append(nomVendeur);
			message2.append(", je vais regarder si je peux vous trouver un étal.");
			System.out.println(message2.toString());
			boolean etalDisponible = false;
			etalDisponible = controlPrendreEtal.resteEtals();
			
			if(!etalDisponible) {
				StringBuilder message3 = new StringBuilder();
				message3.append("Désolée ");
				message3.append(nomVendeur);
				message3.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(message3.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		message.append("C'est parfait, il me reste un étal pour vous !\n");
		message.append("Il me faudrait quelques renseignements\n");
		message.append("Quel produit souhaitez-vous vendre? ");
		System.out.println(message.toString());
		String produit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre? ");
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			StringBuilder result = new StringBuilder();
			result.append("Le vendeur ");
			result.append(nomVendeur);
			result.append(" s'est installé à l'étal nº ");
			result.append(numeroEtal);
			System.out.println(result.toString());
		}
		
	}
}
