package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreatePropertie
{
	public static void main(String[] args) 
	{
		FileWriter fw=null;
		
		Properties prop=new Properties();
		
		try
		{
			fw=new FileWriter("D:\\J2EE-Code\\database.properties");
		
			prop.setProperty("username", "root");
			prop.setProperty("password", "root");
			
			prop.store(fw, "EXTERNAL FILE");
			
			System.out.println("PROPERTIES FILE CREATED SUCCESSFULLY");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(fw!=null)
			{
				try
				{
					fw.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
