package weapon;

import exceptions.WeaponException;

public abstract class GenericWeapon implements Weapon {

  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;
  
  protected WeaponException distanceException = new WeaponException("Invalid distance");

  @Override
  public abstract int fire(int distance) throws WeaponException;
  
  @Override
  public int getBaseDamage() {
    return baseDamage;
  }

  @Override
  public int getCurrentAmmo() {
    return currentAmmo;
  }

  @Override
  public int getMaxAmmo() {
    return maxAmmo;
  }


  @Override
  public int getMaxRange() {
    return maxRange;
  }
  
  @Override
  public int getNumAttachments() {
    return 0;
  }

  @Override
  public int getRateOfFire() {
    return rateOfFire;
  }

  @Override
  public int getShotsLeft() {
    return shotsLeft;
  }

  @Override
  public void reload() {
    currentAmmo = maxAmmo;
  }

  @Override
  public abstract String toString();

  @Override
  public void updateTime(int time) {
    shotsLeft = rateOfFire;
  }
}
