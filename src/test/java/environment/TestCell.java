package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 * 
 */
public class TestCell {
  
  /**
   * At initialization, the Cell should be empty and not contain a LifeForm.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
    assertNull(cell.getWeapon1());
    assertNull(cell.getWeapon2());
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
