package agilejerry.pattern;

public abstract class Watcher {
	protected String Name="Anonymous";
	public void update(String str){
		System.out.println("China");
	}
	public void setName(String thename){
		Name = thename; 
	}
}

