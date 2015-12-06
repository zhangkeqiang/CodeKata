package kata;

import java.util.ArrayList;
import java.util.List;

public final class PrimeFactors {
	private PrimeFactors()	{		
	}
	public static List<Integer> generate(int n) {
		int num = n;
		List<Integer> primes = new ArrayList<Integer>();

		    for (int candidate = 2; num > 1; candidate++){
		    	while(num%candidate == 0){
		    		primes.add(candidate);
		    		num=num/candidate;
		    	}		    	  
		      
		    }
		    return primes;
		    
		  }
	  
	public static int calcMinCommonMultiple(int p1, int p2){	
		int minCommonMultiple = 0;
		int small, big;
		if(p1 < 0 || p2 < 0){
			return -1;
		}
		if(p1 > p2){
			small = p2;
			big = p1;
		}else {
			small = p1;
			big = p2;
		}
		
		for(int i = 1; i <= small; i++){
			minCommonMultiple = big * i;
			if(minCommonMultiple % small == 0){
				break;
			}
		}
		
		return minCommonMultiple;
	}
}
