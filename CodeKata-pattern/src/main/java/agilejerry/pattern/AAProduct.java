package agilejerry.pattern;

public class AAProduct extends ProductSkeleton {

	public void fly() {		
	}


	@Override
	protected int step1() {
		return 123;
		
	}

	@Override
	protected int step2(int i) {
		step21();		
		return step22(i+23);
		
	}
	
	private void step21(){
		//do nothing
	}

	private int step22(int i){
		return 122+i;
		
	}
}
