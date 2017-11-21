package agilejerry.pattern;

public class EITT extends EITE {

	@Override
	protected int run1() {
		return this.context.getI();
	}

	@Override
	protected int run2() {
		return 3;
	}
    
}
