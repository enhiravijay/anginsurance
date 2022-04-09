package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	public static Properties prop;
	
	public static Properties loadPropertyFile() throws Exception {
		
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\AngularPos\\src\\main\\resources\\configfile\\config.properties");
		prop.load(fi);
		return prop;
		
		
	}
	
	
}
