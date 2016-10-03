package services;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import utils.WebContextUtils;

@Service("liquibase")
public class LiquibaseServcie {

	Logger logger = Logger.getLogger(LiquibaseServcie.class);

	public void initDB() throws SQLException, LiquibaseException {

		String changeLogFilePath = "liquibase.xml";

		/**
		 * 注释部分本是想通过spring mvc 的上下文从 webApplicationContext中获取，但是一直提示报错 Cannot
		 * load JDBC driver class 'org.postgresql.Driver'
		 **/
		// WebApplicationContext webApplicationContext =
		// ContextLoader.getCurrentWebApplicationContext();
		DataSource dataSource = (DataSource) WebContextUtils.getBean("dataSource");
		// DataSource dataSource = (DataSource)
		// webApplicationContext.getBean("dataSource");

		// 所以采用了最古老的的办法读取配置文件

		// String driver = ConfigUtils.getConfigByName("driver");
		// String url = ConfigUtils.getConfigByName("url");
		// String username = ConfigUtils.getConfigByName("username");
		// String password = ConfigUtils.getConfigByName("password");
		//
		// BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName("org.postgresql.Driver");
		// dataSource.setUsername(username);
		// dataSource.setPassword(password);
		// dataSource.setUrl(url);

		if (dataSource == null) {
			logger.error("get datebase error");
		} else {
			DatabaseConnection databaseConnection = new JdbcConnection(dataSource.getConnection());
			Liquibase liquibase = null;
			liquibase = new Liquibase(changeLogFilePath, new ClassLoaderResourceAccessor(), databaseConnection);
			liquibase.update("updateDb");
		}
	}

}
