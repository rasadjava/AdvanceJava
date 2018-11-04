package com.c2n.advjava.datasoure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDataSource {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("##TejaStart##");
		MySQLDataSource.mySQLDatabaseConnection();
		System.out.println("##TejaEnd##");
	}
	
	public static void mySQLDatabaseConnection() throws ClassNotFoundException, SQLException {
		//Register the driver class
		Class.forName("com.mysql.jdbc.Driver");
		//Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","admin");
		//Create statement
		Statement stm=con.createStatement();
		//Build SQL queries 
		String sql1="select email from users";
		String sql2="select username from users";
		String sql3="select username,email from users";
		//Establish ResultSet
		ResultSet rs=stm.executeQuery(sql1);
		//fetching the data from ResultSet
		System.out.println("##Start_Kiran##");
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("##End##");
		//close the connection
		con.close();
	}

}
