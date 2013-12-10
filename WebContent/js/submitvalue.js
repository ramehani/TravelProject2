var firstcall='false';
var SaveStat='false';
var msg1,msg2,msg3,msg4,msg5,msg6,msg7,msg8="";
var resutzMsg1,resutzMsg2,resutzMsg3,resutzMsg4,resutzMsg5,resutzMsg6,resutzMsg7,resutzMsg8,resutzMsg9,resutzMsg10,resutzMsg11,resutzMsg12,resutzMsg13,resutzMsg14,resutzMsg15,resutzMsg16,resutzMsg17,resutzMsg18="";

function subIntHt(hotcode,hotName,hotAddress,roomTypeCode,roomType,bedTypeString,bedTypeCode,strrateCode,ratePlan,_standardPerDay,roomnames,__hotNetRate,
//		,tAddRateDay,
//				  _childPerDay,_totAdditional,_totChild,roomnames,tFreeNights,tCreditCcFee,tSalesTax,tRatePerDay,tRtType,strtRate
				  hotelSpecialCode
//				  ,
//		promotions
//		,pattern,rateStr,,,noRooms,imgName,rateStr2,rPlCd,strikethrou
		){
	initLoading(document.internalform.loadmsg.value);
	document.styleForm.hidHotCode.value=hotcode; 					document.styleForm.hotName.value=hotName;
	document.styleForm.hotAddress.value=hotAddress;					document.styleForm.rooTypeCode.value=roomTypeCode;
	document.styleForm.rooType.value=roomType;						document.styleForm.bedTypeString.value=bedTypeString;
	document.styleForm.bedTypeCode.value=bedTypeCode;				document.styleForm.rateCode.value=strrateCode;
	document.styleForm.ratePlanCode.value=ratePlan;					document.styleForm.standardRate.value=_standardPerDay;
//	document.styleForm.additionalRate.value=tAddRateDay;			document.styleForm.childRate.value=_childPerDay;
//	document.styleForm.totAdditional.value=_totAdditional;			document.styleForm.totChild.value=_totChild;
	document.styleForm.bedType.value=roomnames;						//document.styleForm.freeNights.value=tFreeNights; 
//	document.styleForm.tCreditCcFee.value =tCreditCcFee; 			document.styleForm.tRoomTax.value     =tSalesTax; 
//	document.styleForm.rateStr.value     =tRatePerDay; 				document.styleForm.rtType.value     =tRtType; 
//	document.styleForm.freeSell.value=strtRate; 					
	document.styleForm.hotNetRate.value=__hotNetRate; 
//	document.styleForm.hidAffHotelURL.value=fUrl; 
	
//	document.styleForm.reqRequestID.value=RequestId; 
/*	if(hotelSpecialCode==null)										
		document.styleForm.hotelSpecialCode.value="";
	else
		document.styleForm.hotelSpecialCode.value=hotelSpecialCode;

	var promotion="";
	try{
		promotion = promotions.substring(promotions.indexOf("\">",0)+2,promotions.indexOf("</a>",0));
	}catch(e){
	}	*/
//	document.styleForm.promotions.value=promotion;
	document.styleForm.submit();
}
var xmlobject = null;
function displayResult(source,styledoc,element,pagingfn,page,countneeded,backloaded,locationtrue,orderby,pagestart,pageend) {  
 //alert('source'+source);
 
 
		if(xmlobject == null)
		{
			if(isNaN(page)){
				page=1;
			}
			
			document.internalform.cmsSource.value = source;  
			source = BuildUrl(source, "clstatus", new Array(firstcall));
				if(SaveStat == "false" )
					source = BuildUrl(source, "saveStat", new Array("Y"));
				else	
					source = BuildUrl(source, "saveStat", new Array("N"));
				firstcall='true';
				SaveStat='true';
			var url_data =  source.split('?');
		   $.ajax({
			beforeSend: function(request) {
			request.setRequestHeader("Accept-Encoding", "gzip, deflate");
			},
			url:url_data[0],
			dataType:'json',
			data:url_data[1],
			type:'POST',
			success: function (json){
					xmlobject = json;
					dofilters(orderbyselection,pagestart,pageend,page,pagingfn);		
					callServer('TravelStay.ResevationFilterSearch?filtcodes='+(document.styleForm.filtcodes.value).replace("%","")+"&locationtrue="+locationtrue+"&sessionid="+xmlobject.sessionid);
			}
			});
		}else{
			dofilters(orderbyselection,pagestart,pageend,page,pagingfn);
		}
}




function getSortVal(x,y,way){

	if (way === '123' ) { 
			return ((x < y) ? -1 : ((x > y) ? 1 : 0)); 
		}
        if (way === '321') { 
			return ((x > y) ? -1 : ((x < y) ? 1 : 0)); 
		}
}

function sortJSON(data, key, way) {
  data.key = key;
  data.way = way;
    return data.sort(function(a, b) {
		var mKeys = [];
		var mWays = [];
		try{
			mKeys =data.key.split("@"); 
			mWays = data.way.split("@"); 
		}catch(e){
			mKeys ="hotelminrates".split("@"); 
			mWays = data.way.split("@"); 
		}
			for(var i=0;i<mKeys.length;i++){
				var key2  = mKeys[i];
				var x = a[key2]; 
				var y = b[key2];
				
				if(x!=y){
					return getSortVal(x,y,mWays[i]);
				}
			}
		return 0;
      
    });
}






	
 
 function transformfun(element,xml,countneeded,locationtrue,backloaded,pagingfn,page,sortby,pagestart,pageend)
 {
			var location = document.styleForm.selCity.value;
			var hotcount = xml.length;
			var qString = document.internalform.currentdomain.value;
			var filterresults = getQueryStringValue("filterresults",qString);
			var zeroresults = false;
			if(hotcount == 0 ){
				zeroresults = true;
			}
			if(!zeroresults)
			{
				document.getElementById(element).innerHTML = ""; 
				//alert('In Mozilla');
				var results_data = "";
				var sortedHotResultz ="";
	
				lablesLoads();	
				//results_data +=seachMsage();
			if(hotcount != 0)
			{
				//$.getJSON(document.internalform.currentdomain.value, function(data) {
				if(sortby=='TopPicks'){
					sortedHotResultz=sortJSON(xml,'toppick@hotelminrates@name','321@123@123')
				}else if(sortby=='hotelName'){
					sortedHotResultz=sortJSON(xml,'name@hotelminrates','123@123');
				}else if(sortby=='rank'){
					sortedHotResultz=sortJSON(xml,'rank@hotelminrates@name','123@123@123');
				}else if(sortby=='starrating'){
					sortedHotResultz=sortJSON(xml,'storder@hotelminrates@name','321@123@123');
				}else if(sortby=='distance'){
					sortedHotResultz=sortJSON(xml,'hotdistance@hotelminrates@name','123@123@123');
				}else if(sortby=='custrating'){
					sortedHotResultz=sortJSON(xml,'customerrating@hotelminrates@name','321@123@123');
				}else if(sortby=='price'){
					sortedHotResultz=sortJSON(xml,'hotelminrates@name','123@123');	
				}else{ 
					sortedHotResultz=sortJSON(xml,'rank@hotelminrates@name','123@123@123');
				}	
			
				//sortedHotResultz=xml.hotel;
				startnumber = 1;

				var results_data2 = "" ;
				var noofcount =0;
				//console.log('pagestart >>'+pagestart+"<<"+pageend)
				  $.each(sortedHotResultz, function(key, val) {
						if(pagestart <= startnumber &&  pageend >= startnumber){
							results_data += hoteltransform(sortedHotResultz[key],noofcount);	
							noofcount++;
						}
					startnumber++;
				  });
				  
			   }else{
				   results_data = "No Results";
			   }
			var newdiv = document.createElement("div");
			newdiv.innerHTML = results_data;
			var container = document.getElementById('results_component');
			container.appendChild(newdiv);
		   
		   
		    document.getElementById('disable_back').style.display="none"; 
		    document.getElementById('loading').style.display="none"; 
		  
		  if(Number(document.styleForm.noOfAdults.value) >= 3)
			{
				$('.slidepop').css('display','block');
			}
			if(isNaN(my_start)){
			 my_start = 1;
			 my_end = 20;
			}						
			resultsperpage=(my_end-my_start)+1;
			paging(xml.length,resultsperpage,page);																				
			var qString = document.internalform.currentdomain.value;
			qString = BuildUrl(qString, "altstatus", new Array(altervalue));
			qString = BuildUrl(qString, "clstatus", new Array(firstcall));
			document.internalform.currentdomain.value=qString;
			$('html, body').animate({scrollTop:0},0);
			initOpenClose();
			initOpenCloseLess();
			
		   }else{
			    document.getElementById(element).innerHTML = ""; 
			    results_data =  '<div class="main-block main-block-wide">'+
								'<div class="tl">'+
									'<div class="tr">'+
										'<div class="bl">'+
											'<div class="br">'+
												'<div class="main-area txt-area txt-area-alt">'+
													'<h3>'+msg1+'</h3>'+
													'<ul>'+
														'<li><a href="javascript:gobackfilters();">'+msg2+'</a></li>'+
														'<li><a href="javascript:clearFilters();">'+msg3+'</a></li>'+
													'</ul>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</div>';
			    var newdiv = document.createElement("div");
				newdiv.innerHTML = results_data;
				var container = document.getElementById('results_component');
				container.appendChild(newdiv);
			    document.getElementById('disable_back').style.display="none"; 
			    document.getElementById('loading').style.display="none"; 
		   }
 }
 
 
starcategorySelected = "-"
HotelTypeSelected = "-"
HotelFacilitySelected = "-"
HotelLocationSelected = "-"
RoomFilterSelected="-"

var orderbyselection = '-';
var filtersapplied=false;
var xmlobjectemp = null;
 function dofilters(orderbyselection,pagestart,pageend,cuurentpage,pagingfn)
 {
	   xmlobjectemp = new Array();
	   if(filtersapplied)
	   {
		   newreturnlist = [];
		   $.each(xmlobject.hotel, function(key, val) {
			   var lowestrate = 99999;
//			   xmlobject.hotel[key]
			   var templhotellist =  []; 
			   $.extend(true, templhotellist, xmlobject.hotel[key]);
			   var amenfilt = false,starfilter=false,ratefilter=false,hotelfiladd=false;
			   if(filterhotelname != "-")
			   {
				   if(templhotellist['hotelcode']==filterhotelname)
				   {
					   hotelfiladd=true;
				   }
			   }else{
				   hotelfiladd=true;
			   }
			   if(hoteltypecodefilt.length != 0)
			   {
				   var amenitykeys = templhotellist['amenitycode'].split(',');
				   for(x in hoteltypecodefilt)
				   {
					   for(y in amenitykeys)
					   {
						   if(hoteltypecodefilt[x] ==  amenitykeys[y])
						   {
							   amenfilt = true;
						   }
					   }
				   }
			   }else{
				   amenfilt = true; 
			   }
			   
			   
			   if(starfilt.length != 0)
			   {
				   for(starcat in starfilt)
				   {

					if(starfilt[starcat] == templhotellist['starcategory']){
							starfilter = true;
					}
				   }
			   }else{
				   starfilter = true; 
			   }
			   
//			   var roomslist = ;
			   var temproomlist = new Array();
			   $.each(templhotellist.roomtypes, function(key2, val2) {
				
				   if(rateplanfilt.length != 0)
				   {
					   for(ratepplns in rateplanfilt)
					   {
						   if(rateplanfilt[ratepplns] ==  templhotellist.roomtypes[key2]['rateplancode'])
						   {
							   if(stPrice<=Number(templhotellist.roomtypes[key2]['mintotal']) && edPrice>=Number(templhotellist.roomtypes[key2]['maxtotal'])){
								   temproomlist[temproomlist.length]=templhotellist.roomtypes[key2];
								   ratefilter = true;
								   if(lowestrate > Number(templhotellist.roomtypes[key2]['distotrate']))
								   {
									   lowestrate = Number(templhotellist.roomtypes[key2]['distotrate']);
								   }
							   }
							
						   }
					   }
				   }else{
					   if(stPrice<=Number(templhotellist.roomtypes[key2]['mintotal']) && edPrice>=Number(templhotellist.roomtypes[key2]['maxtotal'])){
						   temproomlist[temproomlist.length]=templhotellist.roomtypes[key2];
						   ratefilter = true;
						   if(lowestrate >= Number(templhotellist.roomtypes[key2]['distotrate']))
						   {
							   lowestrate = Number(templhotellist.roomtypes[key2]['distotrate']);
						   }
					   }
				   }
				   
			   });
			   
			   templhotellist.roomtypes = temproomlist;
			   templhotellist.hotelminrates = lowestrate;
			   
			   if(amenfilt && starfilter && ratefilter && hotelfiladd)
			   {
				   newreturnlist[newreturnlist.length] = templhotellist; 
			   }
					//results_data += hoteltransform(sortedHotResultz[key]);					
		  });
		   xmlobjectemp = newreturnlist;
	   }else{
		   xmlobjectemp = xmlobject.hotel;
	   }
	 
	 	/**
		* Hotel alternative logic top pick enable with new name
		*/
		try{
		
		if(document.styleForm.hotelCode.value !="%")
		{
			if (orderbyselection=="Location")
			{
				orderbyselection = "HTopPicks"
			}else if (orderbyselection=="-")
			{
				orderbyselection = "HTopPicks";
			}			
		}else{
			if(orderbyselection =="-"){
				if(document.styleForm.Utp.value == "L")
					orderbyselection = "distance";
				else
					orderbyselection = "Price";
			}
		}
		}catch(e)
		{
				if(orderbyselection =="-"){
					if(document.styleForm.Utp.value == "L")
						orderbyselection = "distance";
					else
						orderbyselection = "Price";
				}
		}
		document.internalform.sortVal.value = orderbyselection;
		transformfun('results_component',xmlobjectemp,'true','true','true',pagingfn,cuurentpage,orderbyselection,pagestart,pageend);
 }
 
 function createDomObject(parsexmlobject)
 {
	var xmlDoc;
	if (window.DOMParser)
	  {
	  parser=new DOMParser();
	  xmlDoc=parser.parseFromString(parsexmlobject,"text/xml");
	  }
	else // Internet Explorer
	  {
	  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	  xmlDoc.async=false;
	  xmlDoc.loadXML(parsexmlobject);
	  }
	return xmlDoc;	  
 }
 
 function redirect(){
			var location = document.styleForm.selCity.value;
			var hotcount = document.getElementById("avahotcount").value;
			var qString = document.internalform.currentdomain.value;
			var filterresults = getQueryStringValue("filterresults",qString);
				//alert(filterresults);
				
 }


function hoteltransform(hotel,noofcount)
{
	var defaultstyle = "padding_bottom_15 margin_top_5";
	if(noofcount==0)
		defaultstyle = " padding_bottom_15";
	var returnval = '';
	returnval = '<div class="grid_17 border_light_yellow padding_top_8 hotel_results_bg '+defaultstyle+'">'+
			  '<div class="hotel_details">'+
			  	'	<div class="heading grid_6">'+
			  			'<h2 class="item maroon_text" style="width: 250px;">'+hotel.name+'</h2>'+
			  		'</div>'+
				      '<div class="quick_menu grid_10 float_right">'+
				  		  '<ul class="item_sub_menu">';
							if(hotel.mapurl != "")
							returnval+=' <li><a title="Map" href="javascript:showMap(\''+hotel.hotelcode+'\');window.scrollTo(0,200);"> Map </a></li>';
							if(hotel.photourl != "")
							returnval+=' <li><a title="Image Gallery" href="'+hotel.photourl+'" target="_blank">Image Gallery</a></li>';
							if(hotel.websiteurl != "")
							returnval+= ' <li><a title="Hotel Information" href="'+hotel.websiteurl+'" class="fancybox font_bold" target="_blank">Hotel Info</a></li>';
							returnval+=' <li><a title="Hotel Policy" href="javascript:ldPg(\'1\',\''+hotel.hotelcode+'\')" class="fancybox font_bold">Hotel Policy </a></li>';
							returnval+=' <li><a title="Rates Calender" href="javascript:loadAvailability(\''+hotel.hotelcode+'\')" class="fancybox font_bold">Rates Calender</a></li>'+
					      '</ul>'+   
				      '</div>'+    
				      '<div class="clear"></div>'+
				      '<div class="visual grid_5">'+
				        '<ul class="photo-list2">'+
				          '<li>'+
				            '<div class="frame"><a class="fn url" href="javascript:fUrl(\''+hotel.websiteurl+'\',1,\''+hotel.hotelcode+'\')"><img width="64" height="66" alt="image description" src="'+hotel.imageurl+'"></a></div>'+
				          '</li>'+
				        '</ul>'+
				      '</div>'+   
				        
				      '<div class="txt grid_13"> <strong class="location">'+hotel.address+'</span></strong>'+
					        '<div class="review-info">'+
					          '<div>';
//					            '';
//					              '<div class="stars_1" title="1 Star"></div>'+
									if(hotel.starcategory == "ST8"){
					            		returnval+='<div class="rating stars"><div class="stars_2" title="2 Shells"></div></div>'+
							            '<strong class="type blue_text">2 Shells Accommodation</strong>';
					            	}else if(hotel.starcategory == "ST8_H"){
										returnval+='<div class="rating stars"><div class="stars_2_H" title="2.5 Shells"></div></div>'+
							            '<strong class="type blue_text">2.5 Shells Accommodation</strong>';
									}else if(hotel.starcategory == "ST7"){
										returnval+='<div class="rating stars"><div class="stars_3" title="3 Shells"></div></div>'+
							            '<strong class="type blue_text">3 Shells Accommodation</strong>';
									}else if(hotel.starcategory == "ST7_H"){
										returnval+='<div class="rating stars"><div class="stars_3_H" title="3.5 Shells"></div></div>'+
							            '<strong class="type blue_text">3.5 Shells Accommodation</strong>';
									}else if(hotel.starcategory == "ST9"){
										returnval+='<div class="rating stars"><div class="stars_4" title="4 Shells"></div></div>'+
							            '<strong class="type blue_text">4 Shells Accommodation</strong>';
									}else if(hotel.starcategory == "ST9_H"){
										returnval+='<div class="rating stars"><div class="stars_4_H" title="4.5 Shells"></div></div>'+
							            '<strong class="type blue_text">4.5 Shells Accommodation</strong>';
									}else if(hotel.starcategory == "ST10"){
										returnval+='<div class="rating stars"><div class="stars_5" title="5 Shells"></div></div>'+
							            '<strong class="type blue_text">5 Shells Accommodation</strong> ';
									}else if(hotel.starcategory == "ST10_H"){
										returnval+='<div class="rating stars"><div class="stars_5_H" title="5.5 Shells"></div></div>'+
							            '<strong class="type blue_text">5 Shells Accommodation</strong> ';
									}
					  returnval += '</div>'+
					          '<div class="clear"></div>'+
					        '</div>'+
					        '<p class="description">'+hotel.description+'<a title="More Information" href="javascript:fUrl(\''+hotel.websiteurl+'\',1,\''+hotel.hotelcode+'\')" class="fancybox"> More information </a></p>'+
//					      '</div>'+
					   '</div>'+
					   '<div class="clear"></div>'+
				       '<div class="grid_9">'+
				     //   '<p class="text_left maroon_text"><span class="font_bold"> Rooms </span> (prices are <span class="font_bold"> per person per night </span> & include taxes) </p>'+
					'<p></p>'+
				       ' </div>'+
				       
				       ' <div class="clear"></div>'+
//				       <!-- End Room details -->
					  ' <div class="clear"></div>'+
//					  <!-- End other hotel options-->
					  ' <div class="grid_17 border_light_yellow_top">'+
						  ' <div class="grid_3_new">'+
						  ' <div class="font_bold blue_text"> Room Type </div>'+
						  ' </div>'+ 
						  ' <div class="grid_4_new">'+
						  ' <div class="font_bold blue_text"> Bed Type </div>'+
						  ' </div>'+ 
//						  ' <div class="grid_5_new">'+
//						  ' <div class="font_bold text_center blue_text"> Daily Rate $ </div>';
////						  ' <div class="grid_mini"><div class="font_bold orange_text">Sun</div></div>'+
//					  	  for(dtvval in dateparsed)
//					  	  {
//					  		returnval+= ' <div class="grid_mini"><div class="font_bold orange_text">'+dateparsed[dtvval]+'</div></div>';
//					  	  }
//						  returnval+=' </div>'+ 
						  ' <div class="grid_6_new">'+
						  ' <div class="font_bold text_center blue_text" style="text-align:left !important;"> Total Rate </div>'+
						  ' </div><div class="clear"></div>';
					  /**
					   * room loop
					   */
					  $.each(hotel.roomtypes,function(key, val){
						  var roomkeyid = hotel.hotelcode+"_"+hotel.roomtypes[key]["roomcode"]+"_"+hotel.roomtypes[key]["bedcode"]+"_"+hotel.roomtypes[key]["rateplancode"];
						  returnval+=''+
						  "<div class=\"opndv grid_16 border_top_yellow\"> <div class=\"padding_bottom_15\"></div>"+
						  "<div class='title'> "+
						   "<img src='/html/ACCentral/Images/layout/small_loader.gif' height='16' width='16' align='absmiddle' style='float:left;display:none;' id=\'"+roomkeyid+"img\'> </img>"+
						   "</div>	"+
						  "<div class=\"grid_3_new\">" +
						  " <span class=\"hotel_select_bg\">&nbsp;&nbsp;</span>"+
						  " <span>"+hotel.roomtypes[key]["rooms"]+" x "+hotel.roomtypes[key]["roomtypename"]+"</span>"+
						  " </div>"+
						   " <div class=\"grid_4_new\">"+
						  " <span>"+hotel.roomtypes[key]["bedtypename"]+"</span>"+
						  " <br>"+
						  " <span>"+
						  " <a class=\"open-close\" id=\""+roomkeyid+"_anc\" onclick=\"javascript:roompop(\'"+hotel.roomtypes[key]["roomcode"]+"\',\'"+hotel.roomtypes[key]["bedcode"]+"\',\'"+hotel.hotelcode+"\',\'"+roomkeyid+"\')\">More Details</a>"+
						  "</span>"+
						  " </div>"+ 
						  " <div class=\"grid_5_new\">";
//						  " <span> Room Type </span>"+
/*//						  var splirates = (hotel.roomtypes[key]["disprates"]).split(",");
//						  for(rtvals in splirates)
//						  {
//							  returnval+="<div class=\"grid_mini\"><span>"+splirates[rtvals]+"</span></div>";
//						  }
*/						  returnval+=" </div>"+ 
						  		" <div class=\"grid_4_new\">"+
						  
//								  " <div class=\"grid_2_new\">"+
								  "<div class=\"font_bold orange_text text_center float_left\">"+hotel.roomtypes[key]["distotrate"]+"</div>"+
//								  "</div>"+
								 
							    
						  " </div>" ;
returnval+=" <div class=\"grid_4_new\">"+
//"<div class=\"grid_2_5_new\">"+
"<div> <a class=\"book_button\" " +
"href='javascript:subIntHt(\""+hotel.hotelcode+"\",\""+hotel.name+"\",\""+hotel.address+"\",\""+hotel.roomtypes[key]["roomcode"]+"\"" +
						   ",\""+hotel.roomtypes[key]["roomtypename"]+"\",\""+hotel.roomtypes[key]["bedtypename"]+"\",\""+hotel.roomtypes[key]["bedtypecode"]+"\",\""+hotel.roomtypes[key]["rateplanname"]+"\"" +
						   ",\""+hotel.roomtypes[key]["rateplancode"]+"\",\""+hotel.roomtypes[key]["distotrate"]+"\",\""+(hotel.roomtypes[key]["rooms"]).trim()+"\")'>Book</a></div>"+
//"</div>"+
" </div>" ;
						  if(hotel.roomtypes[key]["promotion"] != "" && hotel.roomtypes[key]["promotion"] != " ")
							  {
							  returnval+="<div  class=\"grid_17 promotion\">"+  
						                 "<a href=\"#\" class=\"font_bold\">"+hotel.roomtypes[key]["promotion"]+"</a>"+ 
						                 "</div>";  
							  }
						  
						  returnval+="<div class=\"clear\"></div>"+
						  "<div class=\"block\" >"+	                                       		 
							"<div class=\"roomdesc\">"+
							    "<div id=\""+roomkeyid+"_0\">"+
								"</div>"+
						    "</div>"+
					    "</div>"+
						  "</div>";
					  });
					  
					  returnval+=' </div>'+ 
				'</div>'+
			'</div>';		
			
	return returnval;
}


function seachMsage()
{

var returnval2 = '';

if(xmlobject.hotelsavailablility =="NO"){
		returnval2 = '<div class="main-block main-block-wide">'+
			'<div class="tl">'+
				'<div class="tr">'+
					'<div class="bl">'+
						'<div class="br">'+
							'<div class="main-area txt-area txt-area-alt">'+
								'<h3>'+msg1+'</h3>'+
								'<ul>'+
									'<li><a href="javascript:gobackfilters();">'+msg2+'</a></li>'+
									'<li><a href="javascript:clearFilters();">'+msg3+'</a></li>'+
								'</ul>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>'+
		'</div>';
}else{
	if(xmlobject.alternativehotel=="YES"){
		if(xmlobject.altaccomo=="YES"){
			returnval2 = '<div class="main-block main-block-wide">'+
					'<div class="tl">'+
						'<div class="tr">'+
							'<div class="bl">'+
								'<div class="br">'+
									'<div class="main-area txt-area" style="background: none repeat scroll 0 0 #E7F1FA; height: auto; color:#EC7E24;">'+
										'<p align="center">'+msg4+'</p>'+
									'</div>'+
								'</div>'+
							 '</div>'+       
						 '</div>'+
					 '</div>'+
			'</div>';
		
		}else{
			returnval2 = '<div class="main-block main-block-wide">'+
				'<div class="tl">'+
					'<div class="tr">'+
						'<div class="bl">'+
							'<div class="br">'+
								'<div class="main-area txt-area" style="background: none repeat scroll 0 0 #DAEAF9; height: auto; text-align: left;">'+

									'<p align="left" style="color: #000099; display: inline; font: 18px/22px Arial,Helvetica,sans-serif;"><h2>'+msg6+'</h2></p>'+
									'<br/><br/>'+
									'<p align="left" style="font-size: 16px; color: #000099;">'+msg7+'</p>'+
									
									
								'</div>'+
							'</div>'+
						 '</div>'+    
					 '</div>'+ 
				 '</div>'+
			'</div>';
		}
	}else if(xmlobject.alternativehotel=="YESA"){
			returnval2 = '<div class="main-block main-block-wide">'+
				'<div class="tl">'+
					'<div class="tr">'+
						'<div class="bl">'+
							'<div class="br">'+
								'<div class="main-area txt-area" style="background: none repeat scroll 0 0 #DAEAF9; height: auto; text-align: left;">'+
									'<p align="left" style="color: #000099; display: inline; font: 18px/22px Arial,Helvetica,sans-serif;">'+
									''+msg8+''+
									'</p>'+																				
								'</div>'+
							'</div>'+
						 '</div>'+   
					 '</div>'+
				 '</div>'+
			'</div>';
	}	
}
return returnval2;
}

function lablesLoads(){

var language=document.styleForm.language.value;

if (language == 'es'){ 
	msg1="Lo sentimos, no hay resultados para esta combinaci&#243;n espec&#237;fica.";
	msg2="Hacer  clic aqui para retroceder";
	msg3="Hacer clic aqu&#237; para borrar filtros";
	msg4="&#161;Lo sentimos! Este alojamiento ya est&#225; completo.<br/><br/>&#161;En la siguiente secci&#243;n encontrar&#225; hoteles cercanos, otras opciones y ofertas especiales!";
	msg6="&#161;Lo sentimos! Ya no quedan habitaciones disponibles en <span id='htname'/>.";
	msg7="En la siguiente secci&#243;n encontrar&#225; hoteles cercanos y ofertas especiales";
	msg8="<h2>Lo sentimos, el hotel <span id='htname'></span> no corresponde con ninguno de sus criterios de selecci&#243;n. A continuaci&#243;n le mostramos otros hoteles disponibles que se adaptan a sus criterios</h2>";
    resutzMsg1="Vendiendo R&#225;pido";
	resutzMsg2="La Mejor Selecci&#243;n";
	resutzMsg3="Mejor Precio";
	resutzMsg4="Ofert&#243;n anti-crisis";
	resutzMsg45="Nuevo";
	resutzMsg5="Ver Mapa";
	resutzMsg6="1 Star";
	resutzMsg7="2 Stars";
	resutzMsg8="3 Stars";
	resutzMsg9="4 Stars";
	resutzMsg10="5 Stars";
	resutzMsg101="m&#225;s informaci&#243;n";
	resutzMsg11="<p><strong>habitaciones</strong> (los precios son <strong>por persona, por noche</strong> y los impuestos est&#225;n inclu&#237;dos)</p>";
	resutzMsg12="Total Ahorrado:";
	resutzMsg130="Oferta de &#250;ltimo minuto: Ahorrar&#225;";
	resutzMsg13="Reservar";
	resutzMsg122="Las instalaciones incluyen";
	resutzMsg14="Menos detalles";
	resutzMsg15="Visualizar tipos de habitaciones m&#250;ltiples (e.j. 1 doble, 1 doble con dos camas)";
	resutzMsg16="Ver combinaciones de habitaciones";
	resutzMsg16="Combinaciones de habitaciones";
	resutzMsg17="Haga su reserva en s&#243;lo 1 minuto. S&#243;lo tiene que hacer clic en 'Reservar habitaci&#243;n'. <br/>A continuaci&#243;n, rellene la p&#225;gina de reserva para obtener una confirmaci&#243;n al instante";
	resutzMsg18="Tambi&#233;n dispone de las siguientes alternativas";
}else if(language == 'it'){
	msg1="Siamo spiacenti, ma questa combinazione non ha prodotto alcun risultato.";
	msg2="Fare clic qui per tornare indietro";
	msg3="Fare clic qui per eliminare tutti i filtri.";
	msg4="Siamo spiacenti, ma non vi sono pi&#249; camere disponibili per questa ricerca<br/><br/>Di seguito troverete altri hotel nelle vicinanze, tante possibilit&#224; e offerte speciali!";
	msg6="Ci dispiace! <span id='htname'/> &#232; gi&#224; tutto completo!";
	msg7="Di seguito troverete hotel nelle vicinanze e offerte speciali";
	msg8="<h2>Ci dispiace, ma <span id='htname'></span>  non &#232; compatibile con i tuoi criteri di selezione. Trovi di seguito altri hotel disponibili in linea con i tuoi criteri</h2>";
    resutzMsg1="Da approfittare subito";
	resutzMsg2="Migliore scelta";
	resutzMsg3="Migliore offerta";
	resutzMsg4="Offerta in ribasso";
	resutzMsg45="Nuovo";
	resutzMsg5="Vista Mappa";
	resutzMsg6="1 Star";
	resutzMsg7="2 Stars";
	resutzMsg8="3 Stars";
	resutzMsg9="4 Stars";
	resutzMsg10="5 Stars";
	resutzMsg101="Ulteriori informazioni";
	resutzMsg11="<p><strong>Camere</strong> (le tariffe sono <strong>per persona per notte</strong> &#38; comprendono le tasse)</p>";
	resutzMsg12="Risparmio totale di:";
	resutzMsg130="Offerta dell ultimo minuto : Risparmi";
	resutzMsg13="Prenota";
	resutzMsg122="I servizi comprendono";
	resutzMsg14="Meno informazioni";
	resutzMsg15="Mostra diversi tipi di camere (ad es., una camera doppia e una camera con letto matrimoniale)";
	resutzMsg16="Vedi le combinazioni delle camere";
	resutzMsg16="Combinazioni delle camere";
	resutzMsg17="Solo 1 minuto per prenotare! Basta fare clic su 'Prenota'. <br/>Poi completa la pagina di prenotazione per la conferma immediata";
	resutzMsg18="Sono inoltre disponibili le alternative seguenti";
}else if(language == 'de'){
	msg1="Diese Kombination hat keine Suchergebnisse geliefert.";
	msg2="Anklicken um zur&#252;ck zu gehen";
	msg3="Hier klicken zum Leeren s &#228;mtlicher Filter.";
	msg4="Leider sind die Zimmer nicht mehr f&#252;r diese Suche zur Verf&#252;gung<br/><br/>Klicken Sie weiter unten f&#252;r alternative Hotels in der N&#228;he, sonstige Optionen und Sonderangebote!";
	msg6="Leider ist <span id='htname'></span> bereits ausgebucht!";
	msg7="Weiter unten finden Sie nahegelegene Hotels und Sonderangebote.";
	msg8="<h2>Leider ist das <span id='htname'></span> nicht in Ihrer Filterauswahl - andere verf&#252;gbare Hotels, die Ihren Suchkriterien entsprechen, sehen Sie unten</h2>";
    resutzMsg1="Schnell zugreifen";
	resutzMsg2="Top-Treffer";
	resutzMsg3="Bester Preis";
	resutzMsg4="Krisen-angebot";
	resutzMsg45="Neu";
	resutzMsg5="Stadtplan Anschauen";
	resutzMsg6="1 Star";
	resutzMsg7="2 Stars";
	resutzMsg8="3 Stars";
	resutzMsg9="4 Stars";
	resutzMsg10="5 Stars";
	resutzMsg101="Weitere Informationen";
	resutzMsg11="<p><strong>Zimmer</strong> (Preise gelten <strong>pro Person, pro Nacht</strong> und einschlie&#223;lich Steuern)</p>";
	resutzMsg12="Insgesamt sparen Sie:";
	resutzMsg130="Last-Minute-Angebot: Sparen Sie";
	resutzMsg13="Buchen";
	resutzMsg122="Die Freizeitanlagen umfassen auch";
	resutzMsg14="Weniger Details";
	resutzMsg15="Mehrere Zimmertypen anzeigen (z.B. 1 Doppel- und 1 Zweibettzimmer)";
	resutzMsg16="Zimmer-Kombinationen anzeigen";
	resutzMsg16="Zimmer-Kombinationen";
	resutzMsg17="Die Buchung dauert nur eine Minute! Einfach auf &#8222;Buchen&#8220; klicken. <br/>Dann f&#252;llen Sie bitte die Buchungsseite aus, um eine sofortige Best&#228;tigung zu erhalten";
	resutzMsg18="Dar&#252;ber hinaus sind auch die folgenden Alternativen verf&#252;gbar";
}else if(language == 'pl'){
	msg1="Przykro nam, ale nie ma &#380;adnych rezultat&#243;w w tym zestawieniu.";
	msg2="Kliknij tu by sie cofnac";
	msg3="Kliknij tu by wyczyscic wszystkie filtry.";
	msg4="Przepraszamy! Wszystkie miejsca noclegowe zosta&#322;y zarezerwowane.<br/><br/>Sprawd&#378; poni&#380;ej alternatywne hotele w pobli&#380;u, inne opcje i specjalne oferty!";
	msg6="Przepraszamy. Brak wolnych <span id='htname'/>!";
	msg7="Patrz poni&#380;ej na hotele w pobli&#380;u i specjalne oferty";
	msg8="<h2>Przepraszamy <span id='htname'></span> nie znajduje si&#281; w kryteriach Pa&#324;stwa selekcji. Hotele spe&#322;niaj&#261;ce te kryteria s&#261; na li&#347;cie poni&#380;ej</h2>";
    resutzMsg1="Szybko ubywa miejsc";
	resutzMsg2="Najlepzy wyb&#243;r";
	resutzMsg3="Najlepsza oferta";
	resutzMsg4="Pogromca recesji";
	resutzMsg45="Nowo&#347;&#263;";
	resutzMsg5="Zobacz Map&#281;";
	resutzMsg6="1 Star";
	resutzMsg7="2 Stars";
	resutzMsg8="3 Stars";
	resutzMsg9="4 Stars";
	resutzMsg10="5 Stars";
	resutzMsg101="Wi&#281;cej informacji";
	resutzMsg11="<p><strong>kombinacji pokoju</strong> (podane ceny zawieraj&#261; podatki i <strong>s&#261; za osoba za dob&#281;</strong>) </p>";
	resutzMsg12="Calkowita zaoszczedzona kwota:";
	resutzMsg130="Oferta \"Last Minute\": Oszcz&#281;dzasz";
	resutzMsg13="Rezerwuj";
	resutzMsg122="Opcje zawarte w ofercie";
	resutzMsg14="Mniej danych";
	resutzMsg15="Poka&#380; r&#243;&#380;ne rodzaje pokoi - np. dwuosobowy &#322;&#243;zko podw&#243;jne lub dwa pojedy&#324;cze";
	resutzMsg16="Zobacz warianty pokoi";
	resutzMsg16="Zobacz warianty pokoi";
	resutzMsg17="Rezerwacja zajmuje tylko minut&#281;! Wystarczy klikn&#261;&#263; w 'Rezerwuj Pok&#243;j'. <br/>A nast&#281;nie wypelni&#263; wymagane pola rezerwacji by otrzyma&#263; natychmiastowe potwierdzenie";
	resutzMsg18="Dost&#281;pne s&#261; tak&#380;e nast&#281;puj&#261;ce alternatywy";
}else if(language == 'fr'){
	msg1="D&#233;sol&#233;, il n&#39;y a pas de r&#233;sultats pour cette combinaison sp&#233;cifique.";
	msg2="Cliquez ici pour revenir en arri&#232;re";
	msg3="Cliquez ici pour supprimer tous les filtres.";
	msg4="D&#233;sol&#233;, les chambres ne sont plus disponibles pour cette recherche<br/><br/>Consultez la section ci-dessous pour d'autres h&#244;tels &#224; proximit&#233;, d'autres options et des offres sp&#233;ciales !";
	msg6="D&#233;sol&#233; ! <span id='htname'/> affiche complet";
	msg7="Consultez la section ci-dessous pour des h&#244;tels &#224; proximit&#233; et des offres sp&#233;ciales";
	msg8="<h2>Toutes nos excuses, <span id='htname'></span> ne figure pas dans votre s&#233;lection de filtres ; veuillez trouver ci-dessous d'autres h&#244;tels disponibles qui correspondent &#224; vos filtres</h2>";
    resutzMsg1="Affaire &#224; saisir";
	resutzMsg2="Meilleur choix";
	resutzMsg3="Meilleure offre";
	resutzMsg4="Anti-crise";
	resutzMsg45="Nouveau";
	resutzMsg5="Voir Carte";
	resutzMsg6="1 Star";
	resutzMsg7="2 Stars";
	resutzMsg8="3 Stars";
	resutzMsg9="4 Stars";
	resutzMsg10="5 Stars";
	resutzMsg101="Plus d&#39;informations";
	resutzMsg11="<p><strong>Chambres</strong>  (les prix s'entendant <strong>par personne, par nuit,</strong> TTC)</p>";
	resutzMsg12="Total &#233;conomis&#233; :";
	resutzMsg130="Offre de derni&#232;re minute : &#233;conomisez";
	resutzMsg13="R&#233;server";
	resutzMsg122="Les installations incluent";
	resutzMsg14="Moins de d&#233;tails";
	resutzMsg15="Afficher plusieurs types de chambres (par ex., une chambre avec 2 lits individuels et une chambre &#224; un lit pour 2 personnes)";
	resutzMsg16="Voir les combinaisons de chambres";
	resutzMsg16="Combinaisons de chambres";
	resutzMsg17="Il suffit d'1 minute pour r&#233;server ! Cliquez simplement sur 'R&#233;server'. <br/>Compl&#233;tez ensuite la page de r&#233;servation pour une confirmation instantan&#233;e.";
	resutzMsg18="Les alternatives suivantes sont &#233;galement disponibles";
}else {
	msg1="Sorry there are no results for this particular combination.";
	msg2="Click here to go back";
	msg3="Click here to clear all filters";
	msg4="<b>Sorry, rooms are no longer available for this search<br/><br/>Check below for alternative nearby hotels, other options and special offers!</b>";
	msg6="Sorry! <span id='htname'></span> has already sold out";
	msg7="See below for nearby hotels and special offers";
	msg8="<h2>Sorry, <span id='htname'></span> is not in your filter selection - other available hotels that fit your filters are shown below</h2>";
    resutzMsg1="Selling FAST";
	resutzMsg2="Top Pick";
	resutzMsg3="Best Value";
	resutzMsg4="Recession Buster";
	resutzMsg45="Nuevo";
	resutzMsg5="View map";
	resutzMsg6="1 Star";
	resutzMsg7="2 Star";
	resutzMsg8="3 Star";
	resutzMsg9="4 Star";
	resutzMsg10="5 Star";
	resutzMsg101="More information";
	resutzMsg11="<p><strong>Rooms</strong> (prices are <strong>per person per night</strong> &amp; include taxes)</p>";
	resutzMsg12="Total Saving:";
	resutzMsg130="Last Minute Deal: You Save";
	resutzMsg13="Book";
	resutzMsg122="Facilities include";
	resutzMsg14="Less detail";
	resutzMsg15="Display multiple room types (e.g. 1 double and 1 twin)";
	resutzMsg16="View Room Combinations";
	resutzMsg17="It only  takes1 minute to book! Simply click on \'Book room\'.";
	resutzMsg17="It only  takes1 minute to book! Simply click on \'Book room\'. <br/>Then complete the book page for instant confirmation.";
	resutzMsg18="The following alternatives are also available";
}

}
