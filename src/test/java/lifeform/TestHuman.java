package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHuman {

  /**
   * @author lh9509
   */
  @Test
  public void testMaxSpeedHuman() {
    Human entity = new Human("Louis", 10, 8);
    assertEquals(3, entity.getCurrentSpeed());
  }

  @Test
  public void testInitialization() {
    Human entity = new Human("Frank", 10, 8);
    assertEquals("Frank", entity.getName());
    assertEquals(10, entity.getCurrentLifePoints());
    assertEquals(8, entity.getArmorPoints());
  }

  @Test
  public void testSetArmorPoints() {
    Human entity = new Human("Joe", 10, 8);

    entity.setArmorPoints(1000);
    assertEquals(1000, entity.getArmorPoints());
  }

  @Test
  public void testGetArmorPoints() {
    Human entity = new Human("Sarah", 10, 8);

    assertEquals(8, entity.getArmorPoints());
  }

  @Test
  public void testMinArmorPoints() {
    Human entity = new Human("Bob", 8, 10);
    entity.setArmorPoints(-9);
    assertEquals(0, entity.getArmorPoints());

    entity = new Human("Bob", 8, -7);
    assertEquals(0, entity.getArmorPoints());
  }

  @Test
  public void testDefaultAttackDamage() {
    Human entity = new Human("Bob", 10, 3);
    assertEquals(5, entity.getAttackStrength());
  }

  @Test
  public void testDamageLessThanArmor() {
    Human entity = new Human("Bob", 10, 3);
    entity.takeHit(2);
    assertEquals(10, entity.getCurrentLifePoints());
  }

  @Test
  public void testDamageGreaterThanArmor() {
    Human entity = new Human("Bob", 10, 3);
    entity.takeHit(5);
    assertEquals(8, entity.getCurrentLifePoints());
  }

  @Test
  public void testDamageEqualsArmor() {
    Human entity = new Human("Bob", 10, 3);
    entity.takeHit(3);
    assertEquals(10, entity.getCurrentLifePoints());
  }
}
