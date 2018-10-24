package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestEnvironment {

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
