package command;

import org.junit.Test;

import environment.Environment;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * @author sb0476
 */
public class TestCommand {
  
  @Test
  public void testMove() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testReload() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testTurnNorth() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testTurnSouth() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testTurnEast() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testWest() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testDropWithSpace() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testDropWithoutSpace() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testAcquireWithOneWeaponAvailable() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }
  
  @Test
  public void testAcquireWithNoWeaponAvailable() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    
    
    enviro.addLifeForm(lf, 1, 1);
    enviro.addWeapon(ptl, 4, 4);
    
  }
  
  @Test
  public void testAcquireWithWeaponEquipped() {
    Environment enviro = Environment.getEnvironment(4, 4);
    LifeForm lf = new MockLifeForm ("Smith", 25);
    enviro.addLifeForm(lf, 1, 1);
    
  }

}
