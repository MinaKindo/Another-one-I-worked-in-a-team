package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.WeaponException;
import gameplay.SimpleTimer;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
 * Tests the functionality provided by the LifeForm class
 * 
 */
public class TestLifeForm {

  /**
   * @author ad5146
   */
  @Test
  public void testStoreRowCol() {
    LifeForm lf = new MockLifeForm("A", 5);
    lf.setLocation(2, 4);
    assertEquals(2, lf.getRow());
    assertEquals(4, lf.getCol());
  }
  
  @Test
  public void testRowColInitialize() {
    LifeForm lf = new MockLifeForm("B", 5);
    assertEquals(-1, lf.getRow());
    assertEquals(-1, lf.getCol());
  }
  
  @Test
  public void testNegativeLocation() {
    LifeForm lf = new MockLifeForm("C", 5);
    
    lf.setLocation(-1, 4);
    assertEquals(-1, lf.getRow());
    assertEquals(-1, lf.getCol());
    
    lf.setLocation(1, -4);
    assertEquals(-1, lf.getRow());
    assertEquals(-1, lf.getCol());
  }
  
  /*
   * Beginning of lab 4 tests
   */
  
  /**
   * @author dh3187
   */
  @Test
  public void testPickUpWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    Weapon w1 = new Pistol();
    assertTrue(entity.pickUpWeapon(w1));
    assertTrue(entity.hasWeapon());
  }

  /**
   * @author dh3187
   */
  @Test
  public void testNoMoreThanOneWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    Weapon w1 = new Pistol();
    Weapon w2 = new Pistol();
    assertTrue(entity.pickUpWeapon(w1));
    assertFalse(entity.pickUpWeapon(w2));
  }

  /**
   * @author dh3187
   */
  @Test
  public void testDropWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    Weapon w1 = new Pistol();
    assertTrue(entity.pickUpWeapon(w1));
    assertEquals(w1, entity.dropWeapon());
    assertFalse(entity.hasWeapon());
  }

  /**
   * @author dh3187
   * @throws WeaponException
   */
  @Test
  public void testUseWeaponDamage() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 50);
    Weapon w1 = new PlasmaCannon();
    assertTrue(bob.pickUpWeapon(w1));
    bob.attack(fred, 10);
    assertEquals(3, w1.getCurrentAmmo());
    assertEquals(0, fred.getCurrentLifePoints());
  }

  /**
   * @author dh3187
   * @throws WeaponException
   */
  @Test
  public void testNoAmmo() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 200);
    Weapon w1 = new PlasmaCannon();
    SimpleTimer st = new SimpleTimer();
    assertTrue(bob.pickUpWeapon(w1));
    for (int i = 0; i < 4; i++) {
      bob.attack(fred, 10);
      st.timeChanged();
      w1.updateTime(0);
    }
    assertEquals(0, w1.getCurrentAmmo());
    assertEquals(76, fred.getCurrentLifePoints());
    bob.attack(fred, 5);
    assertEquals(75, fred.getCurrentLifePoints());
  }

  /**
   * @author dh3187
   * @throws WeaponException
   */
  @Test
  public void testNoDamage() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    bob.attack(fred, 10);
    assertEquals(40, fred.getCurrentLifePoints());
  }

  /**
   * @author dh3187
   * @throws WeaponException
   */
  @Test
  public void testReload() throws WeaponException {
    LifeForm entity = new MockLifeForm("Bob", 40);
    Weapon w1 = new PlasmaCannon();
    assertTrue(entity.pickUpWeapon(w1));
    w1.fire(10);
    w1.reload();
    assertEquals(w1.getMaxAmmo(), w1.getCurrentAmmo());
  }

  /**
   * Beginning of lab 3 tests
   */

  /**
   * When a LifeForm is created, it should know its name and how many life points
   * it has.
   */
  @Test
  public void testStoreLifePoints() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40);
    assertEquals(40, entity.getCurrentLifePoints());
  }

  @Test
  public void testStoreName() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
  }

  @Test
  public void testTakeHitFirst() {
    LifeForm entity = new MockLifeForm("Bill", 10);

    entity.takeHit(5);
    assertEquals(5, entity.getCurrentLifePoints());
  }

  @Test
  public void testTakeHitAgain() {
    LifeForm entity = new MockLifeForm("Bill", 10);

    entity.takeHit(5);
    entity.takeHit(3);

    assertEquals(2, entity.getCurrentLifePoints());
  }

  @Test
  public void testHurtLifeForm() {
    LifeForm entityA = new MockLifeForm("sdfj", 10, 3);
    LifeForm entityB = new MockLifeForm("rhbt", 10, 3);

    entityA.attack(entityB, 5);

    assertEquals(7, entityB.getCurrentLifePoints());
  }

  @Test
  public void testAttackWhenDead() {
    LifeForm entityA = new MockLifeForm("sdfj", 0, 3);
    LifeForm entityB = new MockLifeForm("rhbt", 10, 3);

    entityA.attack(entityB, 5);

    assertEquals(10, entityB.getCurrentLifePoints());
  }
}
