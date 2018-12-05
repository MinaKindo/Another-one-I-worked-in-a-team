
package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RecoveryRateException;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestDeadState {

  Environment environment = Environment.getEnvironment(4, 4);

  @Before
  public void testBefore() {
    environment.clearBoard();
  }

  // lab 7 tests

  @Test
  public void testWithWeapon() throws RecoveryRateException {
    LifeForm h = new Human("bob", 10, 10);
    environment.addLifeForm(h, 1, 1);
    Weapon pistol = new Pistol();
    h.pickUpWeapon(pistol);
    assertTrue(h.hasWeapon());
    h.takeHit(20);
    AiContext ai = new AiContext(environment, h);
    ai.setCurrentState(ai.getDeadState());
    ai.executeAction();
    assertFalse(h.hasWeapon());
    assertEquals(10, h.getCurrentLifePoints());
    assertEquals(ai.getCurrentState(), ai.getNoWeaponState());

  }

  @Test
  public void testWithoutWeapon() throws RecoveryRateException {
    LifeForm h = new Human("bob", 10, 10);
    environment.addLifeForm(h, 1, 1);
    AiContext ai = new AiContext(environment, h);
    assertFalse(h.hasWeapon());
    h.takeHit(20);
    ai.setCurrentState(ai.getDeadState());
    ai.executeAction();
    assertFalse(h.hasWeapon());
    assertEquals(10, h.getCurrentLifePoints());
    assertEquals(ai.getCurrentState(), ai.getNoWeaponState());
  }
}
