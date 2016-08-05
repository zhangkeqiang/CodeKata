package kata.primefactor;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorAnalyzer {

	public static List<Integer> analyze(int n) {
		int initN = n;
		List<Integer> list = new ArrayList<Integer>();
		for(int f=2;f<n+1;){
			if(n%f ==0){
				list.add(f);
				n=n/f;
			}else{
				f++;
			}
		}
		if(n == initN)
			list.add(n);
		return list;
	}

}
