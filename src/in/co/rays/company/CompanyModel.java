package in.co.rays.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class CompanyModel {

	public void add(CompanyBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("Insert into company values(?,?,?,?,?)");
		ps.setInt(1, bean.getCompId());
		ps.setString(2, bean.getCompName());
		ps.setString(3, bean.getPerformnce());
		ps.setInt(4, bean.getStrength());
		ps.setString(5, bean.getTurnOver());

		int i = ps.executeUpdate();
		System.out.println(i);
	}

	public List search(CompanyBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from company where 1=1");

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();
		while (rs.next()) {
			bean = new CompanyBean();
			bean.setCompId(rs.getInt(1));
			bean.setCompName(rs.getString(2));
			bean.setPerformnce(rs.getString(3));
			bean.setStrength(rs.getInt(4));
			bean.setTurnOver(rs.getString(5));
			list.add(bean);
		}

		return list;

	}

}
