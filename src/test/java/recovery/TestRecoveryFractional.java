package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryFractional {

  @Test
  public void testRecoverWhenNotHurt() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int currentHp = 100;
    int maxHp = 100;
    int result = rf.calculateRecovery(currentHp, maxHp);
    assertEquals(100, result);
  }

  @Test
  public void testRecoverOnce() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int currentHp = 73;
    int maxHp = 100;
    int result = rf.calculateRecovery(currentHp, maxHp);
    assertEquals(81, result);
  }

  @Test
  public void testRecoverOverMax() {
    RecoveryFractional rf = new RecoveryFractional(0.2);
    int currentHp = 90;
    int maxHp = 100;
    int result = rf.calculateRecovery(currentHp, maxHp);
    assertEquals(100, result);
  }

  @Test
  public void testRecoverWhenDead() {
    RecoveryFractional rf = new RecoveryFractional(0.2);
    int currentHp = 0;
    int maxHp = 100;
    int result = rf.calculateRecovery(currentHp, maxHp);
    assertEquals(0, result);
  }
}
