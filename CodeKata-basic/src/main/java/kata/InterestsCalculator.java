package kata;

public class InterestsCalculator {

	public float lincunzhenqu(float fmoney, float frate, float fyear) {
		float fsum = 0;
		for (int i = 0; i < fyear; i++) {
			fsum = (fsum + fmoney) * (1 + frate);
		}
		return fsum;
	}

	public float zhencunzhenqu(float fmoney, float frate, float fyear) {
		float fsum = fmoney;
		for (int i = 0; i < fyear; i++) {
			fsum = fsum * (1 + frate);
		}
		return fsum;
	}

	public float denebenxi(float fmoney, float frateofmonth, float fmonth) {

		return (float) (fmoney * frateofmonth * Math.pow((1 + frateofmonth), fmonth)
				/ (Math.pow((1 + frateofmonth), fmonth) - 1));

	}

	public float getYearInterestfromMonth(float frate) {
		return (float) (Math.pow((1 + frate), 12) - 1.0);
	}

}
