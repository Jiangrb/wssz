package service.configuration;

import java.util.Locale;
import java.util.ResourceBundle;

public class SourceBinderDemo {

	public static void main(String[] args) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("aaaaaaa", Locale.getDefault());
		String a = resourceBundle.getString("aa");
		System.out.println("a==============" + a);
	}

}
