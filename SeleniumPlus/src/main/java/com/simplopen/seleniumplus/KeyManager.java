package com.simplopen.seleniumplus;

import org.openqa.selenium.WebElement;

public class KeyManager {

    /**@method formatKeyFromForm
     * @description 
     * @return String
    */
    public static String formatKeyFromForm(WebElement e) {
        return  e.getAttribute("method") + "|"
                + e.getAttribute("action") + "|"
                + e.getAttribute("name") + "|"
                + e.getAttribute("id");
    }

}
