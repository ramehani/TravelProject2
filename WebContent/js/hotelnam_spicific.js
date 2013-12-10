
function searchHotel(){
	document.getElementById("imgSearch").style.innerHTML = "Please Wait";
	var rSource="W";
	
	var prvScr="";
	// if(document.frm1.afftCode.value == 'RA'){
	// if(document.frm1.language.value != "en")
	// {
	    // prvScr="http://bookings.travelstay.com/new/TravelStayBooking_"+document.frm1.language.value+".htm";
	// }else {
		// prvScr="http://bookings.travelstay.com/new/TravelStayBooking.htm";
	// }
	// }else{
		// prvScr="http://bookings.travelstay.com/new/TravelStayBooking_"+document.frm1.afftCode.value+".htm";
	// }
	var currentlocation = new String(window.location);
	var arrprvScr = currentlocation.split("?");
	prvScr = arrprvScr[0];
	var splitcheckin = (document.getElementById("check-in").value).split("/");
	var splitcheckout = (document.getElementById("check-out").value).split("/");
	
	document.frm1.cmbCheckInDate.value = splitcheckin[2]+"-"+splitcheckin[1]+"-"+splitcheckin[0];
	document.frm1.cmbCheckOutDate.value = splitcheckout[2]+"-"+splitcheckout[1]+"-"+splitcheckout[0];
	
	var Accom_name = document.getElementById('cmbAccomSelection')[document.getElementById('cmbAccomSelection').selectedIndex].innerHTML;
//	document.frm1.hotelName.value=Accom_name;
	createCookie("hotel_cmbNoOfAdults",  document.getElementById("cmbNoOfAdults").selectedIndex);
	createCookie("hotel_cmbCity",  document.getElementById("cmbCity").value);

	tmpInDate = new Date(splitcheckin[2],splitcheckin[1],splitcheckin[0],0,0,0,0);
	var temp = tmpInDate.toGMTString();
	var gmtDate = new Date(temp.substring(0, temp.lastIndexOf(" ")-1));
	tmpOutDate = new Date(splitcheckout[2],splitcheckout[1],splitcheckout[0],0,0,0,0);
	if((tmpInDate-gmtDate) == 0)
	{
		if(tmpOutDate.getTimezoneOffset() == -60 && tmpInDate.getTimezoneOffset() == 0)
		{
			tmpOutDate = new Date(document.frm1.cmbCheckOutYear.value,document.frm1.cmbCheckOutMonth.value,document.frm1.cmbCheckOutDate.value,tmpOutDate.getHours()+1,0,0,0);
		}
	}
// dateDifference = get_deference(tmpInDate,tmpOutDate);
dateDifference = (tmpOutDate-tmpInDate)/one_day;
document.frm1.cmbNoOfNights.value = Math.round(dateDifference);
 today = new Date();

  if ((today-tmpInDate)>86400000){
   var languageName = document.frm1.language.value;
	if(languageName.toLowerCase() == "en")
  	{
       alert("Please check your dates - your requested check-in date has already passed!");
    }else if(languageName.toLowerCase() == "de")
  	{
		alert("Bitte wählen Sie ein anderes Datum - Ihr gewünschter Check-In Termin liegt in der Vergangenheit!");
  	}else if(languageName.toLowerCase() == "es")
  	{
		alert("Compruebe las fechas seleccionadas: ¡su fecha de llegada ya ha pasado!");
  	}else if(languageName.toLowerCase() == "it")
  	{
		alert("Controllare le date selezionate: la data di arrivo richiesta è già trascorsa!");
  	}else if(languageName.toLowerCase() == "fr")
  	{
		alert("Veuillez choisir d’autres dates. Les dates que vous avez choisi ne sont plus disponibles.");
  	}else if(languageName.toLowerCase() == "pl")
  	{
		alert("Sprawdz date pobytu - data przyjazdu juz minela!");
  	}
	return;
 }
 
 if (tmpOutDate<tmpInDate){
  alert("Check Out Date should be greater than Check In Date");
  return;
 }
 if (dateDifference>99 || dateDifference<1){
  alert("please only search for a maximum of 99 days");
  return;
 }else{
 }
/*
	if(document.getElementById("cmbAccomSelection").value == "%")
		document.frm1.HidRoomType.value  = guestrooms(document.getElementById("cmbNoOfAdults").value);	
		
	createCookie("hotel_cmbCheckInDate", document.getElementById("check-in").value);
	createCookie("hotel_cmbCheckOutDate", document.getElementById("check-out").value);
	createCookie("hotel_cmbhotelcode", document.getElementById("cmbAccomSelection").value);*/

	//sub_url="http://192.168.1.212:7001/servlet/TravelStay.ResevationSearch?afCd="+document.frm1.afftCode.value+"&afTp="+document.frm1.afftType.value+"&NoAd="+document.frm1.cmbNoOfAdults.options[document.frm1.cmbNoOfAdults.selectedIndex].value+"&NoCh="+document.frm1.cmbNoChi.value+"&NoNgt="+document.frm1.cmbNoOfNights.value+"&stPr=0&edPr=999999&PrRg=All%20Prices&AcNm="+escape(document.frm1.hotelName.value)+"&Grp="+escape(document.frm1.selGroup.value)+"&NoRm="+document.frm1.cmbNoOfRooms.value+"&Ct="+escape(document.frm1.cityCd.value)+"&InDt="+document.frm1.cmbCheckInDate.options[document.frm1.cmbCheckInDate.selectedIndex].value+"&InMn="+document.frm1.cmbCheckInMonth.options[document.frm1.cmbCheckInMonth.selectedIndex].value+"&InYr="+document.frm1.cmbCheckInYear.options[document.frm1.cmbCheckInYear.selectedIndex].value+"&OtDt="+document.frm1.cmbCheckOutDate.value+"&prSc="+escape(prvScr)+"&OtMn="+document.frm1.cmbCheckOutMonth.options[document.frm1.cmbCheckOutMonth.selectedIndex].value+"&OtYr="+document.frm1.cmbCheckOutYear.options[document.frm1.cmbCheckOutYear.selectedIndex].value+"&htCd="+escape(document.frm1.hotelCode.value)+"&amty="+escape(document.frm1.selCategory.value)+"&slCt="+escape(document.frm1.selCity.value)+"&CtgNm="+escape(document.frm1.selCategoryName.value)+"&slCat="+escape(document.frm1.selCategory.value)+"&Dcn1="+document.frm1.selDiscount1.value+"&Dcn2=N&mxP="+document.frm1.maxpPrevalue.value+"&RmTyD="+escape(document.frm1.cmbRoomType.options[document.frm1.cmbRoomType.selectedIndex].text)+"&RmTyp="+escape(document.frm1.HidRoomType.value)+"&slLoc="+document.frm1.selLocation.value+"&sLNm="+escape(document.frm1.selLocationNm.value)+"&Sor="+rSource+"&vInf="+escape(document.frm1.visitorInfo.value)+"&language=en&country=US&browser=IE&flB=T&Utp=HT";
	//sub_url="http://192.168.1.212:7001/servlet/TravelStay.ResevationSearch?afCd="+document.frm1.afftCode.value+"&afTp="+document.frm1.afftType.value+"&NoAd="+document.frm1.cmbNoOfAdults.options[document.frm1.cmbNoOfAdults.selectedIndex].value+"&NoCh="+document.frm1.cmbNoChi.value+"&NoNgt="+document.frm1.cmbNoOfNights.value+"&stPr=0&edPr=999999&PrRg=All%20Prices&AcNm="+escape(document.frm1.hotelName.value)+"&Grp="+escape(document.frm1.selGroup.value)+"&NoRm="+document.frm1.cmbNoOfRooms.value+"&Ct="+escape(document.frm1.cityCd.value)+"&InDt="+document.frm1.cmbCheckInDate.options[document.frm1.cmbCheckInDate.selectedIndex].value+"&InMn="+document.frm1.cmbCheckInMonth.options[document.frm1.cmbCheckInMonth.selectedIndex].value+"&InYr="+document.frm1.cmbCheckInYear.options[document.frm1.cmbCheckInYear.selectedIndex].value+"&OtDt="+document.frm1.cmbCheckOutDate.value+"&prSc="+escape(prvScr)+"&OtMn="+document.frm1.cmbCheckOutMonth.options[document.frm1.cmbCheckOutMonth.selectedIndex].value+"&OtYr="+document.frm1.cmbCheckOutYear.options[document.frm1.cmbCheckOutYear.selectedIndex].value+"&htCd="+escape(document.frm1.hotelCode.value)+"&amty="+escape(document.frm1.selCategory.value)+"&slCt="+escape(document.frm1.selCity.value)+"&CtgNm="+escape(document.frm1.selCategoryName.value)+"&slCat="+escape(document.frm1.selCategory.value)+"&Dcn1="+document.frm1.selDiscount1.value+"&Dcn2=N&mxP="+document.frm1.maxpPrevalue.value+"&RmTyD="+escape(document.frm1.cmbRoomType.options[document.frm1.cmbRoomType.selectedIndex].text)+"&RmTyp="+escape(document.frm1.HidRoomType.value)+"&slLoc="+document.frm1.selLocation.value+"&sLNm="+escape(document.frm1.selLocationNm.value)+"&Sor="+rSource+"&vInf="+escape(document.frm1.visitorInfo.value)+"&language=en&country=US&browser=IE&flB=T&Utp=HT";
	//sub_url="http://192.168.1.212:7001/servlet/TravelStay.ResevationSearch?afCd="+document.frm1.afftCode.value+"&afTp="+document.frm1.afftType.value+"&NoAd="+document.frm1.cmbNoOfAdults.options[document.frm1.cmbNoOfAdults.selectedIndex].value+"&NoCh="+document.frm1.cmbNoChi.value+"&NoNgt="+document.frm1.cmbNoOfNights.value+"&stPr=0&edPr=999999&PrRg=All%20Prices&AcNm="+escape(document.frm1.hotelName.value)+"&Grp="+escape(document.frm1.selGroup.value)+"&NoRm="+document.frm1.cmbNoOfRooms.value+"&Ct="+escape(document.frm1.cityCd.value)+"&InDt="+document.frm1.cmbCheckInDate.options[document.frm1.cmbCheckInDate.selectedIndex].value+"&InMn="+document.frm1.cmbCheckInMonth.value+"&InYr="+document.frm1.cmbCheckInYear.value+"&OtDt="+document.frm1.cmbCheckOutDate.value+"&prSc="+escape(prvScr)+"&OtMn="+document.frm1.cmbCheckOutMonth.value+"&OtYr="+document.frm1.cmbCheckOutYear.value+"&htCd="+escape(document.frm1.hotelCode.value)+"&amty="+escape(document.frm1.selCategory.value)+"&slCt="+escape(document.frm1.selCity.value)+"&CtgNm="+escape(document.frm1.cmbCty.options[document.frm1.cmbCty.selectedIndex].text)+"&slCat="+escape(document.frm1.selCategory.value)+"&Dcn1="+document.frm1.selDiscount1.value+"&Dcn2=N&mxP="+document.frm1.maxpPrevalue.value+"&RmTyD="+escape(document.frm1.cmbRoomType.options[document.frm1.cmbRoomType.selectedIndex].text)+"&RmTyp="+escape(document.frm1.HidRoomType.value)+"&slLoc="+document.frm1.selLocation.value+"&sLNm="+escape(document.frm1.selLocationNm.value)+"&Sor="+rSource+"&vInf="+escape(document.frm1.visitorInfo.value)+"&language=en&country=US&browser=IE&flB=T&Utp=HT";
	/*if(document.frm1.afftCode.value == 'RA'){
	var currencycodeL = getCookie('currencyname');*/
	sub_url="hotels/ResevationSearch?" +
//			"afCd="+document.frm1.afftCode.value+"&afTp="+document.frm1.afftType.value+"&NoAd="+document.getElementById("cmbNoOfAdults").options[document.getElementById("cmbNoOfAdults").selectedIndex].value+"&NoCh="+document.frm1.cmbNoChi.value+"&NoNgt="+document.frm1.cmbNoOfNights.value+"&stPr=0&edPr=999999&PrRg=All%20Prices&AcNm="+escape(document.frm1.hotelName.value)+"&Grp="+escape(document.frm1.selGroup.value)+"&NoRm="+document.frm1.cmbNoOfRooms.value+"&Ct="+escape(document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].value)+"&
	"fromdate="+  document.frm1.cmbCheckInDate.value +"&"+
	"todate="+ document.frm1.cmbCheckOutDate.value +"&NoAd="+document.getElementById("cmbNoOfAdults").options[document.getElementById("cmbNoOfAdults").selectedIndex].value+""+
//	InDt="+document.frm1.cmbCheckInDate.value+"&InMn="+document.frm1.cmbCheckInMonth.value+"&InYr="+document.frm1.cmbCheckInYear.value+"&
//	OtDt="+document.frm1.cmbCheckOutDate.value+"
//		&prSc="+escape(prvScr)+"
//		&OtMn="+document.frm1.cmbCheckOutMonth.value+"&OtYr="+document.frm1.cmbCheckOutYear.value+"
//			&htCd="+escape(document.getElementById("cmbAccomSelection").value)+"&amty="+escape(document.frm1.selAmenity.value)+"&slCt="+escape(document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].text)+"&CtgNm="+escape(document.frm1.selCategoryName.value)+"&slCat="+escape(document.frm1.selCategory.value)+"&Dcn1="+document.frm1.selDiscount1.value+"&Dcn2=N&mxP="+document.frm1.maxpPrevalue.value+"&RmTyD=&RmTyp="+escape(document.frm1.HidRoomType.value)+"&slLoc="+escape(document.frm1.selLocation.value)+"&sLNm="+escape(document.frm1.selLocationNm.value)+"&flB=C&Sor="+rSource+"&vInf="+escape(document.frm1.visitorInfo.value)+"&language="+escape(document.frm1.language.value)+"&country="+escape(document.frm1.country.value)+"&InDate="+escape(document.frm1.cmbCheckInDate.selectedIndex)+"&OutDate="+escape(document.frm1.cmbCheckOutDate.selectedIndex)+"&NoAdTs="+escape(document.getElementById("cmbNoOfAdults").selectedIndex)+"&cny="+escape(currencycodeL)+"&roomtype=&browser=IE&Utp=C&id=TS&sgamty=-&bcd=" +
					"";
	/*}else{
	sub_url="http://secure.travelstay.com/servlet/TravelStay.ResevationSearch?afCd="+document.frm1.afftCode.value+"&afTp="+document.frm1.afftType.value+"&NoAd="+document.getElementById("cmbNoOfAdults").options[document.getElementById("cmbNoOfAdults").selectedIndex].value+"&NoCh="+document.frm1.cmbNoChi.value+"&NoNgt="+document.frm1.cmbNoOfNights.value+"&stPr=0&edPr=999999&PrRg=All%20Prices&AcNm="+escape(document.frm1.hotelName.value)+"&Grp="+escape(document.frm1.selGroup.value)+"&NoRm="+document.frm1.cmbNoOfRooms.value+"&Ct="+escape(document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].value)+"&InDt="+document.frm1.cmbCheckInDate.value+"&InMn="+document.frm1.cmbCheckInMonth.value+"&InYr="+document.frm1.cmbCheckInYear.value+"&OtDt="+document.frm1.cmbCheckOutDate.value+"&prSc="+escape(prvScr)+"&OtMn="+document.frm1.cmbCheckOutMonth.value+"&OtYr="+document.frm1.cmbCheckOutYear.value+"&htCd="+escape(document.getElementById("cmbAccomSelection").value)+"&amty="+escape(document.frm1.selAmenity.value)+"&slCt="+escape(document.getElementById("cmbCity").options[document.getElementById("cmbCity").selectedIndex].text)+"&CtgNm="+escape(document.frm1.selCategoryName.value)+"&slCat="+escape(document.frm1.selCategory.value)+"&Dcn1="+document.frm1.selDiscount1.value+"&Dcn2=N&mxP="+document.frm1.maxpPrevalue.value+"&RmTyD=&RmTyp="+escape(document.frm1.HidRoomType.value)+"&slLoc="+escape(document.frm1.selLocation.value)+"&sLNm="+escape(document.frm1.selLocationNm.value)+"&flB=C&Sor="+rSource+"&vInf="+escape(document.frm1.visitorInfo.value)+"&language="+escape(document.frm1.language.value)+"&country="+escape(document.frm1.country.value)+"&InDate="+escape(document.frm1.cmbCheckInDate.selectedIndex)+"&OutDate="+escape(document.frm1.cmbCheckOutDate.selectedIndex)+"&NoAdTs="+escape(document.getElementById("cmbNoOfAdults").selectedIndex)+"&cny="+escape(document.frm1.cny.value)+"&roomtype=&browser=IE&Utp=C&id=TS&sgamty=-&bcd=";
	
	}*/
	
	if(document.getElementById("transitScreen"))
	{
	    document.getElementById("main").style.display="none";
	    document.getElementById("main").style.visibility ="hidden";
	    document.getElementById("footer").style.display="none";
	    document.getElementById("footer").style.visibility ="hidden";
	    document.getElementById("transitScreen").style.display="block";
	    document.getElementById("transitScreen").style.visibility="visible";
    }
	document.location=sub_url;
}
