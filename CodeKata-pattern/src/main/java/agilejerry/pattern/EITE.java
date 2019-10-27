package agilejerry.pattern;

public abstract class EITE implements EITI{
	protected EITContext context;
	public int run(){
		System.out.println("EITE.run...run1 = " + run1());
		return run1() + run2();
	}
	
	protected abstract int run1();
	abstract protected int run2();

	public void setContext(EITContext theContext) {
		this.context = theContext;
	}
	public void setContextI(int i){
		context.setI(i);
	}
}
