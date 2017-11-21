package agilejerry.pattern;

public abstract class SMSSender {	
	public abstract void send(String string, String string2);
	
	public void sendVerifyCode(String sPhone, String message){
		String code = generateCode();
		addCodeList(sPhone, code);
		send(sPhone,code);		
	};
	
	private void addCodeList(String sPhone, String code) {
		
	}

	private String generateCode() {
		return "2345";
	}

	public int verifyCode(String sPhone, String code){
		int ret = 0;
		if(isInCodeList(sPhone,code)){
			ret = 1;
		}
		return ret;
	}

	private boolean isInCodeList(String sPhone, String code) {
		return false;
	}

}
