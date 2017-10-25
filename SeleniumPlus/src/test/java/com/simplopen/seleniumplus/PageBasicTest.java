package com.simplopen.seleniumplus;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**@ClassName: PageComposerTest
 * @Description:  
 */
public class PageBasicTest {
    WebDriver driver = null;
    Page composer = new Page();
    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
        // System.setProperty("webdriver.firefox.bin", "C:\\Program
        // Files\\Mozilla Firefox\\firefox.exe");
        // 创建一个 FireFox 的浏览器实例
        String geckodriverpath = "C:\\IDE\\geckodriver-v0.16.1-win64\\geckodriver.exe";
        // System.setProperty("webdriver.firefox.marionette", geckodriverpath);
        System.setProperty("webdriver.gecko.driver", geckodriverpath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        //设置等待时间  
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  
        composer.setDriver(driver);
        assertNotNull(composer);       
    }
    @After
    public void tearDown() throws Exception {
        // 关闭浏览器
        //driver.close();
        driver.quit();
    }

    
    @Test 
    public final void testSubmit1(){
        String url = "http://localhost:8080/examples/servlets/servlet/SessionExample";
        PageBean bean = new PageBean();
        bean.setDataname("dataname1");
        bean.setDatavalue("datavalue1");
        composer.visit(url);
        System.out.println("all keys======");
        for(String key: composer.getElementMap().keySet()){
            System.out.println(key);
        }
        System.out.println("end of all keys======");
        assertNotNull(composer.findElement("input|submit|form1"));
        composer.submit(bean);
        
        checkPageWithBean(bean);
    }
    
    @Test 
    public final void testSubmit2(){
        String url = "http://localhost:8080/examples/servlets/servlet/SessionExample";
        PageBean bean = new PageBean();
        bean.setDataname("dataname2");
        bean.setDatavalue("datavalue2");
        composer.visit(url);
        composer.submit(bean,2);
        
        checkPageWithBean(bean);

    }
    protected void checkPageWithBean(PageBean bean) {
        WebElement body = driver.findElement(By.xpath("/html/body"));
        // System.out.println("body: " + body.getText());
        assertTrue("user should be found",
                body.getText().indexOf(bean.getDataname()) > 0 && body.getText().indexOf(bean.getDatavalue()) > 0);
    }
    
    @Test 
    public final void testSubmit3(){
        String url = "http://localhost:8080/examples/servlets/servlet/SessionExample";
        PageBean bean = new PageBean();
        bean.setDataname("dataname222");
        bean.setDatavalue("datavalue222");
        composer.visit(url);
        Form form = composer.findForm("SessionExample","post");
        assertNotNull(form);
        assertEquals(true,form.getAction().indexOf("SessionExample")>0);
        form.fill(bean);
        form.submit();
        //composer.submit(bean,2);
        
        checkPageWithBean(bean);

    }
    
    @Test 
    public final void testSubmit4(){
        String url = "http://localhost:8080/examples/servlets/servlet/SessionExample";
        PageBean bean = new PageBean();
        bean.setDataname("dataname444");
        bean.setDatavalue("datavalue444");
        composer.visit(url);
        Form form = composer.findForm("SessionExample","get");
        assertNotNull(form);
        assertEquals(true,form.getAction().indexOf("SessionExample")>0);
        form.fill(bean);
        form.submit();
        //composer.submit(bean,2);
        
        checkPageWithBean(bean);

    }

}
