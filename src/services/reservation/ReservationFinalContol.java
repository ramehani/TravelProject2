package services.reservation;

import hotels.impl.reservation.ConfirmFilter;
import hotels.impl.reservation.ConfirmInformationSetter;
import hotels.impl.reservation.ConfirmLogic;
import hotels.pojo.reservation.ConfirmInfoHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import utils.InterlizationManager;
import utils.LoadSystemProperties;

public class ReservationFinalContol {

	public Map<String, Object> detailHandle(HttpServletRequest request) {
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		LoadSystemProperties sysprop = null;
		try {
			sysprop = LoadSystemProperties.getInstance();
			String Schemaname = sysprop.getProperty("SchemaName").toString();
			System.out.println("test 4 chk");
			
			ConfirmInformationSetter confirmsetter = new ConfirmInformationSetter();
			ConfirmInfoHolder info = confirmsetter.getConfirmInformation(request,Schemaname);
			
			InterlizationManager intermanger = InterlizationManager.getInstance();
			ResourceBundle rbundle = intermanger.getBundle("US", "en");
			
			
			ConfirmFilter filters  = new ConfirmFilter();
			if(filters.checkInventory(info))
			{
				retMap.put("error", "outinv");
				retMap.put("errormsg", "Selected Accommodation has Sold out");
			}else{
				ConfirmLogic cf = new ConfirmLogic();
				retMap = cf.getConfirmation(info,Schemaname,sysprop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retMap;
	}

}
