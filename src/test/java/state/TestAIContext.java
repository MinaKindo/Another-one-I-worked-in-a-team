package state;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import exceptions.RecoveryRateException;
import lifeform.Alien;
import lifeform.LifeForm;

public class TestAIContext {

	@Test
	public void testCanChangeState() throws RecoveryRateException {
		LifeForm et = new Alien("et", 50);
		Environment env = Environment.getEnvironment(4, 4);
		env.addLifeForm(et,2,2);
		
		AIContext ai = new AIContext(env, et);
		
		ai.getCurrentState();
		
	}

	@Test
	public void testCanGetState() throws RecoveryRateException {
		LifeForm et = new Alien("et", 50);
		Environment env = Environment.getEnvironment(4, 4);
		env.addLifeForm(et,2,2);
		
		AIContext ai = new AIContext(env, et);
		
		assertTrue(ai.getdeadState() instanceof DeadState);
	}
}
