package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import environment.CellInfo;
import environment.Environment;
import exceptions.RecoveryRateException;
import state.ActionState;

public class TestSimulator {

  Environment environment = Environment.getEnvironment(4, 4);

  @Before
  public void testBefore() {
    environment.clearBoard();
  }

  // lab 7 tests

  /**
   * @author ad5146
   */
  @Test
  public void testPopulateWorld() throws RecoveryRateException {
    SimpleTimer timer = new SimpleTimer(1000);
    Simulator sim = new Simulator(environment, timer, 2, 1);

    int numLifeForms = 0;
    int numWeapons = 0;

    for (int row = 0; row < environment.getNumRows(); row++) {
      for (int col = 0; col < environment.getNumCols(); col++) {
        CellInfo cellInfo = environment.getCellInfo(row, col);

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

  @Test
  public void testTimeUpdatesAiContext() throws RecoveryRateException {
    SimpleTimer timer = new SimpleTimer(1000);
    Simulator sim = new Simulator(environment, timer, 2, 2);

    List<ActionState> originalStates = new ArrayList<>();
    for (int i = 0; i < sim.getAis().size(); i++) {
      originalStates.add(sim.getAis().get(i).getCurrentState());
    }

    timer.timeChanged();

    boolean changed = true;
    for (int i = 0; i < sim.getAis().size(); i++) {
      if (originalStates.get(i) == sim.getAis().get(i).getCurrentState()) {
        changed = true;
        break;
      }
    }
    assertTrue(changed);
  }
}
