package factory;

import domain.Bike;
import domain.Car;
import domain.Vehical;

public class VehicalFactory 
{

	public Vehical getVehical(int vehicaltype)
	{
		Vehical v1=null;
		
		switch(vehicaltype)
		{
		
		case 1: v1= new Bike();
				break;
				
		case 2: v1= new Car();
				break;
		}
		
		return v1;
	}
}
