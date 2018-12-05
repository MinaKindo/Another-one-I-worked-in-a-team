package recovery;

/**
 * @author Dr. Alice Armstrong RecoveryLinear objects recover a fixed number of
 *         life points each time Life points cannot exceed the maximum number of
 *         life points
 */
public class RecoveryLinear implements RecoveryBehavior {

  private int recoveryAmount; // the amount recovered for this behavior

  public RecoveryLinear(int recoveryAmount) {
    this.recoveryAmount = recoveryAmount;
  }

  /**
   * @see recovery.RecoveryBehavior#calculateRecovery(int, int)
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    int temp = currentLife + recoveryAmount;

    if (currentLife <= 0) {
      // can't recover from death
      return 0;
    } else if (temp < maxLife) {
      // recover recoveryAmount
      return temp;
    } else {
      // otherwise recover to max
      return maxLife;
    }
  }

}
