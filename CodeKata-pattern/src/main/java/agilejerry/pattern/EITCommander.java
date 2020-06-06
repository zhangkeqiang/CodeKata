package agilejerry.pattern;

public class EITCommander {
	private EITCommander() {
		//nothing
	}
	public static EITI createEITI(){
		return new EITIT();
	}
	
	public static EITContext getContext(){
		return EITContext.getInstance();
	}

	public static EITE createEIT(){
		EITE eit = null;
		if(getContext().getEITType()=="EITT"){
		    eit = new EITT();
		}else if(getContext().getEITType()=="EITT2"){
			eit = new EITT2();
		}else {
			eit = new EITT();
		}
		eit.setContext(getContext());
		return eit;
	}
}
