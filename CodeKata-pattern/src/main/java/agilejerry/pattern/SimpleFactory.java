package agilejerry.pattern;

public class SimpleFactory {

	public static Product CreateProduct()
	{
		if(Settings.getProduct() == "AB"){
			return new ABProduct();	
		}else{
			return new AAProduct();	
		}
		

		
	}
}
