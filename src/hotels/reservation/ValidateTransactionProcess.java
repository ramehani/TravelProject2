package hotels.reservation;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateTransactionProcess
 */
public class ValidateTransactionProcess extends HttpServlet {
	
	etspl.common.jdbc.PoolManager poolManager =null;
//	static RezGatewaySystemProperties  systemProperties=null;
//	static RezGatewayResInternationalizationManager iManager=null;
	static String  __servletURL=null;
	static String __resAgentName=null;
	
	public void init(ServletConfig conf) throws ServletException{
		try{
			poolManager=etspl.common.jdbc.PoolManager.getInstance();
		}catch(Exception e){
			throw new ServletException(e.toString());
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res){
		PrintWriter out=null;
		res.setContentType("text/html");
		res.setHeader("Pragma","no-cache");
		res.setHeader("Expires","0");
		Connection conn=null; 
		String appendingvalues= "";
		try{
//			System.out.println("Validate Transaction Process...........");
			
			appendingvalues += req.getSession().getId()+ "|ValidateTransactionProcess|";
			
			conn=poolManager.getConnection("basicpool");
			CallableStatement callableStmt=null;
			String recNo="";
			String check_detail_str="";
			String _languageCode=req.getParameter("language");
			String _countryCode =req.getParameter("country");
			out=res.getWriter();
			/*systemProperties=RezGatewaySystemProperties.getInstance();
			iManager=RezGatewayResInternationalizationManager.getInstance();
			__resAgentName=(String)systemProperties.getProperty("ResAgentName");
			__servletURL=(String)systemProperties.getProperty("ServletUrl-https"); 
			 
			
			
			
			String __schemaName=(String)systemProperties.getProperty("SchemaName");
			String __ClientHomeUrl=(String)systemProperties.getProperty("ClientHomeUrlSecure");
			String __SSLImageURL=(String)systemProperties.getProperty("SSL_ImageUrl-https");  
			String _ResAg=(String)systemProperties.getProperty("ReservationAgent");
			String _HomeUrl=(String)systemProperties.getProperty("HomeUrlSecure");
			String _ResvURL = ""+_HomeUrl+""+_ResAg+"";
			String HotelLocStrRetrieveUrl = systemProperties.getProperty("HotelLocStrRetrieveUrl").toString().trim();
			String __mainPageURL =(String)systemProperties.getProperty("MakeReservationUrlSecure");
			String _languageCode=req.getParameter("language");
			String _StyleSheetUrl = (String)systemProperties.getProperty("StyleSheetUrlSecure").toString().trim();
			String __AffiliateLogoUploadUrlReal =(String)systemProperties.getProperty("AffiliateLogoUploadUrlRealSSL");
//			String _countryCode =(String)systemProperties.getProperty("Country");
			
			String afflnetcode =(String)systemProperties.getProperty("AffCode_LondonNet").toString().trim();
			String styles ="";// " \r\n"+req.getParameter("StyleObj").toString();
			String hidStr ="";// "<input type=Hidden name=StyleObj value='"+req.getParameter("StyleObj").toString()+"'>\r\n"; 
			
			
		//	System.out.println("--------------------------");
			
//			System.out.println("CountryCode..........."+ _countryCode);
//			System.out.println("LanguageCode..........."+ _languageCode);
			
			ResourceBundle __resFirstBundle=iManager.getBundle(_countryCode,_languageCode); */
			
		//	System.out.println("After.........................11111");
			
			String roomList="";
//			for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfRooms"));__i++){ 
			for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfAdults"));__i++){
				roomList=roomList+" "+req.getParameter("Res_Sel_Cust_Title_"+__i+"")+" "+req.getParameter("Res_txt_Room_FName_"+__i+"")+" "+req.getParameter("Res_txt_Room_LName_"+__i+"")+" ("+req.getParameter("Res_Cus_Age_"+__i+"")+")/";
			}
			
			Statement __stmt=null;
			__stmt = conn.createStatement();
			appendingvalues += millisecondsToString("|",System.currentTimeMillis());
			try{
				
				
				callableStmt =  conn.prepareCall("{call travelbooking.PR_UPDATE_RES_BEFORE_CONF(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)};"+
//				callableStmt =  conn.prepareCall("BEGIN travelbooking.PR_UPDATE_RES_BEFORE_CONF(:1,:2"
////						+ ",:3,:4,:5,:6,:7,:8,:9,:10,:11,:12,:13,:14,:15,:16, "+
////					":17,:18,:19,:20,:21,:22,:23,:24,:25,:26,:27,:28,:29,:30,:31,:32,:33,:34,:35,:36,:37,:38,:39,:40,:41"
////					+ ",:42,:43,:44,:45,:46"
//					+ ");END;");
			    "");
				//callableStmt = conn.prepareCall("BEGIN travelbooking.PR_UPDATE_RES_BEFORE_CONF(:1);END;");
				callableStmt.setString(1,req.getParameter("hidHotCode"));
				
				
				
				
//				if(_languageCode.equals("en")){
					callableStmt.setString(2,req.getParameter("Res_txt_FName"));
					callableStmt.setString(3,req.getParameter("Res_txt_LName")); 
//				}else {
//					callableStmt.setString(2,req.getParameter("TransRes_txt_FName"));
//					callableStmt.setString(3,req.getParameter("TransRes_txt_LName")); 
//					
//				}
			
				
				callableStmt.setString(4,req.getParameter("Res_Sel_Cust_Title"));
				callableStmt.setString(5,req.getParameter("Res_txt_Phone"));
				callableStmt.setString(6,req.getParameter("Res_txt_Email"));
				
				
//				if(_languageCode.equals("en")){
				callableStmt.setString(7,req.getParameter("Res_txt_Address1"));
				callableStmt.setString(8,req.getParameter("Res_txt_Address2"));
				callableStmt.setString(9,req.getParameter("Res_txt_City"));
				/*}else {
				callableStmt.setString(7,req.getParameter("TransRes_txt_Address1"));							
				callableStmt.setString(8,req.getParameter("TransRes_txt_Address2"));
				callableStmt.setString(9,req.getParameter("TransRes_txt_City"));
				}*/
				

			
				callableStmt.setString(10,req.getParameter("Res_txt_State"));
				callableStmt.setString(11,req.getParameter("Res_txt_Zip"));				
				callableStmt.setString(12,req.getParameter("res_sel_Country"));
				
				callableStmt.setString(13,req.getParameter("cmbCardType"));
				callableStmt.setString(14,req.getParameter("Res_txt_CName"));
				callableStmt.setString(15,req.getParameter("Res_txt_ccNo"));
				callableStmt.setString(16,(Integer.parseInt(req.getParameter("cmbExpMonth"))+1)+"/"+req.getParameter("cmbExpYear"));
				callableStmt.setString(17,req.getParameter("cmbStrMonth")+"/"+req.getParameter("cmbStrYear"));
				callableStmt.setString(18,req.getParameter("Res_Issue_No"));
				
				
				callableStmt.setString(19,req.getParameter("txaRequest"));
				callableStmt.setString(20,req.getParameter("Hid_arv_time"));
				callableStmt.setString(21,req.getParameter("res_sel_purposeStay"));
				callableStmt.setString(22,req.getParameter("res_sel_hearAbout"));
				callableStmt.setString(23,req.getParameter("roomTypeCode"));
				
				
				
				callableStmt.setString(24,req.getParameter("bedtypecode"));
				callableStmt.setString(25,req.getParameter("checkInDate"));
				
				
					
				callableStmt.setString(26,req.getParameter("checkOutDate"));
				callableStmt.setString(27,req.getParameter("noOfRooms").trim());
				callableStmt.setString(28,req.getParameter("noOfNights").trim());
				callableStmt.setString(29,req.getParameter("noOfAdults").trim());
				callableStmt.setString(30,req.getParameter("noOfStudent"));
				callableStmt.setString(31,req.getParameter("noOfChildren"));
				
				
				callableStmt.registerOutParameter(32,java.sql.Types.CHAR);
				callableStmt.setString(33,req.getParameter("rplcode").trim());
				
				
				
				callableStmt.setString(34,roomList);
				callableStmt.setString(35,req.getParameter("TotalPayable").trim());
				callableStmt.setString(36,req.getParameter("paidAmount"));
				callableStmt.setString(37,req.getParameter("balAmount"));
				
				
				callableStmt.setString(38,"TRS");
//				callableStmt.setString(39,"INT");
//				callableStmt.setString(40,"-");
//				callableStmt.setString(41,"-");
				
				
				callableStmt.registerOutParameter(38,java.sql.Types.CHAR);	
//				callableStmt.setString(43,req.getParameter("Utp").trim());
//				callableStmt.setString(44,req.getParameter("srchNm").trim());
				callableStmt.setString(39,_languageCode);
				callableStmt.setString(40,_countryCode);
//				callableStmt.registerOutParameter(32,java.sql.Types.CHAR);	
				System.out.println("TEst to u");
				callableStmt.execute();
				
				
				
				
				
				recNo=callableStmt.getString(32);
//				check_detail_str=callableStmt.getString(42);
				callableStmt.close();
				
			}catch(Exception e){
				out.println("SQL ERROR"+e.toString());
				e.printStackTrace();
				System.out.println("Err.........................1");
			
			}
	//		System.out.println(".........................1");
			appendingvalues += millisecondsToString("|",System.currentTimeMillis());
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"); 
			out.println("<html>"); 
			out.println("<head>"); 
			out.println("<title>Please Wait ...</title>"); 
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
			
			out.println("<script language=\"javascript\">ac_fl_runcontent = 0;</script> \r\n");
			out.println("<script language=\"javascript\" src=\"../images/ac_runactivecontent.js\"></script>\r\n");

			
			out.println("<script language=\"javascript\">\r\n");
			out.println("if (ac_fl_runcontent == 0) {\r\n");
			out.println("} else {\r\n");
			out.println("ac_fl_runcontent(\r\n");
			out.println("\"codebase\",\"https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0\",\r\n");
			out.println("\"width\",\"600\",\r\n");
			out.println("\"height\",\"175\",\r\n");
			out.println("\"src\",\"../images/leo_card_Trans.swf\",\r\n");
			out.println("\"quality\",\"high\",\"pluginspage\",\"https://www.macromedia.com/go/getflashplayer\",\"align\",\"middle\",\"play\",\"true\",\"loop\",\"false\",\"scale\",\"noscale\",\"wmode\",\"window\",\"devicefont\",\"false\",\r\n");
			out.println("\"id\",\"flashanim\",\r\n");
			out.println("\"bgcolor\",\"#ffffff\",\r\n");
			out.println("\"name\",\"leo_card_Trans\",\r\n");
			out.println("\"menu\",\"false\",\"allowscriptaccess\",\"samedomain\",\r\n");
			out.println("\"movie\",\"../images/leo_card_Trans.swf\",\r\n");
			out.println("\"salign\",\"\");\r\n");
			out.println("}\r\n");
			out.println("</script>\r\n");
			
			
			
			out.println("<script>\n");
			out.println("function openWin(url){ \n");
			out.println("window.open(url);\r\n");
			out.println("} \n");
			out.println("function loadFinal(){ \n");
			out.println(" document.frm1.submit();\r\n");
			out.println("} \n");
			out.println("function opHm(url) { \r\n");
	    	out.println("	window.open(url,'HomePage','width=800, height=600, location=yes, menubar=yes, status=yes, toolbar=yes, scrollbars=yes, resizable=yes'); \r\n");
	    	out.println("} \r\n");
	    	
	    	boolean _lookfeel = req.getParameter("afftCode").equals("AFF62")||req.getParameter("afftCode").equals("AFF124")||req.getParameter("afftCode").equals("AFF138")||req.getParameter("afftCode").equals("AFF139")||req.getParameter("afftCode").equals("AFF140")||req.getParameter("afftCode").equals("AFF141") || req.getParameter("afftCode").equals("RA");
	    	
			out.println("</script> \n");
			
			out.println("<link href=\"../css/styles_"+req.getParameter("afftCode")+".css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
			
			out.println("</head> \r\n");
			if(_lookfeel){
				out.println("<body leftmargin=\"0\" topmargin=\"0\" class=\"nobodybg\" onload=\"loadFinal();\" topmargin=\"0\" leftmargin=\"0\">\r\n");
				
			}else
//			if(req.getParameter("afftCode").equals(afflnetcode))
			out.println("<body leftmargin=\"0\" topmargin=\"0\" class=\"bgsearch\" onload=\"loadFinal();\" topmargin=\"0\" leftmargin=\"0\">\r\n");
//			else
//			out.println("<body leftmargin=\"0\" topmargin=\"0\" class=\"nobodybg\" onload=\"loadFinal();\" topmargin=\"0\" leftmargin=\"0\">\r\n");
//			if(req.getParameter("afftCode").equals(afflnetcode))
//			{
//				out.println("<DIV class=toplookup align=center></DIV>\r\n");
//				out.println("<DIV class=bgsearch align=center>\r\n");
//				out.println("<DIV class=bordersearch id=bordersearch align=center>\r\n");
////				__sbr.append("<div id=\"splashScreen\"  align=\"center\" style=\"position:absolote; width:104px; height:100%; background-color: #FFFFFF; display:none \">\r\n");//
//			}
			
			
			out.println("<form name=frm1 method=POST action='../hotels/ReservationFinal'> \r\n");
			
		//	System.out.println(".........................2");
			if (req.getParameter("afftCode").equals("RA")){
				
				out.println("<table width=\"780\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"bgcolor1\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"4\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"4\" height=\"5\"></td>\r\n");
				out.println("<td width=\"772\" valign=\"top\" class=\"bgcolor3\">\r\n");
				out.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"772\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td colspan=\"6\" rowspan=\"4\" valign=\"top\"><img src=\"../images/logo_pt3.gif\" alt=\"Travelstay\" width=\"132\" height=\"97\"></td>\r\n");
				out.println("<td colspan=\"3\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"640\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"170\"><img src=\"../images/logo_pt2.gif\" alt=\"Travelstay\" width=\"170\" height=\"78\"></td>\r\n");
				out.println("<td width=\"470\" class=\"bgcolor1\" align=\"center\"><img height=\"60\" src=\"../images/s.gif\" alt=\"\" width=\"380\" border=\"0\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"625\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"625\" height=\"3\"></td>\r\n");
				out.println("<td colspan=\"2\" rowspan=\"2\"><img src=\"../images/cnr_pbc_tr.gif\" alt=\"\" width=\"15\" height=\"15\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"625\" class=\"bgcolor3\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"625\" height=\"12\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"625\" class=\"bgcolor3\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"625\" height=\"4\"></td>\r\n");
				out.println("<td width=\"12\" class=\"bgcolor3\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"12\" height=\"4\"></td>\r\n");
				out.println("<td width=\"3\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"3\" height=\"4\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table></td>\r\n");
				out.println("<td width=\"4\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"4\" height=\"5\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table>\r\n");
				
				out.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"780\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"4\" class=\"bgcolor1\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"4\" height=\"5\"></td>\r\n");
				out.println("<td width=\"772\" valign=\"top\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"772\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"3\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"3\" height=\"20\"></td>\r\n");
				out.println("<td width=\"5\" class=\"bgcolor6\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"5\" height=\"20\"></td>\r\n");
				out.println("<td width=\"104\" valign=\"middle\" class=\"bgcolor6\"><img src=\"../images/lowest_gurannree_blue.gif\" alt=\"\" width=\"104\" height=\"87\"></td>\r\n");
				out.println("<td width=\"5\" class=\"bgcolor6\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"5\" height=\"20\"></td>\r\n");
				out.println("<td width=\"3\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"3\" height=\"20\"></td>\r\n");
				out.println("<td width=\"12\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"12\" height=\"12\"></td>\r\n");
				out.println("<td width=\"625\" align=\"center\"><table width=\"461\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
				out.println("<tr>\r\n");
//				out.println("<td width=\"106\"><img src=\"../images/leo_card.gif\" width=\"106\" height=\"147\"></td>\r\n");
////				out.println("<td width=\"355\"><img src=\"../images/booksecure.gif\" alt=\"Contacting - Credit Card Secure Connection, Verifying - Credit Card Details, Processing - Credit Card Payment\" width=\"355\" height=\"116\"></td>\r\n");
//				out.println("<td width=\"355\"><img src=\"../images/booksecure.gif\" alt=\""+__resFirstBundle.getString("ContactCreditCard")+"\" ></td>\r\n");
				
				
				
//				out.println("</tr>\r\n");
				
				
				if(_languageCode.equals("en"))
					out.println("<td width=\"600\" align=\"center\">	<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0\" width=\"600\" height=\"175\">\r\n");
					else if(_languageCode.equals("es")||_languageCode.equals("pl"))
						out.println("<td width=\"600\" align=\"center\">	<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0\" width=\"600\" height=\"175\">\r\n");
					else
					out.println("<td width=\"600\" align=\"center\">	<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0\" width=\"600\" height=\"175\">\r\n");
					
					out.println("<param name=\"movie\" value=\"../images/leo_card_Trans.swf\">\r\n");
					out.println("<param name=\"quality\" value=\"high\">\r\n");
					
					if(_languageCode.equals("fr"))
					out.println("<embed src=\"../images/leo_card_Trans.swf\" quality=\"high\" pluginspage=\"https://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"600\" height=\"175\"></embed>\r\n");
					else if(_languageCode.equals("es")||_languageCode.equals("pl"))
						out.println("<embed src=\"../images/leo_card_Trans.swf\" quality=\"high\" pluginspage=\"https://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"600\" height=\"175\"></embed>\r\n");
					
					else
					out.println("<embed src=\"../images/leo_card_Trans.swf\" quality=\"high\" pluginspage=\"https://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"600\" height=\"175\"></embed>\r\n");
					out.println("</object>\r\n");
					out.println("</td>\r\n");
				
				out.println("</tr>\r\n");
				out.println("</table></td>\r\n");
				out.println("<td width=\"12\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"12\" height=\"7\"></td>\r\n");
				out.println("<td width=\"3\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"3\" height=\"7\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td colspan=\"5\" rowspan=\"2\"><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"120\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"15\" rowspan=\"2\"><img src=\"../images/cnr_ln_bl.gif\" alt=\"\" width=\"15\" height=\"15\"></td>\r\n");
				out.println("<td width=\"90\" class=\"bgcolor6\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"90\" height=\"12\"></td>\r\n");
				out.println("<td width=\"15\" rowspan=\"2\"><img src=\"../images/cnr_ln_br.gif\" alt=\"\" width=\"15\" height=\"15\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"90\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"90\" height=\"3\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table></td>\r\n");
				out.println("<td width=\"12\" valign=\"bottom\"><img src=\"../images/cnr_pb_bl.gif\" alt=\"\" width=\"12\" height=\"12\"></td>\r\n");
				out.println("<td width=\"625\" valign=\"bottom\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"625\" height=\"12\"></td>\r\n");
				out.println("<td colspan=\"2\" rowspan=\"2\"><img src=\"../images/cnr_pbc_br.gif\" alt=\"\" width=\"15\" height=\"15\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td width=\"12\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"12\" height=\"3\"></td>\r\n");
				out.println("<td width=\"625\" class=\"bgcolor2\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"625\" height=\"3\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table></td>\r\n");
				out.println("<td width=\"4\" class=\"bgcolor1\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"4\" height=\"5\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("<tr>\r\n");
				out.println("<td colspan=\"3\" class=\"bgcolor1\"><img src=\"../images/spacer.gif\" alt=\"\" width=\"780\" height=\"4\"></td>\r\n");
				out.println("</tr>\r\n");
				out.println("</table>\r\n");
				
				
			}else{
				
				String affDirectionUrl="";
			//	System.out.println(".........................3");
				try{
				
				ResultSet __grs = __stmt.executeQuery("SELECT NVL(LOGO_DIRECTION_URL,' ') from travelbooking.LKUP_AFFILIATE WHERE AFFILIATE_CODE='"+req.getParameter("afftCode")+"' ");
				if(__grs.next()){
					affDirectionUrl=__grs.getString(1);
					__grs.close();
				}
				
				}catch(Exception we){out.println("affiliate direction url error="+we.toString());}
				
				if(!_lookfeel)
				{
					out.println("<DIV class=toplookup align=center></DIV>\r\n");
					out.println("<DIV class=bgsearch align=center>\r\n");
					out.println("<DIV class=bordersearch id=bordersearch align=center>\r\n");
				}
				
				out.println("<table width=\"780\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
				out.println("<tr>\r\n");
				out.println("<td align=\"center\"><img src=\"../images/space.gif\" height=\"10\" width=\"1\"></td>\r\n");
				out.println("</tr>\r\n");
				//affiliate logo comes here	
				
				out.println("<tr>\r\n");
//				if(!affDirectionUrl.equals(" ")){
//				out.println("<td align=\"center\"><a href=\"JavaScript:opHm('https://"+affDirectionUrl+"');\" ><img src=\""+__AffiliateLogoUploadUrlReal+""+_languageCode+"/"+req.getParameter("afftCode")+".gif\" border=\"0\"></a></td>\r\n");
//				}else{
//				out.println("<td align=\"center\"><img src=\""+__AffiliateLogoUploadUrlReal+""+_languageCode+"/"+req.getParameter("afftCode")+".gif\"></td>\r\n");
//				}
				out.println("</tr>\r\n");
				
				out.println("<tr>\r\n");
				out.println("<td align=\"center\"><img src=\"../images/space.gif\" height=\"15\" width=\"1\"></td>\r\n");
				out.println("</tr>\r\n");
				
				out.println("<tr>\r\n");
				out.println("<td align=\"center\"><B>YOUR CREDIT CARD DETAILS ARE BEING PROCESSED. PLEASE WAIT ...</B></td>\r\n");
//				out.println("<td align=\"center\"><B>"+__resFirstBundle.getString("CreditCardProcessed")+"</B></td>\r\n");
				
				
				out.println("</tr>\r\n");
				out.println("</table>\r\n");
				
			}
			
			//System.out.println(".........................4");
			
//			out.println(hidStr);
			out.println("<INPUT type=Hidden name='cvv' value='"+req.getParameter("cvv")+"'>\r\n");
			out.println("<INPUT type=hidden name=rSource value=\""+req.getParameter("rSource")+"\" >\r\n");
			out.println("<INPUT type=Hidden name=\"bBy\" value=\""+req.getParameter("bBy")+"\">\r\n");
			
			out.println("<input type=Hidden name=\"strHotFacility\" value=\""+req.getParameter("strHotFacility")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"strBedFacility\" value=\""+req.getParameter("strBedFacility")+"\">\r\n"); 
			
			out.println("<input type=Hidden name=\"HotThumbUrl\" value=\""+req.getParameter("HotThumbUrl")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HotWebUrl\" value=\""+req.getParameter("HotWebUrl")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HotLocation\" value=\""+req.getParameter("HotLocation")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HotShrtDesc\" value=\"\">\r\n"); 
			out.println("<input type=Hidden name=\"HotStarcat\" value=\""+req.getParameter("HotStarcat")+"\">\r\n"); 
			
			out.println("<input type=Hidden name=\"chkPayment\" value=\""+req.getParameter("chkPayment")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"AffiliateMainPage\" value=\""+req.getParameter("AffiliateMainPage")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"recNo\" value=\""+recNo+"\">\r\n"); 
			out.println("<input type=Hidden name=\"StyleObj\" value=\"\">\r\n"); 
			out.println("<input type=Hidden name=\"stylesCount\" value=\"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftCode\" value=\""+req.getParameter("afftCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftType\" value=\""+req.getParameter("afftType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftParams1\" value=\""+req.getParameter("afftParams1")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftParams2\" value=\""+req.getParameter("afftParams2")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftParams3\" value=\""+req.getParameter("afftParams3")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftParams4\" value=\""+req.getParameter("afftParams4")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftParams5\" value=\""+req.getParameter("afftParams5")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hidHotCode\" value=\""+req.getParameter("hidHotCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotName\" value=\""+req.getParameter("hotName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotAddress\" value=\""+req.getParameter("hotAddress")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"roomTypeCode\" value=\""+req.getParameter("roomTypeCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"roomType\" value=\""+req.getParameter("roomType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"bedtypecode\" value=\""+req.getParameter("bedtypecode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"bedType\" value=\""+req.getParameter("bedType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"rateCode\" value=\""+req.getParameter("rateCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"checkInDate\" value=\""+req.getParameter("checkInDate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"checkOutDate\" value=\""+req.getParameter("checkOutDate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"noOfRooms\" value=\""+req.getParameter("noOfRooms")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"noOfAdults\" value=\""+req.getParameter("noOfAdults")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"noOfChildren\" value=\""+req.getParameter("noOfChildren")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"cityCode\" value=\""+req.getParameter("cityCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"noOfNights\" value=\""+req.getParameter("noOfNights")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"language\" value=\""+req.getParameter("language")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"country\" value=\""+req.getParameter("country")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"browser\" value=\""+req.getParameter("browser")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"unFormatedDate\" value=\""+req.getParameter("unFormatedDate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotCity\" value=\""+req.getParameter("hotCity")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotCountry\" value=\""+req.getParameter("hotCountry")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotPhone\" value=\""+req.getParameter("hotPhone")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_Sel_Cust_Title\" value=\""+req.getParameter("Res_Sel_Cust_Title")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_FName\" value=\""+req.getParameter("Res_txt_FName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_LName\" value=\""+req.getParameter("Res_txt_LName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_Phone\" value=\""+req.getParameter("Res_txt_Phone")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_Email\" value=\""+req.getParameter("Res_txt_Email")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_Address1\" value=\""+req.getParameter("Res_txt_Address1")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_Address2\" value=\""+req.getParameter("Res_txt_Address2")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_City\" value=\""+req.getParameter("Res_txt_City")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_State\" value=\""+req.getParameter("Res_txt_State")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_Zip\" value=\""+req.getParameter("Res_txt_Zip")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"res_sel_Country\" value=\""+req.getParameter("res_sel_Country")+"\">\r\n"); 
			
			String txaRequest=ReplaceString(req.getParameter("txaRequest"), "'", "\"");
			out.println("<input type=Hidden name='txaRequest' value='"+txaRequest+"'>\r\n"); 

			out.println("<input type=Hidden name=\"cmbCardType\" value=\""+req.getParameter("cmbCardType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_CName\" value=\""+req.getParameter("Res_txt_CName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"Res_txt_ccNo\" value=\""+req.getParameter("Res_txt_ccNo")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"cmbExpMonth\" value=\""+req.getParameter("cmbExpMonth")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"cmbExpYear\" value=\""+req.getParameter("cmbExpYear")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"ratePlanCode\" value=\""+req.getParameter("ratePlanCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"ShowcheckInDate\" value=\""+req.getParameter("ShowcheckInDate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"ShowcheckOutDate\" value=\""+req.getParameter("ShowcheckOutDate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"State\" value=\""+req.getParameter("State")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hidCountryName\" value=\""+req.getParameter("hidCountryName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotFaxNo\" value=\""+req.getParameter("hotFaxNo")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotZip\" value=\""+req.getParameter("hotZip")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hidCardType\" value=\""+req.getParameter("hidCardType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotEmail\" value=\""+req.getParameter("hotEmail")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"stdRate\" value=\""+req.getParameter("stdRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"addRate\" value=\""+req.getParameter("addRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"childRate\" value=\""+req.getParameter("childRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totDayRate\" value=\""+req.getParameter("totDayRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"CodebedType\" value=\""+req.getParameter("CodebedType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"afftCode\" value=\""+req.getParameter("afftCode")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"requetsbooking\" value=\""+req.getParameter("requetsbooking")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"adultSvPctBedTyp\" value=\""+req.getParameter("adultSvPctBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"paidAmount\" value=\""+req.getParameter("paidAmount")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"depositType\" value=\""+req.getParameter("depositType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"balAmount\" value=\""+req.getParameter("balAmount")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"discountType\" value=\""+req.getParameter("discountType")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"multBook\" value=\""+req.getParameter("multBook")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"adultRatesTypes\" value=\""+req.getParameter("adultRatesTypes")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"studRatesTypes\" value=\""+req.getParameter("studRatesTypes")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"adultsNumByBedTyp\" value=\""+req.getParameter("adultsNumByBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"studNumByBedTyp\" value=\""+req.getParameter("studNumByBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"adultRateBedTyp\" value=\""+req.getParameter("adultRateBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"childRateBedTyp\" value=\""+req.getParameter("childRateBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"studRateBedTyp\" value=\""+req.getParameter("studRateBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totalRate\" value=\""+req.getParameter("totalRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totalStudRate\" value=\""+req.getParameter("totalStudRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totalChildRate\" value=\""+req.getParameter("totalChildRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totalAdultRate\" value=\""+req.getParameter("totalAdultRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"studSvPctRateBedTyp\" value=\""+req.getParameter("studSvPctRateBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"rackRateBedTyp\" value=\""+req.getParameter("rackRateBedTyp")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"adultRate\" value=\""+req.getParameter("adultRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"studentRate\" value=\""+req.getParameter("studentRate")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"noOfStudent\" value=\""+req.getParameter("noOfStudent")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"freeChild\" value=\""+req.getParameter("freeChild")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HidHotelLink\" value=\""+req.getParameter("HidHotelLink")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"hotContactPer\" value=\""+req.getParameter("hotContactPer")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HidHotelMap\" value=\""+req.getParameter("HidHotelMap")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HidWholeSelId\" value=\""+req.getParameter("HidWholeSelId")+"\">\r\n"); 
			out.println("<INPUT type=Hidden name=\"HidHotelLink\" value=\""+req.getParameter("HidHotelLink")+"\">\r\n");
			out.println("<INPUT type=Hidden name=\"CallCenCode\" value=\""+req.getParameter("CallCenCode")+"\">\r\n");
			out.println("<INPUT type=Hidden name=\"Clientcountry\" value=\""+req.getParameter("Clientcountry")+"\">\r\n");
			out.println("<INPUT type=Hidden name=\"afficommision\" value=\""+req.getParameter("afficommision")+"\">\r\n");
			if(req.getParameter("cmbStrMonth")==null){
				out.println("<input type=Hidden name=\"cmbStrMonth\" value=\"-\">\r\n"); 
			}else{
				out.println("<input type=Hidden name=\"cmbStrMonth\" value=\""+req.getParameter("cmbStrMonth")+"\">\r\n"); 
			}
			if(req.getParameter("cmbStrYear")==null){
				out.println("<input type=Hidden name=\"cmbStrYear\" value=\"-\">\r\n"); 
			}else{
				out.println("<input type=Hidden name=\"cmbStrYear\" value=\""+req.getParameter("cmbStrYear")+"\">\r\n"); 
			}
			if(req.getParameter("Res_Issue_No")==null){
				out.println("<input type=Hidden name=\"Res_Issue_No\" value=\"\">\r\n"); 
			}else{
				out.println("<input type=Hidden name=\"Res_Issue_No\" value=\""+req.getParameter("Res_Issue_No")+"\">\r\n"); 
			}
			
			out.println("<input type=Hidden name=\"Hid_arv_time\" value=\""+req.getParameter("Hid_arv_time")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"res_sel_purposeStay\" value=\""+req.getParameter("res_sel_purposeStay")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"res_sel_hearAbout\" value=\""+req.getParameter("res_sel_hearAbout")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"HidBookFee\" value=\""+req.getParameter("HidBookFee")+"\">\r\n");
			out.println("<input type=Hidden name=\"Ridehotelcode\" value=\""+req.getParameter("Ridehotelcode")+"\">\r\n"); 
			
		//	System.out.println(".........................4");
			
			
			String lname="";
			String fname="";
//			for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfRooms"));__i++){ 
			for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfAdults"));__i++){ 
				lname=ReplaceString(req.getParameter("Res_txt_Room_LName_"+__i+""), "'", "`");
				fname=ReplaceString(req.getParameter("Res_txt_Room_FName_"+__i+""), "'", "`");

				out.println("<input type=\"Hidden\" name=\"Res_Sel_Cust_Title_"+__i+"\" value=\""+req.getParameter("Res_Sel_Cust_Title_"+__i+"")+"\">\r\n");
				out.println("<input type=\"Hidden\" name=\"Res_txt_Room_FName_"+__i+"\" value=\""+fname+"\">\r\n");
				out.println("<input type=\"Hidden\" name=\"Res_txt_Room_LName_"+__i+"\" value=\""+lname+"\">\r\n");
				out.println("<input type=\"Hidden\" name=\"Hid_chk_stud_"+__i+"\" value=\""+req.getParameter("Hid_chk_stud_"+__i+"")+"\">\r\n");
				out.println("<input type=\"Hidden\" name=\"Res_Cus_Age_"+__i+"\" value=\""+req.getParameter("Res_Cus_Age_"+__i+"")+"\">\r\n");
				
			}
			
			out.println("<input type=Hidden name=\"chkEmailList\" value=\""+req.getParameter("chkEmailList")+"\">\r\n"); 
			
			out.println("<input type=Hidden name=\"chkMember\" value=\""+req.getParameter("chkMember")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"txtUserName\" value=\""+req.getParameter("txtUserName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"txtPassWord\" value=\""+req.getParameter("txtPassWord")+"\">\r\n"); 
			
			
			for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfNights"));__i++){
				out.println("<input type=Hidden name=\""+__i+"_stDate\" value=\""+req.getParameter(""+__i+"_stDate")+"\">\r\n"); 
				out.println("<input type=Hidden name=\""+__i+"_dayRate\" value=\""+req.getParameter(""+__i+"_dayRate")+"\">\r\n"); 
				out.println("<input type=Hidden name=\""+__i+"_StudentdayRate\" value=\""+req.getParameter(""+__i+"_StudentdayRate")+"\">\r\n"); 
				out.println("<input type=Hidden name=\""+__i+"_ChilddayRate\" value=\""+req.getParameter(""+__i+"_ChilddayRate")+"\">\r\n"); 
				out.println("<input type=Hidden name=\""+__i+"_dayTotal\" value=\""+req.getParameter(""+__i+"_dayTotal")+"\">\r\n"); 
				out.println("<input type=Hidden name=\""+__i+"_dayTotal\" value=\""+req.getParameter(""+__i+"_dayTotal")+"\">\r\n"); 
			}
			out.println("<input type=Hidden name=\"subTotal\" value=\""+req.getParameter("subTotal")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"TotalPayable\" value=\""+req.getParameter("TotalPayable")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"visitorInfo\" value=\""+req.getParameter("visitorInfo")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"totalPriceDiff\" value=\""+req.getParameter("totalPriceDiff")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"check_detail_str\" value=\""+check_detail_str+"\">\r\n"); 
			out.println("<input type=\"hidden\" name=\"ShowcheckInDateDisp\" value=\""+req.getParameter("ShowcheckInDateDisp")+"\">\r\n");
			out.println("<input type=\"hidden\" name=\"ShowcheckOutDateDisp\" value=\""+req.getParameter("ShowcheckOutDateDisp")+"\">\r\n");
	
			out.println("<input type=\"hidden\" name=\"rPlCde\" value=\""+req.getParameter("rPlCde")+"\">\r\n");
			
			if(!_languageCode.equals("en")){
			
			
			out.println("<input type=Hidden name=\"TransRes_txt_FName\" value=\""+req.getParameter("TransRes_txt_FName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"TransRes_txt_LName\" value=\""+req.getParameter("TransRes_txt_LName")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"TransRes_txt_Address1\" value=\""+req.getParameter("TransRes_txt_Address1")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"TransRes_txt_Address2\" value=\""+req.getParameter("TransRes_txt_Address2")+"\">\r\n"); 
			out.println("<input type=Hidden name=\"TransRes_txt_City\" value=\""+req.getParameter("TransRes_txt_City")+"\">\r\n"); 
			
			}
			
			
//			System.out.println("Validate rplcde"+req.getParameter("rPlCde"));
			
			out.println("</form>\r\n"); 
			if(!_lookfeel)
			{
				out.println("</div>\r\n");
				out.println("</div>\r\n");
				out.println("<script language=\"javascript\">");	
				out.println("document.getElementById('bordersearch').style.height=screen.height-250;\r\n");
				out.println("</script>\r\n");
			}
//			System.out.println(".........................5");
			out.println("<!--BEGINNING OF DEEPMETRIX STATSCRIPT-->\r\n");	
			out.println("<script language=\"javascript\">");	
			out.println("var DMdomain = \"\";");	
			out.println("var DMpage = window.location;");	
			out.println("var DMVersion = 86;");	
			out.println("var DMsendTo = \"//collector.deepmetrix.com/dm.gif?\";");	
			out.println("var DMsession;");	
			out.println("function dmerr(){return true;}window.onerror=dmerr;");	
			out.println("var u3k8u6y1j3 = new Date();");	
			out.println("if (navigator.userAgent.indexOf('Mac') >= 0 && u3k8u6y1j3.getTimezoneOffset() >= 720){");	
			out.println("u3k8u6y1j3.setTime (u3k8u6y1j3.getTime() - 1440*60*1000);}");	
			out.println("var u3k8u6y1 = location.protocol+DMsendTo+\"v=\"+DMVersion+\"&vst=1\";");	
			out.println("var u3k8u6 = document.cookie.toString();if(u3k8u6.indexOf(\"_dmid\") == -1)");	
			out.println("{DMsession = parseInt( Math.random()*1000000 ) + \"_\" + u3k8u6y1j3.getTime();");	
			out.println("var u3k8 = \"\";if(DMdomain != \"\"){u3k8 = \"domain=\"+ DMdomain +\";\";}");	
			out.println("document.cookie = \"_dmid=\" + DMsession + \";expires=Mon, 31-Dec-2008 00:00:00GMT;\"+u3k8+\"path=/;\";}");	
			out.println("u3k8u6 = document.cookie.toString();if(u3k8u6.indexOf('_dmid') ==-1){DMsession = \"\";}");	
			out.println("else{if(u3k8u6.indexOf(';') == -1){u3k8u6 = u3k8u6.replace(/_dm/g,';_dm');}var u3 = u3k8u6.indexOf(\"_dmid=\") + 6;");	
			out.println("var g5b1z7i5z6 = u3k8u6.indexOf(\";\",u3);if (g5b1z7i5z6 == -1){g5b1z7i5z6 =u3k8u6.length;}");	
			out.println("DMsession = unescape(u3k8u6.substring(u3,g5b1z7i5z6));}");	
			out.println("u3k8u6y1 += \"&id=\"+DMsession+\"&url=\"+escape(DMpage) +\"&ref=\"+escape(document.referrer)+\"&lng=\" + ((!document.all || navigator.userAgent.match('Opera')) ? navigator.language: navigator.userLanguage) + \"&tz=\" + (Math.round(new Date('dec 1, 2002').getTimezoneOffset()/60)*-1);");
			out.println("if(screen){u3k8u6y1 += \"&scr=\" + escape( screen.width + \"x\" + screen.height+ \" \" + screen.colorDepth + \"bpp\" );}");
			out.println("u3k8u6y1 += \"&rnd=\" + new Date().getTime();if(document.layers){");
			out.println("document.write(\"<la\"+\"yer name=\\\"DMStats\\\" visibility=hide><img src=\\\"\"+u3k8u6y1+\"\\\" height=1 width=1></la\"+\"yer>\");");
			out.println("}else{document.write(\"<di\"+\"v id=\\\"DMStats\\\" STYLE=\\\"position:absolute;visibility:hidden;\\\"><imgsrc=\\\"\"+u3k8u6y1+\"\\\" height=1 width=1></di\"+\"v>\");}");
			out.println("</script>\r\n");
			out.println("<!--END OF DEEPMETRIX STATSCRIPT-->\r\n");
			
			out.println("</body>\r\n"); 
			
			
			out.println("</html>\r\n");  
		//	System.out.println(".........................6");
			HttpSession session = req.getSession(true);
			//System.out.println(".........................7");
			try{
			//	System.out.println(".........................8");
				session.setAttribute(""+__resAgentName+"_FNAME",""+req.getParameter("Res_txt_FName")+"");
				session.setAttribute(""+__resAgentName+"_LNAME",""+req.getParameter("Res_txt_LName")+"");
				session.setAttribute(""+__resAgentName+"_TITLE",""+req.getParameter("Res_Sel_Cust_Title")+"");
				session.setAttribute(""+__resAgentName+"_PHONE",""+req.getParameter("Res_txt_Phone")+"");
				session.setAttribute(""+__resAgentName+"_EMAIL",""+req.getParameter("Res_txt_Email")+"");
				session.setAttribute(""+__resAgentName+"_ADD1",""+req.getParameter("Res_txt_Address1")+"");
				session.setAttribute(""+__resAgentName+"_ADD2",""+req.getParameter("Res_txt_Address2")+"");
				session.setAttribute(""+__resAgentName+"_CITY",""+req.getParameter("Res_txt_City")+"");
				session.setAttribute(""+__resAgentName+"_STATE",""+req.getParameter("Res_txt_State")+"");
				session.setAttribute(""+__resAgentName+"_ZIP",""+req.getParameter("Res_txt_Zip")+"");
				session.setAttribute(""+__resAgentName+"_COUNTRY",""+req.getParameter("res_sel_Country")+"");
				
				String spcRq=ReplaceString(req.getParameter("txaRequest"), "\r\n", "<br>");
				session.setAttribute(""+__resAgentName+"_SPCREQ",""+spcRq+"");
				
				session.setAttribute(""+__resAgentName+"_ARVTIME",""+req.getParameter("Hid_arv_time")+"");
				session.setAttribute(""+__resAgentName+"_PSTAY",""+req.getParameter("res_sel_purposeStay")+"");
				session.setAttribute(""+__resAgentName+"_HABOUT",""+req.getParameter("res_sel_hearAbout")+"");
				/*
				session.setAttribute(""+__resAgentName+"_CCTYP",""+req.getParameter("cmbCardType")+"");
				session.setAttribute(""+__resAgentName+"_CCNO",""+req.getParameter("Res_txt_ccNo")+"");
				session.setAttribute(""+__resAgentName+"_CCNM",""+req.getParameter("Res_txt_CName")+"");
				session.setAttribute(""+__resAgentName+"_EXPMM",""+req.getParameter("cmbExpMonth")+"");
				session.setAttribute(""+__resAgentName+"_EXPYY",""+req.getParameter("cmbExpYear")+"");
				session.setAttribute(""+__resAgentName+"_ISNO",""+req.getParameter("Res_Issue_No")+"");
				session.setAttribute(""+__resAgentName+"_STRMM",""+req.getParameter("cmbStrMonth")+"");
				session.setAttribute(""+__resAgentName+"_STRYY",""+req.getParameter("cmbStrYear")+"");
				*/
//				for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfRooms"));__i++){ 
				for(int __i=0;__i<Integer.parseInt(req.getParameter("noOfAdults"));__i++){ 								
					session.setAttribute(""+__resAgentName+"_FNAME"+__i+"",""+req.getParameter("Res_txt_Room_FName_"+__i+"")+"");
					session.setAttribute(""+__resAgentName+"_LNAME"+__i+"",""+req.getParameter("Res_txt_Room_LName_"+__i+"")+"");
					session.setAttribute(""+__resAgentName+"_AGGRP"+__i+"",""+req.getParameter("Res_Cus_Age_"+__i+"")+"");
					session.setAttribute(""+__resAgentName+"_TITLE"+__i+"",""+req.getParameter("Res_Sel_Cust_Title_"+__i+"")+"");
				}
				
			//	System.out.println(".........................10");
			}catch(Exception e){ 
				e.printStackTrace();
			//out.println("SESSION ERROR"+e.toString());
			}
			
			appendingvalues += millisecondsToString("|",System.currentTimeMillis());
			mywritetofile(appendingvalues);
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("Err.........................2");
			//out.println("BBBBB"+e.toString());
			}
		finally{
			try{poolManager.freeConnection(conn);}catch(Exception e){}
			try{out.close();}catch(Exception e){out.println("AAA"+e.toString());}	
		}
		
	}
	
	private String ReplaceString(String repString, String token, String replaceElem) {
		int index = -1;
		while ( (index = repString.indexOf(token)) > -1) {
			repString = repString.substring(0, index) + replaceElem +
				repString.substring(index + token.length(), repString.length());
		}
		return repString;
	}
	
	private static void mywritetofile(String mMsg)
	{
		try{ 
			java.text.SimpleDateFormat _format1= new java.text.SimpleDateFormat("MMM-dd-yyyy hh:mm:ss");
			java.text.SimpleDateFormat _format= new java.text.SimpleDateFormat("MMM-dd-yyyy");
//		 String logFileName = "D:\\WEBLOGS\\SYSTEM_LOGS\\HotelSetupHotelPageCreator.txt"; 
		 
		 java.util.Date m_Date = new java.util.Date(); 	
		 String logFileName = "D:\\WEBLOGS\\SYSTEM_LOGS\\"+System.getProperty("RzName")+"reservationbookingsave_"+_format.format(m_Date)+".txt"; 
		 FileOutputStream fout = new FileOutputStream(logFileName,true); 	
		 mMsg=_format1.format(m_Date)+"->>"+mMsg+"\n";
		 fout = new FileOutputStream(logFileName,true); 
		 fout.write((mMsg+"\r\n").getBytes()); fout.close(); 
		 }catch(Exception e){ 
		 
		 } 
   
  
	}
	
	public String millisecondsToString(String Name, long time)
    {
        int milliseconds = (int)(time % 1000L);
        int seconds = (int)((time / 1000L) % 60L);
        int minutes = (int)((time / 60000L) % 60L);
        int hours = (int)((time / 0x36ee80L) % 24L);
        String millisecondsStr = (milliseconds >= 10 ? milliseconds >= 100 ? "" : "0" : "00") + milliseconds;
        String secondsStr = (seconds >= 10 ? "" : "0") + seconds;
        String minutesStr = (minutes >= 10 ? "" : "0") + minutes;
        String hoursStr = (hours >= 10 ? "" : "0") + hours;
        String str = new String(hoursStr + ":" + minutesStr + ":" + secondsStr + "." + millisecondsStr);
        str = Name + "|" + str;
        return str;
    }
	}
