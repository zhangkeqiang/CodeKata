package com.simplopen.seleniumplus;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @ClassName: PageComposer
 * @Description:
 */
public class Form {

    List<WebElement> formList;
    Map<String, WebElement> elementMap = new HashMap();
    private WebDriver driver;
    private WebElement formInWebElement;
    private int index;

    /**
     * @param driver2
     */
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param i 
     * @param webElement
     */
    public Form(WebElement webElement,int i) {
        this.formInWebElement = webElement;
        this.index = i;
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
        if (formNo == 1) {
            getElement(obj.getClass().getName(), "submit").click();
        } else {
            elementMap.get("input||submit|form2").click();
        }
    }

    
    /**
     * @method getElement
     * @description
     * @return void
     */
    private WebElement getElement(String name, String type) {
        return elementMap.get(generateKeyFromInput("", type));
    }

    public void fillFormElements(){
        
    }
    public void input(Object obj) {
        input(obj, 0, null, null);
    }
    
    private void input(Object obj, int formNo, String formName, String formMethod) {
       

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

    protected String generateKeyFromInput(String name, String type) {
        return "input|" + name + "|" + type;
    }

    protected String generateKeyFromInput(String name) {
        return generateKeyFromInput(name, "text");
    }

    protected String generateKeyFromInput(String name, int formNo) {
        String key;
        if (formNo == 1) {
            key = generateKeyFromInput(name);
        } else {
            key = "input|" + name + "|" + "text" + "|form" + formNo;
        }
        System.out.println("get==" + key);
        return key;

    }

 
    protected void putElementIntoMap(WebElement eInput, WebElement form, int formNo) {
        String formKey = "form" + formNo;
        String key1 = generateKeyFromElement(eInput, formKey);
        System.out.println(key1 + "|-------");
        elementMap.put(key1, eInput);
        String key2 = generateKeyFromElement(eInput);
        System.out.println(key2 + "|-------");
        if (!elementMap.containsKey(key2))
            elementMap.put(key2, eInput);
    }

    private String generateKeyFromElement(WebElement eInput, String formKey) {
        String key = eInput.getTagName() + "|" + eInput.getAttribute("name").toLowerCase() + "|"
                + eInput.getAttribute("type");
        if (formKey != null)
            key = key + "|" + formKey;
        return key;
    }

    protected String generateKeyFromElement(WebElement eInput) {
        return generateKeyFromElement(eInput, null);
    }

    /**
     * @method findElement
     * @description
     * @return WebElement
     */
    public WebElement findElement(String key) {
        String keyInMap = "input|" + key + "|text";
        return elementMap.get(keyInMap);
    }

    /**@method findForm
     * @description 
     * @return void
    */
    public WebElement findForm(String searchKey) {
        Set<String> keySet = elementMap.keySet();
        for(String key:keySet){
            if(key.indexOf(searchKey)>0){
                return elementMap.get(key);
            }
        } 
        return null;        
    }

    /**@method fill
     * @description 
     * @return void
    */
    public  void fill(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i].getName();
            if (methodName.startsWith("get")) {
                String fieldName = methodName.substring(3).toLowerCase();
                formInWebElement.findElement(By.name(fieldName)).sendKeys(getByMethodName(obj, methodName));
            }
        }    
    }

    /**@method submitForm
     * @description 
     * @return void
    */
    public void submit() {
        formInWebElement.findElement(By.xpath("//form["+this.index+"]//input[@type='submit']")).click();
    }

    /**@method getAction
     * @description 
     * @return Object
    */
    public String getAction() {
        return formInWebElement.getAttribute("action");
    }

}
