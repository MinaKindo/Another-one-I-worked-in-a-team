package gameplay;

import environment.Environment;

public class Simulator {

  private final Environment environment;
  private Timer timer;
  
  public Simulator(Environment e, Timer timer, int humans, int aliens) {
    environment = e;
    this.timer = timer;
    
  }
}
