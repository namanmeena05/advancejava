package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from marksheet");
        
		while(rs.next()) {
		System.out.print(" insert data : " + rs.getInt(1));
		System.out.print(" insert data : " + rs.getString(2));
		System.out.print(" insert data : " + rs.getInt(3));
		
		System.out.println();
		}
	}

}
