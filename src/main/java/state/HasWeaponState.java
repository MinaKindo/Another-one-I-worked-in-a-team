package state;

import java.awt.Point;

import environment.CellInfo;
import environment.Environment;
import exceptions.EnvironmentException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;

public class HasWeaponState extends ActionState {

  public HasWeaponState(Environment e, AIContext ai, LifeForm l) {
    super(e, ai, l);
  }

  @Override
  public void executeAction() {
    try {
      Point searchLoc = searchLife();
      Point myLoc = new Point(lifeForm.getRow(), lifeForm.getCol());
      if (!searchLoc.equals(myLoc)
          && lifeForm.getWeapon().getMaxRange() > environment.getDistance(lifeForm.getRow(),
              lifeForm.getCol(), (int) searchLife().getX(), (int) searchLife().getY())) {

        lifeForm.attack(
            environment.getLifeForm((int) searchLife().getX(), (int) searchLife().getY()),
            (int) environment.getDistance(lifeForm,
                environment.getLifeForm((int) searchLife().getX(), (int) searchLife().getY())));

        environment.updateCell((int) searchLife().getX(), (int) searchLife().getY());
      } else {
        search();
      }
      if (lifeForm.getWeapon().getCurrentAmmo() == 0) {
        ai.setCurrentState(ai.getOutOfAmmoState());
      }
      if (lifeForm.getCurrentLifePoints() == 0) {
        ai.setCurrentState(ai.getDeadState());
      }
    } catch (EnvironmentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public Point searchLife() throws EnvironmentException {
    int closestX = lifeForm.getRow();
    int closestY = lifeForm.getCol();
    double closestDistance = 1000000000;
    for (int i = 0; i < environment.getNumRows(); i++) {
      for (int j = 0; j < environment.getNumCols(); j++) {
        if (environment.getLifeForm(i, j) != null) {
          if ((lifeForm instanceof Human && environment.getLifeForm(i, j) instanceof Alien)
              || (lifeForm instanceof Alien && environment.getLifeForm(i, j) instanceof Human)) {
            if (closestDistance > environment.getDistance(lifeForm,
                environment.getLifeForm(i, j))) {
              closestDistance = environment.getDistance(lifeForm, environment.getLifeForm(i, j));
              closestX = i;
              closestY = j;
            }
          }
        }
      }
    }
    return new Point(closestX, closestY);
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

    if (Math.random() < 0.5) {
      int oldRow = lifeForm.getRow();
      int oldCol = lifeForm.getCol();
      environment.move(lifeForm);
      environment.updateCell(oldRow, oldCol);
    }
    environment.updateCell(lifeForm.getRow(), lifeForm.getCol());
  }

}
