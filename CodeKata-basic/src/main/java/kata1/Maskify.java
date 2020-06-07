package kata1;

public class Maskify {
	public String hideLast4Chars(String input) {
		StringBuilder sf = new StringBuilder();
		String output;
		if (input.length() > 4) {
			for (int i = 0; i < input.length() - 4; i++) {
				sf.append("#");
			}
			output = sf.toString() + input.substring(input.length() - 4);
		} else {
			output = input;
		}
		return output;
	}

}
