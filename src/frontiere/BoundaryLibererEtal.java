package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.getBoolean(donneesEtal[0]);
			if(!etalOccupe) {
				StringBuilder result = new StringBuilder();
				result.append("Vous avez vendu ");
				result.append(donneesEtal[4]);
				result.append(" sur ");
				result.append(donneesEtal[3]);
				result.append(" ");
				result.append(donneesEtal[2]);
				result.append(".\n");
				result.append("Au revoir ");
				result.append(nomVendeur);
				result.append(", passez une bonne journée");
				System.out.println(result.toString());
			}
		}
	}

}
