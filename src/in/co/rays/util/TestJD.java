package in.co.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJD {

	public static void main(String[] args) throws Exception {
		
		testGet();
	}

	private static void testGet() throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where user_id =?");
		ps.setInt(1, 2);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getDate(6));
			System.out.println(rs.getString(7));
			
		}

	
	}
	
	}


