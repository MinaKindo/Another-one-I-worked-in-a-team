package state;

import environment.CellInfo;
import environment.Environment;
import exceptions.EnvironmentException;
import lifeform.LifeForm;

public class HasWeaponState extends ActionState {

  public HasWeaponState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
	  if(search() != null) {
		  
		  try {
			lifeForm.attack(environment.getLifeForm(search().getRow(), search().getCol()), (int) environment.getDistance(lifeForm, environment.getLifeForm(search().getRow(), search().getCol())));
			if(lifeForm.getWeapon().getCurrentAmmo() == 0) {
				ai.setCurrentState(ai.getOutOfAmmoState());
			}
		  } catch (EnvironmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  else {
		  
	  }
	  if(lifeForm.getCurrentLifePoints() == 0) {
	    	ai.setCurrentState(ai.getdeadState());
	    }
	  if(environment.getRandomCell().hasLife()) {
		  
	  }
  }
  
  public CellInfo search() {
	for(int i = lifeForm.getRow(); i < environment.getNumRows(); i++) {
		for(int j = lifeForm.getCol(); j < environment.getNumCols(); j++) {
			if(environment.getLifeForm(i, j) != null) {
				return environment.getCellInfo(i, j);
			}
		}
	}
	return null;  
  }

}
