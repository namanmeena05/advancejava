package in.co.rays.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	public static void main(String[] args) throws Exception {

		//search();
		// add();
		update();

	}

	private static void update() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(1);
		if (bean != null) {
			bean.setFirstName("radhika");
			
			model.update(bean);
		}else {
			System.out.println("not Update");
		}
	}

	private static void add() throws Exception {

		String dob = "1999-10-11";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setFirstName("mohan");
		bean.setLastName("meena");
		bean.setLoginId("annu@gmail.com");
		bean.setPassword("12334445");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("indore");

		UserModel model = new UserModel();
		model.add(bean);

	}

	private static void search() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(1);
		UserModel model = new UserModel();
		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}
}
