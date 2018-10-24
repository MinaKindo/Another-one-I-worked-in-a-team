package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryLinear {

  @Test
  public void testRecoverWhenNotHurt() {
    RecoveryLinear r1 = new RecoveryLinear(3);
    int maxLifePts = 30;
    int result = r1.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  @Test
  public void testRecoverOnce() {
    RecoveryLinear r1 = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLife = 10;
    int result = r1.calculateRecovery(currentLife, maxLifePts);
    assertEquals(13, result);

  }

  @Test
  public void testRecoverOverMax() {
    RecoveryLinear r1 = new RecoveryLinear(5);
    int maxLifePts = 10;
    int currentLife = 8;
    int result = r1.calculateRecovery(currentLife, maxLifePts);
    assertEquals(10, result);
  }

  @Test
  public void testRecoverWhenDead() {
    RecoveryLinear r1 = new RecoveryLinear(5);
    int maxLifePts = 10;
    int currentLife = 0;
    int result = r1.calculateRecovery(currentLife, maxLifePts);
    assertEquals(0, result);
  }
}
