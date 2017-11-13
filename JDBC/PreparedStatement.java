package com.c2n.advjava.datasoure;

import java.sql.Connection;
import java.sql.DriverManager;

public class PreparedStatement {
	static Connection con = null;
	static String sql_insert = "insert into users values(?,?,?,?,?,?,?,?)";

	public static void main(String[] args) throws Exception {
		PreparedStatement preparedStatement =new PreparedStatement();
		preparedStatement.preparedStatementMethod();
	}

	public static Connection DBConnection() throws Exception {
		System.out.println("Tring to connect MySQL Database");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
		System.out.println("MySQL Database Connected");
		return con;
	}

	public void preparedStatementMethod() throws Exception {
		java.sql.PreparedStatement pstm = PreparedStatement.DBConnection().prepareStatement(sql_insert);
		pstm.setInt(1, 126);
		pstm.setString(2, "Prasad");
		pstm.setString(3, "Prasad");
		pstm.setString(4, "Prasad");
		pstm.setString(5, "Prasad");
		pstm.setString(6, "Prasad");
		pstm.setInt(7, 99922234);
		pstm.setInt(8, 9);
		int pstm_status = pstm.executeUpdate();
		System.out.println("PreparedStatement status " + pstm_status);

	}

}
