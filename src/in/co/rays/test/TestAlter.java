package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestAlter {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		Statement st = conn.createStatement();
		int i = st.executeUpdate("alter table marksheet add column english int");
		System.out.println(i);
	}

}
