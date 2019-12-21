package kata.kata12;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BestSellingManager extends Thread {
    public static final int LAST24H = 1;
    public static final int LAST30D = 2;
    public static final int DAILYUPDATE = 1440;
    public static final int HOURLYUPDATE = 60;
    public static final int REALTIMEUPDATE = 1;
    private static final Logger LOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private int updateType = DAILYUPDATE;
    private static ArrayList<SaleItem> bestList = new ArrayList<>();

    public List<SaleItem> generateBestList() {
        bestList.clear();
        if (updateType == DAILYUPDATE) {
            addSaleItemIntoBestList("AA");
        } else if (updateType == HOURLYUPDATE) {
        	addSaleItemIntoBestList("BB");
        } else if (updateType == REALTIMEUPDATE) {
        	addSaleItemIntoBestList("CC");
        }

        return bestList;
    }

	private void addSaleItemIntoBestList(String name) {
		for (int i = 0; i < 10; i++) {
		    bestList.add(new SaleItem(name + i));
		}
	}

    public List<SaleItem> getBestList() {
        return bestList;
    }

    public void changeType(int type) {
        updateType = type;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            generateBestList();
            LOGGER.info("Thread running..."+i);
            try {
                sleep(50);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
