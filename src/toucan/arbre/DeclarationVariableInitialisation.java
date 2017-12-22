package toucan.arbre;

/**
 * Created by Cyril on 14/12/2017.
 */
public class DeclarationVariableInitialisation extends ArbreAbstrait {
	private String type;
	private String name;
	private String expression;

	public DeclarationVariableInitialisation(String type, String name, String expression) {
		this.type = type;
		this.name = name;
		this.expression = expression;
	}

	public String getCodeDecore() {
		return type + " " + name + "=" + expression + ";";
	}
}


