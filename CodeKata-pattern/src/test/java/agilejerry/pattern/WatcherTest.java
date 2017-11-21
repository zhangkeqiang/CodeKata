package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WatcherTest {

	Watched alice;
	@Before
	public void setUp() throws Exception {
		alice = new Watched();
		alice.addWatcher(new WatcherFromShangHai());
		alice.addWatcher(new WatcherFromBeiJing());
		alice.addWatcher(new WatcherFromSuZhou());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddWatcher() {		
		alice.notifyWatchers("I love you");
	}

	@Test
	public void testRemoveWatcher() {
		Watcher Bob = new WatcherFromShangHai();
		Watcher Richard = new WatcherFromSuZhou();
		alice.makeFriend(Bob);
		alice.makeFriend(Richard);
		System.out.println("----------------------");
		alice.notifyWatchers("I will go to BeiJing");
		Bob.setName("Bob");
		Richard.setName("Richard");
		alice.unfriend(Richard);
		System.out.println("----------------------");
		alice.notifyWatchers("I will go to ShangHai");
		
	}


}
