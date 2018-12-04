package state;

import environment.Environment;
import lifeform.LifeForm;

public class AIContext {
  
  private ActionState hasWeaponState;
  private ActionState outOfAmmoState;
  private ActionState deadState;
  private ActionState noWeaponState;
  private ActionState currentState;
  
  public AIContext(Environment e, LifeForm l) {
    hasWeaponState = new HasWeaponState(e, this, l);
    outOfAmmoState = new OutOfAmmoState(e, this, l);
    deadState = new DeadState(e, this, l);
    noWeaponState = new NoWeaponState(e, this, l);
	  currentState = noWeaponState;
  }
  
  public void executeAction() {
	  currentState.executeAction();
  }
  
  public void setCurrentState(ActionState state) {
	  currentState = state;
  }
  
  public ActionState getCurrentState() {
	  return currentState;
  }
  
  public ActionState getHasWeaponState() {
	  return hasWeaponState;
  }
  
  public ActionState getHasNoWeaponsState() {
	  return noWeaponState;
  }
  
  public ActionState getOutOfAmmoState() {
	  return outOfAmmoState;
  }
  
  public ActionState getDeadState() {
	  return deadState;
  }
  
}
