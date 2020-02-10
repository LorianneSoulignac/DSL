package aspects.fsm.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.ut2j.m1ice.fsm.FSM
import fr.ut2j.m1ice.fsm.State
import fr.ut2j.m1ice.fsm.Transition
import fr.ut2j.m1ice.fsm.Initial
import fr.ut2j.m1ice.fsm.Final

import static extension aspects.fsm.aspects.FSMAspect.*
import static extension aspects.fsm.aspects.StateAspect.*
import static extension aspects.fsm.aspects.TransitionAspect.*
import static extension aspects.fsm.aspects.InitialAspect.*
import static extension aspects.fsm.aspects.FinalAspect.*
import fr.ut2j.m1ice.fsm.FSM

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

class Interpreter{
	def static void main (String [] args){
		fr.ut2j.m1ice.fsm.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		var Resource resource = new ResourceSetImpl().getResource(URI.createURI('Desktop/gemoc/workspace/fr.ut2j.m1ice.fsm/model/FSM.xmi'),true)
		var myfsm = resource.contents.get(0) as FSM
		myfsm.execute
	}
}

@Aspect(className=FSM)
class FSMAspect {

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



