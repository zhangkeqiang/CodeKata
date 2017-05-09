package com.simplopen.seleniumplus.maker;

import org.openqa.selenium.WebElement;

/**
 * @ClassName: WebElementMaker
 * @Description:
 */
public class WebElementMaker implements Maker {
    protected WebElement e;

    /**
     * (这里用一句话描述这个方法的作用)
     * 
     * @see com.simplopen.seleniumplus.maker.Maker#setElement(org.openqa.selenium.WebElement)
     */
    @Override
    public void setElement(WebElement e) {
        this.e = e;
    }

    /**
     * (这里用一句话描述这个方法的作用)
     * 
     * @see com.simplopen.seleniumplus.maker.Maker#makeSimpleKey()
     */
    @Override
    public String makeSimpleKey() {
        String key = e.getAttribute("id");
        if (key == null) {
            key = e.getAttribute("name");
        }
        if (key == null) {
            key = e.getTagName() + "|" + e.getAttribute("type");
        }
        return key;
    }

    /**
     * (这里用一句话描述这个方法的作用)
     * 
     * @see com.simplopen.seleniumplus.maker.Maker#makeKey(int)
     */
    @Override
    public String makeKey(int formNo) {
        StringBuffer bufKey = new StringBuffer();
        bufKey.append(e.getTagName() + "|");
        bufKey.append(e.getAttribute("name").toLowerCase() + "|");
        bufKey.append(e.getAttribute("type"));
        if (formNo > 0) {
            bufKey.append("|form" + formNo);
        }
        return bufKey.toString();
    }
}
