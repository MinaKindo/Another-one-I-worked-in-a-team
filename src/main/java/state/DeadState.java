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
		if (lifeForm.hasWeapon()) {
			Weapon droppedWeapon = lifeForm.dropWeapon();
			CellInfo randomCell = null;
			do {
				CellInfo c = environment.getRandomCell();
				if (!c.hasWeapon1() || !c.hasWeapon2()) {
					randomCell = c;
				}
			} while (randomCell == null);
			
			environment.addWeapon(droppedWeapon, randomCell.getRow(), randomCell.getCol());
			environment.updateCell(randomCell.getRow(), randomCell.getCol());
		}
		lifeForm.setCurrentLifePoints(lifeForm.getMaxLifePoints());
		ai.setCurrentState(ai.getHasNoWeaponsState());
		environment.updateCell(lifeForm.getRow(), lifeForm.getCol());
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

}
