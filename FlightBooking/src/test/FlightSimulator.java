package test;

import java.util.Scanner;

import admin.AdminOperations;
import customer.CustomerOperations;

//UTILIZATION LAYER OR PRESENTATION LAYER
public class FlightSimulator 
{
	static Scanner sc1=new Scanner(System.in);
	
	
	public static void main(String[] args)
	{
		System.out.println("SELECT TYPE OF USER");
		System.out.println("PRESS 1 FOR ADMIN");
		System.out.println("PRESS 2 FOR CUSTOMER");
		
		int choice=sc1.nextInt();
		
		if(choice==1)
		{
			displayAdminOperations();
		}
		else if(choice==2)
		{
			displayCustomerOperations();
		}
		
	}
	
	static void displayAdminOperations()
	{
		System.out.println("1: ADD FLIGHT DETAILS");
		System.out.println("2: DELETE FLIGHT DETAILS");
		System.out.println("3: DISPLAY FLIGHT DETAILS");
		
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: addFlightDetails();
				break;
				
		case 2: deleteFlightDetails();
				break;
				
		case 3: displayFlightDetails();
				break;
		}
	}
	
	static void displayCustomerOperations()
	{
		System.out.println("1: SEARCH FLIGHT");
		System.out.println("2: BOOK TICKETS");
		
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: searchFlightDetails();
				break;
				
		case 2: bookTickets();
				break;
		}
	}

	static void addFlightDetails()
	{
		//accept the values from end user
		System.out.println("ENTER SOURCE");
		String source=sc1.next();
		
		System.out.println("ENTER DESTINATION");
		String destination=sc1.next();
		
		System.out.println("ENTER SERVICE PROVIDER");
		String serviceprovider=sc1.next();
		
		System.out.println("ENTER NO OF TICKETS AVAILABLE");
		int tickets=sc1.nextInt();
		
		//pass the values for business logic class
		AdminOperations a1=new AdminOperations();
		
		a1.insertFlightDetails(source, destination, serviceprovider, tickets);
	}
	
	static void deleteFlightDetails()
	{
		//accept flight id
		System.out.println("ENTER FLIGHT ID");
		int id=sc1.nextInt();
		
		//pass the values for business logic class
		AdminOperations a1=new AdminOperations();
		a1.removeFlightDetails(id);
	}
	
	static void displayFlightDetails()
	{
		//call the method of business logic class
		AdminOperations a1=new AdminOperations();
		a1.showFlightDetails();
	}
	
	static void searchFlightDetails()
	{
		//accept source and destination
		
		System.out.println("ENTER SOURCE");
		String source=sc1.next();
		
		System.out.println("ENTER DESTINATION");
		String destination=sc1.next();
		
		//pass the values for business logic class 
		CustomerOperations c1=new CustomerOperations();
		c1.findFlightDetails(source, destination);
	}
	
	static void bookTickets()
	{
		//source  destination tickets service provider
		
		System.out.println("ENTER THE SOURCE");
		String source=sc1.next();
		
		System.out.println("ENTER THE DESTINATION");
		String destination=sc1.next();
		
		System.out.println("ENTER SERVICE PROVIDER");
		String servicename=sc1.next();
		
		System.out.println("ENTER NO OF TICKETS TO BOOK");
		int tickets=sc1.nextInt();
		
		//call the method of business logic class
		CustomerOperations c1=new CustomerOperations();
		c1.bookFlightTickets(source, destination, servicename, tickets);
	}

}
