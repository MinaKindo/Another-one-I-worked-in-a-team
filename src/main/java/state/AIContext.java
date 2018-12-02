package state;

import environment.Environment;
import lifeform.LifeForm;

public class AIContext {
  
  private ActionState hasWeaponState;
  private ActionState outOfAmmoState;
  private ActionState deadState;
  private ActionState noWeaponState;
  
  public AIContext(Environment e, AIContext ai, LifeForm l) {
    hasWeaponState = new HasWeaponState(e, ai, l);
    outOfAmmoState = new OutOfAmmoState(e, ai, l);
    deadState = new DeadState(e, ai, l);
    noWeaponState = new NoWeaponState(e, ai, l);
  }
  
  public void executeAction() {
    // TODO
  }
}
