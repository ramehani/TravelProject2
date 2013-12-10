package services.reservation;

import hotels.impl.reservation.DetailsRateHolder;
import hotels.pojo.reservation.DetailsInformationSetter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ReservationDetailsContol {
	
	public Map<String,Object> detailHandle(HttpServletRequest req)
	{
		DetailsInformationSetter inforhandle = new DetailsInformationSetter(); 
		
		String fromdate = req.getParameter("cmbCheckInDate");
		String fromMonth = req.getParameter("cmbCheckInMonth");
		String fromYear = req.getParameter("cmbCheckInYear");
		String todate = req.getParameter("cmbCheckOutDate");
		String toMonth = req.getParameter("cmbCheckOutMonth");
		String toYear = req.getParameter("cmbCheckOutYear");
		
		Calendar cld = Calendar.getInstance();
		cld.set(Integer.parseInt(fromYear), Integer.parseInt(fromMonth)-1, Integer.parseInt(fromdate));
		Calendar cldco = Calendar.getInstance();
		cldco.set(Integer.parseInt(toYear), Integer.parseInt(toMonth)-1, Integer.parseInt(todate));
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy (EEE)");
		
		inforhandle.setShowCheckdate(dateformat.format(cld.getTime()));
		inforhandle.setShowCheckoutdate(dateformat.format(cldco.getTime()));
		
		inforhandle.setFromdate(fromdate+"-"+fromMonth+"-"+fromYear);
		inforhandle.setTodate(todate+"-"+toMonth+"-"+toYear);
		inforhandle.setNoOfnights(req.getParameter("noOfNights"));
		inforhandle.setNoOfAdults(req.getParameter("noOfNights"));
		inforhandle.setHotelCode(req.getParameter("hidHotCode"));
		inforhandle.setHotelName(req.getParameter("hotName"));
		inforhandle.setHotelAddress(req.getParameter("hotAddress"));
		inforhandle.setNoofrooms(req.getParameter("cmbNoOfRooms"));
		inforhandle.setBedName(req.getParameter("bedTypeString"));
		inforhandle.setBedcode(req.getParameter("bedTypeCode"));
		inforhandle.setRoomcode(req.getParameter("rooTypeCode"));
		inforhandle.setRoomname(req.getParameter("rooType"));
		inforhandle.setRateplancode(req.getParameter("ratePlanCode"));
		inforhandle.setRateplanname(req.getParameter("rateCode"));
		HashMap<String, Object> rootmap = new HashMap<String, Object>();
		rootmap.put("info", inforhandle);
		
		/*
		 * rates information handler
		 */
		DetailsRateHolder ratez = new DetailsRateHolder();
		rootmap.put("ratez", ratez.rateholder(inforhandle));
		
		
		
		return rootmap;
	}

}
