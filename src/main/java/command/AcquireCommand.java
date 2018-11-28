package command;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * @author ad5146 & sb0476
 */
public class AcquireCommand implements Command {

  @Override
  public void execute(int x, int y) {
    Environment env = Environment.getEnvironment(4, 4);
    LifeForm lifeform = env.getLifeForm(y, x);

    // get the weapons at the cell x, y
    Weapon[] weapons = env.getWeapons(y, x);
    // what life form was holding
    Weapon oldWeapon = null;
    if (lifeform.hasWeapon()) {
      oldWeapon = lifeform.dropWeapon();
    }
    
    // if there is a weapon 1 in the cell
    if (weapons[0] != null) {
      lifeform.pickUpWeapon(weapons[0]);
      env.removeWeapon(weapons[0], y, x);
      if (oldWeapon != null) {
        env.addWeapon(oldWeapon, y, x);
      }
    }
    // if there is a weapon 2 in the cell
    else if (weapons[1] != null) {
      lifeform.pickUpWeapon(weapons[1]);
      env.removeWeapon(weapons[0], y, x);
      if (oldWeapon != null) {
        env.addWeapon(oldWeapon, y, x);
      }
    }

  }

}
