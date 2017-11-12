package kata;

import java.util.ArrayList;
import java.util.List;

/*
 * That is it! This is how we are using differential views and manual reviews 
 * to run an effective continuous improvement process. Of course, you can adapt 
 * it to meet your needs. But keep in mind 
 * that the most important is to be sure that technical debt is under control!
 */
public class Change {

	
	/**
	 * Get the change
	 * @param j price 
	 * @return List of Integer 
	 */
	public List<Integer> getChange(int j) {	
		
		ArrayList<Integer> list = new  ArrayList<Integer>(); 
		int i;
		i = 100 - j;
		if(i == 0){
			return list;
		}

		if(i>=50){
			list.add(50);
			i = i-50;			
		}
		while(i >= 10){		
			//add one 10
			list.add(10);   
			i = i -10;
		}
		while(i >= 5){			
				list.add(5);
				i = i -5;
		}
			while(i >= 1){		
				//add one 1
				list.add(1);  
				i = i -1;
			}
		
			
		return list;
	}
}
