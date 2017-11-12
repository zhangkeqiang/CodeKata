package com.simplopen.seleniumplus;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.simplopen.seleniumplus.maker.InputSubmitMaker;
import com.simplopen.seleniumplus.maker.Maker;
import com.simplopen.seleniumplus.maker.WebElementMaker;

/**@ClassName: MakerFactory
 * @Description:  
 */
public class MakerFactory {
    Map<String, Maker> makerMap = new HashMap<String, Maker>();
    private static MakerFactory factory = new MakerFactory();
    private MakerFactory(){
        makerMap.put("input|text", new WebElementMaker());
        makerMap.put("input|submit", new InputSubmitMaker());
        makerMap.put("input|radio", new InputSubmitMaker());
    }
    public static Maker getMaker(WebElement e){
        String makerName = e.getTagName()+"|"+e.getAttribute("type");
        Maker maker = factory.makerMap.get(makerName);
        if(maker == null)
            maker = factory.makerMap.get("input|text");
        maker.setElement(e);
        return maker;
    }
}
