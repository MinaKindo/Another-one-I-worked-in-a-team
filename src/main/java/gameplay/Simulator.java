package gameplay;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import environment.CellInfo;
import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.Human;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;
import state.AiContext;
//import state.TestAIContext;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Scope;
import weapon.Stabilizer;
import weapon.Weapon;

public class Simulator implements TimerObserver {

  private final Environment environment;

  private List<AiContext> ais = new ArrayList<>();

  /**
   * Creates a simulator
   */
  public Simulator(Environment e, Timer timer, int numHumans, int numAliens)
      throws RecoveryRateException {
    this.environment = e;
    timer.addTimeObserver(this);

    // generate humans
    for (int i = 0; i < numHumans; i++) {

      int lifePts = (int) (Math.random() * 51) + 50; // [50, 100]
      int armorPts = (int) (Math.random() * 6); // [0, 5]
      Human human = new Human("AIHuman_" + i, lifePts, armorPts);

      Point loc = getLifeFormSpawnableCell();
      e.addLifeForm(human, loc.y, loc.x);
      ais.add(new AiContext(e, human));
      e.updateCell(loc.y, loc.x);
    }

    // generate aliens
    for (int i = 0; i < numAliens; i++) {

      int lifePts = (int) (Math.random() * 51) + 50; // [50, 100]

      RecoveryBehavior rb = null;
      int rbChance = (int) (Math.random() * 3); // [0, 2]
      if (rbChance == 0) {
        rb = new RecoveryNone();
      } else if (rbChance == 1) {
        int recoveryAmt = (int) (Math.random() * 30) + 1; // [1, 10]
        rb = new RecoveryLinear(recoveryAmt);
      } else {
        double recoveryFrac = Math.random() * 9 + 1; // [1, 10)
        rb = new RecoveryFractional(recoveryFrac);
      }

      int recoveryRate = (int) (Math.random() * 3) + 1; // [1, 3]

      Alien alien = new Alien("AIAlien_" + i, lifePts, rb, recoveryRate);
      timer.addTimeObserver(alien);

      Point loc = getLifeFormSpawnableCell();
      e.addLifeForm(alien, loc.y, loc.x);
      ais.add(new AiContext(e, alien));
      e.updateCell(loc.y, loc.x);
    }

    // generate weapons
    for (int i = 0; i < numHumans + numAliens; i++) {

      Weapon weapon;
      int weaponChance = (int) (Math.random() * 3); // [0, 2]
      if (weaponChance == 0) {
        weapon = new ChainGun();
      } else if (weaponChance == 1) {
        weapon = new Pistol();
      } else {
        weapon = new PlasmaCannon();
      }

      int numAttachments = (int) (Math.random() * 3); // [0, 2]
      for (int j = 0; j < numAttachments; j++) {
        int attachmentChance = (int) (Math.random() * 3); // [0, 2]
        try {
          if (attachmentChance == 0) {
            weapon = new PowerBooster(weapon);
          } else if (attachmentChance == 1) {
            weapon = new Scope(weapon);
          } else {
            weapon = new Stabilizer(weapon);
          }
        } catch (AttachmentException ex) {
          // this should never happen
          ex.printStackTrace();
        }
      }

      Point loc = getWeaponSpawnableCell();
      timer.addTimeObserver(weapon);
      e.addWeapon(weapon, loc.y, loc.x);
      e.updateCell(loc.y, loc.x);
    }
  }

  private Point getLifeFormSpawnableCell() {
    Point loc = null;

    do {
      CellInfo cellInfo = environment.getRandomCell();

      if (!cellInfo.hasLife()) {
        loc = new Point(cellInfo.getCol(), cellInfo.getRow());
      }
    } while (loc == null);

    return loc;
  }

  private Point getWeaponSpawnableCell() {
    Point loc = null;

    do {
      CellInfo cellInfo = environment.getRandomCell();

      if (!cellInfo.hasWeapon1() || !cellInfo.hasWeapon2()) {
        loc = new Point(cellInfo.getCol(), cellInfo.getRow());
      }
    } while (loc == null);

    return loc;
  }

  @Override
  public void updateTime(int time) {
    ais.forEach(ai -> ai.executeAction());
  }
}
