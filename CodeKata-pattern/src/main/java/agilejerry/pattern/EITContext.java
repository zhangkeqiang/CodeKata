package agilejerry.pattern;

public class EITContext {
	private static EITContext instance = new EITContext();  
	private int I=500;
	private EITContext(){
		
	}
	
	public static EITContext getInstance(){
		return instance;		
	}
	
	public int getI(){
		return I;
	}

	public void setI(int i) {
		I = i;		
	}

	public String getEITType() {
		return "EITT";
	}
}
