package environment;

import lifeform.LifeForm;

/**
 * A cell that can hold a LifeForm.
 *
 */
public class Cell {

  private LifeForm lifeForm;

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
}
