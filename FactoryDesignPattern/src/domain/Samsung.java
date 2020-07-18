package domain;

public class Samsung implements Mobile
{
	@Override
	public void getOsType()
	{
		System.out.println("OS type is Android");
	}
	
	@Override
	public void getBillAmount(int qty,double price)
	{
		double totalAmount=qty*price; 
		System.out.println("Total Price is "+totalAmount);
	}
	
}
