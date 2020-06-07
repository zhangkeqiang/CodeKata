package agilejerry.pattern;

public class SimpleFactory {
	private SimpleFactory() {
		//to hide the implicit public one
	}
	public static Product createProduct()
	{
		if(Settings.getProduct().equals("AB")){
			return new ABProduct();	
		}else{
			return new AAProduct();	
		}
	}
}
