package state;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import recovery.RecoveryNone;
import weapon.Pistol;
import weapon.Weapon;

public class TestHasWeaponState {

	Environment e = Environment.getEnvironment(100, 100);

	@Before
	public void testBefore() {
		e.clearBoard();
	}

	@Test
	public void testWhenOutOfAmmo() throws WeaponException {
		LifeForm h = new Human("bob", 10, 10);
		e.addLifeForm(h, 1, 2);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		for (int i = 0; i < 10; i++) {
			pistol.fire(9);
			pistol.updateTime(2);
		}
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(ai.getCurrentState(), ai.getOutOfAmmoState());
	}

	@Test
	public void testWhenNoTarget() throws WeaponException {
		LifeForm h = new Human("bob", 10, 10);
		e.addLifeForm(h, 1, 2);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(10, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
	}

	@Test
	public void testWhenSameTarget() throws WeaponException {
		LifeForm h = new Human("bob", 10, 10);
		LifeForm b = new Human("bob", 10, 10);
		e.addLifeForm(h, 1, 2);
		e.addLifeForm(b, 1, 3);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(10, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
	}

	@Test
	public void testWhenDifferentTarget() throws WeaponException, RecoveryRateException {
		LifeForm h = new Human("bob", 10, 10);
		LifeForm b = new Alien("bob", 10, new RecoveryNone(), 2);
		e.addLifeForm(h, 1, 2);
		e.addLifeForm(b, 1, 1);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(9, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
	}
	
	@Test
	public void testWhenDifferentTargetWithOneShot() throws WeaponException, RecoveryRateException {
		LifeForm h = new Human("bob", 10, 10);
		LifeForm b = new Alien("bob", 10, new RecoveryNone(), 2);
		e.addLifeForm(h, 1, 2);
		e.addLifeForm(b, 1, 1);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		
		for (int i = 0; i < 9; i++) {
			pistol.fire(9);
			pistol.updateTime(2);
		}
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(0, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getOutOfAmmoState());
	}
	
	@Test
	public void testWhenDead() throws WeaponException, RecoveryRateException {
		LifeForm h = new Human("bob", 10, 10);
		LifeForm b = new Alien("bob", 10, new RecoveryNone(), 2);
		e.addLifeForm(h, 1, 2);
		e.addLifeForm(b, 1, 1);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		h.pickUpWeapon(pistol);
		h.takeHit(20);
		ai.executeAction();
		assertEquals(10, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getDeadState());
	}
	
	@Test
	public void testWhenTargetOutOfRange() throws WeaponException, RecoveryRateException {
		LifeForm h = new Human("bob", 10, 10);
		LifeForm b = new Alien("bob", 10, new RecoveryNone(), 2);
		e.addLifeForm(h, 99, 99);
		e.addLifeForm(b, 1, 1);
		Weapon pistol = new Pistol();
		AIContext ai = new AIContext(e, h);
		ai.setCurrentState(ai.getHasWeaponState());
		h.pickUpWeapon(pistol);

		ai.executeAction();
		assertEquals(10, h.getWeapon().getCurrentAmmo());
		assertEquals(ai.getCurrentState(), ai.getHasWeaponState());
	}
}
