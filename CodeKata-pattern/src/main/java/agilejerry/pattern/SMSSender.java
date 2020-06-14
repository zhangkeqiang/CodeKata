package agilejerry.pattern;

import java.util.HashMap;
import java.util.Map;

public abstract class SMSSender {
	private static final String _2345 = "2345";
	private Map<String, String> mapPhoneCode = new HashMap<>();
	public abstract void send(String string, String string2);

	public void sendVerifyCode(String sPhone) {
		String code = generateCode();
		addCodeList(sPhone, code);
		send(sPhone, code);
	};

	private void addCodeList(String sPhone, String code) {
		mapPhoneCode.put(sPhone, code);
	}

	private String generateCode() {
		return _2345;
	}

	public int verifyCode(String sPhone, String code) {
		return isInCodeList(sPhone, code) ? 1 : 0;
	}

	protected boolean isInCodeList(String sPhone, String code) {
		return sPhone == null ? false : sPhone.indexOf(code) >= 0;
	}

}
