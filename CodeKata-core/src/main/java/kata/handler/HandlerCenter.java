package kata.handler;

import java.util.HashMap;
import java.util.Map;

public class HandlerCenter {
    private static Map<String,Handler> handlerMap = new HashMap<String, Handler>();
    public static void addHandler(String key, Handler handler){
        handlerMap.put(key, handler);
    }
    public static Handler getHandler(String handlerName) {        
        return handlerMap.get(handlerName);
    }
    
}
