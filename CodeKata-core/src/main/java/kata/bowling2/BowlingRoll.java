package kata.bowling2;

public class BowlingRoll {
	private int pins;
	private int maxPins = 10;;
	

	public BowlingRoll(int maxPins){
		this.maxPins = maxPins;
	}

	/**@method getPins(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午7:24:37
	*/
	public int getPins() {
		return this.pins;
	}

	/**@method setPins(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午7:25:53
	*/
	public void setPins(int pins) {
		this.pins = pins;
	}

	/**@method getMaxPins(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月24日 上午10:16:48
	*/
	public int getMaxPins() {
		return this.maxPins;
	}
}
