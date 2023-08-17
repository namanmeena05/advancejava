package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testAlter();
		// testSelect();
		// findByRollNo();
		   testsearch();
	}

	private static void testsearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		//bean.setName("n");
		//bean.setId(1);
		//bean.setRollNo(102);
		
		MarksheetModel model = new MarksheetModel();
		List list = model.testSearch(bean,5,2);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getEnglish());
			System.out.println();

		}
	}

	private static void findByRollNo() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByRollNo(102);

		MarksheetBean rollNo = bean;

		if (rollNo != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getEnglish());
		} else {
			System.out.println("rollno not exist........!");
		}

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(12);
		bean.setName("mohan");
		bean.setRollNo(111);
		bean.setPhysics(77);
		bean.setChemistry(99);
		bean.setMaths(87);
		bean.setEnglish(87);

		MarksheetModel model = new MarksheetModel();
		model.testAdd(bean);

	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setName("ranu");
		bean.setRollNo(201);
		bean.setId(7);
		MarksheetModel model = new MarksheetModel();
		model.testUpdate(bean);
	}

	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(6);
		MarksheetModel model = new MarksheetModel();
		model.testUpdate(bean);

	}

	public static void testAlter() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.testAlter();

	}

	public static void testSelect() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.testSelect();
	}

}
