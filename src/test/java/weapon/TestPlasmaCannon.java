package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPlasmaCannon {

  /**
   * @author ad5146
   */
  @Test
  public void testDamage() throws WeaponException {
    PlasmaCannon plasmaCannon = new PlasmaCannon();

    assertEquals(50, plasmaCannon.fire(1));
    plasmaCannon.shotsLeft = 1;
    assertEquals(37, plasmaCannon.fire(1));
  }
}
