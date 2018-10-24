package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A cell that can hold a LifeForm.
 *
 */
public class Cell {

  private LifeForm lifeForm;
  private int weaponsCount;
  private Weapon weapon1;
  private Weapon weapon2;

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
   * @author dh3187
   * @param weapon
   * @return
   */
  public boolean addWeapon(Weapon weapon) {
    if (weapon1 == null) {
      weapon1 = weapon;
      return true;
    } else {
      if (weapon2 == null) {
        weapon2 = weapon;
        return true;
      } else {
        return false;
      }
    }
  }
  
  /**
   * @return the LifeForm in this Cell.
   */
  public LifeForm getLifeForm() {
    return lifeForm;
  }
  
  /**
   * @author dh3187
   * @return
   */
  public Weapon getWeapon1() {
    return weapon1;
  }
  
  /**
   * @author dh3187
   * @return
   */
  public Weapon getWeapon2() {
    return weapon2;
  }
  
  /**
   * @author dh3187
   * @return
   */
  public int getWeaponsCount() {
    return weaponsCount;
  }

  public void removeLifeForm() {
    lifeForm = null;
  }
  
  /**
   * @author dh3187
   * @param weapon
   * @return
   */
  public Weapon removeWeapon(Weapon weapon) {
    return weapon;
  }
}
