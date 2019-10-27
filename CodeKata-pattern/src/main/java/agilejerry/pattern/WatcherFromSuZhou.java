package agilejerry.pattern;

public class WatcherFromSuZhou extends Watcher {

	@Override
	public void update(String str) {
		System.out.println("SuZhou copyed " + str + ", by " + Name );
	}

}
