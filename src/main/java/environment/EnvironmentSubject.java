package environment;

import java.awt.Point;

public interface EnvironmentSubject {

  public void addObserver(EnvironmentObserver o);
  public void notifyObservers(Point[] locs);
}
