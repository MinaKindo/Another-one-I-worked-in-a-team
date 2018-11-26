/**
 * @author sb0476
 */
package invokerbuilder;

import lifeform.LifeForm;
import weapon.Weapon;

public class Command {

  public void reloadCommand(LifeForm lifeform) {
    lifeform.reload();
    // weapon.reload();
  }

  public void turnPlayerCommands() {
    // add turning and movement abilities
  }

  public void moveCommand() {
    // add turning and movement abilities
  }

  public void attackCommand(LifeForm lifeform, int distance) {
//    LifeForm.attack(lifeform, distance);
    // change attack() to static?
  }

  public void dropCommand(LifeForm lifeform) {
//    LifeForm.dropWeapon();
    // change dropWeapon() to static?
  }

  public void acuireCommand(LifeForm lifeform, Weapon newWeapon) {
    if (lifeform.hasWeapon() == true) {
      lifeform.dropWeapon();
    }

    lifeform.pickUpWeapon(newWeapon);
  }

}
