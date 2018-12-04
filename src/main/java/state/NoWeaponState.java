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
      Weapon[] list  = new Weapon[2];
      list = environment.getWeapons(lifeForm.getRow(), lifeForm.getCol());
      for (int i = 0; i < 2; i++) {
        if (list[i] != null) {
          lifeForm.pickUpWeapon(list[i]);
          ai.setCurrentState(ai.getHasWeaponState());
        }
      } if (lifeForm.hasWeapon() == false) {
        search();
      }
    }
  }

  @Override
  public void search() {
    environment.move(lifeForm);
  }
}
