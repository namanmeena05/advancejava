package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn=	DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
	Statement st = conn.createStatement();
	
	int i = st.executeUpdate("create table vikash(id int primary key , name varchar(255))");
	
	System.out.println(i);
		
	}

}
