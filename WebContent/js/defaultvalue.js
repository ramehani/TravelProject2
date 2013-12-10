function ldRelData(Value,Value1){
	var searchAnyCity = document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].value;
	var langcode = document.frm1.language.value;
	if(searchAnyCity=='SAC' && document.frm1.afftCode.value == 'RA'){
		if(langcode=='en'){
			window.open ('http://book.travelstay.com/Search_now.htm?set-lang=en&set-currency=GBP','_self',true);
		}else if(langcode=='pl'){
			window.open ('http://tsqa.digital-trip.co.uk/Search_now.htm?set-lang=pl&set-currency=PLN','_self',true);
		}else if(langcode=='it'){
			window.open ('http://tsqa.digital-trip.co.uk/Search_now.htm?set-lang=it&set-currency=EUR','_self',true);
		}else if(langcode=='fr'){
			window.open ('http://tsqa.digital-trip.co.uk/Search_now.htm?set-lang=fr&set-currency=EUR','_self',true);
		}else if(langcode=='es'){
			window.open (' http://tsqa.digital-trip.co.uk/Search_now.htm?set-lang=es&set-currency=EUR','_self',true);
		}else if(langcode=='de'){
			window.open ('http://tsqa.digital-trip.co.uk/Search_now.htm?set-lang=de&set-currency=EUR','_self',true);
		}
	}else if(searchAnyCity=='SAC' && document.frm1.afftCode.value != 'RA'){
		window.open ('http://book.travelstay.com','_self',true);
	}else if(document.getElementById("cmbAccomSelection")){
		str = '';
		document.getElementById("cmbAccomSelection").length=0;
		if(langcode=='en'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('All Accommodation','%') 
		}else if(langcode=='es'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('Todo alojamiento','%') 
		}else if(langcode=='fr'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('Tous les h'+String.fromCharCode(244)+'tels','%') 
		}else if(langcode=='pl'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('Wszystkie miejsca noclegowe','%') 
		}else if(langcode=='de'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('Alle Unterk'+String.fromCharCode(252)+'nfte','%') 
		}else if(langcode=='it'){
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('Tutte le sistemazioni','%') 
		}else{
		document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option('All Accommodation','%') 
		}
		for(a=0;a<arrHot.length;a++){
			if(arrHot[a].hotCty==Value){ 
				document.getElementById("cmbAccomSelection").options[document.getElementById("cmbAccomSelection").length]= new Option(arrHot[a].hotDesc,arrHot[a].hotCd); 
			}
		}
		sortHotels('cmbAccomSelection');
		getdefault_values();
	}else if(document.getElementById("cmbAmenity")){
		var isHostel = false; 	 
		var oGroup = document.createElement('optgroup'); 	 
		var oSelect = document.getElementById("cmbAmenity"); 
		var x=0;
		if(oSelect.hasChildNodes())
		{ 
			oSelect.removeChild(oSelect.firstChild);
			oSelect.innerHTML = '';
		} 
		oSelect.length=0; 
		 oSelect = document.getElementById("cmbAmenity"); 
		var oOption = document.createElement('option'); 
		oOption.value = '%'; 
	  if(langcode=='es'){		
		oOption.innerHTML = 'Todo';  
		}else if(langcode=='fr'){		
		oOption.innerHTML = 'Tous';  
		}else if(langcode=='pl'){		
		oOption.innerHTML = 'Wszystko';
		}else if(langcode=='de'){		
		oOption.innerHTML = 'Alle';  		
		}else if(langcode=='it'){		
		oOption.innerHTML = 'Tutte';  		
		}else{
		oOption.innerHTML = 'All';  
		}
		oSelect.appendChild(oOption); 

		for(a=0;a<arrCtyhty.length;a++){
			if(arrCtyhty[a].Cty==Value){ 
				var subTitle=''; 
				var strVal = arrCtyhty[a].HtyID.split(",");		
				for(b=0;b<strVal.length-1;b++){ 
					if(arrHty[strVal[b]].HtyTle!='-'){
					if(arrHty[strVal[b]].HtyDesc=='Hostel'){isHostel = true;}
						if(subTitle!=arrHty[strVal[b]].HtyTle){ 
							var oGroup = document.createElement('optgroup'); 
							oGroup.label = arrHty[strVal[b]].HtyTle; 	
						}
						var oOption = document.createElement('option'); 
						oOption.value = arrHty[strVal[b]].HtyCd;  
						oOption.innerHTML = arrHty[strVal[b]].HtyDesc;  
						oGroup.appendChild(oOption); 	
						if(subTitle!=arrHty[strVal[b]].HtyTle){ 
							oSelect.appendChild(oGroup); 	
							subTitle=arrHty[strVal[b]].HtyTle;	
						}
					}else if((arrHty[strVal[b]].HtyTle=='-')&&(arrHty[strVal[b]].HtyDesc=='Hostel')&&(!isHostel)){
						if(subTitle!='Type of Hotel'){ 
							var oGroup = document.createElement('optgroup'); 
							oGroup.label = 'Type of Hotel'; 	
						}
						var oOption = document.createElement('option'); 
						oOption.value = arrHty[strVal[b]].HtyCd;  
						oOption.innerHTML = arrHty[strVal[b]].HtyDesc;  
						oGroup.appendChild(oOption); 	
						if(subTitle!='Type of Hotel'){ 
							oSelect.appendChild(oGroup); 	
							subTitle='Type of Hotel';	
						}
					}else{ 
					}
				}
			}
			
		}
		getdefault_values();
	}else if (document.getElementById("cmbLocation")){
		document.getElementById("cmbLocation").length=0;
		if(langcode=='es'){
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('Todas las localizaciones','%') 
		}
		if(langcode=='fr'){
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('Tous les lieux','%') 
		}if(langcode=='pl'){
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('Wszystkie lokalizacje','%') 
		}if(langcode=='de'){
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('Alle Orte','%') 
		}if(langcode=='it'){
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('Tutte le localit'+String.fromCharCode(224)+'','%') 
		}else{
		document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option('All Locations','%') 
		}
		for(a=0;a<arrLCty.length;a++){
			if(arrLCty[a].Cty==Value){ 
				document.getElementById("cmbLocation").options[document.getElementById("cmbLocation").length]= new Option(arrLCty[a].LocIDN,arrLCty[a].LocID); 
			}
		}
		sortHotels('cmbLocation');	
	}
	getdefault_values();
}


var detectload=0;
var city_d = "";
var location_d = "";
var amenity_d = "";
var hotelCode_d = "";

var city_d = "";
var location_d = "";
var amenity_d = "";
var hotelCode_d = "";
var inDate_d = "";
var inYear_d = "";
var inMonth_d = "";
var outDate_d = "";
var outYear_d = "";
var outMonth_d = "";

	
function getdefault_values(){
if ( detectload == 0){
	detectload=1;
	
	var url_val=""+window.location;
	if(url_val.indexOf("?")>0){
		city_d = gup_d('C');
		location_d = gup_d('L');
		amenity_d = gup_d('S');
		hotelCode_d = gup_d('H');

		if(gup_d("city")!='nan'){
		city_d = gup_d("city");
		location_d = gup_d("slLoc");
		amenity_d = gup_d("amenity");
		hotelCode_d = gup_d("hotelCode");
		}
		
		inDate_d = gup_d("inDate");
		inYear_d = gup_d("inYear");
		inMonth_d = gup_d("inMonth");
		outDate_d = gup_d("outDate");
		outYear_d = gup_d("outYear");
		outMonth_d = gup_d("outMonth");
		
		noofadults_d = gup_d('noofadults');
		
		setdefault_values("N");
	}else if(readCookie("hotel_cmbNoOfAdults")  != null){
		city_d = readCookie('hotel_cmbCity');
		cookieckin_d = readCookie('hotel_cmbCheckInDate');
		cookieckout_d = readCookie('hotel_cmbCheckOutDate');
		noofadults_d = readCookie('hotel_cmbNoOfAdults');	
		
		amenity_d = readCookie('hotel_cmbAmenity');
		location_d = readCookie('hotel_cmblocation');	
		hotelCode_d = readCookie('hotel_cmbhotelcode');
		setdefault_values("C");
	}else{
		initvalues();
	}
}
}

function setdefault_values(x){
		
		if(document.getElementById("cmbCity")){	
			for (a=0; a<document.getElementById("cmbCity").length; a++){
			if (document.getElementById("cmbCity").options[a].value==city_d){
			document.getElementById("cmbCity").selectedIndex=a;
			}
			}
			ldRelData(document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].value,"%");
		}
		
		if(document.getElementById("cmbAmenity")){
			for (a=0; a<document.getElementById("cmbAmenity").length; a++){
			if (document.getElementById("cmbAmenity").options[a].value==amenity_d){
			document.getElementById("cmbAmenity").selectedIndex=a;
			}
			}
		}
		if(document.getElementById("cmbAccomSelection")){
			for (a=0; a<document.getElementById("cmbAccomSelection").length; a++){
				if (document.getElementById("cmbAccomSelection").options[a].value==hotelCode_d){
				document.getElementById("cmbAccomSelection").selectedIndex=a;
				}
			}
		}
		if(document.getElementById("cmbLocation")){
			for (a=0; a<document.getElementById("cmbLocation").length; a++){
				if (document.getElementById("cmbLocation").options[a].value==location_d){
				document.getElementById("cmbLocation").selectedIndex=a;
				}
			}
		}
		//alert('noofadults_d>>>>>'+noofadults_d);
		if(noofadults_d=="nan")
			noofadults_d=1;
		
		document.getElementById("cmbNoOfAdults").selectedIndex=noofadults_d;
		
		if(x == "C"){
		// date fomat should be 07/03/2012
			document.getElementById("check-in").value = cookieckin_d;
			document.getElementById("check-out").value = cookieckout_d;
		}else if(inDate_d != 'nan'){
			document.getElementById("check-in").value = inDate_d+"/"+inMonth_d+"/"+inYear_d;
			document.getElementById("check-out").value = outDate_d+"/"+outMonth_d+"/"+outYear_d;
		}
		
		//used for validation
		// if(document.getElementById("cmbCity").value==""||document.getElementById("cmbAmenity").value==""||document.getElementById("cmbAccomSelection").value==""||document.getElementById("cmbLocation").value==""){
			// initvalues();
		// }
}

function initvalues(){	

		if(document.getElementById("cmbCity")){
			document.getElementById("cmbCity").value="CY1";
			ldRelData("CY1","%");
		}
		if(document.getElementById("cmbAmenity")){
			document.getElementById("cmbAmenity").selectedIndex=0;	
		}
		if(document.getElementById("cmbAccomSelection")){
			document.getElementById("cmbAccomSelection").selectedIndex=0;
		}
		if(document.getElementById("cmbLocation")){
			document.getElementById("cmbLocation").selectedIndex=0;		
		}	
		
		document.getElementById("cmbNoOfAdults").selectedIndex=1;
		
}

function gup_d( name ){  
	name = name.replace(/[\\[]/,'\\\\[').replace(/[\\]]/,'\\\\]');  
	var regexS = '[\\?&]'+name+'=([^&#]*)';  var regex = new RegExp( regexS );  
	var results = regex.exec( window.location.href );  
	if( results == null ) {   
		return 'nan'; 
	}else{    
		return results[1]; 
	} 
}

function set_adultno(){
	if(((document.getElementById("cmbAmenity").options[document.getElementById("cmbAmenity").selectedIndex].value=='HT45')||(document.getElementById("cmbAmenity").options[document.getElementById("cmbAmenity").selectedIndex].value=='HT4')||(document.getElementById("cmbAmenity").options[document.getElementById("cmbAmenity").selectedIndex].value=='HT5'))){
		document.getElementById("cmbNoOfAdults").selectedIndex=0;
	}else{
		document.getElementById("cmbNoOfAdults").selectedIndex=1;
	}
}

function sortHotels(drpNm){
	var strVal;
	var srtArray=new Array();
	var b=0;
	for (c=0;c<document.getElementById(drpNm).options.length; c++){
		if(document.getElementById(drpNm).options[c].value!="%") {
		srtArray[b]=document.getElementById(drpNm).options[c].text+"|"+document.getElementById(drpNm).options[c].value;
		b++;
		}
	}
	document.getElementById(drpNm).length=1;
	srtArray.sort();
	for(a=0;a<srtArray.length;a++){
		strVal=srtArray[a];
		document.getElementById(drpNm).options[document.getElementById(drpNm).length]=
		new Option(strVal.substring(0,strVal.indexOf("|")),strVal.substring(strVal.indexOf("|")+1,strVal.length));
	}
	document.getElementById(drpNm).value="%";
}

function checkAdultNo(){
	var adults_value = document.getElementById("cmbNoOfAdults").options[document.getElementById("cmbNoOfAdults").selectedIndex].value;
	var langcode = document.frm1.language.value;
	if(adults_value=='21+'){
		window.open ('http://book.travelstay.com/'+langcode+'/group-enquiry.htm','_self',true);	
	}
}