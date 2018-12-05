package state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import environment.Environment;
import exceptions.WeaponException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestOutOfAmmoState {

  @Test
  public void testInitialization() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getOutOfAmmoState());
  }
  
  @Test
  public void testReload() throws WeaponException {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getOutOfAmmoState());
    Weapon w1 = new Pistol();
    assertTrue(lifeForm.pickUpWeapon(w1));
    w1.fire(10);
    assertEquals(9, w1.getCurrentAmmo());
    ai.executeAction();
    assertEquals(10, w1.getCurrentAmmo());
  }

  @Test
  public void testState() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getOutOfAmmoState());
    Weapon w1 = new Pistol();
    assertTrue(lifeForm.pickUpWeapon(w1));
    ai.executeAction();
    assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
  }
  
  @Test
  public void testDead() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 0);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getOutOfAmmoState());
    ai.executeAction();
    assertEquals(ai.getCurrentState(), ai.getDeadState());
  }
 
}
