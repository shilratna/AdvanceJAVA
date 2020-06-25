package preparedstatements;

import java.sql.*;
import java.util.Scanner;

/*Q.13 write a jdbc program to accept student id from end user 
 * and delete the specific record from table*/

public class DeleteStudent1
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER STUDENT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from student_data where student_id=?";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" RECORD DELETED SUCCESSFULLY");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			sc1.close();
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
			
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}
}
