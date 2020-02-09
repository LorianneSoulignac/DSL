package aspects.fsm.aspects;

import aspects.fsm.aspects.StateAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.ut2j.m1ice.fsm.Initial;

@Aspect(className = Initial.class)
@SuppressWarnings("all")
public class InitialAspect extends StateAspect {
}
