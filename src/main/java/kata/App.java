package kata;

import java.util.Collection;

/**
 * Hello world!
 *
 */
public final class App {

        /**/
    public static void main( String[] args ){
    	
    }
    
    private App(){
    	
    }
    
    public void foo() {
        int x = 3;
        //x = x;
    }
    
    
    public void foo(int y) {
        int x = 3;
        //y = x;
        
    } 
    
    String[] getAsArray(Collection c) {
        return (String[]) c.toArray();
        //return null;
      }
    
    
}
