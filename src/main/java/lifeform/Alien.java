package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;

public class Alien extends LifeForm implements TimerObserver {

  private int maxLifePoints;
  private RecoveryBehavior recoveryBehavior;
  private int recoverRate;

  /**
   * Aliens recreated with a RecoveryBehavior are RecoveryNone by default Aliens
   * have an attack strength of 10, by default Aliens have a recovery Rate of 0
   * (will never recover) by default
   * 
   * @param name
   * @param points
   * @throws RecoveryRateException this should never be thrown
   */
  public Alien(String name, int points) throws RecoveryRateException {
    super(name, points, 10);
    maxLifePoints = points;
    recoverRate = 0;
  }

  /**
   * Aliens have an attack strength of 10, by default Aliens have a recovery Rate
   * of 0 (will never recover) by default
   * 
   * @param name
   * @param points maximum possible life points, also the initial life points at
   *               instantiation
   * @param rb     the way in which this Alien will recover life points
   * @throws RecoveryRateException this should never be thrown
   */
  public Alien(String name, int points, RecoveryBehavior rb) throws RecoveryRateException {
    this(name, points);
    recoveryBehavior = rb;
    recoverRate = 0;
  }

  /**
   * Aliens have an attack strength of 10, by default
   * 
   * @param name
   * @param points
   * @param rb
   * @param recoveryRate Aliens can recover periodically. This specifies how often
   *                     to recover. A recovery rate of 1 means the Alien will
   *                     recover every round. A recovery rate of 0 means this
   *                     Alien will never recover points.
   * @throws RecoveryRateException thrown if the recoverRate is less than 0
   */
  public Alien(String name, int points, RecoveryBehavior rb, int recoveryRate)
      throws RecoveryRateException {
    this(name, points);
    recoveryBehavior = rb;

    if (recoveryRate < 0) {
      throw new RecoveryRateException();
    } else {
      recoverRate = recoveryRate;
    }
  }

  public void setCurrentLifePoints(int life) {
    currentLifePoints = life;
  }

  public void setRecoveryRate(int recoveryRate) {
    recoverRate = recoveryRate;
  }

  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  public int getRecoveryRate() {
    return recoverRate;
  }

  protected void recover() {
    currentLifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
  }

  @Override
  public void updateTime(int time) {
    if (recoverRate != 0) {
      if (time % recoverRate == 0) {
        recover();
      }
    }
  }
}
