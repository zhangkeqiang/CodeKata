package agilejerry.pattern;

public abstract class ProductSkeleton implements Product {

	public void fly() {

	}
	public int calc(){
		int i = step1();
		return step2(i);
	}
	
	protected abstract int step1();
	protected abstract int step2(int i);
	
}
