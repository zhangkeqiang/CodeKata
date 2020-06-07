package agilejerry.pattern;

public abstract class SMSSender {
	public abstract void send(String string, String string2);

	public void sendVerifyCode(String sPhone) {
		String code = generateCode();
		addCodeList(sPhone, code);
		send(sPhone, code);
	};

	private void addCodeList(String sPhone, String code) {

	}

	private String generateCode() {
		return "2345";
	}

	public int verifyCode(String sPhone, String code) {
		return isInCodeList(sPhone, code) ? 1 : 0;
	}

	protected boolean isInCodeList(String sPhone, String code) {
		return sPhone == null ? false : sPhone.indexOf(code) >= 0;
	}

}
