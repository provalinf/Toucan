package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Valentin.
 */
public class ViewToolbar extends JToolBar implements Observer {

	private PanneauAnimation panAnim;
	private JButton debut, playPause, stop, fin;
	private JSlider slideControl, slideSpeed;

	public ViewToolbar(Observable model, PanneauAnimation panAnim) {
		model.addObserver(this);
		this.panAnim = panAnim;
		setFloatable(false);
		init((Modele) model);
	}

	private void init(Modele m) {
		debut = (JButton) add(new JButton("Début"));
		debut.addActionListener(e -> {
			panAnim.defineDebTemps();
			m.refreshUI();
		});

		playPause = (JButton) add(new JButton("Play/Pause"));
		playPause.addActionListener(e -> {
			if (!m.isThreadLaunch() && !m.isMouvCalc()) {
				panAnim.setPause(false);
				m.genererMouvements();
			} else {
				panAnim.inversPause();
			}
			m.refreshUI();
		});
		stop = (JButton) add(new JButton("Stop"));
		stop.addActionListener(e -> {
			m.stopAndReset();
			panAnim.resetAndInit();
			m.refreshUI();
		});

		fin = (JButton) add(new JButton("Fin"));
		fin.addActionListener(e -> {
			panAnim.defineFinTemps();
			m.refreshUI();
		});

		slideControl = (JSlider) add(new JSlider(0, 100, 1));
		slideControl.addChangeListener(e -> {
			panAnim.defineCustomTemps(slideControl.getValue());
			m.refreshUI();
		});


		JLabel lent = (JLabel) add(new JLabel("Lent"));
		slideSpeed = (JSlider) add(new JSlider(0, 14, 1));
		slideSpeed.addChangeListener(e -> {
			m.setVitesseAnimation(slideSpeed.getMaximum() - slideSpeed.getValue());
		});
		slideSpeed.setMajorTickSpacing(1);
		slideSpeed.setPaintTicks(true);
		JLabel speed = (JLabel) add(new JLabel("Rapide"));

		setButtonState(m);
	}

	private void setButtonState(Modele m) {
		debut.setEnabled(m.getMaxTemps() > 0 && !panAnim.isStart());
		playPause.setText(panAnim.isPause() ? "Play" : "Pause");
		stop.setEnabled(m.getMaxTemps() > 0);
		fin.setText(m.isMouvCalc() ? "Fin" : "Tous les mouvements ne sont pas calculés");
		fin.setEnabled(m.getMaxTemps() > 0 && m.isMouvCalc() && !panAnim.isEnd());

		slideSpeed.setValue(m.getVitesseAnimation() + slideSpeed.getMaximum());

		slideControl.setEnabled(m.isMouvCalc());
		if (m.isMouvCalc()) {
			slideControl.setMaximum(m.getMaxTemps() + 10);
			slideControl.setValue(panAnim.getTempsActuel());
			System.out.println("TAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Runnable run = () -> setButtonState((Modele) o);
		if (SwingUtilities.isEventDispatchThread()) {
			run.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(run);
			} catch (InterruptedException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
