package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {

  /**
   * Creates Pistol instance
   */
  public Pistol() {
    baseDamage = 10;
    maxRange = 50;
    rateOfFire = 2;
    maxAmmo = 10;

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

    int damage = (int) (baseDamage * ((maxRange - distance + 10 + 0.0) / maxRange));

    currentAmmo--;
    shotsLeft--;
    return damage;
  }

  @Override
  public String toString() {
    return "Pistol";
  }
}
