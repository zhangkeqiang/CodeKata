package com.agilejerry.bowling;

/**@ClassName: BowlingRoll
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月25日 下午11:27:13 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class BowlingRoll {

	private int maxPins;
	private int pins;

	/**(这里用一句话描述这个构造函数的作用)
	 * @param pins
	 */
	public BowlingRoll(int maxPins) {
		this.maxPins = maxPins;
	}

	/**@method getMaxPins(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月27日 上午8:16:53
	*/
	public int getMaxPins() {
		// TODO Auto-generated method stub
		return this.maxPins;
	}

	/**@method getScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月27日 上午8:19:57
	*/
	public int getPins() {
		// TODO Auto-generated method stub
		return this.pins;
	}

	/**@method setPins(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月27日 上午8:25:38
	*/
	public void setPins(int pins) {
		this.pins = pins;
	}

}
