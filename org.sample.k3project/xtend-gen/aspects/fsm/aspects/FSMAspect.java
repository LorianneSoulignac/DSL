package aspects.fsm.aspects;

import aspects.fsm.aspects.FSMAspectFSMAspectProperties;
import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.ut2j.m1ice.fsm.FSM;
import fr.ut2j.m1ice.fsm.Final;
import fr.ut2j.m1ice.fsm.Initial;
import fr.ut2j.m1ice.fsm.State;
import fr.ut2j.m1ice.fsm.Transition;
import java.util.Scanner;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Aspect(className = FSM.class)
@SuppressWarnings("all")
public class FSMAspect {
  @Step
  public static void execute(final FSM _self) {
    final aspects.fsm.aspects.FSMAspectFSMAspectProperties _self_ = aspects.fsm.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void execute()
    if (_self instanceof fr.ut2j.m1ice.fsm.FSM){
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    		@Override
    		public void execute() {
    			aspects.fsm.aspects.FSMAspect._privk3_execute(_self_, (fr.ut2j.m1ice.fsm.FSM)_self);
    		}
    	};
    	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager stepManager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    	if (stepManager != null) {
    		stepManager.executeStep(_self, new Object[] {_self}, command, "FSM", "execute");
    	} else {
    		command.execute();
    	}
    	;
    };
  }
  
  protected static void _privk3_execute(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Bonjour");
    final Function1<State, Boolean> _function = (State statut) -> {
      return Boolean.valueOf((statut instanceof Initial));
    };
    State current = ((State[])Conversions.unwrapArray(IterableExtensions.<State>filter(_self.getState(), _function), State.class))[0];
    final Function1<State, Boolean> _function_1 = (State statut) -> {
      return Boolean.valueOf((statut instanceof Final));
    };
    State fin = ((State[])Conversions.unwrapArray(IterableExtensions.<State>filter(_self.getState(), _function_1), State.class))[0];
    while ((!current.equals(fin))) {
      {
        String _name = current.getName();
        String _plus = ("Statut courant : " + _name);
        System.out.println(_plus);
        final String trigger = sc.nextLine();
        final State currentBis = current;
        final Function1<Transition, Boolean> _function_2 = (Transition tr) -> {
          return Boolean.valueOf((tr.getState1().equals(currentBis) && tr.getName().equals(trigger)));
        };
        Transition transition = IterableExtensions.<Transition>findFirst(_self.getTransition(), _function_2);
        boolean _notEquals = (!Objects.equal(transition, null));
        if (_notEquals) {
          current = transition.getState2();
        } else {
          System.out.println("Transition null");
        }
        String _name_1 = current.getName();
        String _plus_1 = ("nouveau state : " + _name_1);
        System.out.println(_plus_1);
      }
    }
    System.out.println("Etat final : FIN");
  }
}
