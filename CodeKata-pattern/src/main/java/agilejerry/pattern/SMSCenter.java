package agilejerry.pattern;

public class SMSCenter {
	private SMSCenter() {
	}

	public static SMSSender createSMSSender() {
		return new SMSSenderfromHX();
	}
}
