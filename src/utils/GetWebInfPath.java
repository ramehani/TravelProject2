package utils;

import java.net.URL;

public class GetWebInfPath {
	 private static final String WEBINF = "WEB-INF";
	public String getFilePath()
	{
		String filePath;
		  URL url = this.getClass ().getResource("GetWebInfPath.class");
		  String className = url.getFile();  
		  filePath = className.substring(0,className.indexOf(WEBINF)+WEBINF.length());
		  return filePath;
	}
}
