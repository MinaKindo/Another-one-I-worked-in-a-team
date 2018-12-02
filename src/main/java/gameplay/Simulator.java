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
import state.AIContext;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.PowerBooster;
import weapon.Scope;
import weapon.Stabilizer;
import weapon.Weapon;

public class Simulator implements TimerObserver {

  private final Environment e;

  private List<AIContext> AIs = new ArrayList<>();

  public Simulator(Environment e, Timer timer, int numHumans, int numAliens)
      throws RecoveryRateException {
    this.e = e;
    timer.addTimeObserver(this);

    // generate humans
    for (int i = 0; i < numHumans; i++) {

      int lifePts = (int) (Math.random() * 6) + 5; // [5, 10]
      int armorPts = (int) (Math.random() * 10); // [0, 9]
      Human human = new Human("AIHuman_" + i, lifePts, armorPts);

      Point loc = getLifeFormSpawnableCell();
      e.addLifeForm(human, loc.y, loc.x);
      AIs.add(new AIContext(e, human));
      e.updateCell(loc.y, loc.x);
    }

    // generate aliens
    for (int i = 0; i < numHumans; i++) {

      int lifePts = (int) (Math.random() * 6) + 5; // [5, 10]

      RecoveryBehavior rb = null;
      int rbChance = (int) (Math.random() * 3); // [0, 2]
      if (rbChance < 1) {
        rb = new RecoveryNone();
      } else if (rbChance < 2) {
        int recoveryAmt = (int) (Math.random() * 3) + 1; // [1, 3]
        rb = new RecoveryLinear(recoveryAmt);
      } else {
        double recoveryFrac = Math.random() * 2 + 1; // [1, 3)
        rb = new RecoveryFractional(recoveryFrac);
      }

      int recoveryRate = (int) (Math.random() * 3) + 1; // [1, 3]

      Alien alien = new Alien("AIAlien_" + i, lifePts, rb, recoveryRate);

      Point loc = getLifeFormSpawnableCell();
      e.addLifeForm(alien, loc.y, loc.x);
      AIs.add(new AIContext(e, alien));
      e.updateCell(loc.y, loc.x);
    }

    // generate weapons
    for (int i = 0; i < numHumans + numAliens; i++) {

      Weapon weapon;
      int weaponChance = (int) (Math.random() * 3); // [0, 2]
      if (weaponChance < 1) {
        weapon = new ChainGun();
      } else if (weaponChance < 2) {
        weapon = new Pistol();
      } else {
        weapon = new PlasmaCannon();
      }

      int numAttachments = (int) (Math.random() * 3); // [0, 2]
      for (int j = 0; j < numAttachments; j++) {
        int attachmentChance = (int) (Math.random() * 3); // [0, 2]
        try {
          if (attachmentChance < 1) {
            weapon = new PowerBooster(weapon);
          } else if (attachmentChance < 2) {
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
      e.addWeapon(weapon, loc.y, loc.x);
      e.updateCell(loc.y, loc.x);
    }
  }

  private Point getLifeFormSpawnableCell() {
    Point loc = null;

    do {
      CellInfo cellInfo = e.getRandomCell();

      if (!cellInfo.hasLife()) {
        loc = new Point(cellInfo.getCol(), cellInfo.getRow());
      }
    } while (loc == null);

    return loc;
  }

  private Point getWeaponSpawnableCell() {
    Point loc = null;

    do {
      CellInfo cellInfo = e.getRandomCell();

      if (!cellInfo.hasWeapon1() || !cellInfo.hasWeapon2()) {
        loc = new Point(cellInfo.getCol(), cellInfo.getRow());
      }
    } while (loc == null);

    return loc;
  }

  @Override
  public void updateTime(int time) {
    AIs.forEach(ai -> ai.executeAction());
  }
}
