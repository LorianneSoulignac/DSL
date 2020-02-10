package aspects.fsm.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.ut2j.m1ice.fsm.FSM
import fr.ut2j.m1ice.fsm.State
import fr.ut2j.m1ice.fsm.Transition
import fr.ut2j.m1ice.fsm.Initial
import fr.ut2j.m1ice.fsm.Final
import fr.ut2j.m1ice.fsm.FsmPackage

import static extension aspects.fsm.aspects.FSMAspect.*
import static extension aspects.fsm.aspects.StateAspect.*
import static extension aspects.fsm.aspects.TransitionAspect.*
import static extension aspects.fsm.aspects.InitialAspect.*
import static extension aspects.fsm.aspects.FinalAspect.*

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import fr.inria.diverse.k3.al.annotationprocessor.Step
import java.util.Scanner

class Interpreter {
	def static void main(String [] args){
		FsmPackage.eINSTANCE.class
		Resource$Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		var Resource resource = new ResourceSetImpl().getResource(URI.createURI('C:\\Users\\Etu\\Desktop\\cours\\Master 1\\tp_dsl\\DSL\\fr.ut2j.m1ice.fsm\\model\\FSM.xmi'),true)
		var myfsm = resource.contents.get(0) as FSM
		myfsm.execute
	}
}


@Aspect(className=FSM)
class FSMAspect {
	@Step
	def public void  execute() {
		var sc = new Scanner(System.in)
		System.out.println("Bonjour")
		var current = _self.state.filter[statut | statut instanceof Initial].get(0);
		var fin = _self.state.filter[statut | statut instanceof Final].get(0);
		while(!current.equals(fin)){
			System.out.println("Statut courant : "+ current.name)
			val trigger = sc.nextLine()
			val currentBis = current
			var transition = _self.transition.findFirst[ tr | tr.state1.equals(currentBis) && tr.name.equals(trigger)]
			if (transition != null){
				current = transition.state2
			}
			else{
				System.out.println("Transition null");
			}
			System.out.println("nouveau state : " + current.name);										
		}
		System.out.println("Etat final : FIN");
	}

}

@Aspect(className=State)
class StateAspect {

}

@Aspect(className=Transition)
class TransitionAspect {

}

@Aspect(className=Initial)
class InitialAspect extends StateAspect {

}

@Aspect(className=Final)
class FinalAspect extends StateAspect {

}



