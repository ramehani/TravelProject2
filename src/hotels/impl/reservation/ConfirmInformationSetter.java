package hotels.impl.reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import etspl.common.jdbc.PoolManager;
import hotels.pojo.reservation.ConfirmInfoHolder;

public class ConfirmInformationSetter {

	public ConfirmInfoHolder getConfirmInformation(HttpServletRequest req,String Schemaname) {

		ConfirmInfoHolder inforhandle = new ConfirmInfoHolder(); 
		
		String[] checkInDate = req.getParameter("checkInDate").split("-");
		String[] checktoDate = req.getParameter("checkOutDate").split("-");
		inforhandle.setShowCheckdate(req.getParameter("ShowcheckInDate"));
		inforhandle.setShowCheckoutdate(req.getParameter("ShowcheckOutDate"));
		inforhandle.setFromdate(checkInDate[2]+"-"+checkInDate[1]+"-"+checkInDate[0]);
		inforhandle.setTodate(checktoDate[2]+"-"+checktoDate[1]+"-"+checktoDate[0]);
		inforhandle.setNoOfnights(req.getParameter("noOfNights"));
		inforhandle.setNoOfAdults(req.getParameter("noOfAdults"));
		inforhandle.setHotelCode(req.getParameter("hidHotCode"));
		inforhandle.setHotelName(req.getParameter("hotName"));
		inforhandle.setHotelAddress(req.getParameter("hotAddress"));
		inforhandle.setNoofrooms(req.getParameter("noOfRooms"));
		inforhandle.setBedName(req.getParameter("bedType"));
		inforhandle.setBedcode(req.getParameter("bedtypecode"));
		inforhandle.setRoomcode(req.getParameter("roomTypeCode"));
		inforhandle.setRoomname(req.getParameter("roomType"));
		inforhandle.setRateplancode(req.getParameter("ratePlanCode"));
		inforhandle.setRateplanname(req.getParameter("rateCode"));
		inforhandle.setRecordno(Integer.parseInt(req.getParameter("recNo")));
		inforhandle.setDiscounttype("NONE");
		inforhandle.setLanguage(req.getParameter("language"));
		inforhandle.setCountry(req.getParameter("country"));
		inforhandle.setHoteltype("INT");
		inforhandle.setBooktype("S");
		inforhandle.setRoomrate(req.getParameter("adultRateBedTyp"));
		inforhandle.setAffcode("ZA");
		inforhandle.setAdltRtByBtyp(req.getParameter("adultRateBedTyp"));
		/*hotel information setting here*/
		
		PoolManager poolconnc = PoolManager.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			con = poolconnc.getConnection("basicpool");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT Address,City,contactname,phoneno,email FROM "+Schemaname+".LKUP_HOTELS L,"+Schemaname+".lkup_hotel_contacts LC WHERE L.HOTEL_CODE='"+inforhandle.getHotelCode()+"'"
					+ "and l.hotel_code = Lc.Hotel_code and contact_type='Y'");
			System.out.println("SELECT Address,City,contactname,phoneno,email FROM "+Schemaname+".LKUP_HOTELS L,"+Schemaname+".lkup_hotel_contacts LC WHERE L.HOTEL_CODE='"+inforhandle.getHotelCode()+"'"
					+ "and l.hotel_code = Lc.Hotel_code and contact_type='Y'");
			if(rs.next())
			{
				inforhandle.setHotelAddress(rs.getString(1));
				inforhandle.setHotelcity(rs.getString(2));
				inforhandle.setHotelmaincontactname(rs.getString(3));
				inforhandle.setHotelemail(rs.getString(5));
				inforhandle.setHotelphone(rs.getString(4));
				
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{rs.close();rs=null;}catch(Exception e){rs=null;}
			try{stmt.close();stmt=null;}catch(Exception e){stmt=null;}
			try{con.close();con=null;}catch(Exception e){con=null;}
		}
		
		/**
		 * 
		 * Hotel Rates setting in here
		 * 
		 */
		
		inforhandle.setTotalpayment(req.getParameter("TotalPayable"));
		inforhandle.setPaynow(req.getParameter("paidAmount"));
		inforhandle.setBalance(req.getParameter("balAmount"));
		
		
		/**
		 * Customer Information Setting here
		 */
		inforhandle.setCtitile(req.getParameter("Res_Sel_Cust_Title"));
		inforhandle.setFname(req.getParameter("Res_txt_FName"));
		inforhandle.setLastname(req.getParameter("Res_txt_LName"));	
		inforhandle.setCphoneno(req.getParameter("Res_txt_Phone"));
		inforhandle.setCemail(req.getParameter("Res_txt_Email"));
		inforhandle.setCaddress(req.getParameter("Res_txt_Address1") + req.getParameter("Res_txt_Address2"));
		inforhandle.setCcity(req.getParameter("Res_txt_City"));
		inforhandle.setCcountry(req.getParameter("res_sel_Country"));
		
		inforhandle.setCcno(req.getParameter("Res_txt_ccNo"));
		inforhandle.setCcname(req.getParameter("Res_txt_CName"));
		inforhandle.setCcexpdt(Integer.parseInt(req.getParameter("cmbExpMonth"))+1+"/"+req.getParameter("cmbExpYear"));
		/**
		 * 
		 */
		return inforhandle;
	}

}
