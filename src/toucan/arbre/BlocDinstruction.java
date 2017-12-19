package toucan.arbre;

import com.sun.corba.se.impl.protocol.INSServerRequestDispatcher;

import java.util.ArrayList;

/**
 * Created by Cyril on 24/11/2017.
 */
public class BlocDinstruction extends ArbreAbstrait {
    private ArrayList<ArbreAbstrait> bloc = new ArrayList<>();

    public BlocDinstruction(ArrayList<ArbreAbstrait> bloc) {
        this.bloc = bloc;
    }
    public void ajouter(ArbreAbstrait a){
        bloc.add(a);
    }
    public String getCodeDecore() {
        StringBuilder res = new StringBuilder();
        for (ArbreAbstrait a : bloc){
            res.append(a.getCodeDecore()).append("\n");
        }
        return res.toString();
    }
}
