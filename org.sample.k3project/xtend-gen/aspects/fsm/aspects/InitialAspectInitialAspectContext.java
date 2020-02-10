package aspects.fsm.aspects;

import aspects.fsm.aspects.InitialAspectInitialAspectProperties;
import fr.ut2j.m1ice.fsm.Initial;
import java.util.Map;

@SuppressWarnings("all")
public class InitialAspectInitialAspectContext {
  public final static InitialAspectInitialAspectContext INSTANCE = new InitialAspectInitialAspectContext();
  
  public static InitialAspectInitialAspectProperties getSelf(final Initial _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new aspects.fsm.aspects.InitialAspectInitialAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Initial, InitialAspectInitialAspectProperties> map = new java.util.WeakHashMap<fr.ut2j.m1ice.fsm.Initial, aspects.fsm.aspects.InitialAspectInitialAspectProperties>();
  
  public Map<Initial, InitialAspectInitialAspectProperties> getMap() {
    return map;
  }
}
