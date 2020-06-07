package kata.spring.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: UserControllerTest
 * @Description:
 */
public class UserControllerTest {

	private UserController userController;

	/**
	 * @method setUp
	 * @description
	 * @return void
	 */
	// @Before
	public void setUp() throws Exception {
		userController = new UserController();
	}

	@Test
	public void helloTest() {
		assertNull(userController);
	}

	/**
	 * Test method for
	 * {@link kata.spring.controller.UserController#view(java.lang.Long, javax.servlet.http.HttpServletRequest)}.
	 * 
	 * @Test
	 * @Ignore
	 */
	public final void testView() {
		assertNotNull(userController);
		MockHttpServletRequest req = new MockHttpServletRequest();
		assertNotNull(req);
		String localName = "localName";
		req.setLocalName(localName);
		assertEquals(localName, req.getLocalName());

		// ModelAndView mv = userController.view(14544L, req);
		//
		// ModelAndViewAssert.assertViewName(mv, "user/view");
		// ModelAndViewAssert.assertModelAttributeAvailable(mv, "user");
	}

}
