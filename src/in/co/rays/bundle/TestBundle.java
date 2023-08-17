package in.co.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {


			
			ResourceBundle rb= ResourceBundle.getBundle("in.co.rays.bundle.app" , new Locale ("hi"));
			
			System.out.println(rb.getString("greeting"));
			
			

			
		}

	
}
