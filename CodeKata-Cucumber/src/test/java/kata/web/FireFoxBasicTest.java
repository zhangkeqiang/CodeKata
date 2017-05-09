package kata.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simplopen.seleniumplus.Page;

/**
 * @ClassName: BaiduVisitTest
 * @Description:
 */
public class FireFoxBasicTest {

    public WebDriver driver;
    PageDataManager manager = new PageDataManager();
    TomcatUser user = new TomcatUser();

    /**
     * @method setUp
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
       
        user.setFirstName("mike");
        user.setLastName("zhang");
    }

    /**
     * @method tearDown
     * @description
     * @return void
     */
    @After
    public void tearDown() throws Exception {
        // 关闭浏览器
        // driver.close();
        driver.quit();
    }

    @Test
    public final void test() {

        // 让浏览器访问 Baidu
        driver.get("http://localhost:8080");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.baidu.com");

        // 获取 网页的 title
        System.out.println("1 Page title is: " + driver.getTitle());
        WebElement lable1 = driver.findElement(By.xpath("//*[text()='Managing Tomcat']"));
        assertNotNull(lable1);
        System.out.println(lable1.getText() + "|" + lable1.getTagName());
        WebElement lableNotExisted = null;
        try {
            lableNotExisted = driver.findElement(By.xpath("//*[text()='NotExisted']"));
        } catch (NoSuchElementException e) {
            assertNull(lableNotExisted);
        }

        driver.findElement(By.linkText("Examples")).click();
        /*
         * // 通过 id 找到 input 的 DOM WebElement element =
         * driver.findElement(By.id("SI_Search_Type_Hack"));
         * 
         * // 输入关键字 element.sendKeys("zTree");
         * 
         * // 提交 input 所在的 form element.submit();
         */

        /*
         * // 通过判断 title 内容等待搜索页面加载完毕，间隔10秒 (new WebDriverWait(driver,
         * 10)).until(new ExpectedCondition<Boolean>() { public Boolean
         * apply(WebDriver d) { return
         * d.getTitle().toLowerCase().endsWith("ztree"); } });
         */

        // 显示搜索结果页面的 title
        System.out.println("2 Page title is: " + driver.getTitle());

    }

    @Test
    public void elementToObjectTest() {
        String url = "http://localhost:8080/examples/servlets/servlet/RequestParamExample";
        manager.setDriver(driver);
        
        manager.visit(url);
        // manager.input(user);
        manager.submit(user);
        System.out.println("2nd Page is: " + driver.getPageSource());
        WebElement body = driver.findElement(By.xpath("/html/body"));
        // System.out.println("body: " + body.getText());
        assertTrue("user could be found",
                body.getText().indexOf(user.getFirstName()) > 0 && body.getText().indexOf(user.getLastName()) > 0);

    }
    
    @Test
    public void pageComposerBasicTest() {
        String url = "http://localhost:8080/examples/servlets/servlet/RequestParamExample";
        Page composer = new Page(driver);
        composer.visit(url);
        String key = "lastname";
        WebElement inputlastname = composer.findElement(key);
        assertNotNull(inputlastname);
        composer.submit(user);
        WebElement body = driver.findElement(By.xpath("/html/body"));
        // System.out.println("body: " + body.getText());
        assertTrue("user should be found",
                body.getText().indexOf(user.getFirstName()) > 0 && body.getText().indexOf(user.getLastName()) > 0);

    }
}
