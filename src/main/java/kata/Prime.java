package kata;

public class Prime {

	public static int searchMaxPrime(int max) {
		int maxprimecandidate = max;
		if(max < 1)
		{
			return -1;
		}
		while(!isPrime(maxprimecandidate)){
			maxprimecandidate--;
		}
		return maxprimecandidate;
	}

	private static boolean isPrime(int maxprimecandidate) {
		if(maxprimecandidate < 4 && maxprimecandidate > 0){
			return true;
		}
		if(maxprimecandidate < 1){
			return false;
		}
			
		boolean isprime = true;
		int maxturn = maxprimecandidate / 2 + 1;
		for(int i = 2;i < maxturn;i++){
			if(maxprimecandidate % i == 0){
				isprime = false;
				break;
			}
		}
		return isprime;
	}
	
	
	public static int searchMinPrime(int max) {
		int minprimecandidate = max+1;
		if(minprimecandidate < 1)
		{
			return -1;
		}
		while(!isPrime(minprimecandidate)){
			minprimecandidate++;
		}
		return minprimecandidate;
	}
	
	

}
