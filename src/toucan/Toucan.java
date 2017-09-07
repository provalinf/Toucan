package toucan;

import toucan.modele.Modele;

public class Toucan {

	public static void main(String[] args) {
		Modele mod = new Modele();
		mod.creerCase(0,2,1);
		mod.creerCase(5,0,2);
		mod.creerCase(10,0,3);
		mod.creerLesMouvements();
	}
}
