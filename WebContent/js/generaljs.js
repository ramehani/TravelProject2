function windoPop(link){	
	window.open (link,'_self',true);
}

function windoPopNew(link){	
	window.open((link).replace('#',''));
}

function EMailFriend(){
	var s_filters = getSelectedFilters();
	var sort = document.getElementById("sort").options[document.getElementById("sort").selectedIndex].value;
	var pageNo = document.internalform.currentpage.value;
	var startR = document.internalform.start.value;
	var endR = document.internalform.end.value;
	//alert("start>>"+startR);
	//alert("end>>"+endR);
	//alert();
	if((document.internalform.currentdomain.value).indexOf("sortval=") == -1){
	document.internalform.forwarddomain.value = (document.internalform.currentdomain.value).replace('ResevationSearchXML','ForwardToFriend').replace('&option=ViewEmail','').replace('#','')+'&cmbCity='+document.styleForm.cmbCity.value+'&option=EmailDetail&maxpPrevalue=99999&screen=SEARCH&selCity='+escape(document.styleForm.selCity.value)+'&cmbNoOfRooms='+document.styleForm.noOfRooms.value+'&cmbNoOfAdults='+document.styleForm.cmbNoOfAdults.value+'&cmbNoChi='+document.styleForm.cmbNoChi.value+'&cmbNoOfNights='+document.styleForm.cmbNoOfNights.value+'&cmbCheckInDate='+document.styleForm.cmbCheckInDate.value+'&cmbCheckInMonth='+document.styleForm.cmbCheckInMonth.value+'&cmbCheckInYear='+document.styleForm.cmbCheckInYear.value+'&cmbCheckOutDate='+document.styleForm.cmbCheckOutDate.value+'&cmbCheckOutMonth='+document.styleForm.cmbCheckOutMonth.value+'&cmbCheckOutYear='+document.styleForm.cmbCheckOutYear.value+'&hotelCode='+escape(document.styleForm.hotelCode.value)+'&selAmenity='+escape(document.styleForm.selAmenity.value)+'&selDiscount1='+document.styleForm.selDiscount1.value+'&selDiscount2='+document.styleForm.selDiscount2.value+'&afftCode='+document.styleForm.afftCode.value+'&HidRoomType='+escape(document.styleForm.HidRoomType.value)+'&selCategoryName='+escape(document.styleForm.selCategoryName.value)+'&selGroup='+escape(document.styleForm.selGroup.value)+'&start='+document.internalform.start.value+'&end='+document.internalform.end.value+'&hidroomtypedesc=All Room Types&language='+document.styleForm.language.value+'&currCount='+document.styleForm.currCount.value+'&filtervalz='+escape(s_filters)+'&enableNewLayout='+document.styleForm.enableNewLayout.value+'&sortval='+sort+'&pageNo='+pageNo+'&start='+startR+'&end='+endR+'';
	}else{
	//alert(sort);
	/*alert((document.internalform.currentdomain.value).replace(/(sortval=)[W]&/,'sortval='+sort+'&').replace('pageNo=','pageNo='+pageNo+'&').replace('start=', 'start='+startR+'&').replace('end=','end='+endR+'&'));*/
	//alert((document.internalform.currentdomain.value).split("&sortval")[0]);
	
	document.internalform.forwarddomain.value = (document.internalform.currentdomain.value).split("&sortval")[0].replace('ResevationSearchXML','ForwardToFriend').replace('&option=ViewEmail','').replace('#','').replace('sortval=','sortval='+sort+'&').replace('pageNo=','pageNo='+pageNo+'&').replace('start=', 'start='+startR+'&').replace('end=','end='+endR)+'&cmbCity='+document.styleForm.cmbCity.value+'&option=EmailDetail&maxpPrevalue=99999&screen=SEARCH&selCity='+escape(document.styleForm.selCity.value)+'&cmbNoOfRooms='+document.styleForm.noOfRooms.value+'&cmbNoOfAdults='+document.styleForm.cmbNoOfAdults.value+'&cmbNoChi='+document.styleForm.cmbNoChi.value+'&cmbNoOfNights='+document.styleForm.cmbNoOfNights.value+'&cmbCheckInDate='+document.styleForm.cmbCheckInDate.value+'&cmbCheckInMonth='+document.styleForm.cmbCheckInMonth.value+'&cmbCheckInYear='+document.styleForm.cmbCheckInYear.value+'&cmbCheckOutDate='+document.styleForm.cmbCheckOutDate.value+'&cmbCheckOutMonth='+document.styleForm.cmbCheckOutMonth.value+'&cmbCheckOutYear='+document.styleForm.cmbCheckOutYear.value+'&hotelCode='+escape(document.styleForm.hotelCode.value)+'&selAmenity='+escape(document.styleForm.selAmenity.value)+'&selDiscount1='+document.styleForm.selDiscount1.value+'&selDiscount2='+document.styleForm.selDiscount2.value+'&afftCode='+document.styleForm.afftCode.value+'&HidRoomType='+escape(document.styleForm.HidRoomType.value)+'&selCategoryName='+escape(document.styleForm.selCategoryName.value)+'&selGroup='+escape(document.styleForm.selGroup.value)+'&start='+document.internalform.start.value+'&end='+document.internalform.end.value+'&hidroomtypedesc=All Room Types&language='+document.styleForm.language.value+'&currCount='+document.styleForm.currCount.value+'&filtervalz='+escape(s_filters)+'&enableNewLayout='+document.styleForm.enableNewLayout.value+'&sortval='+sort+'&pageNo='+pageNo+'&start='+startR+'&end='+endR+'';
	}
	
	window.open((document.internalform.forwarddomain.value).replace('#',''),"EMF","width=345,height=275,scrollbars=no,resizable=no,status=no");
}

function gobkengine(){
	//var PageUrl=gup('prSc');
	var city=document.styleForm.cmbCity.value;
	var slLoc=document.styleForm.slLoc.value;
	var amenity=document.styleForm.selAmenity.value;
	var hotelCode=document.styleForm.hotelCode.value;
	var inDate=document.styleForm.cmbCheckInDate.value;
	var inYear=document.styleForm.cmbCheckInYear.value;
	var inMonth=parseInt(document.styleForm.cmbCheckInMonth.value)+1;
	var outDate=document.styleForm.cmbCheckOutDate.value;
	var outYear=document.styleForm.cmbCheckOutYear.value;
	var outMonth=parseInt(document.styleForm.cmbCheckOutMonth.value)+1;
	var noofadults=document.styleForm.cmbNoOfAdults.value-1;
	var PageUrl=document.internalform.prSc.value;
	var PageUrl2=PageUrl.replace(/%3A/g, ":").replace(/%26/g, "&").replace(/%3D/g, "=").replace(/%3F/g, "?");
	PageUrl2=PageUrl2+"?city="+city+"&slLoc="+slLoc+"&amenity="+amenity+"&hotelCode="+hotelCode+"&inDate="+inDate+"&inYear="+inYear+"&inMonth="+inMonth+"&outDate="+outDate+"&outYear="+outYear+"&outMonth="+outMonth+"&noofadults="+noofadults;
	window.location=PageUrl2;
}
			
function gup( name ){  
	name = name.replace(/[\\[]/,'\\\\[').replace(/[\\]]/,'\\\\]');  
	var regexS = '[\\?&]'+name+'=([^&#]*)';  var regex = new RegExp( regexS );  
	var results = regex.exec( window.location.href );  
	if( results == null ) {   
		return null; 
	}else{    
		return results[1]; 
	} 
}
 
function loadCurrencyCode(){
	var currencycodeP = gup('cny');
	
	if(currencycodeP!=null && currencycodeP != "null" && currencycodeP!=''){
	 setcookies('currencyname',currencycodeP);
	}
	var currencycodeL = getCookie('currencyname');
	
	
	var lang_code = gup('language');

	if(currencycodeL != null){
	updatedCurrencyCode = currencycodeL;
	}else{ 
	if(lang_code == 'pl'){
	updatedCurrencyCode = 'PLN';
	}else if(lang_code == 'fr' || lang_code == 'de' || lang_code == 'es' || lang_code == 'it'){
	updatedCurrencyCode = 'EUR';
	}else{
	updatedCurrencyCode = 'GBP';
	}
	}

}
loadmapjs = false;
function showMap(hotel_code,hotel_name) {
	jQuery('#mapView').show();
	if(xmlobjectemp == null)
	{
		setTimeout("showMap('"+hotel_code+"','"+hotel_name+"')",300);
	}else
		loadGMap(hotel_code);
}

function fUrl(mUrl) {
	mUrl=mUrl.replace(/@/g ,"'"); if(mUrl!='-' && mUrl!=' ' && mUrl!='') {
	window.open(mUrl+"?affcode=RA",'i','width=800,height=600,scrollbars=yes,resizable=yes,toolbar=yes,menubar=yes');
	}else{
	alert('Hotel Info not Available !')
	}
	}

function setfilterVisibility(){
	if(document.styleForm.afftCode.value == "AFF16"){
		$('.filterRT').hide();
		$('.filterHT').hide();
		$('.filterSR').hide();
		$('.filterL').hide();
	}
}

function SendThisPage(){
	var s_filters = getSelectedFilters();
	var sort = document.getElementById("sort").options[document.getElementById("sort").selectedIndex].value;
	var pageNo = document.internalform.currentpage.value;
	var startR = document.internalform.start.value;
	var endR = document.internalform.end.value;
	
	if((document.internalform.currentdomain.value).indexOf("sortval=") == -1){
	document.internalform.forwarddomain.value = (document.internalform.currentdomain.value).replace('ResevationSearchXML','SendThisPage').replace('&option=ViewEmail','').replace('#','')+'&cmbCity='+document.styleForm.cmbCity.value+'&option=EmailDetail&maxpPrevalue=99999&screen=SEARCH&selCity='+escape(document.styleForm.selCity.value)+'&cmbNoOfRooms='+document.styleForm.noOfRooms.value+'&cmbNoOfAdults='+document.styleForm.cmbNoOfAdults.value+'&cmbNoChi='+document.styleForm.cmbNoChi.value+'&cmbNoOfNights='+document.styleForm.cmbNoOfNights.value+'&cmbCheckInDate='+document.styleForm.cmbCheckInDate.value+'&cmbCheckInMonth='+document.styleForm.cmbCheckInMonth.value+'&cmbCheckInYear='+document.styleForm.cmbCheckInYear.value+'&cmbCheckOutDate='+document.styleForm.cmbCheckOutDate.value+'&cmbCheckOutMonth='+document.styleForm.cmbCheckOutMonth.value+'&cmbCheckOutYear='+document.styleForm.cmbCheckOutYear.value+'&hotelCode='+escape(document.styleForm.hotelCode.value)+'&selAmenity='+escape(document.styleForm.selAmenity.value)+'&selDiscount1='+document.styleForm.selDiscount1.value+'&selDiscount2='+document.styleForm.selDiscount2.value+'&afftCode='+document.styleForm.afftCode.value+'&HidRoomType='+escape(document.styleForm.HidRoomType.value)+'&selCategoryName='+escape(document.styleForm.selCategoryName.value)+'&selGroup='+escape(document.styleForm.selGroup.value)+'&start='+document.internalform.start.value+'&end='+document.internalform.end.value+'&hidroomtypedesc=All Room Types&language='+document.styleForm.language.value+'&currCount='+document.styleForm.currCount.value+'&filtervalz='+escape(s_filters)+'&enableNewLayout='+document.styleForm.enableNewLayout.value+'&sortval='+sort+'&pageNo='+pageNo+'&start='+startR+'&end='+endR+'';

	}else{
	
		document.internalform.forwarddomain.value = (document.internalform.currentdomain.value).split("&sortval")[0].replace('ResevationSearchXML','SendThisPage').replace('&option=ViewEmail','').replace('#','')+'&cmbCity='+document.styleForm.cmbCity.value+'&option=EmailDetail&maxpPrevalue=99999&screen=SEARCH&selCity='+escape(document.styleForm.selCity.value)+'&cmbNoOfRooms='+document.styleForm.noOfRooms.value+'&cmbNoOfAdults='+document.styleForm.cmbNoOfAdults.value+'&cmbNoChi='+document.styleForm.cmbNoChi.value+'&cmbNoOfNights='+document.styleForm.cmbNoOfNights.value+'&cmbCheckInDate='+document.styleForm.cmbCheckInDate.value+'&cmbCheckInMonth='+document.styleForm.cmbCheckInMonth.value+'&cmbCheckInYear='+document.styleForm.cmbCheckInYear.value+'&cmbCheckOutDate='+document.styleForm.cmbCheckOutDate.value+'&cmbCheckOutMonth='+document.styleForm.cmbCheckOutMonth.value+'&cmbCheckOutYear='+document.styleForm.cmbCheckOutYear.value+'&hotelCode='+escape(document.styleForm.hotelCode.value)+'&selAmenity='+escape(document.styleForm.selAmenity.value)+'&selDiscount1='+document.styleForm.selDiscount1.value+'&selDiscount2='+document.styleForm.selDiscount2.value+'&afftCode='+document.styleForm.afftCode.value+'&HidRoomType='+escape(document.styleForm.HidRoomType.value)+'&selCategoryName='+escape(document.styleForm.selCategoryName.value)+'&selGroup='+escape(document.styleForm.selGroup.value)+'&start='+document.internalform.start.value+'&end='+document.internalform.end.value+'&hidroomtypedesc=All Room Types&language='+document.styleForm.language.value+'&currCount='+document.styleForm.currCount.value+'&filtervalz='+escape(s_filters)+'&enableNewLayout='+document.styleForm.enableNewLayout.value+'&sortval='+sort+'&pageNo='+pageNo+'&start='+startR+'&end='+endR+'';
	}
	window.open((document.internalform.forwarddomain.value).replace('#',''),"EMF","width=345,height=275,scrollbars=no,resizable=no,status=no");
}