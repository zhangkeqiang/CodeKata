package agilejerry.pattern;

public class WatcherFromSuZhou extends Watcher {

	@Override
	public void update(String str) {
		logger.debug("SuZhou copyed " + str + ", by " + Name );
	}

}
