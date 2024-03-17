package frontiere;

import javax.naming.spi.DirStateFactory.Result;

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
			for(int i = 0; i < infosMarche.length; i++) {
				result.append("- ");
				result.append(infosMarche[i]);
				i++;
				result.append(" qui vend ");
				result.append(infosMarche[i]);
				i++;
				result.append(" ");
				result.append(infosMarche[i]);
			}
			System.out.println(result.toString());
		}

	}
}
