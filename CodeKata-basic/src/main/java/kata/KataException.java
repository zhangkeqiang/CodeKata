/**
 * 
 */
package kata;

/**
 * @author Minjun
 *
 */
public class KataException extends Exception {

	    private static final long serialVersionUID = 1L; 
        public KataException() {

        }

        /**
         * @param arg0
         */
        public KataException(String arg0) {
                super(arg0);

        }

        /**
         * @param arg0
         */
        public KataException(Throwable arg0) {
                super(arg0);

        }

        /**
         * @param arg0
         * @param arg1
         */
        public KataException(String arg0, Throwable arg1) {
                super(arg0, arg1);
        }

        /**
         * @param arg0
         * @param arg1
         * @param arg2
         * @param arg3
         */
        public KataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
                super(arg0, arg1, arg2, arg3);
        }

}
