package kata;

public class SearchManager {

	public int chop(int j, int[] list) 
	{
		int nRet = -1;
		for(int i=0;i< list.length;i++)
		{
			if(j == list[i])
			{
			  nRet = i;
			  break;
			}
		}
		return nRet;
	}

}
