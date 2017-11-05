package toucan.view;

import toucan.modele.Modele;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewToolbar extends JToolBar implements Observer {

	public ViewToolbar(Observable model) {
		model.addObserver(this);
		setFloatable(false);
		init((Modele) model);
	}

	private void init(Modele m) {
		JButton playPause = (JButton) add(new JButton("Play/Pause"));
		playPause.addActionListener(e -> {
			if (m.isThreadLaunch()) {
				m.inversThreadState();
			} else {
				Thread creerMouv = new Thread((Runnable) m, "Toucan");
				creerMouv.start();
			}
		});
		JButton stop = (JButton) add(new JButton("Stop"));
		stop.addActionListener(e -> m.stopAndReset());
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
