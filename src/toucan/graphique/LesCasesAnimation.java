package toucan.graphique;

import toucan.modele.Modele;

import java.awt.*;

public class LesCasesAnimation {

	private Modele modele;

	public LesCasesAnimation(Modele modele) {
		this.modele = modele;
		/*lesCases = new ArrayList<>(3);
		lesCases.add(new CaseAnimation("a", 120, 50, Color.blue));
		lesCases.add(new CaseAnimation("b", 170, 105, Color.magenta));
		lesCases.add(new CaseAnimation("c", 230, 70, new Color(0, 154, 0)));*/
	}

	public void dessiner(Graphics g, int tmps) {
		for (int i = 0; i < modele.getNbCases(); i++) {
			modele.getCase(i).dessiner(g, tmps);
		}
	}

}
