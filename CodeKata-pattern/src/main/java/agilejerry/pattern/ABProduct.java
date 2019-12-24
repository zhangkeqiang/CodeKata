package agilejerry.pattern;

import java.util.logging.Logger;

public class ABProduct extends ProductSkeleton {

	@Override
	public void fly() {
		Logger.getAnonymousLogger().info("fly to sky on AB");
	}

	@Override
	protected int step1() {
		return 0;
	}

	@Override
	protected int step2(int i) {
		return 123;

	}

}
