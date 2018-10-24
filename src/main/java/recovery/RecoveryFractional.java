package recovery;

public class RecoveryFractional implements RecoveryBehavior {

  private double recoveryFraction;
  
  public RecoveryFractional(double rf) {
    recoveryFraction = rf;
  }
  
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    double recoverExact = currentLife * recoveryFraction;
    int recover = (int) (currentLife * recoveryFraction);
    
    double remainder = recoverExact - recover;
    
    if (remainder > 0) {
      recover++;
    }
    
    int result = currentLife + recover;
    
    if (result > maxLife) {
      result = maxLife;
    }
    return result;
  }
}