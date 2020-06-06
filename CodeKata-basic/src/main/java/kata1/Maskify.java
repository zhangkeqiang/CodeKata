package kata1;

public class Maskify {
	public String hideLast4Chars(String input) {
		return input.substring(0,input.length()-4) + "####";
	}

}
