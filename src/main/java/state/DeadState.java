package state;

import environment.Environment;
import lifeform.LifeForm;

public class DeadState extends ActionState {

  public DeadState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    // TODO Auto-generated method stub

  }

  @Override
  public void search() {
    // TODO Auto-generated method stub
    
  }

}
