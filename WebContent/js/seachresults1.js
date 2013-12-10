var filterzn=""; 
var filterznamen=""; 
var filtzvalzcodes;
var filtergcodes="";
var clearprice="F";

var loc_chk=0;
var stg_chk=0;
var hfac_chk=0;
var htype_chk=0;
var grt_chk=0;
var typloc_chk=0;
var xslpath = '';

var lastfilter="",lastfiltertype="",lastfiltertype1="",lastcolumnname="",lastcolumncode="",lastcolumncode1="",lastfiltertp="";
var filterselected = new Array();
var currentindex = 0;

var hoteltypecodefilt=new Array();
var starfilt=new Array();
var rateplanfilt=new Array();
function filter(filtertype,filtername,check,filter1,columnname,columncode,columncode1,filtertp,arg){
	filtersapplied = true;
		try{
		if(filterselected.length==0)
		{			
			filterselected[currentindex] ="filtertype"; 
		}else{
			if(filterselected.indexOf("filtertype") == -1){		
				filterselected.splice(currentindex,0,"filtertype"); 
			}
		}
				currentindex++;
		}catch(e)
		{
		}
		document.getElementById('disable_back').style.display='block';
		document.getElementById('loading').style.display='block';
		set_to_center('loading');		
	 
		if(filtername.indexOf("HT") >= 0 ){
			filterzn = hoteltypecode;			
		}else if(filtertype == "roomGroupFilter"){
			filterzn = roomcategorycode;			
		}else if(filtertype == "LocationCategoryFilter"){
			filterzn = locationcategorycode;			
		}else { 
			filterzn = starcategorycode;			
		}
		lastfilter = filtertype;		lastfiltertype = filtername;		lastfiltertype1 = filter1;		lastcolumnname =columnname;
 		lastcolumncode = columncode;		lastcolumncode1 = columncode1;		lastfiltertp = filtertp;	
	
			var qString = document.internalform.currentdomain.value; 
			qString = BuildUrl(qString, "start", new Array("1"))  //always resert page to 1 
			qString = BuildUrl(qString, "end", new Array("20"))  //always resert page to 1 
			qString = BuildUrl(qString, "page", new Array("1"))  //always resert page to 1 

		  if( filtername.indexOf("HT")== -1 && filtername.indexOf("AC")== -1 && filtername.indexOf("RP")== -1 && filtername.indexOf("LC")== -1){
			  columnname="slsgCat";
			  columncode="slsgCtgNm";
			  columncode1="sgamty";
		  }

			var filtzvalz=filtername;
			 
			 var filtzgcodes1=new Array();
			 var filtzgcodes=new Array();
			 if(filtername != "STG%" && filtername != "HT%" && filtername != "RP%" && filtername != "AC%" && filtername != "LC%"){ 
				if(!check){
					try{
						 if(filterzn.toString().lastIndexOf(',') > 0)
						 {
							 filtzgcodes2=filterzn.toString().split(",");
							 filtergcodes1=filtergcodes.toString().split(",");
							 filterzn=removeaddcols(filtzgcodes2,filtzgcodes2,filtzgcodes2,filtername,filtertype);
						 }else
						 {
							filterzn = "%";
						 }
					 }catch(e)
					 {
							alert(e);
							filterzn = "%";
					 }
					 if(filterzn.toString() == "" || filterzn.toString() == ",,")	
						filterzn="%";
					 if(filtername.indexOf("HT")== -1 && filtername.indexOf("RP")== -1){
							if (filterzn == "%" )
							  filterzn="-";
						} 
						
								if(filtername.toString().indexOf("RP") != -1)		
								{
									if(rateplanfilt.length == 1)
									{
										filters['RP%'][2] = true;	
									    check_checkbox('RP%',true);											
										grt_chk =0;	
									}
								}else
								if(filtername.toString().indexOf("ST") != -1)		
								{
									if(starfilt.length == 1)
										{
											check_checkbox('STG%',true);	
											filters['STG%'][2] = true;	
											stg_chk=0;
										}
								}else
								if(filtername.toString().indexOf("AC") != -1)		
								{
									if(hoteltypecodefilt.length == 1)
									{
										filters['AC%'][2] = true;	
									    check_checkbox('AC%',true);											
										hfac_chk =0;	
									}
								}
				}else{
					if(filtername.toString().indexOf("RP") != -1)	
					{
						check_checkbox('RP%',false);
						filters['RP%'][2] = false;	
						grt_chk=1;
					}else if(filtername.toString().indexOf("ST") != -1)	 
					{
						check_checkbox('STG%',false);
						filters['STG%'][2] = false;	
						stg_chk=1;
					}else if(filtername.toString().indexOf("AC") != -1)	 
					{
						 check_checkbox('AC%',false);
						 filters['AC%'][2] = false;	
						 htype_chk=1;
					}else if(filtername.toString().indexOf("LC") != -1)	
					{
						check_checkbox('LC%',false);
						loc_chk=1;						
					}
				} 
			}else { 

				if(filtername == "STG%"){
					filterzn = "-";
					filterznamen = "";
					uncheckelements('sub_2','STG%');
					stg_chk=0;
				}else if(filtername == "RP%") { 
					filterzn = "%";
					filterznamen = "";
					uncheckelements('sub_1','RP%');
					grt_chk=0;
				}else if(filtername == "LC%") { 
					filterzn = "%";
					filterznamen = "";
					loc_chk=0;
					//uncheckelements('sub_5','LC%');
					uncheckelements('sub_6','LC%');
				}else if(filtername == "AC%"){ 
					filterzn = "-";
					filterznamen = "";  
					uncheckelements('sub_3','AC%'); 
					htype_chk=0;				
				}else {/* 
				*/} 
			} 
			
			if(filtername.indexOf("AC") >= 0 ){
				hoteltypecode = filterzn;
				if(!check){
					for(x2 in hoteltypecodefilt)
					{
						if(hoteltypecodefilt[x2] == filtername)
						   hoteltypecodefilt.splice(x2, 1);
					}
				}else{
					if(filtername == "AC%")
						hoteltypecodefilt=new Array();
					else	
						hoteltypecodefilt[hoteltypecodefilt.length] = filtername;
				}
				
			}else if(filtername.indexOf("RP") >= 0){
				if(!check){
					for(x2 in rateplanfilt)
					{
						if(rateplanfilt[x2] == filtername)
							rateplanfilt.splice(x2, 1);
					}
				}else{
					if(filtername == "RP%")
						rateplanfilt=new Array();
					else	
						rateplanfilt[rateplanfilt.length] = filtername;
				}
			}else if(filtertype == "LocationCategoryFilter"){
				locationcategorycode=filterzn;			
			}else { 
				starcategorycode=filterzn;		
				if(!check){
					for(x2 in starfilt)
					{
						if(starfilt[x2] == filtername){
							starfilt.splice(x2, 1);
							var filtername2 = "" ;

							if(filtername=="ST10"){
								filtername2 = "ST9_H" ;
							}else if(filtername=="ST9"){
								filtername2 = "ST7_H" ;
							}else if(filtername=="ST7"){
								filtername2 = "ST8_H" ;
							}

							for(x3 in starfilt){
								if(starfilt[x3] == filtername2){
								     starfilt.splice(x3, 1);
								}
							}
						}
					}
				}else{
					if(filtername == "STG%")
						starfilt=new Array();
					else{	
						starfilt[starfilt.length] = filtername;

						if(filtername=="ST10"){
							var filtername2 = "ST9_H" ;
							starfilt[starfilt.length] = filtername2 ;
						}else if(filtername=="ST9"){
							var filtername2 = "ST7_H" ;
							starfilt[starfilt.length] = filtername2 ;
						}else if(filtername=="ST7"){
							var filtername2 = "ST8_H" ;
							starfilt[starfilt.length] = filtername2 ;
						}else {

						}
					
					}	
				}
			}
			
			
			if(filtertype == "roomGroupFilter"){
			filtzvalzcodes="Y";
			} 
				qString = BuildUrl(qString, columnname, new Array(filtzvalzcodes)) 
				qString = BuildUrl(qString, columncode, new Array(filterznamen)) 	
				qString = BuildUrl(qString, columncode1, new Array(filterzn)) 
				qString = BuildUrl(qString, "filtzgcodes", new Array(filtergcodes)) 
				qString = BuildUrl(qString, "filtertype", new Array(filtertype)) 
				qString = BuildUrl(qString, "selfiltzgcodes", new Array(filtername)) 
				qString = BuildUrl(qString, "filtercheck", new Array(check))
				qString = BuildUrl(qString, "filtered", new Array("Yes"))				
				qString = BuildUrl(qString, "filterresults", new Array("true"))
				qString = BuildUrl(qString, "resultgenerate", new Array("YES"))
				qString = BuildUrl(qString, "slCat", new Array(""))				

				qString = qString.replace("#","");
				document.internalform.currentdomain.value = qString;
	var locationfalse= "false";	
	if(filtername.indexOf("LC%") == 0)
		locationfalse= "true";	
	else if(filtername.indexOf("LC") == -1)	
		locationfalse= "true";	
	if(arg)
		setTimeout('callDisplayResults("false","'+locationfalse+'","'+orderbyselection+'",1,20)',500);
	urlrewrite();
} 

function urlrewrite()
{
	window.location = 	'#'+getSelectedFilters();
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
		 try{		
			if(Number(my_page_no) == null){
				my_start = 1;
				my_end  = 20;
				my_page_no = 1;
			}	
		 }catch(e){
				my_start = 1;
				my_end  = 20;
				my_page_no = 1;
		 }
		 bk_dates='@'+document.getElementById("check-in").value+'~'+document.getElementById("check-out").value + '@' + my_page_no +'@' + my_start + '@' + my_end +'@' + stPrice +'@' + edPrice;
		 return s_filters+bk_dates;
}

function gobackfilters()
{
	var filterlength = filterselected.length;
	if(filterselected[filterlength-1] == "filtertype")
	{
		check_checkbox(lastfiltertype,false);
		filters[lastfiltertype][2] = false;
		filter(lastfilter,lastfiltertype,false,lastcolumnname,'slCat','CtgNm','amty',lastfiltertp,true);
	}else if(filterselected[filterlength-1] == "slider")
	{
		$("#slider").slider( "values" , 0 , [0] );
		$("#slider").slider( "values" , 1 , [slidermaxval] );
		$("#slider").parent().find(".label-min").text(String.fromCharCode(163)+""+0);
		$("#slider").parent().find(".label-max").text(String.fromCharCode(163)+""+slidermaxval);
		slider(0,slidermaxval);
	}
	
}
function uncheckelements(element,alltag)
{
	 for (var code in filters) {
		var ar =  filters[code];
		if(ar[4]==element){
			ar[2] = false;	
		}
	}

	try{
		if(alltag=="RP%" ){
			filters['RP%'][2] = true;
		}
		if(alltag=="AC%" ){
			filters['AC%'][2] = true;
		}
		if(alltag=="HT%" ){
			filters['HT%'][2] = true;
		}
		if(alltag=="STG%" ){	
			filters['STG%'][2] = true;
		}
        if(alltag=="LC%" ){		
			filters['LC%'][2] = true;
		}	
	}catch(e){}
		
	
	renderLocationFilter()
}
function clearFilters()
{
	filtersapplied = false;
loc_chk=0;
stg_chk=0;
hfac_chk=0;
htype_chk=0;
grt_chk=0;
typloc_chk=0;
//xmlobject = null;
	document.getElementById('disable_back').style.display='block';
	document.getElementById('loading').style.display='block';
	set_to_center('loading');
	$("#slider").slider( "values" , 0 , [0] );
	$("#slider").slider( "values" , 1 , [slidermaxval] );
	$("#slider").parent().find(".label-min").text(String.fromCharCode(163)+""+0);
	$("#slider").parent().find(".label-max").text(String.fromCharCode(163)+""+slidermaxval);	
	uncheckelements('sub_1','RP%');
	uncheckelements('sub_2','STG%');
	uncheckelements('sub_3','AC%');
	uncheckelements('sub_4','');
	uncheckelements('sub_5','');
	uncheckelements('sub_6','');
	
	hoteltypecodefilt=new Array();
	starfilt=new Array();
	rateplanfilt=new Array();
	
//	hoteltypecode ="%";
//	locationcategorycode ="-";
//	roomcategorycode="%"
//	starcategorycode="-";
	var qString = document.internalform.currentdomain.value; 
	qString = BuildUrl(qString, "start", new Array("1"))  //always resert page to 1 
	qString = BuildUrl(qString, "end", new Array("20"))  //always resert page to 1 
	qString = BuildUrl(qString, "page", new Array("1"))  //always resert page to 1 
	qString = BuildUrl(qString, "RmTyp", new Array(roomcategorycode)) 
	qString = BuildUrl(qString, "amty", new Array(hoteltypecode)) 
	qString = BuildUrl(qString, "slLoc", new Array(locationcategorycode)) 
	qString = BuildUrl(qString, "sgamty", new Array(starcategorycode)) 
	qString = BuildUrl(qString, "htCd", new Array("%"))
	qString = BuildUrl(qString, "altstatus", new Array("N"));	
	qString = BuildUrl(qString, "sortval", new Array("-")) 
	qString = BuildUrl(qString, "mxP", new Array("0-300"));
	qString = BuildUrl(qString, "Dcn1", new Array("N"));
	qString = qString.replace("#","");
	document.internalform.currentdomain.value = qString;
	stPrice = 0;
	edPrice = 150;
	getSelectedFilters();
	setTimeout('callDisplayResultsclear("false","true")',500);
	try{
		filters['RP%'][2] = true;
		filters['HTG%'][2] = true;
		filters['AC%'][2] = true;
		filters['STG%'][2] = true;
		filters['LC%'][2] = true;
	}catch(e){}
	document.getElementById("acc-in").value = document.styleForm.selCity.value;
}

function removeaddcols(filtz,filtzgcodes,filtzgcodesret,filter){
	 var filtzgcodes1 = new Array();
	 var xyo1=0; 
	 for(xyo=0;xyo<filtz.length;xyo++)
	 { 
		if(filtzgcodes[xyo] != filter){ 
		filtzgcodes1[xyo1] = filtzgcodes[xyo]; 
		xyo1++; 
		} 
	 } 
	filtzgcodesret=filtzgcodes1;
	
	 return filtzgcodesret;
} 
function callServer(url)
{
	var xmltable = (document.styleForm.filtcodes.value).split(","); // or just []
	var xmldatatable = new Array(); // or just []
	
	for (x2 in xmltable)
	{
		xmldatatable[x2] = 'ZERO';
	}
	
	var returnxml="";
	countval =0;
	 $.each(xmlobject.hotel, function(key, val) {
		 var amenitykeys = xmlobject.hotel[key]['amenitycode'].split(',');
		 for(x in xmltable)
		 {
			if(xmltable[x].indexOf("AC")!= -1)
			{
				 for(y in amenitykeys)
				 {
					 if(xmltable[x] == amenitykeys[y])
					 {
						 if(xmldatatable[x] == 'ZERO')
							 xmldatatable[x] = 1;
						 else
							 xmldatatable[x] = xmldatatable[x]+1;
					 }
				 }
			}else if(xmltable[x].indexOf("ST")!= -1)
			{
				if(xmltable[x] == xmlobject.hotel[key]['starcategory'])
				 {
					 if(xmldatatable[x] == 'ZERO')
						 xmldatatable[x] = 1;
					 else
						 xmldatatable[x] = xmldatatable[x]+1;
				 }
			}else if(xmltable[x].indexOf("RP")!= -1){
			 $.each(xmlobject.hotel[key].roomtypes, function(key2, val2) {
				 if(xmltable[x] == xmlobject.hotel[key].roomtypes[key2]['rateplancode'])
				 {
					 if(xmldatatable[x] == 'ZERO')
						 xmldatatable[x] = 1;
					 else
						 xmldatatable[x] = xmldatatable[x]+1;
				 }
				 
			 });
			}
			
		 }
		 
				//results_data += hoteltransform(sortedHotResultz[key]);					
	  });
		var xmlfilter = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
						"<mypage>"+
						"<mydata>";
		for (x2 in xmltable)
		{
			if(xmltable[x2] == "AC" || xmltable[x2] == "STG" || xmltable[x2] == "RP")
				xmlfilter += "<mydatavalz>"+xmltable[x2]+"%,"+"1"+"</mydatavalz>";
			else if(xmldatatable[x2] == "ZERO" || xmldatatable[x2] == "")
				xmlfilter += "<mydatavalz>"+xmltable[x2]+","+"ZERO"+"</mydatavalz>";
			else
				xmlfilter += "<mydatavalz>"+xmltable[x2]+","+xmldatatable[x2]+"</mydatavalz>";
		}
		xmlfilter += "</mydata>"+
					 "</mypage>";
		alertContents($.parseXML( xmlfilter ));
}

function renderLocationFilter(){
//alert(1)
var sub1_str = '';
var sub2_str = '';
var sub3_str = '';
var sub4_str = '';
var sub5_str = '';
var sub6_str = '';
for (var code in filters) {
    var ar =  filters[code];
	if(ar[3]){
	
		var strs='';
		
		var dvname = '';
		if("sub_1"==ar[4]){
			dvname = 'dvr';
		}
		if("sub_2"==ar[4]){
			dvname = 'dvh';
		}
		if("sub_3"==ar[4]){
			dvname = 'dvd';
		}
		if("sub_4"==ar[4]){
			dvname = 'dvs';
		}
		if("sub_5"==ar[4]){
			dvname = 'dv';
		}
		if("sub_6"==ar[4]){
			dvname = 'dvl';
		}

		strs +='<li id="subid_'+ar[0]+'" style="width:235px;">';
		strs +='<div class="check_box'+(ar[2]?'_checked':'')+'" id="'+dvname+'_'+ar[0]+'">&nbsp;</div><span class="checkbox">'+ar[1]+'</span>';
		strs +='</li>';

		if("sub_1"==ar[4]){
			sub1_str+=strs;
		}else
		if("sub_2"==ar[4]){
			strs='';
			strs +='<li id="subid_'+ar[0]+'" style="width:235px;">';
			strs +='<div class="check_box'+(ar[2]?'_checked':'')+'" id="'+dvname+'_'+ar[0]+'">&nbsp;</div>'+ar[1]+'';
			strs +='</li><div class="clear"></div>';
			sub2_str+=strs;
		}else
		if("sub_3"==ar[4]){
				
			sub3_str+=strs;
		}else
		if("sub_4"==ar[4]){
			sub4_str+=strs;
		}else
		if("sub_5"==ar[4]){
			sub5_str+=strs;
		}else
		if("sub_6"==ar[4]){
			sub6_str+=strs;
		}
	}
}
var ul = document.getElementById('sub_1');
ul.innerHTML = sub1_str;

ul = document.getElementById('sub_2');
ul.innerHTML = sub2_str;

ul = document.getElementById('sub_3');
ul.innerHTML = sub3_str;

//ul = document.getElementById('sub_4');
//ul.innerHTML = sub4_str;

//ul = document.getElementById('sub_5');
//ul.innerHTML = sub5_str;

//ul = document.getElementById('sub_6');
//ul.innerHTML = sub6_str;
 
 initcheck_box();
 
 //window.location = 	'#'+getSelectedFilters();


}

function check_alloption(){
		var stg_checked = false;
		var grt_checked = false;
		var htg_checked = false;
		var ht_checked = false;
		var lc_checked = false;

	for (var code in filters) {
			var ar =  filters[code];
			if(lastfiltertype=="STG%" && ar[0].indexOf("STG") != -1 && ar[0] != "STG%"){
				ar[2] = false;
			}
			
			if(lastfiltertype=="RP%" && ar[0].indexOf("RP") != -1 && ar[0] != "RP%"){
				ar[2] = false;
			}
			
			if(lastfiltertype=="HT%" && ar[0].indexOf("HT") != -1 && ar[0] != "HT%" && ar[4] == 'sub_2'){
				ar[2] = false;
			}
			
			if(lastfiltertype=="AC%" && ar[0].indexOf("AC") != -1 && ar[0] != "AC%" && ar[4] == 'sub_3'){
				ar[2] = false;
			}
			
			if(ar[0].indexOf("STG") != -1 && ar[0] != "STG%" && ar[2] && !stg_checked){
				stg_checked= true;
			}
			if(ar[0].indexOf("GRT") != -1 && ar[0] != "GRT%" && ar[2] && !grt_checked){
				grt_checked = true;
			}
			if(ar[0].indexOf("HT") != -1 && ar[0] != "HT%" && ar[2] && !ht_checked && ar[4] == 'sub_2'){
				ht_checked = true;
			}
			if(ar[0].indexOf("AC") != -1 && ar[0] != "AC%" && ar[2] && !htg_checked && ar[4] == 'sub_3'){
				htg_checked = true;
			}
			
			if(ar[0].indexOf("HT") != -1 && ar[0] != "LC%" && ar[2] && !lc_checked && ar[4] == 'sub_6'){
				lc_checked = true;
			}

		}
		
		filters["STG%"][2] = !stg_checked;
		filters["RP%"][2] = !grt_checked;
//		filters["HT%"][2] =  !ht_checked;*/
		filters["AC%"][2] = !htg_checked;

//		filters["LC%"][2] =  !lc_checked;*/
		

			 
}
var isRefreshed = false;
var filtersInTheFirstSearch = "";
function alertContents(xml) {    
	var valz1h
	
	valz = xml.documentElement.getElementsByTagName("mydatavalz");
	for(i=0;i<valz.length;i++) {
		valz1 = (valz[i].firstChild.nodeValue).split(",");			
		var code = 	valz1[0];
		var include = 'ZERO'!=valz1[1] ||( (code.indexOf('ST')!=-1 || code.indexOf('AC')!=-1 || code.indexOf('RP')!=-1) && isRefreshed && filters[code][3]);
		if(include && !isRefreshed)
			filtersInTheFirstSearch += code + "#";
			
		try{
			filters[code][3] = include;
			var ar = filters[code];
		}catch(e){
			//alert("2:" + e);
		}
	}
	check_alloption();
	if(!isRefreshed && $('#backloaedflters').val()=='-')
		$('#backloaedflters').val(filtersInTheFirstSearch);	
		
	var backFilerAr = $('#backloaedflters').val().split('#');
	for(var i=0;i<backFilerAr.length;i++){
		var fcode = backFilerAr[i];
		try{
			filters[fcode][3] = true;
		}catch(e){
			//alert(e);
		}
	}
	isRefreshed = true;
	renderLocationFilter();	
} 
function alertAncestorsUntilID(node, id) {
var parent = node;
 vazlcount =0 
 tertvals = false;
while(vazlcount < 9) {
 try {
 parent = parent.parentNode;
 	if(parent.id == id) 
 	tertvals = true;
 }catch(Exception){} 
  vazlcount++
}
 return tertvals;
}


function fUrl1(mUrl) {
  top.location=mUrl
}
var imgtop=0;
var Mshow=false;
			
var he = screen.height;
var wi = screen.width;

function BuildUrl(qString, name, arrVal) {
      var i ;
      var qStringNew = '';
			
      if (qString != "") { 
	var curName; 
	var arrNameVal = qString.split("&") ;
			
	for (i in arrNameVal) { 
		 curName = arrNameVal[i].split("=")[0] ;
	 	 curName = ReplaceUrl(curName) ;
	  	 if (curName.toLowerCase() != name.toLowerCase()){qStringNew += "&" + arrNameVal[i]}; 
	 } 
	} 
			
	for (i in arrVal) { 
	 qStringNew += "&" + escape(name) + "=" + escape(arrVal[i]) 
	} 
			
	return qStringNew.substr(1) ;
 } 
function SortBy(name, val) { 
				document.getElementById('disable_back').style.display="block";
				//document.getElementById('disable_back').style.display='block';
				document.getElementById('loading').style.display='block';
				set_to_center('loading');
				
				val =$("#sort option:selected").val();
				
				var qString = document.internalform.currentdomain.value;				
				var idresultselement=document.getElementById("results");
				var noOfResults=50;
				qString = BuildUrl(qString, "start", new Array("1"))  //always resert page to 1 
				qString = BuildUrl(qString, "end", new Array(noOfResults))  //always resert page to 1 
				qString = BuildUrl(qString, "page", new Array("1"))  //always resert page to 1 
				qString = BuildUrl(qString, name, new Array(val.toString())) 
				qString = BuildUrl(qString, "srtbox", new Array("Y")) 
				qString = BuildUrl(qString, "filter", new Array("Y")) 
				
				if(qString.indexOf('resultgenerate') == -1)
					qString += "&resultgenerate=YES";
				document.internalform.currentdomain.value = qString;	
				sortenable = true;
				orderbyselection = val;
				callDisplayResults('false','false',val,1,50);
				document.internalform.currentpage.value=1;
				document.internalform.start.value=1;
				document.internalform.end.value=50;
				/*document.internalform.currentdomain.value = qString;
				displayResult(document.internalform.currentdomain.value,'/html/Ts/xsl/hotel_results.xsl','results_component','',1);*/
} 

function sortvalueset(sorttoset){	
	if(sorttoset == false){
		var language=document.styleForm.language.value;
		if(document.getElementsByClassName){
			if (language == 'es'){ 
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Distancia desde el centro";
			}else if (language == 'pl'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Odleg&#322;o&#347;&#263; od centrum";
			}else if (language == 'it'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Distanza dal centro";
			}else if (language == 'de'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Entfernung zur Innenstadt";
			}else if (language == 'fr'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Distance du centre";
			}else{
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Distance from centre";
			}
		}else if (document.getElementsByTagName){
		i = 0;
		a = document.getElementsByTagName("div");
		while (element = a[i++]) {
			if (element.className == "selectArea") {
					if (language == 'es'){ 
					element.childNodes[1].innerHTML="Distancia desde el centro";
					}else if (language == 'pl'){
					element.childNodes[1].innerHTML="Odleg&#322;o&#347;&#263; od centrum";
					}else if (language == 'it'){
					element.childNodes[1].innerHTML="Distanza dal centro";
					}else if (language == 'de'){
					element.childNodes[1].innerHTML="Entfernung zur Innenstadt";
					}else if (language == 'fr'){
					element.childNodes[1].innerHTML="Distance du centre";
					}else{
					element.childNodes[1].innerHTML="Distance from centre";
					}
				return false;
			}
		}
		}
		//initCustomForms();		
		sortenable='true';
	}
}
	
function sortvaluesettp(sorttoset){	
	if(sorttoset == false){
		var language=document.styleForm.language.value;
		if(document.getElementsByClassName){
			if (language == 'es'){ 
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Ubicaci&#243;n";
			}else if (language == 'pl'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Lokalizacja";
			}else if (language == 'it'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Localit&#224;";
			}else if (language == 'de'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Ort";
			}else if (language == 'fr'){
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Lieu";
			}else{
			document.getElementsByClassName('selectArea')[0].childNodes[1].innerHTML="Location";
			}
		}else if (document.getElementsByTagName){
		i = 0;
		a = document.getElementsByTagName("div");
		while (element = a[i++]) {
			if (element.className == "selectArea") {
					if (language == 'es'){ 
					element.childNodes[1].innerHTML="Ubicaci&#243;n";
					}else if (language == 'pl'){
					element.childNodes[1].innerHTML="Lokalizacja";
					}else if (language == 'it'){
					element.childNodes[1].innerHTML="Localit&#224;";
					}else if (language == 'de'){
					element.childNodes[1].innerHTML="Ort";
					}else if (language == 'fr'){
					element.childNodes[1].innerHTML="Lieu";
					}else{
					element.childNodes[1].innerHTML="Location";
					}
				return false;
			}
		}
		}
		//initCustomForms();		
		sortenable='true';
	}
}	
		
function ChangeLang(langcode, countrycode) { 
				document.getElementById('disable_back').style.display='block';
				document.getElementById('loading').style.display='block';
				set_to_center('loading');
	
	var qString = location.search.substr(1) 
	qString = BuildUrl(qString, "start", new Array("1"))  //always resert page to 1 
	qString = BuildUrl(qString, "end", new Array("20"))  //always resert page to 1 
	qString = BuildUrl(qString, "page", new Array("1"))  //always resert page to 1 
	qString = BuildUrl(qString, "language", new Array(langcode)); 
	qString = BuildUrl(qString, "country", new Array(countrycode)); 
	qString = qString+"&srtbox=Y"; 
	if(qString.indexOf('resultgenerate') == -1)
					qString += "&resultgenerate=YES";
	document.internalform.currentdomain.value = qString;
	displayResult(document.internalform.currentdomain.value,'/html/Ts/xsl/hotel_results.xsl','results_component','',1);
	//location = location.toString().substr(0,location.toString().indexOf("?")) + "?" + qString 
 } 
var one_day=1000*60*60*24;

function searchAgain(){

		isRefreshed = false;
		document.internalform.backloaedflters.value="-";
		$('.multiple_room_details').css('display','none');
		document.getElementById('disable_back').style.display='block';
		document.getElementById('loading').style.display='block';
		set_to_center('loading');
		var checkinvalue =(document.getElementById("check-in").value).split("/");
		var checkoutvalue =(document.getElementById("check-out").value).split("/");
		var qString = document.internalform.currentdomain.value;
		qString = BuildUrl(qString, "fromdate", new Array(checkinvalue[2]+"-"+checkinvalue[1]+"-"+checkinvalue[0]));
		qString = BuildUrl(qString, "todate", new Array(checkoutvalue[2]+"-"+checkoutvalue[1]+"-"+checkoutvalue[0]));
		qString = BuildUrl(qString, "NoAd", new Array(document.getElementById("guests").options[document.getElementById("guests").selectedIndex].value));
		console.log("qString >>"+qString);
//		qString = BuildUrl(qString, "cmbCheckInYear", new Array(checkinvalue[2]))
//		qString = BuildUrl(qString, "cmbCheckInMonth", new Array(""+(Number(checkinvalue[1])-1)))
//		qString = BuildUrl(qString, "cmbCheckInDate", new Array(checkinvalue[0]))
//		qString = BuildUrl(qString, "cmbCheckOutYear", new Array(checkoutvalue[2]))
//		qString = BuildUrl(qString, "cmbCheckOutMonth", new Array(""+(Number(checkoutvalue[1])-1)))
//		qString = BuildUrl(qString, "cmbCheckOutDate", new Array(checkoutvalue[0]))
//		qString = BuildUrl(qString, "cmbNoOfRooms", new Array(document.getElementById("rooms").options[document.getElementById("rooms").selectedIndex].value))
//		qString = BuildUrl(qString, "cmbNoOfAdults", new Array(document.getElementById("guests").options[document.getElementById("guests").selectedIndex].value))
//		qString = BuildUrl(qString, "cmbNoChi", new Array(document.getElementById("children").options[document.getElementById("children").selectedIndex].value))
//		qString = BuildUrl(qString, "enablenewlayout", new Array("Y"))
		uncheckelements('sub_2','STG%');
		htype_chk=0;
		uncheckelements('sub_3','AC%');
		stg_chk=0;
		uncheckelements('sub_1','RP%');
		hfac_chk=0;
			
		uncheckelements('sub_6','LC%');
		typloc_chk=0;
		
		
		filtersapplied = false;
		hoteltypecodefilt=new Array();
		starfilt=new Array();
		rateplanfilt=new Array();
		var afftCodz =document.styleForm.afftCode.value;
		var sort_val =document.internalform.sortVal.value;
		var today = new Date(checkinvalue[2],checkinvalue[1]-1,checkinvalue[0])
		var checkoutday = new Date(checkoutvalue[2],checkoutvalue[1]-1,checkoutvalue[0])
		var noofnights = Math.round((checkoutday - today) / one_day );
//		noofnights = Math.round(noofnights);
		var currdate = new Date();
		currdate.setDate(currdate.getDate()-1);
		var ar =  document.getElementById("guests").options;
		var noofadults = 0;
		for(var x=0;x<ar.length;x++){
		    if(ar[x].selected)
			noofadults = ar[x].value;
		}
		qString = BuildUrl(qString, "dummy", new Array("DM"));
		var accin = document.getElementById("acc-in").value;
		if((document.styleForm.afftCode.value=='RA'||document.styleForm.afftCode.value=='AFF135')){
			qString = qString.replace("#","");
		}else{
			qString += '#'+getSelectedFilters();
		}
		
		if(currdate < today && currdate < checkoutday)
		{
			if(noofnights >0)
			{
				document.styleForm.NoAd.value = document.getElementById("guests").options[document.getElementById("guests").selectedIndex].value;
				document.styleForm.noOfNights.value=noofnights;
				document.styleForm.checkInShowDate.value = checkinvalue[0]+"-"+monthnamearray[(Number(checkinvalue[1])-1)]+"-"+checkinvalue[2]+' ('+datesarray[today.getDay()]+')';
				document.styleForm.checkOutShowDate.value = checkoutvalue[0]+"-"+monthnamearray[(Number(checkoutvalue[1])-1)]+"-"+checkoutvalue[2]+' ('+datesarray[checkoutday.getDay()]+')';

				document.styleForm.checkInDate.value = checkinvalue[0]+"-"+montharray[(Number(checkinvalue[1])-1)]+"-"+checkinvalue[2]+" 00:00";
				document.styleForm.checkOutDate.value = checkoutvalue[0]+"-"+montharray[(Number(checkoutvalue[1])-1)]+"-"+checkoutvalue[2]+" 00:00";
				document.styleForm.noOfAdults.value = noofadults;

				document.styleForm.cmbCheckInYear.value = checkinvalue[2];
				document.styleForm.cmbCheckInMonth.value = Number(checkinvalue[1])-1;
				document.styleForm.cmbCheckInDate.value= checkinvalue[0];
				document.styleForm.cmbCheckOutYear.value= checkoutvalue[2];
				document.styleForm.cmbCheckOutMonth.value= Number(checkoutvalue[1])-1;
				document.styleForm.cmbCheckOutDate.value= checkoutvalue[0];
				
				document.styleForm.fromdate.value= checkinvalue[2]+"-"+checkinvalue[1]+"-"+checkinvalue[0];
				document.styleForm.todate.value= checkoutvalue[2]+"-"+checkoutvalue[1]+"-"+checkoutvalue[0]; 
				
				document.styleForm.noOfRooms.value = document.getElementById("rooms").options[document.getElementById("rooms").selectedIndex].value;
				document.styleForm.cmbNoOfRooms.value = document.getElementById("rooms").options[document.getElementById("rooms").selectedIndex].value;
				document.styleForm.cmbNoChi.value = document.getElementById("children").options[document.getElementById("children").selectedIndex].value;
				
				document.internalform.currentdomain.value = qString;	
				document.styleForm.action = (document.internalform.currentdomain.value).replace("ResevationSearchResults","ResevationSearch").split("?")[0];
				document.styleForm.submit();
			}else
			{
				alert('check out date needs to be greater than check in date');
				document.getElementById('check-in').focus();	
				document.getElementById('disable_back').style.display="none"; 
				document.getElementById('loading').style.display="none";			
			}
		}else{
				alert('Please check your dates - your requested check-in date has already passed!');
				document.getElementById('check-in').focus();	
				document.getElementById('disable_back').style.display="none"; 
				document.getElementById('loading').style.display="none";
		}
} 

function guestrooms(noofadults)
{
	if(Number(noofadults) == 1)
	return "GRT1,GRT2,GRT3,GRT4";
	else if(Number(noofadults) == 2)
	return "GRT2,GRT3,GRT4,GRT6";
	else if(Number(noofadults) == 3)
	return "GRT4,GRT5,GRT6,GRT8";
	else
	return "GRT2,GRT3,GRT4,GRT5,GRT6,GRT8";
}
			
function RetunToHome(urlStr) { 
			window.open(urlStr); 
}  

function ChangeLangstyle() { 
	if(document.getElementById("lang-selectli").getAttribute("class") == "active")
		document.getElementById("lang-selectli").setAttribute("class","");	
	else
		document.getElementById("lang-selectli").setAttribute("class","active");	
}  
 function ReplaceUrl(urlStr) { 
	return unescape(urlStr.replace(/\+/g, " ")) 
}
function set_to_center(e){ 
var divH = document.getElementById(e).offsetHeight;
		if(navigator.appName=='Netscape'){
		var screenH = window.innerHeight || document.body.offsetHeight;
		}else{
		var screenH = document.documentElement.clientHeight;
		}
	var scrollH = window.pageYOffset || document.body.scrollTop || document.documentElement.scrollTop;
	var scrollW = window.pageXOffset || document.body.scrollLeft || document.documentElement.scrollLeft;
	var divW = document.getElementById(e).offsetWidth;
	var screenW = document.documentElement.clientWidth;
	if(gup("afCd")=="RA"){
		var top = scrollH + (screenH-divH)/2;
		var left = scrollW + (screenW - divW)/2;
	}else{
		var top = scrollH + (screenH-136)/2;
		var left = scrollW + (screenW-300)/2;
		document.getElementById(e).style.left = left+'px';
	}
	document.getElementById(e).style.top = top+'px';
}

 function roompop(roomcode,bedcode,hotelcode,roomelement)
 {
	document.getElementById(roomelement+'img').style.display="block"; 
	args = "type=1&Msg="+bedcode+"&rTyp="+roomcode+"&hotCode="+hotelcode+"&AffCode=RA&languageCode="+document.styleForm.language.value+"&countryCode="+document.styleForm.country.value+"&enablenewlayout=Y"
    ajaxFunction('ACCentral.loadDiscription',args,roomelement); 
  }
 
 function ajaxFunction(Url,args,roomelementz) {
	var tinyTip;
	var dataTemp;
	//var dt = new Date();
	var lang = document.styleForm.language.value;
	
	$.getJSON(Url+'?'+args,
	  function(json) {
		var roombed = json.roomdesc;
		var beddesc = json.beddesc;
		document.getElementById(roomelementz+"_0").innerHTML = "";
		if(document.getElementById(roomelementz+"_anc").innerHTML == "More Details")
		{
			document.getElementById(roomelementz+"_anc").innerHTML = "";
			document.getElementById(roomelementz+"_anc").innerHTML = "Hide Details";	
		}else{
			document.getElementById(roomelementz+"_anc").innerHTML = "";
			document.getElementById(roomelementz+"_anc").innerHTML = "More Details";
		}
		
		document.getElementById(roomelementz+"_0").innerHTML = buildroominfo(roombed,beddesc);
		document.getElementById(roomelementz+'img').style.display="none";
  });
 }
 
 function buildroominfo(roomdesc,beddesc)
 {
	var returnvalue = "";
	if(roomdesc != "-" && roomdesc != null && roomdesc != "null")
	{
		returnvalue="<div>"+htmlDecode(roomdesc)+"</div>";
	}
	if(beddesc != "-" && beddesc != null && beddesc != "null")
	{
		if(returnvalue == "<div>-</div>"){
			returnvalue = "";
		}
	returnvalue+="<div>"+htmlDecode(beddesc)+"</div>";
	}
	return returnvalue;
 }
  
 function promocall(promocode,elementname)
 {
	 /*$("#"+elementname+"").fancybox({
		    ajax : {
		        type    : "POST",
		        url:"ACCentral.loadDiscription?type=2&promoCode="+promocode+"&affCode=RA"
		    }
		});*/
	 $.ajax({
			 url:"ACCentral.loadDiscription?type=2&promoCode="+promocode+"&affCode=RA",
			 dataType:'text',
			 type:'POST',
			 success: function (datareturn){
				 document.getElementById(elementname).innerHTML = "";
				 document.getElementById(elementname).innerHTML = datareturn;
				 set_to_centermultiple(elementname);
				 document.getElementById('loading').style.display='none';
			 }
		 	}); 
 }
 function set_to_centermultiple(e){
	  var divH = document.getElementById(e).offsetHeight;
	  if(navigator.appName=='Netscape'){
	   var screenH = window.innerHeight || document.body.offsetHeight;
	  }else{
	   var screenH = document.documentElement.clientHeight;
	  }
	  var scrollH = window.pageYOffset || document.body.scrollTop || document.documentElement.scrollTop;
	  var scrollW = window.pageXOffset || document.body.scrollLeft || document.documentElement.scrollLeft;  
	  var divW = document.getElementById(e).offsetWidth;  
	  var screenW = document.documentElement.clientWidth;
	  var top = scrollH + 100;
	  var left = scrollW + (screenW-730)/2;
	  document.getElementById(e).style.top = top+'px';  
      document.getElementById(e).style.left = left+'px'; 

	 $("#"+e).css('display','block');
	 $(".disablebg").css('display','block');	
	 }
 
  function paging(hotcount,resperpage,pcurrentpage){
 	currentpage=Number(pcurrentpage);
   var numpages = Math.ceil((hotcount/resperpage))
   var _html = ''  	
   var prevstartpage = (currentpage*resperpage)-((resperpage*2)-1); 
   var prevendpage =(currentpage*resperpage)-resperpage;	
   var nextstartpage = (currentpage*resperpage)+1;  
   var nextendpage =(currentpage*resperpage)+resperpage; 
   if(currentpage != 1){
    _html = '<li><a class="prev" href="javascript:nextprev('+prevstartpage+','+prevendpage+','+currentpage+');paging('+hotcount+','+resperpage+','+(currentpage-1)+');"><span>'+document.internalform.prev.value+'</span><em>&nbsp;</em></a></li>' 
   }
   var startitrtaorvalue=1;
   var enditrtaorvalue=resperpage;
   for($i=1; $i <= numpages; $i++ ){
   
    if(currentpage != $i){
     _html += '<li id="page'+$i+'" style="display:block"><a href="javascript:nextprev('+startitrtaorvalue+','+enditrtaorvalue+','+$i+');paging('+hotcount+','+resperpage+','+$i+');"><span>'+$i+'</span><em>&nbsp;</em></a></li>'
    }else{
     _html += '<li id="page'+$i+'" class="active" style="display:block"><a href="javascript:nextprev('+startitrtaorvalue+','+enditrtaorvalue+','+$i+');paging('+hotcount+','+resperpage+','+$i+');"><span>'+$i+'</span><em>&nbsp;</em></a></li>'
    }
	startitrtaorvalue+=resperpage;
	enditrtaorvalue+=resperpage;
   }
   
   if(currentpage != numpages){
    _html += '<li><a class="next" href="javascript:nextprev('+nextstartpage+','+nextendpage+','+currentpage+');paging('+hotcount+','+resperpage+','+(currentpage+1)+');"><span>'+document.internalform.next.value+'</span><em>&nbsp;</em></a></li>'
   }
   
   
   if (hotcount!=0){
    $('#paging_control').html(_html)
	var outend = currentpage+14;
	var cutoffvalue ='';
	var calculateLimit=numpages-outend
	
	if(16>calculateLimit){
	cutoffvalue=numpages-14
	}else{
	cutoffvalue=currentpage
	}
	
	for ($i=cutoffvalue; $i > 0; $i-- ){
		var pageid='';
		if(cutoffvalue==$i && cutoffvalue!=1){
			pageid=$i--;			
		}else{
			pageid=$i;
		}		
		if(cutoffvalue!=1){
			var elementId=document.getElementById("page"+$i)
			if(elementId){
			document.getElementById("page"+$i).style.display="none";
			}			
		}
	 }
	 	for ($i=outend; $i<=numpages; $i++ ){
			var elementId=document.getElementById("page"+$i)
			if(elementId){
			elementId.style.display="none";
			}
		}
		for ($i=outend; currentpage<=$i; $i-- ){
			var elementId=document.getElementById("page"+$i)
			if(elementId){
			elementId.style.display="block";
			}
		}
    }
	var deepindate=new Date();
	var deepoutdate=new Date();
	deepindate.setFullYear(2012,6,1);
	deepoutdate.setFullYear(2012,9,1);
	
	var ckInDate =	new Date(); 
	var ckOtDate =	new Date(); 
	var ckInDay	=	gup('InDt');
	var ckInMn	=	gup('InMn');
	var ckInYr	=	gup('InYr');
	var ckOtDay	=	gup('OtDt');
	var ckOtMn	=	gup('OtMn');
	var ckOtYr	=	gup('OtYr');
	
	ckInDate.setFullYear(ckInYr,ckInMn,ckInDay);
	ckOtDate.setFullYear(ckOtYr,ckOtMn,ckOtDay);
	
	var qString = document.internalform.currentdomain.value;
	var filterresults = getQueryStringValue("filterresults",qString);
	
	if( filterresults == 'nan' && hotcount<resperpage && deepindate<=ckInDate && deepoutdate>=ckOtDate && gup("afCd")=="RA" ){
		document.getElementById('deeplink').style.display="block";
	}	
	
	if(hotcount<resperpage){
		document.getElementById('paginmain').style.display="none";
	}else{
		document.getElementById('paginmain').style.display="block";
	}
		
  }
 
 function nextprev(start,end,current)
 {
  my_end = end;
  my_start  =start;
  document.internalform.start.value=start;
  document.internalform.end.value=end;
  window.location = 	'#'+getSelectedFilters();
  document.internalform.currentpage.value = current;
  try{
			jQuery("#disable_back").css("display", "block");
			jQuery("#loading").css("display", "block");
			set_to_center('loading');
	} catch (e) {
	}
		setTimeout("callDisplayResultsNav("+start+","+end+","+current+")",500);
 }
 
 function callDisplayResultsNav (start, end, current) {
 	var qStringz = document.internalform.currentdomain.value;
	if(qStringz.indexOf("start=") != -1 || qStringz.indexOf("end=") != -1){	
		qStringz = BuildUrl(qStringz, "start", new Array(start))
		qStringz = BuildUrl(qStringz, "end", new Array(end))		
	}
		qStringz += "&start="+start+"&end="+end;
		document.internalform.currentdomain.value = qStringz;
	displayResult(document.internalform.currentdomain.value,xslpath,'results_component','false',current,'false','true','false',orderbyselection,start,end);	
 }
 
  function callstudentdiscount(obj) {
  
	try{
			jQuery("#disable_back").css("display", "block");
			jQuery("#loading").css("display", "block");
			set_to_center('loading');
		} catch (e) {
		}
		
	xmlobject = null;
	var qStringz = document.internalform.currentdomain.value;
	if(obj.checked)
		qStringz = BuildUrl(qStringz, "Dcn1", new Array("Y"))
	else	
		qStringz = BuildUrl(qStringz, "Dcn1", new Array("N"))
 	
	
	qStringz = BuildUrl(qStringz, "start", new Array("1"))
	qStringz = BuildUrl(qStringz, "end", new Array("20"))	
	document.internalform.currentdomain.value	= qStringz;
	document.styleForm.selDiscount1.value="Y";
	displayResult(document.internalform.currentdomain.value,xslpath,'results_component','true',1,'false','true','false',orderbyselection,1,20);
 }
 
 function callDisplayResults (locationfalse,locationtrue,orderby,pagestart,pagend) {
	displayResult(document.internalform.currentdomain.value+'&resultgenerate=YES',xslpath,'results_component','true',1,locationfalse,'true',locationtrue,orderby,pagestart,pagend);		
 }
 function callDisplayResultsclear(locationfalse,locationtrue) {
 	displayResult(document.internalform.currentdomain.value+'&resultgenerate=YES',xslpath,'results_component','true',1,locationfalse,'true',locationtrue,orderbyselection,1,20);		
 }
	function check_checkbox(code,arg){
		
			try{
				var dv = "dv_";
				if(code.indexOf("STG")!=-1)
					dv = "dvh_";
				if(code.indexOf("LC")!=-1)
					dv = "dv_";
				if(code.indexOf("RP")!=-1)
					dv = "dvr_";
				if(code.indexOf("HTG")!=-1)
					dv = "dvs_";
				else if(code.indexOf("AC")!=-1)
					dv = "dvd_";
				else if(code.indexOf("HT")!=-1)
					dv = "dvl_";
				changeCssClass(dv+code,'check_box'+(arg?'_checked':''));
			}catch(e){}
		}
			function changeCssClass(id,className){

				var o = document.getElementById(id);
				o.setAttribute('class',className)
				o.setAttribute('className',className)
	}
var mxpx="0-300";
	
	function slider(value1,value2){
		filtersapplied = true;
	try{
		if(filterselected.length==0)
		{			
			filterselected[currentindex] ="slider"; 
		}else{
			if(filterselected.indexOf("slider") == -1){		
				filterselected.splice(currentindex,0,"slider"); 
			}
		}
				currentindex++;
		}catch(e)
		{
		}
	mxpx=value1+"-"+value2;
	 stPrice = value1;
	 edPrice = value2;
	 getSelectedFilters();
	try{
			jQuery("#disable_back").css("display", "block");
			jQuery("#loading").css("display", "block");
			set_to_center('loading');
		} catch (e) {
		}
	var qString = document.internalform.currentdomain.value; 
	qString = BuildUrl(qString, "mxP", new Array(value1+"-"+value2))
	qString = BuildUrl(qString, "filtered", new Array("Yes"))
	qString = qString.replace("#","");
	document.internalform.currentdomain.value = qString;
//	setTimeout('callDisplayResults()',500);
	setTimeout('callDisplayResults("true","true","'+orderbyselection+'",1,20)',500);
}
function xslloader()
{
	
	var url_styledoc = styledocz.split('?');
	$.ajax({
	url:styledocz,
	dataType:'xml',
	type:'POST',
	success: function (xsl){
		xslobject = xsl;
		}
	});	
	
}
  //sujeeve
 function getQueryStringValue(name,qString){
	var arrNameVal = qString.split("&") ;
	var ret_value = "nan";
	for (i in arrNameVal) { 
		 curName = arrNameVal[i].split("=")[0] ;
	 	 curName = ReplaceUrl(curName) ;
	  	 if (curName.toLowerCase() == name.toLowerCase()){
			ret_value = arrNameVal[i].split("=")[1];
			break;
		 }
	 }
		 return ret_value;
 }
 
 function htmlDecode(value,objecttype){
 if(objecttype == 'li')
  return $('<li/>').html(value).text();
 else
  return $('<div/>').html(value).text();
}
