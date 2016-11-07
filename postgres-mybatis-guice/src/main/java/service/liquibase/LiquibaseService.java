package service.liquibase;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.sql.DataSource;

import com.google.common.collect.Maps;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquibaseService {

	@Inject
	static Injector injector;

	@Inject
	@Named("postgres.address")
	String name;

	public Liquibase getLiquibase(String name, String changeLogFile) {
		DataSource dataSource = injector.getInstance(Key.get(DataSource.class, Names.named(name)));
		Liquibase liquibase;
		try {
			Connection connection = dataSource.getConnection();
			liquibase = new Liquibase(changeLogFile, new ClassLoaderResourceAccessor(), new JdbcConnection(connection));
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return liquibase;
	}

	public static void init() {
		injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault());
				Names.bindProperties(binder, transformToMap(resourceBundle));
			}
		});
	}

	public static void main(String[] args) {
		init();
		LiquibaseService liquibaseService = injector.getInstance(LiquibaseService.class);
		System.out.println(liquibaseService.name);
		Liquibase liquibase = liquibaseService.getLiquibase("root", "/config/liquibase.xml");

		try {
			liquibase.update("prod");
		} catch (LiquibaseException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, String> transformToMap(ResourceBundle resourceBundle) {
		Map<String, String> maps = Maps.toMap(resourceBundle.keySet(), i -> resourceBundle.getString(i));
		return maps;
	}

}
