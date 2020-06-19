package kata;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {

	App app;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		app = new App();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		App.main(null);
	}
	
	@Test
	public void testSetGet() {
		int y = -1800000;
		app.setX(y);
		assertEquals(y,app.getX());
	}

	@Test
	public void testFoo() {
		app.foo();
		assertEquals(0,app.getX());
	}

	@Test
	public void testFooInt() {
		int y = 18;
		app.foo(y);
		assertEquals(y,app.getX());
	}

	@Test
	public void testGetAsArray() {
		Collection<String> c = new ArrayList<String>();
		app.getAsArray(c );
	}

}
