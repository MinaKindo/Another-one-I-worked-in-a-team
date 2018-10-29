package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.AttachmentException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Weapon;

/**
 * The test cases for the Cell class
 * 
 */
public class TestCell {
  
  /**
   * @author dh3187
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
   * @author dh3187
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
   * @author aa1184
   * @throws AttachmentException 
   * 
   */
  @Test
  public void testCanRemoveOneOrTwoWeapon() throws AttachmentException {
    Cell cell = new Cell();
    //create 2 weapon
    Weapon pistol = new Pistol();
    Weapon boostedPistol = new PowerBooster(pistol);
    //add both to cell
    cell.addWeapon(pistol);
    cell.addWeapon(boostedPistol);
    //should be 2
    assertEquals(2, cell.getWeaponsCount());
    //remove 1 weapon and check that it had been successfully removed
    assertEquals(pistol, cell.removeWeapon(pistol));
    assertEquals(1, cell.getWeaponsCount());
    //remove other weapon and check that it had been successfully removed
    assertEquals(boostedPistol, cell.removeWeapon(boostedPistol));
    assertEquals(0, cell.getWeaponsCount());
  }
  
  /**
   * @author aa1184
   * @throws AttachmentException 
   * 
   */
  @Test
  public void testNoMoreThanTwoWeapon() throws AttachmentException {
    Cell cell = new Cell();
    Weapon pistol1 = new Pistol();
    Weapon pistol2 = new Pistol();
    Weapon pistol3 = new Pistol();
    //try adding three weapon to the cell
    assertTrue(cell.addWeapon(pistol1)); //should be true
    assertTrue(cell.addWeapon(pistol2)); //should be true
    assertFalse(cell.addWeapon(pistol3)); //should be false  
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
