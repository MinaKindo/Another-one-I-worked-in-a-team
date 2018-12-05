package state;

import environment.Environment;
import lifeform.Alien;
import lifeform.LifeForm;

public class AiContext {

  private ActionState hasWeaponState;
  private ActionState outOfAmmoState;
  private ActionState deadState;
  private ActionState noWeaponState;
  private ActionState currentState;

  private LifeForm lifeForm;

  /**
   * Creates an AI context
   */
  public AiContext(Environment e, LifeForm l) {
    hasWeaponState = new HasWeaponState(e, this, l);
    outOfAmmoState = new OutOfAmmoState(e, this, l);
    deadState = new DeadState(e, this, l);
    noWeaponState = new NoWeaponState(e, this, l);

    currentState = noWeaponState;

    this.lifeForm = l;
  }

  public void executeAction() {
    currentState.executeAction();
  }

  public ActionState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(ActionState state) {
    currentState = state;
  }

  public ActionState getHasWeaponState() {
    return hasWeaponState;
  }

  public ActionState getNoWeaponState() {
    return noWeaponState;
  }

  public ActionState getOutOfAmmoState() {
    return outOfAmmoState;
  }

  public ActionState getDeadState() {
    return deadState;
  }

}
