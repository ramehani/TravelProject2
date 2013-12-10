<!DOCTYPE html>
<html><head>
<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="SKYPE_TOOLBAR" content="SKYPE_TOOLBAR_PARSER_COMPATIBLE">
<meta name="Title" content="Atlantic City Hotels, lodging and great Deals, Lodging, Atlantic City Casino Hotels">
<title>Atlantic City Hotels, lodging and great Deals, Lodging, Atlantic City Casino Hotels</title>

<script src="../js/ga.js" async="" type="text/javascript"></script><script type="text/javascript" src="../js/jquery-1.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/onload.js"></script>
<!-- Add jquery UI CSS and JS files -->
<script type="text/javascript" src="../js/jquery-ui-1.js"></script>
<!-- Add fancyBox main JS and CSS files -->

<style type="text/css" media="all"><!--
		@import url("../css/jquery-ui-1.8.12.custom.css");
		@import url("../css/reset.css");
		@import url("../css/demo.css?version=66.686");
		@import url("../css/searchSuggests.css?version=6.66");
		@import url("../css/text.css?version=6.66");
		@import url("../css/jquery.fancybox.css?version=6.66");
		@import url("../css/styles_nwl_RA.css?version=66.686");
	--></style>


<script src="details_files/PIE.htm" type="text/javascript"></script>
<script type="text/javascript" src="../js/booking.js"></script>


<script language="JavaScript" type="text/JavaScript">
<!-- Yahoo! Inc.
//			 Segment Id Name: Default Conversion Type
//			 Event Type Name: Prospect 
if (typeof(window.ysm_customData) != 'object') window.ysm_customData = new Object();
window.ysm_customData.segment_1QRKRN5GNPKR78 = "event=0,transId=,currency=,amount=";
//			 -->
</script>
 
 
<!-- google-analytics link not activated -->
<script language="JavaScript" type="text/JavaScript">
function setHid(doc){
doc.hidCountryName.value=doc.res_sel_Country.options[doc.res_sel_Country.selectedIndex].text
}

function validate(doc){
for(i=0;i< 1 ;i++){
	if(doc.elements['wheel_chk_'+i].checked){doc.elements['Hid_Wheel_Chair_'+i].value='Wheel Chair ,';}else{doc.elements['Hid_Wheel_Chair_'+i].value='';}
	if(doc.elements['handi_chk_'+i].checked){doc.elements['Hid_handi_chk_'+i].value='Handicap , ';}else{doc.elements['Hid_handi_chk_'+i].value='';}
}
	var afftCode = "RA" ;
	
	if(!isNull(doc.Res_txt_FName.value)){
		alert('Please Enter First Name');
		return false;
	}else if(doc.Res_Sel_Cust_Title.selectedIndex==0){
		alert('Please Select Title');
		return false;
	}
	else if(!isNull(doc.Res_txt_LName.value)){
		alert('Please Enter Last Name');
		return false;
	}else if(!isNull(doc.Res_txt_Phone.value)){
		alert('Please Enter Phone No.');
		return false;
	}else if(!isNull(doc.Res_txt_Email.value)) {
		alert('Please Enter a valid email address');
		return false;
	}else if(!validateEmail(doc.Res_txt_Email.value)) {
		alert('Please Enter a valid email address');
		return false;
	}else if(!isNull(doc.Res_txt_Address1.value)){
		alert('Please Enter an Address ');
		return false;
	}else if(!isNull(doc.Res_txt_City.value)) {
		alert('Please Enter a City');
		return false;
	}else if(doc.Res_txt_State.value=='-' && (doc.res_sel_Country.selectedIndex==222 ||doc.res_sel_Country.selectedIndex==38 || doc.res_sel_Country.selectedIndex==13 )) {
		alert('Please Enter a State/Province');
		return false;
	}else if(!isNull(doc.Res_txt_Zip.value)) {
		alert('Please Enter a Zip');
		return false;
	}else if(doc.res_sel_Country.selectedIndex==0) {
		alert('Please Select a country');
		return false;
	}else if(!isNull(doc.Res_txt_Room_FName_0.value)) {
		doc.Res_txt_Room_FName_0.value=doc.Res_txt_FName.value;
		doc.txt_Room_FName_0.value=doc.Res_txt_FName.value;
			if(!isNull(doc.Res_txt_Room_LName_0.value)){
				doc.Res_txt_Room_LName_0.value=doc.Res_txt_LName.value;
				doc.txt_Room_LName_0.value=doc.Res_txt_LName.value;
			}
	}else if(!isNull(doc.Res_txt_CName.value)) {
		alert('Please Enter Card holders Name. ');
		return false;
	}else if(!isNull(doc.Res_txt_ccNo.value)) {
		alert('Please Enter Credit Card No.');
		return false;
	}else if((doc.Res_txt_ccNo.value).indexOf(' ') >= 0 || !(isFinite(doc.Res_txt_ccNo.value))) {
		alert('Please Enter Valid Credit Card No.');
		return false;
	}else if(((doc.cmbCardType.selectedIndex=='0')||(doc.cmbCardType.selectedIndex=='1')) && (!checkCard(doc.Res_txt_ccNo.value))){
		alert('Please Enter a valid Credit Card No.');
		return false;
	}else if(doc.chkBookPolicy.checked==false){
		alert('Please accept the Booking Policy');
		return false;
	}

	if(afftCode == "AFF37" || afftCode == "AFF171" || afftCode == "AFF201" ){

		if(!isNull(doc.Res_conf_email.value)) {
			alert('Please Enter Confirm Email');
			return false;
		}

		if((doc.Res_txt_Email.value)!=(doc.Res_conf_email.value)) {
			alert('Please Confirm Email');
			return false;
		}
	}

	for(i=1;i<1;i++){ 
		if(doc.elements["Res_txt_Room_FName_"+i].value==""){ 
			alert('Please Enter First Name to room No. '+(i+1)+' ');
			return false;
		} 		
		if(doc.elements["Res_txt_Room_LName_"+i].value==""){
			alert('Please Enter Second Name to room No. '+(i+1)+' ');
			return false;
		} 				
	} 
	
		var hctype = "N" ;
		date2  = new Date("2013","9",01);
    	date1  = new Date(doc.cmbExpYear.options[doc.cmbExpYear.selectedIndex].value,doc.cmbExpMonth.options[doc.cmbExpMonth.selectedIndex].value-1,1);

	if(date1<date2){
   		if(hctype != null && hctype=="N"){
	   		alert("Expiry date should be more then or equal to  today's date / month.");
   		}else{
	   		alert('Expiry date should be more then or equal to  check in date / month.');
   		}
		return false;
	}else if((doc.chkMember.value==" ") && ((doc.txtUserName.value==" ") || (doc.txtPassWord.value==" "))){
		alert('Enter userName and PassWord ');
		return false;
	}

	if(afftCode == "AFF37" || afftCode == "AFF171" || afftCode == "AFF201" ){
		if(doc.chkMember.checked==true){
			doc.chkMember.value="ON" ;
		}else{
			doc.chkMember.value="OFF" ;
		}
	}else{ 
		doc.chkMember.value="OFF" ;
	}
	return true;
}

function confEmail(doc){
	var afftCode = "RA" ;

	if(afftCode == "AFF37" || afftCode == "AFF171" || afftCode == "AFF201" ){
		if(!isNull(doc.Res_conf_email.value)) {
			alert('Please Enter Confirm Email');
			return false;
		}else if((doc.Res_txt_Email.value)!=(doc.Res_conf_email.value)) {
			alert('Please Confirm Email');
			return false;
		}
	}
}

function WindowOpenUpMsg(type,hotel){
	var afftCode = "RA" ;

	if(type==1) {
		window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=3&hotCode='+hotel+'','i','width=400,height=400,scrollbars=yes,resizable=yes');
	}else if(type==2) {
	}else if(type==3) {
		window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=2','i','width=400,height=250,scrollbars=yes,resizable=yes');
	}else if(type==4) {
	
	}
	if(afftCode == "AFF37" || afftCode == "AFF171" || afftCode == "AFF201" ){
		window.open('http://www.atlanticcity.com/privacy.htm','i','width=500,height=400,scrollbars=yes,resizable=yes');
	}else{
		window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=1','i','width=500,height=400,scrollbars=yes,resizable=yes');
	}
}

function setPromoCode(obj){
	var PromoCode = obj.value; 
	PromoCode = PromoCode.toUpperCase(); 
	var arr_Pcode = new Array();
	var pcount = 0;
	var pstatus = 'N';

	arr_Pcode[pcount] ="ACFUN08" ;
	pcount++;
	arr_Pcode[pcount] ="TEST456" ;
	pcount++;
	arr_Pcode[pcount] ="GOOGLE10" ;
	pcount++;
	arr_Pcode[pcount] ="DREWTEST" ;
	pcount++;
	arr_Pcode[pcount] ="CHABADAC" ;
	pcount++;
	arr_Pcode[pcount] ="1" ;
	pcount++;
	arr_Pcode[pcount] ="FB915" ;
	pcount++;
	
 	for(i=0;i<=pcount;i++){  
 		if(PromoCode == arr_Pcode[i]){  
 			pstatus = 'Y'; 
 			break;
 		} 
 	} 

 	if((pstatus == 'N')&&(PromoCode!='')){  
 		alert('Travel Code is invalid! Please re-enter'); 
 		obj.value = ""; 
 		obj.focus; 
 	} 
 } 
 
 function CusFeedBack(){
 window.open('http://www4.secure-reservation.com/servlet/ACCentral.loadDiscription?type=6&screenName=RES_CUS_DET&title=Visitor Satisfaction Feedback&HotSpeID=&afftCode=RA','i','width=590,height=385,status=no,scrollbars=no,resizable=no');
}
 
</script>
<style type="text/css"></style><script src="details_files/mixpanel-2.js" async="" type="text/javascript"></script><style media="screen" type="text/css">#dddContent {visibility:hidden}</style></head>
<body>
<form name="frm1" method="POST" action="../hotels/ValidateTransactionProcess"> 
	<!-- google-analytics link not activated --><!-- Pup-up when close not activated -->
<input name="onlinePross" value="YES" type="Hidden">
<input name="stylesCount" value="0" type="Hidden">
<input name="AffiliateMainPage" value="" type="Hidden">
<input name="hidHotCode" value="${info.hotelCode}" type="Hidden">
<input name="hotName" value="${info.hotelName}" type="Hidden">
<input name="hotCity" value="${info.hotelAddress}" type="Hidden">
<input name="hotCountry" value="USA" type="Hidden">
<input name="hotEmail" value="tajwholesale@taj.trump.com" type="Hidden">
<input name="hotPhone" value="800-524-1706" type="Hidden">
<input name="hotAddress" value="1000 Boardwalk and Virginia Ave.   &nbsp; &nbsp;" type="Hidden">
<input name="hotFaxNo" value="6094496794'" type="Hidden">
<input name="checkInDate" value="${info.fromdate}" type="Hidden">
<input name="checkOutDate" value="${info.todate}" type="Hidden">
<input name="noOfAdults" value="${info.noOfAdults}" type="Hidden">
<input name="noOfChildren" value="0" type="Hidden">
<input name="noOfRooms" value="${info.noofrooms}" type="Hidden">
<input name="noOfNights" value="${info.noOfnights}" type="Hidden">
<input name="roomTypeCode" value="${info.roomcode}" type="Hidden">
<input name="roomType" value="${info.roomname}" type="Hidden">
<input name="bedType" value="${info.bedName}" type="Hidden">
<input name="bedtypecode" value="${info.bedcode}" type="Hidden">
<input name="rplcode" value="${info.rateplancode}" type="Hidden">
<input name="rplname" value="${info.rateplanname}" type="Hidden">
<input name="smoking" value="" type="Hidden">
<input name="children" value="H9" type="Hidden"> <!-- pass worng value(old code) -->
<input name="rateCode" value="69.0:,S,69@0.00:,69.0:,0:,0:,${info.bedcode}:,Room Only:,0.0,0.0,69.0@69.0,0,0.00,0.00,N:" type="Hidden">
<input name="State" value="New Jersey" type="Hidden">
<input name="hotZip" value=" 08401" type="Hidden">
<input name="ddChildRate" value="" type="Hidden">
<input name="language" value="en" type="Hidden">
<input name="country" value="US" type="Hidden">
<input name="browser" value="IE" type="Hidden">
<input name="afftCode" value="RA" type="hidden">	
	
<input name="afftParams1" value="&nbsp;" type="Hidden">
<input name="afftParams2" value="&nbsp;" type="Hidden">
<input name="afftParams3" value="&nbsp;" type="Hidden">
<input name="afftParams4" value="&nbsp;" type="Hidden">
<input name="afftParams5" value="&nbsp;" type="Hidden">
<input name="afftParams6" value="blank.gif" type="Hidden">
<input name="afftParams7" value="-" type="Hidden">

<input name="afftType" value="-" type="hidden">
<input name="afftCode" value="RA" type="hidden">
<input name="ShowcheckOutDate" value="${info.showCheckoutdate}" type="hidden">
<input name="ShowcheckInDate" value="${info.showCheckdate}" type="hidden">
<input name="additionalRate" value="0:" type="hidden">
<input name="childRate" value="0:" type="hidden">
<input name="promotions" value="" type="Hidden">
<input name="unFormatedDate" value="26-10-2013" type="Hidden">
<input name="visitorInfo" value="-" type="Hidden">
<input name="hotelSpecialCode" value="" type="Hidden">
<input name="contractType" value="N" type="Hidden">
<input name="freeSell" value="Y" type="Hidden">
<input name="rateStr" value="" type="Hidden">
<input name="AffUserName" value="-" type="Hidden">
<input name="AffPassWord" value="-" type="Hidden">
<input name="hotNetRate" value="51.75@" type="Hidden">
<input name="adultRateBedTyp" value="51.75@" type="Hidden"> 

<input name="affHotName" value="Taj Mahal" type="Hidden">
<input name="Res_txt_MName" value="" type="Hidden">
<input name="enablenewlayout" value="Y" type="Hidden">
<script>
function fUrl(mUrl) {
mUrl=mUrl.replace(/@/g ,"'"); if(mUrl!='-') {
window.open(mUrl+"?affcode=RA",'i','width=800,height=600,scrollbars=yes,resizable=yes');
}else{
alert('Hotel Info not Available !')
}
}
</script>
<div>
 <!-- Begin header -->
  <div class="red_bg_header">
    <div class="header">
      <div class="container_24">
      	<div class="grid_24">
      		<div class="text_center">
        		<ul class="top_promotional">
        	 		<li>Book Atlantic City Hotels, Atlantic City Hotel Casinos and receive the BEST Hotel deals and rates available!</li>
        		</ul>
        	</div>
      	</div>
      	<div class="clear"></div>
        <!-- Begin top main header -->
        <div class="grid_19 alpha float_right">
        </div>
        <div class="grid_19 alpha float_left">
          <div class="flash_header">
            <div>
            	<a href="http://www.accentralreservations.com/index.html"><img alt="A. C. Central Reservations" src="details_files/logo_lite2.jpg" height="44" width="760"></a><br>
              <div class="aaa">
					<iframe src="details_files/slider.htm" style="width:780px;margin-right: -3px; margin-top: -8px; " scrolling="no"></iframe> 
			   </div>
              <ul class="top_menu">
						<li><a href="http://www.accentralreservations.com/index.html">HOME</a></li>
						<li><a href="http://www.accentralreservations.com/hotel-deals.html">HOTEL SPECIALS</a></li>
						<li><a href="http://www.accentralreservations.com/hotels.html">ATLANTIC CITY HOTELS &amp; CASINOS</a></li>
						<li><a href="http://www.accentralreservations.com/groups.html/GROUPS">GROUPS</a></li>
						<li><a href="http://www.accentralreservations.com/city-guide.html">CITY GUIDE</a></li>
						<li><a href="http://www.accentralreservations.com/events.html">EVENTS</a></li>
						<li><a href=""></a></li>
        	</ul>
            </div>
          </div>
        </div>
       
        <div class="clear"></div>
        <div class="sub_header">
          <div class="grid_12 push_12">
            <div class="grid_9 alpha float_right">
              <ul class="nav-list float_right">
                <li><a href="" class="active_white">Search</a></li>
                <li><a class="active_white">Select</a></li>
                <li><a href="" class="active_orange">Book</a></li>
                <li><a href="" class="active_white">Confirm</a></li>
              </ul>
            </div>
          </div>
        </div>
        <!-- End top main header -->
      </div>
    </div>
    <div class="clear"></div>
  </div>

</div>
<div class="container_24">
  <div class="grid_24">&nbsp;</div>
  <div class="clear"></div>
  <div class="grid_10_new margin_left_10">
    <div class="left_column_bg padding_10">
      <div class="book_summary border_yellow">
        <h2 class="maroon_text"> Booking Summary </h2>
        <h5 class="maroon_text">Hotel Information</h5>
        <div class="container_6">
          <div class="grid_3">
            <p class="float_left">
            <a href="javascript:onClick=fUrl('http://www4.secure-reservation.com/HTML/ACCentral/HotelTemplate/taj_mahal_hotelpage.html');">
            	<img alt="hotel information" src="details_files/H9THUMB.jpg" border="1" height="100" width="100">
            </a>
          </p></div>
          <div class="grid_3">
            <div class="hotel_name"><a href="#" class="normal_text">${info.hotelName}</a></div>
            <em class="normal_text">${info.hotelAddress}</em>
			<br>
            <div class="grid_3 normal_text"></div>
            </div>
          <div class="clear"></div>
          <div class="grid_3 normal_text maroon_text">Parking Available</div>
          <div class="clear"></div>
          <div class="grid_3 normal_text">Valet Parking</div>
          <div class="grid_1">:</div>
          <div class="grid_5">
            <ul class="side">
              <li class="normal_text">15.00 per day</li>
            </ul>
          </div>
          <div class="clear"></div>
          <div class="grid_3 normal_text">Self Parking</div>
          <div class="grid_1">:</div>
          <div class="grid_5">
            <ul class="side">
              <li class="normal_text">10.0 per day</li>
            </ul>
          </div>
          <div class="clear"></div>
          

          
          <!-- Reservation Details -->
          <br>
          <h5 class="maroon_text">Reservation Details</h5>
          
          <div class="grid_3 normal_text">Period of Stay</div>
          <div class="grid_1">:</div>
          <div class="grid_5">
            <ul class="side">
              <li class="normal_text">${info.showCheckdate}</li>
              <li class="normal_text">to</li>
              <li class="normal_text">${info.showCheckoutdate}</li>
            </ul>
          </div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">No. of Nights</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text ">${info.noOfnights}</div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">No. of Rooms</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text">${info.noofrooms}</div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">No. of Adults</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text">${info.noOfAdults}</div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">No. of Children</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text">0</div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">Room Type</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text">${info.roomname}</div>
          <div class="clear"></div>
          
          <div class="grid_3 normal_text">Bed Type</div>
          <div class="grid_1">:</div>
           <div class="grid_3 normal_text">
           	${info.bedName}
          </div>
          <div class="clear"></div>
          <div class="grid_6">
            <h5 class="maroon_text margin_top_15">Rate Details</h5>
          </div>
          <div class="clear"></div>
          <div class="clear"></div>
          <div class="grid_1">&nbsp;</div>
          <div class="grid_3 normal_text_red font_bold">Total Payable ($)</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text_red font_bold">${ratez.totoalprice}<input name="TotalPayable" value="${ratez.totoalprice}" type="hidden"></div>
          <div class="clear"></div>
          <div class="grid_1">&nbsp;</div>
          <div class="grid_3 normal_text_red font_bold">Deposit Payable now($)</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text_red font_bold">${ratez.depositvalue}<input name="paidAmount" value="${ratez.depositvalue}" type="hidden"></div>
          <div class="clear"></div>
          <div class="grid_1">&nbsp;</div>
          <div class="grid_3 normal_text_red font_bold">Balance Payable ($)</div>
          <div class="grid_1">:</div>
          <div class="grid_2 normal_text_red font_bold">${ratez.balanceamount}<input name="balAmount" value="${ratez.balanceamount}" type="hidden"></div>
          <div class="clear"></div>
        </div>
        <br>
        <div style="text_right">
         <a class="fancybox " title="Room Details" href="#inline3" style="color:#FC6D0C;font-weight:bold;">
         <u>Room Rate Details</u></a>
          </div>
      </div>
      
      <div class="clear"></div>
     
      <!-- End -->
    </div>
  </div>
 <input name="Discount" value="0" type="Hidden"> 
 <input name="freeNights" value="0" type="Hidden"> 
 <input name="stdRate" value=",69.0" type="Hidden">
 <input name="addRate" value=",0" type="Hidden">
 <input name="childRate" value=",0" type="Hidden">
 <input name="totDayRate" value="69.0," type="hidden">
 <input name="ratePlanCode" value="Room Only:" type="Hidden">
 <input name="rateType" value="S" type="Hidden">
 
	<input type="hidden" name='subTotal' value='26.20'/>
   
   
   
 <!-- Customer Details-->
 
  <div class="grid_13">
    <div class="container_12 bg_grey border_light_yellow padding_left_10 padding_bottom_15">
      <h3 class="maroon_text"> Customer Information </h3>
      <div class="grid_2">
        <label class="normal_text">Title </label>
        <span>*</span>
        <select class="sel-short2" id="Res_Sel_Cust_Titlediv" name="Res_Sel_Cust_Title">
          <option selected="selected" value="-">-</option>
          	<option value="Mr.">Mr.</option>
          	<option value="Miss">Miss</option>
        	<option value="Ms">Ms</option>
          	<option value="Mrs.">Mrs.</option>
          	<option value="Dr">Dr</option>
        </select>
      </div>
      <div class="grid_4">
        <label class="normal_text">First Name</label>
        <span>*</span>
        <input class="text text-middle2" id="Res_txt_FNamediv" name="Res_txt_FName" onchange="document.frm1.Res_txt_Room_FName_0.value=this.value;
        	document.frm1.Res_txt_Room_FName_0.value=this.value;
        	document.frm1.Res_txt_CName.value=this.value;" type="text">
      </div>
      <div class="grid_6">
        <label class="normal_text">Last Name</label>
        <span>*</span>
        <input class="text" id="Res_txt_LNamediv" name="Res_txt_LName" onchange='document.frm1.Res_txt_Room_LName_0.value=this.value;
        	document.frm1.Res_txt_Room_LName_0.value=this.value;
        	document.frm1.Res_txt_CName.value=(document.frm1.Res_txt_FName.value+" "+this.value)' type="text">
      </div>
      <div class="clear"></div>
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Phone</label>
        <span>*</span>
        <input class="text" id="Res_txt_Phonediv" name="Res_txt_Phone" type="text">
      </div>
       <div class="grid_6 padding_top_8">
        <label class="normal_text">Fax</label>
        <br>
        <input class="text" id="Res_txt_Faxdiv" name="Res_txt_Fax" type="text">
      </div>
      <div class="clear"></div>
       
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Address1</label>
        <span>*</span>
        <input class="text" id="Res_txt_Address1div" name="Res_txt_Address1" type="text">
      </div>
       <div class="grid_6 padding_top_8">
        <label class="normal_text">Address2</label>
        <br>
        <input class="text" id="Res_txt_Address2div" name="Res_txt_Address2" type="text">
      </div>
      <div class="clear"></div>
      
      <div class="grid_2 padding_top_8">
      	<label class="normal_text">City</label>
      	<span>*</span>
      	<input class="text text-middle3" id="Res_txt_FNamediv" name="Res_txt_City" type="text">
      </div>
      <div class="grid_4 padding_top_8">
       <label class="select-middle2 normal_text">State</label>
       <br>
      	 <select class="select-middle2" id="Res_Sel_Cust_Statediv" name="Res_txt_State">
          	<option value="-" selected="selected">--</option>
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AR">Arkansas</option>
			<option value="AZ">Arizona</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DC">Washington DC</option>
			<option value="DE">Delaware</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="IA">Iowa</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="MA">Massachusetts</option>
			<option value="MD">Maryland</option>
			<option value="ME">Maine</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MO">Missouri</option>
			<option value="MS">Mississippi</option>
			<option value="MT">Montana</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="NE">Nebraska</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NV">Nevada</option>
			<option value="NY">New York</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="PR">Puerto Rico</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VA">Virginia</option>
			<option value="VT">Vermont</option>
			<option value="WA">Washington</option>
			<option value="WI">Wisconsin</option>
			<option value="WV">West Virginia</option>
			<option value="WY">Wyoming</option>
			<option value="AB">Alberta</option>
			<option value="QC">Quebec</option>
			<option value="ON">Ontario</option>
			<option value="BC">British Columbia</option>
			<option value="MB">Manitoba</option>
			<option value="NB">New Brunswick</option>
			<option value="NL">New Foundland</option>
			<option value="NT">Northwest Territories</option>
			<option value="NS">Nova Scotia</option>
			<option value="PE">Prince Edward Island</option>
			<option value="SK">Saskatchewan</option>
			<option value="YT">Yukon Territories</option>
			<option value="NU">Nunavut</option>
			<option value="ACT">Australian Capital Territor</option>
			<option value="NSW">New South Wales</option>
			<option value="NT">Northern Territory</option>
			<option value="QLD">Queensland</option>
			<option value="SA">South Australia</option>
			<option value="TAS">Tasmania</option>
			<option value="VIC">Victoria</option>
			<option value="WA">Western Australia</option>
        </select>
      </div>
      <div class="grid_1 padding_top_8">
      	<label class="normal_text">Zip</label>
      	<span>*</span>
      	<input class="text text-middle4" id="Res_txt_FNamediv" name="Res_txt_Zip" type="text">
      </div>
      <input name="hidCountryName" value="United States" type="hidden">
      <div class="grid_26 padding_top_8">
       <label class="select-middle5 normal_text">Country <span>*</span></label>
       
       <div class="selectcountry">
      	 <select class="select-middle4" id="Res_Sel_Cust_Statediv" name="res_sel_Country" onchange="setHid(document.frm1)">
      	    	<option value="any">Select a Country </option>
							<option value="AF">Afghanistan</option>
							<option value="AL">Albania</option>
							<option value="DZ">Algeria</option>
							<option value="AS">American Samoa</option>
							<option value="AD">Andorra</option>
							<option value="AO">Angola</option>
							<option value="AI">Anguilla</option>
							<option value="AQ">Antarctica</option>
							<option value="AG">Antigua And Barbuda</option>
							<option value="AR">Argentina</option>
							<option value="AM">Armenia</option>
							<option value="AW">Aruba</option>
							<option value="AU">Australia</option>
							<option value="AT">Austria</option>
							<option value="AZ">Azerbaijan</option>
							<option value="BS">Bahamas</option>
							<option value="BH">Bahrain</option>
							<option value="BD">Bangladesh</option>
							<option value="BB">Barbados</option>
							<option value="BY">Belarus</option>
							<option value="BE">Belgium</option>
							<option value="BZ">Belize</option>
							<option value="BJ">Benin</option>
							<option value="BM">Bermuda</option>
							<option value="BT">Bhutan</option>
							<option value="BO">Bolivia</option>
							<option value="BA">Bosnia and Herzegovina</option>
							<option value="BW">Botswana</option>
							<option value="BV">Bouvet Island</option>
							<option value="BR">Brazil</option>
							<option value="IO">British Indian Ocean Territory</option>
							<option value="BN">Brunei</option>
							<option value="BG">Bulgaria</option>
							<option value="BF">Burkina Faso</option>
							<option value="BI">Burundi</option>
							<option value="KH">Cambodia</option>
							<option value="CM">Cameroon</option>
							<option value="CA">Canada</option>
							<option value="CV">Cape Verde</option>
							<option value="KY">Cayman Islands</option>
							<option value="CF">Central African Republic</option>
							<option value="TD">Chad</option>
							<option value="CL">Chile</option>
							<option value="CN">China</option>
							<option value="CX">Christmas Island</option>
							<option value="CC">Cocos (Keeling) Islands</option>
							<option value="CO">Colombia</option>
							<option value="KM">Comoros</option>
							<option value="CG">Congo</option>
							<option value="CD">Congo Democractic Republic</option>
							<option value="CK">Cook Islands</option>
							<option value="CR">Costa Rica</option>
							<option value="CI">Cote DIvoire (Ivory Coast)</option>
							<option value="HR">Croatia (Hrvatska)</option>
							<option value="CU">Cuba</option>
							<option value="CY">Cyprus</option>
							<option value="CZ">Czech Republic</option>
							<option value="DK">Denmark</option>
							<option value="DJ">Djibouti</option>
							<option value="DM">Dominica</option>
							<option value="DO">Dominican Republic</option>
							<option value="TP">East Timor</option>
							<option value="EC">Ecuador</option>
							<option value="EG">Egypt</option>
							<option value="SV">El Salvador</option>
							<option value="GQ">Equatorial Guinea</option>
							<option value="ER">Eritrea</option>
							<option value="EE">Estonia</option>
							<option value="ET">Ethiopia</option>
							<option value="FK">Falkland Islands (Islas Malvinas)</option>
							<option value="FO">Faroe Islands</option>
							<option value="FJ">Fiji Islands</option>
							<option value="FI">Finland</option>
							<option value="FR">France</option>
							<option value="GF">French Guiana</option>
							<option value="PF">French Polynesia</option>
							<option value="TF">French Southern Territories</option>
							<option value="GA">Gabon</option>
							<option value="GM">Gambia</option>
							<option value="GE">Georgia</option>
							<option value="DE">Germany</option>
							<option value="GH">Ghana</option>
							<option value="GI">Gibraltar</option>
							<option value="GR">Greece</option>
							<option value="GL">Greenland</option>
							<option value="GD">Grenada</option>
							<option value="GP">Guadeloupe</option>
							<option value="GU">Guam</option>
							<option value="GT">Guatemala</option>
							<option value="GN">Guinea</option>
							<option value="GW">Guinea-Bissau</option>
							<option value="GY">Guyana</option>
							<option value="HT">Haiti</option>
							<option value="HM">Heard and McDonald Islands</option>
							<option value="HN">Honduras</option>
							<option value="HK">Hong Kong S.A.R.</option>
							<option value="HU">Hungary</option>
							<option value="IS">Iceland</option>
							<option value="IN">India</option>
							<option value="ID">Indonesia</option>
							<option value="IR">Iran</option>
							<option value="IQ">Iraq</option>
							<option value="IE">Ireland</option>
							<option value="IL">Israel</option>
							<option value="IT">Italy</option>
							<option value="JM">Jamaica</option>
							<option value="JP">Japan</option>
							<option value="JO">Jordan</option>
							<option value="KZ">Kazakhstan</option>
							<option value="KE">Kenya</option>
							<option value="KI">Kiribati</option>
							<option value="KR">Korea</option>
							<option value="KP">North Korea</option>
							<option value="KW">Kuwait</option>
							<option value="KG">Kyrgyzstan</option>
							<option value="LA">Laos</option>
							<option value="LV">Latvia</option>
							<option value="LB">Lebanon</option>
							<option value="LS">Lesotho</option>
							<option value="LR">Liberia</option>
							<option value="LY">Libya</option>
							<option value="LI">Liechtenstein</option>
							<option value="LT">Lithuania</option>
							<option value="LU">Luxembourg</option>
							<option value="MO">Macau S.A.R.</option>
							<option value="MK">Macedonia</option>
							<option value="MG">Madagascar</option>
							<option value="MW">Malawi</option>
							<option value="MY">Malaysia</option>
							<option value="MV">Maldives</option>
							<option value="ML">Mali</option>
							<option value="MT">Malta</option>
							<option value="MH">Marshall Islands</option>
							<option value="MQ">Martinique</option>
							<option value="MR">Mauritania</option>
							<option value="MU">Mauritius</option>
							<option value="YT">Mayotte</option>
							<option value="MX">Mexico</option>
							<option value="FM">Micronesia</option>
							<option value="MD">Moldova</option>
							<option value="MC">Monaco</option>
							<option value="MN">Mongolia</option>
							<option value="MS">Montserrat</option>
							<option value="MA">Morocco</option>
							<option value="MZ">Mozambique</option>
							<option value="MM">Myanmar</option>
							<option value="NA">Namibia</option>
							<option value="NR">Nauru</option>
							<option value="NP">Nepal</option>
							<option value="AN">Netherlands Antilles</option>
							<option value="NL">Netherlands</option>
							<option value="NC">New Caledonia</option>
							<option value="NZ">New Zealand</option>
							<option value="NI">Nicaragua</option>
							<option value="NE">Niger</option>
							<option value="NG">Nigeria</option>
							<option value="NU">Niue</option>
							<option value="NF">Norfolk Island</option>
							<option value="MP">Northern Mariana Islands</option>
							<option value="NO">Norway</option>
							<option value="OM">Oman</option>
							<option value="PK">Pakistan</option>
							<option value="PW">Palau</option>
							<option value="PA">Panama</option>
							<option value="PG">Papua new Guinea</option>
							<option value="PY">Paraguay</option>
							<option value="PE">Peru</option>
							<option value="PH">Philippines</option>
							<option value="PN">Pitcairn Island</option>
							<option value="PL">Poland</option>
							<option value="PT">Portugal</option>
							<option value="PR">Puerto Rico</option>
							<option value="QA">Qatar</option>
							<option value="RE">Reunion</option>
							<option value="RO">Romania</option>
							<option value="RU">Russia</option>
							<option value="RW">Rwanda</option>
							<option value="SH">Saint Helena</option>
							<option value="KN">Saint Kitts And Nevis</option>
							<option value="LC">Saint Lucia</option>
							<option value="PM">Saint Pierre and Miquelon</option>
							<option value="VC">Saint Vincent And The Grenadines</option>
							<option value="WS">Samoa</option>
							<option value="SM">San Marino</option>
							<option value="ST">Sao Tome and Principe</option>
							<option value="SA">Saudi Arabia</option>
							<option value="SN">Senegal</option>
							<option value="SC">Seychelles</option>
							<option value="SL">Sierra Leone</option>
							<option value="SG">Singapore</option>
							<option value="SK">Slovakia</option>
							<option value="SI">Slovenia</option>
							<option value="SB">Solomon Islands			</option>
							<option value="SO">Somalia</option>
							<option value="ZA">South Africa</option>
							<option value="ES">Spain</option>
							<option value="LK">Sri Lanka</option>
							<option value="SD">Sudan</option>
							<option value="SR">Suriname</option>
							<option value="SJ">Svalbard And Jan Mayen Islands</option>
							<option value="SZ">Swaziland</option>
							<option value="SE">Sweden</option>
							<option value="CH">Switzerland</option>
							<option value="SY">Syria</option>
							<option value="TW">Taiwan</option>
							<option value="TJ">Tajikistan</option>
							<option value="TZ">Tanzania</option>
							<option value="TH">Thailand</option>
							<option value="TG">Togo</option>
							<option value="TK">Tokelau</option>
							<option value="TO">Tonga</option>
							<option value="TT">Trinidad And Tobago</option>
							<option value="TN">Tunisia</option>
							<option value="TR">Turkey</option>
							<option value="TM">Turkmenistan</option>
							<option value="TC">Turks And Caicos Islands</option>
							<option value="TV">Tuvalu</option>
							<option value="UG">Uganda</option>
							<option value="UA">Ukraine</option>
							<option value="AE">United Arab Emirates</option>
							<option value="GB">United Kingdom</option>
							<option value="US" selected="selected">USA</option>
							<option value="UM">US Minor Outlying Islands</option>
							<option value="UY">Uruguay</option>
							<option value="UZ">Uzbekistan</option>
							<option value="VU">Vanuatu</option>
							<option value="VA">Vatican City State (Holy See)</option>
							<option value="VE">Venezuela</option>
							<option value="VN">Vietnam</option>
							<option value="VG">Virgin Islands (British)</option>
							<option value="VI">Virgin Islands (US)</option>
							<option value="WF">Wallis And Futuna Islands</option>
							<option value="YE">Yemen</option>
							<option value="YU">Yugoslavia</option>
							<option value="ZM">Zambia</option>
							<option value="ZW">Zimbabwe</option>
        </select>
       </div>
      </div>
      <div class="clear"></div>
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Email</label>
        <em class="normal_text">(for booking confirmation)</em><span>*</span><br>
        <input class="text" id="Res_txt_Emaildiv" name="Res_txt_Email" type="text">
      </div>
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Confirm email</label>
        <br>
        <input class="text" id="Res_txt_ConfEmaildiv" name="Res_conf_email" type="text">
      </div>
      <div class="clear"></div>
      <br>
      	<input maxlength="50" name="Res_promo_code" value="-" type="hidden">
      
      <div class="grid_12 padding_top_8">
        <p class="noties normal_text2"> Please Note: all fields marked with ( * ) are compulsory</p>
      </div>
      <div class="clear"></div>
      <div class="grid_12">
        <p class="sub_noties normal_text2">Customers from countries that do not have state/province or zip code please enter "none" in those fields.</p>
      </div>
      <div class="clear"></div>
      <div class="grid_12">&nbsp;</div>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
    
 <!-- Billing Information -->
    
    <div class="container_12 bg_grey border_light_yellow padding_left_10 margin_top_15 padding_bottom_15">
      <h3 class="maroon_text"> Billing Information</h3>
      <div class="grid_6">
        <label class="normal_text">Name of cardholder </label>
        <span>*</span>
        <input class="text" id="Res_txt_CNamediv" name="Res_txt_CName" type="text">
      </div>
      <div class="grid_6">
        <label class="normal_text">Number on card </label>
        <span>*</span>
        <input maxlength="16" class="text" id="Res_txt_ccNodiv" name="Res_txt_ccNo" onchange="setCr(this.value);" onkeypress="return numbersonly(event)" type="text">
      </div>
      <div class="clear"></div>
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Credit card type</label>
        <span>*</span>
        <select name="cmbCardType" onchange="document.frm1.hidCardType.value=this.options[this.selectedIndex].text" id="cmbCardTypediv" class="text">
					<option selected="selected" value="VI">Visa</option>
					<option value="MS">Master Card</option>
					<option value="AE">American Express</option>
					<option value="DR">Discover</option>
					<option value="DC">Diners Club</option>
		</select>
      </div>
      <input name="hidCardType" value="Visa" type="Hidden">
      <div class="grid_3 padding_top_8">
        <label class="label_class normal_text">Expiry date </label>
        <span>*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
        <#assign aDateTime = .now>
		<#assign ayear= (aDateTime?string("yyyy"))?number>
		<#assign amonth= aDateTime?string("MM")>
		<#assign amonthn= amonth?number>
        <select name="cmbExpMonth" class="sel-short" id="cmbExpMonthdiv">
        <#list 0..11 as x>
        	<#if x==(amonthn-1)>
        		<option value="${x}" selected>${x+1}</option>
        	<#else>
        		<option value="${x}">${x+1}</option>
        	</#if>
        </#list>
        </select>
     
        <select id="cmbExpYeardiv" class="sel-middle  " name="cmbExpYear">
				<#list ayear..ayear+5 as yesr>
					<option value="${yesr?string("0000")}">${yesr?string("0000")}</option>
				</#list>
        </select>
		</div>
      <div class="clear"></div>
      <div class="grid_6 padding_top_8">
        <label class="normal_text">Security code </label>
        <a href="#inline2" class="note2 link-popup fancybox">?</a>
        <input class="text" id="Res_txt_cvvdiv" name="Res_txt_cvv" onkeypress="return numbersonly(event)" type="text">
        <div class="clear"></div>
        <label for="chkBookPolicy">
          <input class="check" id="chkBookPolicy" name="chkBookPolicy" type="checkbox">
          <label class="normal_text">I accept the&nbsp;</label><a class="fancybox" title="Booking Policy" href="#inline1" style="color:#FC6D0C"><u class="normal_text">Booking Policy</u></a></label>
        <br>
        <label for="chkEmailListdiv">
          <input class="check" id="chkEmailListdiv" onclick="this.value='ON'" value="OFF" name="chkMember" type="checkbox">
          <label class="normal_text">Send me news  about special promotions, offers and discounts.</label> </label>
      </div>
      <div class="grid_3_new"> 
      	<script src="details_files/getthawteseal"></script><a href="https://sealinfo.thawte.com/thawtesplash?form_file=fdf/thawtesplash.fdf&amp;dn=WWW4.SECURE-RESERVATION.COM&amp;lang=en" tabindex="-1" onmousedown="return v_mDown(event);" target="THAWTE_Splash"><img name="seal" src="details_files/getthawteseal.gif" oncontextmenu="return false;" alt="Click to Verify - This site has chosen a thawte SSL Certificate to improve Web site security" border="true"></a>     
      </div>
      <div class="grid_3 normal_text"> Thawte security <br>
        128-bit <br>
        encryption</div>
      <div class="clear"></div>
      <div class="grid_12">&nbsp;</div>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
    
<!-- Rooming List -->

    <div class="container_12 bg_grey border_light_yellow padding_left_10 margin_top_15 padding_bottom_15">
      <h3 class="maroon_text"> Room Occupancy Details</h3>
      	<div class="grid_6">
        	<h5 class="blue_text">Room 1</h5>
      	</div>
      	<div class="clear"></div>
      	<div class="grid_6">
        	<label class="normal_text">First Name</label>
        	<span>*</span><br>
        	<input class="text text-middle2" id="A_F_name" name="Res_txt_Room_FName_0" type="text">
      	</div>
      	<div class="grid_6">
        	<label class="normal_text">Last Name</label>
        	<br>
        	<input maxlength="19" class="text" id="A_L_name" name="Res_txt_Room_LName_0" type="text">
      	</div>
      <div class="clear"></div>
      <div class="grid_6"></div>
      <div class="clear"></div>
    </div>
    <div class="container_12 bg_grey border_light_yellow padding_left_10 margin_top_15 padding_bottom_15">
      <h3 class="maroon_text"> Special Requests / Preferences </h3>
      <div class="grid_12">
        <textarea cols="55" rows="3" name="txaRequest"></textarea>
      </div>
      <div class="clear"></div>
      <div class="grid_12">
        <label class="normal_text">Your preferences will be noted, but cannot be guaranteed.</label>
      </div>
      <div class="clear"></div>
      <input name="smoking_0" value="" type="Hidden">
	  <input name="beds_0" value="" type="Hidden">
	  	<!-- smoking & non smoking -->
       	<div class="grid_12">
        	<h5 class="blue_text"> Room 1 </h5>
      	</div>
      	<div class="clear"></div>
      	<div class="grid_1">
        	<div class="padding_left_1 smoking"></div>
     	 </div>
     	 <div class="grid_1">
        	<input name="smk_type_0" type="radio"><input name="Hid_smk_type_0" onclick='document.frm1.smoking_0.value="Smoking,"' type="hidden">
        	
      	</div>
      	<div class="grid_1 margin_left_min_10">
        	<div class="no_smoking"></div>
      	</div>
      	<div class="grid_1">
        	<input name="smk_type_0" onclick='document.frm1.smoking_0.value="Non Smoking,' type="radio">
      	</div>
      	
      	<!-- Handicap -->
      	<div class="grid_2 margin_left_min_10">
        	<div class="">
          		<p class="text_red">Handicap</p>
        	</div>
      	</div>
      	<div class="grid_1 margin_left_min_10">
        	<input name="handi_chk_0" value="" type="checkbox"><input name="Hid_handi_chk_0" type="hidden">
      	</div>
      	<div class="grid_1 margin_left_min_10">
        	<div class="float_left padding_left_13 wheel_chair"></div>
      	</div>
      	<div class="grid_1 margin_left_13">
        	<input name="wheel_chk_0" value="" type="checkbox"><input name="Hid_Wheel_Chair_0" type="hidden">
      	</div>
      	<div class="grid_2">
        	<p class="normal_text text_center "> No.of Beds Requested </p>
      	</div>
      	<div>
      		<span>1 <input name="beds_num_0" onclick='document.frm1.beds_0.value="1 Bed,' type="radio"></span>
      		<span>2 <input name="beds_num_0" onclick='document.frm1.beds_0.value="2 Beds,' type="radio"></span>
      </div>
      	<div class="clear"></div>
     
 </div>     
  </div>
  <div class="grid_6 prefix_14">
    <div class="booking_btn margin_top_15">
    <a href="javascript:onClick=submitData(document.frm1);"> 
    Book Now
    </a>
    </div>
  </div>
  <div class="grid_1"></div>
  <div class="clear"></div>
  <div class="grid_24">
    <p class="sub_noties text_center margin_top_15 normal_text2"> By 
clicking on "Confirm Reservation" you agree that you have read and 
accepted the Disclaimer, Reservation or Payment Conditions, Cancellation
 Policies and Privacy issues. 
  </p></div>
  <div class="clear"></div>
  <div class="grid_24"> &nbsp; </div>
  <div class="clear"></div>
   <div class="grid_24">
    <p class="sub_noties text_center">
    	<a class="pagelink2 normal_text" href="javascript:onClick=WindowOpenUpMsg(4)">Privacy policy</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    	<a href="javascript:onClick=WindowOpenUpMsg(3)" class="pagelink2 normal_text">Disclaimer</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    	<a href="javascript:CusFeedBack()" class="pagelink2 normal_text">Visitor Satisfaction Feedback</a>
    </p>
  </div>
</div>
<!--   footer container -->
<!--<div class="container_24 footer_bg">
<div class="grid_24 footer_bg padding_top_15 padding_bottom_15">
    <div class="text_center"> <span class="maroon_text"><a href="http://www.accentralreservations.com/about.html">About Us</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/sitemap.html">Site Map</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/directions.html">Directions</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/gift.html">Gift Certificate</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/contact.html">Contact Us</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/service.html">Customer Service</a> »&nbsp;&nbsp;<a href="http://www4.secure-reservation.com/servlet/ACCentral.HotelPartnerMain">Partner Login</a>&nbsp;»<br>
      &nbsp;<a href="http://www4.secure-reservation.com/servlet/ACCentral.AffiliateMain">Affiliate Login</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/policy.html">Reservation Policy</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/press.html">Press	Room</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/concierge.html">Concierge Services</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/history.html">AC History</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/directory.html">Travel Directory</a> »<br>
      <a href="http://www.accentralreservations.com/travel-tips.html">Travel Tips</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/casinos.html">Casinos</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/museums.html">Museums</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/beaches.html">Beaches</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/boating.html">Marinas, Fishing &amp; Boating</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/antiquing.html">Antiquing</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/affiliate.html">Be an Affiliate</a> »<br>
      <a href="http://www.accentralreservations.com/nightlife.html">Nightlife</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/maps.html">Maps</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/faq.html">FAQ</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/weather.html">Weather</a> »&nbsp;&nbsp;<a href="http://www.accentralreservations.com/security.html">Privacy &amp; Security</a> »&nbsp;<strong>&nbsp;</strong><span class="style28"><a href="http://www.accentralreservations.com/movies.html">Local Theaters</a></span><strong><span class="style28"> »</span></strong></span><span class="style30"><br>
      </span></div>
    <div  class="text_center font_bold grey_text margin_top_5">
      <p>Atlantic City Hotel Deals! Book Your Room Online Now, Atlantic City Hotel Casinos<br/>
        and receive the BEST Hotel deals and rates available!</p>
    </div>
    <div  class="text_center font_bold grey_text">
      <p>Copyright © 2003 - 2013 AC Central Reservations, Inc. All rights reserved.</p>
    </div> 
    <div  class="text_center maroon_text">
      <a href=""> AtlanticCity.com </a>
    </div>    
     
</div>  </div>-->
<!--    footer E N D  -->
<!-- Room Rate Details -->
<div class="clear"></div>
<div id="inline3" style="display:none;">
	<div class="container_24 padding_bottom_15">
		<div class="grid_23 popup_bg border_light_yellow margin_top_15 margin_left_13 padding_8">
			<h3 class="maroon_text normal_text">Room Rate Details</h3>
				 <table class="room_details">
				 	<tbody><tr>
			   			<th scope="col">Date</th>
			    		<th scope="col">No. of People</th>
			    		<th scope="col">No. of Rooms</th>
			    		<th scope="col">Std. Rate per Room ($)</th>
			    		<th scope="col">Additional Adult Rate ($)</th>
			    		<th scope="col">Child Rate ($)</th>
			    		<th scope="col">Total ($)</th>
					</tr>
						<tr>
									<td>Nov-26-2013<input name="0_stDate" value="Nov-26-2013" type="Hidden"></td>
									<td>2</td>
									<td>1</td>
									<td>69<input name="0_dayRate" value="69" type="Hidden"></td>
									<td>0<input name="0_AdditionaldayRate" value="0" type="Hidden"></td>
									<td>0<input name="0_ChilddayRate" value="0" type="Hidden"></td>
									<td>69<input name="0_dayTotal" value="69" type="Hidden"></td>
						</tr>
				 </tbody></table>
		</div>
	</div>
</div>

<!-- Booking Policy -->
<div class="clear"></div>
<div id="inline1" style="display:none;">
  <div class="container_24 padding_bottom_15">
    <div class="grid_23 popup_bg border_light_yellow margin_top_15 margin_left_13 padding_8">
      <h3 class="maroon_text"> YOU ARE NOW IN A SAFE SECURE INTERNET ENVIRONMENT</h3>
      <h6 class="blue_text"> Booking Requirements</h6>
      <p class="text_justify"> To complete your reservation you must 
enter a valid Visa, Master Card , American Express or Discover card #. 
Your Credit Card will be authorized immediately and charged in full for (
 Room total plus relative taxes) by A.C. Central Reservations, Inc. We 
will not give your personal / credit card details to anyone other than 
the credit card processing company. </p>
      <p class="text_justify"> One registered occupant MUST be 21 or 
older to check in at all casino hotels &amp; most non casino hotels. If 
not, entry will be denied by Hotel. </p>
      <h6 class="blue_text"> Cancellation Policy</h6>
      <p class="text_justify">  </p>
       <p class="text_justify"> A cancellation fee of $25.00 will be 
assessed provided that cancellation is made at least     48 hours prior 
to check-in date.  A cancellation with less than 48 hours from check-in 
date will forfeit 1 night room charge.  To cancel please call 
(800)-524-1706 or (609) 383-8880 , to receive a cancellation number. </p>
      <h6 class="blue_text">Check In Policy</h6>
      <p class="text_justify">All casino hotels and some non casino 
hotels require that a credit card be presented at the time of arrival as
 an ?incidental deposit?. The credit card is authorized for deposits 
ranging from $50-$250, depending on hotel and whatever is not used is 
refunded to the card. Cash payment for this deposit is not approved as 
it must be a valid credit card that will be authorized. Debit cards are 
therefore actually charged. Occupancy of the room can be declined if 
this policy is not accepted. In addition, please bring identification 
that confirms the name of the room occupants. Please cancel your 
reservation if you cannot comply with both policies and rebook at a 
hotel that doesn?t have this policy. Call 888-227-6667 8 am to midnight 
daily.</p>
      <h6 class="blue_text">Hotel Policy</h6>
      <p class="text_justify"></p>
    </div>
    <div class="clear"></div>
  </div>
</div>

<div id="inline2" style="display:none;">
	<div class="container_24 padding_bottom_15">
		<div class="grid_23 popup_bg border_light_yellow margin_top_15 margin_left_13 padding_8">
			<p class="text_justify">
				</p><p>CVV / Security Code is a security feature to help verify that you are in possession of your credit card.</p>
				<p>Visa / Mastercard / JCB / Switch / Solo feature a three-digit CVV
 / Security Code on the signature panel on the back of the card 
immediately after the card's account number.</p>
				<p>American Express cards feature a four-digit CVV / Security Code on the front of the card above the card account number.</p>
				<div class="img_holder">
					<img src="details_files/img16.jpg" alt="image description" height="102" width="135">
					<img src="details_files/img17.jpg" alt="image description" height="102" width="136">
				</div>
				<div class="btn-holder">
				</div>
			<p></p>
		<div>
	<div>
	<div class="clear"></div>
  	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
    if (window.PIE) {	
        $('.container_24').each(function() {
            PIE.attach(this);
        });
		$('.footer').each().each(function() {
			PIE.attach(this);							 
		});
    }
});
</script>



</div></div></div></form>
</body></html>