package kata.oo;

public class Duck extends Bird {
	
    private static final String DUCK_URL = "http://www.wildfowl-photography.co.uk/identification/types-of-duck.htm";
	public Duck() {
        this.url = DUCK_URL;
    }
    @Override
    public boolean fly(int m){
        return false;
    }
}
