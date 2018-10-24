package weapon;

import exceptions.WeaponException;

/**
 * @author Anthony DePaul
 */
public class MockWeapon extends GenericWeapon {

  /**
   * Creates a MockWeapon instance
   */
  public MockWeapon() {
    baseDamage = 5;
    maxAmmo = 5;
    currentAmmo = maxAmmo;
    maxRange = 5;
    rateOfFire = 3;
    shotsLeft = rateOfFire;
  }
  
  @Override
  public int fire(int distance) throws WeaponException {

    if (distance < 0) {
      throw this.distanceException;
    }

    if (currentAmmo == 0) {
      return 0;
    }

    if (shotsLeft == 0) {
      return 0;
    }

    if (distance > maxRange) {
      currentAmmo--;
      shotsLeft--;
      return 0;
    }

    currentAmmo--;
    shotsLeft--;
    return 1;
  }

  @Override
  public String toString() {
    return "MockWeapon";
  }
}
