package toucan.modele;

import toucan.LesCases;

public class Modele {

	private LesCases lesCases = new LesCases();

	public void creerLesMouvements() {
		lesCases.monter(0, 5);
		lesCases.droite(0, 10);
	}
}
