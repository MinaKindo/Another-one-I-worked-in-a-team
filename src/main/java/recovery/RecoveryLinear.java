package recovery;

public class RecoveryLinear implements RecoveryBehavior {

  int recoveryStep;

  public RecoveryLinear(int step) {
    this.recoveryStep = step;
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife <= 0) {
      return 0;
    }

    currentLife += recoveryStep;
    if (currentLife > maxLife) {
      currentLife = maxLife;
    }
    return currentLife;
  }
}
