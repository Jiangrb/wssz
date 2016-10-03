package liquibase;

import org.junit.Test;

import utils.ConfigUtils;

public class LiquibaseTest {

	@Test
	public void liquibaseTest() {

		System.out.println("simple test");
	}

	@Test
	public void configurationUtilTest() {
		String driver = ConfigUtils.getConfigByName("driver");
		System.out.println("driver======>" + driver);

	}

}
