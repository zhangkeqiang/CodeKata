package kata.bowling;

/**@ClassName: BowlingTerm
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月23日 下午11:53:50 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class BowlingTerm {

	public static final int SLASH_SQARE = -3;
	/**
	 * show X for strike, not has next 2 deliver
	 */
	public static final int X_STRIKE = -2;
	/**
	 * Strike get score 10
	 */
	public static final int STRIKE = 10;
	/**
	 * no score ,show blank
	 */
	public static final int BLANK = -1;
	
	
	public static final int FRAME_NORMALOVER = 9;
	public static final int FRAME_RUNNING = 1;
	public static final int ABNORMAL = -99;
	public static final int FRAME_INIT = -4;

}
