package utils;

import java.util.ResourceBundle;

public class ConfigUtils {

	public static String getConfigByName(String name) {
		return resourceBundle().getString(name);
	}

	private static ResourceBundle resourceBundle() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		return resourceBundle;
	}

}
