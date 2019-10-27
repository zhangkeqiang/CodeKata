package agilejerry.pattern;

public class EITU {
	EITI eit;
	EITCommander commander;
	public void setEIT(){
		this.eit = EITCommander.createEITI();
	}
	
	public void run(){
		if(eit != null){
			eit.run();
		}else{
			System.out.println("EIT is null");			
		}
	}
	
	public void setCommander(EITCommander theCommander){
		commander = theCommander;
	}
	
	public int calc(){
		int iRet=0;
		
		return iRet;
	}
	
}
