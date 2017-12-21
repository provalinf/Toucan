package toucan.arbre;

/**
 * Created by Cyril on 14/12/2017.
 */
public class DeclarationVariable extends Instruction {
	private String type;
	private String name;

	public DeclarationVariable(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getCodeDecore() {
		return type + " " + name + ";";
	}
}


