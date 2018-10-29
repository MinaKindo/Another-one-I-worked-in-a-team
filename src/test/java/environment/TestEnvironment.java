package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.Scope;
import weapon.Weapon;

public class TestEnvironment {
  
  @Test
  public void testRemoveWeapon() {
    Environment environment = new Environment(4, 4);
    ChainGun cg = new ChainGun();
    Weapon cGScp = new Scope(cg);
    environment.addWeapon(cGScp, 3, 1);
    assertEquals(cGScp, environment.getWeapon(3, 1));
    environment.removeWeapon(3,1);
    assertNull(environment.getWeapon(3, 1));
  }
  
  @Test
  public void testAddWeapon() {
    Environment environment = new Environment(4, 4);
    Pistol ptl = new Pistol();
    environment.addWeapon(ptl, 1, 3);
    assertEquals(ptl, environment.getWeapon(1, 3));
  }
  
  @Test
  public void testSingletonInitialize() {
    
  }
  
  /**
   * ^^ Tests for Singleton Pattern start here ^^
   * @author sb0476
   */

  /* lab 5 tests */ 
  @Test
  public void testGetDistanceAlongSameRow() {
    Environment ev = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1",3);
    LifeForm entity2 = new MockLifeForm("name2",3);
    ev.addLifeForm(entity1, 2, 2);
    ev.addLifeForm(entity2, 2, 1);
    assertEquals(5,ev.getDistance​(3, 3, 2, 3),.001);
  }
  
  @Test
  public void testGetDistanceAlongSameCol() {
    Environment ev = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1",3);
    LifeForm entity2 = new MockLifeForm("name2",3);
    ev.addLifeForm(entity1, 2, 2);
    ev.addLifeForm(entity2, 2, 1);
    assertEquals(10,ev.getDistance​(3, 1, 3, 3),.001);
  }
  
  @Test
  public void getDistanceNotAlongSameRowOrColumn() {
    Environment ev = new Environment(4,4);
    LifeForm entity1 = new MockLifeForm("name1",3);
    LifeForm entity2 = new MockLifeForm("name2",3);
    ev.addLifeForm(entity1, 2, 2);
    ev.addLifeForm(entity2, 2, 1);
    assertEquals((5*2.236),ev.getDistance​(4, 3, 2, 2),.001);
  }
  
  /* *********** */
  
  @Test
  public void testInitialization() {
    Environment environment = new Environment(1, 1);
    LifeForm entity = environment.getLifeForm(0, 0);
    assertNull(entity);
  }

  @Test
  public void testAddLifeForm() {
    Environment environment = new Environment(2, 3);
    LifeForm entity = new MockLifeForm("Bob", 20);
    environment.addLifeForm(entity, 1, 2);
    assertEquals(entity, environment.getLifeForm(1, 2));
  }

  @Test
  public void testBoundaries() {
    Environment environment = new Environment(3, 2);
    LifeForm entity = new MockLifeForm("Ted", 15);
    try {
      environment.addLifeForm(entity, 5, 0);
      fail();
    } catch (Exception ex) {
      ex = null;
    }
  }

  @Test
  public void testRemoveLifeForm() {
    Environment environment = new Environment(1, 1);
    LifeForm entity = new MockLifeForm("Jeff", 10);
    environment.addLifeForm(entity, 0, 0);
    assertEquals(entity, environment.getLifeForm(0, 0));
    environment.removeLifeForm(0, 0);
    assertNull(environment.getLifeForm(0, 0));
  }
}
