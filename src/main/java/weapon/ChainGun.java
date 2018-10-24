package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon {

  /**
   * Creates ChainGun instance
   */
  public ChainGun() {
    baseDamage = 15;
    maxRange = 60;
    rateOfFire = 4;
    maxAmmo = 40;

    shotsLeft = rateOfFire;
    currentAmmo = maxAmmo;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw distanceException;
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

    int damage = (int) (baseDamage * ((distance + 0.0) / maxRange));

    currentAmmo--;
    shotsLeft--;
    return damage;
  }

  @Override
  public String toString() {
    return "ChainGun";
  }
}
