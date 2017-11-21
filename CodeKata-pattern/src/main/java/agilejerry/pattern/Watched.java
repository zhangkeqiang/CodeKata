package agilejerry.pattern;

import java.util.ArrayList;
import java.util.List;

public class Watched {
	private List<Watcher> list = new ArrayList<Watcher>();
	public void addWatcher(Watcher watcher)
    {
        list.add(watcher);
    }
	public void makeFriend(Watcher watcher){
		addWatcher(watcher);
	}
    public void removeWatcher(Watcher watcher)
    {
        list.remove(watcher);
    }
    
    public void unfriend(Watcher watcher){
    	removeWatcher(watcher);
    }
	public void notifyWatchers(String str)
	{
	    for (Watcher watcher : list)
        {
            watcher.update(str);
        }
    }

}
