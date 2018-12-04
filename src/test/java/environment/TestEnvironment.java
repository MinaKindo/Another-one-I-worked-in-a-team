package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.EnvironmentException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.Scope;
import weapon.Weapon;

public class TestEnvironment {
  Environment environment = Environment.getEnvironment(4, 4);

  /* lab 5 tests */

  @Before
  public void testBefore() {
    environment.clearBoard();
  }

  /**
   * @author lh9509
   */
  @Test
  public void testMovementNorth() {

    // move north
    LifeForm entity1 = new MockLifeForm("Bob", 20);
    LifeForm entity2 = new MockLifeForm("Bill", 30);

    environment.addLifeForm(entity1, 2, 3);
    environment.addLifeForm(entity2, 1, 3);

    entity1.setMaxSpeed(1);
    environment.move(entity1);

    assertEquals(entity1, environment.getLifeForm(2, 3));
  }

  /**
   * @author lh9509
   */
  @Test
  public void testMovementWest() {
    LifeForm entity1 = new MockLifeForm("Bob", 20);
    LifeForm entity2 = new MockLifeForm("Bill", 30);

    environment.addLifeForm(entity1, 2, 3);
    environment.addLifeForm(entity2, 2, 1);

    entity1.setMaxSpeed(2);
    entity1.setDirection("West");
    environment.move(entity1);

    assertEquals(entity1, environment.getLifeForm(2, 2));
  }

  /**
   * @author lh9509
   */
  @Test
  public void testMovementSouth() {
    LifeForm entity1 = new MockLifeForm("Bob", 20);
    LifeForm entity2 = new MockLifeForm("Bill", 30);

    environment.addLifeForm(entity1, 0, 3);
    environment.addLifeForm(entity2, 2, 3);

    entity1.setMaxSpeed(2);
    entity1.setDirection("South");
    environment.move(entity1);

    assertEquals(entity1, environment.getLifeForm(1, 3));
  }

  /**
   * @author lh9509
   */
  @Test
  public void testMovementEast() {

    LifeForm entity1 = new MockLifeForm("Bob", 20);
    LifeForm entity2 = new MockLifeForm("Bill", 30);

    environment.addLifeForm(entity1, 0, 0);
    environment.addLifeForm(entity2, 0, 3);

    entity1.setMaxSpeed(4);
    entity1.setDirection("East");
    environment.move(entity1);

    assertEquals(entity1, environment.getLifeForm(0, 2));
  }

  /**
   * @author lh9509
   */
  @Test
  public void testMovementBounds() {

    /* Tests Vertical Movement */
    LifeForm entity1 = new MockLifeForm("Bob", 20);
    environment.addLifeForm(entity1, 2, 2);
    entity1.setMaxSpeed(10);

    /* Tests North Bounds */
    environment.move(entity1);
    assertEquals(entity1, environment.getLifeForm(0, 2));

    /* Tests South Bounds */
    entity1.setDirection("South");
    environment.move(entity1);
    assertEquals(entity1, environment.getLifeForm(3, 2));

    /* Tests horizontal movement */
    LifeForm entity2 = new MockLifeForm("Bill", 30);
    environment.addLifeForm(entity2, 0, 0);

    /* Tests East Bounds */
    entity2.setDirection("East");
    entity2.setMaxSpeed(100);
    environment.move(entity2);
    assertEquals(entity2, environment.getLifeForm(0, 3));

    /* Tests West Bounds */
    entity2.setDirection("West");
    environment.move(entity2);
    assertEquals(entity2, environment.getLifeForm(0, 0));
  }

  /**
   * @author lh9509
   */
  @Test
  public void testSingletonInitialize() {
    // make sure you can build ONE environment
    // meaning: build one, check to see if not null
    // also
    // try to make another of a different size
    // make sure the r/c = the first one you made, not the new attempt
    environment = Environment.getEnvironment(10, 10);
    assertEquals(4, environment.getNumCols());
  }

  /**
   * @author lh9509
   */
  @Test
  public void testAddWeapon() {
    // Environment environment = Environment(4, 4);
    Pistol ptl = new Pistol();
    assertTrue(environment.addWeapon(ptl, 1, 3));
    assertEquals(ptl, environment.getWeapons(1, 3)[0]);
  }

  /**
   * @author lh9509
   */
  @Test
  public void testRemoveWeapon() throws AttachmentException {
    ChainGun cg = new ChainGun();
    Weapon cgScp = new Scope(cg);
    environment.addWeapon(cgScp, 3, 1);
    Weapon[] w = environment.getWeapons(3, 1);
    assertEquals(cgScp, w[0]);

    environment.removeWeapon(cgScp, 3, 1);
    // assertNull(environment.getWeapons(3, 1));

    w = environment.getWeapons(3, 1);

    assertNull(w[0]);
    assertNull(w[1]);
  }

  /**
   * @author lh9509
   */
  @Test
  public void testGetDistanceAlongSameRow() throws EnvironmentException {
    // Environment ev = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1", 3);
    LifeForm entity2 = new MockLifeForm("name2", 3);
    environment.addLifeForm(entity1, 2, 2);
    environment.addLifeForm(entity2, 2, 1);
    assertEquals(5, environment.getDistance(3, 3, 2, 3), .001);
  }

  /**
   * @author lh9509
   */
  @Test
  public void testGetDistanceAlongSameCol() throws EnvironmentException {
    // Environment ev = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1", 3);
    LifeForm entity2 = new MockLifeForm("name2", 3);
    environment.addLifeForm(entity1, 2, 2);
    environment.addLifeForm(entity2, 2, 1);
    assertEquals(10, environment.getDistance(3, 1, 3, 3), .001);
  }

  /**
   * @author lh9509
   */
  @Test
  public void testGetDistanceNotAlongSameRowOrColumn() throws EnvironmentException {
    // Environment environment = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1", 3);
    LifeForm entity2 = new MockLifeForm("name2", 3);
    environment.addLifeForm(entity1, 3, 3);
    environment.addLifeForm(entity2, 2, 2);
    assertEquals((5 * Math.sqrt(2)), environment.getDistance(3, 3, 2, 2), .00001);
    assertEquals((5 * Math.sqrt(2)), environment.getDistance(entity1, entity2), .001);

  }

  /* *********** */

  @Test
  public void testInitialization() {
    // Environment environment = new Environment(1, 1);
    LifeForm entity = environment.getLifeForm(0, 0);
    assertNull(entity);
  }

  @Test
  public void testAddLifeForm() {
    // Environment environment = new Environment(2, 3);
    LifeForm entity = new MockLifeForm("Bob", 20);
    environment.addLifeForm(entity, 1, 2);
    assertEquals(entity, environment.getLifeForm(1, 2));
  }

  @Test
  public void testBoundaries() {
    // Environment environment = new Environment(3, 2);
    LifeForm entity = new MockLifeForm("Ted", 15);
    assertFalse(environment.addLifeForm(entity, 5, 0));
  }

  @Test
  public void testRemoveLifeForm() {
    // Environment environment = new Environment(1, 1);
    LifeForm entity = new MockLifeForm("Jeff", 10);
    environment.addLifeForm(entity, 0, 0);
    assertEquals(entity, environment.getLifeForm(0, 0));
    environment.removeLifeForm(0, 0);
    assertNull(environment.getLifeForm(0, 0));
  }
}
