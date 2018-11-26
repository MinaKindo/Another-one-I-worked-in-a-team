package invokerbuilder;

import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

/**
 * @author sb0476
 */
public class Command {

  public void reloadCommand(LifeForm lifeform) {
    LifeForm.reload();
    // lifeform.reload();
    // weapon.reload();
  }

  public void turnPlayerCommands() {
    Environment.turn(LifeForm lifeform)
    // add turning and movement abilities?
  }

  public void moveCommand() {
    Environment.move(LifeForm lifeform)
  }

  public void attackCommand(LifeForm lifeform, int distance) {
    LifeForm.attack(lifeform, distance);
    // change attack() to static?
  }

  public void dropCommand(LifeForm lifeform) {
    LifeForm.dropWeapon();
    // change dropWeapon() to static?
  }

  /**
   * acquires weapon
   */
  public void acquireCommand(LifeForm lifeform, Weapon newWeapon) {
    if (lifeform.hasWeapon() == true) {
      lifeform.dropWeapon();
    }

    lifeform.pickUpWeapon(newWeapon);
  }

}
