package utils;

import java.io.File;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

public class InterlizationManager {
	  private static Hashtable	resourceTable=null;  	
	  private static InterlizationManager instance=null;
	  private static ResourceBundle rBundle;
	  static String  fileSeperator=File.separator;
	  protected InterlizationManager(){
	    resourceTable=new Hashtable();	
	  }
	  
	  public static InterlizationManager getInstance(){
	  	if(instance==null)
	  		instance=new InterlizationManager();
	  	return instance;
	  }		  	
	  
	  
	  
	  public static void getBundleutf(String countryCode,String localeCode){  	
	  	String fileSeperator=File.separator;	
	  	String _fileName="/TravelStay/Properties/ResInternationeliZation";
	    if((rBundle=(ResourceBundle)resourceTable.get(countryCode+localeCode))==null){ 	  	
	      Locale currentLocale=new Locale(localeCode,countryCode);  
	      rBundle=
	      ResourceBundle.getBundle(_fileName,currentLocale);
	      resourceTable.put(countryCode+localeCode,rBundle);
		}	 	
	  }
	  
	  public static ResourceBundle getBundle(String countryCode,String localeCode){  	
		  	ResourceBundle rBundle1;
		  	String _fileName="resources.ResourceInterlization";
		    GetWebInfPath gf = new GetWebInfPath();
			String filePath = gf.getFilePath();
		    if((rBundle1=(ResourceBundle)resourceTable.get(countryCode+localeCode))==null){ 	  	
		      Locale currentLocale=new Locale(localeCode,countryCode);  
		      rBundle1=
		      ResourceBundle.getBundle(_fileName,currentLocale);
		      resourceTable.put(countryCode+localeCode,rBundle1);
			}	 	
		    return rBundle1;
		  }
	  
	  public String getString(String key) {	
		  try {
		  return  new String(rBundle.getString(key).getBytes("UTF-8"));
		  }catch (Exception e) {
			  return null;      
		}
	  }
	  
	  public int size(){
	  	return(resourceTable.size());
	  }
}
