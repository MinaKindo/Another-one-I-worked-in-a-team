package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryNone {

  @Test
  public void testEqualsMax() {
    RecoveryNone rec = new RecoveryNone();

    int currentLifePoints = 5;
    int maxLifePoints = 5;
    currentLifePoints = rec.calculateRecovery(currentLifePoints, maxLifePoints);

    assertEquals(currentLifePoints, maxLifePoints);
  }

  @Test
  public void testLessThanMax() {
    RecoveryNone test = new RecoveryNone();

    int oldLifePoints = 2;
    int maxLifePoints = 5;
    int newLifePoints = test.calculateRecovery(oldLifePoints, maxLifePoints);

    assertEquals(newLifePoints, oldLifePoints);
  }
}