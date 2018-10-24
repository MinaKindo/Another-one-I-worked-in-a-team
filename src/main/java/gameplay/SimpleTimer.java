package gameplay;

import java.util.ArrayList;
import java.util.List;

public class SimpleTimer extends Thread implements Timer {

  private List<TimerObserver> obs = new ArrayList<>();
  private int round = 0;
  private int sleep;

  public SimpleTimer() {
  }
  
  public SimpleTimer(int s) {
    sleep = s;
  }

  @Override
  public void addTimeObserver(TimerObserver o) {
    obs.add(o);
  }

  @Override
  public void timeChanged() {
    round++;
    obs.forEach(o -> o.updateTime(round));
  }

  @Override
  public void removeTimeObserver(TimerObserver o) {
    obs.remove(o);
  }

  public int getRound() {
    return round;
  }

  public int getNumObservers() {
    return obs.size();
  }

  @Override
  public void run() {

    while (round < 100) {
      try {
        Thread.sleep(sleep);

      } catch (InterruptedException e) {
        System.out.println("Something bad happened");
      }
      
      timeChanged();
    }
  }
}
