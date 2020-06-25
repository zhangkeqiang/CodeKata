package kata;

public class Premium {
    
    private static final double N0_4 = 0.4;
    private static final String PREMIUM_CHILDREN_CAN_T_BE_BELOW_ZERO = "Premium:children can't be below zero.";
    private static final String PREMIUM_MARRIAGE_CAN_T_BE_IDENTIFIED = "Premium:marriage can't be identified.";
    private static final String PREMIUM_GENDER_CAN_T_BE_IDENTIFIED = "Premium:gender can't be identified.";
    private static final String PREMIUM_AGE_CAN_T_BE_BELOW_ZERO = "Premium:age can't be below zero.";
    private static final int N39 = 39;
    private static final int N59 = 59;
    private static final int TWENTY = 20; 

    public double calculatePremiumRate(int age, char gender, char marriage, int children) throws KataException{
        double point = 0;
        point = calculatePremiumPointByAge(age, point);        
        point = calculatePremiumPointByGender(gender, point);        
        point = calculatePremiumPointByMarriage(marriage, point);
        point = calculatePremiumPointByChildren(children, point);        
        return calculatePremiumRateByPoint(point);
    }

	protected double calculatePremiumRateByPoint(double point) {
		if(point >= 10){
            return 0.6;
        } else {
            return N0_4;
        }
	}

	protected double calculatePremiumPointByChildren(int children, double point) throws KataException {
		if(children < 0){
            throw new KataException(PREMIUM_CHILDREN_CAN_T_BE_BELOW_ZERO);
        }else if(children <=6){
            point -= children * 0.5;
        }else{
            point -= 3;
        }
		return point;
	}

	protected double calculatePremiumPointByMarriage(char marriage, double point) throws KataException {
		if(marriage == 'Y'){
            point += 3;
        }else if(marriage == 'N'){
            point += 5;
        }else {
            throw new KataException(PREMIUM_MARRIAGE_CAN_T_BE_IDENTIFIED);
        }
		return point;
	}

	protected double calculatePremiumPointByGender(char gender, double point) throws KataException {
		if(gender == 'M'){
            point += 5;
        }else if(gender == 'F'){
            point += 3;
        }else {
            throw new KataException(PREMIUM_GENDER_CAN_T_BE_IDENTIFIED);
        }
		return point;
	}

	protected double calculatePremiumPointByAge(int age, double point) throws KataException {
		if(age < 0){
            throw new KataException(PREMIUM_AGE_CAN_T_BE_BELOW_ZERO);
        }else if (age < TWENTY || age > N59 ){
            point += 2;
        }else if (age <= N39){
            point += 6;
        }else if (age >=40){
            point += 4;
        }
		return point;
	}


}
