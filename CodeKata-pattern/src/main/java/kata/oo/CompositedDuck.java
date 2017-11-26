package kata.oo;

public class CompositedDuck {
    protected Bird duck = new Bird();
    public CompositedDuck() {
        // TODO Auto-generated constructor stub
    }

    public int countWings() {        
        return duck.countWings();
    }

}
