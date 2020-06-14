package agilejerry.pattern;

public class WatcherFromShangHai extends Watcher {

	@Override
	public void update(String str) {
		logger.debug(Name + " from ShangHai received " + str);

	}

}
