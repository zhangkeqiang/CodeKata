package kata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: KQAppender
 * @Description: use the log
 */
public class KQAppender{
    static Logger logger = LogManager.getLogger();
    /**
     * @method appendMessage
     * @param message what is need be appended
     * @return void
     */
    public void appendMessage(String message){
        logger.info(message);
    }
}  

