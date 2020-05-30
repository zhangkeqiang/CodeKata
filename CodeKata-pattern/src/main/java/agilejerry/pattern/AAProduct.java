package agilejerry.pattern;

import java.util.logging.Logger;

public class AAProduct extends ProductSkeleton {
	@Override
	public void fly() {
		Logger.getAnonymousLogger().info("fly to sky");
	}

	@Override
	protected int step1() {
		return 123;

	}

	@Override
	protected int step2(int i) {
		step21();
		return step22(i + 23);

	}

	private void step21() {
		// do nothing
	}

	private int step22(int i) {
		return 122 + i;

	}
}
