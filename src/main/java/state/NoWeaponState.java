package state;

import environment.Environment;
import lifeform.LifeForm;
import state.AIContext;

public class NoWeaponState extends ActionState {

  public NoWeaponState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    if (state.getState() == deadState) {
      
    }

  }

}
