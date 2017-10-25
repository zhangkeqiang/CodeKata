package com.simplopen.seleniumplus.maker;

import org.openqa.selenium.WebElement;

/**@ClassName: WebElementMaker
 * @Description:  
 */
public interface Maker {    
    /**@method setElement
     * @description 
     * @return void
    */
    public void setElement(WebElement e);
    /**@method getSimpleKey
     * @description 
     * @return String
    */
    public String makeSimpleKey();
    /**@method getKey
     * @description 
     * @return String
    */
    public String makeKey(int formNo);
}
