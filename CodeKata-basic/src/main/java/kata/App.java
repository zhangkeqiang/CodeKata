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
    }
    
    
    public void foo(int y) {
        int x = 3;
        
    } 
    
    String[] getAsArray(Collection c) {
        return (String[]) c.toArray();
      }
    
    
}
