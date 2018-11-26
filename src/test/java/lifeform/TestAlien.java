package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;

public class TestAlien {

  /**
   * @author lh9509
   */
  @Test
  public void testMaxSpeedHuman() {
    Alien entity = null;
    try {
      entity = new Alien("Jeb", 10);
    } catch (RecoveryRateException e) {
      fail();
    }
    assertEquals(2, entity.getCurrentSpeed());
  }

  @Test
  public void testInitialization() {
    Alien entity = null;
    try {
      entity = new Alien("Afjaii", 10);
    } catch (RecoveryRateException e) {
      fail();
    }
    assertEquals("Afjaii", entity.getName());
    assertEquals(10, entity.getCurrentLifePoints());
  }

  @Test
  public void testLinearRecovery() {
    RecoveryBehavior rb = new RecoveryLinear(3);
    Alien entity = null;
    try {
      entity = new Alien("Ncowiur", 10, rb);
    } catch (RecoveryRateException e) {
      fail();
    }
    entity.setCurrentLifePoints(5);
    entity.recover();
    assertEquals(8, entity.getCurrentLifePoints());
  }

  @Test
  public void testDefaultAttackStrength() {
    Alien entity = null;
    try {
      entity = new Alien("Arsoth", 10);
    } catch (RecoveryRateException e) {
      e.printStackTrace();
    }

    assertEquals(10, entity.getAttackStrength());
  }

  @Test
  public void testSetRecoveryConstructor() {
    Alien entity = null;
    try {
      entity = new Alien("Tim", 10, null, 5);
    } catch (RecoveryRateException e) {
      e.printStackTrace();
    }

    assertEquals(5, entity.getRecoveryRate());
  }

  @Test
  public void testSetRecoverySetter() {
    Alien entity = null;
    try {
      entity = new Alien("Tim", 10);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setRecoveryRate(5);
    assertEquals(5, entity.getRecoveryRate());
  }

  @Test
  public void testZeroRecover() {
    Alien entity = null;
    try {
      entity = new Alien("sdfsdf", 10, new RecoveryLinear(1), 0);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setCurrentLifePoints(5);

    SimpleTimer timer = new SimpleTimer(1000);
    timer.addTimeObserver(entity);

    timer.timeChanged();
    assertEquals(5, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(5, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(5, entity.getCurrentLifePoints());
  }

  @Test
  public void testGreaterThanZeroRecover() {
    Alien entity = null;
    try {
      entity = new Alien("sdfsdf", 10, new RecoveryLinear(1), 2);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setCurrentLifePoints(5);

    SimpleTimer timer = new SimpleTimer(1000);
    timer.addTimeObserver(entity);

    timer.timeChanged();
    assertEquals(5, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(6, entity.getCurrentLifePoints());
  }

  @Test
  public void testAnotherRecover() {
    Alien entity = null;
    try {
      entity = new Alien("sdfsdf", 10, new RecoveryFractional(0.25), 4);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setCurrentLifePoints(4);

    SimpleTimer timer = new SimpleTimer(1000);
    timer.addTimeObserver(entity);

    timer.timeChanged();
    assertEquals(4, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(4, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(4, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(5, entity.getCurrentLifePoints());
  }

  @Test
  public void testTrackTime() {
    Alien entity = null;
    try {
      entity = new Alien("sdfsdf", 10, new RecoveryLinear(1), 1);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setCurrentLifePoints(5);

    SimpleTimer timer = new SimpleTimer(1000);
    timer.addTimeObserver(entity);

    timer.timeChanged();
    assertEquals(6, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(7, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(8, entity.getCurrentLifePoints());
  }

  @Test
  public void testRemoveTimeObserver() {
    Alien entity = null;
    try {
      entity = new Alien("sdfsdf", 10, new RecoveryLinear(1), 1);
    } catch (RecoveryRateException e) {
      fail();
    }

    entity.setCurrentLifePoints(5);

    SimpleTimer timer = new SimpleTimer(1000);
    timer.addTimeObserver(entity);

    timer.timeChanged();
    assertEquals(6, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(7, entity.getCurrentLifePoints());

    timer.removeTimeObserver(entity);

    timer.timeChanged();
    assertEquals(7, entity.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(7, entity.getCurrentLifePoints());
  }

  @Test
  public void testLessThanZeroRecover() {
    boolean exceptionThrown = false;

    try {
      new Alien("sdfsdf", 10, new RecoveryLinear(1), -1);
    } catch (RecoveryRateException e) {
      exceptionThrown = true;
    }

    if (!exceptionThrown) {
      fail();
    }
  }
}
