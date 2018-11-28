package command;

import environment.Environment;
import lifeform.LifeForm;

/**
 * @author ad5146
 */
public class AttackCommand implements Command {

  @Override
  public void execute(int x, int y) {
    
    Environment e = Environment.getEnvironment(4, 4);
    LifeForm lifeform = e.getLifeForm(x, y);
    LifeForm Opponent = null;
        
    
    if(lifeform.getCurrentDirection() == "West" || lifeform.getCurrentDirection() == "East") {
      //for(int z = x; z )

    }
    
    
    
    //LifeForm.attack(lifeform, distance);
    // change attack() to static?

  }

}
