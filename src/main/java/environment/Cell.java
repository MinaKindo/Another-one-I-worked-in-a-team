package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A cell that can hold a LifeForm.
 *
 */
public class Cell {

  private LifeForm lifeForm;
  private Weapon weapon1; //first weapon in cell
  private Weapon weapon2; //second weapon in cell

  /**
   * Tries to add the LifeForm of the Cell. Will not add if a LifeForm is already
   * present.
   * 
   * @param entity
   *          the lifeform held in the cell
   * @return true if the LifeForm was added to the Cell, false otherwise.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (lifeForm == null) {
      lifeForm = entity;
      return true;
    } else {
      return false;
    }
  }

  /**
   * @return the LifeForm in this Cell.
   */
  public LifeForm getLifeForm() {
    return lifeForm;
  }

  public void removeLifeForm() {
    lifeForm = null;
  }
  
  /**
   * 
   * @param weapon
   * @return true if the weapon is added successfully
   */
  public boolean addWeapon​(Weapon weapon) {
    boolean status = false;
    if (weapon1 == null || weapon2 == null)
    return status;
  }
}
