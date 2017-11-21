package agilejerry.pattern;

public class Visitor {

	public boolean visit(Visited visited) {
		System.out.println("Start to Visit");
		return true;
	}

	public boolean visit(VisitedFriend visited) {
		System.out.println("Start to Visit Friend");
		return true;
	}
	
	public void shakeHand(VisitedFriend visitedFriend) {
		System.out.println("ShakeHand");
	}
	
	

}
