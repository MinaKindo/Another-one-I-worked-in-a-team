package state;

import environment.Environment;
import lifeform.LifeForm;

public class OutOfAmmoState extends ActionState {

  public OutOfAmmoState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    // TODO Auto-generated method stub

  }

}
