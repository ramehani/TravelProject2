package utils;

import etspl.common.Property.SystemProperty;

import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;

public class LoadSystemProperties  extends SystemProperty{
	  private static String fileSeperator=File.separator;	
	  
	  private static String fileName=fileSeperator+"classes"+fileSeperator+"resources"+fileSeperator+"System_p2.properties";
	 
	  
	  private static LoadSystemProperties instance =null;
	  private static Properties prop=null;
	  	
	  private LoadSystemProperties(String fileName) throws Exception{
	  	
	  	prop = new Properties();
	  	this.fileName=fileName;
	  	prop.load(this.getClass ().getResourceAsStream (fileName));
	  }	
	  
	  private LoadSystemProperties() throws Exception{
		  GetWebInfPath gf = new GetWebInfPath();
		  String filePath = gf.getFilePath();
		System.out.println("filePath+this.fileName>>>"+filePath+this.fileName);
	  	prop = new Properties();
	  	prop.load(new FileInputStream(filePath+this.fileName));
//	  	prop.load(this.getClass ().getResourceAsStream (fileName));
	  }		
	  
	  public static LoadSystemProperties getInstance(String fileName) throws Exception{
	  	if(instance==null)
	  		instance=new LoadSystemProperties(fileName);
	  	return instance;	
	  }	
	 
	  public static LoadSystemProperties getInstance() throws Exception{
	  	if(instance==null)
	  		instance=new LoadSystemProperties();
	  	return instance;	
	  }
	  
	  public synchronized Object getProperty(String key){
	   return ((Object) prop.getProperty(key));	
	 }	

}
