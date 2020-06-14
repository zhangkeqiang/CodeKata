package agilejerry.pattern;

public class WatcherFromBeiJing extends Watcher {

	@Override
	public void update(String str) {		
		logger.debug("BeiJing Welcome" + str);
		
	}

}
