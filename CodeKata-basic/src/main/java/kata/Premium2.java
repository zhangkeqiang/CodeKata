package kata;

public class Premium2 {
	
	
	private static final int AGE40 = 40;
	private static final int AGE39 = 39;
	private static final int AGE20 = 20;
	private static final int AGE59 = 59;

	public double calculatePremiumRate(int age, char gender, char marriage, int children) throws PremiumException {
		double point = 0;
		if(age < 0){
			throw new PremiumException("Premium:age can't be below zero.");
		}else if (age < AGE20 || age > AGE59 ){
			point += 2;
		}else if (age <= AGE39){
			point += 6;
		}else if (age >=AGE40){
			point += 4;
		}
		
		point += dealwithGender(gender);
		
		point += dealwithMarriage(marriage);
		
		if(children < 0){
			throw new PremiumException("Premium:children can't be below zero.");
		}else if(children <=6){
			point -= children * 0.5;
		}else{
			point -= 3;
		}
		
		if(point >= 10){
			return 0.6;
		} else {
			return 0.4;
		}
	}

	private double dealwithMarriage(char marriage)
			throws PremiumException {
		double p;
		if(marriage == 'Y'){
			p = 3;
		}else if(marriage == 'N'){
			p = 5;
		}else {
			throw new PremiumException("Premium:marriage can't be identified.");
		}
		return p;
	}

	private double dealwithGender(char gender) throws PremiumException {
		double p;
		if(gender == 'M'){
			  p = 5;
		}else if(gender == 'F'){
			  p= 3;
		}else {
			throw new PremiumException("Premium:gender can't be identified.");
		}
		return p;
	}


}

class PremiumException extends  Exception
{
	private static final long serialVersionUID = 1L; 
	PremiumException(String msg)
	{
		super(msg);
	}
}

