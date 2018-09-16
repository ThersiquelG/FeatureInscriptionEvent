package com.general.greg;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionBDD {
	public static Connection openConnection () {
		Connection cn = null;

		String url = "jdbc:mysql://localhost:3306/mabddevent";
		String usr = "root";
		String pwd = "root";

		try 
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}

			cn = (Connection) DriverManager.getConnection(url, usr, pwd); //attempting to connect to MySQL database
			System.out.println("Driver loaded"+ cn);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return cn; 
	}
}



