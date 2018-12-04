package state;

import environment.Environment;
import lifeform.LifeForm;

public abstract class ActionState {

  protected Environment environment;
  protected AIContext ai;
  protected LifeForm lifeForm;
  
  public ActionState(Environment e, AIContext ai, LifeForm l) {
    environment = e;
    this.ai = ai;
    lifeForm = l;
  }
  
  public abstract void executeAction();
  public abstract void search();
}
