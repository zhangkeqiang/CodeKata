package agilejerry.pattern;

public class EITContext {
	private static EITContext instance = new EITContext();  
	private int iInteger=500;
	private EITContext(){
		
	}
	
	public static EITContext getInstance(){
		return instance;		
	}
	
	public int getI(){
		return iInteger;
	}

	public void setI(int i) {
		iInteger = i;		
	}

	public String getEITType() {
		return "EITT";
	}
}
