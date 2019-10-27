package kata.profiles;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/**@ClassName: ProfilePropertyTest
 * @Description:  
 */
public class ProfilePropertyTest {

	/**@method setUp
	 * @description 
	 * @return void
	*/
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Properties properties = initProperies();
		System.out.println("DB_URL system properties: " + properties.getProperty("DB_URL"));
		System.out.println("db-url properties: " + properties.getProperty("DB_PASSWORD"));
	}

	private Properties initProperies(){ 
		Properties properties = new Properties(); 
        try { 
            properties.load(getClass().getResourceAsStream("/param.properties")); 
        } catch (IOException ex) { 
        System.out.println(ex.getMessage());
        } 
        return properties;
    } 
}
