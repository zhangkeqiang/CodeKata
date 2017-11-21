package agilejerry.pattern;

public class VisitedFriend extends Visited {

	@Override
	public boolean accept(Visitor visitor) {
		visitor.visit(this);
		visitor.shakeHand(this);
		return true;
	}
	
	

}
