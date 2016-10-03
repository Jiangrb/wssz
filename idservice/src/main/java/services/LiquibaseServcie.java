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

		// 从注入的bean中获取Datasource
		DataSource dataSource = (DataSource) WebContextUtils.getBean("dataSource");
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
