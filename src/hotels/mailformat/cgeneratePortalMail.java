package hotels.mailformat;

import hotels.pojo.reservation.ConfirmInfoHolder;

import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class cgeneratePortalMail {

	
	public StringBuffer generatePortalMailErrorDesc(
			ConfirmInfoHolder info, String errorDesc,ResourceBundle __resFirstBundle
			/*ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] __occupancyArr1,
			String[] arrWholeSellerDetails, String errorDesc,
			String supplierItaNo, String supplierHotConfNo*/
			) throws Exception {
		StringBuffer _sbr = new StringBuffer();
		String error="0";
				
		
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		
		try{
			 _sbr.append("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n");
			  _sbr.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
			  _sbr.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
			  _sbr.append("<head>\n");
			  _sbr.append("<title>Untitled Document</title>\n");
			  _sbr.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
			  _sbr.append("</head>\n");
			  _sbr.append("\n");
			  _sbr.append("<body>\n");
			  _sbr.append("<div align=\"center\">\n");
			  _sbr.append("\n");
			  _sbr.append("<p align=\"center\"><font face=\"Verdana, Arial, Helvetica, sans-serif\"><strong><font size=\"+1\">EzyReservetions.com</font></strong>\n");
			  _sbr.append("</p>\n");
			  _sbr.append("<p align=\"center\"><font face=\"Verdana, Arial, Helvetica, sans-serif\"><strong><font size=\"+1\">"+__resFirstBundle.getString("Address1")+"</font></strong><br>\n");
			  _sbr.append("<font size=\"2\">"+__resFirstBundle.getString("Address2")+","+__resFirstBundle.getString("Address3")+"<br>\n");
			  _sbr.append(""+__resFirstBundle.getString("TeleNo")+" "+__resFirstBundle.getString("Fax")+": "+__resFirstBundle.getString("FaxNo")+"</font></font></p>\n");
			  _sbr.append("<div align=\"left\">\n");
			  _sbr.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
			  _sbr.append("<tr>\n");
			  error="1";
			  error="2";
			  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("BookingDate")+" : "+info.getShowCheckdate()+"<b></font></td>\n");
			  _sbr.append("</tr>\n");
			  _sbr.append("</table>\n");
			  
			  
//			  if(info.getHoteltype().equals("INT")){
				  _sbr.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Error Description : "+errorDesc+"</font></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
//			  }
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td colspan='2'><br>\n");
				  _sbr.append("<div align=\"left\">\n");
				  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("hotelInformation")+"</b></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</div><br>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td>\n");
				  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("HotelName")+"</td>\n");
				  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+info.getHotelName()+"</font></td>\n");
				  _sbr.append("</tr>\n");
				  if(info.getHoteltype().equals("INT")){
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
				  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+info.getHotelAddress()+"</font></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+info.getHotelcity()+"</td>\n");
//				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Fax")+" #</td>\n");
//				  _sbr.append("<td width=\"25%\" ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+_reqDetails[49]+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Phone")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+info.getHotelphone()+"</td>\n");
				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Email")+" #</td>\n");
				  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getHotelemail()+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("HotContactPer")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+info.getHotelmaincontactname()+"</td>\n");
//				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("AccomGroup")+"</td>\n");
//				  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+arrWholeSellerDetails[0]+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				  }else if(info.getHoteltype().equals("INV8")){
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
				  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+info.getHotelAddress()+"</font></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+info.getHotelcity()+"</td>\n");
				  _sbr.append("</tr>\n");
				  }else if(info.getHoteltype().equals("INV1")){
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
				  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+info.getHotelAddress()+"</font></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+info.getHotelcity()+"</td>\n");
				  _sbr.append("</tr>\n");
				  }
				  error="5";
				  _sbr.append("</table></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
		          _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td> <br>\n");
				  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td colspan=2 ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("guestInfo")+"</b></font></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table> \n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td>\n");
				  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Name")+"</td>\n");
				  _sbr.append("<td width=\"30%\" colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getFname()+" "+info.getLastname()+"</td>\n");
				  _sbr.append("<td >&nbsp; </td>\n");
				  _sbr.append("<td >&nbsp; </td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</font></td>  \n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCaddress()+"</td>  \n");
		 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Phone")+" #</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCphoneno()+"</td>\n");
		    	  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
		 		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+"&nbsp;</td>  \n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCcity()+"</b></td>  \n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Fax")+" #</td>\n");
				  _sbr.append("<td>&nbsp;:&nbsp; </td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
		 		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Zip")+"&nbsp;</td>  \n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCzip()+"</td>  \n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Email")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCemail()+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td> <br>\n");
				  _sbr.append("<table width=\"20%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("ResInfo")+"</b></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table> \n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td>\n");
				  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CheckInDate")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getShowCheckdate()+"</td>\n");
				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2># "+__resFirstBundle.getString("NoOfNights")+" </td>\n");
				  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getNoOfnights()+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CheckOutDate")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getShowCheckoutdate()+"</td>\n");
				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2># "+__resFirstBundle.getString("NoOfRooms")+" </td>\n");
				  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getNoofrooms()+"</td>\n");
				  _sbr.append("</tr>\n");
				  error="6";
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("BedType")+" </td>\n");
				  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getBedName()+" </td>\n");
		  		  _sbr.append("</tr> \n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2># "+__resFirstBundle.getString("NoOfAdults")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getNoOfAdults()+"</td>\n");
				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2># "+__resFirstBundle.getString("NoOfChildren")+"</td>\n");
				  _sbr.append("<td width=\"20%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; 0</td>\n");
				  _sbr.append("</tr>\n");
				  
				  
				 /* int __i=0;
				  
				  while(__i<__occupancyArr1.length){
				  	_sbr.append("<tr>\n");
				  	_sbr.append("<td width=\"18%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Customer "+(__i+1)+" </td>\n");
				  	_sbr.append(""+__occupancyArr1[__i]+"   \n");		  	
				  	_sbr.append("</tr>\n");
				  	__i+=1;
				  }*/

				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("SpecialRequests")+" </td>\n");
				  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getSpecialrequest()+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>time of arrival</td>\n");
				  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getTimeofarrival()+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Purpose of stay</td>\n");
				  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getPurposeofstay()+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Where did you hear about us</td>\n");
				  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getHowuhear()+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				  
				  _sbr.append("</table></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td ><br>\n");
				  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>Customer Payment Detail</b></td>\n");//__resFirstBundle.getString("PayInfo")
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td>\n");
				  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Cctype")+" </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCctype()+"</td>\n");
				  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Ceon")+" </td>\n");
				  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCcexpdt()+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<tr>\n");
				  
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CCNo")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; XXXX XXXX XXXX "+info.getCcno().substring(info.getCcno().length()-4,info.getCcno().length())+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Chname")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+info.getCcname()+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><br>\n");
				  _sbr.append("<table width=\"20%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("PayInfo")+"</b></td>\n");//
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td>\n");
				  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
				  _sbr.append("<tr>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Currency </td>\n");
				  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+currencyName+" </td>\n");
				  _sbr.append("<td width=\"20%\">&nbsp;</td>\n");
				  _sbr.append("<td width=\"20%\">&nbsp;</td>\n");
				  _sbr.append("</tr><tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Discount Type </td>\n");
				  String discountType="NONE";
				  error="7";
				  if (!info.getDiscounttype().equals("NONE")){
						if (info.getDiscounttype().equals("PRIOR")){
							discountType="Prior to arival discount";
						}else if (info.getDiscounttype().equals("NONUK")){
							discountType="Non UK residence discount";
						}else if (info.getDiscounttype().equals("GROUP")){
							discountType=__resFirstBundle.getString("Group");
						}else if (info.getDiscounttype().equals("STUDENT")){
							discountType="Student discount";
						}else if (info.getDiscounttype().equals("LONGSTAY")){
							discountType="Longstay discount";
						}
					}

				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+discountType+"</td>\n");
				  _sbr.append("</tr>\n");
				  
				    String[] arrAdultRtBedtyp=new String[3];
					String[] arrStudRtBedtyp=new String[3];
					String[] arrbedTypeDisc=new String[3];
					
					int bedTyps=0; 
					if(info.getBooktype().equals("S")){
						bedTyps=1;
					}else{
						bedTyps=2;
					}
					int bedTypscount=0;
					double yourRtRm=0;
					int countval=0;
					StringTokenizer adultRtBedtyp = new StringTokenizer(info.getRoomrate(),"@");
					while(adultRtBedtyp.hasMoreElements()){
						arrAdultRtBedtyp[countval]=adultRtBedtyp.nextElement().toString();	
						if(info.getBooktype().equals("S")){
							break;
						}
						countval+=1;
					}
					adultRtBedtyp=null;
					
					countval=0;
					/*StringTokenizer studRtBedtyp = new StringTokenizer(_reqDetails[81],"@");
					while(studRtBedtyp.hasMoreElements()){
						arrStudRtBedtyp[countval]=studRtBedtyp.nextElement().toString();	
						if(info.getBooktype().equals("S")){
							break;
						}
						countval+=1;
					}
					studRtBedtyp=null;*/
					
					countval=0;
					StringTokenizer bedTypeDisc = new StringTokenizer(info.getBedName()+"|@|","|@|");
					while(bedTypeDisc.hasMoreElements()){
						arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
						countval+=1;
					}
					bedTypeDisc=null;
					
				  String bedType="";
				  String rmNo="";
				  java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Rate per night </td>\n");//"+__resFirstBundle.getString("AveAdultNightRate")+"
				  _sbr.append("<td colspan=\"2\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>\n");
				  while(bedTyps>bedTypscount){//arrbedType
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
//					System.out.println("arrAdultRtBedtyp[bedTypscount] >>"+arrAdultRtBedtyp[bedTypscount]+"<<arrStudRtBedtyp[bedTypscount]).doubleValue()>>"+arrStudRtBedtyp[bedTypscount]);
					yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
//					+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue()
				   	if(bedTyps==1 || bedTypscount==1){
				   	_sbr.append("&nbsp;:&nbsp; "+rmNo+" x "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" per room night \n");
					}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("&nbsp;:&nbsp; "+rmNo+" x "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" per room night <br>\n");	
					}
					bedTypscount+=1;
				 }
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  
				 arrAdultRtBedtyp=null;
				 arrStudRtBedtyp=null;
				 arrbedTypeDisc=null;
				  
				  _sbr.append("<tr>\n");
				  
				  /*_sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Total")+" number "+__resFirstBundle.getString("NoOfNights")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;&nbsp;"+_reqDetails[14]+"</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("SubTotal")+"</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+_rateDetails[_rateDetails.length-1][0]+"</td>\n");
				  _sbr.append("</tr>\n");*/
				NumberFormat nf = NumberFormat.getInstance();
		          nf.setMinimumFractionDigits(2); 
		          nf.setMaximumFractionDigits(2);
		            
				/*if(info.getHoteltype().equals("INT")){
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Tax Recovery & Service Fee</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+_reqDetails[102]+"</td>\n");
				  _sbr.append("</tr>\n");
				}else{
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Tax Recovery & Service Fee</td>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(Double.parseDouble(_reqDetails[69])-Double.parseDouble(_reqDetails[142]))+"</td>\n");
				  _sbr.append("</tr>\n");
				}*/		  
				  error="8";
				  
				  _sbr.append("<tr>\n");
				  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("TotalPayable")+"</td>\n");//
				  try{
				   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format((new Double(info.getTotalpayment().toString()).doubleValue()))+"</td>\n");
				  }catch(Exception e){
				   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+info.getTotalpayment()+"</td>\n");		  	
				  }
				            	
				            	
				  _sbr.append("</tr>\n");
				  
				  
				  if(info.getHoteltype().equals("INT")){
					  _sbr.append("<tr>\n");
					  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Total Paid</td>\n");
					  try{
					    _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(new Double(info.getPaynow().toString()).doubleValue())+"</td>\n");
			          }catch(Exception e){
			          	_sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+info.getPaynow()+"</td>\n");
			          }
					  
					  
					  _sbr.append("</tr>\n");
					  
					  if( info.getDepositcharge()!=null && info.getDepositcharge().equals("false")){
					  _sbr.append("<tr>\n");
					  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" colspan=2 size=2><b>DEPOSIT NOT CHARGED ONLINE</b></td>\n");
					  _sbr.append("</tr>\n");
					  }
					  
					  _sbr.append("<tr>\n");
					  _sbr.append("<td>&nbsp;</td>\n");
					  _sbr.append("<td>&nbsp;</td>\n");
					  _sbr.append("</tr>\n");
					  
					  
					  _sbr.append("<tr>\n");
					  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Balance to be paid By Customer</td>\n");
					  try{
					   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(new Double(info.getBalance().toString()).doubleValue())+"</td>\n");
			          }catch(Exception e){
					   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+info.getBalance()+"</td>\n");          	
			          }
					  _sbr.append("</tr>\n");
				  }
				  _sbr.append("</table></td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  

				  _sbr.append("</table>\n");
				  _sbr.append("</td>\n");
				  _sbr.append("</tr>\n");
				  _sbr.append("</table>\n");  
				  
				  
				  
				  
			  _sbr.append("</body>\n");
			  _sbr.append("</html>\n");
		}catch(Exception err){
			err.printStackTrace();
			throw new Exception("Error at generating Portal Mail : at  "+err.toString()+"==="+error);
		}  
		
		return _sbr;
	}	
	
	public StringBuffer generatePortalMailNetAce(
			ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] __occupancyArr1,
			String[] arrWholeSellerDetails, String supplierItaNo,
			String supplierHotConfNo, String[] afftParam, String Site,
			String Source, ResultSet rs,ConfirmInfoHolder info) throws Exception {
		StringBuffer _sbr = new StringBuffer();
		String resDate="";
		
//		System.out.println("generatePortalMailNetAce");
		
	
		//writeToLogMail("generating Portal Mail>>>>Start","********************************************");
		
		String cusName="";
		String cusCountry="";
		String cusEmail="";
		String cusPhn="";
		String cusAdd="";
		String cusCity="";
		String cusState="";
		String cusZip="";
		
		String DiscTyp="";
		String afftCode="";
		String bookNo  ="";
		String supl	="INT";
		String wholeId ="";
		
		String hotName ="";
		String hotAdd  ="";
		String hotCity ="";
		String hotZip  ="";
		String hotFax  ="";
		String hotPhn  ="";
		String hotEmail  ="";
		String hotContper="";
		
		String cctype="";
		String ccexp="";
		String ccno="";
		String ccname="";
		
		String noRooms="";
		String moreInfo  ="";
		String multbook ="";
		String bedTydesc ="";// if multiple format is - bed1|@|bed2
		String chkInDate ="";
		String chkOutdate ="";
		String noNight ="";
		String mealPlan ="";
		String radsBdTyp ="";	
		int noPeople =0;
		String noChild="";
		String noStud="";
		String spcReq ="";
		String timeArr="";
		String purposeSty="";
		String hearAbt="";
		String adltRtByBtyp=""; // if multiple format is - 78@79
		String stdRtByBtyp=""; // if multiple format is - 78@79
		String RadsNightRate="";
		String depChgonline="";
		double subTot=0;
		double totCharge=0;
		double bookFee=0;
		double radsBookFee=0;
		double totPay=0;
		double deposit=0;
		double balance=0;
		String hotcontract="";
		String x="";
		String title = "";
		String roomType="";
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		String roomTypeEn		="";
		String langCode = "en";
		String language = "English";
		
	//	System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		
		try{
		if(Source.equals("RES")){
			try{
				supl	=info.getHoteltype().toString();
			}catch(Exception e){}
			
			if(Site.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
			}else if(Site.equals("TravelStay")){
				resDate=_reqDetails[108].toString();
				currencyName 	=_reqDetails[110].toString();
				curr_htmlcode 	=_reqDetails[111].toString();
				curr_code 		=_reqDetails[112].toString();
				curr_symbol		=_reqDetails[113].toString();
			}
			
			try{
		  		  langCode = _reqDetails[15];
		  		 
		  	}catch(Exception e){
		  			e.printStackTrace();
		  	}
						
			cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
			cusCountry=""+_reqDetails[48]+"";
			cusEmail=""+_reqDetails[28]+"";
			cusPhn=""+_reqDetails[26]+"";
			cusAdd=""+info.getCaddress()+"";
			cusCity=""+info.getCcity()+"";
			cusState=""+_reqDetails[32]+"";
			cusZip=""+info.getCzip()+"";
			
			DiscTyp=""+info.getDiscounttype()+"";
			afftCode=_reqDetails[64].toString();	
			bookNo  =_reqDetails[51].toString();
			
			wholeId =_reqDetails[95].toString();
			
			hotName =_reqDetails[1].toString();
			hotAdd  =info.getHotelAddress().toString();
			hotCity =info.getHotelcity().toString();
			hotZip  =_reqDetails[50].toString();
			hotFax  =_reqDetails[49].toString();
			hotPhn  =info.getHotelphone().toString();
			hotEmail  =info.getHotelemail().toString();
			hotContper=info.getHotelmaincontactname().toString();
			
			cctype=_reqDetails[36];
			ccexp=""+(Integer.parseInt(_reqDetails[39]))+"/"+_reqDetails[40]+"";
			ccno=""+_reqDetails[38].substring(_reqDetails[38].length()-4,_reqDetails[38].length())+"";
			ccname=_reqDetails[37];
			
			noRooms=_reqDetails[10].toString();
			moreInfo  =_reqDetails[92].toString();
			multbook =info.getBooktype().toString();
			bedTydesc =info.getBedName().toString();// if multiple format is - bed1|@|bed2
			chkInDate =_reqDetails[45].toString();
			chkOutdate =_reqDetails[46].toString();
			noNight =_reqDetails[14].toString();
			mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
			radsBdTyp =_reqDetails[61].replace ('`',',');			
			noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
			noChild=_reqDetails[12];
			noStud=_reqDetails[90];
			spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			timeArr=info.getTimeofarrival().toString();
			purposeSty=info.getPurposeofstay().toString();
			hearAbt=info.getHowuhear().toString();
			adltRtByBtyp=info.getRoomrate().toString(); // if multiple format is - 78@79
			stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79]
			roomType=_reqDetails[4].toString();
			roomTypeEn=_reqDetails[3].toString();
			
			
//			System.out.println("roomTypeEn"+roomTypeEn);
			
			try{
				
			//RadsNightRate=_reqDetails[129].substring(0,_reqDetails[129].lastIndexOf("|")-1);
			RadsNightRate=_reqDetails[129].replace('|',',');
			RadsNightRate=RadsNightRate.substring(0,RadsNightRate.lastIndexOf(",")-1);
			}catch(Exception e){}
			totCharge=(Double.parseDouble(_rateDetails[_rateDetails.length-1][4])-Double.parseDouble(_reqDetails[102]));
			bookFee=Double.parseDouble(_reqDetails[102]);
			try{
			radsBookFee=Double.parseDouble(_reqDetails[69])-Double.parseDouble(_reqDetails[142]);
			}catch(Exception e){}
			subTot=Double.parseDouble(_rateDetails[_rateDetails.length-1][0]);
			totPay=Double.parseDouble(_rateDetails[_rateDetails.length-1][4]);
			deposit=Double.parseDouble(_reqDetails[69]);
			balance=Double.parseDouble(_reqDetails[71]);
			depChgonline=info.getDepositcharge();
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			title=_reqDetails[22].toString();
		}else{
			//PR_SECURE_CC_REPORT
			langCode = rs.getString(100);
			hotcontract=rs.getString(28);
			x="1";
			try{
				supl	=rs.getString(66);
			}catch(Exception e){}
			
			x="2 ="+Site;
			if(Site.equals("LondonHotelSavings")){
				resDate=rs.getString(1);
			}else if(Site.equals("LondonHotelSite")){
				resDate=rs.getString(1);
			}else if(Site.equals("TravelStay")){
				resDate=rs.getString(1);
			}
			
			currencyName 	=rs.getString("currencyName");
			curr_htmlcode 	=rs.getString("curr_htmlcode");
			curr_code 		=rs.getString("curr_code");
			curr_symbol		=rs.getString("curr_symbol");
			
			x="3";
			cusName=rs.getString(82);
			x="4";
			cusCountry=rs.getString(46);
			x="5";
			cusEmail=rs.getString(14);
			x="6";
			cusPhn=rs.getString(10);
			x="7";
			cusAdd=rs.getString(9);
			x="8";
			cusCity=rs.getString(11);
			x="9";
			cusState=rs.getString(83);
			x="10";
			cusZip=rs.getString(84);
			x="11";
			
			DiscTyp=rs.getString(47);
			x="12";
			afftCode=rs.getString(71);
			x="13";	
			bookNo  =rs.getString(18);
			x="14";	
			
			wholeId =rs.getString(77);	
			x="15";
			
			hotName =rs.getString(2);
			x="16";	
			hotAdd  =rs.getString(53);
			x="17";	
			hotCity =rs.getString(3);
			x="18";	
			hotZip  =rs.getString(31);	
			x="19";
			title=rs.getString(90);
			
			StringTokenizer telfax  = new StringTokenizer(rs.getString(35)+":",":");
			x="20";
			
			while(telfax.hasMoreElements()){
				x="21";
				try{	hotPhn  	=telfax.nextToken();}catch(Exception e){hotPhn="";}
				try{	hotFax		=telfax.nextToken();}catch(Exception e){hotFax="";}
				try{	hotEmail	=telfax.nextToken();}catch(Exception e){hotEmail="";}
				x="22";
				try{	hotContper	=telfax.nextToken();}catch(Exception e){hotContper="";}
				x="23";
				
			}
			
			x="24";
			cctype=rs.getString(23);	
			x="25";
			ccexp=rs.getString(24);
			x="26";
			ccno=(rs.getString(25)).substring(rs.getString(25).length()-4,rs.getString(25).length());
			x="27";
			ccname=rs.getString(26);
			
			x="28";
			noRooms=rs.getString(70);
			x="29";
			moreInfo  =rs.getString(85);
			x="30";
			multbook =rs.getString(78);
			x="31";
			bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
			x="32";
			chkInDate =rs.getString(4);
			x="33";
			chkOutdate =rs.getString(32);
			x="34";
			noNight =rs.getString(5);
			x="35";
			
			if(supl.equals("INT")){ 
				try{
					mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
					mealPlan =rs.getString(44);	
				}
			}else{
					mealPlan =rs.getString(91);	
			}	
				
			x="36";
			
			if(supl.equals("INT")){
			radsBdTyp =rs.getString(89);
			}else{
			radsBdTyp =rs.getString(69);
			}
			x="37";
			noPeople =rs.getInt(17);
			x="38";
			noChild=rs.getString(38);
			x="39";
			noStud=rs.getString(86);
			x="40";
			spcReq = rs.getString(6);
			x="41";
			timeArr=rs.getString(63);
			x="42";
			purposeSty=rs.getString(87);
			x="43";
			hearAbt=rs.getString(88);
			x="44";
			adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
			x="45";
			stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
			x="46";
			
				
			try{
				
			RadsNightRate=rs.getString(64);
			x="47";
			}catch(Exception e){}
			x="48";
			totCharge=rs.getDouble(62);
			x="49";
			bookFee=rs.getDouble(55);
			x="50";
			try{
			x="51";
			radsBookFee=rs.getDouble(55);
			x="52";
			}catch(Exception e){}
			x="53";
			subTot=rs.getDouble(29);
			x="54";
			totPay=rs.getDouble(62);
			x="55";
			deposit=rs.getDouble(50);
			x="56";
			balance=rs.getDouble(81);
			x="57";
			depChgonline=null;
			x="58";
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			roomType=rs.getString(93);
			x="59";		
		}
		x="60";
		
//		System.out.println("cccccccccccccccccccccccccccccccccc");
			if (langCode.equals("en")){
			language = "English";
			
			}
			//-------------------------------- PL / DE/ FR/ IT---------
			else if (langCode.equals("pl"))
			{
				language = "Polski";	
			}
			else if (langCode.equals("fr"))
			{
				language = "Francais";	
			}
			else if (langCode.equals("it"))
			{
				language = "Italiano";	
			}
			else if (langCode.equals("de"))
			{
				language = "Deutsch";	
			//------------------------------------------
			}else{
				language = "Espanol";	
			}
		
		
		
		  _sbr.append("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n");
		  _sbr.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		  _sbr.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		  _sbr.append("<head>\n");
		  _sbr.append("<title>Untitled Document</title>\n");
		  _sbr.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
		  _sbr.append("</head>\n");
		  _sbr.append("\n");
		  _sbr.append("<body>\n");
		  _sbr.append("<form name=form1>\n");
		  _sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  _sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  _sbr.append("</form>\n");
		  _sbr.append("<div align=\"center\">\n");
		  _sbr.append("\n");
		  _sbr.append("<p align=\"center\"><font face=\"Verdana, Arial, Helvetica, sans-serif\"><strong><font size=\"+1\">"+Site+" "+language+"</font></strong>\n");
		  _sbr.append("</p>\n");
  
		  _sbr.append("<p align=\"center\">\n");//<font face=\"Verdana, Arial, Helvetica, sans-serif\"><strong><font size=\"+1\">"+__resFirstBundle.getString("Address1")+"</font></strong><br>
		  _sbr.append("<font size=\"2\">"+__resFirstBundle.getString("Address2")+","+__resFirstBundle.getString("Address3")+"<br>\n");
		  _sbr.append(""+__resFirstBundle.getString("TeleNo")+" "+__resFirstBundle.getString("Fax")+": "+__resFirstBundle.getString("FaxNo")+"</font></font></p>\n");
		  _sbr.append("<div align=\"left\">\n");
		  _sbr.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
	
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("BookingDate")+" : "+resDate+"<b></font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><b><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("BookingNo")+" : "+bookNo+"</b></font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</div><br>\n");
		  _sbr.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  if(!supl.equals("INT")){
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td colspan=2 ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>Supplier Information</b></font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table> \n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Suplier Name</td>\n");
		  String supName="";
		  if(supl.equals("INV8")){
		  	supName="HRN Hotels";		  	
		  _sbr.append("<td width=\"30%\" colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supName+"</td>\n");
		  _sbr.append("<td >&nbsp; </td>\n");
		  _sbr.append("<td >&nbsp; </td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Supplier  Itinerary #</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supplierItaNo+"</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Refernce #</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supplierHotConfNo+"</td>\n");
    	  _sbr.append("</tr>\n");
    	  
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Contact Name</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; Customer Care</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Phone</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; 08000 32 66 96</td>\n");
    	  _sbr.append("</tr>\n");
    	  
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Fax</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; 00 33 1710 03334</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Email</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; affiliatesupport@hotels.com</td>\n");
    	  _sbr.append("</tr>\n");

		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		  }else if(supl.equals("INV1")){
		  	supName="CNG Hotels";
		  	
		  _sbr.append("<td width=\"30%\" colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supName+"</td>\n");
		  _sbr.append("<td >&nbsp; </td>\n");
		  _sbr.append("<td >&nbsp; </td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Supplier  Itinerary #</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supplierItaNo+"</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Refernce #</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+supplierHotConfNo+"</td>\n");
    	  _sbr.append("</tr>\n");
    	  
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Contact Name</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; Eddie Scully</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Phone</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; 00 353 644 0307</td>\n");
    	  _sbr.append("</tr>\n");
    	  
		  _sbr.append("<tr>\n"); 
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Fax</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; 00 353 644 0155</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Email</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; escully@cnghotels.com</td>\n");
    	  _sbr.append("</tr>\n");

		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  }
		}
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td colspan='2'><br>\n");
		  _sbr.append("<div align=\"left\">\n");
		  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("hotelInformation")+"</b></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</div><br>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
	 
		 String wholesaler = "";
 		
 		 if(supl.equals("INT")){ 		 
 		 	if(arrWholeSellerDetails[0].equals("-")||arrWholeSellerDetails[0].equals("")){
 		 		wholesaler = "TravelStay";
 		 	}else{
 		 		wholesaler = arrWholeSellerDetails[0];
 		 	} 
 		 	
 			_sbr.append("<tr>\n");
		  	_sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("HotelName")+" </td>\n");
		  	_sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotName+"</td>\n");
		    _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Supplier</td>\n");
		    _sbr.append("<td width=\"25%\" ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+wholesaler+"</td>\n");		  
		    _sbr.append("</tr>\n");
		 }else{
		   _sbr.append("<tr>\n");
 		   _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("HotelName")+"</td>\n");
   		   _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+hotName+"</font></td>\n");
 		   _sbr.append("</tr>\n");
		 }
		
		  if(supl.equals("INT")){
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
		  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+hotAdd+"</font></td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotCity+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Fax")+" No.</td>\n");
		  _sbr.append("<td width=\"25%\" ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+hotFax+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Phone")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotPhn+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Email")+"</td>\n");
		  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+hotEmail+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("HotContactPer")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotContper+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("AccomGroup")+"</td>\n");
		  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+arrWholeSellerDetails[0]+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  }else if(supl.equals("INV8")){
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
		  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+hotAdd+"</font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotCity+"</td>\n");
		  _sbr.append("</tr>\n");
		  }else if(supl.equals("INV1")){
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</td>\n");
		  _sbr.append("<td colspan=\"3\">&nbsp;:&nbsp;<font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+hotAdd+"</font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+" </td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;  "+hotCity+"</td>\n");
		  _sbr.append("</tr>\n");
		  }
		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
          _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td> <br>\n");
		  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td colspan=2 ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("guestInfo")+"</b></font></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table> \n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Name")+"</td>\n");
		  _sbr.append("<td width=\"30%\" ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;"+title+" "+cusName+"</td>\n");
		  _sbr.append("<td ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Country</td>\n");
		  _sbr.append("<td ><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusCountry+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Address")+"</font></td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusAdd+"</td>  \n");
 		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Phone")+" No.</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusPhn+"</td>\n");
    	  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
 		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("City")+"&nbsp;</td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusCity+"</b></td>  \n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Fax")+" #</td>\n");
		  _sbr.append("<td>&nbsp;:&nbsp; </td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
 		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("State")+" / "+__resFirstBundle.getString("Zip")+"&nbsp;</td>  \n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusState+" / "+cusZip+"</td>  \n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Email")+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cusEmail+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td> <br>\n");
		  _sbr.append("<table width=\"20%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("ResInfo")+"</b></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table> \n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CheckInDate")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+chkInDate+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>No. "+__resFirstBundle.getString("NoOfNights")+" </td>\n");
		  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+noNight+"</td>\n");
		 
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CheckOutDate")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+chkOutdate+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>No. "+__resFirstBundle.getString("NoOfRooms")+" </td>\n");
		  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+noRooms+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Room Description</td>\n");
 		  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2> \n");
	
		
		    String[] arrAdultRtBedtyp1=new String[3];
			String[] arrStudRtBedtyp1=new String[3];
			String[] arrbedTypeDisc1=new String[3];
	
		if(supl.equals("INT")){	
			
			int bedTyps1=0; 
			if(multbook.equals("S")){
				bedTyps1=1;
			}else{
				bedTyps1=2;
			}
			
			int bedTypscount1=0;
			
			int countval1=0;
			StringTokenizer adultRtBedtyp1 = new StringTokenizer(adltRtByBtyp,"@");
			while(adultRtBedtyp1.hasMoreElements()){
				arrAdultRtBedtyp1[countval1]=adultRtBedtyp1.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval1+=1;
			}
			adultRtBedtyp1=null;
			
			countval1=0;
			StringTokenizer studRtBedtyp1 = new StringTokenizer(stdRtByBtyp,"@");
			while(studRtBedtyp1.hasMoreElements()){
				arrStudRtBedtyp1[countval1]=studRtBedtyp1.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval1+=1;
			}
			studRtBedtyp1=null;
			
			countval1=0;
			StringTokenizer bedTypeDisc1 = null;
			
			if(Source.equals("RES")){
					bedTypeDisc1 = new StringTokenizer(bedTydesc+"|@|","|@|");
			}else{
					bedTypeDisc1 = new StringTokenizer(bedTydesc+"/","/");
			}
				
			while(bedTypeDisc1.hasMoreElements()){
				arrbedTypeDisc1[countval1]=bedTypeDisc1.nextElement().toString();
				countval1+=1;
			}
			
			bedTypeDisc1=null;
			
			
		  String bedType1="";
		  String rmNo1="";

		  
		  while(bedTyps1>bedTypscount1){//arrbedType
			rmNo1 = arrbedTypeDisc1[bedTypscount1].substring(0,arrbedTypeDisc1[bedTypscount1].trim().indexOf(" "));
			bedType1 = arrbedTypeDisc1[bedTypscount1].substring(arrbedTypeDisc1[bedTypscount1].trim().indexOf(" "),arrbedTypeDisc1[bedTypscount1].length());

		   	if(bedTyps1==1 || bedTypscount1==1){
		   	_sbr.append("&nbsp;:&nbsp; "+rmNo1+" x "+roomType+" - "+bedType1+" \n");
			}else if(bedTyps1==2 && bedTypscount1==0){
			_sbr.append("&nbsp;:&nbsp; "+rmNo1+" x "+roomType+" - "+bedType1+"  <br>\n");	
			}
			bedTypscount1+=1;

		}	

  	}else{
  			_sbr.append("&nbsp;:&nbsp; "+radsBdTyp+" \n");
  	}
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		 arrAdultRtBedtyp1=null;
		 arrStudRtBedtyp1=null; 
		 arrbedTypeDisc1=null;

/////////////////////////////////////////////////////////////////////////////////
  		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Meal Plan</td>\n");
		  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+mealPlan+" </td>\n");
  		  _sbr.append("</tr> \n");
  		  
		  //_sbr.append(""+__resFirstBundle.getString("BedType")+" "+(_ii+1)+" : "+arrbedTypeDisc[_ii]+" <br>  \n");
		  //_ii+=1;
		  //}		  
//System.out.println("1-----------------------1");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>No. "+__resFirstBundle.getString("NoOfAdults")+"</td>\n");
		  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+noPeople+"</td>\n");
//		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>No "+__resFirstBundle.getString("NoOfChildren")+"</td>\n");
//		  _sbr.append("<td width=\"20%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+noChild+"</td>\n");
		  _sbr.append("</tr>\n");
		  
//		  _sbr.append("<tr>\n");
//		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>No. of Students</td>\n");
//		  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+noStud+"</td>\n");
//		  _sbr.append("</tr>\n");
		  int __i=0;
		  while(__i<__occupancyArr1.length){
		  	_sbr.append("<tr>\n");
		  	_sbr.append("<td width=\"18%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Customer "+(__i+1)+" </td>\n");
		  	if(__occupancyArr1[__i] != null){ //____AMILA TSTAY-517____
		  	_sbr.append(""+__occupancyArr1[__i]+"   \n");
		  	}else{
		  	_sbr.append("<td><font face=\"Courier New\" size=2>&nbsp;:&nbsp;-</font></font></td> \n");	
		  	}
		  	_sbr.append("</tr>\n");
		  	__i+=1;
		  }

		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("SpecialRequests")+" </td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+spcReq+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>time of arrival</td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+timeArr+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Purpose of stay</td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+purposeSty+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Where did you hear about us</td>\n");
		  _sbr.append("<td colspan=\"3\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+hearAbt+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td ><br>\n");
		  _sbr.append("<table width=\"25%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td colspan=3><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>Customer Payment Detail</b></td>\n");//__resFirstBundle.getString("PayInfo")
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Cctype")+" </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+cctype+"</td>\n");
		  _sbr.append("<td width=\"15%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Ceon")+" </td>\n");
		  _sbr.append("<td width=\"25%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+ccexp+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("CCNo")+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; XXXX XXXX XXXX "+ccno+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Chname")+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+ccname+"</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		  
//		  System.out.println("1-----------------------2");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><br>\n");
		  _sbr.append("<table width=\"20%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=left>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2><b>"+__resFirstBundle.getString("PayInfo")+"</b></td>\n");//
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td>\n");
		  _sbr.append("<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
		  _sbr.append("<tr>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Currency </td>\n");
		  _sbr.append("<td width=\"30%\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+currencyName+" </td>\n");
		  _sbr.append("<td width=\"20%\">&nbsp;</td>\n");
		  _sbr.append("<td width=\"20%\">&nbsp;</td>\n");
		  _sbr.append("</tr><tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Discount Type </td>\n");
		 
		  String discountType="NONE";
		  
		  if (!DiscTyp.equals("NONE")){
				if (DiscTyp.equals("PRIOR")){
					discountType="Prior to arival discount";
				}else if (DiscTyp.equals("NONUK")){
					discountType="Non UK residence discount";
				}else if (DiscTyp.equals("GROUP")){
					discountType=__resFirstBundle.getString("Group");
				}else if (DiscTyp.equals("STUDENT")){
					discountType="Student discount";
				}else if (DiscTyp.equals("LONGSTAY")){
					discountType="Longstay discount";
				}
			}

		  
//		  System.out.println("1-----------------------3");
		  
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+discountType+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		    String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			//mywritetoFile("generatePortalMailNetAce  CAL");
			
			int bedTyps=0; 
			if(multbook.equals("S")){
				bedTyps=1;
			}else{
				bedTyps=2;
			}
			
			int bedTypscount=0;
			double yourRtRm=0;
			
			int countval=0;
			StringTokenizer adultRtBedtyp = new StringTokenizer(adltRtByBtyp,"@");
			while(adultRtBedtyp.hasMoreElements()){
				arrAdultRtBedtyp[countval]=adultRtBedtyp.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval+=1;
			}
			adultRtBedtyp=null;
			
			countval=0;
			StringTokenizer studRtBedtyp = new StringTokenizer(stdRtByBtyp,"@");
			while(studRtBedtyp.hasMoreElements()){
				arrStudRtBedtyp[countval]=studRtBedtyp.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval+=1;
			}
			studRtBedtyp=null;
			
			countval=0;
			StringTokenizer bedTypeDisc = null;
			
			if(Source.equals("RES")){
					bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
			}else{
					bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
			}
				
			while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
			}
			bedTypeDisc=null;
			
		  String bedType="";
		  String rmNo="";
		  java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Rate per night </td>\n");//"+__resFirstBundle.getString("AveAdultNightRate")+"
		  _sbr.append("<td colspan=\"2\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>\n");

		  
//		  System.out.println("1-----------------------4");
		  
		  while(bedTyps>bedTypscount){//arrbedType
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
		
			if(supl.equals("INT")){
			yourRtRm=((Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue());
			}else{
			yourRtRm=((Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue())/Double.valueOf(noNight).doubleValue();
			}

			
		
			
			
		   	if(supl.equals("INT")){
		   		if(bedTyps==1 || bedTypscount==1){
		   		_sbr.append("&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" \n");
				}else if(bedTyps==2 && bedTypscount==0){
				_sbr.append("&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" <br>\n");	
				}	
			}else{
				_sbr.append("&nbsp;:&nbsp; "+radsBdTyp+" "+curr_code+" "+__formater.format(yourRtRm)+" <br>\n");	
			}	
			bedTypscount+=1;	
		 }
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		 arrAdultRtBedtyp=null;
		 arrStudRtBedtyp=null; 
		 arrbedTypeDisc=null;
		 
		 
//		 System.out.println("1-----------------------5");
		  
		  _sbr.append("<tr>\n");
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("Total")+" number "+__resFirstBundle.getString("NoOfNights")+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp;&nbsp;"+noNight+"</td>\n");
		  _sbr.append("</tr>\n");
		  
		//double tax = Double.parseDouble(_rateDetails[_rateDetails.length-1][1])+Double.parseDouble(_rateDetails[_rateDetails.length-1][2])+Double.parseDouble(_rateDetails[_rateDetails.length-1][3])+Double.parseDouble(_rateDetails[_rateDetails.length-1][5]);
		//java.text.NumberFormat nf= java.text.NumberFormat.getInstance();
		//nf.setMaximumFractionDigits(0); 
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("SubTotal")+"</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+subTot+"</td>\n");
		  _sbr.append("</tr>\n");
		NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumFractionDigits(2); 
          nf.setMaximumFractionDigits(2);
            
		if(supl.equals("INT")){
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Tax Recovery & Service Fee</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+bookFee+"</td>\n");
		  _sbr.append("</tr>\n");
		}else{
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Tax Recovery & Service Fee</td>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(radsBookFee)+"</td>\n");
		  _sbr.append("</tr>\n");
		}		  
		  
		  
		  _sbr.append("<tr>\n");
		  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>"+__resFirstBundle.getString("TotalPayable")+"</td>\n");//
		  try{
		   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(totPay)+"</td>\n");
		  }catch(Exception e){
		   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+totPay+"</td>\n");		  	
		  }
		            	
		            	
		  _sbr.append("</tr>\n");
//		  System.out.println("1-----------------------6");
		  
		  if(supl.equals("INT")){
			  _sbr.append("<tr>\n");
			  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Total Paid</td>\n");
			  try{
			    _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(deposit)+"</td>\n");
	          }catch(Exception e){
	          	_sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+deposit+"</td>\n");
	          }
			  
			  
			  _sbr.append("</tr>\n");
			  
			  if( depChgonline!=null && depChgonline.equals("false")){
			  _sbr.append("<tr>\n");
			  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" colspan=2 size=2><b>DEPOSIT NOT CHARGED ONLINE</b></td>\n");
			  _sbr.append("</tr>\n");
			  }
			  
			  _sbr.append("<tr>\n");
			  _sbr.append("<td>&nbsp;</td>\n");
			  _sbr.append("<td>&nbsp;</td>\n");
			  _sbr.append("</tr>\n");
			  
			  
			  _sbr.append("<tr>\n");
			  _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>Balance to be paid By Customer</td>\n");
			  try{
			   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+nf.format(balance)+"</td>\n");
	          }catch(Exception e){
			   _sbr.append("<td><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=2>&nbsp;:&nbsp; "+curr_code+" "+balance+"</td>\n");          	
	          }
			  _sbr.append("</tr>\n");
		  }
		  
		  _sbr.append("</table></td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  
		  _sbr.append("</table>\n");
		  _sbr.append("</td>\n");
		  _sbr.append("</tr>\n");
		  _sbr.append("</table>\n");
		  _sbr.append("</body>\n");
		  _sbr.append("</html>\n");
			
        }catch(Exception err){
        	System.out.println("1-----------------------err"+err.toString());
		
        	throw new Exception("Error at generating Portal Mail : at=X="+x+" "+err.toString());
		
        }  
       
        return _sbr;
	}

	public StringBuffer generatePortalMailNetFax(
			ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] __occupancyArr1,
			String[] arrWholeSellerDetails, String supplierItaNo,
			String supplierHotConfNo, String[] afftParam, String Site,
			String Source, ResultSet rs,ConfirmInfoHolder info) throws Exception {
		StringBuffer _sbr = new StringBuffer();
		String resDate="";
		
		String cusName="";
		String cusCountry="";
		String cusEmail="";
		String cusPhn="";
		String cusAdd="";
		String cusCity="";
		String cusState="";
		String cusZip="";
		
		String DiscTyp="";
		String afftCode="";
		String bookNo  ="";
		String supl	="INT";
		String wholeId ="";
		
		String hotName ="";
		String hotAdd  ="";
		String hotCity ="";
		String hotZip  ="";
		String hotFax  ="";
		String hotPhn  ="";
		String hotEmail  ="";
		String hotContper="";
		
		String cctype="";
		String ccexp="";
		String ccno="";
		String ccname="";
		
		String noRooms="";
		String moreInfo  ="";
		String multbook ="";
		String bedTydesc ="";// if multiple format is - bed1|@|bed2
		String chkInDate ="";
		String chkOutdate ="";
		String noNight ="";
		String mealPlan ="";
		String radsBdTyp ="";	
		int noPeople =0;
		String noChild="";
		String noStud="";
		String spcReq ="";
		String timeArr="";
		String purposeSty="";
		String hearAbt="";
		String adltRtByBtyp=""; // if multiple format is - 78@79
		String stdRtByBtyp=""; // if multiple format is - 78@79
		String RadsNightRate="";
		String depChgonline="";
		double subTot=0;
		double totCharge=0;
		double bookFee=0;
		double radsBookFee=0;
		double totPay=0;
		double deposit=0;
		double balance=0;
		String hotcontract="";
		String x="";
		String title = "";
		String roomType="";
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		
		try{
		if(Source.equals("RES")){
			try{
				supl	=info.getHoteltype().toString();
			}catch(Exception e){}
			
			if(Site.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
			}else if(Site.equals("TravelStay")){
				resDate			=_reqDetails[108].toString();
				currencyName 	=_reqDetails[110].toString();
				curr_htmlcode 	=_reqDetails[111].toString();
				curr_code 		=_reqDetails[112].toString();
				curr_symbol		=_reqDetails[113].toString();

			}
			
			

			
			cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
			cusCountry=""+_reqDetails[48]+"";
			cusEmail=""+_reqDetails[28]+"";
			cusPhn=""+_reqDetails[26]+"";
			cusAdd=""+info.getCaddress()+"";
			cusCity=""+info.getCcity()+"";
			cusState=""+_reqDetails[32]+"";
			cusZip=""+info.getCzip()+"";
			
			DiscTyp=""+info.getDiscounttype()+"";
			afftCode=_reqDetails[64].toString();	
			bookNo  =_reqDetails[51].toString();
			
			wholeId =_reqDetails[95].toString();
			
			hotName =_reqDetails[1].toString();
			hotAdd  =info.getHotelAddress().toString();
			hotCity =info.getHotelcity().toString();
			hotZip  =_reqDetails[50].toString();
			hotFax  =_reqDetails[49].toString();
			hotPhn  =info.getHotelphone().toString();
			hotEmail  =info.getHotelemail().toString();
			hotContper=info.getHotelmaincontactname().toString();
			
			cctype=_reqDetails[36];
			ccexp=""+(Integer.parseInt(_reqDetails[39]))+"/"+_reqDetails[40]+"";
			ccno=""+_reqDetails[38].substring(_reqDetails[38].length()-4,_reqDetails[38].length())+"";
			ccname=_reqDetails[37];
			
			noRooms=_reqDetails[10].toString();
			moreInfo  =_reqDetails[92].toString();
			multbook =info.getBooktype().toString();
			bedTydesc =info.getBedName().toString();// if multiple format is - bed1|@|bed2
			chkInDate =_reqDetails[45].toString();
			chkOutdate =_reqDetails[46].toString();
			noNight =_reqDetails[14].toString();
			mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
			radsBdTyp =_reqDetails[61].replace ('`',',');			
			noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
			noChild=_reqDetails[12];
			noStud=_reqDetails[90];
			spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			timeArr=info.getTimeofarrival().toString();
			purposeSty=info.getPurposeofstay().toString();
			hearAbt=info.getHowuhear().toString();
			adltRtByBtyp=info.getRoomrate().toString(); // if multiple format is - 78@79
			stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
			roomType=_reqDetails[4].toString();
			try{
				
			//RadsNightRate=_reqDetails[129].substring(0,_reqDetails[129].lastIndexOf("|")-1);
			RadsNightRate=_reqDetails[129].replace('|',',');
			RadsNightRate=RadsNightRate.substring(0,RadsNightRate.lastIndexOf(",")-1);
			}catch(Exception e){}
			totCharge=(Double.parseDouble(_rateDetails[_rateDetails.length-1][4])-Double.parseDouble(_reqDetails[102]));
			bookFee=Double.parseDouble(_reqDetails[102]);
			try{
			radsBookFee=Double.parseDouble(_reqDetails[69])-Double.parseDouble(_reqDetails[142]);
			}catch(Exception e){}
			subTot=Double.parseDouble(_rateDetails[_rateDetails.length-1][0]);
			totPay=Double.parseDouble(_rateDetails[_rateDetails.length-1][4]);
			deposit=Double.parseDouble(_reqDetails[69]);
			balance=Double.parseDouble(_reqDetails[71]);
			depChgonline=info.getDepositcharge();
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			title=_reqDetails[22].toString();
		}else{
			//PR_SECURE_CC_REPORT
			hotcontract=rs.getString(28);
			x="1";
			try{
				supl	=rs.getString(66);
			}catch(Exception e){}
			
			x="2";
			if(Site.equals("LondonHotelSavings")){
				resDate=rs.getString(1);
			}else if(Site.equals("LondonHotelSite")){
				resDate=rs.getString(1);
			}else if(Site.equals("TravelStay")){
				resDate=rs.getString(1);
			}
			
			x="3";
			cusName=rs.getString(82);
			x="4";
			cusCountry=rs.getString(46);
			x="5";
			cusEmail=rs.getString(14);
			x="6";
			cusPhn=rs.getString(10);
			x="7";
			cusAdd=rs.getString(9);
			x="8";
			cusCity=rs.getString(11);
			x="9";
			cusState=rs.getString(83);
			x="10";
			cusZip=rs.getString(84);
			x="11";
			
			DiscTyp=rs.getString(47);
			x="12";
			afftCode=rs.getString(71);
			x="13";	
			bookNo  =rs.getString(18);
			x="14";	
			
			wholeId =rs.getString(77);	
			x="15";
			
			hotName =rs.getString(2);
			x="16";	
			hotAdd  =rs.getString(53);
			x="17";	
			hotCity =rs.getString(3);
			x="18";	
			hotZip  =rs.getString(31);	
			x="19";
			title=rs.getString(90);
			
			StringTokenizer telfax  = new StringTokenizer(rs.getString(35)+":",":");
			x="20";
			
			while(telfax.hasMoreElements()){
				x="21";
				hotPhn  	=telfax.nextToken();
				hotFax		=telfax.nextToken();
				hotEmail	=telfax.nextToken();
				x="22";
				hotContper	=telfax.nextToken();
				x="23";
			}
			
			x="24";
			cctype=rs.getString(23);	
			x="25";
			ccexp=rs.getString(24);
			x="26";
			ccno=(rs.getString(25)).substring(rs.getString(25).length()-4,rs.getString(25).length());
			x="27";
			ccname=rs.getString(26);
			
			x="28";
			noRooms=rs.getString(70);
			x="29";
			moreInfo  =rs.getString(85);
			x="30";
			multbook =rs.getString(78);
			x="31";
			bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
			x="32";
			chkInDate =rs.getString(4);
			x="33";
			chkOutdate =rs.getString(32);
			x="34";
			noNight =rs.getString(5);
			x="35";
			
			if(supl.equals("INT")){ 
				try{
					mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
					mealPlan =rs.getString(44);	
				}
			}else{
					mealPlan =rs.getString(91);	
			}	
				
			x="36";
			
			if(supl.equals("INT")){
			radsBdTyp =rs.getString(89);
			}else{
			radsBdTyp =rs.getString(69);
			}
			x="37";
			noPeople =rs.getInt(17);
			x="38";
			noChild=rs.getString(38);
			x="39";
			noStud=rs.getString(86);
			x="40";
			spcReq = rs.getString(6);
			x="41";
			timeArr=rs.getString(63);
			x="42";
			purposeSty=rs.getString(87);
			x="43";
			hearAbt=rs.getString(88);
			x="44";
			adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
			x="45";
			stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
			x="46";
			
				
			try{
				
			RadsNightRate=rs.getString(64);
			x="47";
			}catch(Exception e){}
			x="48";
			totCharge=rs.getDouble(62);
			x="49";
			bookFee=rs.getDouble(55);
			x="50";
			try{
			x="51";
			radsBookFee=rs.getDouble(55);
			x="52";
			}catch(Exception e){}
			x="53";
			subTot=rs.getDouble(29);
			x="54";
			totPay=rs.getDouble(62);
			x="55";
			deposit=rs.getDouble(50);
			x="56";
			balance=rs.getDouble(81);
			x="57";
			depChgonline=null;
			x="58";
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			roomType=rs.getString(93);
			x="59";		
		}
		x="60";
		
;
		  /*_sbr.append("<form name=form1>\n");
		  _sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  _sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  _sbr.append("</form>\n");*/
		  _sbr.append(""+Site+"\n");

		  _sbr.append(""+__resFirstBundle.getString("Address1")+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Address2")+","+__resFirstBundle.getString("Address3")+"\n");
		  _sbr.append(""+__resFirstBundle.getString("TeleNo")+" "+__resFirstBundle.getString("Fax")+": "+__resFirstBundle.getString("FaxNo")+"\n\n");


		  _sbr.append(""+__resFirstBundle.getString("BookingDate")+" : "+resDate+"\n");
		  _sbr.append(""+__resFirstBundle.getString("BookingNo")+" : "+bookNo+"\n\n");
		  
		  if(!supl.equals("INT")){
		  _sbr.append("Supplier Information\n");
		  _sbr.append("====================\n");
		  _sbr.append("Suplier Name\n");
		  String supName="";
		  if(supl.equals("INV8")){
		  	
		  supName="HRN Hotels";		  	
		  _sbr.append(" : "+supName+"\n");
		  _sbr.append("Supplier  Itinerary # : "+supplierItaNo+"   Refernce # : "+supplierHotConfNo+"\n");
		  _sbr.append("Contact Name : Customer Care    Phone : 08000 32 66 96\n");
		  _sbr.append("Fax : 00 33 1710 03334      Email : affiliatesupport@hotels.com\n\n");
		  
		  }else if(supl.equals("INV1")){
		  	supName="CNG Hotels";
		  	
		  _sbr.append(" : "+supName+"\n");
		  _sbr.append("Supplier  Itinerary # : "+supplierItaNo+"   Refernce # : "+supplierHotConfNo+"\n");
		  _sbr.append("Contact Name : Eddie Scully    Phone : 00 353 644 0307\n");
		  _sbr.append("Fax : 00 353 644 0155      Email : escully@cnghotels.com\n\n");
		  }
		}
		  
		  _sbr.append(""+__resFirstBundle.getString("hotelInformation")+"\n");
		  _sbr.append("==================\n");
		  _sbr.append(""+__resFirstBundle.getString("HotelName")+" : "+hotName+"\n");
		  if(supl.equals("INT")){
		  _sbr.append(""+__resFirstBundle.getString("Address")+"            : "+hotAdd+"\n");
		  
		  _sbr.append(""+__resFirstBundle.getString("City")+"               : "+hotCity+"     "+__resFirstBundle.getString("Fax")+" No. : "+hotFax+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Phone")+"               : "+hotPhn+"      "+__resFirstBundle.getString("Email")+" : "+hotEmail+"\n");
		  _sbr.append(""+__resFirstBundle.getString("HotContactPer")+"      : "+hotContper+"     "+__resFirstBundle.getString("AccomGroup")+" : "+arrWholeSellerDetails[0]+"\n");
		  
		  }else{
		  _sbr.append(""+__resFirstBundle.getString("Address")+" : "+hotAdd+"\n");
		  _sbr.append(""+__resFirstBundle.getString("City")+" : "+hotCity+"\n");
		  }
		  
;
		  _sbr.append("\n"+__resFirstBundle.getString("guestInfo")+"\n");
		  _sbr.append("========================\n");

		  _sbr.append(""+__resFirstBundle.getString("Name")+"         : "+title+" "+cusName+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Address")+"      : "+cusAdd+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Phone")+" No.    : "+cusPhn+"\n");
		  _sbr.append(""+__resFirstBundle.getString("City")+"         : "+cusCity+"\n");

		  _sbr.append(""+__resFirstBundle.getString("State")+" / "+__resFirstBundle.getString("Zip")+"  : "+cusState+" / "+cusZip+"\n");
		  _sbr.append("Country        : "+cusCountry+"\n\n");
		  _sbr.append(""+__resFirstBundle.getString("Email")+"        : "+cusEmail+"\n\n");


		  _sbr.append(""+__resFirstBundle.getString("ResInfo")+"\n");
		  _sbr.append("===============\n");
		  
		  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"   : "+chkInDate+"\n");
		  _sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"  : "+noNight+"\n");
		  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" : "+chkOutdate+"\n");
		  _sbr.append("No. "+__resFirstBundle.getString("NoOfRooms")+"   : "+noRooms+"\n");
		  _sbr.append("Meal Plan      : "+mealPlan+"\n");
		  _sbr.append(""+__resFirstBundle.getString("NoOfAdults")+"      : "+noPeople+"\n");
		  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"   : "+chkInDate+"\n\n");

		  int __i=0;
		  while(__i<__occupancyArr1.length){
		  	_sbr.append("Customer "+(__i+1)+"     : "+__occupancyArr1[__i]+"\n");
		  	__i+=1;
		  }

		  _sbr.append("\n");
		  _sbr.append(""+__resFirstBundle.getString("SpecialRequests")+" : "+spcReq+"\n");
		  _sbr.append("time of arrival  : "+timeArr+"\n");
		  _sbr.append("Purpose of stay  : "+purposeSty+"\n");
		  _sbr.append("Where did you hear about us : "+hearAbt+"\n\n");

		  _sbr.append("Customer Payment Detail\n");//__resFirstBundle.getString("PayInfo")
		  _sbr.append("=======================\n");

		  _sbr.append(""+__resFirstBundle.getString("Cctype")+" : "+cctype+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Ceon")+"      : "+ccexp+"\n");
		  _sbr.append(""+__resFirstBundle.getString("CCNo")+"         : "+ccno+"\n");
		  _sbr.append(""+__resFirstBundle.getString("Chname")+" : "+ccname+"\n\n");


		  _sbr.append(""+__resFirstBundle.getString("PayInfo")+"\n");//
		  _sbr.append("==========================\n");
		  _sbr.append("Currency            : "+currencyName+"\n");

		  String discountType="NONE";
		  
		  /*if (!DiscTyp.equals("NONE")){
				if (DiscTyp.equals("PRIOR")){
					discountType="Prior to arival discount";
				}else if (DiscTyp.equals("NONUK")){
					discountType="Non UK residence discount";
				}else if (DiscTyp.equals("GROUP")){
					discountType=__resFirstBundle.getString("Group");
				}else if (DiscTyp.equals("STUDENT")){
					discountType="Student discount";
				}else if (DiscTyp.equals("LONGSTAY")){
					discountType="Longstay discount";
				}
			}*/
		  
		  
		  
		  if (!DiscTyp.equals("NONE")){
				if (DiscTyp.equals("PRIOR")){
//					__sbr.append("<font class=\"txt12\">Prior to arival&nbsp;</font>\r\n");
					discountType=__resFirstBundle.getString("Priorarival");
					
				}else if (DiscTyp.equals("NONUK")){
//					__sbr.append("<font class=\"txt12\">Non UK residence&nbsp;</font>\r\n");
					discountType=__resFirstBundle.getString("NONUK");
				}else if (DiscTyp.equals("GROUP")){
//					__sbr.append("<font class=\"txt12\">Group&nbsp;</font>\r\n");
					discountType=__resFirstBundle.getString("Group");
				}else if (DiscTyp.equals("STUDENT")){
//					__sbr.append("<font class=\"txt12\">Student&nbsp;</font>\r\n");
					discountType=__resFirstBundle.getString("STUDENT");
				}else if (DiscTyp.equals("LONGSTAY")){
//					__sbr.append("<font class=\"txt12\">Longstay&nbsp;</font>\r\n");
					discountType=__resFirstBundle.getString("LONGSTAY");
				}
			}else{
//				__sbr.append("<font class=\"txt12\">Standard &nbsp;</font>\r\n");
				discountType=__resFirstBundle.getString("Standard");
			}
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  _sbr.append("Discount Type     : "+discountType+"\n");

		  
		    String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			int bedTyps=0; 
			if(multbook.equals("S")){
				bedTyps=1;
			}else{
				bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			int countval=0;
			StringTokenizer adultRtBedtyp = new StringTokenizer(adltRtByBtyp,"@");
			while(adultRtBedtyp.hasMoreElements()){
				arrAdultRtBedtyp[countval]=adultRtBedtyp.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval+=1;
			}
			adultRtBedtyp=null;
			
			countval=0;
			StringTokenizer studRtBedtyp = new StringTokenizer(stdRtByBtyp,"@");
			while(studRtBedtyp.hasMoreElements()){
				arrStudRtBedtyp[countval]=studRtBedtyp.nextElement().toString();	
				if(multbook.equals("S")){
					break;
				}
				countval+=1;
			}
			studRtBedtyp=null;
			
			countval=0;
			StringTokenizer bedTypeDisc = null;
			
			if(Source.equals("RES")){
					bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
			}else{
					bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
			}
				
			while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
			}
			bedTypeDisc=null;
			
		  String bedType="";
		  String rmNo="";
		  java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
		  
		  
		  _sbr.append("Rate per night");

		  while(bedTyps>bedTypscount){//arrbedType
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			if(supl.equals("INT")){
			yourRtRm=((Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue());
			}else{
			yourRtRm=((Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue())/Double.valueOf(noNight).doubleValue();
			}
		   	if(bedTyps==1 || bedTypscount==1){
		   	_sbr.append("     : "+rmNo+" x "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"\n");
			}else if(bedTyps==2 && bedTypscount==0){
			_sbr.append("     : "+rmNo+" x "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"\n");	
			}
			bedTypscount+=1;
		 }
		  
		 arrAdultRtBedtyp=null;
		 arrStudRtBedtyp=null; 
		 arrbedTypeDisc=null;
		  
		  _sbr.append(""+__resFirstBundle.getString("Total")+" number "+__resFirstBundle.getString("NoOfNights")+" : "+noNight+"\n");
		  _sbr.append(""+__resFirstBundle.getString("SubTotal")+"    : "+curr_code+" "+subTot+"\n");

		NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumFractionDigits(2); 
          nf.setMaximumFractionDigits(2);
            
		if(supl.equals("INT")){
			_sbr.append("Tax Recovery & Service Fee : "+curr_code+" "+bookFee+"\n");
		}else{
			_sbr.append("Tax Recovery & Service Fee : "+curr_code+" "+nf.format(radsBookFee)+"\n");

		}		  
		  
		  try{
			_sbr.append(""+__resFirstBundle.getString("TotalPayable")+" : "+curr_code+" "+nf.format(totPay)+"\n");
		  }catch(Exception e){
		  	_sbr.append(""+__resFirstBundle.getString("TotalPayable")+" : "+curr_code+" "+totPay+"\n");
		  }
		            	
		            	
		  
		  
		  if(supl.equals("INT")){
			  
			  try{
				_sbr.append("Total Paid         : "+curr_code+" "+nf.format(deposit)+"\n");
			  }catch(Exception e){
			  	_sbr.append("Total Paid         : "+curr_code+" "+deposit+"\n");
			  }
			  
			  
			  if( depChgonline!=null && depChgonline.equals("false")){
			  	_sbr.append("DEPOSIT NOT CHARGED ONLINE\n");
			  }
			  
			  
			  try{
				_sbr.append("Balance to be paid By Customer : "+curr_code+" "+nf.format(balance)+"\n");
			  }catch(Exception e){
			  	_sbr.append("Balance to be paid By Customer : "+curr_code+" "+balance+"\n");
			  }

		  }
			
        }catch(Exception err){
        	//System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD at=X="+x+" "+err.toString());
			throw new Exception("Error at generating Portal Fax : at=X="+x+" "+err.toString());
		}  
		
		return _sbr;
	}
	
}
