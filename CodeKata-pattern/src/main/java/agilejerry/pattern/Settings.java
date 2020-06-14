package agilejerry.pattern;

public class Settings {
	
	private Settings() {
		//Add a private constructor to hide the implicit public one.
	}

	public static final String PRODUCT = "AA";

	public static String getProduct() {
		return PRODUCT;
	}
}
