<!DOCTYPE html>
<html class=" win ff2 gecko"><head>
<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="SKYPE_TOOLBAR" content="SKYPE_TOOLBAR_PARSER_COMPATIBLE">
<title>Atlantic City Hotels, lodging and great Deals, Lodging, Atlantic City Casino Hotels</title>
<!-- Add jQuery library -->
<script src="../js/ga.js" async="" type="text/javascript"></script>
<script type="text/javascript" src="../js/seachresults1.js"></script>


<script type="text/javascript" src="../js/jquery-1.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.js"></script>
<script type="text/javascript" src="../js/jquery-ui-i18n.js"></script>
<!-- Add grid960 CSS files -->
<script type="text/javascript" src="../js/jquery_003.js"></script>
<script type="text/javascript" src="../js/jquery_002.js"></script>
<script type="text/javascript" src="../js/searchSuggests.js"></script>
<script type="text/javascript" src="../js/generaljs.js"></script>
<script type="text/javascript" src="../js/submitvalue.js"></script>
<script src="../js/main.js" type="text/javascript"></script>
<script src="../js/mpdmarkerRA.js" type="text/javascript"></script>
<script src="../js/extlargemapcontrol.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/gmap.js"></script>
<!-- Add jquery UI CSS and JS files -->

<style type="text/css" media="all"><!--
		@import url("../css/jquery-ui-1.8.12.custom.css?version=1");
		@import url("https://www4.secure-reservation.com/html/ACCentral/stylesheets/reset.css");
		@import url("https://www4.secure-reservation.com/html/ACCentral/stylesheets/demo.css?version=66.686");
		@import url("https://www4.secure-reservation.com/html/ACCentral/stylesheets/searchSuggests.css?version=1");
		@import url("https://www4.secure-reservation.com/html/ACCentral/stylesheets/text.css?version=6.66");
		@import url("https://www4.secure-reservation.com/html/ACCentral/stylesheets/jquery.fancybox.css?version=6.66");
		@import url("../css/styles_nwl_RA.css?version=1.1");
	--></style>
<script type="text/javascript">
	function EMailFriend() {
	
	var weburl = "http://www4.secure-reservation.com/servlet/ACCentral.ForwardToFriend?option=EmailDetail&type=1&cmbCity=null&cmbNoOfRooms=1&cmbNoOfAdults=2&cmbNoChi=0&cmbNoOfNights=1&cmbtravelerType=null&cmbNbHoode=-&cmbPriceRange=null&cmbCheckInDate=20&cmbCheckInMonth=8&cmbCheckInYear=2013&cmbCheckOutDate=21&cmbCheckOutMonth=8&stylesCount=0&cmbCheckOutYear=2013&afftCode=RA&language=en&country=US&browser=IE&startRange=0&endRange=999999" ;
		myWindow=window.open(weburl,'','width=550,height=250');
		myWindow.focus();
	}
	
	function CusFeedBack(){
		window.open('http://www4.secure-reservation.com/servlet/ACCentral.loadDiscription?type=6&screenName=RES_SEARCH&title=Visitor Satisfaction Feedback&HotSpeID=&afftCode=RA','i','width=590,height=385,status=no,scrollbars=no,resizable=no');
	} 
</script>
<script type="text/javascript">
	  
	function hotelmajorlist(hotelcode,hotelname,longitude,latitude)
	{
		this.hotelCode = hotelcode;
		this.hotelName = hotelname;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	var arrhotellist = '{"hotel":[';
		arrhotellist +='{"hotelCode":"H60","hotelName":"Wyndham Skyline Tower","latitude":"39.361594","longitude":"-74.42452"},';
	arrhotellist = arrhotellist.substring(0,arrhotellist.length-1)+"]}";
	arrhotellist = $.parseJSON(arrhotellist);
	function ldPg(type,hotel){
			if(type==1) {
				window.open('http://www4.secure-reservation.com/servlet/ACCentral.loadDiscription?type=3&hotCode='+hotel+'&cancelPolicy=&affCode=RA&ChkinDate=Sep-20-2013&ChkoutDate=Sep-21-2013','i','width=600,height=500,scrollbars=yes,resizable=yes');
			}else if(type==2) {
			window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=2','i','width=600,height=250,scrollbars=yes,resizable=yes');		
			}else if(type==5) {
			window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=5','i','width=290,height=250,scrollbars=yes,resizable=yes');
			}else if(type==6) {
			window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=6','i','width=290,height=250,scrollbars=yes,resizable=yes');
			}else if(type==7) {
			window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=7','i','width=290,height=250,scrollbars=yes,resizable=yes');
			}else if(type==3) {
				window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=3','i','width=290,height=250,scrollbars=yes,resizable=yes');
			}else if(type==4) {

				window.open('http://www4.secure-reservation.com/servlet/ACCentral.readStatic?type=1','i','width=600,height=250,scrollbars=yes,resizable=yes');
			}
			}
	function loadAvailability(hotCode) {

			WndMoreRooms=window.open("http://www4.secure-reservation.com/servlet/ACCentral.Availability_RatesCalander?option=EmailDetail&type=1&cmbCity=%&cmbNoOfRooms=1&cmbNoOfAdults="+
					"2&cmbNoChi=0&cmbNoOfNights=1"+
					//&cmbtravelerType="+_req.getParameter("cmbtravelerType")+"&cmbNbHoode="+__criteria[12]+"&cmbPriceRange="+_req.getParameter("cmbPriceRange")+
					"&hidCheckInDate=20&hidCheckInMonth=8&hidCheckInYear=2013"+
					"&hidCheckOutDate=21&hidCheckOutMonth=8&hidCheckOutYear=2013"+
					"&SelectedCheckInDate=20&SelectedCheckInMonth=8&SelectedCheckInYear=2013"+
					"&SelectedCheckOutDate=21&SelectedCheckOutMonth=8&SelectedCheckOutYear=2013"+
					"&stylesCount=0&afftCode=RA&language=en&country=US"+
					"&browser=IE"+
					//&startRange="+__criteria[17]+"&endRange="+__criteria[18]+"
					"&hotelCode="+hotCode+"",'ForwardToFriend',' width='+(Number(screen.width)-30)+',height='+(Number(screen.height)-200)+',scrollbars=yes,resizable=yes,status=yes,toolbar=yes,menubar=yes,location=yes,top=0,left=0')
}
		function showPromotions(promotionCode){			
			window.open('http://www4.secure-reservation.com/servlet/ACCentral.loadDiscription?type=2&promoCode='+promotionCode+'&affCode=RA','promoWnd','width=300,height=200,scrollbars=yes,toolbar=no,menubar=no');
		}
	var slidermaxval = 1000;
		var stPrice =1;
		var edPrice =1000;
		
		var dateparsed = ('Fri').split(",");
		var sourcechangevalue="";
		var sortenable=false;
		var HotelBroucherPages="http://www4.secure-reservation.com/html/ACCentral/HotelTemplate/";
		
		var my_page_no = 1;
		var my_start = 1;
		var my_end = 50;
		var altervalue="NO";
	
		var var_language = 'en';
		var var_country = 'US';
		function resultsPerPage(){
		try{
		var idresultselement=document.getElementById("results");
		var noOfResults=idresultselement.options[idresultselement.selectedIndex].text;
		var page="1";
		setTimeout("paging($('#avahotcountz').text(),"+noOfResults+","+page+")",200);		
		setTimeout("nextprev('1',"+noOfResults+","+page+")",200);
		}catch(e){}
		} 
		var xslobject = null;
					
			
		
		
		
		var montharray = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'] ;
		var monthnamearray = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'] ;
		var datesarray = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'] ;
		
		var roomcategorycode ="";
		var hoteltypecode ="";
		var locationcategorycode ="";
		var starcategorycode="";
		
		
		if("-" != "-")
		{
			hoteltypecode ="-";
		}
			
		function initcheck_box(){
			$('div.check_box,div.check_box_checked').click(function(){
			var locCode = this.id.split('_')[1]
			var dvs = this.id.split('_')[0]
			var name = this.id.split('_')[2]
			var checked = false;
			if(this.className == "check_box_checked"){
				this.setAttribute('class','check_box')
				this.setAttribute('className','check_box')
				checked = false;
			}else{
				this.setAttribute('class','check_box_checked')
				this.setAttribute('className','check_box_checked')
				checked = true; 
			}
			filters[locCode][2] = checked;
			if("dv"==dvs)
				filter('LocationCategoryFilter',locCode,checked,'','slLocexe','sLNm','slLoc','subid5',true)
			else if("dvs"==dvs)
				filter('FacilityFilter',locCode,checked,'','slCat','CtgNm','amty','subid4',true);
			else if("dvd"==dvs)	
				filter('StarCategoryFilter',locCode,checked,'','slCat','CtgNm','amty','subid3',true)
			else if("dvh"==dvs)		
				filter('HotelTyPeFilter',locCode,checked,'','slCat','CtgNm','amty','subid4',true)
			else if("dvr"==dvs)		
				filter('roomGroupFilter',locCode,checked,name,'RmTypexe','RmTyD','RmTyp','subid1',true)
			else if("dvl"==dvs)		
				filter('LocationFilter',locCode,checked,'','slCat','CtgNm','amty','subid6',true);		
			
		});
		
		$('span.checkbox').click(function(event){
			var selected_obj = $(event.target).siblings(this)
			
			var locCode =  selected_obj.get(0).id.split('_')[1]
			var dvs =  selected_obj.get(0).id.split('_')[0]
			var name =  selected_obj.get(0).id.split('_')[2]
			var idd =  selected_obj.get(0).id
			var checked = false;
			
			if((selected_obj.attr("class") == "check_box_checked") || (selected_obj.attr("class") == "check_box_checked1")){
				selected_obj.attr('class','check_box')
				selected_obj.attr('className','check_box')
				classname = 'check_box'
				checked = false;
			}else{
				selected_obj.attr('class','check_box_checked')
				selected_obj.attr('className','check_box_checked')
				classname = 'check_box_checked'
				checked = true; 
			}
			
			$('span#'+idd).unbind('mouseout')
			filters[locCode][2] = checked;
			if("dv"==dvs)
				filter('LocationCategoryFilter',locCode,checked,'','slLocexe','sLNm','slLoc','subid5',true)
			else if("dvs"==dvs)
				filter('FacilityFilter',locCode,checked,'','slCat','CtgNm','amty','subid4',true);
			else if("dvd"==dvs)	
				filter('StarCategoryFilter',locCode,checked,'','slCat','CtgNm','amty','subid3',true)
			else if("dvh"==dvs)		
				filter('HotelTyPeFilter',locCode,checked,'','slCat','CtgNm','amty','subid4',true)
			else if("dvr"==dvs)		
				filter('roomGroupFilter',locCode,checked,name,'RmTypexe','RmTyD','RmTyp','subid1',true)
			else if("dvl"==dvs)		
				filter('LocationFilter',locCode,checked,'','slCat','CtgNm','amty','subid6',true);		
		});
		
		var classname = ''
		$('span.checkbox').mouseover(function(event){
			 classname = $(event.target).siblings(this).attr("class");
			if(classname == 'check_box'){
				$(event.target).siblings(this).attr("class", "check_box1"); //"div[id^='dvr_GRT']" ~ this
			}else{
				$(event.target).siblings(this).attr("class", "check_box_checked1");
			}
		});
		
		$('span.checkbox').mouseout(function(event){
			$(event.target).siblings(this).attr("class",classname)
		});
		
		}
		
		function getSelectedFilters(){
			var s_filters = '';
			var bk_dates = '';
			for (var code in filters) {
				var ar =  filters[code];
				if(ar[3] && ar[2]){
					s_filters+=code+'*';
				}
				
		 }		 
		 bk_dates='@'+document.getElementById("check-in").value+'~'+document.getElementById("check-out").value + '@' + my_page_no +'@' + my_start + '@' + my_end +'@' + stPrice +'@' + edPrice;
		 return s_filters+bk_dates;
		}
		
		var filters  = {};
		var str_filtercodes = "";
		var fc1='';
		var fc2='';
		var fc3='';
		var fc4='';
		var fc5='';
		
		function initFilterMetadata(){
									filters['AC%'] = new Array('AC%',"All Facilities",false,false,'sub_3');						
									filters['AC58'] = new Array('AC58',"Casino",false,false,'sub_3');						
									filters['AC59'] = new Array('AC59',"Non Casino",false,false,'sub_3');						
									filters['AC17'] = new Array('AC17',"Indoor pool",false,false,'sub_3');						
									filters['AC36'] = new Array('AC36',"Kitchen",false,false,'sub_3');						
									filters['AC18'] = new Array('AC18',"Outdoor pool",false,false,'sub_3');						
									filters['AC67'] = new Array('AC67',"Suite",false,false,'sub_3');						
									filters['AC58'] = new Array('AC58',"Casino",false,false,'sub_3');
									fc2= fc2+',AC%,AC58,AC59,AC17,AC36,AC18,AC67,AC58';
				
				//Star code
						
								filters['STG%'] = new Array('STG%',"<span>&nbsp;All stars</span>",false,false,'sub_2');						
								filters['ST10'] = new Array('ST10',"<span class='img_stars5'></span>",false,false,'sub_2');						
								filters['ST9'] = new Array('ST9',"<span class='img_stars4'></span>",false,false,'sub_2');						
								filters['ST7'] = new Array('ST7',"<span class='img_stars3'></span>",false,false,'sub_2');						
								filters['ST8'] = new Array('ST8',"<span class='img_stars2'></span>",false,false,'sub_2');
								fc3= fc3+',STG%,ST10,ST9,ST7,ST8';
				
				// RP%|All Rate Plans|Amenities~RP2|Free Breakfast or Parking|Amenities
				//Star code
						
								filters['RP%'] = new Array('RP%',"All Rate Plans",true,false,'sub_1');						
								filters['RP2'] = new Array('RP2',"Free Breakfast or Parking",false,false,'sub_1');
								fc4= fc4+',RP%,RP2';				
						initFilterCodes();
						}
						
	function initLoading(txt){
		document.getElementById('loadingtxt').innerHTML = txt
		set_to_center('loading');
		document.getElementById('disable_back').style.display='block';
		document.getElementById('loading').style.display='block';
		
	}
	function initFilterCodes(){
		fc1 = fc1.replace('%','');
		fc2 = fc2.replace('%','');
		fc3 = fc3.replace('%','');
		fc4 = fc4.replace('%','');
		fc5 = fc5.replace('%','');
	
		str_filtercodes  = fc1+fc2+fc3+fc4+fc5;
	
		document.styleForm.filtcodes.value = str_filtercodes ;			
	}	
	<#assign fromdate=criteria.from_date?split("-")>
	<#assign todate=criteria.to_date?split("-")>
    </script> 
	<script type="text/javascript">
		history.navigationMode = 'compatible';
			$(window).bind("load", function() {
					initFilterMetadata();
					addFiltersFromUrl();
					initcheck_box();
					backloaded=document.internalform.backloaded.value;
					locationloaded=document.internalform.locationtrue.value;
					if(document.internalform.currentdomain.value == "-"){
						document.internalform.currentdomain.value=window.location;	
						var qvalue = (document.internalform.currentdomain.value).split("?")[0];
						qvalue+= "?fromdate=${criteria.from_date}";
						qvalue+= "&todate=${criteria.to_date}";
						qvalue+= "&cmbNoOfRooms=1&cmbNoOfAdults=${criteria.noofadults}&cmbNoChi=0&language=en&country=US&hotelCode=%&dsc=d#";
						document.internalform.currentdomain.value = qvalue;
						document.internalform.currentdomain.value = (document.internalform.currentdomain.value).replace('ResevationSearch','ResevationSearchResults');
						backloaded="true";
						document.internalform.backloaded.value="true";
						locationloaded="false";
						document.internalform.locationtrue.value="false";
					}
					orderbyselection = 	document.internalform.sortVal.value;
					initLoading('Updating your results....');
					var stPriceX=stPrice;
					var edPriceX=edPrice;
					if(isNaN(stPrice)){
					stPriceX=0;
					edPriceX=1000;
					}
					var qString = document.internalform.currentdomain.value; 
					qString = BuildUrl(qString, "mxP", new Array(stPriceX+"-"+edPriceX));
					document.internalform.currentdomain.value = qString;
					//xslmultipleloader();
					var pageNo = 1;
					if(pageNo != 1){
					document.internalform.currentpage.value=1;
					}
					displayResult(document.internalform.currentdomain.value,'','results_component','true',document.internalform.currentpage.value,'true',"true","true",'rank',document.internalform.start.value,document.internalform.end.value);
				});
			
			function addFiltersFromUrl(){
				var locationUrl = window.location+'';				
				if(locationUrl.split('#').length>0){
					var bmarks = locationUrl.split('#')[1];
					try{
					var flter_ar = bmarks.split('*');
					for(var i=0;i<flter_ar.length;i++){
						var ar = filters[flter_ar[i]];
							var dvname = '';
							var locCode  = ar[0];
							ar[2] 		 = true;
							var checked  = ar[2];
							var name   	 = ar[1];
							if("sub_1"==ar[4]){
								filter('roomGroupFilter',locCode,true,name,'RmTypexe','RmTyD','RmTyp','subid1',false)
							}else if("sub_2"==ar[4]){
								filter('HotelTyPeFilter',locCode,true,'','slCat','CtgNm','amty','subid4',false)
							}else if("sub_3"==ar[4]){
								filter('StarCategoryFilter',locCode,true,'','slCat','CtgNm','amty','subid3',false)
							}else if("sub_4"==ar[4]){
								filter('FacilityFilter',locCode,true,'','slCat','CtgNm','amty','subid4',false);
							}else if("sub_5"==ar[4]){
								filter('LocationCategoryFilter',locCode,true,'','slLocexe','sLNm','slLoc','subid5',false)
							}else if("sub_6"==ar[4]){
								filter('LocationFilter',locCode,true,'','slCat','CtgNm','amty','subid6',false);
							}				 
				}
				}catch(e){ 					
				}				
			}
			
			setStartEnd(my_start,my_end);
			
			var locNamz="";
			try{
				locNamz=locNamz.substring(0,locNamz.indexOf(" ("))
			}catch(e){
				locNamz="";
			}
			
			document.getElementById("acc-in").value="ALL"; 
			}
			
			function setStartEnd(start,end){
				var qStringz = document.internalform.currentdomain.value;
				if(qStringz.indexOf("start=") != -1 || qStringz.indexOf("end=") != -1){	
					qStringz = BuildUrl(qStringz, "start", new Array(start))
					qStringz = BuildUrl(qStringz, "end", new Array(end))		
				}
					document.internalform.currentdomain.value = qStringz;
		    }
			
			
			
	</script>
   
   <script type="text/javascript">
	
	function backButtonLoadingDatz(){
	
		var indt = 20;
		var inMm  = (8)+1;
		var inyr = 2013;
		
		var outdt = 21;
		var outMm  = parseInt(8)+1;
		var outyr = 2013;	
			
			
		$( "#check-in" ).val(indt+"/"+inMm+"/"+inyr);
		$( "#check-out" ).val(outdt+"/"+outMm+"/"+outyr);
		
		var adultz =2;
		$($("#guests")[0].parentNode).find('.selectArea').find('.center').html(adultz)
		$("input[name=noOfAdults]").val(adultz)
		
		var inndt = $.datepicker.formatDate('dd-M-yy (D)', new Date(inyr, 8, indt))
		var outdtval = $.datepicker.formatDate('dd-M-yy (D)', new Date(outyr, 8, outdt))
		$("input[name=checkInShowDate]").val(inndt)
		$("input[name=checkOutShowDate]").val(outdtval)
		
		var adultz =1;
		$("input[name=noOfNights]").val(adultz)
		
	}
</script>
<script src="reservations_files/script.htm" type="text/javascript"></script><script src="reservations_files/commonutilstats.js" charset="UTF-8" type="text/javascript"></script><style type="text/css"></style><script src="reservations_files/mixpanel-2.js" async="" type="text/javascript"></script><style media="screen" type="text/css">#dddContent {visibility:hidden}</style><style media="screen" type="text/css">#easyInlineSwf {visibility:hidden}</style><script src="reservations_files/trustBanner.js"></script><script src="reservations_files/js.js" type="text/javascript"></script><style type="text/css">#reviewsDisp , #reviewsDisp * { position:relative; color:inherit; font-family:Arial; font-weight:inherit; font-size:inherit; margin:0; padding:0; box-sizing:content-box; -moz-box-sizing:content-box; -webkit-box-sizing:content-box; text-align:center; line-height:1; border:none; -webkit-border-radius:0; -moz-border-radius:0; border-radius:0; text-shadow:none;-moz-box-shadow: none; -webkit-box-shadow: none;box-shadow: none;overflow:hidden; }#reviewsDisp { display:block; position:relative; margin:9px; width:143px; height:70px; color:#BABABA; background:#FFF; border:1px solid #BABABA; -webkit-border-radius:5px; -moz-border-radius:5px; border-radius:5px; overflow:hidden; }#reviewsDisp.reviewRed { color:#C66; }#reviewsDisp.reviewYellow { color:#C90; }#reviewsDisp.reviewGreen { color:#6B9E0C; }#reviewsDisp .reviewContent { display:block; float:left; width:119px;  }#reviewsDisp .reviewTitle { height:23px; font-size:14px; color:#69C; font-weight:bold; background: #ffffff; background: -moz-linear-gradient(top,  #ffffff 0%, #eeeeee 100%); background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#eeeeee));background: -webkit-linear-gradient(top,  #ffffff 0%,#eeeeee 100%);  background: -o-linear-gradient(top,  #ffffff 0%,#eeeeee 100%);  background: -ms-linear-gradient(top,  #ffffff 0%,#eeeeee 100%);  background: linear-gradient(to bottom,  #ffffff 0%,#eeeeee 100%);  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#eeeeee',GradientType=0 );  }#reviewsDisp.trust.reviewRed .reviewTitle, #reviewsDisp.trust.reviewYellow .reviewTitle, #reviewsDisp.trust.reviewGreen .reviewTitle { color:inherit; }#reviewsDisp .reviewTitle > div { line-height:23px; }#reviewsDisp .reviewSection { height:28px; margin:5px 0 0; font-size:12px; font-weight:bold; }#reviewsDisp .reviewSection .percent.rated { font-size:26px }#reviewsDisp .reviewSection .percent span { font-size:18px; position:relative; top:-7px; }#reviewsDisp .reviewSection .reviewStars { color:#BABABA;font-size:12px;margin-left:4px; }#reviewsDisp .reviewSection .reviewStar { float:left; margin-top:3px; width:22px; height:22px; background:url(//wac.edgecastcdn.net/800952/a1008/app/review_sprite.png) transparent; background }#reviewsDisp .reviewSection .reviewStar.reviewStarFull { background-position:-5px -88px }#reviewsDisp .reviewSection .reviewStar.reviewStarHalf { background-position:-27px -88px }#reviewsDisp .reviewSection .reviewStar.reviewStarNone { background-position:-49px -88px }#reviewsDisp .reviewFooter { font-size:10px; line-height:12px;color:#BABABA; }#reviewsDisp.trust .reviewFooter { color:inherit; margin:0 5px; overflow:hidden; }.trust .rate { display:none }.rate .trust { display:none }#reviewsDisp .reviewNav { width:24px; display:block; float:right; }#reviewsDisp .reviewNav .reviewBtn { display:block; height:23px; background:url(//wac.edgecastcdn.net/800952/a1008/app/review_sprite.png) transparent; background-color:#E3E3E3; border-bottom:1px solid #FFF;cursor:pointer; }#reviewsDisp .reviewNav .reviewBtn:last-child { border-bottom:none; }#reviewsDisp .reviewNav .reviewBtn.hover { background-color:#D1D1D1; }#reviewsDisp .reviewNav .reviewBtn.reviewSelected { background-color:#BABABA; cursor:auto; }#reviewsDisp .reviewNav .reviewBtn.reviewCheck { background-position: -3px -6px }#reviewsDisp .reviewNav .reviewBtn.reviewSelected.reviewCheck { background-position: -33px -6px }#reviewsDisp .reviewNav .reviewBtn.reviewThumb { background-position: -3px -59px }#reviewsDisp .reviewNav .reviewBtn.reviewSelected.reviewThumb { background-position: -33px -59px }#reviewsDisp .reviewNav .reviewBtn.reviewInfo { background-position: -3px -32px }</style><style type="text/css"></style></head>
<body style="margin-bottom: 340px;">

	<div class="disablebg" id="disable_back" style="display:block"></div>
	<div class="layover_wrapper" id="loading" style="display: block; width: 300px; left: 492.5px; top: 257.5px;">
		<div class="layover">           
			<div class="layover_body">
				<div style="border:1px #666 solid;">
					<br><img src="../images/ajax-loader.gif" height="32" width="32"><br><br><span id="loadingtxt">Updating your results....</span><br><br>
				</div>
			</div>
		</div>
	</div>
	<div style="display:none;" id="loading_book" class="layover_wrapper">
		<div class="layover">           
			<div class="layover_body">
				<div style="border:1px #666 solid;">
					<br><img src="../images/ajax-loader.gif" height="32" width="32"><br><br>Processing your request....<br><br>
				</div>
			</div>
		</div>
	</div>
	
<form name="styleForm" action="../hotels/ReservationDetails" method="post">
	
	     <div style="display:none">
			<input name="AffiliateMainPage" type="text">
			<input name="hidHotCode" type="text">
			<input name="hotName" type="text">
			<input name="hotAddress" type="text">			
			<input name="rooTypeCode" type="text">
			<input name="rooType" type="text">
			<input name="bedTypeString" type="text">
			<input name="bedTypeCode" type="text">
			<input name="rateCode" type="text">
			<input name="checkInDate" value="20-Sep-2013 00:00" type="text">
			<input name="checkOutDate" value="21-Sep-2013 00:00" type="text">
			<input name="noOfRooms" value="1" type="text">
			<input name="noOfAdults" value="${criteria.noofadults}" type="text">
			<input name="noOfChildren" value="0" type="text">
			<input name="cityCode" type="text">
			<input name="noOfNights" value="${criteria.noofnights}" type="text">
			<input name="unFormatedDate" value="20-8-2013" type="text">
			<input name="unFormatedCheckOutDate" value="21-8-2013" type="text">
			<input name="language" value="en" type="text">
			<input name="country" value="US" type="text">
			<input name="browser" type="text">
			<input name="afftCode" value="RA" type="text">
			<input name="userName" type="text">
			<input name="passWord" type="text">
			<input name="ratePlanCode" type="text">
			<input name="checkInShowDate" value="Sep-20-2013 (Fri)" type="text">
			<input name="checkOutShowDate" value="Sep-21-2013 (Sat)" type="text">
			<input name="standardRate" type="text">
			<input name="additionalRate" type="text">
			<input name="childRate" type="text">
			<input name="totAdditional" type="text">
			<input name="totChild" type="text">
			<input name="freeSell" type="text">
			<input name="bedType" type="text"> 
			<input name="promotions" type="text">
			<input name="fromdate" type="text">
			<input name="todate" type="text">
			<input name="afftParams3" value=" " type="text">
			<input name="afftParams4" type="text">
			<input name="afftParams5" type="text">
			<input name="hotelSpecialCode" type="text">
			<input name="freeNights" type="text">
			<input name="tCreditCcFee" type="text">
			<input name="tRoomTax" type="text">
			<input name="hidAffHotelURL" type="text">
			<input name="rtType" type="text">
			<input name="rateStr" type="text">
			<input name="tSalesTax" type="text">
			<input name="hotNetRate" type="text">
			<input name="reqRequestID" type="text">
			<input name="rateStr" type="text">
			<input name="visitorInfo" value="-" type="text">
			<input name="cmbCheckInDate" value="${fromdate[2]}" type="text">
			<input name="cmbCheckInYear" value="${fromdate[0]}" type="text">
			<input name="cmbCheckInMonth" value="${fromdate[1]}" type="text">		
			<input name="cmbCheckOutDate" value="${todate[2]}" type="text">
			<input name="cmbCheckOutYear" value="${todate[0]}" type="text">
			<input name="cmbCheckOutMonth" value="${todate[1]}" type="text">
			<input name="filtcodes" value="" type="text">
			<input name="selCity" type="text">
			<input name="DiscountAmount" value="0" type="text">
			<input name="DiscountType" type="text">
			<input name="NoAd" value="${criteria.noofadults}" type="text">
			<input name="cmbNoChi" value="0" type="text">
			
			<input name="cmbNoOfNights" value="1" type="text">
			<input name="cmbNoOfRooms" value="1" type="text">
			<input name="enablenewlayout" value="Y" type="text">
			<input name="AffUserName" value="-" type="text">			
			<input name="AffPassWord" value="-" type="text">		
		</div>	
	</form>
	<form name="internalform">
		<div style="display:none">
			<input name="currentdomain" value="../hotels/ResevationSearchResults?fromdate=${criteria.from_date}&amp;todate=${criteria.to_date}&amp;afftCode=RA&amp;cmbNoOfRooms=1&amp;NoAd=${criteria.noofadults}&amp;cmbNoChi=0&amp;language=en&amp;country=US&amp;hotelCode=%&amp;dsc=d#&amp;mxP=1-1000" type="text">
			<input name="forwarddomain" value="-" type="text">
			<input name="locationtrue" value="false" type="text">
			<input name="backloaded" value="true" type="text">
			<input name="backloaedflters" id="backloaedflters" value="-" type="text">
			<input name="cmsSource" value="http://web1.secure-reservation.com/servlets/ACCentral.ResevationSearchResults?cmbCheckInMonth=8&amp;cmbCheckInDate=20&amp;cmbCheckInYear=2013&amp;cmbCheckOutMonth=8&amp;cmbCheckOutDate=21&amp;cmbCheckOutYear=2013&amp;afftCode=RA&amp;cmbNoOfRooms=1&amp;cmbNoOfAdults=2&amp;cmbNoChi=0&amp;language=en&amp;country=US&amp;hotelCode=%&amp;dsc=d#&amp;mxP=1-1000" type="text">
			<input name="currentpage" value="1" type="text">
			<input name="loadmsg" value="Processing your request...." type="text">
			<input name="next" value="Next" type="text">
			<input name="prev" value="Prevoius" type="text">
			<input name="sortVal" value="rank" type="text">
			<input name="start" value="1" type="text">
			<input name="end" value="50" type="text">
			<input name="current" value="1" type="text">
		</div>
	</form>

<div>
  <!-- Begin header -->
  <!--Begin header top -->
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
        <!--End header top -->
        <!--Begin header top right -->
          <div class="grid_24 alpha float_right">
          <div class="flash_header">
              <div class="text_center">
            	<div class="aaa">
            		<a href=""><img alt="A. C. Central Reservations" src="reservations_files/logo_lite2.jpg" height="44" width="760"></a><br>
            	</div>
            	<div class="aaa"> 
					<iframe src="reservations_files/slider.htm" style="width:780px;margin-right: -3px; margin-top: -8px; " scrolling="no"></iframe> 
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
            <!--div class="hotline float_right"> <span class="hotline_number">1-888-227-6667</span> <span class="hotline_text">Booking lines open 24x7</span> </div-->
          </div>
          <div class="clear"></div>
            <div class="sub_header">
	          <div class="grid_12 push_12">
	            <div class="grid_9 alpha float_right">
	              <ul class="nav-list float_right">
	                <li><a class="active_white" href="">Search</a></li>
	                <li><a class="active_orange" href="">Select</a></li>
	                <li><a class="active_white" href="">Book</a></li>
	                <li><a class="active_white" href="">Confirm</a></li>
	              </ul>
	            </div>
	          </div>
        	</div>
        <!--End header top right -->
        <!--Begin header top left -->
        <div class="clear"></div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <!--End header top left -->
  <!--End header -->
</div>
<div class="container_24">
  <!--Begin Main content body -->
  <!-- Begin left column -->
  <div class="grid_7 padding_top_15 padding_bottom_15">
	    <div class="grid_7 left_column_bg padding_bottom_15">
		      <div class="grid_6 padding_top_8 padding_bottom_15">
			        <div class="accommodation_filter">
				          <h3 class="accommodation_filter_header">Accommodation in:</h3>
				          <form action="accommodation_filter">
				          		<div class="field">	
				          			<div style="float:right"><table>
										<tbody><tr style="cursor:pointer"><td id="togArrow"><img onclick="javascript:clickArrow()" alt="" src="reservations_files/select-button.gif" height="21" width="19"></td></tr>
										</tbody></table>
										</div>
									<div>
										<!--span class="dropdown_icon" onclick="javascript:clickArrow()">&nbsp;</span-->
									<input title="Accommodation in:" class="text" value="ALL" id="acc-in" autocomplete="off" type="text">
						            <input id="HID_SELECTEDHOTEL_val" value="ALL" type="hidden">
						            <div id="popups" style="z-index:3;"></div>
					  			</div>          
				          
			          </div></form>
		        </div>
	      </div>
      <div class="clear"></div>
      <div class="grid_6 margin_left_18">
        <form action="#">
          <div class="bec_quick">
          <h5>Dates:</h5>
          <div class="inner_bg">
            <div class="grid_1_bec alpha font_bold">
              <label for="checkin">Check In</label>
            </div>
            <div class="grid_3_bec omega">
              <input id="check-in" value="${fromdate[2]}/${fromdate[1]}/${fromdate[0]}" type="text">
            </div>
            <div class="clear"></div>
            
            <div class="clear"></div>
            <div class="grid_1_bec alpha font_bold margin_top_5">
              <label for="checkout">Check Out</label>
            </div>
            <div class="grid_3_bec omega margin_top_5">
              <input class="cal3" id="check-out" value="${todate[2]}/${todate[1]}/${todate[0]}" type="text">
              
            </div>
            <div class="clear"></div>
            <div class="grid_1_bec alpha font_bold margin_top_5">
              <label for="rooms">Rooms</label>
            </div>
            <div class="grid_3_bec omega margin_top_5">
              <select id="rooms">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
              </select>
            </div>
            <div class="clear"></div>
            <div class="grid_1_bec alpha font_bold margin_top_5">
              <label for="adults">Adults</label>
            </div>
            <div class="grid_3_bec omega margin_top_5">
              <select id="guests">
						<option value="1">1</option>
						<option value="2" selected="selected">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
              </select>
            </div>
            <div class="clear"></div>
            <div class="grid_1_bec alpha font_bold margin_top_5">
              <label for="children">Children</label>
            </div>
            <div class="grid_3_bec omega margin_top_5">
              <select id="children">
						<option value="0" selected="selected">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
			   </select>
            </div>
            <div class="clear"></div>
           </div>
             <div class="grid_4 margin_top_15 push_2"> <a class="book_button" href="javascript:searchAgain();">Search Again</a> </div>
            <div class="clear">
            </div>
          </div>
        </form>
      </div>
      <div class="grid_6 margin_left_18 price_filter margin_top_5">
        <div class="border_yellow">
          <h6 class="narrow_filter_header">Narrow results by</h6>
          <a href="" class="maroon_text font_bold">Clear all filters &nbsp;x</a> </div>
      </div>
      <div class="clear"></div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow">
          <h6> Price </h6>
          <div class="margin_top_15"> <strong class="float_left">Min</strong>
            <div class="grid_3 price_display_main slider">
              <span class="label-min">$1</span>
			  <span class="label-max">$1000</span>
              <div class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" id="slider"><div style="left: 0.1%; width: 99.9%;" class="ui-slider-range ui-widget-header"></div><a style="left: 0.1%;" class="ui-slider-handle ui-state-default ui-corner-all" href="#"></a><a style="left: 100%;" class="ui-slider-handle ui-state-default ui-corner-all" href="#"></a></div>
            </div>
            <strong class="float_right">Max</strong> </div>
          <div class="clear"></div>
          <br>
        </div>
        <div class="clear"></div>
      </div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow">
          <h6>Star Rating</h6>
          <ul class="check-list check-list2" id="sub_2">
			<li></li>
		  </ul>
        </div>
      </div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow">
	        <h6>Amenities</h6>
			<ul class="check-list" id="sub_3">
			<li> &nbsp; </li>
			</ul>
        </div>
      </div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow">
          <h6>Rate Plans</h6>
			<ul class="check-list" id="sub_1">
			<li> &nbsp; </li>
			</ul>
        </div>
      </div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow">
          <h6> View map Atlantic City</h6>
          <a href="javascript:showMap('ALL');window.scrollTo(0,200);"> <img alt="image description" src="reservations_files/map.png" height="88" width="201"> </a> </div>
      </div>
      <div class="grid_6 margin_left_18 margin_top_5 price_filter">
        <div class="border_yellow padding_bottom_15">
          <h6> Why book with us? </h6>
          <ul class="book_us">
            <li>Lowest prices </li>
            <li>Only pay a deposit to book</li>
            <li>Student discounts </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- End left column -->
  <!-- Begin right column -->
  <div class="grid_17">
    <div class="grid_17">
      <div class="grid_17">
        <div class="grid_11 float_right padding_bottom_15">
          <ul class="menu">
            <li><a href="" class="ico-forward font_bold">Forward to Friend</a></li>
            <li><a href="" class="ico-forward font_bold">Send me this page</a></li>
          </ul>
        </div>
        <div class="clear"></div>
        <!--div class="grid_9 alpha">
          <h3> <span class="white_text float_left"> Results: 582 found, </span></h3>
          <br/>
          <span class="font_bold white_text float_left">197 available accommodations (3228 rooms) </span> </div-->
        <div class="grid_7 alpha bg_light_yellow float_right">
          <div class="sort_filter filter_main margin_top_5"> Sort By : </div>
          <div class="float_right filter_main">
            <form action="accommodation_filter">
              <select id="sort" class="select_filter" onchange="SortBy('orderBy',this.value)">
                &lt;
						<option selected="selected" value="rank">Hotel Rank</option>																

						<option value="price">Lowest Price</option>																

						<option value="hotelName">Hotel Name</option>																

						<option value="starrating">Star Category</option>																
              </select>
              <input value="submit" class="no_display" type="submit">
            </form>
          </div>
        </div>
      </div>
    </div>
    
    <!-- map  view -->
    <div id="mapView" style="display:none;">
		<div class="grid_17 padding_top_8 bec_quick" style="padding-bottom:15px !important">
		<div id="mapTitle">Map view</div>
		<div id="map_canvas">
				<div id="map" style="width: 640px; height: 410px;  background-color: rgb(229, 227, 223);">
				</div>
		</div>
			<div class="show-hide">
			<div class="holder"><a class="book_button" style="margin-left: 545px;" href="#" onclick="hideMap()"><span>Hide Map</span></a></div>
			</div>
		</div></div>
    <div class="clear"></div>
	<br>
    <!-- finished here-->
    
    
    <!-- adding result-->
    <div id="results_component"></div>
    <!-- completed -->
    <!-- promotion shower-->
    <div id="promot" style="display:none;" class="popupage">
        <div class="container_24">
          <div class="grid_8">
            <p> Gallery </p>
          </div>
        </div>
    </div>
    <!-- completed-->
	<!-- paging -->
	<div class="paging" id="paginmain" style="display:block">
		<div class="area">
			<!-- results-form -->
			<ul id="paging_control">
				<li>&nbsp;</li>
			</ul>
		</div>
	</div>
    </div>
    <div class="clear"></div>
    <br>
    	<p class="sub_noties text_center">
    		<a class="pagelink2" href="javascript:ldPg(2);">Disclaimer</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    		<a href="javascript:ldPg(4);" class="pagelink2">Privacy policy</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    		<a href="javascript:EMailFriend();" class="pagelink2">E-mail This Page</a>&nbsp;&nbsp;|&nbsp;&nbsp;
    		<a href="javascript:CusFeedBack();" class="pagelink2">Visitor Satisfaction Feedback</a>
    	</p>
    </div>   

</body></html>