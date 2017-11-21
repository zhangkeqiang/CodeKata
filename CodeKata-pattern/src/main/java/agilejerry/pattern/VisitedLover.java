package agilejerry.pattern;

public class VisitedLover extends Visited {

	@Override
	public boolean accept(Visitor visitor) {
		visitor.visit(this);
		kiss(visitor);
		return true;
	}

	private void kiss(Visitor visitor) {
		System.out.println("Kiss!");
	}

}
