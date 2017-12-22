package toucan;

import toucan.modele.Modele;
import toucan.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class Toucan extends JFrame {

    private Toucan() {
        super("Toucan Kamon");
        setLayout(new BorderLayout());
        setResizable(true);
        setMinimumSize(new Dimension(400, 200));

        Observable model = new Modele();
        ViewGraphique vueGraph = new ViewGraphique(model);

        setJMenuBar(new ViewMenubar(model, vueGraph.getPanAnim()));
        add(new ViewToolbarTop(model, vueGraph.getPanAnim()), BorderLayout.PAGE_START);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        //content.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new ViewEditorPane(model, vueGraph.getPanAnim()), vueGraph));
        //content.add(vueGraph, BorderLayout.EAST);
        //content.add(new ViewEditorPane(model, vueGraph.getPanAnim()), BorderLayout.WEST);
        //content.add(new ViewDebugPane(model), BorderLayout.SOUTH);
        add(new ViewContent(model, vueGraph), BorderLayout.CENTER);


        add(new ViewToolbarBottom(model, vueGraph.getPanAnim()), BorderLayout.PAGE_END);


        Modele modele = (Modele) model;

		modele.creerCase(90, 60, 3);
        modele.creerCase(150, 60, 5);
		modele.creerCase(210, 60, 2);
		modele.creerCase(270, 60, 4);
        modele.creerVariable(5, 300, 0); //Case de stockage pour swap

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Toucan::new);
    }
}
