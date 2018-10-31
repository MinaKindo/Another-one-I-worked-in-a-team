package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * @author sb0476
 */
public class TestScope {

  // Test a pistol with a scope at a distance of 15 (within
  // baseWeapon.getMaxRange)
  // Damage: 9 >> 15.75 -> 15
  @Test
  public void testPistolScope() throws WeaponException, AttachmentException {

    Pistol ptl = new Pistol();
    Weapon ptlScp = new Scope(ptl); // Distance 50 >> 60
    assertEquals(15, ptlScp.fire(15));
  }

  // Test a pistol with a scope at an amped distance of 51
  // Damage: 2 + 5 >> 7
  @Test
  public void testPistolScopeAmpedDistance() throws WeaponException, AttachmentException {
    Pistol ptl = new Pistol();
    Weapon ptlScp = new Scope(ptl); // Distance 50 >> 60
    assertEquals(7, ptlScp.fire(51));
  }

  // Test a pistol with a scope and another scope at a doubly amped distance of 69
  // Damage: 2 + 5 >> 7 + 5 >> 12
  @Test
  public void testPistolScopeScope() throws WeaponException, AttachmentException {
    Pistol ptl = new Pistol();
    Weapon ptlScp = new Scope(ptl); // Distance 50 >> 60
    Weapon ptlScpScp = new Scope(ptlScp); // Distance 60 >> 70
    assertEquals(12, ptlScpScp.fire(69));

  }

  // Test a chain gun with a power booster and a scope at a distance of 31 with 13
  // ammo
  // Damage: 7.75 >> 7.75 * 13.25 >> 10.26875 >> 10.26875 * 1.5571428571 >>
  // 15.9899107143 -> 15
  @Test
  public void testChainGunPowerBoosterScope() throws WeaponException, AttachmentException {
    ChainGun cg = new ChainGun();
    cg.currentAmmo = 13;
    // the more ammo it has, the more damage dealt (13 of 40 ammo remain)
    Weapon cgPb = new PowerBooster(cg);

    Weapon cgPbScp = new Scope(cgPb); // Distance 60 >> 70
    assertEquals(14, cgPbScp.fire(31));

  }

  // Test a plasma cannon with stabilizer and a scope at an amped distance of 45
  // with 1 ammo
  // Damage: 12.5 >> 12.5 + 25% >> 15.625 >> 15.625 + 5 >> 20.625 -> 20
  @Test
  public void testPlasmaCannonStabilizerScope() throws WeaponException, AttachmentException {
    PlasmaCannon pmcn = new PlasmaCannon();
    pmcn.currentAmmo = 1;
    Weapon pmCnSbr = new Stabilizer(pmcn); // increase damage by 25%
    Weapon pmCnSbrScp = new Scope(pmCnSbr); // Distance 40 >> 45
    assertEquals(20, pmCnSbrScp.fire(45));

  }

}