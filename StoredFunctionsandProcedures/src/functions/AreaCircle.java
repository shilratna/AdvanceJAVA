package functions;

import java.sql.*;
import java.util.Scanner;

public class AreaCircle 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER RADIUS OF CIRCLE");
		double radius=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=root");
 
			cstmt=con.prepareCall("{?=call areacircle(?)}");
			cstmt.setDouble(2, radius);
			cstmt.registerOutParameter(1, Types.DOUBLE);
			
			cstmt.execute();
			
			System.out.println("AREA OF CIRCLE IS "+cstmt.getDouble(1));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		sc1.close();
	}
}
