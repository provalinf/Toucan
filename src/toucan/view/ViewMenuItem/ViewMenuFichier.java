package toucan.view.ViewMenuItem;

import toucan.modele.Modele;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewMenuFichier extends JMenu implements Observer {
	public ViewMenuFichier(Observable model) {
		super("Fichier");
		model.addObserver(this);
		init(model);
	}

	private void init(Observable model) {
		add(new JMenuItem("First item"));
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
