package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon {

  /**
   * Creates PlasmaCannon instance
   */
  public PlasmaCannon() {
    baseDamage = 50;
    maxRange = 40;
    rateOfFire = 1;
    maxAmmo = 4;
    
    shotsLeft = rateOfFire;
    currentAmmo = maxAmmo;
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

    int damage = (int) (baseDamage * ((currentAmmo + 0.0) / maxAmmo));

    currentAmmo--;
    shotsLeft--;
    return damage;
  }

  @Override
  public String toString() {
    return "PlasmaCannon";
  }

}
