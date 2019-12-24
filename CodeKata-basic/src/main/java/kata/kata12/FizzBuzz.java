package kata.kata12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FizzBuzz {
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
			return "FizzBuzz";
		} else if (isMultipleByParam(number, 3)) {
			return "Fizz";
		} else if (isMultipleByParam(number, 5)) {
			return "Buzz";
		} else {
			return Integer.toString(number);
		}
	}

	protected boolean isMultipleByParam(int number, int j) {
		return number % j == 0;
	}

}
