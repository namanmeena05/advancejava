package in.co.rays.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public List search(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		if (bean != null) {
			if (bean.getId() != 0 && bean.getId() > 0) {
				sql.append(" and user_id = " + bean.getId() + "");
			}
			System.out.println(sql);

		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

			list.add(bean);

		}
		return list;
	}

	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk(bean));
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		int i = ps.executeUpdate();
		System.out.println("Data Inserted :" + i);

	}

	public Integer nextPk(UserBean bean) throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(user_id) from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public UserBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where user_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		return bean;

	} public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/rays", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update user set first_name= ? , last_name= ?,login_id =?,password =?,dob=?,address=? where user_id= ? ");
	
		ps.setString(1,bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println(i);
	}

}
