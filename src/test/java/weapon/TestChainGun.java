package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;

public class TestChainGun {

  /**
   * @author ad5146
   */
  @Test
  public void testDamage() throws WeaponException {
    ChainGun chainGun = new ChainGun();

    assertEquals(2, chainGun.fire(10));
    assertEquals(5, chainGun.fire(20));
  }
}
