package state;

import environment.Environment;
import lifeform.LifeForm;

public abstract class ActionState {

  protected Environment environment;
  protected AiContext ai;
  protected LifeForm lifeForm;

  /**
   * Creates an action state
   */
  public ActionState(Environment e, AiContext ai, LifeForm l) {
    environment = e;
    this.ai = ai;
    lifeForm = l;
  }

  public abstract void executeAction();

  public abstract void search();
}
