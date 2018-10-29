package lifeform;

import exceptions.WeaponException;
import weapon.Weapon;

/**
 * Keeps track of the information associated with a simple life form. Also
 * provides the functionality related to the life form.
 */
public abstract class LifeForm {

  private String myName;
  protected int currentLifePoints;
  private int attackStrength;
  protected Weapon weapon;
  
  protected int row = -1;
  protected int col = -1;

  /**
   * Create an instance
   * 
   * @param name   the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    myName = name;
    currentLifePoints = points;
    attackStrength = 1;
  }

  /**
   * Create an instance
   * 
   * @param name
   * @param points the life points
   * @param s      the attack strength
   */
  public LifeForm(String name, int points, int s) {
    myName = name;
    currentLifePoints = points;
    attackStrength = s;
  }

  /**
   * @return the name of the lifeform
   */
  public String getName() {
    return myName;
  }

  /**
   * @return the amount of current life points the life form has.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * Life points are reduced by the specified damage.
   * 
   * @param damage How much to reduce life points by
   */
  public void takeHit(int damage) {
    currentLifePoints = Math.max(0, currentLifePoints - damage);
  }

  /**
   * attack another Lifeform with attack strength
   * 
   * @edited by dh3187
   */
  public void attack(LifeForm opponent, int distance) {
    if (currentLifePoints != 0) {
      if (weapon != null) {
        if (weapon.getCurrentAmmo() != 0) {
          try {
            opponent.takeHit(weapon.fire(distance));
          } catch (WeaponException e) {
            // do nothing
            return;
          }
        } else {
          if (distance <= 5) {
            opponent.takeHit(attackStrength);
          }
        }
      } else {
        if (distance <= 5) {
          opponent.takeHit(attackStrength);
        }
      }
    }
  }

  /**
   * @author dh3187
   */
  public int getAttackStrength() {
    return attackStrength;
  }

  /**
   * @author dh3187
   */
  public boolean pickUpWeapon(Weapon weapon) {
    if (this.weapon == null) {
      this.weapon = weapon;
      return true;
    } else {
      return false;
    }
  }

  /**
   * @author dh3187
   */
  public boolean hasWeapon() {
    if (weapon != null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @author dh3187
   */
  public Weapon dropWeapon() {
    Weapon oldWeapon = weapon;
    if (weapon != null) {
      weapon = null;
    }
    return oldWeapon;
  }

  /**
   * @author dh3187
   */
  public void reload() {
    if (weapon.getCurrentAmmo() != weapon.getMaxAmmo()) {
      weapon.reload();
    }
  }
  
  public void setLocation(int row, int col) {
    if (row < 0 || col < 0) {
      this.row = -1;
      this.col = -1;
    } else {
      this.row = row;
      this.col = col;
    }
  }
  
  public int getRow() {
    return row;
  }
  
  public int getCol() {
    return col;
  }
}
