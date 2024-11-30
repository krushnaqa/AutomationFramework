package basicUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
public static String getDataByKey(String key){
	String data="";
	FileInputStream frs = null ;
	//String path=System.getProperty("user.dir")+"/src/main/resources/property.properties";
	//System.out.println(path);
	try {
		frs = new FileInputStream(".//src//main//resources//property.properties");
		Properties prop=new Properties();
		prop.load(frs);
		data=prop.getProperty(key);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return data;
}
}
