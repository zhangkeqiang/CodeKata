package kata16;

import java.util.ArrayList;

public class BowlingFrame {
	private String state;
	private int currentFrame = 0;
	private ArrayList<BowlingBlock> alBlock = new ArrayList<BowlingBlock>();

	public BlockResult addBlock(BowlingBlock block) {
		BlockResult result;
		alBlock.add(block);
		if (block.getPin() == 10 && currentFrame == 0) {
			 result = new BlockResult("Strike!",1);
		} else {
			result = new BlockResult("Hit"+block.getPin()+"Pins",1);
		}
		currentFrame++;
		return result;
	}

}
