/**
 * generated by Xtext 2.14.0
 */
package fr.ut2j.m1ice.mydsl.formatting2;

import com.google.inject.Inject;
import fr.ut2j.m1ice.fsm.FSM;
import fr.ut2j.m1ice.fsm.State;
import fr.ut2j.m1ice.fsm.Transition;
import fr.ut2j.m1ice.mydsl.services.MyDslGrammarAccess;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class MyDslFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private MyDslGrammarAccess _myDslGrammarAccess;
  
  protected void _format(final FSM fSM, @Extension final IFormattableDocument document) {
    EList<State> _state = fSM.getState();
    for (final State state : _state) {
      document.<State>format(state);
    }
    EList<Transition> _transition = fSM.getTransition();
    for (final Transition transition : _transition) {
      document.<Transition>format(transition);
    }
  }
  
  public void format(final Object fSM, final IFormattableDocument document) {
    if (fSM instanceof XtextResource) {
      _format((XtextResource)fSM, document);
      return;
    } else if (fSM instanceof FSM) {
      _format((FSM)fSM, document);
      return;
    } else if (fSM instanceof EObject) {
      _format((EObject)fSM, document);
      return;
    } else if (fSM == null) {
      _format((Void)null, document);
      return;
    } else if (fSM != null) {
      _format(fSM, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fSM, document).toString());
    }
  }
}
