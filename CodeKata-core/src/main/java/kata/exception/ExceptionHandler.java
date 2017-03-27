package kata.exception;

/**@ClassName: ExceptionHandler
 * @Description:  
 */
public class ExceptionHandler {

    private ExceptionHandler(){
        //just to hide
    }
    /**@method createException
     * @param typeOfException which Exception is be created
     * @param message the message of exception
     * @return BaseException
    */
    public static BaseException createException(String typeOfException, String message) {
        BaseException e = null;
        if(typeOfException == null || "BaseException".equals(typeOfException))
            e = new BaseException(message);
        return e;
    }

}
