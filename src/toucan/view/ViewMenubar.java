package toucan.view;

import toucan.view.ViewMenuItem.ViewMenuAlgo;
import toucan.view.ViewMenuItem.ViewMenuFichier;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewMenubar extends JMenuBar implements Observer {

	public ViewMenubar(Observable model) {
		model.addObserver(this);
		init(model);
	}

	private void init(Observable m) {
		add(new ViewMenuFichier(m));
		add(new ViewMenuAlgo(m));
	}

	@Override
	public void update(Observable o, Object arg) {
		/*Runnable run = () -> {};
		if (SwingUtilities.isEventDispatchThread()) {
			run.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(run);
			} catch (InterruptedException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}*/
	}
}