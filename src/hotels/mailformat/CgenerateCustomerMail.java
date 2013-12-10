package hotels.mailformat;

import hotels.pojo.reservation.ConfirmInfoHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import utils.LoadSystemProperties;

public class CgenerateCustomerMail {

	public StringBuffer generateCustomerNetCopyAce(
			ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] _occuDetails,
			String[] arrWholeSellerDetails, String type, String supplierItaNo,
			String supplierHotConfNo, String[] afftParam, String Site,
			String Source, ResultSet rs) throws Exception {

		StringBuffer _sbr = new StringBuffer();
		int i=0;
			
		LoadSystemProperties sysProp = LoadSystemProperties.getInstance();

		String Address1     = sysProp.getProperty("Address1").toString().trim();
		String Address2     = sysProp.getProperty("Address2").toString().trim();
		String Address3     = sysProp.getProperty("Address3").toString().trim();
		String Address4     = sysProp.getProperty("Address4").toString().trim();
		String ResUrl       = sysProp.getProperty("ResUrl").toString().trim();
		String ResPhone     = sysProp.getProperty("ResPhone").toString().trim();
		String ResEmail     = sysProp.getProperty("ResEmail").toString().trim();
		String ServletUrl   = sysProp.getProperty("ServletUrl").toString().trim();
		String ResAgentName = sysProp.getProperty("ResAgentName").toString().trim();	

		String afftCode="RA";
		String bookNo  ="";
		String supl	   ="INT";
		String wholeId ="";
		String hotName ="";
		String hotAdd  ="";
		String hotCity ="";
		String hotZip  ="";;
		String moreInfo  ="";;
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
		String RadsNightRate="";;
		double totCharge=0;
		double bookFee=0;
		double radsBookFee=0;
		double totPay=0;
		double deposit=0;
		double balance=0;
		String webSite=Site;
		String ec=" ";
		double ecc=0.00;
		String hotcontract="";
		String roomType="";
		String hotPhone = "-";
		String hotCode="";
		String checkintime = "";
		String checkouttime = "";
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		
		//writeToLog("","Start of generateCustomerNetCopyAce @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	
		
		i=1;
		try{
		if(Source.equals("RES")){			
			i=-1;
			if(webSite.equals("TravelStay")){
				currencyName 	=_reqDetails[110].toString();
				curr_htmlcode 	=_reqDetails[111].toString();
				curr_code 		=_reqDetails[112].toString();
				curr_symbol		=_reqDetails[113].toString();
			}
				
			afftCode=_reqDetails[64].toString();
			ec=ec+",\r\n afftCode="+afftCode;
			i=-2;	
			bookNo  =cinfo.getBooking_no().toString();
			ec=ec+",\r\n bookNo="+bookNo;
			i=-3;
			try{
				supl	=_reqDetails[131].toString();
				ec=ec+",\r\n supl="+supl;
			}catch(Exception e){}
			i=-4;
			wholeId =_reqDetails[95].toString();
			i=-5;
			ec=ec+",\r\n wholeId="+wholeId;
			hotName =cinfo.getHotelName().toString();
			ec=ec+",\r\n hotName="+hotName;
			i=-6;
			hotAdd  =cinfo.getHotelAddress().toString();
			ec=ec+",\r\n hotAdd="+hotAdd;
			i=-7;
			hotCity =cinfo.getHotelcity().toString();
			ec=ec+",\r\n hotCity="+hotCity;
			i=-8;
			hotZip  =_reqDetails[50].toString();
			ec=ec+",\r\n hotZip="+hotZip;
			i=-9;
			hotPhone  =cinfo.getHotelphone().toString();
			ec=ec+",\r\n hotPhone="+hotPhone;
			i=-10;
			moreInfo  =_reqDetails[92].toString();
			ec=ec+",\r\n moreInfo="+moreInfo;
			i=-11;
			multbook =_reqDetails[74].toString();
			ec=ec+",\r\n multbook="+multbook;
			i=-12;
			bedTydesc =cinfo.getBedName().toString();// if multiple format is - bed1|@|bed2
			ec=ec+",\r\n bedTydesc="+bedTydesc;
			i=-13;
			chkInDate =cinfo.getShowCheckdate().toString();
			ec=ec+",\r\n chkInDate="+chkInDate;
			i=-14;
			chkOutdate =cinfo.getShowCheckoutdate().toString();
			ec=ec+",\r\n chkOutdate="+chkOutdate;
			i=-15;
			noNight =cinfo.getNoOfnights().toString();
			ec=ec+",\r\n noNight="+noNight;
			i=-16;
			mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
			ec=ec+",\r\n mealPlan="+mealPlan;
			i=-17;
			radsBdTyp =_reqDetails[61].replace ('`',',');
			ec=ec+",\r\n radsBdTyp="+radsBdTyp;
			i=-18;
			noPeople =Integer.parseInt(cinfo.getNoOfAdults());//((Integer.parseInt(cinfo.getNoOfAdults()))-(Integer.parseInt(_reqDetails[90])));
			ec=ec+",\r\n noPeople="+noPeople;
			i=-19;
			spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			ec=ec+",\r\n spcReq="+spcReq;
			i=-20;
			timeArr=_reqDetails[99].toString();
			ec=ec+",\r\n timeArr="+timeArr;
			i=-21;
			adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
			ec=ec+",\r\n adltRtByBtyp="+adltRtByBtyp;
			i=-22;
			stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
			ec=ec+",\r\n stdRtByBtyp="+adltRtByBtyp;
			i=-23;
			try{
			//RadsNightRate=_reqDetails[129].substring(0,_reqDetails[129].lastIndexOf("|")-1);
			ec=ec+",\r\n _reqDetails[129]="+_reqDetails[129];
			RadsNightRate=_reqDetails[129].replace('|',',');
			ec=ec+",\r\n RadsNightRate1="+RadsNightRate;
			i=-24;
			RadsNightRate=RadsNightRate.substring(0,RadsNightRate.lastIndexOf(",")-1);
			ec=ec+",\r\n RadsNightRate2="+RadsNightRate;
			i=-25;
			}catch(Exception e){}
			ec=ec+",\r\n cinfo.getTotalpayment()="+cinfo.getTotalpayment();
			ec=ec+",\r\n _reqDetails[102]="+_reqDetails[102];
			totCharge=(Double.parseDouble(cinfo.getTotalpayment())-Double.parseDouble(_reqDetails[102]));
			ec=ec+",\r\n totCharge="+totCharge;
			i=-26;
			bookFee=Double.parseDouble(_reqDetails[102]);
			ec=ec+",\r\n bookFee="+bookFee;
			i=-27;
			try{
			ec=ec+",\r\n cinfo.getPaynow()="+cinfo.getPaynow();	
			ec=ec+",\r\n _reqDetails[142]="+_reqDetails[142];	
			radsBookFee=Double.parseDouble(cinfo.getPaynow())-Double.parseDouble(_reqDetails[142]);
			ec=ec+",\r\n radsBookFee="+radsBookFee;
			i=-28;
			}catch(Exception e){i=-288888;ec=ec+" 28 "+e.toString();}
			i=-29;
			ec=ec+",\r\n cinfo.getTotalpayment()="+cinfo.getTotalpayment();
			totPay=Double.parseDouble(cinfo.getTotalpayment());
			ec=ec+",\r\n totPay="+totPay;
			i=-30;
			deposit=Double.parseDouble(cinfo.getPaynow());
			ec=ec+",\r\n deposit="+deposit;
			i=-31;
			balance=Double.parseDouble(cinfo.getBalance());
			ec=ec+",\r\n balance="+balance;
			i=-32;
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
				ec=ec+",\r\n Site="+Site;
			}
			i=-33;
			roomType=cinfo.getRoomname().toString();
			ec=ec+",\r\n roomType="+roomType;
			i=-34;
			hotCode=cinfo.getHotelCode().toString();
			ec=ec+",\r\n hotCode="+hotCode;
			i=-35;
			try{
			checkintime=_reqDetails[65].toString();
			ec=ec+",\r\n checkintime="+checkintime;
			i=-36;
			checkouttime=_reqDetails[66].toString();
			ec=ec+",\r\n checkouttime="+checkouttime;
			i=-37;
			}catch(Exception er){
			i=-38;	
			checkintime="00:00";
			checkouttime="23:59";
			i=-39;	
			}
		}else{
		//PR_RESERVATION_REPORT_CUS_MAIL
//			if(webSite.equals("TravelStay")){
				currencyName 	=rs.getString("currencyName");
				curr_htmlcode 	=rs.getString("curr_htmlcode");
				curr_code 		=rs.getString("curr_code");
				curr_symbol		=rs.getString("curr_symbol");
//			}
		
		//	title = rs.getString(79);
			hotPhone  =rs.getString(31);
			
			hotcontract=rs.getString(78);
			i=2;
			afftCode=rs.getString(68);	
			i=21;
			bookNo  =rs.getString(15);
			i=22;	
			Site	=rs.getString(72);	
			i=23;
			webSite	=Site;
			try{
				supl	=rs.getString(57);	
			}catch(Exception e){}
			i=24;
//			wholeId =rs.getString(73);
			wholeId =rs.getString(83);
			i=25;			
			hotName =rs.getString(2);	
			i=26;	
			hotAdd  =rs.getString(3);
			i=27;		
			hotCity =rs.getString(4);
			i=28;		
			hotZip  =rs.getString(62);	
			i=29;	
			if(!afftCode.equals("RA")){
			moreInfo  =rs.getString(82);
			}else{
			moreInfo  =rs.getString(71);
			}
			i=30;		
			multbook =rs.getString(74);
			i=31;	
			bedTydesc =rs.getString(46);// if multiple format is - bed1/bed2
			i=32;	
			chkInDate =rs.getString(5);	
			i=33;	
			chkOutdate =rs.getString(6);
			i=34;		
			noNight =rs.getString(8);	
			i=35;
			
			if(supl.equals("INT")){ 
				try{
					mealPlan =rs.getString(48).substring(0,rs.getString(48).indexOf("/"));
				}catch(Exception e){
					mealPlan =rs.getString(48);	
				}
			}else{
				mealPlan =rs.getString(80);	
			}	
				
			//mealPlan =rs.getString(48).substring(0,rs.getString(48).indexOf("/"));	
			i=36;	
			radsBdTyp =rs.getString(64);
			i=37;	
			noPeople =rs.getInt(20);
			i=38;	
			spcReq = rs.getString(7);
			i=39;	
			timeArr=rs.getString(56);
			i=40;	
			adltRtByBtyp=rs.getString(75); // if multiple format is - 78@79 standard 
			i=41;	
			stdRtByBtyp=rs.getString(76); // if multiple format is - 78@79 student
			i=42;	
			try{
			i=43;	
			RadsNightRate=rs.getString(60);
			}catch(Exception e){}
			i=44;	
			totCharge=rs.getDouble(24);
			bookFee=rs.getDouble(54);
			try{
			i=45;	
			radsBookFee=rs.getDouble(54);
			}catch(Exception e){}
			totPay=rs.getDouble(25);
			deposit=rs.getDouble(50);
			balance=rs.getDouble(77);
			
			i=46;	
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			i=3;
			i=4700000;
			roomType=rs.getString(81);	
			hotCode=rs.getString(45);	
			checkintime=rs.getString(84);
			checkouttime=rs.getString(85);
			
		}
		
		//writeToLog("","After putting data generateCustomerNetCopyAce__2 @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	

//		try{
			i=4;
		  _sbr = new StringBuffer();				     		
		  _sbr.append("<html>\n");
		  _sbr.append("<body>\n");
		  _sbr.append("<form name=form1>\n");
		  _sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  _sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  _sbr.append("</form>\n");
		  
		  if(type.equals("EMAIL")){
		  	if(supl.equals("INT")){
		  		
		  		_sbr.append("<font face='Courier New' size=2> \r\n");
		  		_sbr.append("** THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY **<br> \r\n");	
		  		
		  		if(wholeId.equals("-") || afftCode.equals("AFF2")){
			//	_sbr.append("<font face='Courier New' size=2> \r\n");
		  	//	_sbr.append("** THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY **<br><br> \r\n");		
				_sbr.append(" <br> \r\n");
				_sbr.append("<font face='Courier New' size=2>*******************************************************************************<br>\r\n");
				_sbr.append("PLEASE PRINT THIS BOOKING CONFIRMATION AND PRODUCE IT UPON ARRIVAL AT THE HOTEL <br>\r\n");
//				_sbr.append("*******************************************************************************<br>\r\n");
//				_sbr.append("\r\n");
		  		}
		  		_sbr.append("<font face='Courier New' size=2> \r\n");
				_sbr.append("*******************************************************************************<br>\r\n");
				_sbr.append("\r\n");		  		;
//		  		_sbr.append("This confirmation is not valid for visa or immigration purposes <br> \r\n");		
		  		
//		  		if(afftCode.equals("AFF2")){
//				_sbr.append("<font face='Courier New' size=2>Thank you for booking through <a href=\"www.LondonNet.co.uk\">www."+Site+".co.uk</a><br>\r\n");
//				}else{
//				_sbr.append("<font face='Courier New' size=2>Thank you for booking through "+Site+"<br>\r\n");
//				}
//				
//				_sbr.append("Your booking confirmation number is "+bookNo+" <br><br>\r\n");
				
				_sbr.append("This confirmation is not valid for visa or immigration purposes. <br><br> \r\n");
				_sbr.append("Thank you for your reservation, your TravelStay Network reference number is "+bookNo+". <br><br>\r\n");
				
//				if(afftCode.equals("AFF2")){
//				//if(wholeId.equals("WH4") && afftCode.equals("AFF2")){
//					_sbr.append("<font face='Courier New' size=2>More LondonNet services for your visit:<br>\r\n");
//					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/guide/resources/airtransfer.html\">Airport Transfers</a><br>\r\n");
//					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/out/ent/theatre.html\">Theatre Tickets</a><br>\r\n");
//					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/guide/about/attractions-tickets.html\">London Attractions</a><br><br>\r\n");
//				}
				
				if(afftCode.equals("AFF2")){
					_sbr.append("<font face='Courier New' size=2>More LondonNet services for your visit:<br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/guide/resources/airtransfer.html\">Airport Transfers</a><br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.ticketswitch.com/cgi-bin/search.exe/lonnet?crypto_block=k%2D%2D%2Dkg6c1PjArPo9QwojSQqUTWqEWkfmB8zCR4nT6ONYViNls7hxHV%2DxFDTOTf2ClzSMY\">Travel Cards</a><br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/chauffeur/\">Chauffeurs</a><br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/out/ent/theatre.html\">Theatre Tickets</a><br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\"http://www.londonnet.co.uk/ln/guide/about/attractions-tickets.html\">London Attractions</a><br><br>\r\n");
				}				
				
				
			}else{
				_sbr.append("<font face='Courier New' size=2> \r\n");
		  		_sbr.append("** THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY **<br><br> \r\n");		

				_sbr.append("<font face='Courier New' size=2>*******************************************************************<br>\r\n");
				_sbr.append("PLEASE PRINT THIS BOOKING CONFIRMATION AND PRODUCE IT UPON ARRIVAL <br>\r\n");
				_sbr.append("*******************************************************************<br>\r\n");
				_sbr.append("\r\n");
						
		  		_sbr.append("<font face='Courier New' size=2> \r\n");
//		  		_sbr.append("This confirmation is not valid for visa or immigration purposes <br> \r\n");			
		  	//	_sbr.append("********************************************************************<br><br>\r\n");  		
			
//				_sbr.append("Thank you for booking with "+Site+".<br>\r\n");
//				if(supl.equals("INV8")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is Hotels.com/"+supplierHotConfNo+"<br><br>\r\n");
//				}else if(supl.equals("INV1")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is CNG/"+supplierItaNo+"<br><br>\r\n");
//				}
				
				_sbr.append("This confirmation is not valid for visa or immigration purposes. <br><br> \r\n");	
				_sbr.append("Thank you for your reservation, your reference number is "+bookNo+". <br><br>\r\n");

			}
		 }else{
		 	i=5;
		 	if(supl.equals("INT")){
			  if(!wholeId.equals("-")){
				_sbr.append("\r\n");
				_sbr.append("<font face='Courier New' size=2>*******************************************************************<br>\n");
			//	_sbr.append(""+__resFirstBundle.getString("VouHead")+" "+arrWholeSellerDetails[0]+" "+arrWholeSellerDetails[5]+"<br> \n");
				_sbr.append(""+__resFirstBundle.getString("VouHead")+" "+arrWholeSellerDetails[0]+"<br> \n");

				_sbr.append("******************************************************************* <br><br>  \n");
				_sbr.append("HOTEL BOOKING PROVIDER<br>\r\n");
				_sbr.append("====================== <br>\r\n");	
				_sbr.append(""+arrWholeSellerDetails[0]+" <br>\r\n");
				_sbr.append(""+arrWholeSellerDetails[5]+","+arrWholeSellerDetails[6]+" "+arrWholeSellerDetails[7]+" "+arrWholeSellerDetails[9]+"<br>\r\n");
				_sbr.append("" +__resFirstBundle.getString("Phone")+": "+arrWholeSellerDetails[1]+" <br>\r\n");				    			    
				_sbr.append("" +__resFirstBundle.getString("Email")+": "+arrWholeSellerDetails[3]+" <br><br>\r\n");				    			    			    		
			  }else{
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_Voucher_Head")+"<br>  \n");
			  _sbr.append("**********************************************************************<br>\n");
			  }
			}else{
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_Voucher_Head")+"<br>  \n");
			  _sbr.append("**********************************************************************<br>\n");
			}
		}
		  
          i=6;
		  _sbr.append("<font face='Courier New' size=2>HOTEL INFORMATION<br>\r\n");
		  _sbr.append("================= <br>\r\n");	
	      _sbr.append(""+hotName+" <br>\r\n");
		  _sbr.append(""+hotAdd+", <br>\r\n");
	      _sbr.append(""+hotCity+" "+hotZip+".<br>\r\n");
	      if(supl.equals("INT")){
	      _sbr.append("Phone: "+hotPhone+"<br>\r\n");				    			    
	      }else{
	      _sbr.append("Phone: +44 (0)870 922 4100<br>\r\n");				    			    
	      }	
	      
	      if(!type.equals("EMAIL") && wholeId.equals("WH1")){
	      	  _sbr.append("<br>\r\n");
		      _sbr.append("Check-in from: "+checkintime+"  <br>\r\n");
    		  _sbr.append("Check-out by: "+checkouttime+" <br>\r\n");	
    		  _sbr.append("<br>\r\n");
		  }	    			    

		  if(type.equals("EMAIL")){
		  _sbr.append(""+__resFirstBundle.getString("MoreInfo")+" and maps:&nbsp;<br> <a href=\""+moreInfo+"\">"+moreInfo+"</a>  <br>\n");
		  }
		  
		  _sbr.append("</p>  \n");
		  _sbr.append("<p><font face='Courier New' size=2> BOOKING SUMMARY <br>  \n");
		  _sbr.append("===============<br>  \n");
		  if(type.equals("EMAIL")){
		  _sbr.append("Booking No. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+bookNo+" <br>  \n");
		  }
		  
		  i=7;
		  if(supl.equals("INT")){
			
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				i=8;
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
				StringTokenizer bedTypeDisc = null;
				if(Source.equals("RES")){
					bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
				}else{
					bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
				}
				 
				i=9; 
				while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
				}
				bedTypeDisc=null;
				
				i=10;
				_sbr.append(""+__resFirstBundle.getString("HotelName")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+hotName+"<br>  \n");
				_sbr.append("Room Type &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: \r\n");
	
				while(bedTyps>bedTypscount){//arrbedType
					i=11;
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					i=12;
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					i=13;
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}else{
							_sbr.append(" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
							_sbr.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
							_sbr.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}
					}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
					}
					bedTypscount+=1;
				}
				i=13;
				arrbedTypeDisc=null;
			  	_sbr.append("<br>  \n");		  	
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+chkInDate+"<br>  \n");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+noNight+"<br>  \n");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+chkOutdate+"<br>  \n");
			  _sbr.append("No. of Guests  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+noPeople+" <br>  \n");
			  _sbr.append("Meal Plan  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+mealPlan+" <br>  \n");
			  _sbr.append("<p>  \n");
		  }else{
		  	i=14;
		  	if(supl.equals("INV8")){
			  _sbr.append("Reference No. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+supplierHotConfNo+" <br>  \n");
		  	}else{
			  _sbr.append("Itinerary No. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+supplierItaNo+" <br>  \n");
			}
			  _sbr.append("Accommodation Name  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+hotName+"<br>  \n");
			  _sbr.append("Bed Type  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+radsBdTyp+" <br>  \n");
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+chkInDate+"<br>  \n");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+noNight+"<br>  \n");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+chkOutdate+"<br>  \n");
			  _sbr.append("No. of People &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+noPeople+" Adult/s<br>  \n");
			  
			  _sbr.append("Meal Plan  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+mealPlan+" <br>  \n");
		  }

		  //_sbr.append("=========================<br>  \n");
		  i=15;
		  String occLen=""+_occuDetails.length+"";
		  for(int _i=0;_i<_occuDetails.length;_i++){
		  	if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
		  		_sbr.append("Guest "+(_i+1)+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+_occuDetails[_i]+"<br>\n");
		  	}else{
		  		_sbr.append("Room "+(_i+1)+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+_occuDetails[_i]+"<br>\n");
		  	}
		  }

		  i=16;	
		  _sbr.append("<p> \n");
		  
		  if(supl.equals("INT")){
			  
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+spcReq+"    <br>\n");
			  _sbr.append("<font face='Courier New' size=2>Time of arrival &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+timeArr+"    \n");
			  _sbr.append("</p>  \n");
		 }else{
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+spcReq+"    <br><br>\n");
		 }
		 
		 if(type.equals("EMAIL")){
		  _sbr.append("<p><font face='Courier New' size=2>PAYMENT DETAILS<br>  \n");
		  _sbr.append("===============<br>  \n");
		  _sbr.append(""+__resFirstBundle.getString("mailCurrency")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" ("+currencyName+")<br>  \n");
		  
		  if(supl.equals("INT")){
		  			  	
			i=17;
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
			
			ec=ec+"<BR> adltRtByBtyp-"+adltRtByBtyp+" stdRtByBtyp-"+stdRtByBtyp+" multbook-"+multbook;
			i=18;
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
			
			i=19;
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
			
			i=20;
			countval=0;
			StringTokenizer bedTypeDisc = null;
			
			ec=ec+"<BR>"+bedTydesc;
			
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
			
			i=21;
			String bedType="";
			String rmNo="";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
						
			_sbr.append("Nightly Room Rate inc. Tax    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: \r\n");

			while(bedTyps>bedTypscount){//arrbedType
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			
			i=22;
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}
			
			i=23;
			ec=ec+"<BR>"+arrAdultRtBedtyp[bedTypscount]+"-"+arrStudRtBedtyp[bedTypscount]+"-"+rmNo;
			
			yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			i=230;
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append(" "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" \n");
				}else{
					i=2311;
					_sbr.append(" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
					i=2322;
					_sbr.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
					i=2333;
					_sbr.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" \n");
				}
			}else if(bedTyps==2 && bedTypscount==0){
				i=2344;
//				ecc=yourRtRm;
//				ec=__formater.format(yourRtRm);
//				ec=bedType;
			_sbr.append("  "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"  \n");
			}
			i=234455;
			bedTypscount+=1;
			}
			
			i=24;
			_sbr.append("<br>");
			
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
		  	
			  
		  }else{		  	
		  	i=249999999;
		  	try{	
		  	StringTokenizer	rtPerNite = new StringTokenizer(RadsNightRate.substring(0,RadsNightRate.lastIndexOf("|")),"|");	
		  	String[] arrRt=new String[Integer.parseInt(noNight)+1];
		  		
		  	String ratePN="";
		  	int count=0;
		  	while(rtPerNite.hasMoreElements()){
				if(count==0){
				_sbr.append("Rate Per Night  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+rtPerNite.nextElement().toString()+" <br>\r\n");
				}else{
				_sbr.append(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+rtPerNite.nextElement().toString()+" <br>\r\n");
				}
				count+=1;
			}
			  //_sbr.append("Rate Per Night  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+RadsNightRate.substring(0,RadsNightRate.lastIndexOf("|"))+" <br>\r\n");
			}catch(Exception e){
			  _sbr.append("Rate Per Night  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+RadsNightRate+" <br>\r\n");
			}		  
		  }
		  
		  i=25;
		  NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumFractionDigits(2);
          nf.setMaximumFractionDigits(2);

		  if(supl.equals("INT")){
		  	_sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+noNight+"<br>  \n");
		  	_sbr.append(""+__resFirstBundle.getString("totAccCharge")+"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(totCharge)+" <br>\r\n");
		  	_sbr.append(""+__resFirstBundle.getString("bookCrFee")+"s       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(bookFee)+" <br>\r\n");
		    _sbr.append("Total payable  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(totPay)+" <br>\r\n");
		  }else{
		  	_sbr.append("Tax Recovery Charges and Service Fees     &nbsp;&nbsp;: "+curr_code+" "+nf.format(radsBookFee)+" <br>\r\n");
			_sbr.append("Total Amount &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(totPay)+" <br>\r\n");
			_sbr.append("(Total is for entire stay with tax recovery charges and service fees)<br><br>\r\n");
		  }
		  
		 i=26; 
		 if(supl.equals("INT")){
		 	i=26011;
//		 	ec=wholeId;
		  if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
		  	i=2600;
		  _sbr.append("Deposit paid to TSN     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(deposit)+" <br>\r\n");
		  i=2611; 
		  _sbr.append("*************************************************************************** <br>  \n");
		  }else{
		  	i=2600;
		  _sbr.append("Deposit paid      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(deposit)+" <br>\r\n");
		  i=2611; 
		  _sbr.append("*************************************************************************** <br>  \n");
		 }
		  if (hotCode.equals("H1410")){
		  		_sbr.append("Balance payable 10 days prior to arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
		  		_sbr.append("*************************************************************************** <br><br>  \n");
		  		}else{
		 if(!wholeId.equals("-")){
			  if(wholeId.equals("WH1")){
		  	//	_sbr.append("Balance will be taken within 7 days prior to the arrival date     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
		  		_sbr.append("Balance will be charged within 7 days of the booking date     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
			  }else if(wholeId.equals("WH4")){
		  		_sbr.append("Balance payable upon arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
			  }else{
		  		_sbr.append(""+__resFirstBundle.getString("balancePayable")+" "+arrWholeSellerDetails[0]+"     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
			 }
		  i=2633; 
		  _sbr.append("*************************************************************************** <br><br>  \n");
		  }else{
		  	if(afftCode.equals("AFF61")){
		  _sbr.append("balance payable 7 days prior to arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
		  	}else{
		  		
		  		_sbr.append("Balance payable upon arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");	
		  		
		  
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
					
					
					boolean more = false;
					String qry = "SELECT DEPOSIT_TYPE "+
							"	FROM "+__schemaName+".LKUP_DEPOSIT_SETUP_BOOKINGS "+
							"	WHERE "+
							"	HOTEL_CODE='"+hotCode+"' "+
							"	 AND DEPOSIT_TYPE <> 'Y' ";
					//writeToFile("",qry);
					___result = ___stmt.executeQuery(qry);
					more = ___result.next();
					if(more){
						while(more){
							
							_sbr.append("Balance payable "+___result.getString(1)+" days prior to arrival&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
						more = ___result.next();
						}
					}else{
						_sbr.append("Balance payable upon arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");	
					}
					___result.close();
				}catch(Exception e){
					//writeToFile("",e.toString());
					_sbr.append(e.toString()+" Balance payable upon arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");	
				}finally{
					try{___conn.close();___conn=null;}catch(Exception e){}
					try{___stmt.close();___stmt=null;}catch(Exception e){}
					try{___result.close();___result=null;}catch(Exception e){}
				}
		  	*/
		  	}
		  i=2633;
		  
		  _sbr.append("*************************************************************************** <br><br>  \n");
		 }
		 }
		}
   
   		 i=27;
		  _sbr.append("BILLING INSTRUCTIONS <br>\r\n");
		  _sbr.append("==================== <br>\r\n");
		if(supl.equals("INT")){	
			//if(!wholeId.equals("-") && !afftCode.equals("AFF2")){ //ASA			
			if(!wholeId.equals("-")){ //ASA
				_sbr.append("* The deposit and booking fee have been charged to your card. This charge will appear on your statement as \"TSN HOTEL BOOKING\" <br>\r\n");
				_sbr.append("* The balance will be charged by "+arrWholeSellerDetails[0]+" (your accommodation provider) within 7 working days. This charge will appear on your statement as \""+arrWholeSellerDetails[0]+"\" <br>");
				//_sbr.append("" + __resFirstBundle.getString("EML_BillingMsg1_1") +" \r\n");
				_sbr.append("* Your CHECK-IN VOUCHER has been emailed to you. This confirms that your accommodation has been paid for in advance and must be presented upon arrival<br><br>\r\n");
				
				_sbr.append("CHECK-IN INSTRUCTIONS <br>\r\n");
				_sbr.append("=====================<br>\r\n");
				_sbr.append("* Check-in from: "+checkintime+"  <br>\r\n");
				_sbr.append("* Check-out by: "+checkouttime+" <br>\r\n");
			    _sbr.append("* The CHECK-IN VOUCHER must be presented upon arrival <br>\r\n ");
			    _sbr.append("* Special requests are sent to the accommodation but cannot be guaranteed.<br>\r\n"); 
			    _sbr.append("* Room pictures may differ from the actual room you receive.<br><br>\r\n");
			
			}else{
				_sbr.append("* The deposit and booking fee have been charged to your card. This charge will appear in your statement as \"TSN HOTEL BOOKING\" <br>\r\n");
				
				
				if (hotCode.equals("H1410")){
					_sbr.append("* Balance will be taken 10 days prior to the arrival date <br><br>\r\n");
				}else{
				
				if(wholeId.equals("WH1")){
				//_sbr.append("* Balance will be taken within 7 days prior to the arrival date <br><br>\r\n");
				_sbr.append("* Balance will be taken within 7 days of the booking date <br><br>\r\n");

				}else{
					if(afftCode.equals("AFF61")){
				_sbr.append("* Balance will be taken 7 days prior to the arrival date <br><br>\r\n");
					}else{
				_sbr.append("* The balance is payable to the accommodation upon arrival <br><br>\r\n");
					}
				}
				}
				_sbr.append("CHECK-IN INSTRUCTIONS <br>\r\n");
				_sbr.append("=====================<br>\r\n");
				_sbr.append("* Check-in from: "+checkintime+"  <br>\r\n");
				_sbr.append("* Check-out by: "+checkouttime+" <br>\r\n");
			    _sbr.append("* This confirmation must be presented upon arrival<br>\r\n ");
			    _sbr.append("* Students booking the discounted student rate must present student identification upon arrival  <br>\r\n");
			    _sbr.append("* Special requests are sent to the accommodation but cannot be guaranteed.<br>\r\n"); 
			    _sbr.append("* Room pictures may differ from the actual room you receive.<br><br>\r\n");
			}
		}else{
				_sbr.append("Your credit card will be charged in "+curr_code+" for the full amount of this transaction. <br>");
				if(supl.equals("INV8")){
				_sbr.append("The charge will appear under 'TravelNow.com'. \r\n");
				}else if(supl.equals("INV1")){
				_sbr.append("The charge will appear under 'CNGHotels.com'. \r\n");
				}
				_sbr.append("The converted rates displayed are for your convenience. <br>The conversion to your local currency on your statement may vary slightly<br><br>\r\n");
				_sbr.append("CHECK-IN INSTRUCTIONS <br>\r\n");
				_sbr.append("=====================<br>\r\n");
				_sbr.append("* Check-in from: "+checkintime+"  <br>\r\n");
				_sbr.append("* Check-out by: "+checkouttime+" <br>\r\n");
			    _sbr.append("* Your charge card will be charged for the full payment upon submitting your reservation request.<br>\r\n");
			    _sbr.append("* Requests for bed type and smoking preferences will be submitted to the hotel but are not guaranteed.<br>\r\n");
			    _sbr.append("* Room pictures may differ from the actual room you receive.<br>\r\n"); 
			    _sbr.append("* You must present a photo ID upon check-in. <br>\r\n");
			    _sbr.append("* These rates are only available through our websites and call centers and cannot be obtained by calling the hotel directly as they will not have our discounted rates in their system.<br><br>\r\n");

		}
					
				i=28;
				_sbr.append("\r\n");
				if(supl.equals("INT")){					
					_sbr.append("CANCELLATIONS AND MODIFICATIONS  <br>\r\n");
				    _sbr.append("=============================== <br>\r\n");
				   
//				    if(webSite.toUpperCase().equals("LONDONHOTELSITE")&&!afftCode.equals("RA")){
//					_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: "+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com<br>\r\n");
//				    }else{
//					_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: "+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com<br>\r\n");
//				    }
				    
					if(afftCode.equals("AFF65")){ // book travel n stay
					    _sbr.append("* Cancellations & modifications must be made using the following contact details: Tel: +44 (0) 1480 394138, Email AdvertisingOnline@TravelStayNetwork.com <br>\r\n");
					}else{
//						_sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) <br>\r\n");	
//					}	
//					_sbr.append("* Cancellations and modifications require 72 hours advance notice <br>\r\n");
//					_sbr.append("* Cancellations made within 72 hours of arrival and Non-Arrivals are charged for the first night's accommodation per 7 nights of stay<br>\r\n");
//					_sbr.append("* Deposits and booking fees are non-refundable for cancellations<br>\r\n");
//					_sbr.append("* Modifications are subject to availability and incur a charge of "+curr_code+" 10.00 for each new booking made.<br>\r\n");
//					_sbr.append("* Modifications involve making a new booking which will be charged at the lowest rate available at the time<br><br>\r\n");
//				    _sbr.append("\r\n");				
//				    _sbr.append("\r\n");
					_sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations) Modifications@TravelStayNetwork.com (for modifications) <br>\r\n");	
					}	
					_sbr.append("* Deposits and booking fees are non-refundable  <br>\r\n");
					_sbr.append("* Cancellations and modifications require 3 working days advance notice <br>\r\n");
					_sbr.append("* Cancellations made with sufficient notice will result in the loss of the deposit and booking fee only. <br>\r\n");
					_sbr.append("* Cancellations made within 3 working days of arrival and Non-Arrivals are also charged for the first night's accommodation in full per 7 nights of stay <br>\r\n");
					//_sbr.append("* Modifications result in the lower of the deposit values being refunded and incur a modification charge of "+curr_code+" 10.00 for each new booking made. <br>\r\n");
					_sbr.append("* Modifications result in the initial deposit being refunded, the new booking deposit charged and a "+curr_code+" 10.00 modification fee for each new booking made. <br>\r\n");
					
					_sbr.append("* Modifications involve making a new booking and are made at the lowest available rate at the time the modification is made<br>\r\n");
					_sbr.append("\r\n");				
				    _sbr.append("\r\n");


				    String whlNm="-";
				    /*if(!wholeId.equals("-")){
				    	whlNm=arrWholeSellerDetails[0].toString();	
				    }
				    if(afftCode.equals("AFF2")){
				    	Site="Travelstay";
				    }*/
					_sbr.append("Click here for the full booking policy: <br>\r\n");
					if(webSite.toUpperCase().equals("LONDONHOTELSAVINGS")){
						Site="Global Hotel Centre";
						_sbr.append("<a href=\"https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
					}else if(webSite.toUpperCase().equals("LONDONHOTELSITE")){
						Site="London Hotel Site";
						_sbr.append("<a href=\"https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
					}else if(webSite.toUpperCase().equals("TRAVELSTAY")){
						Site="TravelStay";
						_sbr.append("<a href=\"https://secure.travelstay.com/servlet/"+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.travelstay.com/servlet/"+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
					}
					_sbr.append("<br><br>\r\n");

			     }else{
			     	if(supl.equals("INV8")){
					_sbr.append("CANCELLATIONS AND MODIFICATIONS  <br>\r\n");
				    _sbr.append("=============================== <br>\r\n");
				    //_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com<br>\r\n");
   				    _sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) <br>\r\n");
			     	_sbr.append("* Cancellations and modifications are subject to a USD 25.00 charge.<br>\r\n");
			     	_sbr.append("* If cancellation occurs within 24 HOURS, a one-night charge will be assessed.<br>\r\n");
			     	_sbr.append("* No refunds will be made for no-shows or early checkouts.<br>\r\n");
			     	_sbr.append("* Please note that any changes in your reservation could result in charges applicable by policy and availability.<br>\r\n");
			     	_sbr.append("* In the event that collection efforts have to be made, by sending to an outside collections agency or turning over to an attorney, you will be responsible for all costs incurred to collect the above debt.<br>\r\n");

			     	//_sbr.append("Tel : "+ResPhone+"<br>\r\n");
			     	//_sbr.append("In the event that collection efforts have to be made, by sending to an outside collections agency or turning over to an attorney, you will be responsible for all costs incurred to collect the above debt. <br>\r\n");
			     	_sbr.append("<br>\r\n");
			     	}else if(supl.equals("INV1")){
					_sbr.append("CANCELLATIONS AND MODIFICATIONS  <br>\r\n");
				    _sbr.append("=============================== <br>\r\n");
				    _sbr.append("* Cancellations and modifications made up to 6pm on the date of arrival will incur a charge of $20.00.  <br>\r\n");
			     	_sbr.append("* If cancellation or modification is made after 6pm on the date of arrival, the payment is non-refundable <br>\r\n");
			     //	_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: +"+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com<br>\r\n");
			        _sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) <br>\r\n");
			     	_sbr.append("<br><br>\r\n");
			     	}
			     }
			     _sbr.append("\r\n");
		  		_sbr.append("**********************************************************************</b><br>\n");
//			    if(webSite.toUpperCase().equals("LONDONHOTELSITE")&&!afftCode.equals("RA")){
//			    _sbr.append("\"Thank you for your booking. Enjoy your stay!\"  <br>\r\n");
//			    }else{
//			    _sbr.append("\"Thank you for booking with "+Site+". Enjoy your stay!\"  <br>\r\n");
//			    }
				_sbr.append("\"Thank you for your reservation. Enjoy your stay!\"  <br>\r\n");

	    }else{
		  		_sbr.append("**********************************************************************<br>\n");
		  		if(supl.equals("INT")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" "+arrWholeSellerDetails[0]+" Limited <br>\r\n");
			    }else if(supl.equals("INV8")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" TravelNow Limited<br>\r\n");
			   	}else if(supl.equals("INV1")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" CNG Hotels Limited<br>\r\n");
			   	}
			   	
			   	i=30;
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT")+" <br>\r\n");
		  		_sbr.append("**********************************************************************<br>\n");
			    _sbr.append(""+__resFirstBundle.getString("VOUEML_thankYou1")+" <br>\r\n");
	    }				
			     
		  _sbr.append("</body>  \n");
		  _sbr.append("</html>  \n");
			//writeToLog("","End of generateCustomerNetCopyAce @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	
		}catch(Exception err){
			throw new Exception("Error in Generate Mail @ generateCustomerCommCopy  @ : at-"+i+" err "+ec+" ecc "+ecc+" "+err.toString());	
		}  
		return _sbr;	  
	
	}

	public StringBuffer generateCustomerNetCopy(ResourceBundle __resFirstBundle,ConfirmInfoHolder cinfo, String type,
			String[] arrWholeSellerDetails,String Source
			/*ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] _occuDetails,
			String[] arrWholeSellerDetails, String type, String supplierItaNo,
			String supplierHotConfNo, String[] afftParam, String Site,
			String Source, ResultSet rs, Connection ___conn,
			String cinfo.getBalancedays(), String cinfo.getImportant_info()*/
			
			) throws Exception {
			
		
		StringBuffer _sbr = new StringBuffer();
		int i=0;

		LoadSystemProperties sysProp = LoadSystemProperties.getInstance();

		String ResAgentName = sysProp.getProperty("ResAgentName").toString().trim();
		String SchemaName       = sysProp.getProperty("SchemaName").toString().trim();
		
		String ServletUrlBack   = sysProp.getProperty("ServletUrlBack").toString().trim();
		
		String PolicyUrl= sysProp.getProperty("Policy_Url").toString().trim();

		String _htmlUrl =sysProp.getProperty("HtmlUrlCardiff").toString().trim(); //AFF122
		
		String _affUrl=sysProp.getProperty("Policy_Location").toString().trim();
					
		String afftCode="RA";
		String bookNo  ="";
		String supl	   ="INT";
		String wholeId ="";
		String hotName ="";
		String hotAdd  ="";
		String hotCity ="";
		String hotZip  ="";;
		String moreInfo  ="";;
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
		String RadsNightRate="";;
		double totCharge=0;
		double bookFee=0;
		double radsBookFee=0;
		double totPay=0;
		double deposit=0;
		double balance=0;
		String ec=" ";
		double ecc=0.00;
		String hotcontract="";
		String roomType="";
		String hotPhone = "-";
		String hotCode="";
		String checkintime = "";
		String checkouttime = "";
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		String DEPOSIT_TYPE = null;
		String  WS_TERMZ = "";
		String  cancelpolicybefore = "0";
		
		
//		Variable Assignment For Date Format Change in Multi Lingual
//		++++++++++++++++++++++++++++++++++
		 String[] __dayOfWeekdisp={__resFirstBundle.getString("Day_0"),__resFirstBundle.getString("Day_1"),
					__resFirstBundle.getString("Day_2"),__resFirstBundle.getString("Day_3"),
						__resFirstBundle.getString("Day_4"),__resFirstBundle.getString("Day_5"),
						__resFirstBundle.getString("Day_6")};  
		
		 
		 
		 String[] __monthdisp={    __resFirstBundle.getString("Month_0"),__resFirstBundle.getString("Month_1"),
					__resFirstBundle.getString("Month_2"),__resFirstBundle.getString("Month_3"),
						__resFirstBundle.getString("Month_4"),__resFirstBundle.getString("Month_5"),
						__resFirstBundle.getString("Month_6"),__resFirstBundle.getString("Month_7"),
						__resFirstBundle.getString("Month_8"),__resFirstBundle.getString("Month_9"),
						__resFirstBundle.getString("Month_10"),__resFirstBundle.getString("Month_11")};			
		
		 String LangCheckin =null;
		 String LangCheckout =null;
//		++++++++++++++++++++++++++++++++++		
		
		
			
		
		
		
		
//		System.out.println("GenerateCustomerNetCopy--------------------------3");
  		Statement 		___stmt=null;
  		ResultSet ___result=null;
  		
  		String langCode=null;
  		String countryCode=null;
  		
  		try{
  		  langCode=cinfo.getLanguage().toString();
  		  countryCode=cinfo.getCountry().toString();
  		}catch(Exception e){}
  		
  		String discountType = "NONE"; //TSTAY - 322
  		
		
//  	----------------- To Check if the affiliate is a common affiliate---------------
		PreparedStatement  pstmt_aff  = null;
		ResultSet rs_aff    = null;
		String is_common_aff="";
												
		
  		
		//writeToLog("","Start of generateCustomerNetCopyAce @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	
//		System.out.println("GenerateCustomerNetCopy--------------------------4");
		i=1;
		try{
			if (!cinfo.getDiscounttype().toString().equals("NONE")){
				if (cinfo.getDiscounttype().toString().equals("PRIOR")){
					discountType=__resFirstBundle.getString("MailPriorToArivalDiscount");
				}else if (cinfo.getDiscounttype().toString().equals("NONUK")){
					discountType=__resFirstBundle.getString("MailNonUKDiscount");
				}else if (cinfo.getDiscounttype().toString().equals("GROUP")){
					//discountType="Group discount";
					discountType=__resFirstBundle.getString("MailGroupDiscount");
											
				}else if (cinfo.getDiscounttype().toString().equals("STUDENT")){
					discountType=__resFirstBundle.getString("MailStudentDiscount");
				}else if (cinfo.getDiscounttype().toString().equals("LONGSTAY")){
					discountType=__resFirstBundle.getString("MailLongstayDiscount");
				}
			}else{
				discountType=__resFirstBundle.getString("MaliNone");
			}
		
		
			
			i=-1;
			/*if(webSite.equals("TravelStay")){
				currencyName 	=_reqDetails[110].toString();
				curr_htmlcode 	=_reqDetails[111].toString();
				curr_code 		=_reqDetails[112].toString();
				curr_symbol		=_reqDetails[113].toString();
				cancelpolicybefore = _reqDetails[127].toString();
				is_common_aff= _reqDetails[128].toString();
			}*/
				
//			System.out.println("GenerateCustomerNetCopy--------------------------5");
			
			/*afftCode=_reqDetails[64].toString();
			ec=ec+",\r\n afftCode="+afftCode;*/
			i=-2;	
			bookNo  =cinfo.getBooking_no();
			ec=ec+",\r\n bookNo="+bookNo;
			/*i=-3;
			try{
				supl	=_reqDetails[131].toString();
				ec=ec+",\r\n supl="+supl;
			}catch(Exception e){}
			i=-4;
			wholeId =_reqDetails[95].toString();*/
			i=-5;
			ec=ec+",\r\n wholeId="+wholeId;
			hotName =cinfo.getHotelName().toString();
			ec=ec+",\r\n hotName="+hotName;
			i=-6;
			
			hotAdd  =cinfo.getHotelAddress().toString();
			ec=ec+",\r\n hotAdd="+hotAdd;
			i=-7;
			hotCity =cinfo.getHotelcity().toString();
			ec=ec+",\r\n hotCity="+hotCity;
			i=-8;
//			hotZip  =_reqDetails[50].toString();
			ec=ec+",\r\n hotZip="+hotZip;
			i=-9;
			hotPhone  =cinfo.getHotelphone().toString();
			ec=ec+",\r\n hotPhone="+hotPhone;
			i=-10;
			multbook =cinfo.getBooktype();
			ec=ec+",\r\n multbook="+multbook;
			/*moreInfo  =_reqDetails[92].toString();
			ec=ec+",\r\n moreInfo="+moreInfo;
			i=-11;
			
			i=-12;*/
			
//			System.out.println("GenerateCustomerNetCopy--------------------------6");
			
			bedTydesc =cinfo.getBedName().toString();// if multiple format is - bed1|@|bed2
			ec=ec+",\r\n bedTydesc="+bedTydesc;
			i=-13;
			
//			System.out.println("GenerateCustomerNetCopy--------------------------7"+cinfo.getBedName().toString());
			
			chkInDate =cinfo.getShowCheckdate().toString();
			ec=ec+",\r\n chkInDate="+chkInDate;
			i=-14;
			chkOutdate =cinfo.getShowCheckoutdate().toString();
			ec=ec+",\r\n chkOutdate="+chkOutdate;
			i=-15;
			/*if (!langCode.equals("en")){
				LangCheckin=_reqDetails[118].toString();
				i=-35;
				LangCheckout=_reqDetails[119].toString();
				i=-36;
			}*/
			
			noNight =cinfo.getNoOfnights().toString();
			ec=ec+",\r\n noNight="+noNight;
			i=-16;
//			mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
			ec=ec+",\r\n mealPlan="+mealPlan;
			
			i=-17;
//			radsBdTyp =_reqDetails[61].replace ('`',',');
			ec=ec+",\r\n radsBdTyp="+radsBdTyp;
			i=-18;
			noPeople =Integer.parseInt(cinfo.getNoOfAdults());//((Integer.parseInt(cinfo.getNoOfAdults()))-(Integer.parseInt(_reqDetails[90])));
			ec=ec+",\r\n noPeople="+noPeople;
			i=-19;
//			spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			ec=ec+",\r\n spcReq="+spcReq;
			i=-20;
//			timeArr=cinfo.get.toString();
			ec=ec+",\r\n timeArr="+timeArr;
			i=-21;
			adltRtByBtyp=cinfo.getAdltRtByBtyp(); // if multiple format is - 78@79
			ec=ec+",\r\n adltRtByBtyp="+adltRtByBtyp;
//			i=-22;
//			stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
//			ec=ec+",\r\n stdRtByBtyp="+adltRtByBtyp;
			i=-23;
			try{
			//RadsNightRate=_reqDetails[129].substring(0,_reqDetails[129].lastIndexOf("|")-1);
//			ec=ec+",\r\n _reqDetails[129]="+_reqDetails[129];
//			RadsNightRate=_reqDetails[129].replace('|',',');
			ec=ec+",\r\n RadsNightRate1="+RadsNightRate;
			i=-24;
			RadsNightRate=RadsNightRate.substring(0,RadsNightRate.lastIndexOf(",")-1);
			ec=ec+",\r\n RadsNightRate2="+RadsNightRate;
			i=-25;
			}catch(Exception e){}
			ec=ec+",\r\n cinfo.getTotalpayment()="+cinfo.getTotalpayment();
//			ec=ec+",\r\n _reqDetails[102]="+_reqDetails[102];
//			totCharge=(Double.parseDouble(cinfo.getTotalpayment())-Double.parseDouble(_reqDetails[102]));
			ec=ec+",\r\n totCharge="+totCharge;
			i=-26;
			bookFee=Double.parseDouble("0.0");
			ec=ec+",\r\n bookFee="+bookFee;
			i=-27;
			/*try{
			ec=ec+",\r\n cinfo.getPaynow()="+cinfo.getPaynow();	
			ec=ec+",\r\n _reqDetails[142]="+_reqDetails[142];	
			radsBookFee=Double.parseDouble(cinfo.getPaynow())-Double.parseDouble(_reqDetails[142]);
			ec=ec+",\r\n radsBookFee="+radsBookFee;
			i=-28;
			}catch(Exception e){i=-288888;ec=ec+" 28 "+e.toString();}*/
			i=-29;
			ec=ec+",\r\n cinfo.getTotalpayment()="+cinfo.getTotalpayment();
			totPay=Double.parseDouble(cinfo.getTotalpayment());
			ec=ec+",\r\n totPay="+totPay;
			i=-30;
			deposit=Double.parseDouble(cinfo.getPaynow());
			ec=ec+",\r\n deposit="+deposit;
			i=-31;
			balance=Double.parseDouble(cinfo.getBalance());
			ec=ec+",\r\n balance="+balance;
			i=-32;
			/*if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
				ec=ec+",\r\n Site="+Site;
			}*/
			i=-33;
			roomType=cinfo.getRoomname().toString();
			ec=ec+",\r\n roomType="+roomType;
			i=-34;
			hotCode=cinfo.getHotelCode().toString();
			ec=ec+",\r\n hotCode="+hotCode;
			
//			System.out.println("GenerateCustomerNetCopy--------------------------10");
			i=-35;
			/*try{
			checkintime=_reqDetails[65].toString();
			ec=ec+",\r\n checkintime="+checkintime;
			i=-36;
			checkouttime=_reqDetails[66].toString();
			ec=ec+",\r\n checkouttime="+checkouttime;
		
			i=-37;
			}catch(Exception er){
			i=-38;	
			checkintime="00:00";
			checkouttime="23:59";
			i=-39;	
			}*/
			
		
//		System.out.println("GenerateCustomerNetCopy--------------------------11");
		//writeToLog("","After putting data generateCustomerNetCopyAce__1 @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	

		
//		try{
			i=4;
		  _sbr = new StringBuffer();				     		
		  _sbr.append("<html>\n");
		  _sbr.append("<body>\n");
		  _sbr.append("<form name=form1>\n");
		  _sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  _sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  _sbr.append("</form>\n");
 		  
		  if(type.equals("EMAIL")){
		  	if(supl.equals("INT")){
		  		_sbr.append("<font face='Courier New' size=2> \r\n");
		  		if (langCode.equals("en")){
					_sbr.append(""+__resFirstBundle.getString("MailAutomated")+" \r\n");	
				}else{
		  			_sbr.append("**"+__resFirstBundle.getString("MailAutomated")+"**<br> \r\n");	
		  		}
		  		
		  		if(wholeId.equals("-") || afftCode.equals("AFF2")|| wholeId.equals("WH5")){
				_sbr.append(" <br> \r\n");
				_sbr.append(""+__resFirstBundle.getString("MailPrintHotel")+" <br>\r\n");
		  		}
				_sbr.append(""+__resFirstBundle.getString("MailPrintHotelLine")+" <br>\r\n");
				if (!langCode.equals("en")){
					_sbr.append(""+__resFirstBundle.getString("MailNotForVisa")+" <br><br> \r\n");
				}
								
				//_sbr.append("Thank you for your reservation, your TravelStay Network reference number is "+bookNo+". <br><br>\r\n");
				if (langCode.equals("en")){
					_sbr.append(""+__resFirstBundle.getString("MailTSNThankReservation")+" "+bookNo+". <br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("MailPrintHotelLine")+" <br><br>\r\n");				
				}else{
					_sbr.append(""+__resFirstBundle.getString("MailTSNThankReservation")+" "+bookNo+". <br><br>\r\n");
				}
				if(afftCode.equals("AFF2")){
					_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailLnetServices")+"<br>\r\n");
					_sbr.append("<font face='Courier New' size=2><a href=\""+__resFirstBundle.getString("MailATUrl")+"\">"+ __resFirstBundle.getString("MailAirportTransfers")+"</a><br>\r\n");
				    _sbr.append("<font face='Courier New' size=2><a href=\""+__resFirstBundle.getString("MailTCUrl")+"\">"+ __resFirstBundle.getString("MailTravelCards")+"</a><br>\r\n");
				    _sbr.append("<font face='Courier New' size=2><a href=\""+__resFirstBundle.getString("MailCUrl")+"\">"+ __resFirstBundle.getString("MailChauffeurs")+"</a><br>\r\n");
				    _sbr.append("<font face='Courier New' size=2><a href=\""+__resFirstBundle.getString("MailTTUrl")+"\">"+ __resFirstBundle.getString("MailTheatreTickets")+"</a><br>\r\n");
				    _sbr.append("<font face='Courier New' size=2><a href=\""+__resFirstBundle.getString("MailLAUrl")+"\">"+ __resFirstBundle.getString("MailLondonAttract")+"</a><br>\r\n");
				}				
			}else{
				_sbr.append("<font face='Courier New' size=2> \r\n");		  		
				_sbr.append("**"+__resFirstBundle.getString("MailAutomated")+"**<br> \r\n");	
				_sbr.append("<font face='Courier New' size=2>*******************************************************************<br>\r\n");
				if(wholeId.equals("-") || afftCode.equals("AFF2")|| wholeId.equals("WH5")){
					_sbr.append(" <br> \r\n");
					_sbr.append(""+__resFirstBundle.getString("MailPrintHotel")+" <br>\r\n");
				}
				
				
//				System.out.println("Gen..........3");
				
				_sbr.append("*******************************************************************<br>\r\n");
				_sbr.append("\r\n");
//				System.out.println("Gen..........4");
		  		_sbr.append("<font face='Courier New' size=2> \r\n");
//		  		_sbr.append("This confirmation is not valid for visa or immigration purposes <br> \r\n");			
		  	//	_sbr.append("********************************************************************<br><br>\r\n");  		
			
//				_sbr.append("Thank you for booking with "+Site+".<br>\r\n");
//				if(supl.equals("INV8")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is Hotels.com/"+supplierHotConfNo+"<br><br>\r\n");
//				}else if(supl.equals("INV1")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is CNG/"+supplierItaNo+"<br><br>\r\n");
//				}
				
		  		
//		  		_sbr.append("This confirmation is not valid for visa or immigration purposes. <br><br> \r\n");	
//				_sbr.append("Thank you for your reservation, your reference number is "+bookNo+". <br><br>\r\n");
//		  		
		  		
		  		_sbr.append(""+__resFirstBundle.getString("MailNotForVisa")+" <br><br> \r\n");
		  		
		  		
//		  		System.out.println("Gen..........5....1");
		  		_sbr.append(""+__resFirstBundle.getString("MailThankReservation")+" <br><br> \r\n");
		  		
//		  		System.out.println("Gen..........5");
				

//		  		System.out.println("Gen4...");
			
			}
		 }else{
		 	i=5;
		 	if(supl.equals("INT")){
			  if(!wholeId.equals("-")){
				_sbr.append("\r\n");
				_sbr.append("<font face='Courier New' size=2>*******************************************************************<br>\n");
			//	_sbr.append(""+__resFirstBundle.getString("VouHead")+" "+arrWholeSellerDetails[0]+" "+arrWholeSellerDetails[5]+"<br> \n");
				_sbr.append(""+__resFirstBundle.getString("VouHead")+" "+arrWholeSellerDetails[0]+"<br> \n");

				_sbr.append("******************************************************************* <br><br>  \n");
				
				
				//_sbr.append("HOTEL BOOKING PROVIDER<br>\r\n");
				
				_sbr.append(""+__resFirstBundle.getString("MailHotProvider")+" <br><br> \r\n");
				
				_sbr.append("====================== <br>\r\n");	
				_sbr.append(""+arrWholeSellerDetails[0]+" <br>\r\n");
				_sbr.append(""+arrWholeSellerDetails[5]+","+arrWholeSellerDetails[6]+" "+arrWholeSellerDetails[7]+" "+arrWholeSellerDetails[9]+"<br>\r\n");
				_sbr.append("" +__resFirstBundle.getString("Phone")+": "+arrWholeSellerDetails[1]+" <br>\r\n");				    			    
				_sbr.append("" +__resFirstBundle.getString("Email")+": "+arrWholeSellerDetails[3]+" <br><br>\r\n");				    			    			    		
			  }else{
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_Voucher_Head")+"<br>  \n");
			  _sbr.append("**********************************************************************<br>\n");
			  }
			}else{
			  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("EML_Voucher_Head")+"<br>  \n");
			  _sbr.append("**********************************************************************<br>\n");
			}
		}
//			System.out.println("Gen6....");
		  
          i=6;
		  //_sbr.append("<font face='Courier New' size=2>HOTEL INFORMATION<br>\r\n");
		  
        _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailHotInfo")+"<br>\r\n");
	
	      _sbr.append(""+hotName+" <br>\r\n");
	      String hotAddMail=hotAdd;
	      hotAddMail=hotAddMail.substring(0,hotAddMail.lastIndexOf(" "));
		  _sbr.append(""+hotAddMail.trim()+", <br>\r\n");		  
	      _sbr.append(""+hotCity+" "+hotZip+".<br>\r\n");
	      
	      if(supl.equals("INT")){
	     // _sbr.append("Phone: "+hotPhone+"<br>\r\n");				    			    
	      
	      _sbr.append(""+__resFirstBundle.getString("MailPhone")+" "+hotPhone+"<br>\r\n");
	      
	      
	      }else{
	    	  
	      //_sbr.append("Phone: +44 (0)870 922 4100<br>\r\n");				    			    
	     
	     _sbr.append(""+__resFirstBundle.getString("MailPoneWithNo")+"<br>\r\n");
	     
	      }	
//	  	System.out.println("Gen7");
	      
	      if(!type.equals("EMAIL") && wholeId.equals("WH1")){
	      	  _sbr.append("<br>\r\n");
    		  _sbr.append(""+__resFirstBundle.getString("MailCheckinfrom")+checkintime+"  <br>\r\n");
    		  _sbr.append(""+__resFirstBundle.getString("MailCheckoutby")+checkouttime+"  <br>\r\n");
    		  _sbr.append("<br>\r\n");
		  }	    			    
		  if(type.equals("EMAIL")){
			_sbr.append(""+__resFirstBundle.getString("MailMoreInfo")+":&nbsp;<br> <a href=\""+moreInfo+"\">"+moreInfo+"</a>  <br>\n");
 		  }
		  if(cinfo.getImportant_info() != null && type.equals("EMAIL")){
			  _sbr.append("<p><font face='Courier New' size=2>"+__resFirstBundle.getString("MailImpInfo")+"<br>  \n"); 
			  _sbr.append(""+cinfo.getImportant_info()+"\r\n");
			  _sbr.append("<br>\r\n");
		  } 
		  _sbr.append("</p>  \n");
		  _sbr.append("<p><font face='Courier New' size=2>");
		  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");

		  if(type.equals("EMAIL")){
			  _sbr.append("<tr>");	 
		      _sbr.append("<td colspan='3'>\n");
			  _sbr.append("</td>");
		      _sbr.append("</tr>");
			  _sbr.append("<tr>");	 
		      _sbr.append("<td colspan='3'><font face='Courier New' size=2>"+__resFirstBundle.getString("MailBookingSummaryTitle")+"\n");
			  _sbr.append("</font></td>");
		      _sbr.append("</tr>");
			  
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailBookingNo")+"");
		  _sbr.append("</font></td>");
		  
	      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailBookinNoSpace")+"");
	      _sbr.append("</font></td>");
	      
	      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append(""+" "+bookNo+" <br>  \n");
	      _sbr.append("</font></td>");
	      _sbr.append("</tr>");
		  }
		  
		  i=7;
		  if(supl.equals("INT")){
			
				int bedTyps=0; 
//				if(multbook.equals("S")){
				bedTyps=1;
//				}else{
//				bedTyps=2;
//				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				i=8;
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
				StringTokenizer bedTypeDisc = null;
				System.out.println(bedTydesc);
				bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
				i=9; 
				while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
				}
				bedTypeDisc=null;
				
//				System.out.println("5---------------------------");
				i=10;
				
		
				
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg222					
					//_sbr.append(""+__resFirstBundle.getString("HotelName")+__resFirstBundle.getString("MailHotelNameSpace")+" "+hotName+"<br>  \n");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("HotelName")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailHotelNameSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+" "+hotName+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>");
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg222				  
								
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg3333				
				//_sbr.append(""+__resFirstBundle.getString("MailRoomType")+__resFirstBundle.getString("MailRoomTypeSpace")+"  \r\n");
			      _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRoomType")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRoomTypeSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			     				
				while(bedTyps>bedTypscount){//arrbedType
					i=11;
					System.out.println("arrbedTypeDisc[bedTypscount] >>"+arrbedTypeDisc[bedTypscount]);
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					i=12;
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					i=13;
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}else{
							_sbr.append(""+__resFirstBundle.getString("MailRoomTypeSp1")+"\n");
							_sbr.append(" "+__resFirstBundle.getString("MailRoomTypeSp2")+"\n");
							_sbr.append(" "+__resFirstBundle.getString("MailRoomTypeSp3")+""+rmNo+" x "+roomType+" - "+bedType+" \n");
						}
					}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
					}
					bedTypscount+=1;
				}
				i=13;
				arrbedTypeDisc=null;
			  	_sbr.append("<br>  \n");
			  	
			  	
			  	 _sbr.append("</font></td>");
			     _sbr.append("</tr>");
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg3333	
			  	
			  	
			  	
			  	
			  	if(langCode.equals("en")){	
			  		_sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailCheckInDateSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+" "+chkInDate+"<br>  \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>");
				      
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailNoDaySpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+noNight+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+chkOutdate+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>");
			      
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg4444
			  	}else if(langCode.equals("it")){
					 _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailCheckInDateSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+LangCheckin+"<br>  \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>");
					 _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+chkOutdate+"<br>  \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
					 _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+LangCheckout+"<br>  \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
					 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg55555			 
			  	}else{
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg6666		  		
				//  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+""+__resFirstBundle.getString("MailCheckInDateSpace")+" "+LangCheckin+"<br>  \n");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailCheckInDateSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+LangCheckin+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
			      
			      
				//  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+""+__resFirstBundle.getString("MailNoDaySpace")+" "+noNight+"<br>  \n");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailNoDaySpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+noNight+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
			      
			      
			      
			      
				 // _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+""+__resFirstBundle.getString("MailCheckOutDateSpace")+" "+LangCheckout+"<br>  \n");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+LangCheckout+"<br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
			  	}
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoGuest")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoGuestSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+noPeople+" <br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailMealPlan")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailMealPlanSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+mealPlan.replaceAll("~","`")+" <br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg88888				
//			  System.out.println("7---------------------------");
			  
			 // _sbr.append("<p>  \n");
		  }else{
		  	i=14;
		  	if(supl.equals("INV8")){
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRefNo")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRefNoSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
//				  _sbr.append(""+supplierHotConfNo+" <br>  \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
		  	}else{
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailItinNo")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(":&nbsp;");
		      _sbr.append("</font></td>");
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
		      
		  	}
		  	 _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailAccName")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+ __resFirstBundle.getString("MailAccNameSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+hotName+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailBedType")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailBedtypeSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+radsBdTyp+" <br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
			  if(langCode.equals("en")){
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailCheckInDateSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+chkInDate+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoDaySpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+noNight+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+chkOutdate+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      		
		      

			  }else{
			 _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailCheckInDateSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+LangCheckin+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoDaySpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+noNight+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      	
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailCheckOutDateSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+LangCheckout+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      	
			  }
	
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoPeople")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoPeopleSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+noPeople+" Adult/s<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailMealPlan")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailMealPlanSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+mealPlan.replaceAll("~","`")+" <br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      	
		      

		  
		  
		  
		  }
///xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		  //_sbr.append("=========================<br>  \n");
		  i=15;
		   
		  
		  
//		  System.out.println("8---------------------------");
		  
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg99999999			  
		  /*String occLen=""+_occuDetails.length+"";
		  for(int _i=0;_i<_occuDetails.length;_i++){
		  	if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
		  		//_sbr.append("Guest "+(_i+1)+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+_occuDetails[_i]+"<br>\n");
		  		if(_occuDetails[_i] != null){  //____AMILA TSN-517____
		  		//_sbr.append(""+__resFirstBundle.getString("MailGuest")+(_i+1)+" "+__resFirstBundle.getString("MailGuestTSSpace")+""+_occuDetails[_i]+"<br>\n");
		  		 _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailGuest")+(_i+1)+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailGuestTSSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+_occuDetails[_i]+"<br>\n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
			      
		  		}else{
		  			_sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailGuest")+(_i+1)+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailGuestTSSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+"- <br>");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
		  		}
		  		
		  	}else{
		  		if(_occuDetails[_i] != null){  //____AMILA TSN-517____
		  		  //_sbr.append(""+__resFirstBundle.getString("MailRoom")+(_i+1)+" "+__resFirstBundle.getString("MailRoomSpace")+" "+_occuDetails[_i]+"<br>\n");
		  		  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRoom")+(_i+1)+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRoomSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+_occuDetails[_i]+"<br>\n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
			      
			      
			      
		  		}else{
		  			// _sbr.append(""+__resFirstBundle.getString("MailRoom")+(_i+1)+" "+__resFirstBundle.getString("MailRoomSpace")+"- <br>");
		  			_sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailRoom")+(_i+1)+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailRoomSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+"- <br>");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
		  		}
		  			
		  	}
		  }*/
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg99999999	
		  
		  i=16;	
		 // _sbr.append("<p> \n");
		  
		  if(supl.equals("INT")){
			  
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg1010101010
			 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+""+__resFirstBundle.getString("MailSpecialRequestsSpace1")+" "+spcReq+"    <br>\n");
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("SpecialRequests")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailSpecialRequestsSpace1")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+spcReq+"    <br>\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg1111aaaaaaaaaa			  
			  //_sbr.append("<font face='Courier New' size=2>Time of arrival &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+timeArr+"    \n");
			  if(langCode.equals("en")){
			 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+timeArr+"    \n");
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+timeArr+"    \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
		      
			  }else
			  {
				  if(timeArr.equals("Morning")){
					 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimmor")+"    \n");
					  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimmor")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else if (timeArr.equals("Midday")){
					  //_sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimmit")+"    \n");
					  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimmit")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else if (timeArr.equals("Afternoon")){
					 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimnach")+"    \n");
					  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimnach")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else if (timeArr.equals("Evening")){
					 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimabend")+"    \n");
					  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimabend")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else if (timeArr.equals("After 10pm")){
					 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimnch10")+"    \n");
					  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimnch10")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else if (timeArr.equals("After midnight")){
			    	 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+__resFirstBundle.getString("Mailarrivaltimnch")+"    \n");
			    	  _sbr.append("<tr>");	 
				      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
					  _sbr.append("</font></td>");
					  
				      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
				      _sbr.append("</font></td>");
				      
				      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
					  _sbr.append(""+__resFirstBundle.getString("Mailarrivaltimnch")+"    \n");
				      _sbr.append("</font></td>");
				      _sbr.append("</tr>"); 
				      
				  }else{
				 // _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("MailTimeOfArrival")+__resFirstBundle.getString("MailTimeOfArrivalSpace")+" "+timeArr+"    \n");
				  _sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrival")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailTimeOfArrivalSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+timeArr+"    \n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
				  }
			      
			  }
		 }else{
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg1111aaaaaaaaaa
			//  _sbr.append("<font face='Courier New' size=2>"+__resFirstBundle.getString("SpecialRequests")+""+__resFirstBundle.getString("MailSpecialRequestsSpace1")+" "+spcReq+"    <br><br>\n");
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("SpecialRequests")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailSpecialRequestsSpace1")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+spcReq+"    <br><br>\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ggg1111aaaaaaaaaa
		 }
		 
		  
		  
		  ///////////gggg111111/////////////////////////////
		  _sbr.append("</table>");  
		 _sbr.append("</p>  \n");
		 if(type.equals("EMAIL")){
		  //_sbr.append("<p><font face='Courier New' size=2>PAYMENT DETAILS<br>  \n");
			 _sbr.append("<p><font face='Courier New' size=2>\n");
		  
		 // _sbr.append("<p><font face='Courier New' size=2>"+__resFirstBundle.getString("MailPaymentDetailTitle")+"<br>  \n");
		  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
		  
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr11111
		  _sbr.append("<tr height = '10px'>");	 
	      _sbr.append("<td colspan='3'>\n");
		  _sbr.append("</td>");
	      _sbr.append("</tr>");
	      
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>"+__resFirstBundle.getString("MailPaymentDetailTitle")+"<br>  \n");
		  _sbr.append("</font></td>");
		  _sbr.append("</tr>"); 
		  
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("mailCurrency")+"");
		  _sbr.append("</font></td>");
		  
	      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailCurrencySpace")+"");
	      _sbr.append("</font></td>");
	      
	      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append(""+curr_code+" ("+currencyName+")<br>  \n");
	      _sbr.append("</font></td>");
	      _sbr.append("</tr>"); 
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDiscountType")+"");
		  _sbr.append("</font></td>");
		  
	      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDiscountTypeSpace")+"");
	      _sbr.append("</font></td>");
	      
	      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append(""+discountType+"<br>  \n");
	      _sbr.append("</font></td>");
	      _sbr.append("</tr>"); 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr222222222	 		  
		  //++++++++++++++++++++++++++++++++++++
		  		  
		  
		  if(supl.equals("INT")){
		  			  	
			i=17;
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
			
			ec=ec+"<BR> adltRtByBtyp-"+adltRtByBtyp+" stdRtByBtyp-"+stdRtByBtyp+" multbook-"+multbook;
			i=18;
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
			
			i=19;
			countval=0;
			/*StringTokenizer studRtBedtyp = new StringTokenizer(stdRtByBtyp,"@");
			while(studRtBedtyp.hasMoreElements()){
			arrStudRtBedtyp[countval]=studRtBedtyp.nextElement().toString();	
			if(multbook.equals("S")){
			break;
			}
			countval+=1;
			}
			studRtBedtyp=null;*/
			
			System.out.println("bedTydesc333333 >>"+bedTydesc);
			System.out.println("bedTyps >"+bedTyps+"bedTypscount"+bedTypscount);
			
			i=20;
			countval=0;
			StringTokenizer bedTypeDisc = null;
			System.out.println("bedTydesc >>"+bedTydesc);
			ec=ec+"<BR>"+bedTydesc;
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
			System.out.println("ec >>"+ec);

			i=21;
			String bedType="";
			String rmNo="";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
			_sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNightlyRoomRate")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNightlyRoomRateSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");			
			while(bedTyps>bedTypscount){//arrbedType
				rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
				bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			i=22;
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
				System.out.println("9---------------------------err"+err.toString());
			}
			
//			System.out.println("9---------------------------11.1");
			
			i=23;
			ec=ec+"<BR>"+arrAdultRtBedtyp[bedTypscount]+"-"+arrStudRtBedtyp[bedTypscount]+"-"+rmNo;
//			yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			i=230;
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append(" "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" \n");
				}else{
					i=2311;
					_sbr.append(""+__resFirstBundle.getString("MailBedtypeSpace1")+"\n");
					i=2322;
					_sbr.append(""+__resFirstBundle.getString("MailBedtypeSpace2")+"\n");
					i=2333;
					_sbr.append(" "+__resFirstBundle.getString("MailBedtypeSpace3")+""+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+" \n");
				}
			}else if(bedTyps==2 && bedTypscount==0){
				i=2344;
				_sbr.append("  "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"  \n");
			}
			i=234455;
			bedTypscount+=1;
			}
//			  System.out.println("9---------------------------22");
			i=24;
			_sbr.append("<br>");
			
			_sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
//		    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr33333333333333333	
		      
		      
		      
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
		  	
			  
		  }else{		  	
		  	i=249999999;
		  	try{	
		  	StringTokenizer	rtPerNite = new StringTokenizer(RadsNightRate.substring(0,RadsNightRate.lastIndexOf("|")),"|");	
		  	String[] arrRt=new String[Integer.parseInt(noNight)+1];
		  		
		  	String ratePN="";
		  	int count=0;
		  	
	
		  	
		  	
		  	while(rtPerNite.hasMoreElements()){
		  		 _sbr.append("<tr>");	
				if(count==0){
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailRatepernight")+"");
				  _sbr.append("</font></td>");
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailNightlyRoomRateSpace")+"");
			      _sbr.append("</font></td>");
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+rtPerNite.nextElement().toString()+" <br>\r\n");
			      _sbr.append("</font></td>");
				}else{
				_sbr.append("<td></td>"); //(TSTAY-956)
				_sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailNightlyRoomRateSpace")+"");
			      _sbr.append("</font></td>");
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+rtPerNite.nextElement().toString()+" <br>\r\n");
			      _sbr.append("</font></td>");
			    
				}
				count+=1;
				  _sbr.append("</tr>"); 
			}
			}catch(Exception e){
			  _sbr.append(""+__resFirstBundle.getString("MailRatepernight")+""+__resFirstBundle.getString("MailNightlyRoomRateSpace")+"  "+RadsNightRate+" <br>\r\n");
				
			}		  
		  }
		  
		  i=25;
		  NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumFractionDigits(2);
          nf.setMaximumFractionDigits(2);
//		  System.out.println("9---------------------------33");
          
          
		  if(supl.equals("INT")){
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"");
			  _sbr.append("</font></td>");
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailNoOfNightsSpace")+"");
		      _sbr.append("</font></td>");
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+noNight+"<br>  \n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		  	  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("totAccCharge")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailtotAccChargeSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+curr_code+" "+nf.format(totCharge)+" <br>\r\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		  	if (!langCode.equals("en")){
		  		_sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("bookCrFee")+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailbookCrFeeSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+curr_code+" "+nf.format(bookFee)+" <br>\r\n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr6666666666666
		  	}else{
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr7777777777777
		  		//_sbr.append(""+__resFirstBundle.getString("bookCrFee")+"s "+__resFirstBundle.getString("MailbookCrFeeSpace")+"  "+curr_code+" "+nf.format(bookFee)+" <br>\r\n");
		  		_sbr.append("<tr>");	 
			      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("bookCrFee")+"s "+"");
				  _sbr.append("</font></td>");
				  
			      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
				  _sbr.append(""+__resFirstBundle.getString("MailbookCrFeeSpace")+"");
			      _sbr.append("</font></td>");
			      
			      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
				  _sbr.append(""+curr_code+" "+nf.format(bookFee)+" <br>\r\n");
			      _sbr.append("</font></td>");
			      _sbr.append("</tr>"); 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr7777777777777
		  	}	   
		  	_sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTotalpayable")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTotalpayableSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+curr_code+" "+nf.format(totPay)+" <br>\r\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("</table>"); 
		      
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr7777777777777		  		  
		  
		  }else{
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTaxChargeFee")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailbookCrFeeSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+curr_code+" "+nf.format(radsBookFee)+" <br>\r\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
		      
			 // _sbr.append(""+__resFirstBundle.getString("MailTotalAmount")+""+__resFirstBundle.getString("MailTotalpayableSpace")+" "+curr_code+" "+nf.format(totPay)+" <br>\r\n");
			  _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTotalAmount")+"");
			  _sbr.append("</font></td>");
			  
		      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTotalpayableSpace")+"");
		      _sbr.append("</font></td>");
		      
		      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
			  _sbr.append(""+curr_code+" "+nf.format(totPay)+" <br>\r\n");
		      _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      
		      
		      _sbr.append("<tr>");	 
		      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  _sbr.append(""+__resFirstBundle.getString("MailTotalEntireStay")+"<br><br>\r\n");
			  _sbr.append("</font></td>");
		      _sbr.append("</tr>"); 
		      _sbr.append("</table>"); 
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr8888888888888888888			
				  
		  }
		  
//		  System.out.println("9---------------------------44");
		 i=26; 
		 if(supl.equals("INT")){
		 	i=26011;
//		 	ec=wholeId;
		 	
		 	
		  if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
		  	i=2600;
		  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDepositTSN")+"");
		  _sbr.append("</font></td>");
		  
	      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDepositTSNSpace")+"");
	      _sbr.append("</font></td>");
	      
	      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append(""+curr_code+" "+nf.format(deposit)+" <br>\r\n");
	      _sbr.append("</font></td>");
	  	_sbr.append("</tr>");	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@rrrrrrrrrrr999999999		  
	      _sbr.append("</table>"); 
	      
	      _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
		  i=2611; 
		  _sbr.append("<tr>");
		  _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append("*************************************************************************** <br>  \n");
		  _sbr.append("</font></td>");
		  _sbr.append("</tr>"); 
		  _sbr.append("</table>"); 
		  }else{
		  	i=2600;
		  	
		  //_sbr.append("Deposit paid      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(deposit)+" <br>\r\n");
		  
		  //_sbr.append(""+__resFirstBundle.getString("MailDepositPaid")+""+__resFirstBundle.getString("MailDepositPaidSpace")+" "+curr_code+" "+nf.format(deposit)+" <br>\r\n");
		 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
		  _sbr.append("<tr>");	 
	      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDepositPaid")+"");
		  _sbr.append("</font></td>");
		  
	      _sbr.append("<td width='3px'><font face='Courier New' size=2>");
		  _sbr.append(""+__resFirstBundle.getString("MailDepositPaidSpace")+"");
	      _sbr.append("</font></td>");
	      
	      _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append(""+curr_code+" "+nf.format(deposit)+" <br>\r\n");
	      _sbr.append("</font></td></tr>");
	      _sbr.append("</table>"); 
	      
		  
		
		  i=2611; 
		  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
		  _sbr.append("<tr>");
		  _sbr.append("<td width='70%'><font face='Courier New' size=2>");
		  _sbr.append("*************************************************************************** <br>  \n");
		  _sbr.append("</font></td>");
		  _sbr.append("</tr>");
		  _sbr.append("</table>"); 
		 }
		  
//		  System.out.println("9---------------------------44");
	  		try{
	  		  if(cinfo.getBalancedays()!=null){
	  				if (afftCode.equals("AFF120"))
					{
	  					 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
	  					_sbr.append("<tr>");	 
					      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					      
					      
						//_sbr.append(""+__resFirstBundle.getString("MailBalance")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
						_sbr.append(""+__resFirstBundle.getString("MailBalanceLSEinter")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
						
						_sbr.append("*************************************************************************** <br><br>  \n");
						
						_sbr.append("</font></td>");
						  _sbr.append("</tr>");
						  _sbr.append("</table>");
											
					}
					
	  				else{
	  				if(cinfo.getBalancedays().equals("WS_TERMZ")){

						  if(wholeId.equals("WH1")){
							  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
							  _sbr.append("<tr>");	 
						      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
							  _sbr.append(""+__resFirstBundle.getString("MailBalanceWithin7Dayschg")+":&nbsp;"+curr_code+" "+nf.format(balance)+" <br>\r\n");
							  _sbr.append("</font></td>");
							  _sbr.append("</tr>");
							  _sbr.append("</table>");
						
							  		
						  }else if(wholeId.equals("WH4")){
							  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
							  _sbr.append("<tr>");	 
						      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					  		  _sbr.append(""+__resFirstBundle.getString("MailBalanceUponArrival")+" "+__resFirstBundle.getString("MailBalanceUponArrivalSpace1")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
					  		  _sbr.append("</font></td>");
							  _sbr.append("</tr>");
							  _sbr.append("</table>");
								
						  }else if(wholeId.equals("-")){
							  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
							  _sbr.append("<tr>");	 
						      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
						      _sbr.append(""+__resFirstBundle.getString("MailBalanceUponArrival")+" "+__resFirstBundle.getString("MailBalanceUponArrivalSpace2")+""+curr_code+" "+nf.format(balance)+" <br>\r\n"); 
							  _sbr.append("</font></td>");
							  _sbr.append("</tr>");
							  _sbr.append("</table>");
						  }else{
							  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
							  _sbr.append("<tr>");	 
						      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
						      _sbr.append(""+__resFirstBundle.getString("balancePayable")+" "+arrWholeSellerDetails[0]+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace3")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
					  		  _sbr.append("</font></td>");
							  _sbr.append("</tr>");
							  _sbr.append("</table>");
								
						  }
							 
//						  System.out.println("9---------------------------99");
						  i=2633; 
						  _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
						  _sbr.append("<tr>");	 
					      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					      
							  _sbr.append("*************************************************************************** <br><br>  \n");
					
							  _sbr.append("</font></td>");
							  _sbr.append("</tr>");
							  _sbr.append("</table>");
	  				}else if (afftCode.equals("AFF157")){
			         				 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
			                      	  _sbr.append("<tr>");	 
			  					      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
			  					   _sbr.append(""+__resFirstBundle.getString("MailbalancecustomerUwic")+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
			  				  		
			  				  		_sbr.append("*************************************************************************** <br>  \n");  
			  					
			  				  		_sbr.append("</font></td>");
			  						  _sbr.append("</tr>");
			  						  _sbr.append("</table>");
						//*********************************************************************************	 
				  				  
				  				  
	  				}else if (afftCode.equals("AFF156")){
	  					_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
	  					_sbr.append("<tr>");	 
	  					_sbr.append("<td width='30%'><font face='Courier New' size=2>");
	  					_sbr.append(""+__resFirstBundle.getString("MailbalancecustomerSwanseaUni")+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
	  					_sbr.append("*************************************************************************** <br>  \n");  
	  					_sbr.append("</font></td>");
	  					_sbr.append("</tr>");
	  					_sbr.append("</table>");
	  					//*********************************************************************************	 
			     	}else{
						_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
						_sbr.append("<tr>");	 
						_sbr.append("<td width='30%'><font face='Courier New' size=2>");
						_sbr.append(""+__resFirstBundle.getString("MailBalPayable")+cinfo.getBalancedays()+__resFirstBundle.getString("MailDaysPrior")+""+__resFirstBundle.getString("MailBedtypeSpace1")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
						_sbr.append("*************************************************************************** <br><br>  \n");
						_sbr.append("</font></td>");
						_sbr.append("</tr>");
						_sbr.append("</table>");
	  				}
	  			}
	  			}
	  			
	  			else{
	  				
	  				if (afftCode.equals("AFF120"))
					{
	  				    _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
	  					_sbr.append("<tr>");	 
					    _sbr.append("<td width='30%'><font face='Courier New' size=2>");
						_sbr.append(""+__resFirstBundle.getString("MailBalanceLSEinter")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
						_sbr.append("*************************************************************************** <br><br>  \n");
						_sbr.append("</font></td>");
						_sbr.append("</tr>");
						_sbr.append("</table>");
					}
	  			
	  				else
	  				{
	  				  	if(afftCode.equals("AFF61")){
						_sbr.append("<tr>");	 
						_sbr.append("<td width='30%'><font face='Courier New' size=2>");
						_sbr.append(""+__resFirstBundle.getString("MailBalancePriorArrival")+ ""+__resFirstBundle.getString("MailBedtypeSpace1")+":"+curr_code+" "+nf.format(balance)+" <br>\r\n");	
						_sbr.append("</font></td>");
						_sbr.append("</tr>");
	  				  	}else if (afftCode.equals("AFF122")){
	  				  	 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
	  				  	 _sbr.append("<tr>");	 
					     _sbr.append("<td width='30%'><font face='Courier New' size=2>");
 				  		 _sbr.append(""+__resFirstBundle.getString("CardiffMailBal")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
				  		 _sbr.append("*************************************************************************** <br>  \n");  
 				  		 _sbr.append("</font></td>");
						  _sbr.append("</tr>");
						  _sbr.append("</table>");
					
				  	}				//*********************************************************************************
                    else if (afftCode.equals("AFF157")){
         				 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
                      	  _sbr.append("<tr>");	 
  					      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
	  					   _sbr.append(""+__resFirstBundle.getString("MailbalancecustomerUwic")+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
	  				  		_sbr.append("*************************************************************************** <br>  \n");  
	  				  		_sbr.append("</font></td>");
  						  _sbr.append("</tr>");
  						  _sbr.append("</table>");
			//*********************************************************************************	 
	  				  
                    }				//*********************************************************************************
                    else if (afftCode.equals("AFF156")){
                    	_sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
                    	_sbr.append("<tr>");	 
                    	_sbr.append("<td width='30%'><font face='Courier New' size=2>");
                    	_sbr.append(""+__resFirstBundle.getString("MailbalancecustomerSwanseaUni")+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace")+" "+curr_code+" "+nf.format(balance)+" <br>\r\n");
                    	
                    	_sbr.append("*************************************************************************** <br>  \n");  
                    	
                    	_sbr.append("</font></td>");
                    	_sbr.append("</tr>");
                    	_sbr.append("</table>");
                    	//*********************************************************************************	 
                    	
	  				  
	  				  
                    }  	else{
	  				  	 _sbr.append("<table width=\"100%\" border=0 cellspacing=0 cellpadding=0>");
	  				  	_sbr.append("<tr>");	 
					      _sbr.append("<td width='30%'><font face='Courier New' size=2>");
					      
	  				  		//_sbr.append("Balance payable upon arrival    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");	
	  				  	
	  				  	_sbr.append(""+__resFirstBundle.getString("MailBalanceUponArrival")+""+__resFirstBundle.getString("MailBalanceUponArrivalSpace") +curr_code+" "+nf.format(balance)+" <br>\r\n");
	  				  		
	  				  System.out.println("A__A__A__A5");
	  				  i=2633;
	  				 
	  				  _sbr.append("*************************************************************************** <br><br>  \n");
	  				 //}
	  				_sbr.append("</font></td>");
					  _sbr.append("</tr>");
					  _sbr.append("</table>");
				
	  				  	}
	  				 
	  				}	 
//	  			  System.out.println("9---------------------------217");
	  			}
				
			}catch(Exception e){
				e.printStackTrace();
				_sbr.append(e.toString()+""+__resFirstBundle.getString("MailBalanceUponArrival")+""+__resFirstBundle.getString("MailBedtypeSpace1")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+curr_code+" "+nf.format(balance)+" <br>\r\n");
				_sbr.append("*************************************************************************** <br><br>  \n");
			}finally{
				if(___result!=null){try{___result.close();___result=null;}catch(Exception e){___result =null;}}	
				if(___stmt!=null){try{___stmt.close();___stmt=null;}catch(Exception e){___stmt =null;}}
			} 
		 		 
		}
		 _sbr.append("</p>"); 
		 ////////second///gggg111111/////////////////////////////
		 
		 
		  //_sbr.append("</table>");  
		 
   		 i=27;
		  _sbr.append(""+__resFirstBundle.getString("MailBillTitle")+"<br>\r\n");
		if(supl.equals("INT")){	
			if(!wholeId.equals("-")){ //ASA
				 if (afftCode.equals("AFF122")) //Cardiff
				 {
					 _sbr.append(""+__resFirstBundle.getString("CardiffBill1")+"<br>\r\n");
					 _sbr.append(""+__resFirstBundle.getString("CardiffDill2")+"<br><br>\r\n");
				 }
				 else{
				_sbr.append("*"+__resFirstBundle.getString("MailChargedTitle")+"\r\n");
				
				if (afftCode.equals("AFF120")){
				_sbr.append("*"+__resFirstBundle.getString("AffBalPayableLSEinter")+"<br><br>\r\n");//(TSTAY-980)
//				*************************************************************************
				 }else if (afftCode.equals("AFF157")){
							_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerUwicins")+"<br><br>\r\n");	
						//*************************************************************************
				 }else if (afftCode.equals("AFF156")){
					 _sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerSwanseaUniins")+"<br><br>\r\n");	
					 //*************************************************************************
				}else if(!wholeId.equals("WH1")){
					_sbr.append("*"+__resFirstBundle.getString("MailBalPayAccomadation")+"<br><br>\r\n");//(TSTAY-980)	
				}
				 }
				
				
				 if (afftCode.equals("AFF77")) {//AFF77 Aston		
					 _sbr.append(""+__resFirstBundle.getString("MailbalanceAston")+"<br><br>\r\n");	 
				 }
				 
				 
//				System.out.println("9---------------------------0001");
				
				if ( ( (cinfo.getBalancedays()!= null)&& (cinfo.getBalancedays().equals("WS_TERMZ") ) )  || ( (WS_TERMZ!=null)&&(!(WS_TERMZ.equals("N")))  )	) { //hoteler termz
					if(wholeId.equals("WH1"))
						_sbr.append("*"+__resFirstBundle.getString("MailChargedByWS1")+"TravelStay Network"+" "+__resFirstBundle.getString("MailChargedByWSstat")+" <br>");
					else
						_sbr.append("*"+__resFirstBundle.getString("MailChargedByWS1")+arrWholeSellerDetails[0]+__resFirstBundle.getString("MailChargedByWS3")+"\""+arrWholeSellerDetails[0]+"\" <br>");
				_sbr.append("*"+__resFirstBundle.getString("MailVoucherEmail")+ "<br><br>\r\n");
								
				}
				 if ((!wholeId.trim().equals("WH1"))&& langCode.equals("en")){
					 _sbr.append(""+__resFirstBundle.getString("MailCheckInInFanPageTitle")+" \r\n");
					 _sbr.append(""+__resFirstBundle.getString("MailCheckInInFanPageContent")+"   <br><br>\r\n");
					 }
								
				_sbr.append("<br>"+__resFirstBundle.getString("MailCheckInInstructionsTitle")+" <br>\r\n");				
				_sbr.append(""+__resFirstBundle.getString("MailCheckinfrom")+checkintime+"  <br>\r\n");
	    	    _sbr.append(""+__resFirstBundle.getString("MailCheckoutby")+checkouttime+"  <br>\r\n");
				if ( ( (cinfo.getBalancedays()!= null)&& (cinfo.getBalancedays().equals("WS_TERMZ") ) )  || ((WS_TERMZ!=null)&&(!(WS_TERMZ.equals("N")))  )	) { //hoteler termz
					_sbr.append("*"+__resFirstBundle.getString("MailVoucherPrint")+"<br>\r\n ");
				}
			    _sbr.append("*"+__resFirstBundle.getString("MailSpecialReqHotel")+"<br>\r\n ");
			    _sbr.append("*"+__resFirstBundle.getString("MailRoomPict")+"<br><br>\r\n ");
			}else{
				if (afftCode.equals("AFF120"))
				 {
					_sbr.append("*"+__resFirstBundle.getString("MailChargedTitle2")+"<br>\r\n");
				 }
				else if (afftCode.equals("AFF122")) //Cardiff
				 {
					 _sbr.append(""+__resFirstBundle.getString("CardiffBill1")+"<br>\r\n");
					 _sbr.append(""+__resFirstBundle.getString("CardiffDill2")+"<br><br>\r\n");
				 }
				else
				{
					_sbr.append("*"+__resFirstBundle.getString("MailChargedTitle")+"\r\n");		
				}
				
				if (afftCode.equals("AFF120"))
				{
					_sbr.append(""+__resFirstBundle.getString("AffBalPayableLSEinter")+"<br><br>\r\n");
				}
				
				 if (afftCode.equals("AFF77")) {//AFF77 Aston		
					 _sbr.append(""+__resFirstBundle.getString("MailbalanceAston")+"<br>\r\n");	 
				 }
			 {
				if (DEPOSIT_TYPE != null){
				//	_sbr.append("* Balance will be taken "+DEPOSIT_TYPE+" days prior to the arrival date <br><br>\r\n");
					//*************************************************************************
				 if (afftCode.equals("AFF157")){ //Cardiff
							_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerUwicins")+"<br><br>\r\n");	
						//*************************************************************************
				 }else if (afftCode.equals("AFF156")){ //Cardiff
								_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerSwanseaUniins")+"<br><br>\r\n");	
								//*************************************************************************
				 }else{
				_sbr.append("*"+__resFirstBundle.getString("MailBalanceTaken")+" "+DEPOSIT_TYPE+" "+__resFirstBundle.getString("MailDaysPrior")+"<br><br>\r\n");
				 }			
				}else if((cinfo.getBalancedays() != null)&&(!cinfo.getBalancedays().equals("WS_TERMZ"))) {
					
					//*************************************************************************
					 if (afftCode.equals("AFF157")){ //Cardiff
								_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerUwicins")+"<br><br>\r\n");	
							//*************************************************************************
					 }else if (afftCode.equals("AFF156")){ //Cardiff
									_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerSwanseaUniins")+"<br><br>\r\n");	
									//*************************************************************************
					 }else{
					_sbr.append("*"+__resFirstBundle.getString("MailBalanceTaken")+cinfo.getBalancedays()+" "+ __resFirstBundle.getString("MailDaysPrior")+"<br><br>\r\n");
					 }
				
				}else{
				
				if(wholeId.equals("WH1")){
					_sbr.append("*"+__resFirstBundle.getString("MailBalTakenWithin7Days")+"<br><br>\r\n");
				}else{
					if(afftCode.equals("AFF61")){
						_sbr.append("*"+__resFirstBundle.getString("MailBalTakenPrior7Days")+"<br><br>\r\n");
				}else if (afftCode.equals("AFF122")) //Cardiff
					 {
//					*************************************************************************
					 }else if (afftCode.equals("AFF157")) //Cardiff
					 {
								_sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerUwicins")+"<br><br>\r\n");	
					 }else if (afftCode.equals("AFF156")) //Cardiff
					 {
						 _sbr.append("*"+__resFirstBundle.getString("MailbalancecustomerSwanseaUniins")+"<br><br>\r\n");	
					}else{
					
						if (!afftCode.equals("AFF120"))
							_sbr.append("*"+__resFirstBundle.getString("MailBalPayAccomadation")+"<br><br>\r\n");	
					}
				}
				}
			 }
	
			 if ((!wholeId.trim().equals("WH1"))&& langCode.equals("en")){
				 _sbr.append(""+__resFirstBundle.getString("MailCheckInInFanPageTitle")+" \r\n");
				 _sbr.append(""+__resFirstBundle.getString("MailCheckInInFanPageContent")+"   <br><br>\r\n");
				 }
				_sbr.append(""+__resFirstBundle.getString("MailCheckInInstructionsTitle")+" <br>\r\n");
				_sbr.append(""+__resFirstBundle.getString("MailCheckinfrom")+"  "+checkintime+"  <br>\r\n");
		    	_sbr.append(""+__resFirstBundle.getString("MailCheckoutby")+"  "+checkouttime+"  <br>\r\n");
		    	 _sbr.append("*"+__resFirstBundle.getString("MailRules1")+"\r\n ");
		    		if (!afftCode.equals("AFF120"))
			     _sbr.append("*"+__resFirstBundle.getString("MailRules2")+"\r\n ");
			     _sbr.append("*"+__resFirstBundle.getString("MailRules3")+"\r\n ");
			     _sbr.append("*"+__resFirstBundle.getString("MailRules4")+"\r\n ");
			}
		}else{
							
            _sbr.append(""+__resFirstBundle.getString("MailCCInfo")+curr_code+""+__resFirstBundle.getString("MailCCTrans"));
			
			if(supl.equals("INV8")){
				
			_sbr.append(""+__resFirstBundle.getString("MailInv8")+" \r\n");
			
			}else if(supl.equals("INV1")){
				
			_sbr.append(""+__resFirstBundle.getString("MailCNG")+"\r\n");
			
			}
//			System.out.println("9---------------------------0009");
			_sbr.append(""+__resFirstBundle.getString("MailConvert")+"\r\n");
			
			
			_sbr.append(""+__resFirstBundle.getString("MailCknIns") +" <br>\r\n");			
			_sbr.append("=====================<br>\r\n");
			
			_sbr.append("*"+__resFirstBundle.getString("MailCheckinfrom")+checkintime+"<br>\r\n");
		
			_sbr.append("*"+__resFirstBundle.getString("MailCheckoutby")+checkintime+"<br>\r\n");
			
			_sbr.append("*"+__resFirstBundle.getString("MailCardCharge")+"<br>\r\n");
			_sbr.append("*"+__resFirstBundle.getString("MailRequest")+"<br>\r\n");
			_sbr.append("*"+__resFirstBundle.getString("MailRules4")+"<br>\r\n");
			_sbr.append("*"+__resFirstBundle.getString("MailPhotoId")+"<br>\r\n");
			_sbr.append("*"+__resFirstBundle.getString("MailWebCall")+"<br>\r\n");
			
//			System.out.println("9---------------------------0011");
		
		}
					
				i=28;
				_sbr.append("\r\n");
				if(supl.equals("INT")){	
					
					
					//====st================== (TSTAY-893)======================================================
					if (afftCode.equals("AFF120"))
					{	
						_sbr.append(""+__resFirstBundle.getString("AffModifications")+"<br>\r\n");
						_sbr.append("============== <br>\r\n");
						//_sbr.append(""+__resFirstBundle.getString("AffModPol1")+"<br>\r\n");
						_sbr.append(""+__resFirstBundle.getString("AffModPol1LSEinter")+"<br><br>\r\n");
						_sbr.append(""+__resFirstBundle.getString("AffCancel")+"<br>\r\n");
						_sbr.append("============== <br>\r\n");
						_sbr.append(""+__resFirstBundle.getString("AffCanPol1LSEinter")+"<br><br>\r\n");
					}else
					{
					_sbr.append(""+__resFirstBundle.getString("MailCancelModiNW1")+"<br>\r\n");		     		
					_sbr.append(""+__resFirstBundle.getString("UcanUseNW1")+"<br>\r\n");
						_sbr.append("<a href=\""+ServletUrlBack+ResAgentName+".CancelCustomerBooklnk?Frame=top&ResNo="+bookNo+"\" target=\"_blank\">"+__resFirstBundle.getString("MailCancelLink")+"</a> <br>\r\n");
					if (langCode.equals("en")){
					_sbr.append(""+__resFirstBundle.getString("AltCallUsNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("DepostBookFeesNonRefNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("CanMadSuffNotNW1")+"<br>\r\n");	
					}else{					
					_sbr.append("<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("AltCallUsNW1")+"<br><br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("DepostBookFeesNonRefNW1")+"<br><br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("CanMadSuffNotNW1")+"<br><br>\r\n");					
					}
					
//					_sbr.append(""+__resFirstBundle.getString("CanMadWithinHotsNotNW1")+"<br><br>\r\n");
//					System.out.println("webSite "+webSite);
//					if(webSite.equals("TravelStay"))
					_sbr.append(""+__resFirstBundle.getString("CanMadWithinHotsNotNW2").trim()+(Integer.parseInt(cancelpolicybefore)*24)+" "+__resFirstBundle.getString("CanMadWithinHotsNotNW3")+"<br><br>\r\n");
//					else
//					_sbr.append(""+__resFirstBundle.getString("CanMadWithinHotsNotNW1")+"<br><br>\r\n");
					
					_sbr.append("<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("MailModiNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("YoucanUseFollContDetailNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("TelEmailNW1")+"\r\n");
					if (langCode.equals("en")){
					_sbr.append(""+__resFirstBundle.getString("ModiEmailNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("ModiFeeRefundNW1")+"<br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("ModiInvolLowAvlRateNW1")+"<br>\r\n");					
					}else{
					_sbr.append(""+__resFirstBundle.getString("ModiEmailNW1")+"<br><br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("ModiFeeRefundNW1")+"<br><br>\r\n");
					_sbr.append(""+__resFirstBundle.getString("ModiInvolLowAvlRateNW1")+"<br><br>\r\n");
					}
				    
				    String whlNm="-";

					//------
				    _sbr.append(""+__resFirstBundle.getString("MailModicancelpolicy")+"<br>\r\n");
				    _sbr.append("<a href=\""+ServletUrlBack+ResAgentName+".CancelCustomerBooklnk?Frame=top&ResNo="+bookNo+"\" target=\"_blank\">"+__resFirstBundle.getString("MailModicancelpolicyclick")+"</a>  "+__resFirstBundle.getString("MailModicancelpolicyclick1")+"<br><br>\r\n");
//				    _sbr.append("<a href=\"JavaScript:viewHtml();\" >"+__resFirstBundle.getString("MailModicancelpolicyclick")+"</a>  "+__resFirstBundle.getString("MailModicancelpolicyclick1")+"<br><br>\r\n");
					//------
				    _sbr.append(""+__resFirstBundle.getString("MailBookPolicy")+"<br>\r\n");//Click here for the full booking policy:
				    
				    
				 if(is_common_aff.equals("Y")) //
				  {/*
				    if(afftCode.equals("AFF122")){ //+++ CARDIFF
						_sbr.append("<a href=\""+_htmlUrl+"Cardiff.html"+"\">"+_htmlUrl+"Cardiff.html"+"</a>");
						}
					else
					{
					if(webSite.toUpperCase().equals("LONDONHOTELSAVINGS")){
						Site="Global Hotel Centre";
						_sbr.append("<a href=\"https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
					}else if(webSite.toUpperCase().equals("LONDONHOTELSITE")){
						Site="London Hotel Site";
						_sbr.append("<a href=\"https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
					
					//-- Travelstay	
					}else if(webSite.toUpperCase().equals("TRAVELSTAY")){
						Site="TravelStay";
						//Policy_Url
						if (langCode.equals("en")){
						_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=en&countryCode=US\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=en&countryCode=US</a>");
						
						}
						//-------------------------------- PL / DE/ FR/ IT---------
						else if (langCode.equals("pl"))
						{
							_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=pl&countryCode=PL\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=pl&countryCode=PL</a>");	
						}
						else if (langCode.equals("fr"))
						{
							_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=fr&countryCode=FR\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=fr&countryCode=FR</a>");	
						}
						else if (langCode.equals("it"))
						{
							_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=it&countryCode=IT\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=it&countryCode=IT</a>");	
						}
						else if (langCode.equals("de"))
						{
							_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=de&countryCode=DE\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=de&countryCode=DE</a>");	
						//------------------------------------------
						}else{
						_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=es&countryCode=ES\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=es&countryCode=ES</a>");	
						}
					}//--- TravelStay
					}	
					*/}
				 else
					{
						  if(afftCode.equals("AFF122")){ //+++ CARDIFF
								_sbr.append("<a href=\""+_htmlUrl+"Cardiff.html"+"\">"+_htmlUrl+"Cardiff.html"+"</a>");
								}
							else
							{
							/*if(webSite.toUpperCase().equals("LONDONHOTELSAVINGS")){
								Site="Global Hotel Centre";
								_sbr.append("<a href=\"https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
							}else if(webSite.toUpperCase().equals("LONDONHOTELSITE")){
								Site="London Hotel Site";
								_sbr.append("<a href=\"https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"\">https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"</a>");
							
							//-- Travelstay	
							}else if(webSite.toUpperCase().equals("TRAVELSTAY")){*/
//								Site="TravelStay";
//								//Policy_Url
//								if (langCode.equals("en")){
//								_sbr.append("<a href=\""+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=en&countryCode=US\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=en&countryCode=US</a>");
//								}
//								//-------------------------------- PL / DE/ FR/ IT---------
//								else if (langCode.equals("pl"))
//								{
//									if(afftCode.equals("RA"))
//									_sbr.append("<a href=\""+_affUrl+"TravelStay"+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=pl&countryCode=PL</a>");
//									else
//									_sbr.append("<a href=\""+_affUrl+afftCode+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=pl&countryCode=PL</a>");
//								}
//								else if (langCode.equals("fr"))
//								{
//									if(afftCode.equals("RA"))
//									_sbr.append("<a href=\""+_affUrl+"TravelStay"+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=fr&countryCode=FR</a>");
//									else
//										_sbr.append("<a href=\""+_affUrl+afftCode+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=fr&countryCode=FR</a>");	
//								}
//								else if (langCode.equals("it"))
//								{
//									if(afftCode.equals("RA"))
//									_sbr.append("<a href=\""+_affUrl+"TravelStay"+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=it&countryCode=IT</a>");
//									else
//									_sbr.append("<a href=\""+_affUrl+afftCode+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=it&countryCode=IT</a>");
//										
//								}
//								else if (langCode.equals("de"))
//								{
//									if(afftCode.equals("RA"))	
//									_sbr.append("<a href=\""+_affUrl+"TravelStay"+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=de&countryCode=DE</a>");
//									else
//									_sbr.append("<a href=\""+_affUrl+afftCode+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=de&countryCode=DE</a>");	
//								}else{
//									if(afftCode.equals("RA"))
//									_sbr.append("<a href=\""+_affUrl+"TravelStay"+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=es&countryCode=ES</a>");
//									else
//									_sbr.append("<a href=\""+_affUrl+afftCode+"_"+langCode+".htm?"+afftCode+"\">"+PolicyUrl+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"&languageCode=es&countryCode=ES</a>");
//								}
//							}//--- TravelStay	
				    }
					}
					_sbr.append("<br><br>\r\n");
					}
			     }else{
			     	if(supl.equals("INV8")){
			     	_sbr.append(""+__resFirstBundle.getString("MailCancelModi")+"<br>\r\n");	
			     	_sbr.append("*" +__resFirstBundle.getString("MailCancelContact")+"<br>\r\n");
			     	_sbr.append("*" +__resFirstBundle.getString("MailCanCharge")+"<br>\r\n");
			    	_sbr.append("*" +__resFirstBundle.getString("MailCancelIf")+"<br>\r\n");
			     	_sbr.append("*" +__resFirstBundle.getString("MailNoRefunds")+"<br>\r\n");
			     	_sbr.append("*" +__resFirstBundle.getString("MailChangeResCharge")+"<br>\r\n");
			     	_sbr.append("*" +__resFirstBundle.getString("MailCollectEffort")+"<br>\r\n");
			     	_sbr.append("<br>\r\n");
			     	}else if(supl.equals("INV1")){
	                _sbr.append(""+__resFirstBundle.getString("MailCancelModi")+"<br>\r\n");	
				    _sbr.append("=============================== \r\n");
			    	_sbr.append("*" +__resFirstBundle.getString("MailCanModiUpto6")+"<br>\r\n");
			    	_sbr.append("*" +__resFirstBundle.getString("MailCanModiAft6")+"<br>\r\n");
			    	_sbr.append("*" +__resFirstBundle.getString("MailCanModiContact")+"<br>\r\n");
			    	
//			    	System.out.println("9---------------------------00018");
			        _sbr.append("<br>\r\n");
			     			     	
			     	
			    	}_sbr.append("<br>\r\n");
			    	if (langCode.equals("en")){
			    	_sbr.append("<a href=\""+ServletUrlBack+ResAgentName+".CancelCustomerBooklnk?Frame=top&ResNo="+bookNo+"\" target=\"_blank\">"+__resFirstBundle.getString("MailCancelLink")+"</a> <br>\r\n");
			     	}
			    	
			    	_sbr.append("<br>\r\n");
			     }
			     _sbr.append("\r\n");
		  		_sbr.append("**********************************************************************</b><br>\n");
		  		_sbr.append(""+__resFirstBundle.getString("MailThankEnjoy")+"<br>\r\n");
		 
		 }else{
		  		_sbr.append("**********************************************************************<br>\n");
		  		if(supl.equals("INT")){
		  			_sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" "+arrWholeSellerDetails[0]+ __resFirstBundle.getString("MailLimited")+"\n");
		  		}else if(supl.equals("INV8")){
		  			_sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+__resFirstBundle.getString("MailTravelNow")+"<br>\r\n"); 	
			    }else if(supl.equals("INV1")){
			    	_sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+__resFirstBundle.getString("MailCNGHotelsLtd")+"<br>\r\n");	
			    }
			   	
			   	i=30;
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT")+" <br>\r\n");
		  		_sbr.append("**********************************************************************<br>\n");
			    _sbr.append(""+__resFirstBundle.getString("VOUEML_thankYou1")+" <br>\r\n");
	    }				
			     
		  _sbr.append("</body>  \n");
		  _sbr.append("</html>  \n");
			///writeToLog("","End of generateCustomerNetCopyAce @ : Booking no="+bookNo+" at-"+i+" err "+ec+" ecc "+ecc+" ");	
		}catch(Exception err){
			err.printStackTrace();
			StackTraceElement [] arrz = err.getStackTrace();
			String errorz = "";
			for(int k=0;+k<arrz.length;k++){
				errorz += arrz[k].toString()+"\r\n";
			}
//			System.out.println("9---------------------------errrrrrrrrrrr"+err.toString());
			throw new Exception("Error in Generate Mail @ generateCustomerCommCopy  @ : at-"+i+" err "+ec+" ecc "+ecc+" "+err.toString());	
		}
		
		return _sbr;	  

	}
	
	public StringBuffer generateCustomerNetFax(
			ResourceBundle __resFirstBundle, String[][] _rateDetails,
			String[] _reqDetails, String[] _occuDetails,
			String[] arrWholeSellerDetails, String type, String supplierItaNo,
			String supplierHotConfNo, String[] afftParam, String Site,
			String Source, ResultSet rs) throws Exception {
		StringBuffer _sbr = new StringBuffer();
		int i=0;
		
		


//		System.out.println("generateCustomerNetFax----------1");
		
		LoadSystemProperties sysProp = LoadSystemProperties.getInstance();

		String Address1     = sysProp.getProperty("Address1").toString().trim();
		String Address2     = sysProp.getProperty("Address2").toString().trim();
		String Address3     = sysProp.getProperty("Address3").toString().trim();
		String Address4     = sysProp.getProperty("Address4").toString().trim();
		String ResUrl       = sysProp.getProperty("ResUrl").toString().trim();
		String ResPhone     = sysProp.getProperty("ResPhone").toString().trim();
		String ResEmail     = sysProp.getProperty("ResEmail").toString().trim();
		String ServletUrl   = sysProp.getProperty("ServletUrl").toString().trim();
		String ResAgentName = sysProp.getProperty("ResAgentName").toString().trim();	
		
		
		
		
//		System.out.println("generateCustomerNetFax----------2");
		String afftCode="RA";
		String bookNo  ="";
		String supl	   ="INT";
		String wholeId ="";
		String hotName ="";
		String hotAdd  ="";
		String hotCity ="";
		String hotZip  ="";;
		String moreInfo  ="";;
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
		String RadsNightRate="";;
		double totCharge=0;
		double bookFee=0;
		double radsBookFee=0;
		double totPay=0;
		double deposit=0;
		double balance=0;
		String webSite=Site;
		String ec=" ";
		double ecc=0.00;
		String hotcontract="";
		String roomType="";
		String hotPhone = "-";
		String hotCode="";
		String checkintime = "";
		String checkouttime = "";
		String currencyName 	="British Pounds";
		String curr_htmlcode 	="&pound;";
		String curr_code 		="GBP";
		String curr_symbol		="£";
		
		
		//       System.out.println("generateCustomerNetFax----------3");
		
		i=1;
		try{
		if(Source.equals("RES")){
			if(webSite.equals("TravelStay")){
				currencyName 	=_reqDetails[110].toString();
				curr_htmlcode 	=_reqDetails[111].toString();
				curr_code 		=_reqDetails[112].toString();
				curr_symbol		=_reqDetails[113].toString();
			}
				
			
			//       System.out.println("generateCustomerNetFax----------4");
			afftCode=_reqDetails[64].toString();	
			bookNo  =cinfo.getBooking_no().toString();
			
			try{
				supl	=_reqDetails[131].toString();
			}catch(Exception e){}
			
			//       System.out.println("generateCustomerNetFax----------5");
			
			wholeId =_reqDetails[95].toString();
			hotPhone  =cinfo.getHotelphone().toString();
			hotName =cinfo.getHotelName().toString();
			hotAdd  =cinfo.getHotelAddress().toString();
			hotCity =cinfo.getHotelcity().toString();
			hotZip  =_reqDetails[50].toString();
			moreInfo  =_reqDetails[92].toString();
			multbook =_reqDetails[74].toString();
			bedTydesc =cinfo.getBedName().toString();// if multiple format is - bed1|@|bed2
			chkInDate =cinfo.getShowCheckdate().toString();
			chkOutdate =cinfo.getShowCheckoutdate().toString();
			noNight =cinfo.getNoOfnights().toString();
			mealPlan =_reqDetails[41].substring(0,_reqDetails[41].indexOf(":"));
			radsBdTyp =_reqDetails[61].replace ('`',',');
			noPeople =Integer.parseInt(cinfo.getNoOfAdults());//((Integer.parseInt(cinfo.getNoOfAdults()))-(Integer.parseInt(_reqDetails[90])));
			spcReq = ""+_reqDetails[35].toString()+" "+_reqDetails[62].toString()+"";
			timeArr=_reqDetails[99].toString();
			adltRtByBtyp=_reqDetails[79].toString(); // if multiple format is - 78@79
			stdRtByBtyp=_reqDetails[81].toString(); // if multiple format is - 78@79
			
			
			//       System.out.println("generateCustomerNetFax----------6");
			try{
			//RadsNightRate=_reqDetails[129].substring(0,_reqDetails[129].lastIndexOf("|")-1);
			RadsNightRate=_reqDetails[129].replace('|',',');
			RadsNightRate=RadsNightRate.substring(0,RadsNightRate.lastIndexOf(",")-1);
			}catch(Exception e){}
			totCharge=(Double.parseDouble(cinfo.getTotalpayment())-Double.parseDouble(_reqDetails[102]));
			bookFee=Double.parseDouble(_reqDetails[102]);
			try{
			radsBookFee=Double.parseDouble(cinfo.getPaynow())-Double.parseDouble(_reqDetails[142]);
			}catch(Exception e){}
			
			//       System.out.println("generateCustomerNetFax----------7");
			
			totPay=Double.parseDouble(cinfo.getTotalpayment());
			deposit=Double.parseDouble(cinfo.getPaynow());
			balance=Double.parseDouble(cinfo.getBalance());
			
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			roomType=cinfo.getRoomname().toString();
			hotCode=cinfo.getHotelCode().toString();
			try{
			checkintime=_reqDetails[65].toString();
			checkouttime=_reqDetails[66].toString();
			}catch(Exception er){
			i=-111;	
			checkintime="00:00";
			checkouttime="23:59";
			i=-112;	
			}
			
			
			//       System.out.println("generateCustomerNetFax----------8");
			
			
		}else{
		//PR_RESERVATION_REPORT_CUS_MAIL
		
//			if(webSite.equals("TravelStay")){
				currencyName 	=rs.getString("currencyName");
				curr_htmlcode 	=rs.getString("curr_htmlcode");
				curr_code 		=rs.getString("curr_code");
				curr_symbol		=rs.getString("curr_symbol");
//			}
		//	title = rs.getString(79);
		
			hotPhone  =rs.getString(31);
			hotcontract=rs.getString(78);
			i=2;
			afftCode=rs.getString(68);	
			i=21;
			bookNo  =rs.getString(15);
			i=22;	
			Site	=rs.getString(72);	
			i=23;
			webSite	=Site;
			try{
				supl	=rs.getString(57);	
			}catch(Exception e){}
			i=24;
//			wholeId =rs.getString(73);
			wholeId =rs.getString(83);
			i=25;			
			hotName =rs.getString(2);	
			i=26;	
			hotAdd  =rs.getString(3);
			i=27;		
			hotCity =rs.getString(4);
			i=28;		
			hotZip  =rs.getString(62);	
			i=29;	
			if(!afftCode.equals("RA")){
			moreInfo  =rs.getString(82);
			}else{
			moreInfo  =rs.getString(71);
			}
			i=30;		
			multbook =rs.getString(74);
			i=31;	
			bedTydesc =rs.getString(46);// if multiple format is - bed1/bed2
			i=32;	
			chkInDate =rs.getString(5);	
			i=33;	
			chkOutdate =rs.getString(6);
			i=34;		
			noNight =rs.getString(8);	
			i=35;
			
			if(supl.equals("INT")){ 
				try{
					mealPlan =rs.getString(48).substring(0,rs.getString(48).indexOf("/"));
				}catch(Exception e){
					mealPlan =rs.getString(48);	
				}
			}else{
				mealPlan =rs.getString(80);	
			}	
				
			//mealPlan =rs.getString(48).substring(0,rs.getString(48).indexOf("/"));	
			i=36;	
			radsBdTyp =rs.getString(64);
			i=37;	
			noPeople =rs.getInt(20);
			i=38;	
			spcReq = rs.getString(7);
			i=39;	
			timeArr=rs.getString(56);
			i=40;	
			adltRtByBtyp=rs.getString(75); // if multiple format is - 78@79 standard 
			i=41;	
			stdRtByBtyp=rs.getString(76); // if multiple format is - 78@79 student
			i=42;	
			try{
			i=43;	
			RadsNightRate=rs.getString(60);
			}catch(Exception e){}
			i=44;	
			totCharge=rs.getDouble(24);
			bookFee=rs.getDouble(54);
			try{
			i=45;	
			radsBookFee=rs.getDouble(54);
			}catch(Exception e){}
			totPay=rs.getDouble(25);
			deposit=rs.getDouble(50);
			balance=rs.getDouble(77);
			
			i=46;	
			if(!afftCode.equals("RA")){
				Site=afftParam[1].toString();
			}
			roomType=rs.getString(81);
			hotCode=rs.getString(45);
			i=3;
			i=4700000;	
			checkintime=rs.getString(84);
			checkouttime=rs.getString(85);
		}
		
		
//		try{
			i=4;
		  _sbr = new StringBuffer();				     		
		  /*_sbr.append("<form name=form1>\n");
		  _sbr.append("     <input type='hidden' name='RABookingNo' value='"+bookNo+"'> \r\n");  
		  _sbr.append("     <input type='hidden' name='hotelType' value='"+hotcontract+"'>\r\n");
 		  _sbr.append("</form>\n");
		  */
		  
		  //       System.out.println("generateCustomerNetFax----------9");
		  
		  if(type.equals("EMAIL")){
		  	if(supl.equals("INT")){
		  			
		  		_sbr.append("** THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY ** \n");		
		  		
		  		if(wholeId.equals("-")){
				_sbr.append("\n");
				_sbr.append("*******************************************************************************\n");
				_sbr.append("PLEASE PRINT THIS BOOKING CONFIRMATION AND PRODUCE IT UPON ARRIVAL AT THE HOTEL \n");
		//		_sbr.append("*******************************************************************************\n\n");
		  		}
		  		
		  		
		  		//       System.out.println("generateCustomerNetFax----------10");
		  		
				_sbr.append("*******************************************************************************\n");		;
//		  		_sbr.append("This confirmation is not valid for visa or immigration purposes \n");
		  		
//		  		if(afftCode.equals("AFF2")){
//				_sbr.append("Thank you for booking through www."+Site+".co.uk\n");
//				}else{
//				_sbr.append("Thank you for booking through "+Site+"\n");
//				}
//				
//				_sbr.append("Your booking confirmation number is "+bookNo+" \n\n");
				
				_sbr.append("This confirmation is not valid for visa or immigration purposes. \n\n");				
				_sbr.append("Thank you for your reservation, your reference number is "+bookNo+". \n\n");
								
				if(afftCode.equals("AFF2")){
				//if(wholeId.equals("WH4") && afftCode.equals("AFF2")){
					_sbr.append("More LondonNet services for your visit:<br>\r\n");
					_sbr.append("http://www.londonnet.co.uk/ln/guide/resources/airtransfer.html for Airport Transfers\n");
					_sbr.append("http://www.londonnet.co.uk/ln/out/ent/theatre.html for Theatre Tickets\n");
					_sbr.append("http://www.londonnet.co.uk/ln/guide/about/attractions-tickets.html for London Attractions\n");
				}
			}else{
		  		_sbr.append("** THIS IS AN AUTOMATED EMAIL - PLEASE DO NOT REPLY **\n\n");		
				_sbr.append("*******************************************************************\n");
				_sbr.append("PLEASE PRINT THIS BOOKING CONFIRMATION AND PRODUCE IT UPON ARRIVAL \n");
				_sbr.append("*******************************************************************\n\n");
				
//				_sbr.append("Thank you for booking with "+Site+".\n");
//				if(supl.equals("INV8")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is Hotels.com/"+supplierHotConfNo+"\n\n");
//				}else if(supl.equals("INV1")){
//				_sbr.append("Your "+Site+" booking confirmation number is "+bookNo+" and the Reference Number to quote upon arrival is CNG/"+supplierItaNo+"\n\n");
//				}
				
				_sbr.append("This confirmation is not valid for visa or immigration purposes. \n\n");				
				_sbr.append("Thank you for your reservation, your reference number is "+bookNo+". \n\n");
			}
		 }else{
		 	i=5;
		 	if(supl.equals("INT")){
			  if(!wholeId.equals("-")){
				_sbr.append("*******************************************************************\n");
				_sbr.append(""+__resFirstBundle.getString("VouHead")+" "+arrWholeSellerDetails[0]+" "+arrWholeSellerDetails[5]+"\n");
				_sbr.append("*******************************************************************\n\n");
				_sbr.append("HOTEL BOOKING PROVIDER\n");
				_sbr.append("======================\n");	
				_sbr.append(""+arrWholeSellerDetails[0]+"\n");
				_sbr.append(""+arrWholeSellerDetails[5]+","+arrWholeSellerDetails[6]+" "+arrWholeSellerDetails[7]+" "+arrWholeSellerDetails[9]+"\n");
				_sbr.append("" +__resFirstBundle.getString("Phone")+": "+arrWholeSellerDetails[1]+"\n");				    			    
				_sbr.append("" +__resFirstBundle.getString("Email")+": "+arrWholeSellerDetails[3]+"\n\n");				    			    			    		
			  }else{
			  _sbr.append(""+__resFirstBundle.getString("EML_Voucher_Head")+"\n");
			  _sbr.append("**********************************************************************\n");
			  }
			}else{
			  _sbr.append(""+__resFirstBundle.getString("EML_Voucher_Head")+"\n");
			  _sbr.append("**********************************************************************\n");
			}
		}
		  
          i=6;
          
          
          //       System.out.println("generateCustomerNetFax----------11");
		  _sbr.append("HOTEL INFORMATION\n");
		  _sbr.append("=================\n");	
	      _sbr.append(""+hotName+"\n");
		  _sbr.append(""+hotAdd+",\n");
	      _sbr.append(""+hotCity+" "+hotZip+".\n");				    			    
		  if(supl.equals("INT")){
	      _sbr.append("Phone: "+hotPhone+"<br>\r\n");				    			    
	      }else{
	      _sbr.append("Phone: +44 (0)870 922 4100<br>\r\n");				    			    
	      }	
		  
		  if(!type.equals("EMAIL") && wholeId.equals("WH1")){
	      	  _sbr.append("\n\n");
		      _sbr.append("CHECK IN  : "+checkintime+"  \n");
    		  _sbr.append("CHECK OUT : "+checkouttime+" \n");	
    		  _sbr.append("\n\n");
		  }	 
		  
		  if(type.equals("EMAIL")){
		  _sbr.append(""+__resFirstBundle.getString("MoreInfo")+" and maps: \n "+moreInfo+"\n");
		  }
		  		  
		  
		  _sbr.append("\n");
		  _sbr.append("BOOKING SUMMARY\n");
		  _sbr.append("===============\n");
		  if(type.equals("EMAIL")){
		  _sbr.append("Booking No.                             : "+bookNo+"\n");
		  }
		  
		  i=7;
		  if(supl.equals("INT")){
			
				int bedTyps=0; 
				if(multbook.equals("S")){
				bedTyps=1;
				}else{
				bedTyps=2;
				}
				int bedTypscount=0;
				
				String bedType="";
				String rmNo="";
				
				i=8;
				String[] arrbedTypeDisc=new String[3];
				int countval=0;
				StringTokenizer bedTypeDisc = null;
				if(Source.equals("RES")){
					bedTypeDisc = new StringTokenizer(bedTydesc+"|@|","|@|");
				}else{
					bedTypeDisc = new StringTokenizer(bedTydesc+"/","/");
				}
				 
				i=9; 
				while(bedTypeDisc.hasMoreElements()){
				arrbedTypeDisc[countval]=bedTypeDisc.nextElement().toString();
				countval+=1;
				}
				bedTypeDisc=null;
				
				i=10;
				_sbr.append(""+__resFirstBundle.getString("HotelName")+"                      : "+hotName+"\n");
				_sbr.append("Room Type                               : ");
	
				while(bedTyps>bedTypscount){//arrbedType
					i=11;
					rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
					bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
					
					i=12;
					try{
						//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
					}catch(Exception err){
						//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
					}
					
					i=13;
					if(bedTyps==1 || bedTypscount==1){
						if(bedTyps==1){
							_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}else{
							_sbr.append("           "+rmNo+" x "+roomType+" - "+bedType+" \n");
						}
					}else if(bedTyps==2 && bedTypscount==0){
					_sbr.append(" "+rmNo+" x "+roomType+" - "+bedType+" \n");
					}
					bedTypscount+=1;
				}
				i=13;
				arrbedTypeDisc=null;
			  	_sbr.append("\n");		  	
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"                            : "+chkInDate+"\n");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"                           : "+noNight+"\n");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"                          : "+chkOutdate+"\n");
			  _sbr.append("No. of Guests                           : "+noPeople+"\n");
			  _sbr.append("Meal Plan                               : "+mealPlan+"\n");
			  _sbr.append("\n");
		  }else{
		  	i=14;
		  	if(supl.equals("INV8")){
			  _sbr.append("Reference No.                           : "+supplierHotConfNo+"\n");
		  	}else{
			  _sbr.append("Itinerary No.                           : "+supplierItaNo+"\n");
			}
			  _sbr.append("Accommodation Name                       : "+hotName+"\n");
			  _sbr.append("Bed Type                                 : "+radsBdTyp+"\n");
			  _sbr.append(""+__resFirstBundle.getString("CheckInDate")+"                            : "+chkInDate+"\n");
			  _sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"                           : "+noNight+"\n");
			  _sbr.append(""+__resFirstBundle.getString("CheckOutDate")+"                          : "+chkOutdate+"\n");
			  _sbr.append("No. of People                           : "+noPeople+" Adult/s\n");
			  
			  _sbr.append("Meal Plan                                : "+mealPlan+"\n");
		  }

		  //_sbr.append("=========================<br>  \n");
		  i=15;
		  String occLen=""+_occuDetails.length+"";
		  for(int _i=0;_i<_occuDetails.length;_i++){
		  	if(occLen.equals(""+noPeople+"")&&(webSite.equals("TravelStay"))){
		  		_sbr.append("Guest "+(_i+1)+"                                  : "+_occuDetails[_i]+"\n");
		  	}else{
		  		_sbr.append("Room "+(_i+1)+"                                  : "+_occuDetails[_i]+"\n");
		  	}
	  		//	if(_i==0){
			//		_sbr.append("Room "+(_i+1)+"    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+title+" "+_occuDetails[_i]+"<br>\n");
		  	//	}else{
		  	//		_sbr.append("Room "+(_i+1)+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+_occuDetails[_i]+"<br>\n");
		  	//	}
		  }

		  i=16;	
		  
		  if(supl.equals("INT")){
			  
			  _sbr.append(""+__resFirstBundle.getString("SpecialRequests")+"                        : "+spcReq+"\n");
			  _sbr.append("Time of arrival                         : "+timeArr+"\n\n\n");
		 }else{
			  _sbr.append(""+__resFirstBundle.getString("SpecialRequests")+"                        : "+spcReq+"\n\n\n");
		 }
		 
		 if(type.equals("EMAIL")){
		  _sbr.append("PAYMENT DETAILS\n");
		  _sbr.append("===============\n");
		  _sbr.append(""+__resFirstBundle.getString("mailCurrency")+"                                : "+curr_code+" ("+currencyName+")\n");
		  
		  if(supl.equals("INT")){
		  			  	
			i=17;
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
			
			ec=ec+"\n adltRtByBtyp-"+adltRtByBtyp+" stdRtByBtyp-"+stdRtByBtyp+" multbook-"+multbook;
			i=18;
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
			
			i=19;
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
			
			i=20;
			countval=0;
			StringTokenizer bedTypeDisc = null;
			
			ec=ec+"<BR>"+bedTydesc;
			
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
			
			//       System.out.println("generateCustomerNetFax----------12");
			i=21;
			String bedType="";
			String rmNo="";
			java.text.DecimalFormat __formater = new java.text.DecimalFormat("###,###0.00");
			
			
			_sbr.append("Nightly Room Rate inc. Tax              : ");

			while(bedTyps>bedTypscount){//arrbedType
			rmNo = arrbedTypeDisc[bedTypscount].substring(0,arrbedTypeDisc[bedTypscount].trim().indexOf(" "));
			bedType = arrbedTypeDisc[bedTypscount].substring(arrbedTypeDisc[bedTypscount].trim().indexOf(" "),arrbedTypeDisc[bedTypscount].length());
			//bedType = arrbedTypeDisc[bedTypscount].replace(' ','*');
			
			i=22;
			try{
				//bedType=bedType.substring(0,bedType.indexOf("(")-1).trim();
			}catch(Exception err){
				//bedType=bedType.substring(0,bedType.indexOf("-")-1).trim();
			}
			
			i=23;
			ec=ec+"<BR>"+arrAdultRtBedtyp[bedTypscount]+"-"+arrStudRtBedtyp[bedTypscount]+"-"+rmNo;
			
			yourRtRm=(Double.valueOf(arrAdultRtBedtyp[bedTypscount]).doubleValue()+Double.valueOf(arrStudRtBedtyp[bedTypscount]).doubleValue())/Double.valueOf(rmNo).doubleValue();
			i=230;
			if(bedTyps==1 || bedTypscount==1){
				if(bedTyps==1){
					_sbr.append(" "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"\n");
				}else{
					_sbr.append("  "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"\n");
				}
			}else if(bedTyps==2 && bedTypscount==0){
				i=2344;
//				ecc=yourRtRm;
//				ec=__formater.format(yourRtRm);
//				ec=bedType;
			_sbr.append("  "+roomType+" - "+bedType+" "+curr_code+" "+__formater.format(yourRtRm)+"\n");
			}
			i=234455;
			bedTypscount+=1;
			}
			
			i=24;
			
			arrAdultRtBedtyp=null;
			arrStudRtBedtyp=null;
			arrbedTypeDisc=null;
		  	
			  
		  }else{		  	
		  	i=249999999;
		  	try{	
		  	StringTokenizer	rtPerNite = new StringTokenizer(RadsNightRate.substring(0,RadsNightRate.lastIndexOf("|")),"|");	
		  	String[] arrRt=new String[Integer.parseInt(noNight)+1];
		  		
		  	String ratePN="";
		  	int count=0;
		  	while(rtPerNite.hasMoreElements()){
				if(count==0){
				_sbr.append("Rate Per Night                           : "+rtPerNite.nextElement().toString()+"\n");
				}else{
				_sbr.append("                                         : "+rtPerNite.nextElement().toString()+"\n");
				}
				count+=1;
			}
			  //_sbr.append("Rate Per Night    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: "+RadsNightRate.substring(0,RadsNightRate.lastIndexOf("|"))+" <br>\r\n");
			}catch(Exception e){
			  _sbr.append("Rate Per Night                           : "+RadsNightRate+"\n");
			}		  
		  }
		  
		  i=25;
		  NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumFractionDigits(2);
          nf.setMaximumFractionDigits(2);

		  if(supl.equals("INT")){
		  	_sbr.append(""+__resFirstBundle.getString("No")+". "+__resFirstBundle.getString("NoOfNights")+"                           : "+noNight+"\n");
		  	_sbr.append(""+__resFirstBundle.getString("totAccCharge")+"              : "+curr_code+" "+nf.format(totCharge)+"\n");
		  	_sbr.append(""+__resFirstBundle.getString("bookCrFee")+"s              : "+curr_code+" "+nf.format(bookFee)+"\n");
		    _sbr.append("Total payable                           : "+curr_code+" "+nf.format(totPay)+"\n");
		  }else{
		  	_sbr.append("Tax Recovery Charges and Service Fees       : "+curr_code+" "+nf.format(radsBookFee)+"\n");
			_sbr.append("Total Amount                            : "+curr_code+" "+nf.format(totPay)+"\n");
			_sbr.append("(Total is for entire stay with tax recovery charges and service fees)\n\n");
		  }
		  
		 i=26; 
		 if(supl.equals("INT")){ 
		 	i=26011;
		 	ec=wholeId;
		  if(!wholeId.equals("-") && !afftCode.equals("AFF2")){
		  	i=2600;
		  _sbr.append("Deposit paid to TSN                     : "+curr_code+" "+nf.format(deposit)+"\n");
		  i=2611; 
		  _sbr.append("***************************************************************************\n");
		  i=2622; 
		  }else{
		  	i=2600;
		  _sbr.append("Deposit paid                            : "+curr_code+" "+nf.format(deposit)+"\n");
		  i=2611; 
		  _sbr.append("***************************************************************************\n");
		 }
		  if (hotCode.equals("H1410")){
			  _sbr.append("Balance payable 10 days prior to arrival: "+curr_code+" "+nf.format(balance)+"\n");
			  _sbr.append("*************************************************************************** <br><br>  \n");
			  		}else{
		  if(!wholeId.equals("-")){
			  if(wholeId.equals("WH1")){
			  _sbr.append("Balance will be taken within 7 days prior to the arrival date             : "+curr_code+" "+nf.format(balance)+"\n");
			  }else{	
			  _sbr.append(""+__resFirstBundle.getString("balancePayable")+" "+arrWholeSellerDetails[0]+"            : "+curr_code+" "+nf.format(balance)+"\n");
			  }
		  i=2633; 
		  _sbr.append("*************************************************************************** \n\n\n");
		  }else{
		  	i=2600;
		  	if(afftCode.equals("AFF61")){
		  _sbr.append("balance payable 7 days prior to arrival            : "+curr_code+" "+nf.format(balance)+"\n");
		  	}else{
		  		
		  _sbr.append("Balance payable upon arrival            : "+curr_code+" "+nf.format(balance)+"\n");
		  		
		  	}
		  i=2633; 
		  _sbr.append("***************************************************************************\n\n\n");
		 }
		 }
		}
		 //       System.out.println("generateCustomerNetFax----------13");
   		 i=27;
		  _sbr.append("BILLING INSTRUCTIONS\n");
		  _sbr.append("====================\n");
		if(supl.equals("INT")){	
			if(!wholeId.equals("-") && !afftCode.equals("AFF2")){ //ASA			
				_sbr.append("* The deposit and booking fee have been charged to your card. This charge will appear on your statement as \"TSN HOTEL BOOKING\" \n");
				_sbr.append("* The balance will be charged by "+arrWholeSellerDetails[0]+" (your accommodation provider) within 7 working days. This charge will appear on your statement as \""+arrWholeSellerDetails[0]+"\"\n");
				//_sbr.append("" + __resFirstBundle.getString("EML_BillingMsg1_1") +" \r\n");
				_sbr.append("* Your CHECK-IN VOUCHER has been emailed to you. This confirms that your accommodation has been paid for in advance and must be presented upon arrival\n\n");
				
				_sbr.append("CHECK-IN INSTRUCTIONS\n");
				_sbr.append("=====================\n");
				_sbr.append("* Check-in from: "+checkintime+" \n ");
				_sbr.append("* Check-out by: "+checkouttime+" \n ");
			    _sbr.append("* The CHECK-IN VOUCHER must be presented upon arrival\n ");
			    _sbr.append("* Special requests are sent to the accommodation but cannot be guaranteed.\n"); 
			    _sbr.append("* Room pictures may differ from the actual room you receive.\n\n");
			
			}else{
				_sbr.append("* The deposit and booking fee have been charged to your card. This charge will appear in your statement as \"TSN HOTEL BOOKING\"\n");
				 
				if (hotCode.equals("H1410")){
					_sbr.append("* Balance will be taken 10 days prior to the arrival date <br><br>\r\n");
				}else{
				
				if(wholeId.equals("WH1")){
				//_sbr.append("* Balance will be taken within 7 days prior to the arrival date \n\n");
				_sbr.append("* Balance will be taken within 7 days of the booking date \n\n");
				 }else{
				 	if(afftCode.equals("AFF61")){
				_sbr.append("* Balance will be taken 7 days prior to the arrival date \n\n");
				 	}else{
				_sbr.append("* The balance is payable to the accommodation upon arrival \n\n");
				 	}
				 }
				}
				_sbr.append("CHECK-IN INSTRUCTIONS\n");
				_sbr.append("=====================\n");
				_sbr.append("* Check-in from: "+checkintime+" \n ");
				_sbr.append("* Check-out by: "+checkouttime+" \n ");
			    _sbr.append("* This confirmation must be presented upon arrival\n");
			    _sbr.append("* Students booking the discounted student rate must present student identification upon arrival\n");
			    _sbr.append("* Special requests are sent to the accommodation but cannot be guaranteed.\n"); 
			    _sbr.append("* Room pictures may differ from the actual room you receive.\n\n");
			}
		}else{
				_sbr.append("Your credit card will be charged in "+curr_code+" for the full amount of this transaction.\n");
				if(supl.equals("INV8")){
				_sbr.append("The charge will appear under 'TravelNow.com'.\n");
				}else if(supl.equals("INV1")){
				_sbr.append("The charge will appear under 'CNGHotels.com'.\n");
				}
				_sbr.append("The converted rates displayed are for your convenience. \nThe conversion to your local currency on your statement may vary slightly\n\n");
				_sbr.append("CHECK-IN INSTRUCTIONS \n");
				_sbr.append("=====================\n");
				_sbr.append("* Check-in from: "+checkintime+" \n ");
				_sbr.append("* Check-out by: "+checkouttime+" \n ");
			    _sbr.append("* Your charge card will be charged for the full payment upon submitting your reservation request.\n");
			    _sbr.append("* Requests for bed type and smoking preferences will be submitted to the hotel but are not guaranteed.\n");
			    _sbr.append("* Room pictures may differ from the actual room you receive.\n"); 
			    _sbr.append("* You must present a photo ID upon check-in.\n");
			    _sbr.append("* These rates are only available through our websites and call centers and cannot be obtained by calling the hotel directly as they will not have our discounted rates in their system.\n\n");

		}
		//       System.out.println("generateCustomerNetFax----------14");
				i=28;
				_sbr.append("\r\n");
				if(supl.equals("INT")){					
					_sbr.append("CANCELLATIONS AND MODIFICATIONS\n");
				    _sbr.append("===============================\n");
//				    if(webSite.toUpperCase().equals("LONDONHOTELSITE")&&!afftCode.equals("RA")){
//					_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: "+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com\n");
//				    }else{
//					_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: "+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com\n");
//				    }
//					_sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) \n");
					
					if(afftCode.equals("AFF65")){ // book travel n stay
					    _sbr.append("* Cancellations & modifications must be made using the following contact details: Tel: +44 (0) 1480 394138, Email AdvertisingOnline@TravelStayNetwork.com \n");
					}else{
						_sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) \n");	
					}	

					
					_sbr.append("* Cancellations and modifications require 72 hours advance notice\n");
					_sbr.append("* Cancellations made within 72 hours of arrival and Non-Arrivals are charged for the first night's accommodation per 7 nights of stay\n");
					_sbr.append("* Deposits and booking fees are non-refundable for cancellations\n");
					_sbr.append("* Modifications are subject to availability and incur a charge of "+curr_code+" 10.00 for each new booking made. \n");
					_sbr.append("* Modifications involve making a new booking which will be charged at the lowest rate available at the time\n\n");
				    _sbr.append("\n");
				    String whlNm="-";
				    /*if(!wholeId.equals("-")){
				    	whlNm=arrWholeSellerDetails[0].toString();	
				    }
				    
				    if(afftCode.equals("AFF2")){
				    	Site="Travelstay";
				    }*/
				    
					_sbr.append("Click here for the full booking policy:\n");
					if(webSite.toUpperCase().equals("LONDONHOTELSAVINGS")){
						Site="Global Hotel Centre";
						_sbr.append("https://secure.londonhotelsavings.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"");
					}else if(webSite.toUpperCase().equals("LONDONHOTELSITE")){
						Site="London Hotel Site";
						_sbr.append("https://secure.londonhotelsite.com/servlet/"+webSite+".loadDiscription?type=9&phn=+44%20(0)870%20922%204100&email=info@"+webSite+".com&hotName="+hotName+"&affName="+Site+"&hotPolicy=&hotCanPolicy=&hotProvider="+Site+"&affUrl=&whlSal="+whlNm+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"");
					}else if(webSite.toUpperCase().equals("TRAVELSTAY")){
						Site="TravelStay";
						_sbr.append("https://secure.travelstay.com/servlet/"+webSite+".loadDiscription?type=9&title=Booking%20Policy&affName="+Site+"&AffCode="+afftCode+"&src=E&hotCode="+hotCode+"&curr_code="+curr_code+"");
					}
					_sbr.append("\n\n");

			     }else{
			     	if(supl.equals("INV8")){
					_sbr.append("CANCELLATIONS AND MODIFICATIONS\n");
				    _sbr.append("===============================\n");
//				    _sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com\n");
				    _sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) \n");
			     	_sbr.append("* Cancellations and modifications are subject to a USD 25.00 charge.\n");
			     	_sbr.append("* If cancellation occurs within 24 HOURS, a one-night charge will be assessed.\n");
			     	_sbr.append("* No refunds will be made for no-shows or early checkouts.\n");
			     	_sbr.append("* Please note that any changes in your reservation could result in charges applicable by policy and availability.\n");
			     	_sbr.append("* In the event that collection efforts have to be made, by sending to an outside collections agency or turning over to an attorney, you will be responsible for all costs incurred to collect the above debt.\n");

			     	//_sbr.append("Tel : "+ResPhone+"<br>\r\n");
			     	//_sbr.append("In the event that collection efforts have to be made, by sending to an outside collections agency or turning over to an attorney, you will be responsible for all costs incurred to collect the above debt. <br>\r\n");
			     	_sbr.append("\n");
			     	}else if(supl.equals("INV1")){
					_sbr.append("CANCELLATIONS AND MODIFICATIONS\n");
				    _sbr.append("===============================\n");
				    _sbr.append("* Cancellations and modifications made up to 6pm on the date of arrival will incur a charge of USD 10.00\n");
			     	_sbr.append("* If cancellation or modification is made after 6pm on the date of arrival, the payment is non-refundable\n");
			     	//_sbr.append("* Cancellations & modifications must be made directly with "+Site+". Tel: +"+ResPhone+" (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@"+webSite+".com\n");
					_sbr.append("* These must be made using the following contact details. Tel: +44 (0)870 922 4100 (open 9am-5:30pm GMT, Mon-Fri), Email: Cancellations@TravelStayNetwork.com (for cancellations)  Modifications@TravelStayNetwork.com (for modifications) \n");
			     	_sbr.append("\n\n");
			     	}
			     }
				//       System.out.println("generateCustomerNetFax----------15");
		  		_sbr.append("**********************************************************************\n");
//			    if(webSite.toUpperCase().equals("LONDONHOTELSITE")&&!afftCode.equals("RA")){
//			    _sbr.append("\"Thank you for your booking. Enjoy your stay!\"\n");
//			    }else{
//			    _sbr.append("\"Thank you for booking with "+Site+". Enjoy your stay!\"\n");
//			    }
				_sbr.append("\"Thank you for your reservation. Enjoy your stay!\" \n");

	    }else{
		  		_sbr.append("**********************************************************************\n");
		  		if(supl.equals("INT")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" "+arrWholeSellerDetails[0]+" Limited\n");
			    }else if(supl.equals("INV8")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" TravelNow Limited\n");
			   	}else if(supl.equals("INV1")){
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT2")+" CNG Hotels Limited\n");
			   	}
			   	
			   	i=30;
			    _sbr.append(""+__resFirstBundle.getString("VOUCHER_FOOT")+"\n");
		  		_sbr.append("**********************************************************************\n");
			    _sbr.append(""+__resFirstBundle.getString("VOUEML_thankYou1")+"\n");
	   
			    //       System.out.println("generateCustomerNetFax----------16");
	    
	    
	    }				
			     
		  //_sbr.append("</body>  \n");
		  //_sbr.append("</html>  \n");
		}catch(Exception err){
						System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD at-"+i+" err "+ec+" ecc "+ecc+" "+err.toString());		
			//throw new Exception("Error in Generate Mail @ generateCustomerCommCopy  @ : at-"+i+" err "+ec+" ecc "+ecc+" "+err.toString());	
		}  
		return _sbr;	  
	}
}
