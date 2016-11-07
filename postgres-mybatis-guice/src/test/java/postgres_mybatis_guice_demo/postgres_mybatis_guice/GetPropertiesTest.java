package postgres_mybatis_guice_demo.postgres_mybatis_guice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Test;

public class GetPropertiesTest {

	@Test
	public void getPropertiesTest() {
		System.out.println(
				"test1------------->" + ResourceBundle.getBundle("aaaaaaa", Locale.getDefault()).getBaseBundleName());
	}

	@Test
	public void getPropertiesTest2() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(new File("config/aaaaaaa.properties"));
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String aString = properties.getProperty("aa", "没有发现aa值");
		System.out.println("test2-------------===>" + aString);
	}

}
