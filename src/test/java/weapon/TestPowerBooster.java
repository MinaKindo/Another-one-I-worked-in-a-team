package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestPowerBooster {

  /**
   * @author @lh9509
   */
  @Test
  public void test_ChainGun_PowerBooster() throws WeaponException, AttachmentException {
    // TEST WILL USE A CHAINGUN WITH A DISTANCE OF 15, AND ACTUALAMMO OF 25

    // create ChainGun
    // Check to see if ChainGun damage works normally: Damage = 15 * (DISTANCE / 30)
    // the gun should deal 3.75 damage
    ChainGun cg = new ChainGun();
    cg.currentAmmo = 25;

    // Decorate ChainGun with PowerBooster
    // Check to see if modified ChainGun damages normally: Power Booster Damage =
    // Damage X (1 + (ACTUALAMMO / 40)
    // the weapon with the PowerBooster should damage 4.875

    Weapon cgPb = new PowerBooster(cg);
    assertEquals(4, cgPb.fire(15));
  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_Pistol_Scope_PowerBooster() throws AttachmentException, WeaponException {

    // create Pistol
    // Check to see if Pistol damage works normally: Damage = 10 * ((50 - DISTANCE +
    // 10) / 50)
    // the gun should deal 9 damage

    Pistol p = new Pistol();
    p.currentAmmo = 8;

    // Decorate Pistol with Scope
    // Check to see if modified Pistol damages normally: Scope Damage = Damage *
    // (1+((60-DISTANCE)/60))
    // the Scope Damage should deal 15.75

    Weapon ps = new Scope(p);
    assertEquals(15, ps.fire(15));
    // assertEquals

    // Decorate Pistol with PowerBooster
    // Check to see if modified Pistol damages normally: Power Booster Damage =
    // Damage X (1 + (ACTUALAMMO / 40))
    // the Power Booster damage would be 25.59375

    Weapon psPb = new PowerBooster(ps);
    assertEquals(25, psPb.fire(15));

  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_ChainGun_PowerBooster_PowerBooster()
      throws WeaponException, AttachmentException {
    // TEST WILL USE A CHAINGUN WITH A DISTANCE OF 15, AND AMMO OF 25

    // create ChainGun
    // Check to see if ChainGun damage works normally: Damage = 15 * (DISTANCE / 30)
    // the gun should deal 3.75 damage
    ChainGun cg = new ChainGun();
    cg.currentAmmo = 25;

    // Decorate ChainGun with PowerBooster
    // Check to see if modified ChainGun damages normally: Power Booster Damage =
    // Damage X (1 + (ACTUALAMMO / 40)
    // the weapon with the PowerBooster should damage 4.875

    Weapon cgPb = new PowerBooster(cg);

    // Second Power Booster added
    Weapon cgPbPb = new PowerBooster(cgPb);
    assertEquals(6, cgPbPb.fire(15));
  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_PlasmaCannon_Stabilizer_PowerBooster()
      throws WeaponException, AttachmentException {
    // TEST WILL USE A PlasmaCannon WITH A DISTANCE OF 15, AND AMMO OF 3

    PlasmaCannon pc = new PlasmaCannon();
    pc.currentAmmo = 3;
    // damage = 37

    Weapon pcSt = new Stabilizer(pc);
    // assertEquals(46,PcSt.fire(15));
    // damage = 46
    Weapon pcStPb = new PowerBooster(pcSt);

    assertEquals(80, pcStPb.fire(15));

    // create PlasmaCannon
    // Check to see if PlasmaCannon damage works normally: Damage = 50 * (Actual
    // Ammo/ 4)
    // the gun should deal 37.5

    // Decorate PlasmaCannon with stabilizer
    // Check to see if modified PlasmaCannon damages normally: Damage = Damage *
    // 1.25
    // the modified PlasmaCannon should deal 46.875

    // check to see if stabilizer automatically reloads

  }

}
