package kata;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LengthTest {

	protected Logger log = LogManager.getLogger(this);
	
	@Test
	public void testLength_inch() {
		Length l1 = new Length(12,"INCH");
		Length l2 = new Length(1,"FEET");
		assertEquals(l1.getInch(), l2.getInch(), 0.0000001);
	}
	
	@Test
	public void testLength_Feet() {
		Length l1 = new Length(48,"INCH");
		Length l2 = new Length(4,"FEET");
		log.info(l1.getFeet());
		log.info(l2.getFeet());
		assertEquals(l1.getFeet(), l2.getFeet(),0.000001);
	}
	
	@Test
	public void testLength_Feet_Float() {
		Length l1 = new Length(54,"INCH");
		Length l2 = new Length(4.5,"FEET");
		log.info(l1.getFeet());
		log.info(l2.getFeet());
		assertEquals(l1.getFeet(), l2.getFeet(),0.000001);
	}

	@Test
	public void testLength_Yard() {
		Length l1 = new Length(720,"INCH");
		Length l2 = new Length(60,"FEET");
		log.debug(l1.getYard());
		log.debug(l2.getYard());
		assertEquals(l1.getYard(), l2.getYard(),0.000001);
	}
}
