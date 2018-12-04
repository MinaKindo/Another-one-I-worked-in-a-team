package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestNoWeaponState {

  @Test
  public void testWeapon() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 5);
    AIContext ai = new AIContext(environment, lifeForm);
    ai.setCurrentState(ai.getHasNoWeaponsState());
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
    AIContext ai = new AIContext(environment, lifeForm);
    environment.addLifeForm(lifeForm, 1, 2);
    ai.setCurrentState(ai.getHasNoWeaponsState());
    ai.executeAction();
    environment.getLifeForm(1, 2);
  }
  
  @Test
  public void testDead() {
    Environment environment = Environment.getEnvironment(4, 4);
    LifeForm lifeForm = new MockLifeForm("Fred", 0);
    AIContext ai = new AIContext(environment, lifeForm);
    ai.setCurrentState(ai.getHasNoWeaponsState());
    ai.executeAction();
    assertEquals(ai.getCurrentState(), ai.getDeadState());
  }

}
