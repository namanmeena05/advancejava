package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public void testAdd(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getEnglish());
		int i = ps.executeUpdate();

		System.out.println(i);

	}

	public void testUpdate(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("update marksheet set name =? ,maths=? where id=?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3, bean.getId());
		int i = ps.executeUpdate();

		System.out.println(i);
	}

	public void testDelete(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Delete from marksheet where id=?");

		ps.setInt(1, bean.getId());
		int i = ps.executeUpdate();
		System.out.println(i);

	}

	public void testAlter() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("alter table marksheet add hindi int");

		int i = ps.executeUpdate();
		System.out.println(i);
	}

	public void testSelect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");

			System.out.print(rs.getInt(3) + "\t");
			System.out.print(rs.getInt(4) + "\t");
			System.out.print(rs.getInt(5) + "\t");
			System.out.println();
		}

	}

	public MarksheetBean findByRollNo(int rollNo) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no =?");

		ps.setInt(1, rollNo);
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setEnglish(rs.getInt(7));

		}
		return bean;

	}

	public List testSearch(MarksheetBean bean , int pageNo, int pageSize ) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		StringBuffer sql = new StringBuffer(" select * from marksheet where 1=1 ");
		if(bean != null) {
			if(bean.getName() != null ) {
				sql.append("and name like '" + bean.getName() +"%'");
			}
			if(bean.getId() != 0 && bean.getId()>0) {
				
				sql.append("and id = " + bean.getId() + "");
				}
			if(bean.getRollNo() != 0 && bean.getRollNo()>0) {
				sql.append("and roll_no = " + bean.getRollNo() + "");
				
				
			}if(pageSize>0) {
				pageNo = (pageSize - 1) * pageNo;
				sql.append("limit " + pageNo + "," + pageSize);
			}
		System.out.println(sql.toString());
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setEnglish(rs.getInt(7));
			list.add(bean);

		}
		return list;

	}
}
