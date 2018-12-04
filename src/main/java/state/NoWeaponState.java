package state;

import environment.Environment;
import environment.Cell;
import lifeform.LifeForm;
import state.AIContext;
import weapon.Weapon;

public class NoWeaponState extends ActionState {

  public NoWeaponState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    if (lifeForm.getCurrentLifePoints() == 0) {
      ai.setCurrentState(ai.getDeadState());
    } else {
      Weapon[] list = new Weapon[2];
      list = environment.getWeapons(lifeForm.getRow(), lifeForm.getCol());
      for (int i = 0; i < 2; i++) {
        if (list[i] != null) {
          lifeForm.pickUpWeapon(list[i]);
          environment.removeWeapon(list[i], lifeForm.getRow(), lifeForm.getCol());
          environment.updateCell(lifeForm.getRow(), lifeForm.getCol());
          ai.setCurrentState(ai.getHasWeaponState());
          break;
        }
      }
      if (lifeForm.hasWeapon() == false) {
        search();
      }
    }
  }

  @Override
  public void search() {
    int randomDirection = (int) (Math.random() * 4); // [0, 3]
    if (randomDirection == 0) {
      lifeForm.setDirection("North");
    } else if (randomDirection == 1) {
      lifeForm.setDirection("South");
    } else if (randomDirection == 2) {
      lifeForm.setDirection("East");
    } else if (randomDirection == 3) {
      lifeForm.setDirection("West");
    }
    int oldRow = lifeForm.getRow();
    int oldCol = lifeForm.getCol();
    environment.move(lifeForm);
    environment.updateCell(oldRow, oldCol);
    environment.updateCell(lifeForm.getRow(), lifeForm.getCol());
  }
}
