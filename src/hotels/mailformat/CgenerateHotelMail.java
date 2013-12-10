package hotels.mailformat;


import hotels.pojo.reservation.ConfirmInfoHolder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import utils.LoadSystemProperties;

public class CgenerateHotelMail {

	public StringBuffer generateHotelMail(ResourceBundle __resFirstBundle,
			String[] _reqDetails, String[] _occuDetails, String[] rateArr,
			String bookId, String Site, String Source, ResultSet rs,
			String[] arrWholeSellerDetails, String bedTypStr,
			Connection ___conn, String BalanceDayz) throws Exception {

    	

		StringBuffer _sbr = new StringBuffer();
		String resDate="";
	   LoadSystemProperties sysProp = LoadSystemProperties.getInstance();
			String ResAgentName            = sysProp.getProperty("ResAgentName").toString().trim();
			String SchemaName       = sysProp.getProperty("SchemaName").toString().trim();
			String ResFax           = sysProp.getProperty("ResFax").toString().trim();
			String ServletUrl       = sysProp.getProperty("ServletUrl").toString().trim();
			String EnglandNo        = sysProp.getProperty("EnglandNo").toString().trim();
			String VATNo       		= sysProp.getProperty("VATNo").toString().trim();
			String ResPhoneNew    	= sysProp.getProperty("ResPhoneNew").toString().trim();			
	   
			String	SecureServletUrl = sysProp.getProperty("SSL_ServletUrlRS3").toString().trim();	
			
			
			String afftCode="RA";
			String hotName="";
			String cusName="";
			String cusCountry="";
			String cusEmail="";
			String cusPhn="";
			String DiscTyp="";
			String bookNo  ="";
			String wholeId ="";
			String multbook ="";;
			String bedTydesc ="";;// if multiple format is - bed1|@|bed2
			String chkInDate ="";;
			String chkOutdate ="";;
			String noNight ="";;
			String mealPlan ="";;
			String radsBdTyp ="";;
			int noPeople =0;
			String spcReq ="";;
			String timeArr="";;
			String adltRtByBtyp="";; // if multiple format is - 78@79
			String stdRtByBtyp="";; // if multiple format is - 78@79
			double balance=0;
			String comPerc="";
			String webSite=Site;
			String x="";
			String hotcontract="";
			String title = "";
			String roomType = "";
			String currencyName 	="British Pounds";
			String curr_htmlcode 	="&pound;";
			String curr_code 		="GBP";
			String curr_symbol		="£";
			String UserzName	= "";
			String UserzType	= "";
		
			try{

			if(Source.equals("RES")){
				
				
				if(Site.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
			}else if(Site.equals("TravelStay")){
				resDate=_reqDetails[108].toString();
			}				
				
				if(webSite.equals("TravelStay")){
					resDate=_reqDetails[108].toString();
					currencyName 	=_reqDetails[110].toString();
					curr_htmlcode 	=_reqDetails[111].toString();
					curr_code 		=_reqDetails[112].toString();
					curr_symbol		=_reqDetails[113].toString();
				}
				
				afftCode=_reqDetails[64].toString();
				comPerc=rateArr[3].toString();//commision percentage
				hotName =_reqDetails[1].toString();
				cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
				cusCountry=""+_reqDetails[48]+"";
				cusEmail=""+_reqDetails[28]+"";
				cusPhn=""+_reqDetails[26]+"";
				DiscTyp=""+_reqDetails[73]+"";
				
				bookNo  =_reqDetails[51].toString();
				wholeId =_reqDetails[95].toString();
				multbook =_reqDetails[74].toString();
				bedTydesc =_reqDetails[6].toString();// if multiple format is - bed1|@|bed2
				chkInDate =_reqDetails[45].toString();
				chkOutdate =_reqDetails[46].toString();
				noNight =_reqDetails[14].toString();
				mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
				radsBdTyp =_reqDetails[61].replace ('`',',');
				noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
				spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
				timeArr=_reqDetails[99].toString();
				adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
				stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
				balance=Double.parseDouble(_reqDetails[71]);
				title =_reqDetails[22].toString();
				roomType=_reqDetails[4].toString();

				
			}else{
				//PR_SECURE_CC_REPORT
				
		
//				if(webSite.equals("TravelStay")){
	
		
			if(Site.equals("LondonHotelSavings")){
				resDate=rs.getString(1);
			}else if(Site.equals("LondonHotelSite")){
				resDate=rs.getString(1);
			}else if(Site.equals("TravelStay")){
				resDate=rs.getString(1);
			}
					/***
					 * getting the user name and the type from the parameters
					 */
	    			UserzType = _reqDetails[0];
	    			UserzName = _reqDetails[1];
	
					currencyName 	=rs.getString("currencyName");
					curr_htmlcode 	=rs.getString("curr_htmlcode");
					curr_code 		=rs.getString("curr_code");
					curr_symbol		=rs.getString("curr_symbol");
//				}
					
					
				x="a";
				afftCode=rs.getString(71);
				x="a1";
				hotcontract=rs.getString(28);
				x="a2";
				comPerc=rateArr[3].toString();//commision percentage
				x="a3";
				hotName =rs.getString(2);	
				x="a4";
				cusName=rs.getString(82);	
				x="a5";
				cusCountry=rs.getString(46);
				x="a6";	
				cusEmail=rs.getString(14);	
				x="a7";
				cusPhn=rs.getString(10);
				x="a8";	
				DiscTyp=rs.getString(47);
				
				x="b";
				
				
				bookNo  =rs.getString(18);
				wholeId =rs.getString(77);
				multbook =rs.getString(78);
				bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
				chkInDate =rs.getString(4);
				chkOutdate =rs.getString(32);
				noNight =rs.getString(5);
				
				x="c";
				
				try{
				mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
				mealPlan =rs.getString(44);	
				}
				
				
				
				x="d";
				radsBdTyp =rs.getString(69);
				noPeople =rs.getInt(17);
				spcReq = rs.getString(6);
				    				
				timeArr=rs.getString(58);
				  				
				    				
				adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
				stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
				balance=rs.getDouble(81);
				title	= rs.getString(90);
				bedTypStr = rs.getString(92);
				roomType=rs.getString(93);
				
				x="e";
			}
					
			x="1";
			
			_sbr.append("<html>\n");
			_sbr.append("<body>\n");
			_sbr.append("<form name=form1>\n");
		  	_sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  	_sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  	_sbr.append("</form>\n");

			_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2>THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY</font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
						
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2><b>BOOKING CONFIRMATION NO: "+bookNo+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	   	
			
			
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2><b>Time of booking: "+resDate+" GMT</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			
			x="2";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	  
			_sbr.append("<font face='Courier New' size=2><b>Please confirm that this reservation has been processed</b></font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			x="3";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
			_sbr.append("<font face='Courier New' size=2><b>Online :</b> Login to <a href=\""+ServletUrl+""+ResAgentName+".HotelPartnerMain\">"+ServletUrl+""+ResAgentName+".HotelPartnerMain</a></font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	   	
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			

//			_sbr.append("<tr>");	 
//			_sbr.append("<td>");	 	
//			_sbr.append("<font face='Courier New' size=2><b>Email :</b>Reply with 'CONFIRMED' as the first word in the subject</font>\n");
//			_sbr.append("</td>");	   	
//			_sbr.append("</tr>");	   	

//			_sbr.append("<tr>");	 
//			_sbr.append("<td>");	   	
//			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
//			_sbr.append("</td>");	   	
//			_sbr.append("</tr>");
			
			x="4";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
		    	
		//Old Merthod to Confirm By Calling CoinfirmBooking Servlet in Travelstay ( Reservation Side)
			
		//_sbr.append("<font face='Courier New' size=2><b>Or click below</b> to confirm the reservation now :<a href=\""+ServletUrl+"TravelStay.ConfirmBooking?language=en&country=US&reqNo="+bookId+"\">"+ServletUrl+""+Site+".ConfirmBooking?language=en&country=US&reqNo="+bookId+"</a></font>\n");
			
			
		_sbr.append("<font face='Courier New' size=2><b>Or click below</b> to process the reservation now :<a href=\""+SecureServletUrl+ResAgentName+".WebReservationsReport?Frame=SaveResConfirmBack&HidCusRaNumber=&HidFaxCusRaNumber=&HidsubMailNo=&HidsubFaxNo=&HidsubNos=&HidSendConfirmation=&HidChangeConNo=&HidChangeRANo=&HidChangeSubConNo=&HidFreeSell=&HidRANumbers="+bookNo+"&HidHotConNumbers=&className=WebReservationsReport&usertype=&userztype="+UserzType+"&userzname="+UserzName+"\"> "+ServletUrl+""+Site+".ConfirmBooking?language=en&country=US&reqNo="+bookId+"</a></font>\n");
			
			
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			/*_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_HotelMsg3")+"&nbsp;"+ResFax+"&nbsp;"+__resFirstBundle.getString("EML_HotelMsg4")+"</font>&nbsp;   \n");		
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_HotelMsg5")+"</font>\n");						
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	*/   	
			_sbr.append("</table>"); 	
			_sbr.append("<br>"); 	
			_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0");
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2><b>BOOKING SUMMARY</b><br>==============</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");

			x="5";
			_sbr.append("<tr>");
			_sbr.append("<td width='35%'>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("HotelName")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td width='65%'>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+hotName+"</font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			/*
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("BookingNo")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+_reqDetails[51]+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			*/
			
			x="6";
			{
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				x="7";
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
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
				
				x="8";
				_sbr.append("<tr>");
				_sbr.append("<td>");
				_sbr.append("<font face='Courier New' size=2>Room Type</font>\n");
				_sbr.append("</td>");
	
				while(bedTyps>bedTypscount){//arrbedType
					x="9";
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
						}else{
							_sbr.append("<tr>");
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
							_sbr.append("</td>");
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
						}
					}else if(bedTyps==2 && bedTypscount==0){
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
					}
					bedTypscount+=1;
				}
				x="10";
				arrbedTypeDisc=null;
			}		

			x="11";
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. of Guests </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+noPeople+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Meal Plan </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+mealPlan+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="12";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CheckInDate")+" </font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+chkInDate+"</font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="13";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. "+__resFirstBundle.getString("NoOfNights")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+noNight+"</td> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="14";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			x="141";
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CheckOutDate")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			x="142";
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+chkOutdate+"</font>  \n");
			x="143 + chkOutdate "+chkOutdate;
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="15";
			int __i=0;
			String occLen=""+_occuDetails.length+"";
			while(__i<_occuDetails.length){
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
			_sbr.append("<font face='Courier New' size=2>Guest "+(__i+1)+"</font>\n");
			}else{
			_sbr.append("<font face='Courier New' size=2>Room "+(__i+1)+"</font>\n");
			}
			_sbr.append("</td>");
			//try{
			//_sbr.append(""+_occuDetails[__i].substring(0,_occuDetails[__i].lastIndexOf("|")-1).trim()+"\n");
			//}catch(Exception e){
			if(_occuDetails[__i] != null){
			_sbr.append(""+_occuDetails[__i]+" \n");
			}else{
			_sbr.append("<td><font face=\"Courier New\" size=2>&nbsp;:&nbsp;&nbsp;-</font></font></td> \n");	
			}
			//}
			//_sbr.append("<td>");
			//_sbr.append("<font face='Courier New' size=2>"+_occuDetails[__i]+" </font>\n");
			//_sbr.append("</td>");
			_sbr.append("</tr>");
			__i+=1;
			}
			
			x="16";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+spcReq+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="17";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Time of arrival </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+timeArr+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font><br>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>&nbsp;</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>CUSTOMER CONTACT DETAILS<br>========================</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Name")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
		//	_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;hhh"+title+"&nbsp;"+cusName+"</font>\n");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;&nbsp;"+title+"&nbsp;"+cusName+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Country")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusCountry+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Email")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusEmail+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Phone")+" No.</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusPhn+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font><br>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>&nbsp;</td>");
			_sbr.append("</tr>");
			
		
			
			
			//afftCode
			
			if(afftCode.equals("AFF73")){
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS - SPECIAL ARRANGEMENT BOOKING <br>=============================================</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   }
		   else{
		   	_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS<br>===============</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   	
		   	}
			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Currency </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+curr_code+" ("+currencyName+") </font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("DiscTypes")+"</font>\n");
			_sbr.append("</td>");
			
			x="18";
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
			
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+discountType+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="19";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
			
			String rmNo="";
			String rmNoFinal="";
			{
			String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			x="20";
			int bedTyps=0; 
			if(multbook.equals("S")){
			bedTyps=1;
			}else{
			bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			x="21";
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
			
			x="22";
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
			
			x="23";
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
			
			x="24";
			String bedType="";
			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Nightly Sell Rate</font>\n");//"+__resFirstBundle.getString("AveAdultNightRate")+"
			_sbr.append("</td>");
			//_sbr.append("<td nowrap>");

			//String bedTypStr="25.0,25.0,25.0@29.0,29.0,29.0";

			x="25";
			String btStr="";
			String strBtRt="";
			int rmNoTemp=0;
			while(bedTyps>bedTypscount){
			x="26";
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			
			
			try{
			int rmNoIn=Integer.parseInt(rmNo);
			rmNoTemp+=rmNoIn;
			rmNoFinal=Integer.toString(rmNoTemp);
			}catch(Exception e){
			e.printStackTrace();
			rmNoFinal="-";
			}
			
//			Logger logger= Logger.getLogger(generateResMails.class);
//			logger.debug("rmNoFinal >>>"+rmNoFinal);
			
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			//yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			//str1.substring(str1.indexOf("@")+1,str1.length())
			try{
				
			if (bedTypscount==0){
				
			
				
				
				strBtRt="";
				btStr=bedTypStr.substring(0,bedTypStr.indexOf("@"));
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				
				}
			}else{
				
				
			
				
				strBtRt="";
				btStr=bedTypStr.substring(bedTypStr.indexOf("@")+1,bedTypStr.length());
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
				//	yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				
				}
				
			}	
			strBtRt=strBtRt.substring(0,strBtRt.length()-2);
			}catch(Exception e){}	
			
			x="27";
			/*try{
				yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
			}catch(Exception e){}
			*/
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}

			x="28";	
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");//__formater.format(yourRtRm)
					_sbr.append("</td>");
					_sbr.append("</tr>");
				}else{
					_sbr.append("<tr>");
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
					_sbr.append("</td>");
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");
					_sbr.append("</td>");
					_sbr.append("</tr>");
				}
			}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");
					_sbr.append("</td>");
					_sbr.append("</tr>");
			}
			
			bedTypscount+=1;
			
			}
			
			x="29";
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
			}		  
			
			x="30";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. "+__resFirstBundle.getString("NoOfRooms")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;&nbsp;"+rmNoFinal+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. "+__resFirstBundle.getString("NoOfNights")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;&nbsp;"+noNight+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");

			_sbr.append("</tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2>****************************************************************</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="31";
			_sbr.append("<tr>");
			_sbr.append("<td nowrap>");
			
	  		Statement 		___stmt=null;
	  		ResultSet ___result=null;
			
			try{
				//String hotCode= rs.getString(54);

		  		
				if (___conn != null){
							     	
						___stmt=___conn.createStatement();
						String WS_TERMZ = "";
						String Bal = null;
						try{
							
							String qry = "SELECT WS_TERMS "+
									"	FROM "+SchemaName+".lkup_hotels "+
									"	WHERE "+
									"	HOTEL_CODE in (select HOTEL_CODE from "+SchemaName+".lkup_hotels where upper(HOTEL_NAME)  like upper('"+hotName+"')) ";
									
							//writeToFile("",qry);
							___result =  ___stmt.executeQuery(qry);
							
							if(___result.next()){								
									WS_TERMZ = ___result.getString(1);
							}
							
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							if(___result!=null){try{___result.close();___result=null;}catch(Exception e){___result =null;}}
								// TODO: handle exception
							}
						
						
						if((WS_TERMZ!=null)&&(WS_TERMZ.equals("N"))){	
						
						String qry = "SELECT DEPOSIT_TYPE "+
								"	FROM "+SchemaName+".LKUP_DEPOSIT_SETUP_BOOKINGS "+
								"	WHERE "+
								"	HOTEL_CODE in (select HOTEL_CODE from "+SchemaName+".lkup_hotels where upper(HOTEL_NAME)  like upper('"+hotName+"')) "+
								"	 AND DEPOSIT_TYPE <> 'Y' "+
						        "	AND SUBSTR('"+chkInDate+"',1,11) BETWEEN DEPOSIT_PERIOD_FROM  AND DEPOSIT_PERIOD_TO ";

						___result = ___stmt.executeQuery(qry);
						
						if(___result.next()){
									Bal = 	___result.getString(1);	
						}
						}
						
						if((WS_TERMZ!=null)&&(WS_TERMZ.equals("N"))&&(Bal!=null)){
							
							
							if (afftCode.equals("AFF122")){
    							
								_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");
								

//    							***************158********************************
    				              }else if (afftCode.equals("AFF157")){
    							
    							// _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"\n");
    							 _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
    							 
    							//***********************************************
//  							 ***************158********************************
    				              }else if (afftCode.equals("AFF156")){
    				            	  
//    				            	  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
    				            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
    				            	  //***********************************************
							}
							else
							{
							
							_sbr.append("<font face='Courier New' size=2>Net Balance payable "+___result.getString(1)+" days prior to arrival</font>\n");
						
							}
							
							}else{
							if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
								if(arrWholeSellerDetails[10].equals("Y")){
									_sbr.append("<font face='Courier New' size=2>Net balance payable to "+arrWholeSellerDetails[0]+" </font>\n");
									
								}else{
									_sbr.append("<font face='Courier New' size=2>Net balance payable to "+hotName+" </font>\n");
								}
							}
							
							//++++++++++++ AF122
					 	
					 	else if (afftCode.equals("AFF122")){
					 		
					 	
					 		_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");	
					 		
					 	
//							***************158********************************
				              }else if (afftCode.equals("AFF157")){
							
//							 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
							 _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
							//***********************************************
							
							 
//							 ***************158********************************
				              }else if (afftCode.equals("AFF156")){
				            	  
//				            	  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
				            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
				            	  //***********************************************
				            	  
					 	    
							
				              }else{
								
									_sbr.append("<font face='Courier New' size=2>Net balance payable upon arrival </font>\n");
								

							}	
						}
						//else{

							//_sbr.append("<font face='Courier New' size=2>Net balance payable upon arrival </font>\n");
						
	
				}else if ((BalanceDayz != null)&&(BalanceDayz!=null)&&(!BalanceDayz.equals("WS_TERMZ"))){
					_sbr.append("<font face='Courier New' size=2>Net Balance payable "+BalanceDayz+" days prior to arrival</font>\n");
			     
				}else{
					
				
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
				if(arrWholeSellerDetails[10].equals("Y")){
					_sbr.append("<font face='Courier New' size=2>Net balance payable to "+arrWholeSellerDetails[0]+" </font>\n");
				}else{
					_sbr.append("<font face='Courier New' size=2>Net balance payable to "+hotName+" </font>\n");
				}
			}else{
				
					_sbr.append("<font face='Courier New' size=2>Net balance payable upon arrival </font>\n");
				

			}
			}
			}catch(Exception e){
				e.printStackTrace();
				_sbr.append("error@>"+e.toString());	
			}
			finally{
				if(___result!=null){try{___result.close();___result=null;}catch(Exception e){___result =null;}}	
				if(___stmt!=null){try{___stmt.close();___stmt=null;}catch(Exception e){___stmt =null;}}	
			}
			
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+curr_code+" "+__formater.format(balance)+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2>****************************************************************</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	  
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan=2>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;TravelStay Network</b></font>\n");
			_sbr.append("<td>");
			_sbr.append("</tr>");
			
			x="32";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Phone")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+ResPhoneNew+"</font>\n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Fax")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+ResFax+"</font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Email")+"</b></font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			//_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;bookings@"+webSite+".com</font> \n");
//			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;Bookings@TravelStayNetwork.com</font> \n");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;HotelSupport@TravelStayNetwork.com</font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("regInLon")+"</b></font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+EnglandNo+"  </font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("vatRegNo")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+VATNo+"  </font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			_sbr.append("</table>");
			x="33";
			
			_sbr.append("</body>\n");
			_sbr.append("</html>\n");

		  			
		}catch(Exception err){
			throw new Exception("Error at generating Hotel Mail Comm : at="+x+" "+err.toString());

		}
		return _sbr;	  

	}
	
	
	public StringBuffer mgenerateHotelMailNetAce(
			ResourceBundle __resFirstBundle, String[] _reqDetails,
			String[] _occuDetails, String[] rateArr, String bookId,
			String Site, String Source, ResultSet rs,
			String[] arrWholeSellerDetails, String bedTypStr) throws Exception {
		StringBuffer _sbr = new StringBuffer();
		String resDate="";
	   LoadSystemProperties sysProp = LoadSystemProperties.getInstance();
			String ResAgentName            = sysProp.getProperty("ResAgentName").toString().trim();
			String Address1                = sysProp.getProperty("Address1").toString().trim();
			String Address2                = sysProp.getProperty("Address2").toString().trim();
			String Address3                = sysProp.getProperty("Address3").toString().trim();
			String Address4                = sysProp.getProperty("Address4").toString().trim();   
			String SchemaName       = sysProp.getProperty("SchemaName").toString().trim();
			String Currency         = sysProp.getProperty("Currency").toString().trim();
			String ResFax           = sysProp.getProperty("ResFax").toString().trim();
			String ServletUrl       = sysProp.getProperty("ServletUrl").toString().trim();
			String EnglandNo        = sysProp.getProperty("EnglandNo").toString().trim();
			String VATNo       		= sysProp.getProperty("VATNo").toString().trim();
			String ResPhone    		= sysProp.getProperty("ResPhone").toString().trim();			
			String ResPhoneNew    	= sysProp.getProperty("ResPhoneNew").toString().trim();			
			String ResEmail    		= sysProp.getProperty("ResEmail").toString().trim();
			String ResUrl    		= sysProp.getProperty("ResUrl").toString().trim();
	   
			String afftCode="RA";
			String hotName="";
			String cusName="";
			String cusCountry="";
			String cusEmail="";
			String cusPhn="";
			String DiscTyp="";
			String bookNo  ="";
			String wholeId ="";
			String multbook ="";;
			String bedTydesc ="";;// if multiple format is - bed1|@|bed2
			String chkInDate ="";;
			String chkOutdate ="";;
			String noNight ="";;
			String mealPlan ="";;
			String radsBdTyp ="";;
			int noPeople =0;
			String spcReq ="";;
			String timeArr="";;
			String adltRtByBtyp="";; // if multiple format is - 78@79
			String stdRtByBtyp="";; // if multiple format is - 78@79
			double balance=0;
			String comPerc="";
			String webSite=Site;
			String x="";
			String hotcontract="";
			String title = "";
			String roomType = "";
			String currencyName 	="British Pounds";
			String curr_htmlcode 	="&pound;";
			String curr_code 		="GBP";
			String curr_symbol		="£";
		
			try{

			if(Source.equals("RES")){
				
				
				if(Site.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
			}else if(Site.equals("TravelStay")){
				resDate=_reqDetails[108].toString();
			}				
				
				if(webSite.equals("TravelStay")){
					resDate=_reqDetails[108].toString();
					currencyName 	=_reqDetails[110].toString();
					curr_htmlcode 	=_reqDetails[111].toString();
					curr_code 		=_reqDetails[112].toString();
					curr_symbol		=_reqDetails[113].toString();
				}
				
				afftCode=_reqDetails[64].toString();
				comPerc=rateArr[3].toString();//commision percentage
				hotName =_reqDetails[1].toString();
				cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
				cusCountry=""+_reqDetails[48]+"";
				cusEmail=""+_reqDetails[28]+"";
				cusPhn=""+_reqDetails[26]+"";
				DiscTyp=""+_reqDetails[73]+"";
				
				bookNo  =_reqDetails[51].toString();
				wholeId =_reqDetails[95].toString();
				multbook =_reqDetails[74].toString();
				bedTydesc =_reqDetails[6].toString();// if multiple format is - bed1|@|bed2
				chkInDate =_reqDetails[45].toString();
				chkOutdate =_reqDetails[46].toString();
				noNight =_reqDetails[14].toString();
				mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
				radsBdTyp =_reqDetails[61].replace ('`',',');
				noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
				spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
				timeArr=_reqDetails[99].toString();
				adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
				stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
				balance=Double.parseDouble(_reqDetails[71]);
				title =_reqDetails[22].toString();
				roomType=_reqDetails[4].toString();

				
			}else{
				//PR_SECURE_CC_REPORT
				
		
//				if(webSite.equals("TravelStay")){
	
		
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
//				}
				x="a";
				afftCode=rs.getString(71);
				x="a1";
				hotcontract=rs.getString(28);
				x="a2";
				comPerc=rateArr[3].toString();//commision percentage
				x="a3";
				hotName =rs.getString(2);	
				x="a4";
				cusName=rs.getString(82);	
				x="a5";
				cusCountry=rs.getString(46);
				x="a6";	
				cusEmail=rs.getString(14);	
				x="a7";
				cusPhn=rs.getString(10);
				x="a8";	
				DiscTyp=rs.getString(47);
				
				x="b";
				
				bookNo  =rs.getString(18);
				wholeId =rs.getString(77);
				multbook =rs.getString(78);
				bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
				chkInDate =rs.getString(4);
				chkOutdate =rs.getString(32);
				noNight =rs.getString(5);
				
				x="c";
				
				try{
				mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
				mealPlan =rs.getString(44);	
				}
				
				x="d";
				radsBdTyp =rs.getString(69);
				noPeople =rs.getInt(17);
				spcReq = rs.getString(6);
				timeArr=rs.getString(63);
				adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
				stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
				balance=rs.getDouble(81);
				title	= rs.getString(90);
				bedTypStr = rs.getString(92);
				roomType=rs.getString(93);
				
				x="e";
			}
					
			x="1";
			_sbr.append("<form name=form1>\n");
		  	_sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  	_sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  	_sbr.append("</form>\n");

			_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2>THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY</font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
						
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2><b>BOOKING CONFIRMATION NO: "+bookNo+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	   	
			
			
			_sbr.append("<tr>");	 
			_sbr.append("<td >");	   	
			_sbr.append("<font face='Courier New' size=2><b>Time of booking: "+resDate+" GMT</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			
			x="2";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	  
			_sbr.append("<font face='Courier New' size=2><b>Please confirm that this reservation has been processed</b></font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			x="3";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
			_sbr.append("<font face='Courier New' size=2><b>Online :</b> Login to <a href=\""+ServletUrl+""+ResAgentName+".HotelPartnerMain\">"+ServletUrl+""+ResAgentName+".HotelPartnerMain</a></font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	   	
			
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");

//			_sbr.append("<tr>");	 
//			_sbr.append("<td>");	 	
//			_sbr.append("<font face='Courier New' size=2><b>Email :</b>Reply with 'CONFIRMED' as the first word in the subject</font>\n");
//			_sbr.append("</td>");	   	
//			_sbr.append("</tr>");	   	

//			_sbr.append("<tr>");	 
//			_sbr.append("<td>");	   	
//			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
//			_sbr.append("</td>");	   	
//			_sbr.append("</tr>");
			
			x="4";
			_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
		
		//	_sbr.append("<font face='Courier New' size=2><b>Or click below</b> to confirm the reservation now :<a href=\""+ServletUrl+""+Site+".ConfirmBooking?language=en&country=US&reqNo="+bookId+"\">"+ServletUrl+""+Site+".ConfirmBooking?language=en&country=US&reqNo="+bookId+"</a></font>\n");
			_sbr.append("<font face='Courier New' size=2><b>Or click below</b> to confirm the reservation now :<a href=\""+ServletUrl+"TravelStay.ConfirmBooking?language=en&country=US&reqNo="+bookId+"\">"+ServletUrl+""+Site+".ConfirmBooking?language=en&country=US&reqNo="+bookId+"</a></font>\n");
			
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			/*_sbr.append("<tr>");	 
			_sbr.append("<td>");	 	
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_HotelMsg3")+"&nbsp;"+ResFax+"&nbsp;"+__resFirstBundle.getString("EML_HotelMsg4")+"</font>&nbsp;   \n");		
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_HotelMsg5")+"</font>\n");						
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");	*/   	
			_sbr.append("</table>"); 	
			_sbr.append("<br>"); 	
			_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0");
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2><b>BOOKING SUMMARY</b><br>==============</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");

			x="5";
			_sbr.append("<tr>");
			_sbr.append("<td width='35%'>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("HotelName")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td width='65%'>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+hotName+"</font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			/*
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("BookingNo")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+_reqDetails[51]+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			*/
			
			x="6";
			{
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				x="7";
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
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
				
				x="8";
				_sbr.append("<tr>");
				_sbr.append("<td>");
				_sbr.append("<font face='Courier New' size=2>Room Type</font>\n");
				_sbr.append("</td>");
	
				while(bedTyps>bedTypscount){//arrbedType
					x="9";
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
						}else{
							_sbr.append("<tr>");
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
							_sbr.append("</td>");
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
						}
					}else if(bedTyps==2 && bedTypscount==0){
							_sbr.append("<td>");
							_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" </font>\n");
							_sbr.append("</td>");
							_sbr.append("</tr>");
					}
					bedTypscount+=1;
				}
				x="10";
				arrbedTypeDisc=null;
			}		

			x="11";
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. of Guests </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+noPeople+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Meal Plan </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+mealPlan+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="12";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CheckInDate")+" </font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+chkInDate+"</font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="13";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. "+__resFirstBundle.getString("NoOfNights")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+noNight+"</td> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="14";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			x="141";
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CheckOutDate")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			x="142";
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+chkOutdate+"</font>  \n");
			x="143 + chkOutdate "+chkOutdate;
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="15";
			int __i=0;
			String occLen=""+_occuDetails.length+"";
			while(__i<_occuDetails.length){
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
			_sbr.append("<font face='Courier New' size=2>Guest "+(__i+1)+"</font>\n");
			}else{
			_sbr.append("<font face='Courier New' size=2>Room "+(__i+1)+"</font>\n");
			}
			_sbr.append("</td>");
			//try{
			//_sbr.append(""+_occuDetails[__i].substring(0,_occuDetails[__i].lastIndexOf("|")-1).trim()+"\n");
			//}catch(Exception e){
			_sbr.append(""+_occuDetails[__i]+" \n");
			//}
			//_sbr.append("<td>");
			//_sbr.append("<font face='Courier New' size=2>"+_occuDetails[__i]+" </font>\n");
			//_sbr.append("</td>");
			_sbr.append("</tr>");
			__i+=1;
			}
			
			x="16";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+spcReq+" </font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="17";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Time of arrival </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+timeArr+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font><br>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>&nbsp;</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>CUSTOMER CONTACT DETAILS<br>========================</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Name")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
		//	_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;hhh"+title+"&nbsp;"+cusName+"</font>\n");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;&nbsp;"+title+"&nbsp;"+cusName+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Country")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusCountry+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Email")+" </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusEmail+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("Phone")+" No.</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+cusPhn+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	 
			_sbr.append("<td colspan='2'>");	   	
			_sbr.append("<font face='Courier New' size=2>-----------------------------------------------------------------</font><br>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>&nbsp;</td>");
			_sbr.append("</tr>");
			
		
			
			
			//afftCode
			
			if(afftCode.equals("AFF73")){
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS - SPECIAL ARRANGEMENT BOOKING <br>=============================================</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   }
		   else{
		   	_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS<br>===============</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   	
		   	}
			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Currency </font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+curr_code+" ("+currencyName+") </font>  \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("DiscTypes")+"</font>\n");
			_sbr.append("</td>");
			
			x="18";
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
			
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+discountType+"</font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="19";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");

			{
			String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			x="20";
			int bedTyps=0; 
			if(multbook.equals("S")){
			bedTyps=1;
			}else{
			bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			x="21";
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
			
			x="22";
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
			
			x="23";
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
			
			x="24";
			String bedType="";
			String rmNo="";
			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>Nightly Sell Rate</font>\n");//"+__resFirstBundle.getString("AveAdultNightRate")+"
			_sbr.append("</td>");
			//_sbr.append("<td nowrap>");

			//String bedTypStr="25.0,25.0,25.0@29.0,29.0,29.0";

			x="25";
			String btStr="";
			String strBtRt="";
			while(bedTyps>bedTypscount){//arrbedType
			x="26";
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			//yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			//str1.substring(str1.indexOf("@")+1,str1.length())
			try{
			if (bedTypscount==0){
				strBtRt="";
				btStr=bedTypStr.substring(0,bedTypStr.indexOf("@"));
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
			}else{
				strBtRt="";
				btStr=bedTypStr.substring(bedTypStr.indexOf("@")+1,bedTypStr.length());
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
				
			}	
			strBtRt=strBtRt.substring(0,strBtRt.length()-2);
			
	
			}catch(Exception e){}	
			
			x="27";
			/*try{
				yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
			}catch(Exception e){}
			*/
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}

			x="28";	
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");//__formater.format(yourRtRm)
					_sbr.append("</td>");
					_sbr.append("</tr>");
				}else{
					_sbr.append("<tr>");
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
					_sbr.append("</td>");
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");
					_sbr.append("</td>");
					_sbr.append("</tr>");
				}
			}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("<td>");
					_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" </font>\n");
					_sbr.append("</td>");
					_sbr.append("</tr>");
			}
			
			bedTypscount+=1;
			
			}
			
			x="29";
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
			}		  
			
			
			x="30";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>No. "+__resFirstBundle.getString("NoOfNights")+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp;&nbsp;"+noNight+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");

			_sbr.append("</tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2>****************************************************************</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			x="31";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			try{
				//String hotCode= rs.getString(54);
				
				//if (hotCode.equals("H148")){
				if (hotName.trim().equalsIgnoreCase("Charles Morton Court")){
					_sbr.append("<font face='Courier New' size=2>Net Balance payable 10 days prior to arrival</font>\n");
				}else{
					
				
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
				if(arrWholeSellerDetails[10].equals("Y")){
					_sbr.append("<font face='Courier New' size=2>Net balance payable to "+arrWholeSellerDetails[0]+" </font>\n");
				}else{
					_sbr.append("<font face='Courier New' size=2>Net balance payable to "+hotName+" </font>\n");
				}
			}else{
				
					_sbr.append("<font face='Courier New' size=2>Net balance payable upon arrival </font>\n");
				
				/*	
		  		Connection 	___conn = null;
		  		Statement 		___stmt=null;
		  		ResultSet ___result=null;
		  		PoolManager pool   = null;
		  		try{
		  			pool = etspl.common.jdbc.PoolManager.getInstance(); 
		  			String BackOfficePool = sysProp.getProperty("BackOfficePool").toString().trim();
		  			___conn = pool.getConnection(BackOfficePool);				     	
					___stmt=___conn.createStatement();
					
					String hotCode= rs.getString(54);
					

					
					boolean more = false;
					String qry = "SELECT DEPOSIT_TYPE "+
							"	FROM "+SchemaName+".LKUP_DEPOSIT_SETUP_BOOKINGS "+
							"	WHERE "+
							"	HOTEL_CODE='"+hotCode+"' "+
							"	 AND DEPOSIT_TYPE <> 'Y' ";
					//writeToFile("",qry);
					//_sbr.append(qry);
					___result = ___stmt.executeQuery(qry);
					more = ___result.next();
					if(more){
						while(more){
							
							_sbr.append("<font face='Courier New' size=2>Net balance payable "+___result.getString(1)+" days prior to arrival </font>\n");
							
						more = ___result.next();
						}
					}else{
						_sbr.append("<font face='Courier New' size=2>Net balance payable upon arrival </font>\n");	
					}
					___result.close();
				}catch(Exception e){
					//writeToFile("",e.toString());
					_sbr.append(e.toString()+" <font face='Courier New' size=2>Net balance payable upon arrival </font>\n");	
				}finally{
					try{___conn.close();___conn=null;}catch(Exception e){}
					try{___stmt.close();___stmt=null;}catch(Exception e){}
					try{___result.close();___result=null;}catch(Exception e){}
				}
			*/	
			}
			}
			}catch(Exception e){
				_sbr.append("error@>"+e.toString());	
			}
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>&nbsp;:&nbsp; "+curr_code+" "+__formater.format(balance)+"</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2>****************************************************************</font>\n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");	  
			_sbr.append("<td>");	   	
			_sbr.append("<font face='Courier New' size=2>&nbsp;</font>\n");
			_sbr.append("</td>");	   	
			_sbr.append("</tr>");
			
			
			_sbr.append("<tr>");
			_sbr.append("<td colspan=2>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;TravelStay Network</b></font>\n");
			_sbr.append("<td>");
			_sbr.append("</tr>");
			
			x="32";
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Phone")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+ResPhoneNew+"</font>\n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Fax")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+ResFax+"</font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("Email")+"</b></font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			//_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;bookings@"+webSite+".com</font> \n");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;Bookings@TravelStayNetwork.com</font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("regInLon")+"</b></font>  \n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+EnglandNo+"  </font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			
			_sbr.append("<tr>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2><b>&nbsp;"+__resFirstBundle.getString("vatRegNo")+"</b></font>\n");
			_sbr.append("</td>");
			_sbr.append("<td>");
			_sbr.append("<font face='Courier New' size=2>:&nbsp;&nbsp;"+VATNo+"  </font> \n");
			_sbr.append("</td>");			
			_sbr.append("</tr>");			
			_sbr.append("</table>");
			x="33";
			
			

		  			
		}catch(Exception err){
			throw new Exception("Error at generating Hotel Mail Comm : at="+x+" "+err.toString());

		}
		return _sbr;
	}
	
	public StringBuffer generateHotelMailReservationFinal(
			/* String[] _reqDetails,
			String[] _occuDetails, String[] rateArr, ,
			String Source, ResultSet rs,
			 String bedTypStr, String BalanceDayz*/
			ResourceBundle __resFirstBundle,ConfirmInfoHolder cinfo,String Site,String[] arrWholeSellerDetails, String bookId
			)
			throws Exception, SQLException {
     		StringBuffer _sbr = new StringBuffer();
		
		
	        LoadSystemProperties sysProp = LoadSystemProperties.getInstance();
			String ResAgentName     = sysProp.getProperty("ResAgentName").toString().trim();
			String ResFax           = sysProp.getProperty("ResFax").toString().trim();
			String ServletUrl       = sysProp.getProperty("ServletUrl").toString().trim();
			String EnglandNo        = sysProp.getProperty("EnglandNo").toString().trim();
			String VATNo       		= sysProp.getProperty("VATNo").toString().trim();
			String ResPhoneNew    	= sysProp.getProperty("ResPhoneNew").toString().trim();			
			
			String afftCode="RA";
			String resDate="";
			String hotName="";
			String cusName="";
			String cusCountry="";
			String cusEmail="";
			String cusPhn="";
			String DiscTyp="";
			String bookNo  ="";
			String wholeId ="";
			String multbook ="";;
			String bedTydesc ="";;// if multiple format is - bed1|@|bed2
			String chkInDate ="";;
			String chkOutdate ="";;
			String noNight ="";;
			String mealPlan ="";;
			String radsBdTyp ="";;
			int noPeople =0;
			String spcReq ="";;
			String timeArr="";;
			String adltRtByBtyp="";; // if multiple format is - 78@79
			String stdRtByBtyp="";; // if multiple format is - 78@79
			double balance=0;
			String comPerc="";
			String webSite=Site;
			String x="";
			String hotcontract="";
			String roomType="";
			String currencyName 	="British Pounds";
			String curr_htmlcode 	="&pound;";
			String curr_code 		="GBP";
			String curr_symbol		="£";

			
			String bedtyprates ="";

				/*if(webSite.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
					resDate=_reqDetails[144].toString();
					bedtyprates = _reqDetails[166].toString();
				}else if(webSite.equals("TravelStay")){
					resDate			=_reqDetails[108].toString();
					currencyName 	=_reqDetails[110].toString();
					curr_htmlcode 	=_reqDetails[111].toString();
					curr_code 		=_reqDetails[112].toString();
					curr_symbol		=_reqDetails[113].toString();
					bedtyprates = _reqDetails[116].toString();
				}*/
				
				afftCode=cinfo.getAffcode();
				
//				comPerc=rateArr[3].toString();//commision percentage
				hotName =cinfo.getHotelName();
				cusName=""+cinfo.getFname()+", "+cinfo.getLastname()+"";
				cusCountry=""+cinfo.getCcountry()+"";
				cusEmail=""+cinfo.getCemail()+"";
				cusPhn=""+cinfo.getCphoneno()+"";
				DiscTyp=""+cinfo.getDiscounttype()+"";		
				bookNo  =cinfo.getBooking_no();
				wholeId =cinfo.getWholesalerid();
				multbook ="S";
				bedTydesc =cinfo.getBedName();// if multiple format is - bed1|@|bed2
				chkInDate =cinfo.getShowCheckdate();
				chkOutdate =cinfo.getShowCheckoutdate();
				noNight =cinfo.getNoOfnights();
				mealPlan =cinfo.getRateplanname();
//				radsBdTyp =_reqDetails[61].replace ('`',',');
				noPeople =Integer.parseInt(cinfo.getNoOfAdults());//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
				spcReq = ""+cinfo.getSpecialrequest()+"";
				timeArr=cinfo.getTimeofarrival();
//				adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
//				stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
				balance=Double.parseDouble(cinfo.getBalance());
				roomType=cinfo.getRoomname();
			
			
		try{
			_sbr.append("THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY \n\n");
			_sbr.append("BOOKING CONFIRMATION NO: "+bookNo+"\n");
			_sbr.append("Time of booking: "+ resDate +" GMT \n\n");
			_sbr.append("Please confirm that this reservation has been processed\n");
			_sbr.append("Online : Login to "+ServletUrl+""+ResAgentName+".HotelPartnerMain\n");
			_sbr.append("Or click on the following URL to confirm the reservation now : \n"+ServletUrl+"TravelStay.ConfirmBooking?language=en&country=US&reqNo="+bookId+" \n");
			_sbr.append("-----------------------------------------------------------------\n");
			_sbr.append("BOOKING SUMMARY\n=================\n");
			_sbr.append("\n");
			_sbr.append("Accommodation");
			_sbr.append(" : "+hotName+"\n");
			x="6";
			String rmNo="";
			{
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				
				x="7";
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
				StringTokenizer bedTypeDisc = null;
				
//				if(Source.equals("RES")){
					bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
				/*}else{
					bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
				}*/
				
				while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
				}
				bedTypeDisc=null;
				
				x="8";
				_sbr.append("Room Type");

				while(bedTyps>bedTypscount){//arrbedType
					x="9";
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}else{
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}
					}else if(bedTyps==2 && bedTypscount==0){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
					}
					bedTypscount+=1;
				}
				x="10";
				arrbedTypeDisc=null;
			}		

			
			x="11";
			
			_sbr.append("No. of Guests ");
			_sbr.append("         : "+noPeople+" \n");
			
			_sbr.append("Meal Plan ");
			_sbr.append("         : "+mealPlan+" \n");
			
			x="12";
			_sbr.append(""+__resFirstBundle.getString("CheckInDate")+" ");
			_sbr.append("      : "+chkInDate+"\n");
			
			x="13";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");
			
			x="14";
			x="141";
			_sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" ");
			x="142";
			_sbr.append("    : "+chkOutdate+"\n");
			
			x="15";
//			int __i=0;
			/*String occLen=""+_occuDetails.length+"";
			while(__i<_occuDetails.length){
			if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
			_sbr.append("Guest "+(__i+1)+"             : ");
			}else{
			_sbr.append("Room "+(__i+1)+"             : ");
			}
			_sbr.append(""+_occuDetails[__i]+" \n");
			__i+=1;
			}*/
			
			
			//       System.out.println("MAil___________8");	
			
			
			x="16";
			_sbr.append(""+__resFirstBundle.getString("SpecialRequests")+" ");
			_sbr.append("  : "+spcReq+" \n");
			
			x="17";
			_sbr.append("Time of arrival ");
			_sbr.append("   : "+timeArr+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			_sbr.append("CUSTOMER CONTACT DETAILS\n========================\n");
			
			_sbr.append(""+__resFirstBundle.getString("Name")+"");
			_sbr.append("               : "+cusName+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Country")+"");
			_sbr.append("            : "+cusCountry+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+" ");
			_sbr.append("             : "+cusEmail+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Phone")+" No.");
			_sbr.append("          : "+cusPhn+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			
		
			
			//       System.out.println("MAil___________9");	
			
			
			if(afftCode.equals("AFF73")){
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS - SPECIAL ARRANGEMENT BOOKING <br>=============================================</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   }
		   else {
		   	
		   		_sbr.append("PAYMENT DETAILS\n===============\n");
		   	}
			

			_sbr.append("Currency ");
			_sbr.append("          : "+curr_code+" ("+currencyName+") \n");
			
			_sbr.append(""+__resFirstBundle.getString("DiscTypes")+" ");
			
			x="18";
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
			
			_sbr.append("  : "+discountType+"\n");
			
			x="19";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");

			{
			String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			x="20";
			int bedTyps=0; 
			if(multbook.equals("S")){
			bedTyps=1;
			}else{
			bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			
			
			x="21";
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
			
			x="22";
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
			
			x="23";
			countval=0;
			StringTokenizer bedTypeDisc = null;
//			if(Source.equals("RES")){
				bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
//			}else{
//				bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
//			}
			while(bedTypeDisc.hasMoreElements()){
			arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
			countval+=1;
			}
			bedTypeDisc=null;
			
			x="24";
			String bedType="";
			
			
			//       System.out.println("MAil___________10");	
			_sbr.append("Rate per night");//"+__resFirstBundle.getString("AveAdultNightRate")+"
			//_sbr.append("<td nowrap>");
			
			x="25";
			String btStr="";
			String strBtRt="";

			while(bedTyps>bedTypscount){//arrbedType
			x="26";
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			//yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			
			x="27";
			
			
			try{
			if (bedTypscount==0){
				strBtRt="";
				btStr=bedtyprates.substring(0,bedtyprates.indexOf("@"));
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
			}else{
				strBtRt="";
				btStr=bedtyprates.substring(bedtyprates.indexOf("@")+1,bedtyprates.length());
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
				
			}	
			strBtRt=strBtRt.substring(0,strBtRt.length()-2);
			}catch(Exception e){}

			x="28";	
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
				}else{
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
				}
			}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
			}
			
			
			bedTypscount+=1;
			
			}
			
			
			x="29";
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
			}		  
			//writeToLog("","31:");
			
			
			x="30";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfRooms")+"");
			_sbr.append("      : "+cinfo.getNoofrooms()+"\n");		
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");

			_sbr.append("****************************************************************\n");
			
			x="31";
			try{
				//writeToLog("","32:");
				
				//String hotCode= rs.getString(54);
				
				//if (hotCode.equals("H1410")){
				//if (hotName.trim().equalsIgnoreCase("Charles Morton Court")){
			//_sbr.append("Balance payable 10 days prior to arrival");

			if((cinfo.getBalancedays() != null)&&(!cinfo.getBalancedays().equals("WS_TERMZ"))){
				
				
				if (afftCode.equals("AFF122")){
					
					_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");
					
//					***************158********************************
	            }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
				 _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
					
//				 ***************158********************************
	            }else if (afftCode.equals("AFF156")){
	            	
//	            	_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	//***********************************************
	            	
				}
				else
				{
				
				_sbr.append("Balance payable "+cinfo.getBalancedays()+" days prior to arrival");
				}
				//_sbr.append("Balance payable within "+BalanceDayz+" days ");
				}else{
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
				if(arrWholeSellerDetails[10].equals("Y")){
					_sbr.append("Balance payable to "+arrWholeSellerDetails[0]+" ");
//					***************158********************************
	            }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
//				 ***************158********************************
	            }else if (afftCode.equals("AFF156")){
	            	
//	            	_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	//***********************************************
				
				}else{
					_sbr.append("Balance payable to "+hotName+" ");
				}
				
			}else if (afftCode.equals("AFF122")){
				
				_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");
				
				//***************158********************************
	              }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
	            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
				 //***************158********************************
	              }else if (afftCode.equals("AFF156")){
	            	  
//	            	  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	  //***********************************************
				
			}
				
				
				
		else{
		
			_sbr.append("Net balance payable upon arrival ");
				
			}
			
			}
			}catch(Exception e){
				_sbr.append("error"+e.toString());	
			}
			_sbr.append(" : "+curr_code+" "+__formater.format(balance)+"\n");
			
			_sbr.append("****************************************************************\n\n");
			
			//writeToLog("","32:");
			_sbr.append("TravelStay Network\n");
			
			x="32";
			_sbr.append(""+__resFirstBundle.getString("Phone")+"");
			_sbr.append(": "+ResPhoneNew+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Fax")+"");
			_sbr.append(": "+ResFax+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+"  ");
			//_sbr.append(": bookings@"+webSite+".com\n");
//			_sbr.append(": Bookings@TravelStayNetwork.com \n");
			_sbr.append(": HotelSupport@TravelStayNetwork.com \n");
			
			_sbr.append(""+__resFirstBundle.getString("regInLon")+"  ");
			_sbr.append(": "+EnglandNo+"  \n");
			
			_sbr.append(""+__resFirstBundle.getString("vatRegNo")+"");
			_sbr.append(": "+VATNo+"  \n");
			x="33";
			
			//writeToLog("","33:");
			
			//_sbr.append("<form name=form1>\n");
		  	//_sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  	//_sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
			  	//_sbr.append("</form>\n");
		
			//       System.out.println("MAil___________12");	
		}catch(Exception err){
			err.printStackTrace();
			System.out.println("MAil__________eroroororororo");	
			throw new Exception("Error at generating Hotel Mail Comm : at="+x+" "+err.toString());

		}
		return _sbr;	  

	}

	public StringBuffer generateHotelMailReservationFinalSecure(
			ResourceBundle __resFirstBundle, String[] _reqDetails,
			String[] _occuDetails, String[] rateArr, String bookId,
			String Site, String Source, ResultSet rs,
			String[] arrWholeSellerDetails, String bedTypStr, String BalanceDayz)
			throws Exception, SQLException {


		
		StringBuffer _sbr = new StringBuffer();
		
		
		
	        LoadSystemProperties sysProp = LoadSystemProperties.getInstance();
			String ResAgentName            = sysProp.getProperty("ResAgentName").toString().trim();
			String Address1                = sysProp.getProperty("Address1").toString().trim();
			String Address2                = sysProp.getProperty("Address2").toString().trim();
			String Address3                = sysProp.getProperty("Address3").toString().trim();
			String Address4                = sysProp.getProperty("Address4").toString().trim();   
			String SchemaName       = sysProp.getProperty("SchemaName").toString().trim();
			
			
			
			
			String Currency         = sysProp.getProperty("Currency").toString().trim();
			String ResFax           = sysProp.getProperty("ResFax").toString().trim();
			String ServletUrl       = sysProp.getProperty("ServletUrl").toString().trim();
			String EnglandNo        = sysProp.getProperty("EnglandNo").toString().trim();
			String VATNo       		= sysProp.getProperty("VATNo").toString().trim();
			String ResPhone    		= sysProp.getProperty("ResPhone").toString().trim();			
			String ResPhoneNew    	= sysProp.getProperty("ResPhoneNew").toString().trim();			
			String ResEmail    		= sysProp.getProperty("ResEmail").toString().trim();
			String ResUrl    		= sysProp.getProperty("ResUrl").toString().trim();
	   
			
			
			
			
			String afftCode="RA";
			String resDate="";
			String hotName="";
			String cusName="";
			String cusCountry="";
			String cusEmail="";
			String cusPhn="";
			String DiscTyp="";
			String bookNo  ="";
			String wholeId ="";
			String multbook ="";;
			String bedTydesc ="";;// if multiple format is - bed1|@|bed2
			String chkInDate ="";;
			String chkOutdate ="";;
			String noNight ="";;
			String mealPlan ="";;
			String radsBdTyp ="";;
			int noPeople =0;
			String spcReq ="";;
			String timeArr="";;
			String adltRtByBtyp="";; // if multiple format is - 78@79
			String stdRtByBtyp="";; // if multiple format is - 78@79
			double balance=0;
			String comPerc="";
			String webSite=Site;
			String x="";
			String hotcontract="";
			String roomType="";
			String currencyName 	="British Pounds";
			String curr_htmlcode 	="&pound;";
			String curr_code 		="GBP";
			String curr_symbol		="£";
			String creditCardType	="";
//			String creditCardNo  	="";
//			String cvvNo	="";
//			String cardHolderName	="";
//			String expMonth="";
//			String expYear="";
			
			String bedtyprates ="";
			
			if(Source.equals("RES")){
				//       System.out.println("MAil___________3");	
				
				//writeToLog("","3:");
				if(webSite.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
				bedtyprates = _reqDetails[166].toString();
				
				
				
				}else if(webSite.equals("TravelStay")){
					resDate			=_reqDetails[108].toString();
				
					currencyName 	=_reqDetails[110].toString();
					
					curr_htmlcode 	=_reqDetails[111].toString();
					
					curr_code 		=_reqDetails[112].toString();
					
					curr_symbol		=_reqDetails[113].toString();
					bedtyprates = _reqDetails[116].toString();
					//writeToLog("","4:");
					//       System.out.println("MAil___________4");	
				}
				
				afftCode=_reqDetails[64].toString();
				
				comPerc=rateArr[3].toString();//commision percentage
				
				
				
				hotName =_reqDetails[1].toString();
				
				
				
//				cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
				cusName=""+_reqDetails[25]+", "+_reqDetails[23]+"";
				
				
				
				cusCountry=""+_reqDetails[48]+"";
				
				
				
				cusEmail=""+_reqDetails[28]+"";
				
				
				
				cusPhn=""+_reqDetails[26]+"";
				
				
				
				DiscTyp=""+_reqDetails[73]+"";		
				
				
				bookNo  =_reqDetails[51].toString();
				
				
				
				wholeId =_reqDetails[95].toString();
				
				
				
				multbook =_reqDetails[74].toString();
				
				
				
				bedTydesc =_reqDetails[6].toString();// if multiple format is - bed1|@|bed2
			
				
				
				chkInDate =_reqDetails[45].toString();
				
				
				
				chkOutdate =_reqDetails[46].toString();
				
				
				
				noNight =_reqDetails[14].toString();
				
				
				
				mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
				
				//writeToLog("","5:");
				
				radsBdTyp =_reqDetails[61].replace ('`',',');
				
				
				
				noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
			
				
				
				
				spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			
				
				
				
				timeArr=_reqDetails[99].toString();
			
				
				
				adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
				
				
				
				
				stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
				
				
				
				
				balance=Double.parseDouble(_reqDetails[71]);
				
				
				
				roomType=_reqDetails[4].toString();
				
				
			
				
//				 bedtyprates = _reqDetails[116].toString();
				
				// writeToLog("","6:");
				
				 //       System.out.println("MAil___________5");	
				
				
			}
			
			
			
			else{
				
				//PR_SECURE_CC_REPORT
//				if(webSite.equals("TravelStay")){

		if(webSite.equals("LondonHotelSavings")){
				resDate=rs.getString(1);
			}else if(webSite.equals("LondonHotelSite")){
				resDate=rs.getString(1);
			}else if(webSite.equals("TravelStay")){
				resDate=rs.getString(1);
			}


					currencyName 	=rs.getString("currencyName");
					curr_htmlcode 	=rs.getString("curr_htmlcode");
					curr_code 		=rs.getString("curr_code");
					curr_symbol		=rs.getString("curr_symbol");
//				}
				afftCode=rs.getString(71);
				hotcontract=rs.getString(28);
				comPerc=rateArr[3].toString();//commision percentage
				hotName =rs.getString(2);	
				cusName=rs.getString(82);	
				cusCountry=rs.getString(46);	
				cusEmail=rs.getString(14);	
				cusPhn=rs.getString(10);	
				DiscTyp=rs.getString(47);
				
				bookNo  =rs.getString(18);
				wholeId =rs.getString(77);
				multbook =rs.getString(78);
				bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
				chkInDate =rs.getString(4);
				chkOutdate =rs.getString(32);
				noNight =rs.getString(5);
				try{
				mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
				mealPlan =rs.getString(44);	
				}
				radsBdTyp =rs.getString(69);
				noPeople =rs.getInt(17);
				spcReq = rs.getString(6);
				timeArr=rs.getString(63);
				adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
				stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
				balance=rs.getDouble(81);
				bedTypStr = rs.getString(92);
				roomType=rs.getString(93);
			}
			
			
			 /*creditCardType	=_reqDetails[36];
			 creditCardNo  	=_reqDetails[38];
			 cvvNo	=_reqDetails[109];
			String cardHolderName	=_reqDetails[37];
			String expMonth=_reqDetails[39];
			String expYear=_reqDetails[40];*/
			
		try{
			

			//writeToLog("","7:");
			
			//       System.out.println("MAil___________6");	
			
			_sbr.append("THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY \n\n");
			
						
			_sbr.append("BOOKING CONFIRMATION NO: "+bookNo+"\n");
			_sbr.append("Time of booking: "+ resDate +" GMT \n\n");
			//writeToLog("","8:");
			//_sbr.append("\n\n=================================== \n");
			
			_sbr.append("Please confirm that this reservation has been processed\n");
			_sbr.append("Online : Login to "+ServletUrl+""+ResAgentName+".HotelPartnerMain\n");
			//_sbr.append("Email  : Reply with 'CONFIRMED' as the first word in the subject\n");
			_sbr.append("Or click on the following URL to confirm the reservation now : \n"+ServletUrl+"TravelStay.ConfirmBooking?language=en&country=US&reqNo="+bookId+" \n");
			_sbr.append("-----------------------------------------------------------------\n");
			_sbr.append("BOOKING SUMMARY\n=================\n");
			_sbr.append("\n");
			_sbr.append("Accommodation");
			_sbr.append(" : "+hotName+"\n");
			
			//writeToLog("","9:");
			//       System.out.println("MAil___________7");	
			x="6";
			{
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				x="7";
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
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
				
				x="8";
				_sbr.append("Room Type");

				while(bedTyps>bedTypscount){//arrbedType
					x="9";
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
							
							

							
							
						}else{
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
							
							

							
							
						}
					}else if(bedTyps==2 && bedTypscount==0){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
							

							
					}
					bedTypscount+=1;
				}
				x="10";
				arrbedTypeDisc=null;
			}		

			
			x="11";
			
			_sbr.append("No. of Guests ");
			_sbr.append("         : "+noPeople+" \n");
			
			_sbr.append("Meal Plan ");
			_sbr.append("         : "+mealPlan+" \n");
			
			x="12";
			_sbr.append(""+__resFirstBundle.getString("CheckInDate")+" ");
			_sbr.append("      : "+chkInDate+"\n");
			
			x="13";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");
			
			x="14";
			x="141";
			_sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" ");
			x="142";
			_sbr.append("    : "+chkOutdate+"\n");
			
			x="15";
			int __i=0;
			String occLen=""+_occuDetails.length+"";
			while(__i<_occuDetails.length){
			if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
			_sbr.append("Guest "+(__i+1)+"             : ");
			}else{
			_sbr.append("Room "+(__i+1)+"             : ");
			}
			//try{
			//_sbr.append(""+_occuDetails[__i].substring(0,_occuDetails[__i].lastIndexOf("|")-1).trim()+"<br>");
			//}catch(Exception e){
			_sbr.append(""+_occuDetails[__i]+" \n");
			//}
			//_sbr.append("<td>");
			//_sbr.append(""+_occuDetails[__i]+" </font><br>");
			//_sbr.append("</td>");
			__i+=1;
			}
			
			
			//       System.out.println("MAil___________8");	
			
			
			x="16";
			_sbr.append(""+__resFirstBundle.getString("SpecialRequests")+" ");
			_sbr.append("  : "+spcReq+" \n");
			
			x="17";
			_sbr.append("Time of arrival ");
			_sbr.append("   : "+timeArr+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			_sbr.append("CUSTOMER CONTACT DETAILS\n========================\n");
			
			_sbr.append(""+__resFirstBundle.getString("Name")+"");
			_sbr.append("               : "+cusName+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Country")+"");
			_sbr.append("            : "+cusCountry+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+" ");
			_sbr.append("             : "+cusEmail+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Phone")+" No.");
			_sbr.append("          : "+cusPhn+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			
		
			
			//       System.out.println("MAil___________9");	
			
			
			if(afftCode.equals("AFF73")){
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS - SPECIAL ARRANGEMENT BOOKING <br>=============================================</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   }
		   else {
		   	
		   		_sbr.append("PAYMENT DETAILS\n===============\n");
		   	}
			

			_sbr.append("Currency ");
			_sbr.append("          : "+curr_code+" ("+currencyName+") \n");
			
			_sbr.append(""+__resFirstBundle.getString("DiscTypes")+" ");
			
			x="18";
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
			
			_sbr.append("  : "+discountType+"\n");
			
			x="19";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");

			{
			String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			x="20";
			int bedTyps=0; 
			if(multbook.equals("S")){
			bedTyps=1;
			}else{
			bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			
			
			x="21";
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
			
			x="22";
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
			
			x="23";
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
			
			x="24";
			String bedType="";
			String rmNo="";
			
			
			//       System.out.println("MAil___________10");	
			_sbr.append("Rate per night");//"+__resFirstBundle.getString("AveAdultNightRate")+"
			//_sbr.append("<td nowrap>");
			
			x="25";
			String btStr="";
			String strBtRt="";

			while(bedTyps>bedTypscount){//arrbedType
			x="26";
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			//yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			
			x="27";
			
			
			try{
			if (bedTypscount==0){
				strBtRt="";
				//btStr=bedTypStr.substring(0,bedTypStr.indexOf("@"));
				
				if(Source.equals("RES")){
				btStr=bedtyprates.substring(0,bedtyprates.indexOf("@"));
				}else{
					btStr=bedTypStr.substring(0,bedTypStr.indexOf("@"));
				}
				
				
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
				//OLD FORMULA	//yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					
					
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					
					


					
					
					
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
					

					
					
					
				
					
					
				}
			}else{
				strBtRt="";
				//btStr=bedTypStr.substring(bedTypStr.indexOf("@")+1,bedTypStr.length());
				
				//bedtyprates
				
				if(Source.equals("RES")){
				
				btStr=bedtyprates.substring(bedtyprates.indexOf("@")+1,bedtyprates.length());
				}
				else
				{
				btStr=bedTypStr.substring(bedTypStr.indexOf("@")+1,bedTypStr.length());
				}
				
				
				
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
			//OLD FORMULA		//yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					
					
					
					yourRtRm=(Double.parseDouble(rt.nextElement().toString()));
					
					
					
					
					

					
					
					
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
					

					
					
					
					
				}
				
			}	
			strBtRt=strBtRt.substring(0,strBtRt.length()-2);
			
			
			//mywritetoFile("generateHotelMailReservationFinal CAL " + strBtRt);
			
			}catch(Exception e){}
						
			/*try{
				yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
			}catch(Exception e){}*/
			
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}

			x="28";	
			
			
			//writeToLog("","28:");
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
					
					//writeToLog("","29:");
					
					
				}else{
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
					
					

					
					
					
					
					
				}
			}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
					//writeToLog("","30:");
			

			
			
					
			
			
			}
			
			
			bedTypscount+=1;
			
			}
			
			
			x="29";
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
			}		  
			//writeToLog("","31:");
			
			
			x="30";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");

			_sbr.append("****************************************************************\n");
			
			x="31";
			try{
				//writeToLog("","32:");
				
				//String hotCode= rs.getString(54);
				
				//if (hotCode.equals("H1410")){
				//if (hotName.trim().equalsIgnoreCase("Charles Morton Court")){
			//_sbr.append("Balance payable 10 days prior to arrival");

			if((BalanceDayz != null)&&(!BalanceDayz.equals("WS_TERMZ"))){
				
				
				if (afftCode.equals("AFF122")){
					
					_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");
					
//					***************158********************************
	            }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
				 _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
					
//				 ***************158********************************
	            }else if (afftCode.equals("AFF156")){
	            	
//	            	_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	//***********************************************
	            	
				}
				else
				{
				
				_sbr.append("Balance payable "+BalanceDayz+" days prior to arrival");
				}
				//_sbr.append("Balance payable within "+BalanceDayz+" days ");
				}else{
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
				if(arrWholeSellerDetails[10].equals("Y")){
					_sbr.append("Balance payable to "+arrWholeSellerDetails[0]+" ");
//					***************158********************************
	            }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
//				 ***************158********************************
	            }else if (afftCode.equals("AFF156")){
	            	
//	            	_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	_sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	//***********************************************
				
				}else{
					_sbr.append("Balance payable to "+hotName+" ");
				}
				
			}else if (afftCode.equals("AFF122")){
				
				_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("CardiffNetBal")+"</font>\n");
				
				//***************158********************************
	              }else if (afftCode.equals("AFF157")){
				
//				 _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelUwic")+"</font>\n");
	            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelUwic")+"");
				//***********************************************
				 //***************158********************************
	              }else if (afftCode.equals("AFF156")){
	            	  
//	            	  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"</font>\n");
	            	  _sbr.append(""+__resFirstBundle.getString("MailbalancehotelSwanseaUni")+"");
	            	  //***********************************************
				
			}
				
				
				
		else{
		
			_sbr.append("Net balance payable upon arrival ");
				
			}
			
			}
			}catch(Exception e){
				_sbr.append("error"+e.toString());	
			}
			_sbr.append(" : "+curr_code+" "+__formater.format(balance)+"\n");
			
			_sbr.append("****************************************************************\n\n");
			
			_sbr.append("CUSTOMER PAYMENT DETAILS\n========================\n");
			_sbr.append(""+__resFirstBundle.getString("creditcardtype")+"");
			_sbr.append("            : "+_reqDetails[36]+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("creditcardname")+"");
			_sbr.append("           : "+_reqDetails[38]+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("cvvno")+" ");
			_sbr.append("                         : "+_reqDetails[109]+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("cardholdersname")+"");
			_sbr.append("        : "+_reqDetails[37]+"\n");
						
			_sbr.append(""+__resFirstBundle.getString("expirydate")+"");
			_sbr.append("                    : "+_reqDetails[39]+"/"+_reqDetails[40]+"\n");

			_sbr.append("-----------------------------------------------------------------\n\n");


			
			//writeToLog("","32:");
			_sbr.append("TravelStay Network\n");
			
			x="32";
			_sbr.append(""+__resFirstBundle.getString("Phone")+"");
			_sbr.append(": "+ResPhoneNew+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Fax")+"");
			_sbr.append(": "+ResFax+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+"  ");
			//_sbr.append(": bookings@"+webSite+".com\n");
//			_sbr.append(": Bookings@TravelStayNetwork.com \n");
			_sbr.append(": HotelSupport@TravelStayNetwork.com \n");
			
			_sbr.append(""+__resFirstBundle.getString("regInLon")+"  ");
			_sbr.append(": "+EnglandNo+"  \n");
			
			_sbr.append(""+__resFirstBundle.getString("vatRegNo")+"");
			_sbr.append(": "+VATNo+"  \n");
			x="33";
			
			//writeToLog("","33:");
			
			//_sbr.append("<form name=form1>\n");
		  	//_sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  	//_sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
			  	//_sbr.append("</form>\n");
		
			//       System.out.println("MAil___________12");	
		}catch(Exception err){
			System.out.println("MAil__________eroroororororo");	
			
			throw new Exception("Error at generating Hotel Mail Comm : at="+x+" "+err.toString());

		}
		return _sbr;	  

	}
	
	public StringBuffer generateHotelFaxNetAce(
			ResourceBundle __resFirstBundle, String[] _reqDetails,
			String[] _occuDetails, String[] rateArr, String bookId,
			String Site, String Source, ResultSet rs,
			String[] arrWholeSellerDetails, String bedTypStr) throws Exception,
			SQLException {

		StringBuffer _sbr = new StringBuffer();
		
	   LoadSystemProperties sysProp = LoadSystemProperties.getInstance();
			String ResAgentName            = sysProp.getProperty("ResAgentName").toString().trim();
			String Address1                = sysProp.getProperty("Address1").toString().trim();
			String Address2                = sysProp.getProperty("Address2").toString().trim();
			String Address3                = sysProp.getProperty("Address3").toString().trim();
			String Address4                = sysProp.getProperty("Address4").toString().trim();   
			String SchemaName       = sysProp.getProperty("SchemaName").toString().trim();
			String Currency         = sysProp.getProperty("Currency").toString().trim();
			String ResFax           = sysProp.getProperty("ResFax").toString().trim();
			String ServletUrl       = sysProp.getProperty("ServletUrl").toString().trim();
			String EnglandNo        = sysProp.getProperty("EnglandNo").toString().trim();
			String VATNo       		= sysProp.getProperty("VATNo").toString().trim();
			String ResPhone    		= sysProp.getProperty("ResPhone").toString().trim();			
			String ResPhoneNew    	= sysProp.getProperty("ResPhoneNew").toString().trim();			
			String ResEmail    		= sysProp.getProperty("ResEmail").toString().trim();
			String ResUrl    		= sysProp.getProperty("ResUrl").toString().trim();
	   
			String afftCode="RA";
			String resDate="";
			String hotName="";
			String cusName="";
			String cusCountry="";
			String cusEmail="";
			String cusPhn="";
			String DiscTyp="";
			String bookNo  ="";
			String wholeId ="";
			String multbook ="";;
			String bedTydesc ="";;// if multiple format is - bed1|@|bed2
			String chkInDate ="";;
			String chkOutdate ="";;
			String noNight ="";;
			String mealPlan ="";;
			String radsBdTyp ="";;
			int noPeople =0;
			String spcReq ="";;
			String timeArr="";;
			String adltRtByBtyp="";; // if multiple format is - 78@79
			String stdRtByBtyp="";; // if multiple format is - 78@79
			double balance=0;
			String comPerc="";
			String webSite=Site;
			String x="";
			String hotcontract="";
			String roomType="";
			String currencyName 	="British Pounds";
			String curr_htmlcode 	="&pound;";
			String curr_code 		="GBP";
			String curr_symbol		="£";

			
			
			
			
			
			if(Source.equals("RES")){
				
				
				if(webSite.equals("LondonHotelSavings")||Site.equals("LondonHotelSite")){
				resDate=_reqDetails[144].toString();
				}else if(webSite.equals("TravelStay")){
					resDate			=_reqDetails[108].toString();
					currencyName 	=_reqDetails[110].toString();
					curr_htmlcode 	=_reqDetails[111].toString();
					curr_code 		=_reqDetails[112].toString();
					curr_symbol		=_reqDetails[113].toString();
				}
				
				afftCode=_reqDetails[64].toString();
				comPerc=rateArr[3].toString();//commision percentage
				hotName =_reqDetails[1].toString();
				cusName=""+_reqDetails[23]+" "+_reqDetails[25]+"";
				cusCountry=""+_reqDetails[48]+"";
				cusEmail=""+_reqDetails[28]+"";
				cusPhn=""+_reqDetails[26]+"";
				DiscTyp=""+_reqDetails[73]+"";
				
				bookNo  =_reqDetails[51].toString();
				wholeId =_reqDetails[95].toString();
				multbook =_reqDetails[74].toString();
				bedTydesc =_reqDetails[6].toString();// if multiple format is - bed1|@|bed2
				chkInDate =_reqDetails[45].toString();
				chkOutdate =_reqDetails[46].toString();
				noNight =_reqDetails[14].toString();
				mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
				radsBdTyp =_reqDetails[61].replace ('`',',');
				noPeople =Integer.parseInt(_reqDetails[11]);//((Integer.parseInt(_reqDetails[11]))-(Integer.parseInt(_reqDetails[90])));
				spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
				timeArr=_reqDetails[99].toString();
				adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
				stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
				balance=Double.parseDouble(_reqDetails[71]);
				roomType=_reqDetails[4].toString();
			}else{
				
				//PR_SECURE_CC_REPORT
//				if(webSite.equals("TravelStay")){
	
		if(webSite.equals("LondonHotelSavings")){
				resDate=rs.getString(1);
			}else if(webSite.equals("LondonHotelSite")){
				resDate=rs.getString(1);
			}else if(webSite.equals("TravelStay")){
				resDate=rs.getString(1);
			}
	
	
					currencyName 	=rs.getString("currencyName");
					curr_htmlcode 	=rs.getString("curr_htmlcode");
					curr_code 		=rs.getString("curr_code");
					curr_symbol		=rs.getString("curr_symbol");
//				}
				afftCode=rs.getString(71);
				hotcontract=rs.getString(28);
				comPerc=rateArr[3].toString();//commision percentage
				hotName =rs.getString(2);	
				cusName=rs.getString(82);	
				cusCountry=rs.getString(46);	
				cusEmail=rs.getString(14);	
				cusPhn=rs.getString(10);	
				DiscTyp=rs.getString(47);
				
				bookNo  =rs.getString(18);
				wholeId =rs.getString(77);
				multbook =rs.getString(78);
				bedTydesc =rs.getString(42);// if multiple format is - bed1|@|bed2
				chkInDate =rs.getString(4);
				chkOutdate =rs.getString(32);
				noNight =rs.getString(5);
				try{
				mealPlan =rs.getString(44).substring(0,rs.getString(44).indexOf("/"));
				}catch(Exception e){
				mealPlan =rs.getString(44);	
				}
				radsBdTyp =rs.getString(69);
				noPeople =rs.getInt(17);
				spcReq = rs.getString(6);
				timeArr=rs.getString(63);
				adltRtByBtyp=rs.getString(79); // if multiple format is - 78@79
				stdRtByBtyp=rs.getString(80); // if multiple format is - 78@79
				balance=rs.getDouble(81);
				bedTypStr = rs.getString(92);
				roomType=rs.getString(93);
			}
					
		try{
			
			_sbr.append("THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY \n\n");
			
						
			_sbr.append("BOOKING CONFIRMATION NO: "+bookNo+"\n");
			_sbr.append("Time of booking: "+ resDate +" GMT\n");
			
			_sbr.append("===================================\n");
			
			_sbr.append("Please confirm that this reservation has been processed\n");
			_sbr.append("Online : Login to "+ServletUrl+""+ResAgentName+".HotelPartnerMain\n");
			//_sbr.append("Email  : Reply with 'CONFIRMED' as the first word in the subject\n");
			_sbr.append("Or click on the following URL to confirm the reservation now : \n"+ServletUrl+"TravelStay.ConfirmBooking?language=en&country=US&reqNo="+bookId+" \n");
			_sbr.append("-----------------------------------------------------------------\n");
			_sbr.append("BOOKING SUMMARY\n=================\n");
			_sbr.append("\n");
			_sbr.append("Accommodation");
			_sbr.append(" : "+hotName+"\n");
			
			
			x="6";
			{
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				x="7";
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
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
				
				x="8";
				_sbr.append("Room Type");
	
				while(bedTyps>bedTypscount){//arrbedType
					x="9";
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}else{
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}
					}else if(bedTyps==2 && bedTypscount==0){
							_sbr.append("          : "+rmNo+" x "+roomType+" - "+bedType+" \n");
					}
					bedTypscount+=1;
				}
				x="10";
				arrbedTypeDisc=null;
			}		

			x="11";
			
			_sbr.append("No. of Guests ");
			_sbr.append("         : "+noPeople+" \n");
			
			_sbr.append("Meal Plan ");
			_sbr.append("         : "+mealPlan+" \n");
			
			x="12";
			_sbr.append(""+__resFirstBundle.getString("CheckInDate")+" ");
			_sbr.append("      : "+chkInDate+"\n");
			
			x="13";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");
			
			x="14";
			x="141";
			_sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" ");
			x="142";
			_sbr.append("    : "+chkOutdate+"\n");
			
			x="15";
			int __i=0;
			String occLen=""+_occuDetails.length+"";
			while(__i<_occuDetails.length){
			if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
			_sbr.append("Guest "+(__i+1)+"             : ");
			}else{
			_sbr.append("Room "+(__i+1)+"             : ");
			}
			//try{
			//_sbr.append(""+_occuDetails[__i].substring(0,_occuDetails[__i].lastIndexOf("|")-1).trim()+"<br>");
			//}catch(Exception e){
			_sbr.append(""+_occuDetails[__i]+" \n");
			//}
			//_sbr.append("<td>");
			//_sbr.append(""+_occuDetails[__i]+" </font><br>");
			//_sbr.append("</td>");
			__i+=1;
			}
			
			x="16";
			_sbr.append(""+__resFirstBundle.getString("SpecialRequests")+" ");
			_sbr.append("  : "+spcReq+" \n");
			
			x="17";
			_sbr.append("Time of arrival ");
			_sbr.append("   : "+timeArr+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			_sbr.append("CUSTOMER CONTACT DETAILS\n========================\n");
			
			_sbr.append(""+__resFirstBundle.getString("Name")+"");
			_sbr.append("               : "+cusName+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Country")+"");
			_sbr.append("            : "+cusCountry+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+" ");
			_sbr.append("             : "+cusEmail+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Phone")+" No.");
			_sbr.append("          : "+cusPhn+"\n");
			
			_sbr.append("-----------------------------------------------------------------\n\n");
			
		
			
			
			
			
			if(afftCode.equals("AFF73")){
			_sbr.append("<tr>");
			_sbr.append("<td colspan='2'>");
			_sbr.append("<font face='Courier New' size=2><b>PAYMENT DETAILS - SPECIAL ARRANGEMENT BOOKING <br>=============================================</b></font> \n");
			_sbr.append("</td>");
			_sbr.append("</tr>");
			
		   }
		   else {
		   	
		   		_sbr.append("PAYMENT DETAILS\n===============\n");
		   	}
			

			_sbr.append("Currency ");
			_sbr.append("          : "+curr_code+" ("+currencyName+") \n");
			
			_sbr.append(""+__resFirstBundle.getString("DiscTypes")+" ");
			
			x="18";
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
			
			_sbr.append("  : "+discountType+"\n");
			
			x="19";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");

			{
			String[] arrAdultRtBedtyp=new String[3];
			String[] arrStudRtBedtyp=new String[3];
			String[] arrbedTypeDisc=new String[3];
			
			x="20";
			int bedTyps=0; 
			if(multbook.equals("S")){
			bedTyps=1;
			}else{
			bedTyps=2;
			}
			int bedTypscount=0;
			double yourRtRm=0;
			
			x="21";
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
			
			x="22";
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
			
			x="23";
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
			
			x="24";
			String bedType="";
			String rmNo="";
			
			
			_sbr.append("Rate per night");//"+__resFirstBundle.getString("AveAdultNightRate")+"
			//_sbr.append("<td nowrap>");
			
			x="25";
			String btStr="";
			String strBtRt="";

			while(bedTyps>bedTypscount){//arrbedType
			x="26";
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			//yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			
			x="27";
			
			try{
			if (bedTypscount==0){
				strBtRt="";
				btStr=bedTypStr.substring(0,bedTypStr.indexOf("@"));
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
			}else{
				strBtRt="";
				btStr=bedTypStr.substring(bedTypStr.indexOf("@")+1,bedTypStr.length());
				StringTokenizer rt=new StringTokenizer(btStr.toString()+",",",");
				while(rt.hasMoreElements()){
					yourRtRm=(Double.parseDouble(rt.nextElement().toString())/Double.valueOf(rmNo).doubleValue());
					//yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
					strBtRt=strBtRt+__formater.format(yourRtRm)+", ";
				}
				
			}	
			strBtRt=strBtRt.substring(0,strBtRt.length()-2);
			}catch(Exception e){}
						
			/*try{
				yourRtRm=(yourRtRm-(yourRtRm/100)*Double.valueOf(comPerc).doubleValue());
			}catch(Exception e){}*/
			
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}

			x="28";	
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
				}else{
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
				}
			}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append("     : "+roomType+" - "+bedType+" "+curr_code+" "+strBtRt+" \n");
			}
			
			bedTypscount+=1;
			
			}
			
			x="29";
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
			}		  
			
			x="30";
			_sbr.append("No. "+__resFirstBundle.getString("NoOfNights")+"");
			_sbr.append("      : "+noNight+"\n");

			_sbr.append("****************************************************************\n");
			
			x="31";
			try{
				//String hotCode= rs.getString(54);
				
				//if (hotCode.equals("H1410")){
				if (hotName.trim().equalsIgnoreCase("Charles Morton Court")){
			_sbr.append("Balance payable 10 days prior to arrival");
			
				}else{
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
				if(arrWholeSellerDetails[10].equals("Y")){
					_sbr.append("Balance payable to "+arrWholeSellerDetails[0]+" ");
				}else{
					_sbr.append("Balance payable to "+hotName+" ");
				}
			}else{
				
			_sbr.append("Net balance payable upon arrival ");
				
			}
			}
			}catch(Exception e){
				_sbr.append("error"+e.toString());	
			}
			_sbr.append(" : "+curr_code+" "+__formater.format(balance)+"\n");
			
			_sbr.append("****************************************************************\n\n");
			
			
			_sbr.append("TravelStay Network\n");
			
			x="32";
			_sbr.append(""+__resFirstBundle.getString("Phone")+"");
			_sbr.append(": "+ResPhoneNew+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Fax")+"");
			_sbr.append(": "+ResFax+"\n");
			
			_sbr.append(""+__resFirstBundle.getString("Email")+"  ");
			//_sbr.append(": bookings@"+webSite+".com\n");
//			_sbr.append(": Bookings@TravelStayNetwork.com \n");
			_sbr.append(": HotelSupport@TravelStayNetwork.com \n");
			
			_sbr.append(""+__resFirstBundle.getString("regInLon")+"  ");
			_sbr.append(": "+EnglandNo+"  \n");
			
			_sbr.append(""+__resFirstBundle.getString("vatRegNo")+"");
			_sbr.append(": "+VATNo+"  \n");
			x="33";
			
			
			
			//_sbr.append("<form name=form1>\n");
		  	//_sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  	//_sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  	//_sbr.append("</form>\n");
		}catch(Exception err){
			//throw new Exception("Error at generating Hotel Mail Comm : at="+x+" "+err.toString());

		}
		return _sbr;	  
    
	}
}
