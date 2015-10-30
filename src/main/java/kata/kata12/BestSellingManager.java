package kata.kata12;

public class BestSellingManager extends Thread {
	public static final int LAST24H = 1;
	public static final int LAST30D = 2;
	public static final int DAILYUPDATE = 1440;
	public static final int HOURLYUPDATE = 60;
	public static final int REALTIMEUPDATE = 1;
	private static int updateType = DAILYUPDATE;
	private static BestSellingList<SaleItem> bestList = new BestSellingList<SaleItem>();

	public BestSellingList<SaleItem> generateBestList() {
		bestList.clear();
		if (updateType == DAILYUPDATE) {
			for (int i = 0; i < 10; i++) {
				bestList.add(new SaleItem("AA" + String.valueOf(i)));
			}
		} else if (updateType == HOURLYUPDATE) {
			for (int i = 0; i < 10; i++) {
				bestList.add(new SaleItem("BB" + String.valueOf(i)));
			}
		} else if (updateType == REALTIMEUPDATE) {
			for (int i = 0; i < 10; i++) {
				bestList.add(new SaleItem("CC" + String.valueOf(i)));
			}
		}

		return bestList;
	}

	public BestSellingList<SaleItem> getBestList() {
		return bestList;
	}

	public void changeType(int type) {
		updateType = type;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			generateBestList();
			System.out.println("Thread running..."+String.valueOf(i));
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
