package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import environment.CellInfo;
import environment.Environment;
import exceptions.RecoveryRateException;

public class TestSimulator {

  /**
   * @author ad5146
   */
  @Test
  public void testPopulateWorld() throws RecoveryRateException {
    Environment e = Environment.getEnvironment(4, 4);
    SimpleTimer timer = new SimpleTimer(1000);
    Simulator sim = new Simulator(e, timer, 2, 1);

    int numLifeForms = 0;
    int numWeapons = 0;

    for (int row = 0; row < e.getNumRows(); row++) {
      for (int col = 0; col < e.getNumCols(); col++) {
        CellInfo cellInfo = e.getCellInfo(row, col);

        if (cellInfo.hasLife()) {
          numLifeForms++;
        }
        if (cellInfo.hasWeapon1()) {
          numWeapons++;
        }
        if (cellInfo.hasWeapon2()) {
          numWeapons++;
        }
      }
    }

    assertEquals(2 + 1, numLifeForms);
    assertEquals(2 + 1, numWeapons);
  }
}
