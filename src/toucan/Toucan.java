package toucan;

import toucan.modele.Modele;
import toucan.view.ViewGraphique;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class Toucan extends JFrame {

	/*public static void main(String[] args) {
		Modele mod = new Modele(3);
		mod.creerCase(2, 2, 1);
		mod.creerCase(2, 2, 2);
		mod.creerCase(3, 3, 3);
		mod.creerCase(4, 4, 4);

		mod.creerLesMouvements(0, Modele.NORD, 5, 0, Modele.SUD, 10, 0, Modele.EST, 10, 1, Modele.STABLE, 10, 1, Modele.SUD, 10);
		System.out.println(mod);
	}*/

	private Toucan() {
		super("Toucan animé");
		setLayout(new BorderLayout());
		setResizable(true);
		setMinimumSize(new Dimension(400, 200));

		Observable model = new Modele();

		add(new ViewGraphique(model), BorderLayout.CENTER);

		((Modele) model).creerCase(200, 60, 3);
		((Modele) model).creerCase(280, 60, 5);
		((Modele) model).creerCase(360, 60, 2);
		((Modele) model).creerCase(440, 60, 4);
		((Modele) model).creerVariable(10, 300, 0); //Case de stockage pour swap
		((Modele) model).creerVariable(10, 360, 0); //Case de stockage pour swap
		((Modele) model).creerLesMouvements(1, Modele.NORD, 30, 2, Modele.SUD, 30, 1, Modele.EST, 80, 2, Modele.STABLE, 80, 2, Modele.OUEST, 80, 1, Modele.SUD, 30, 2, Modele.NORD, 30);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//System.out.println(model.toString());
	}

	public static void main(String[] args) {
		new Toucan();
	}
}
