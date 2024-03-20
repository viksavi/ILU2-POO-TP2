package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder result = new StringBuilder();
			result.append(nomAcheteur);
			result.append(", vous trouverez au marché :\n");
			int i = 0;
			while(i < infosMarche.length) {
				result.append("- ");
				result.append(infosMarche[i]);
				i++;
				result.append(" qui vend ");
				result.append(infosMarche[i]);
				i++;
				result.append(" ");
				result.append(infosMarche[i]);
				i++;
				result.append("\n");
			}
			System.out.println(result.toString());
		}

	}
}
