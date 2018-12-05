package lifeform;

public class Human extends LifeForm {

  private int armorPoints;

  /**
   * Creates a new Human
   * 
   * @param name        the name of the human
   * @param lifePoints  the starting life points of the human
   * @param armorPoints the starting armor points of the human
   */
  public Human(String name, int lifePoints, int armorPoints) {
    super(name, lifePoints, 5);
    this.armorPoints = armorPoints;
    checkArmorPoints();
    maxSpeed = 3;
  }

  public void setArmorPoints(int armorPoints) {
    this.armorPoints = armorPoints;
    checkArmorPoints();
  }

  public int getArmorPoints() {
    return armorPoints;
  }

  private void checkArmorPoints() {
    if (armorPoints < 0) {
      armorPoints = 0;
    }
  }

  @Override
  public void takeHit(int damage) {
    int actualDamage = Math.max(0, damage - armorPoints);
    currentLifePoints = Math.max(0, currentLifePoints - actualDamage);
  }
}
