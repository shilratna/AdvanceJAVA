package test;

import java.util.Scanner;

import domain.Vehical;
import factory.VehicalFactory;

public class VehicalSimulator 
{
		
		public static void main(String[] args) 
		{
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Select Vehical type :");
			System.out.println("1: Bike");
			System.out.println("2: Car");
			
			int choice =scan.nextInt();
			
			VehicalFactory f1=new VehicalFactory();
			Vehical v =f1.getVehical(choice);
			
			
			v.getVehicalPrice();
			v.getVehicalType();
			scan.close();
			
		}
}
