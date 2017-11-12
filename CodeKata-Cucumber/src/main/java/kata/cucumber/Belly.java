package kata.cucumber;

/**@ClassName: Belly
 * @Description:  
 */
public class Belly {

    private int m;
    private int cukes;

    /**
     * @method eat
     * @description 
     * @param cukes number of cuke
     * @return void
     */
    public void eat(int cukes) {
        System.out.println("eat " + cukes + " cukes.");
        this.cukes = cukes;
    }

    /*
     * wait for m minutes
     */
    public void wait(int m) {
        System.out.println("wait " + m + " hours.");
        this.m = m;
    }
    
    public int getGrowl() {
        System.out.println("growl " + m * cukes + ".");
        return m* cukes;
    }
}
