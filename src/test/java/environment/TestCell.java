package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * The test cases for the Cell class
 * 
 */
public class TestCell {
  
  /**
   * At initialization, the Cell should be empty and not contain a LifeForm
   * or weapons.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
    assertNull(cell.getWeapon1());
    assertNull(cell.getWeapon2());
  }
  
  /**
   * The cell should be able to hold up to two weapons.
   */
  @Test
  public void testAddWeapons() {
    Cell cell = new Cell();
    Weapon w1 = new Pistol();
    Weapon w2 = new ChainGun();
    Weapon w3 = new PlasmaCannon();
    assertEquals(0, cell.getWeaponsCount());
    assertTrue(cell.addWeapon(w1));
    assertEquals(w1, cell.getWeapon1());
    assertEquals(1, cell.getWeaponsCount());
    assertTrue(cell.addWeapon(w2));
    assertEquals(w2, cell.getWeapon2());
    assertEquals(2, cell.getWeaponsCount());
    assertFalse(cell.addWeapon(w3));
  }
  
  /**
   * Beginning of Decorator Pattern tests
   */

  /**
   * Checks to see if we change the LifeForm held by the Cell that getLifeForm
   * properly responds to the change.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();

    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
  }

  @Test
  public void testPresentLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();

    cell.addLifeForm(bob);
    boolean success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  @Test
  public void testRemoveLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();

    cell.addLifeForm(bob);
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
  }
}
