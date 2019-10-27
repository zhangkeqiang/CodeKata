package agilejerry.pattern;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VisitorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVisit() {
		Visitor Bob = new Visitor();
		List<Visited> visitedlist = new ArrayList<Visited>();
		visitedlist.add(new VisitedLover());
		visitedlist.add(new VisitedFriend());
		for (Visited visited : visitedlist)
	    {
			assertTrue(visited.accept(Bob));
	    }
	}

}
