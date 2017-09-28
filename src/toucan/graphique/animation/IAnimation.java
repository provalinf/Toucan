package toucan.graphique.animation;

import toucan.modele.LesCases;

public interface IAnimation {

	public void executer(LesCases cases, int... indices);
}
