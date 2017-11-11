package com.c2n.advjava.datasoure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementConcept {
	static Connection con = null;
	static Statement stm = null;
	String sql_select="select * from users";
	String sql_update="update users set email='farheensyed008@gamil.com' where usersid='1'";
	String sql_delete="delete from users where usersid='2'";
	String sql_create="create table File_Image(id int(5) primary key, name varchar(15), image LONGBLOB, file LONGTEXT, status varchar(15))";
    String sql_remove="drop table image_table";
	public static void main(String[] args) throws Exception {
		StatementConcept.DBConnection();
		StatementConcept statementConcept = new StatementConcept();
		//statementConcept.statementQueryMethod();
		//statementConcept.statementUpdateMethod();
		//statementConcept.statementExecuteBatchMethod();
		statementConcept.statementExecuteMethod();
	}

	public static Connection DBConnection() throws Exception {
		System.out.println("Tring to connect MySQL Database");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
		stm = con.createStatement();
		System.out.println("MySQL Database Connected");
		return con;
	}

	public void statementQueryMethod() throws SQLException, Exception {
		System.out.println("###Statement executeQuery()###");
		// Statement stm=con.createStatement();
		//Statement = StatementConcept.DBConnection().createStatement();
		ResultSet rs=stm.executeQuery(sql_select);
		while(rs.next()) {
		int role=rs.getInt(8);
		String phone=rs.getString(7);
		String address=rs.getString(6);
		String password=rs.getString(5);
		System.out.println(password+","+address+","+phone+","+role);
		}

	}

	public void statementUpdateMethod() throws SQLException, Exception {
		System.out.println("###Statement executeUpdate()###");
		//Statement stm = StatementConcept.DBConnection().createStatement();
		int update_status=stm.executeUpdate(sql_update);
		System.out.println(update_status);

	}
	
	public void statementExecuteBatchMethod() throws SQLException, Exception {
		System.out.println("###Statement executeBatch()###");
		//Statement stm = StatementConcept.DBConnection().createStatement();
		stm.addBatch(sql_update);
		stm.addBatch(sql_delete);
		//stm.addBatch(sql_select); // can not use select statement in Batch Processing
		//stm.addBatch(sql_create); //run only one time
		stm.addBatch(sql_remove);
		int[] batch_sataus=stm.executeBatch();// Batch Processing
		System.out.println(batch_sataus);
	}
	public void statementExecuteMethod() throws Exception {
		System.out.println("###Statement executeExcute()###");
		//Statement stm = StatementConcept.DBConnection().createStatement();
		//boolean isExecuted=stm.execute(sql_select); // returns boolean value i.e., True or False
		boolean isExecuted=stm.execute(sql_update); 
		System.out.println(isExecuted);
	}
}
