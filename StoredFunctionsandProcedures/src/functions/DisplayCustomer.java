package functions;

import java.sql.*;
import java.util.Scanner;

public class DisplayCustomer
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER YOUR CREDIT LIMIT");
		double credit=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=root");
            
			cstmt=con.prepareCall("{?=call displaycustomertype(?)}");
			cstmt.setDouble(2, credit);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println("CUSTOMER TYPE IS "+cstmt.getString(1));
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
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
			if(cstmt!=null)
			{
				try 
				{
					cstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			sc1.close();
		}
		
	}
}
