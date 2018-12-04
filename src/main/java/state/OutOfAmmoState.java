package state;

import environment.Environment;
import lifeform.LifeForm;
import state.AIContext;

public class OutOfAmmoState extends ActionState {

  public OutOfAmmoState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    if (lifeForm.getCurrentLifePoints() == 0) {
      ai.setCurrentState(ai.getDeadState());
    } else {
      lifeForm.reload();
      ai.setCurrentState(ai.getHasWeaponState());
    }

  }

  @Override
  public void search() {
    // TODO Auto-generated method stub
    
  }

}
