package command;

import environment.Cell;
import environment.Environment;
import lifeform.LifeForm;

/**
 * @author ad5146
 */
public interface Command {
  
  public void execute(int x, int y);
  
}
