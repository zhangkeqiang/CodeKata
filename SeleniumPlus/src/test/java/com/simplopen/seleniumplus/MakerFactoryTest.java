package com.simplopen.seleniumplus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.WebElement;
import static org.mockito.Mockito.*;

import com.simplopen.seleniumplus.maker.Maker;

/**@ClassName: MakerFactoryTest
 * @Description:  
 */
@RunWith(MockitoJUnitRunner.class)
public class MakerFactoryTest {

    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link com.simplopen.seleniumplus.MakerFactory#getMaker(java.lang.String)}.
     */
    @Test
    public final void testGetMakerOfInputText() {
        
        WebElement e = mock(WebElement.class);
        when(e.getTagName()).thenReturn("input");
        when(e.getAttribute("type")).thenReturn("text");
        String nameValue = "dfsfdsfdfdsfds";
        when(e.getAttribute("name")).thenReturn(nameValue);    
        Maker maker = MakerFactory.getMaker(e);
        assertEquals(nameValue, maker.makeSimpleKey());
        assertEquals("input|dfsfdsfdfdsfds|text|form2",maker.makeKey(2));
    }
    

    @Test
    public final void testGetMakerOfInputSubmit() {
        
        WebElement e = mock(WebElement.class);
        when(e.getTagName()).thenReturn("input");
        when(e.getAttribute("type")).thenReturn("submit");
        String nameValue = "smaplename";
        when(e.getAttribute("name")).thenReturn(nameValue);    
        Maker maker = MakerFactory.getMaker(e);
        assertEquals("input|submit|form1", maker.makeKey(1));
        assertEquals(nameValue, maker.makeSimpleKey());
        
    }
    


}
