package preparedstatements;

import java.sql.*;

/*Q.11 Write a jdbc program to insert 3 students 
 * at a same time by using statement platform*/

public class InsertStudent1 
{
	public static void main(String[] args)
	{
		//declare resources
		Connection con=null;
		Statement stmt=null;
		
		//sql queries
		String query1="insert into student_data values(0,'ROHIT',78.25,'ETC')";
		String query2="insert into student_data values(0,'ASHWIN',85.14,'CS')";
		String query3="insert into student_data values(0,'RAMESH',65.14,'EEE')";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=root");
		
			stmt=con.createStatement();
			
			int count1=stmt.executeUpdate(query1);
			
			int count2=stmt.executeUpdate(query2);
			
			int count3=stmt.executeUpdate(query3);
			
			System.out.println(count1+count2+count3+" RECORDS INSERTED");
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
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
