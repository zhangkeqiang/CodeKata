package kata.handler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kata.factory.Car;

public class HandlerCenter {
    private Map<String, Handler> handlerMap = new HashMap<String, Handler>();

    private HandlerCenter() {
        //call init at the beginning 
        init();  
    }

    protected void init() {
        handlerMap.put("BSingletonHandler", BSingletonHandler.getInstance());
        handlerMap.put("AHandler", new AHandler());
        handlerMap.put("ASingletonHandler", ASingletonHandler.getInstance());
    }

    private static HandlerCenter center = new HandlerCenter();

    /**
     * @method addHandler
     * @description
     * @return void
     */
    public static void addHandler(String key, Handler handler) {
        center.handlerMap.put(key, handler);
    }

    /**
     * @method getHandler
     * @description
     * @return Handler
     */
    public static Handler getHandler(String handlerName) {
        return center.handlerMap.get(handlerName);
    }

    public static Handler getSingletonHandler(String handlerName) {
        Handler handler = center.handlerMap.get(handlerName);
        if (handler != null)
            return handler;
        System.out.println("need invoke");
        try {
            @SuppressWarnings("unchecked")
            Class<Handler> aclass = (Class<Handler>) Class.forName("kata.handler." + handlerName);
            Method getInstanceMethod = aclass.getMethod("getInstance");
            handler = (Handler) getInstanceMethod.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handler;
    }

    public static Handler getReadyHandler(String handlerName) {
        if (center.handlerMap.get(handlerName) == null)
            load();
        return center.handlerMap.get(handlerName);
    }

    /**
     * @method load
     * @description
     * @return void
     */
    private static void load() {
        // center.init();
        System.out.println("load");
        center.init();
    }

    /*
     * protected static void init() { if (center.handlerMap.size() == 0) {
     * center.handlerMap.put("BSingletonHandler",
     * BSingletonHandler.getInstance()); center.handlerMap.put("AHandler", new
     * AHandler()); center.handlerMap.put("ASingletonHandler",
     * ASingletonHandler.getInstance());
     * 
     * } }
     */

}
