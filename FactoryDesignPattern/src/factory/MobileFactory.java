package factory;

import domain.Mobile;
import domain.Samsung;
import domain.iPhone;

public class MobileFactory 
{
		public Mobile getMobile(int mobiletype)
		{
			Mobile m1=null;
			switch(mobiletype)
			{
			case 1: m1=new Samsung();
					break;
					
			case 2: m1=new iPhone();
					break;
			}
			
			return m1;
		}
}
