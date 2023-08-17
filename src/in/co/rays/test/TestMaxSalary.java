package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMaxSalary {

	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from emp where salary = (select max(salary) from emp where salary < (select max(salary)from emp))");
		
	while(rs.next()) {

		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		
	}
        
		
		
		}
	

}
