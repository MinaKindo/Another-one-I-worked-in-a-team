
package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Pistol;
import weapon.Weapon;

public class TestDeadState {

	@Test
	public void testWithWeapon() throws RecoveryRateException {
		Environment e = Environment.getEnvironment(4, 4);
		LifeForm h = new Human("bob", 10, 10);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h); 
		h.pickUpWeapon(pistol);
		assertTrue(h.hasWeapon());
		h.takeHit(20);
		ai.setCurrentState(ai.getDeadState());
		ai.executeAction();
		assertFalse(h.hasWeapon());
		assertEquals(10, h.getCurrentLifePoints());
		assertEquals(ai.getCurrentState(), ai.getHasNoWeaponsState());
		
	}
	
	@Test
	public void testWithoutWeapon() throws RecoveryRateException {
		Environment e = Environment.getEnvironment(4, 4);
		LifeForm h = new Human("bob", 10, 10);
		AIContext ai = new AIContext(e, h); 
		assertFalse(h.hasWeapon());
		h.takeHit(20);
		ai.setCurrentState(ai.getDeadState());
		ai.executeAction();
		assertFalse(h.hasWeapon());	
		assertEquals(10, h.getCurrentLifePoints());
		assertEquals(ai.getCurrentState(), ai.getHasNoWeaponsState());
	}
}
