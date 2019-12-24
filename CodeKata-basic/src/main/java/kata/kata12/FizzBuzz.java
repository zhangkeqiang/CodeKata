package kata.kata12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FizzBuzz {
	private static final String BUZZ = "Buzz";
	private static final String FIZZ = "Fizz";
	private static final String FIZZ_BUZZ = "FizzBuzz";
	protected static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		printFizzBuzzFromOneToHundred();
	}

	protected static void printFizzBuzzFromOneToHundred() {
		FizzBuzz fiz = new FizzBuzz();
		for (int i = 1; i < 101; i++) {
			logger.info(fiz.getFizzBuzzValue(i));
		}
	}
	
	public String getFizzBuzzValue(int number) {
		if (isMultipleByParam(number, 15)) {
			return FIZZ_BUZZ;
		} else if (isMultipleByParam(number, 3)) {
			return FIZZ;
		} else if (isMultipleByParam(number, 5)) {
			return BUZZ;
		} else {
			return Integer.toString(number);
		}
	}

	protected boolean isMultipleByParam(int dividend, int divisor) {
		return dividend % divisor == 0;
	}

}
