package customer;

import java.sql.*;

public class CustomerOperations
{
	static Connection con;
	
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=root");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	//search flight details
	
	public void findFlightDetails(String source,String destination)
	{
		//declare resources
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//prepare sql query
		//selection or projection
		
		String query="select service_provider from flight_data where source=? and destination=?";
		//execute the sql query
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			
			rs=pstmt.executeQuery();
			//display the names of service providers
			System.out.println("SERVICE NAME");
			System.out.println("--------------");
			while(rs.next())
			{
				String service=rs.getString(4);
				
				System.out.println(service);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, rs);
		}
		
	}
	
	//book tickets
	public void bookFlightTickets(String source,String destination,String service,int tickets)
	{
		//declare resources
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query1="select tickets_available from flight_data where source=? and destination=? and service_provider=?";
		
		try
		{
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1, source);
			pstmt.setString(2, destination);
			pstmt.setString(3, service);
			
			rs=pstmt.executeQuery();
			//check the flight details are correct or incorrect
			if(rs.next())
			{
				int dbtickets=rs.getInt("tickets_available");
				
				//check the tickets are available or not
				
				if(tickets<=dbtickets)
				{
					System.out.println();
					//deduct the no of tickets from db table
					String query2="update flight_data set tickets_available=? where source=? and destination=? and service_provider=?";
					
					pstmt=con.prepareStatement(query2);
					pstmt.setInt(1, dbtickets-tickets);
					pstmt.setString(2, source);
					pstmt.setString(3, destination);
					pstmt.setString(4, service);
					
					pstmt.executeUpdate();
					//if tickets are available then book the no of tickets
					System.out.println(tickets+" TICKETS HAS BEEN BOOKED");
					
				}
				else  //if tickets are not available then display proper msg.
				{
					System.out.println("SORRY TICKETS ARE NOT AVAILABLE");
				}
			}
			else
			{
				System.out.println("PLEASE PROVIDE VALID FLIGHT DETAILS");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, rs);
		}
	}
	
	static void closeCostlyResources(Connection con,Statement stmt,ResultSet rs)
	{
		//UPCASTING Statement stmt=pstmt
		if(con!=null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
