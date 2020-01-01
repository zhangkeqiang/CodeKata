package kata16;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BowlingFrame {
	protected Logger logger = LogManager.getLogger();
	private static final String STRIKE = "STRIKE";
	private String state = "INIT";
	private int currentBlockNum = 0;
	public int getCurrentBlockNum() {
		return currentBlockNum+1;
	}
	private ArrayList<BowlingBlock> alBlock = new ArrayList<BowlingBlock>();
	public BowlingBlock getCurrentBlock() {
		return alBlock.get(currentBlockNum);
	}
	public BlockResult addBlock(BowlingBlock block) {
		BlockResult result;
		alBlock.add(block);
		if (block.getPin() == 10 && currentBlockNum == 0) {
			logger.debug("STRIKE");
			state = STRIKE;
			result = new BlockResult("Strike!", state);
		} else if (block.getPin() == 0 && currentBlockNum == 0) {
			state = "FIRSTBLOCK";
			result = new BlockResult("Gutter Ball!", state);
		} else if (block.getPin() == 0 && currentBlockNum == 1) {
			logger.debug("SECONDBLOCK");
			state = "SECONDBLOCK";
			result = new BlockResult("Gutter Ball!", state);
		}
		else {
			state = "FIRSTBLOCK";
			result = new BlockResult("Hit" + block.getPin() + "Pins", state);
		}
		currentBlockNum++;
		logger.debug("currentBlockNum:"+getCurrentBlockNum());
		return result;
	}

	public String getState() {
		return this.state;
	}

}
