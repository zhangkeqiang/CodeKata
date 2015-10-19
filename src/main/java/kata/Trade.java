package kata;

import java.util.ArrayList;
import java.util.List;

public class Trade {

	public List<Integer> getChange(int price) {
		int change, pricewithin100;
		List<Integer> list = new ArrayList<Integer>();
		pricewithin100 = price % 100;
		if( pricewithin100 == 0){
			return list;
		}
		
		change = 100 - pricewithin100;
		int[] moola = {50,10,5,1};
		for(int i = 0; i < moola.length; i++){
			while(change >= moola[i]){
				list.add(moola[i]);
				change -= moola[i];
			}
		}
		/*
		if(change >= 50){
			list.add(50);
			change -= 50;
		}
		while(change >= 10){
			list.add(10);
			change -= 10;
		}
		while(change >= 5){
			list.add(5);
			change -= 5;
		}
		
		while(change >= 1){
			list.add(1);
			change -= 1;
		}
		*/
		
		return list;
	}

}
