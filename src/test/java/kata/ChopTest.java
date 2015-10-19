package kata;

import junit.framework.TestCase;

public class ChopTest extends TestCase {
	SearchManager manager = new SearchManager();
	int intList[] = new int[]{1,3,5,7,9,23};
	public void testNew()
	{
		assertNotNull(manager);
	}
	
	public void testNo1()
	{
		assertEquals(0,  manager.chop(1, intList)) ;
	}
	
	public void testNo2()
	{
		
		assertEquals(1, manager.chop(3, intList));
	}
	
	public void testNo3()
	{
		assertEquals(-1, manager.chop(100, intList));
	}
	

	public void testNo4()
	{
		assertEquals(5, manager.chop(23, intList));
	}

		
	public void testNo5()
	{
		assertEquals(-1, manager.chop(100, intList));
	}

	//fix a bug in mainbranch
	public void testNo6()
	{
		assertEquals(-1, manager.chop(100, intList));
	}

}
