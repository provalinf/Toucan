package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ViewGraphique extends JPanel implements Observer {

	private PanneauAnimation panAnim;

	public ViewGraphique(Observable model) {
		model.addObserver(this);
		panAnim = new PanneauAnimation((Modele) model);
		init((Modele) model);
	}

	private void init(Modele m) {
		add(panAnim);
	}

	@Override
	public void update(Observable o, Object arg) {
		panAnim.repaint();
	}
}
