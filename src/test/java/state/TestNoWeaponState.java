package state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestNoWeaponState {

  // lab 7 tests
  
  @Test
  public void testWeapon() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getNoWeaponState());
    Weapon w1 = new Pistol();
    environment.addLifeForm(lifeForm, 1, 2);
    environment.addWeapon(w1, lifeForm.getRow(), lifeForm.getCol());
    ai.executeAction();
    assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
  }

  @Test
  public void testNoWeapon() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AiContext ai = new AiContext(environment, lifeForm);
    environment.addLifeForm(lifeForm, 1, 2);
    ai.setCurrentState(ai.getNoWeaponState());
    ai.executeAction();
    environment.getLifeForm(1, 2);
  }

  @Test
  public void testDead() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 0);
    AiContext ai = new AiContext(environment, lifeForm);
    ai.setCurrentState(ai.getNoWeaponState());
    ai.executeAction();
    assertEquals(ai.getCurrentState(), ai.getDeadState());
  }

}
