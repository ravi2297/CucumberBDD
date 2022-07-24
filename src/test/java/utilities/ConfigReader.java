package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	public ConfigReader() throws IOException 
	{
	
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\sample\\BDDFinalProject\\src\\test\\resources\\config.properties");
		prop.load(fis);
	
	}
	
	public String getBrowser() throws Exception
	{
		
		String value = prop.getProperty("browser");
		
		if (value!=null)
		{
			return value;
		}
		else
		{
			throw new Exception("value is not config in properties file");
		}
		
	}
	
	
	
	
	
}
