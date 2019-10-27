package agilejerry.pattern;

public class EITT2 extends EITE {

	@Override
	protected int run1() {
		return this.context.getI()*3;
	}

	@Override
	protected int run2() {
		return 5;
	}
    

}
