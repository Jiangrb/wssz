package service.guice;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class InjectService {

	@Inject
	@Named("aa")
	private String aa;
	static Properties properties = new Properties();

	public static void init() {
		try {
			InputStream inputStream = new FileInputStream("/config/config.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		init();
		Injector injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				System.out.println("================" + properties);
				Names.bindProperties(binder, properties);
			}
		});
		InjectService injectService = injector.getInstance(InjectService.class);
		System.out.println("aa+======>" + injectService.aa);
	}

}
