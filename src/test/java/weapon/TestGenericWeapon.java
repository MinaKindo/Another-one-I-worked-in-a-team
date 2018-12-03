package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;

public class TestGenericWeapon {

  /**
   * @author ad5146
   */
  @Test
  public void testUseAmmo() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    int initialAmmo = weapon.getCurrentAmmo();
    weapon.fire(1);
    assertEquals(initialAmmo - 1, weapon.getCurrentAmmo());
  }

  /**
   * @author ad5146
   */
  @Test
  public void testRateOfFire() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    assertEquals(weapon.getRateOfFire(), weapon.getShotsLeft());

    int initialShotsleft = weapon.getShotsLeft();

    weapon.fire(1);

    assertEquals(initialShotsleft - 1, weapon.getShotsLeft());
  }

  /**
   * @author ad5146
   */
  @Test
  public void testReload() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.reload();

    assertEquals(weapon.getMaxAmmo(), weapon.getCurrentAmmo());
  }

  /**
   * @author ad5146
   */
  @Test
  public void testNoDamageNoAmmo() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    while (weapon.getCurrentAmmo() > 0 && weapon.getShotsLeft() > 0) {
      weapon.fire(1);
    }

    assertEquals(0, weapon.fire(1));
  }

  /**
   * @author ad5146
   */
  @Test
  public void testNoDamageMaxRange() throws WeaponException {
    MockWeapon weapon = new MockWeapon();

    assertEquals(0, weapon.fire(weapon.maxRange + 1));
  }
}
