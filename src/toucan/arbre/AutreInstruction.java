package toucan.arbre;

/**
 * Created by bonnal4u.
 */
public class AutreInstruction extends Instruction {
	public AutreInstruction(String s) {
		codeDecore = s;
	}

	@Override
	public String getCodeDecore() {
		return codeDecore;
	}
}
