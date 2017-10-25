package kata.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @ClassName : PageDataManager
 * @Description :
 */
public class PageDataManager {
    /**
     * driver:TODO
     */

    public WebDriver driver;
    List<WebElement> formList;
    Map<String, WebElement> elementMap = new HashMap();

    /**
     * 
     */
    public PageDataManager() {
    }

    /**
     * @method setDriver
     * @description
     * @return void
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @method visit
     * @description
     * @return void
     */
    public void visit(String url) {
        driver.get(url);
        formList = driver.findElements(By.tagName("form"));
        for (int i = 0; i < formList.size(); i++) {
            WebElement e = formList.get(i);
            String numString = String.valueOf(i + 1);
            String formKey = e.getAttribute("action");
            System.out.println(e.getTagName() + numString + "|" + e.getText() + "|" + e.getAttribute("method") + "|"
                    + e.getAttribute("action") + "|");
            System.out.println(e.getCssValue("css"));
            List<WebElement> elementList = e.findElements(By.xpath("//input"));
            for (WebElement eInput : elementList) {
                putElementIntoMap(formKey, eInput);
            }
        }
    }

    protected void putElementIntoMap(String formKey, WebElement eInput) {
        String key1 = generateKeyFromElement(eInput, formKey);
        System.out.println(key1 + "|-------");
        String key2 = generateKeyFromElement(eInput);
        System.out.println(key2 + "|-------");
        elementMap.put(key1, eInput);
        elementMap.put(key2, eInput);
    }

    /**
     * @method generateKeyFromElement
     * @description
     * @return String
     */
    private String generateKeyFromElement(WebElement eInput, String formKey) {
        String key = eInput.getTagName() + "|" + eInput.getAttribute("name").toLowerCase() + "|" + eInput.getAttribute("type");
        if (formKey != null)
            key = key + "|" + formKey;
        return key;
    }

    protected String generateKeyFromElement(WebElement eInput) {
        return generateKeyFromElement(eInput, null);
    }

    protected String generateKeyFromInput(String name, String type) {
        return "input|" + name + "|" + type;
    }

    protected String generateKeyFromInput(String name) {
        return generateKeyFromInput(name, "text");
    }

    /**
     * @method input
     * @description
     * @return void
     */
    public void input(TomcatUser user) {
        elementMap.get(generateKeyFromInput("firstname")).sendKeys(user.getFirstName());
        elementMap.get(generateKeyFromInput("lastname")).sendKeys(user.getLastName());
    }

    public void input(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.startsWith("get")) {
                String fieldName = methodName.substring(3).toLowerCase();
                System.out.println(fieldName);
                System.out.println(getByMethodName(obj, methodName));
                elementMap.get(generateKeyFromInput(fieldName)).sendKeys(getByMethodName(obj, methodName));
            }
        }
    }

    public String getByMethodName(Object obj, String getMethodName) {
        try {
            Method method = obj.getClass().getMethod(getMethodName);
            System.out.println(method.invoke(obj));
            return method.invoke(obj).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @method submit
     * @description
     * @return void
     */
    public void submit(Object obj) {
        input(obj);
        getElement(obj.getClass().getName(), "submit").click();
    }

    /**
     * @method getElement
     * @description
     * @return void
     */
    private WebElement getElement(String name, String type) {
        return elementMap.get(generateKeyFromInput("", type));
    }

}