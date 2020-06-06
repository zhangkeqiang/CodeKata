package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class ABCommandTest {
	

	@Test
	public final void testABCommandInt() {
		ABCommand command = new ABCommand(10);
		assertTrue(command.execute());
	}

	@Test
	public final void testABCommand() {
		ABCommand command = new ABCommand();
		assertTrue(command.execute());
	}
}
