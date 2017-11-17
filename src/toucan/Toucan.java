package toucan;

import toucan.modele.Modele;
import toucan.view.*;

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

		mod.creerLesMouvements(1, Modele.NORD, 30, 2, Modele.SUD, 30, 1, Modele.EST, 80, 2, Modele.STABLE, 80, 2, Modele.OUEST, 80, 1, Modele.SUD, 30, 2, Modele.NORD, 30);
		System.out.println(mod);
	}*/

	private Toucan() {
		super("Toucan animé");
		setLayout(new BorderLayout());
		setResizable(true);
		setMinimumSize(new Dimension(400, 200));

		Observable model = new Modele();
		ViewGraphique vueGraph = new ViewGraphique(model);

		setJMenuBar(new ViewMenubar(model, vueGraph.getPanAnim()));
		add(new ViewToolbarTop(model, vueGraph.getPanAnim()), BorderLayout.PAGE_START);
		add(vueGraph, BorderLayout.CENTER);
		add(new ViewEditorPane(model), BorderLayout.WEST);
		add(new ViewToolbarBottom(model, vueGraph.getPanAnim()), BorderLayout.PAGE_END);
		Modele modele = (Modele) model;

		modele.creerCase(200, 60, 3);
		modele.creerCase(280, 60, 5);
		modele.creerCase(360, 60, 2);
		modele.creerCase(440, 60, 4);
		modele.creerVariable(10, 300, 0); //Case de stockage pour swap
		//modele.creerVariable(10, 360, 0); //Case de stockage pour swap
		//modele.genererMouvements();
		//modele.creerLesMouvements();
		/*Thread creerMouv = new Thread((Runnable) modele, "Toucan");
		creerMouv.start();*/

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//System.out.println(model.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Toucan::new);
	}
}
