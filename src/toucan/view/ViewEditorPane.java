package toucan.view;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Cyril BASILE
 */
public class ViewEditorPane extends JEditorPane implements Observer {

    private PanneauAnimation panAnim;

    public ViewEditorPane(Observable model) {
        model.addObserver(this);
        init((Modele) model);
    }

    private void init(Modele m) {
        setEditor(m);
    }
    private void setEditor(Modele m) {
        m.setAlgoPersoText(this.getText());
    }

    @Override
    public void update(Observable o, Object arg) {
        Runnable run = () -> setEditor((Modele) o);
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
