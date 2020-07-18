package domain;

public class Car implements Vehical
{
	 @Override
     public void getVehicalType()
     {
    	 System.out.println("Vehical type is Car");
     }
	 
	 @Override
	 public void getVehicalPrice()
	 {
		 System.out.println("Vehical price is 1000000 RS");
	 }
}
