package in.co.rays.company;

import java.util.Iterator;
import java.util.List;

public class TestCompany {
	
	public static void main(String[] args) throws Exception {
		
	//	add();
		search();
	}

	private static void search() throws Exception {
		
		CompanyBean bean = new CompanyBean();
		bean.setCompId(1);
		CompanyModel model = new CompanyModel();
		List list = model.search(bean);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean = (CompanyBean) it.next();
			System.out.println(bean.getCompId());
			System.out.println(bean.getCompName());
			System.out.println(bean.getPerformnce());
			System.out.println(bean.getStrength());
			System.out.println(bean.getTurnOver());
		}
		
	}

	private static void add() throws Exception {
		
		CompanyBean bean = new CompanyBean();
		
		bean.setCompId(5);
		bean.setCompName("mumbaiIndin");
		bean.setPerformnce("bad");
		bean.setStrength(100);
		bean.setTurnOver("101cr");
		
		CompanyModel model = new CompanyModel();
		model.add(bean);
	}

}
