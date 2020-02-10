package aspects.fsm.aspects;

import aspects.fsm.aspects.StateAspect;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.ut2j.m1ice.fsm.Final;

@Aspect(className = Final.class)
@SuppressWarnings("all")
public class FinalAspect extends StateAspect {
}
