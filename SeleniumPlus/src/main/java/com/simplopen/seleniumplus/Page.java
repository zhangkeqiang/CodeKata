package com.simplopen.seleniumplus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.simplopen.seleniumplus.maker.Maker;
import com.simplopen.seleniumplus.maker.WebElementMaker;

/**
 * @ClassName: PageComposer
 * @Description:
 */
public class Page {

    List<WebElement> formList;
    Map<String, WebElement> elementMap = new HashMap();
    private WebDriver driver;

    /**
     * @param driver2
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 
     */
    public Page() {
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
     * @method submit
     * @description
     * @return void
     */
    public void submit(Object obj) {
        submit(obj, 1);
    }

    /**
     * @method submit
     * @description
     * @return void
     */
    public void submit(Object obj, int formNo) {
        input(obj, formNo);
        String key = "input|submit|form" + formNo;
        elementMap.get(key).click();
    }

    public void input(Object obj) {
        input(obj, 0, null, null);
    }

    private void input(Object obj, int formNo, String formName, String formMethod) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.startsWith("get")) {
                String fieldName = methodName.substring(3).toLowerCase();
                WebElement e = findElement(fieldName, formNo);
                if (e != null)
                    e.sendKeys(getByMethodName(obj, methodName));
            }
        }

    }

    /**
     * @method input
     * @description
     * @return void
     */
    private void input(Object obj, int formNo) {
        input(obj, formNo, null, null);
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

    // protected String generateKeyFromInput(String name, String type) {
    // return "input|" + name + "|" + type;
    // }
    //
    // protected String generateKeyFromInput(String name) {
    // return generateKeyFromInput(name, "text");
    // }

    protected WebElement findElement(String name, int formNo) {
        String key = "input|" + name + "|" + "text" + "|form" + formNo;
        WebElement e = elementMap.get(key);
        if (e != null)
            return elementMap.get(key);
        return null;
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
            String formKey = KeyManager.formatKeyFromForm(e);
            elementMap.put(formKey, e);
            // xpath("//form["+this.index+"]//input[@type='submit']")
            List<WebElement> elementList = e.findElements(By.xpath("//form[" + numString + "]//input"));
            for (WebElement eInput : elementList) {
                putElementIntoMap(eInput, (i + 1));
            }
        }

        List<WebElement> elementList = driver.findElements(By.tagName("input"));
        for (WebElement e : elementList) {
            putElementIntoMap(e);
        }

        elementList = driver.findElements(By.tagName("button"));
        for (WebElement e : elementList) {
            putElementIntoMap(e);
        }
    }

    private void putElementIntoMap(WebElement e) {
        putElementIntoMap(e, 0);
        // String key = e.getAttribute("id");
        // if(key.isEmpty()){
        // key = e.getAttribute("name");
        // }
        // if(key.isEmpty()){
        // key = e.getTagName()+"|"+e.getAttribute("type");
        // }
        // if (!elementMap.containsKey(key)){
        // elementMap.put(key, e);
        // }
    }

    protected void putElementIntoMap(WebElement e, int formNo) {
        Maker maker = MakerFactory.getMaker(e);
        String key2 = maker.makeSimpleKey();
        if (!elementMap.containsKey(key2))
            elementMap.put(key2, e);
        String key3 = maker.makeKey(formNo);
        if (!elementMap.containsKey(key3))
            elementMap.put(key3, e);
    }

    // private String generateKeyFromElement(WebElement eInput, String formKey)
    // {
    // String key = eInput.getTagName() + "|" +
    // eInput.getAttribute("name").toLowerCase() + "|"
    // + eInput.getAttribute("type");
    // if (formKey != null)
    // key = key + "|" + formKey;
    // return key;
    // }

    // protected String generateKeyFromElement(WebElement eInput) {
    // return generateKeyFromElement(eInput, null);
    // }

    /**
     * @method findElement
     * @description
     * @return WebElement
     * @param key
     *            key to search TODO: need change
     */
    public WebElement findElement(String key) {
        String keyInMap = "input|" + key + "|text";
        if (elementMap.get(keyInMap) != null)
            return elementMap.get(keyInMap);
        return elementMap.get(key);
    }

    /**
     * @method findForm
     * @description
     * @return void
     * @param searchKeys
     *            put all search keys here,one by one by ","
     */
    public Form findForm(String... searchKeys) {
        Set<String> keySet = elementMap.keySet();
        for (String key : keySet) {
            boolean isFound = true;
            for (String searchKey : searchKeys) {
                if (key.indexOf(searchKey) < 0) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                WebElement form = elementMap.get(key);
                return new Form(form, formList.indexOf(form) + 1);
            }
        }
        return null;
    }

    /**
     * @method getElementMap
     * @description
     * @return void
     */
    public Map<String, WebElement> getElementMap() {
        return this.elementMap;
    }

}
