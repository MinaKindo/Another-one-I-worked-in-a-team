package state;

import environment.CellInfo;
import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

public class DeadState extends ActionState {

  public DeadState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    if(lifeForm.hasWeapon()) {
    	Weapon droppedWeapon = lifeForm.dropWeapon();
    	CellInfo randomCell = environment.getRandomCell();
    	environment.addWeapon(droppedWeapon, randomCell.getRow(), randomCell.getCol());
    	lifeForm.setCurrentLifePoints(lifeForm.getMaxLifePoints());
		ai.setCurrentState(ai.getHasNoWeaponsState());
    }

  }

}
