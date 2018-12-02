package state;

import environment.Environment;
import lifeform.LifeForm;

public class AIContext {
  
  private ActionState hasWeaponState;
  private ActionState outOfAmmoState;
  private ActionState deadState;
  private ActionState noWeaponState;
  
  public AIContext(Environment e, LifeForm l) {
    hasWeaponState = new HasWeaponState(e, this, l);
    outOfAmmoState = new OutOfAmmoState(e, this, l);
    deadState = new DeadState(e, this, l);
    noWeaponState = new NoWeaponState(e, this, l);
  }
  
  public void executeAction() {
    // TODO
  }
}
