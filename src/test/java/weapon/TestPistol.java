package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPistol {

  /**
   * @author ad5146
   */
  @Test
  public void testDamage() throws WeaponException {
    Pistol pistol = new Pistol();

    assertEquals(10, pistol.fire(10));
    assertEquals(9, pistol.fire(15));
  }
}
