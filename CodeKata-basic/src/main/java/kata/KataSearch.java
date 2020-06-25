package kata;

public class KataSearch {


	public int chop(int search,int[] array) {	
        for(int i=0; i<array.length ;i++) { 	    
			if(search == array[i]){
				return i;
			}
        }
		return -1;
	}

	public int chop2(int search,int[] array){
		int n = array.length - 1;
		int nh = n;
		int nl = 0;
		int nm,v;

		while(nl <= nh) {			
			//get average(nh, nl)
			nm = (nh+nl) >>> 1; 
			v = array[nm];
			if(search == v){
				return nm;
			}else if(search < v) {
				nh = nm-1;		
			}else {
				nl = nm+1;				
			}						
		}
		return -1;
	}
}
