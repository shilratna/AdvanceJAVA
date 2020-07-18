package domain;

public class Bike implements Vehical
{       
	    @Override
		public void getVehicalType()
		{
			System.out.println("Vehical type is Bike");
		}
	    
	    @Override
	    public void getVehicalPrice()
	    {
	    	System.out.println("Vehical Price is 10000 RS");
	    }
}
