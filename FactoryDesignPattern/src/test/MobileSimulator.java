package test;

import java.util.Scanner;

import domain.Mobile;
import factory.MobileFactory;

public class MobileSimulator 
{
		
		public static void main(String[] args) 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Select Mobile");
			System.out.println("1: Samsung");
			System.out.println("2: iPhone");
			
			int choice=scan.nextInt();
			
			//create an object of factory class
			MobileFactory m1= new MobileFactory();
			Mobile v1=m1.getMobile(choice);
			
			//accept the value from end user
			
			System.out.println("Enter the Mobile Price");
			double price =scan.nextDouble();
			
			System.out.println("Enter the Mobile qty");
			int qty =scan.nextInt();
			
			//Call the method of bussines logic classes
			v1.getOsType();
			v1.getBillAmount(qty, price);
			scan.close();
		}
}
