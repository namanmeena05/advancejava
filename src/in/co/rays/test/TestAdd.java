package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAdd {
	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			Statement st = conn.createStatement();
			int i = st.executeUpdate("insert into marksheet values(2,'suraj',121,11,11,22)");
			i = st.executeUpdate("insert into marksheet values(3,'suraj',121,11,11,22)");
			 i = st.executeUpdate("insert into marksheet values(3,'suraj',121,11,11,22)");
			 i = st.executeUpdate("insert into marksheet values(4,'suraj',121,11,11,22)");
		

			System.out.println("insert data :" + i);
			 conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());

		}
	}

}
