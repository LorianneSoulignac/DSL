package aspects.fsm.aspects;

import aspects.fsm.aspects.StateAspectStateAspectProperties;
import fr.ut2j.m1ice.fsm.State;
import java.util.Map;

@SuppressWarnings("all")
public class StateAspectStateAspectContext {
  public final static StateAspectStateAspectContext INSTANCE = new StateAspectStateAspectContext();
  
  public static StateAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new aspects.fsm.aspects.StateAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateAspectStateAspectProperties> map = new java.util.WeakHashMap<fr.ut2j.m1ice.fsm.State, aspects.fsm.aspects.StateAspectStateAspectProperties>();
  
  public Map<State, StateAspectStateAspectProperties> getMap() {
    return map;
  }
}
