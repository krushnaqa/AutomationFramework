package basicUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	public static PropertiesFileReader pfr=new PropertiesFileReader();
public String getDataByKey(String key){
	String data="";
	try {
		FileInputStream frs = new FileInputStream(".//Properties//config.properties");
		Properties prop=new Properties();
		prop.load(frs);
		data=prop.getProperty(key);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
}
}
