package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Cyril BASILE
 */
public class ViewEditorPane extends JEditorPane implements Observer {

	private PanneauAnimation panAnim;

	public ViewEditorPane(Observable model, PanneauAnimation panAnim) {
		model.addObserver(this);
		this.panAnim = panAnim;
		init((Modele) model);
	}

	private void init(Modele m) {
		getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent de) {
				setEditor(m);
			}

			public void removeUpdate(DocumentEvent de) {
				setEditor(m);
			}

			public void changedUpdate(DocumentEvent arg0) {
			}
		});
	}

	private void setEditor(Modele m) {
		m.setAlgoPersoText(this.getText());
		if (!m.isMouvCalc()) return;
		System.out.println("reset");
		m.stopAndReset();
		panAnim.resetAndInit();
		m.refreshUI();
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
