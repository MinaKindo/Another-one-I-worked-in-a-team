package gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSimpleTimer {

  @Test
  public void testInitialization() {
    SimpleTimer timer = new SimpleTimer();
    assertEquals(0, timer.getRound());
  }

  @Test
  public void testUpdateTime() {
    SimpleTimer timer = new SimpleTimer();
    assertEquals(0, timer.getRound());

    timer.timeChanged();
    assertEquals(1, timer.getRound());
  }

  @Test
  public void testAddObs() {
    SimpleTimer timer = new SimpleTimer();

    timer.addTimeObserver(new MockSimpleTimerObserver());
    assertEquals(1, timer.getNumObservers());

    timer.addTimeObserver(new MockSimpleTimerObserver());
    assertEquals(2, timer.getNumObservers());
  }

  @Test
  public void testReceiveUpdates() {
    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver ob = new MockSimpleTimerObserver();

    timer.addTimeObserver(ob);
    assertEquals(0, ob.myTime);

    timer.timeChanged();
    assertEquals(1, ob.myTime);
  }

  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250);
    for (int x = 0; x <= 5; x++) {
      assertEquals(x, st.getRound());
      Thread.sleep(1000);
    }
  }
}
