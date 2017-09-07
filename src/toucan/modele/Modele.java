package toucan.modele;

import toucan.Case;
import toucan.LesCases;

public class Modele {

	private LesCases lesCases = new LesCases();

	public void creerLesMouvements() {
		lesCases.monter(0, 5);
		//lesCases.monter(1, 5);
		//lesCases.monter(2, 5);
		//lesCases.droite(0, 10);
		System.out.println(lesCases.toString());
	}

	public  void creerCase(int xInit, int yInit, int val){
		lesCases.creerCases(xInit, yInit, val);
	}
}
