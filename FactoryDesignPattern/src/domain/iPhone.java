package domain;

public class iPhone implements Mobile
{
	@Override
	public void getOsType()
	{
		System.out.println("OS type is Ios");
	}
	
	@Override
	public void getBillAmount(int qty,double price)
	{
		double totalAmount=qty*price;
		System.out.println("Total Amount is "+totalAmount);
	}
}
