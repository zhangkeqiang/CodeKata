package com.simplopen.seleniumplus.maker;

import org.openqa.selenium.WebElement;

/**@ClassName: InputSubmitMaker
 * @Description:  
 */
public class InputSubmitMaker extends WebElementMaker implements Maker {

    /** (这里用一句话描述这个方法的作用)
     * @see com.simplopen.seleniumplus.maker.Maker#makeKey(org.openqa.selenium.WebElement)
     */
    @Override
    public String makeKey(int formNo) {
        return e.getTagName()+"|"+e.getAttribute("type")+"|form"+formNo;
    }



}
