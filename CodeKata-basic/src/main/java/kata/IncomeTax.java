package kata;

public class IncomeTax {

    private static final double N2NDRATE = 0.2;
    private static final int SECONDSTAIR = 4500;
    private static final int STARTSTAIR = 3500;
    private static final double SECONDSTAIRRATE = 0.1;
    private static final double FIRSTSTAIRRATE = 0.03;
    private static final int FIRSTSTAIR = 1500;

    public double calculate(double income) {
        double incomeintax = income - IncomeTax.STARTSTAIR;
        double tax;
        if(incomeintax <= 0){
            tax = 0;
        }else if(incomeintax <= FIRSTSTAIR){
            tax = (incomeintax * IncomeTax.FIRSTSTAIRRATE);
        }else if(incomeintax <= IncomeTax.SECONDSTAIR){
            tax = (FIRSTSTAIR * IncomeTax.FIRSTSTAIRRATE + (incomeintax - FIRSTSTAIR) * IncomeTax.SECONDSTAIRRATE);
        }else if(incomeintax <= 9000){
            tax = (FIRSTSTAIR * IncomeTax.FIRSTSTAIRRATE + (SECONDSTAIR - FIRSTSTAIR) * IncomeTax.SECONDSTAIRRATE + (incomeintax - SECONDSTAIR) * N2NDRATE);
        }else if(incomeintax <= 20000){
            tax = FIRSTSTAIR * IncomeTax.FIRSTSTAIRRATE + (SECONDSTAIR - FIRSTSTAIR) * IncomeTax.SECONDSTAIRRATE + 4500 * 0.2 + (incomeintax - 9000) * 0.25;
        }else          {
            tax = FIRSTSTAIR * IncomeTax.FIRSTSTAIRRATE + (SECONDSTAIR - FIRSTSTAIR) * IncomeTax.SECONDSTAIRRATE + 4500 * 0.2 + (incomeintax - 9000) * 0.45;

        }
            
        return tax;
    }

}
