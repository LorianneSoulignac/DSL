/*
 * generated by Xtext 2.14.0
 */
package fr.ut2j.m1ice.mydsl.parser.antlr;

import com.google.inject.Inject;
import fr.ut2j.m1ice.mydsl.parser.antlr.internal.InternalMyDslParser;
import fr.ut2j.m1ice.mydsl.services.MyDslGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class MyDslParser extends AbstractAntlrParser {

	@Inject
	private MyDslGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMyDslParser createParser(XtextTokenStream stream) {
		return new InternalMyDslParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "FSM";
	}

	public MyDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
