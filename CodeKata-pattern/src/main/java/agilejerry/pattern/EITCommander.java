package agilejerry.pattern;

public class EITCommander {
	//private EITContext eitContext;
	public static EITI createEITI(){
		return new EITIT();
	}
	
	public static EITContext getContext(){
		/*
		if(eitContext == null){
			eitContext = EITContext.getInstance();
		}
		return eitContext;
		*/
		return EITContext.getInstance();
	}

	public static EITE createEIT(){
		EITE eit = null;
		if(getContext().getEITType()=="EITT"){
		    eit = new EITT();
		}else if(getContext().getEITType()=="EITT2"){
			eit = new EITT2();
		}
		eit.setContext(getContext());
		return eit;
	}
}
