package agilejerry.pattern;

public abstract class Visited {
	public abstract boolean accept(Visitor visitor); 
	/*{
		return visitor.visit(this);
	}*/
}
