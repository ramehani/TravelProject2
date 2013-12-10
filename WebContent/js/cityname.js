var one_day=1000*60*60*24;
function initcityName(Valz){

str =''; 
str1 = '';
	document.getElementById("cmbCity").options.length=0;
var chk='N'; 
	for(a=0;a<arrCtydrop.length;a++){		
			document.getElementById("cmbCity").options[document.getElementById("cmbCity").length]= new Option(arrCtydrop[a].CtNameDrop,arrCtydrop[a].CtCdDrop); 
	}		
	 if(readCookie("hotel_cmbCity")  != null){
		var cityName=readCookie('hotel_cmbCity');
		document.getElementById("cmbCity").value=cityName;
		ldRelData(cityName,"%");		
	}else{	
		document.getElementById("cmbCity").value="CY1";
		ldRelData("CY1","%");
	}
}


//Functions used to create and read cookies
function createCookie(name, value) {
        var date = new Date();
        date.setTime(date.getTime() + (60 * 100000));
        var expires = "; expires=" + date.toGMTString();
    document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

if (window.addEventListener) {
    window.addEventListener("load", initcityName, false);
} else if (window.attachEvent) {
    window.attachEvent("onload", initcityName);
}

function guestrooms(noofadults)
{
	if(Number(noofadults) == 1)
		return "GRT1,GRT2,GRT3";
	else if(Number(noofadults) == 2)
		return "GRT2,GRT3,GRT6";
	else if(Number(noofadults) == 3)
		return "GRT4,GRT5,GRT6,GRT8";
	else
//	if(Number(noofadults) == 4)
		return "GRT2,GRT3,GRT4,GRT5,GRT6,GRT8";	
//	else return "%";
}

function windoPop(link){	
			window.open (link,'_self',true);
			//window.open(link,"policy","width=996, height=600, location=no, menubar=yes, status=no, toolbar=yes, scrollbars=yes, resizable=yes");
}