package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestStabilizer {

  /**
   * @author @lh9509
   */
  @Test
  public void test_PlasmaCannon_Stabilizer() throws WeaponException, AttachmentException {
    PlasmaCannon pc = new PlasmaCannon();
    pc.currentAmmo = 3;
    // damage = 37

    Weapon pcSt = new Stabilizer(pc);
    assertEquals(46, pcSt.fire(15));
  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_PlasmaCannon_Stabilizer_Stabilizer()
      throws WeaponException, AttachmentException {
    PlasmaCannon pc = new PlasmaCannon();
    pc.currentAmmo = 3;
    // damage = 37

    Weapon pcSt = new Stabilizer(pc);
    Weapon pcStSt = new Stabilizer(pcSt);
    assertEquals(57, pcStSt.fire(15));

  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_Pistol_Scope_Stabilizer() throws WeaponException, AttachmentException {

    Pistol p = new Pistol();
    p.currentAmmo = 8;

    Weapon ps = new Scope(p);
    assertEquals(15, ps.fire(15));

    Weapon psSt = new Stabilizer(ps);
    assertEquals(18, psSt.fire(15));

  }

  /**
   * @author @lh9509
   */
  @Test
  public void test_ChainGun_PowerBooster_Stabilizer() throws WeaponException, AttachmentException {

    ChainGun cg = new ChainGun();
    cg.currentAmmo = 25;

    Weapon cgPb = new PowerBooster(cg);
    assertEquals(4, cgPb.fire(15));
  }
}