 
 //way to call the function from the page 
 //deepText(document.body, 'GBP',$convert); 
var firstText=new Array();  
var arrayposition=1; 
 		// currency xchange rate array  
 		var curXRates = {  
 'AED'      :   '5.5859910541', 
 'AFN'      :   '81.7420492248', 
 'ALL'      :   '164.4469288605', 
 'AMD'      :   '634.4847662595', 
 'ANG'      :   '2.7222030764', 
 'AOA'      :   '146.2535617042', 
 'ARS'      :   '8.0373353591', 
 'AUD'      :   '1.5805705312', 
 'AWG'      :   '2.7222030868', 
 'AZN'      :   '1.1932064959', 
 'BAM'      :   '2.288725201', 
 'BBD'      :   '3.0415676947', 
 'BDT'      :   '118.3576611891', 
 'BGN'      :   '2.2916383282', 
 'BHD'      :   '.5731824225', 
 'BIF'      :   '2343.5249370359', 
 'BMD'      :   '1.5207838474', 
 'BND'      :   '1.9189238984', 
 'BOB'      :   '10.5080645673', 
 'BRL'      :   '3.2529446324', 
 'BSD'      :   '1.5207838474', 
 'BTN'      :   '86.0383550644', 
 'BWP'      :   '13.2819548744', 
 'BYR'      :   '13207.3255792531', 
 'BZD'      :   '3.0716822213', 
 'CAD'      :   '1.5753727463', 
 'CDF'      :   '1396.3162213511', 
 'CHF'      :   '1.4555463483', 
 'CLP'      :   '761.0730849099', 
 'CNY'      :   '9.3315524253', 
 'COP'      :   '2900.8752304856', 
 'CRC'      :   '762.6723139705', 
 'CUC'      :   '1.5207838474', 
 'CUP'      :   '40.3007719552', 
 'CVE'      :   '128.7602313199', 
 'CZK'      :   '30.0614350423', 
 'DJF'      :   '273.2825357026', 
 'DKK'      :   '8.7244254188', 
 'DOP'      :   '62.6635612323', 
 'DZD'      :   '121.5942259226', 
 'EEK'      :   '18.3098016081', 
 'EGP'      :   '10.6238901811', 
 'ERN'      :   '17.1240216311', 
 'ETB'      :   '28.3866290868', 
 'EUR'      :   '1.1702066136', 
 'FJD'      :   '2.7991341709', 
 'FKP'      :   '1', 
 'GBP'      :   '1', 
 'GEL'      :   '2.4967213313', 
 'GGP'      :   '1', 
 'GHS'      :   '3.0374427867', 
 'GIP'      :   '1', 
 'GMD'      :   '51.3562122665', 
 'GNF'      :   '10686.416142941', 
 'GTQ'      :   '11.8552700569', 
 'GYD'      :   '311.682663542', 
 'HKD'      :   '11.8059915071', 
 'HNL'      :   '30.7958704007', 
 'HRK'      :   '8.8376981131', 
 'HTG'      :   '64.4505732587', 
 'HUF'      :   '347.4745193322', 
 'IDR'      :   '14898.7391566488', 
 'ILS'      :   '5.6138348344', 
 'IMP'      :   '1', 
 'INR'      :   '86.0383550644', 
 'IQD'      :   '1742.8189862047', 
 'IRR'      :   '18678.2589948049', 
 'ISK'      :   '186.8739529964', 
 'JEP'      :   '1', 
 'JMD'      :   '150.0973992598', 
 'JOD'      :   '1.0782351723', 
 'JPY'      :   '152.880665517', 
 'KES'      :   '129.5706999279', 
 'KGS'      :   '73.3474133004', 
 'KHR'      :   '6060.0664984984', 
 'KMF'      :   '575.7039147126', 
 'KPW'      :   '200.2895234574', 
 'KRW'      :   '1717.7495787506', 
 'KWD'      :   '.4352480042', 
 'KYD'      :   '1.2470429541', 
 'KZT'      :   '230.2389992434', 
 'LAK'      :   '11687.5487808273', 
 'LBP'      :   '2287.2369489538', 
 'LKR'      :   '192.4170878929', 
 'LRD'      :   '113.2983020226', 
 'LSL'      :   '15.2909122699', 
 'LTL'      :   '4.0404893953', 
 'LVL'      :   '.8206803606', 
 'LYD'      :   '1.9382390323', 
 'MAD'      :   '13.0216265494', 
 'MDL'      :   '19.0018870363', 
 'MGA'      :   '3350.2574112037', 
 'MKD'      :   '72.9894591982', 
 'MMK'      :   '1428.7708233905', 
 'MNT'      :   '2186.1342167181', 
 'MOP'      :   '12.1601712523', 
 'MRO'      :   '397.6716421556', 
 'MUR'      :   '47.6764490114', 
 'MVR'      :   '23.4200730288', 
 'MWK'      :   '501.3975344703', 
 'MXN'      :   '19.4826103504', 
 'MYR'      :   '4.7129049762', 
 'MZN'      :   '45.0606210051', 
 'NAD'      :   '15.2909122699', 
 'NGN'      :   '240.5877256437', 
 'NIO'      :   '38.1944561249', 
 'NOK'      :   '8.9289504075', 
 'NPR'      :   '137.5506931979', 
 'NZD'      :   '1.906617966', 
 'OMR'      :   '.5849694959', 
 'PAB'      :   '1.5207838474', 
 'PEN'      :   '4.1608506725', 
 'PGK'      :   '3.4426329117', 
 'PHP'      :   '64.3289239494', 
 'PKR'      :   '149.8271502837', 
 'PLN'      :   '5.0117030784', 
 'PYG'      :   '6477.8083762309', 
 'QAR'      :   '5.5379317665', 
 'RON'      :   '5.1531877577', 
 'RSD'      :   '132.0195719765', 
 'RUB'      :   '48.5745477095', 
 'RWF'      :   '974.7739608228', 
 'SAR'      :   '5.7037377861', 
 'SBD'      :   '11.0925156048', 
 'SCR'      :   '17.9312132035', 
 'SDG'      :   '6.6800344213', 
 'SEK'      :   '10.076491432', 
 'SGD'      :   '1.9189238984', 
 'SHP'      :   '1', 
 'SLL'      :   '6581.7703960959', 
 'SOS'      :   '2202.056392345', 
 'SPL'      :   '.2534639746', 
 'SRD'      :   '4.9799979499', 
 'STD'      :   '28659.1716036128', 
 'SVC'      :   '13.3068586644', 
 'SYP'      :   '147.8651160644', 
 'SZL'      :   '15.2909122699', 
 'THB'      :   '46.196348307', 
 'TJS'      :   '7.2326903034', 
 'TMM'      :   '21671.1698249424', 
 'TMT'      :   '4.334233965', 
 'TND'      :   '2.499408007', 
 'TOP'      :   '2.6480652052', 
 'TRY'      :   '2.8705748656', 
 'TTD'      :   '9.7480100993', 
 'TVD'      :   '1.5805705312', 
 'TWD'      :   '45.5774770789', 
 'TZS'      :   '2481.1300409471', 
 'UAH'      :   '12.4017005278', 
 'UGX'      :   '3938.7338142969', 
 'USD'      :   '1.5207838474', 
 'UYU'      :   '30.5675723398', 
 'UZS'      :   '3165.6617657271', 
 'VEB'      :   '9562.2305979368', 
 'VEF'      :   '9.5622305979', 
 'VND'      :   '31929.0540908989', 
 'VUV'      :   '142.9496218805', 
 'WST'      :   '3.4840408875', 
 'XAF'      :   '767.6052196167', 
 'XAG'      :   '.0677496328', 
 'XAU'      :   '.0010905363', 
 'XCD'      :   '4.106116392', 
 'XDR'      :   '1.0148950967', 
 'XOF'      :   '767.6052196167', 
 'XPD'      :   '.0020304113', 
 'XPF'      :   '139.642793982', 
 'XPT'      :   '.0010390111', 
 'YER'      :   '326.367378961', 
 'ZAR'      :   '15.2909122699', 
 'ZMK'      :   '8105.7777904318', 
 'ZWD'      :   '550.3716743612', 
 'LAST'      :   '1' 
 }; 

 		// currency code according to the country code 

	   	var  countryCurrency = {	     
	   'AF' : 'AFN',   
	   'AL' : 'ALL',   
	   'DZ' : 'DZD',   
	   'AS' : 'USD',   
	   'AD' : 'EUR',   
	   'AO' : 'AOA',   
	   'AI' : 'XCD',   
	   'AG' : 'XCD',   
	   'AR' : 'ARS',   
	   'AM' : 'AMD',   
	   'AW' : 'AWG',   
	   'AU' : 'AUD',   
	   'AT' : 'EUR',   
	   'AZ' : 'AZM',   
	   'BS' : 'BSD',   
	   'BH' : 'BHD',   
	   'BD' : 'BDT',   
	   'BB' : 'BBD',   
	   'BY' : 'BYR',   
	   'BE' : 'EUR',   
	   'BZ' : 'BZD',   
	   'BJ' : 'XOF',   
	   'BM' : 'BMD',   
	   'BT' : 'BTN',   
	   'BT' : 'INR',   
	   'BO' : 'BOV',   
	   'BA' : 'BAM',   
	   'BW' : 'BWP',   
	   'BV' : 'NOK',   
	   'BR' : 'BRL',   
	   'IO' : 'USD',   
	   'BN' : 'BND',   
	   'BG' : 'BGN',   
	   'BF' : 'XOF',   
	   'BI' : 'BIF',   
	   'KH' : 'KHR',   
	   'CM' : 'XAF',   
	   'CA' : 'CAD',   
	   'CV' : 'CVE',   
	   'KY' : 'KYD',   
	   'CF' : 'XAF',   
	   'TD' : 'XAF',   
	   'CL' : 'CLF',   
	   'CL' : 'CLP',   
	   'CN' : 'CNY',   
	   'CX' : 'AUD',   
	   'CC' : 'AUD',   
	   'CO' : 'COP',   
	   'KM' : 'KMF',   
	   'CG' : 'XAF',   
	   'CD' : 'CDF',   
	   'CK' : 'NZD',   
	   'CR' : 'CRC',   
	   'CI' : 'XOF',   
	   'HR' : 'HRK',   
	   'CU' : 'CUP',   
	   'CY' : 'CYP',   
	   'CZ' : 'CZK',   
	   'DK' : 'DKK',   
	   'DJ' : 'DJF',   
	   'DM' : 'XCD',   
	   'DO' : 'DOP',   
	   'TL' : 'USD',   
	   'EC' : 'ECS',   
	   'EG' : 'EGP',   
	   'SV' : 'USD',   
	   'GQ' : 'XAF',   
	   'ER' : 'ERN',   
	   'EE' : 'EEK',   
	   'ET' : 'ETB',   
	   'FO' : 'DKK',   
	   'FK' : 'FKP',   
	   'FJ' : 'FJD',   
	   'FI' : 'EUR',   
	   'FR' : 'EUR',   
	   'GF' : 'EUR',   
	   'PF' : 'XPF',   
	   'TF' : 'EUR',   
	   'GA' : 'XAF',   
	   'GM' : 'GMD',   
	   'GE' : 'GEL',   
	   'DE' : 'EUR',   
	   'GH' : 'GHC',   
	   'GI' : 'GIP',   
	   'GR' : 'EUR',   
	   'GL' : 'DKK',   
	   'GD' : 'XCD',   
	   'GP' : 'EUR',   
	   'GU' : 'USD',   
	   'GT' : 'GTQ',   
	   'GN' : 'GNF',   
	   'GW' : 'GWP',   
	   'GY' : 'GYD',   
	   'HT' : 'USD',   
	   'HM' : 'AUD',   
	   'VA' : 'EUR',   
	   'HN' : 'HNL',   
	   'HK' : 'HKD',   
	   'HU' : 'HUF',   
	   'IS' : 'ISK',   
	   'IN' : 'INR',   
	   'ID' : 'IDR',   
	   'IR' : 'IRR',   
	   'IQ' : 'IQD',   
	   'IE' : 'EUR',   
	   'IL' : 'ILS',   
	   'IT' : 'EUR',   
	   'JM' : 'JMD',   
	   'JP' : 'JPY',   
	   'JO' : 'JOD',   
	   'KZ' : 'KZT',   
	   'KE' : 'KES',   
	   'KI' : 'AUD',   
	   'KP' : 'KPW',   
	   'KR' : 'KRW',   
	   'KW' : 'KWD',   
	   'KG' : 'KGS',   
	   'LA' : 'LAK',   
	   'LV' : 'LVL',   
	   'LB' : 'LBP',   
	   'LS' : 'ZAR',   
	   'LR' : 'LRD',   
	   'LY' : 'LYD',   
	   'LI' : 'CHF',   
	   'LT' : 'LTL',   
	   'LU' : 'EUR',   
	   'MO' : 'MOP',   
	   'MK' : 'MKD',   
	   'MG' : 'MGA',   
	   'MW' : 'MWK',   
	   'MY' : 'MYR',   
	   'MV' : 'MVR',   
	   'ML' : 'XOF',   
	   'MT' : 'MTL',   
	   'MH' : 'USD',   
	   'MQ' : 'EUR',   
	   'MR' : 'MRO',   
	   'MU' : 'MUR',   
	   'YT' : 'EUR',   
	   'MX' : 'MXN',   
	   'FM' : 'USD',   
	   'MD' : 'MDL',   
	   'MC' : 'EUR',   
	   'MN' : 'MNT',   
	   'MS' : 'XCD',   
	   'MA' : 'MAD',   
	   'MZ' : 'MZM',   
	   'MM' : 'MMK',   
	   'NA' : 'ZAR',   
	   'NR' : 'AUD',   
	   'NP' : 'NPR',   
	   'NL' : 'EUR',   
	   'AN' : 'ANG',   
	   'NC' : 'XPF',   
	   'NZ' : 'NZD',   
	   'NI' : 'NIO',   
	   'NE' : 'XOF',   
	   'NG' : 'NGN',   
	   'NU' : 'NZD',   
	   'NF' : 'AUD',   
	   'MP' : 'USD',   
	   'NO' : 'NOK',   
	   'OM' : 'OMR',   
	   'PK' : 'PKR',   
	   'PW' : 'USD',   
	   'PA' : 'USD',   
	   'PG' : 'PGK',   
	   'PY' : 'PYG',   
	   'PE' : 'PEN',   
	   'PH' : 'PHP',   
	   'PN' : 'NZD',   
	   'PL' : 'PLN',   
	   'PT' : 'EUR',   
	   'PR' : 'USD',   
	   'QA' : 'QAR',   
	   'RE' : 'EUR',   
	   'RO' : 'ROL',   
	   'RU' : 'RUB',   
	   'RU' : 'RUR',   
	   'RW' : 'RWF',   
	   'SH' : 'SHP',   
	   'KN' : 'XCD',   
	   'LC' : 'XCD',   
	   'PM' : 'EUR',   
	   'VC' : 'XCD',   
	   'WS' : 'WST',   
	   'SM' : 'EUR',   
	   'ST' : 'STD',   
	   'SA' : 'SAR',   
	   'SN' : 'XOF',   
	   'SC' : 'SCR',   
	   'SL' : 'SLL',   
	   'SG' : 'SGD',   
	   'SK' : 'SKK',   
	   'SI' : 'SIT',   
	   'SB' : 'SBD',   
	   'SO' : 'SOS',   
	   'ZA' : 'ZAR',   
	   'ES' : 'EUR',   
	   'LK' : 'LKR',   
	   'SD' : 'SDD',   
	   'SR' : 'SRD',   
	   'SJ' : 'NOK',   
	   'SZ' : 'SZL',   
	   'SE' : 'SEK',   
	   'CH' : 'CHF',   
	   'SY' : 'SYP',   
	   'TW' : 'TWD',   
	   'TJ' : 'TJS',   
	   'TZ' : 'TZS',   
	   'TH' : 'THB',   
	   'TG' : 'XOF',   
	   'TK' : 'NZD',   
	   'TO' : 'TOP',   
	   'TT' : 'TTD',   
	   'TN' : 'TND',   
	   'TR' : 'TRL',   
	   'TM' : 'TMM',   
	   'TC' : 'USD',   
	   'TV' : 'AUD',   
	   'UG' : 'UGX',   
	   'UA' : 'UAH',   
	   'AE' : 'AED',   
	   'GB' : 'GBP',   
	   'US' : 'USD',   
	   'UM' : 'USD',   
	   'UY' : 'UYU',   
	   'UZ' : 'UZS',   
	   'VU' : 'VUV',   
	   'VE' : 'VEB',   
	   'VN' : 'VND',   
	   'VG' : 'USD',   
	   'VI' : 'USD',   
	   'WF' : 'XPF',   
	   'EH' : 'MAD',   
	   'YE' : 'YER',   
	   'CS' : 'EUR',   
	   'ZM' : 'ZMK',   
	   'UK' : 'GBP',   
	   'ZW' : 'ZWD'	 
	   };	 	 
	   	/* 				 	 
	   @txtnode -> the body of the html page 							  	 
	   @xchange -> xchange rate 							  	 
	   @cuscurrcode -> customer currency code/sign 						 	 
	   */ 	 
	   var afcodeck = gup('afCd'); 	 
	   var currCodeforGBP=''; 	 
	   var arrayposition=0;					 	 
	   var countGBP=0; 	 
 function $convert(txtnode, prevrate,xchange, cuscurrcode,time){ 
if(afcodeck == null ){ 
if(cuscurrcode=='EUR'){  
cuscurrcode='EUR'; //cuscurrcode='ï¿½'; 
}else if(cuscurrcode=='GBP'){ 
cuscurrcode='GBP'; //cuscurrcode='ï¿½'; 
}else if(cuscurrcode=='JPY'){ 
cuscurrcode='JPY';  //cuscurrcode='ï¿½'; 
} 
}  
var s; 
s= txtnode.innerHTML; 
if(afcodeck == null ){ 
xchange= xchange || 1  
if(xchange==1){  
cuscurrcode='GBP'; 
} 	  
}  
cuscurrcode= cuscurrcode || '£' 
if(s.search(Rx)==0 || s.search(Rx)==1){ 
var valuetobeset;  
if(time==1){ 
if(afcodeck == null ){ 
firstText[arrayposition]=s; 
if(currencyselectedvalue != "")  
{  
var valuestoget = firstText[arrayposition]; 
var valuearray = valuestoget.split("<"); 
valuetobeset= valuearray[0].replace(Rx, function(w){ 
if(time==1){ 
firstText[arrayposition]=s; 
} 
var texttoreturn=''; 
if(countGBP==0 && updatedCurrencyCode=="GBP"){ 
texttoreturn=valuearray[0].replace(/^\s+|\s+$/g, ""); 
}else{ 
texttoreturn=valuearray[0].replace(/^\s+|\s+$/g, "")+'\n('+cuscurrcode+' '+(w.substring(1)*xchange).toFixed(2)+')'; 
}  
return texttoreturn; 
 }) 
txtnode.innerHTML=valuetobeset.replace("(","<"+valuearray[1]+"</span><br>("); 
} 
}else{ 
firstText[arrayposition]=s; 
if(currencyselectedvalue != "") 
{  
var valuestoget = firstText[arrayposition]; 
var valuearray = valuestoget.split("<"); 
var secrate=''; 
valuetobeset= valuearray[0].replace(Rx, function(w){ 
if(time==1){ 
firstText[arrayposition]=s; 
} 
var texttoreturn=''; 
texttoreturn=valuearray[0].replace(/^\s+|\s+$/g, ""); 
if (cuscurrcode == 'GBP'){cuscurrcode='\u00A3'+''}  
try{ 
if(!isNaN(w.substring(1))) 
secrate =''+cuscurrcode+' '+((w.substring(1)/prevrate)*xchange).toFixed(2)+''; 
else 
secrate =''+cuscurrcode+' '+((w.substring(3)/prevrate)*xchange).toFixed(2)+''; 
}catch(e) 
{ 
secrate =''+cuscurrcode+' '+((w.substring(3)/prevrate)*xchange).toFixed(2)+''; 
} 
 
return texttoreturn; 
}) 
txtnode.innerHTML=secrate;//.setAttribute("class",'choose-lang  hidec') 
} 
} 
}else{	 
var valuestoget = firstText[arrayposition]; 
var valuearray = valuestoget.split("<"); 
valuetobeset= valuearray[0].replace(Rx, function(w){ 
if(time==1){ 
firstText[arrayposition]=s; 
} 
var texttoreturn = 0.0; 
if(!isNaN(w.substring(1))) 
texttoreturn =''+cuscurrcode+' '+((w.substring(1)/prevrate)*xchange).toFixed(2)+''; 
else 
texttoreturn =''+cuscurrcode+' '+((w.substring(3)/prevrate)*xchange).toFixed(2)+''; 
return texttoreturn; 
}) 
txtnode.innerHTML=valuetobeset.replace("(","<"+valuearray[1]+"</span><br>("); 
} 
arrayposition++; 
} 
} 
function ElementChecker (node) { 
values = node.innerHTML;  
 
if(values.search(Rx)==0 || values.search(Rx)==1){ 
return NodeFilter.FILTER_ACCEPT;  
} 	 
return NodeFilter.FILTER_SKIP; 
}  
/*  
@hoo -> the body of the html page 
@convert -> function to call to convert  
@cuscurrcode -> customer currency code/sign 	 
*/ 
function deepText(convert,hoo,prevrate,currrate,cuscurrcode,time){ 
if(navigator.userAgent.indexOf("MSIE") != -1) { 
(function findTextNodes(current) { 
for(var i = 0; i < current.childNodes.length; i++) { 
var child = current.childNodes[i]; 
 
if(child.nodeType == 1) { 
convert(child, prevrate,currrate, cuscurrcode,time); 
findTextNodes(child);  
}  
else { 
findTextNodes(child); 
				   }  
} 	 
})(document.body); 
}else {  
walker = document.createTreeWalker (hoo, NodeFilter.SHOW_ELEMENT, ElementChecker, false); 
var node = walker.firstChild ();  
while (node) { 
convert(node, prevrate,currrate, cuscurrcode,time) 
node = walker.nextNode (); 
}	 
}	  
} 	  
function getCurrencyCodeForCustomer(){ 
return countryCurrency[currencyselectedvalue]; 
} 
function controllerConvert(){ 
firstText=new Array();  
var cuscurrcode=getCurrencyCodeForCustomer(); 
var hoo=document.body; 
var rate=curXRates[currencyselectedvalue]; // get the xchange rate according to the currency code 
deepText($convert,hoo,1,rate,currencyselectedvalue,1); 
} 
var prevcurrencycode = "GBP"; 
function convertOnRequest(cuscurrcode,countryname){ 
countGBP=1; 
currCodeforGBP=cuscurrcode; 
document.getElementById("cuurdrop").parentNode.setAttribute("class",''); 
$("#currencycreator").removeClass("active"); 
 
var pattern2 =""; 
if(updatedCurrencyCode != "GBP") 
{ 
pattern2 = "\\"+updatedCurrencyCode+"\\s(\\d+(\\.\\d+)?)"; 
 
}else{ 
pattern2 = "\\\u00A3\\s(\\d+(\\.\\d+)?)"; 
 
 
} 
Rx= new RegExp(pattern2,"g");// +"/g"; 
if(cuscurrcode!='SEL'){ 
arrayposition=0;  
var hoo=document.body; 
var prevrate=curXRates[updatedCurrencyCode]; 
var rate=curXRates[cuscurrcode]; // get the xchange rate according to the currency code 
deepText($convert,hoo,prevrate,rate,cuscurrcode,1); 	 
} 
changecurrncydrop(cuscurrcode,countryname) 
prevcurrencycode = cuscurrcode; 
}  
function multipleConvertOnRequest(cuscurrcode){ 
countGBP=1; 
currCodeforGBP=cuscurrcode; 
if(cuscurrcode!='SEL'){ 
arrayposition=0; 
var hoo=document.body; 
var rate=curXRates[cuscurrcode]; // get the xchange rate according to the currency code 
deepText($convert,hoo,1,rate,cuscurrcode,1); 
} 
} 
	function containsSpecialOffer(d){	 	 
		for(var i = 0; i < d.childNodes.length; i++) {	 	 
	     if (d.childNodes[i].innerHTML == "*"){	 	 
	          return d.childNodes[i];	 	 
		}	 	 
	}	 	 
	return false;	 	 
	}	 	 
	   		function changecurrncydrop(pcuscurrcode,contrycode) 	 
	   { 	 
	   updatedCurrencyCode = pcuscurrcode; 	 
	   currencycreator(); 	 
	   } 	 
	   		var currencyselectedvalue = ""; 	 
	   var currencyselectedname = ""; 	 
	   	 	function setcookies(cookieName,cookieValue) { 	 
	   var cookenabled = navigator.cookieEnabled 	 
	   if (cookenabled){ 	 
	   with(document){ 	 
	   document.cookie = cookieName+'='+cookieValue;   	 
	   } 	 
	   }			 	 
	   } 	 
	   		 function getCookie(name) { 	 
	   var dc = document.cookie; 	 
	   var prefix = name + "="; 	 
	   var begin = dc.indexOf("; " + prefix); 	 
	   if (begin == -1) { 	 
	   begin = dc.indexOf(prefix); 	 
	   if (begin!= 0) return null; 	 
	   } else { 	 
	   begin += 2; 	 
	   } 	 
	   var end = document.cookie.indexOf(";", begin); 	 
	   if (end == -1) { 	 
	   end = dc.length; 	 
	   } 	 
	   return unescape(dc.substring(begin + prefix.length, end)); 	 
	   } 	 
	   		 var updatedCurrencyCode =''; 	 
	   function currencycreator(){ 	 
	   var img='img_con_'; 	 
	   var img1='img_con_'; 	 
	   var cuurencyflagarray  =[img+"en",img1+"ae",img+"AM",img+"AR",img+"au",img+"AZ",img+"BB",img+"BH",img1+"br",img+"BS",img+"BZ",img+"ca",img1+"ch",img+"cl",img+"CN",img+"CO",img+"CR",img1+"cz",img+"dk",img+"DZ",img1+"europeanunion",img+"FJ",img+"GT",img+"HK",img+"HN",img1+"hu",img+"il",img1+"in",img+"JO",img+"jp",img+"KR",img+"MU",img1+"mx",img+"MY",img+"NI" ,img+"no",img+"NZ",img+"PH",img1+"pl",img+"PY",img+"QA",img+"RU",img+"se",img1+"sg",img+"TH",img+"TL",img+"us",img+"UY",img+"XC",img+"ZA"] 	 
	   var cuurencyarray  =["GBP","AED","AMD","ARS","AUD","AZN","BBD","BHD","BRL","BSD","BZD","CAD","CHF","CLP","CNY","COP","CRC","CZK","DKK","DZD","EUR","FJD","GTQ","HKD","HNL","HUF","ILS","INR","JOD","JPY","KRW","MUR","MXN","MYR","NIO","NOK","NZD","PHP","PLN","PYG","QAR","RUB","SEK","SGD","THB","TRY","USD","UYU","XCD","ZAR"] 	 
	   var currencynamearay  =["Pound sterling","U.A.E. dirham","Armenian Dram","Argentine Peso","Australian dollar","Azerbaijani New Manat","Barbadian dollar","Bahraini Dinar","Brazilian real","Bahamian dollar","Belize dollar","Canadian dollar","Swiss franc","Chilean peso","China Yuan Renminbi","Colombian Peso","Costa Rican colón","Czech koruna","Danish krone","Algerian Dinar","Euro","Fijian Dollar","Quetzal","Hong Kong Dollar","Lempira ","Hungarian forint","Israeli new sheqel","Indian rupee","Jordanian Dinar","Japanese yen","Korea (South) Won","Mauritian Rupee","Mexican peso","Malaysian Ringgit","Norwegian krone","New Zealand Dollar","Philippine Peso","Polish zloty","Paraguayan Guarani","Córdoba","Qatari Riyal","Russian Ruble","Swedish krona","Singapore dollar","Thailand Baht","Turkish Lira","U.S. Dollar","Uruguayan Peso","East Caribbean dollar","South African Rand"] 	 
	   var listreturn  = ""; 	 
	   var listreturn0 = ""; 	 
	   var errorHandler = 1; 	 
	    for(i in cuurencyarray){ 	 
	   		if(cuurencyarray[i] == updatedCurrencyCode){ 	 
	   			errorHandler = 0; 	 
	   		} 	 
	   	  } 	 
	   	  if(errorHandler == 1){ 	 
	   	  	updatedCurrencyCode = "GBP"; 	 
	   	    } 	 
	   currencyselectedvalue = updatedCurrencyCode; 	 
	   setcookies('currencyname',updatedCurrencyCode); 	 
	   var selectedIndex=0; 	 
	   for(i in cuurencyarray) 	 
	   { 	 
	   if(cuurencyarray[i]!=currencyselectedvalue){ 	 
	   listreturn += "<li id='"+cuurencyarray[i]+"' ><a href='#' onclick=\"convertOnRequest('"+cuurencyarray[i]+"','"+currencynamearay[i]+"')\"><img class='"+cuurencyflagarray[i]+"' alt='' />"+cuurencyarray[i]+"</a></li>"; 	 
	   }else{ 	 
	   selectedIndex=i; 	 
	   } 	 
	   } 	 
	   		  var listreturn1 ='<div class="choose-lang"><span class="lang-name" title="Currency"><img class="'+cuurencyflagarray[selectedIndex]+'" alt="" />'+cuurencyarray[selectedIndex]+'</span><a class="btn-lang-drop" href="#">Change lang</a></div>';//<ul id="dropselectedc"><li id="'+currencyselectedvalue+'"><a href="#" onload=convertOnRequest("'+currencyselectedvalue+'","'+currencyselectedname+'")>'+currencyselectedname+'</a></li></ul> 	 
	   document.getElementById("currencycreator").innerHTML = listreturn1+'<ul class="lang-drop" id="cuurdrop">'+listreturn+'</ul><div class="choose-lang  hidec">&nbsp;</div>'; 	 
	    initMenu(); 	 
	   } 	 
	    function createCurrencyDropDown(lang){							  	 
	   var dropdown='	<select name="curlist" onchange="javascript:convertOnRequest(this.value);">';   	 
	   if(lang=='en'){ 	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown+' <option value="AED">U.A.E. dirham (AED)</option>'; dropdown=dropdown+' <option value="AUD">Australian dollar (AUD)</option>'; dropdown=dropdown+' <option value="BRL">Brazilian real (BRL)</option>'; dropdown=dropdown+' <option value="CAD">Canadian dollar (CAD)</option>'; dropdown=dropdown+' <option value="CHF">Swiss franc (CHF)</option>'; dropdown=dropdown+' <option value="CLP">Chilean peso (CLP)</option>'; dropdown=dropdown+' <option value="CZK">Czech koruna (CZK)</option>'; dropdown=dropdown+' <option value="DKK">Danish krone (DKK)</option>'; dropdown=dropdown+' <option value="EUR">Euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP">Pound sterling (GBP)</option>'; dropdown=dropdown+' <option value="HUF">Hungarian forint (HUF)</option>'; dropdown=dropdown+' <option value="ILS">Israeli new sheqel (ILS)</option>'; dropdown=dropdown+' <option value="INR">Indian rupee (INR)</option>'; dropdown=dropdown+' <option value="JPY">Japanese yen (JPY)</option>'; dropdown=dropdown+' <option value="MXN">Mexican peso (MXN)</option>'; dropdown=dropdown+' <option value="NOK">Norwegian krone (NOK)</option>'; dropdown=dropdown+' <option value="PLN">Polish zloty (PLN)</option>'; dropdown=dropdown+' <option value="SEK">Swedish krona (SEK)</option>'; dropdown=dropdown+' <option value="SGD">Singapore dollar (SGD)</option>'; dropdown=dropdown+' <option value="USD">U.S. Dollar (USD)</option>'; 	 	 
	   }else if(lang=='fr'){							  	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown=dropdown+' <option value="AED">Dirham des Émirats Arabes Unis (AED)</option>'; dropdown=dropdown+' <option value="AUD">Dollar australien (AUD)</option>'; dropdown=dropdown+' <option value="BRL">Real du Brésil (BRL)</option>'; dropdown=dropdown+' <option value="CAD">Dollar canadien (CAD)</option>'; dropdown=dropdown+' <option value="CHF">Franc suisse (CHF)</option>'; dropdown=dropdown+' <option value="CLP">Peso chilien (CLP)</option>'; dropdown=dropdown+' <option value="CZK">Couronne tchèque (CZK)</option>'; dropdown=dropdown+' <option value="DKK">Couronne danoise (DKK)</option>'; dropdown=dropdown+' <option value="EUR">Euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP" >Livre sterling (GBP)</option>'; dropdown=dropdown+' <option value="HUF">Forint hongrois (HUF)</option>'; dropdown=dropdown+' <option value="ILS">Nouvel israëli sheqel (ILS)</option>'; dropdown=dropdown+' <option value="INR">Roupie indienne (INR)</option>'; dropdown=dropdown+' <option value="JPY">Yen japonais (JPY)</option>'; dropdown=dropdown+' <option value="MXN">Peso mexicain (MXN)</option>'; dropdown=dropdown+' <option value="NOK">Couronne norvégienne (NOK)</option>'; dropdown=dropdown+' <option value="PLN">Zloty polonais (PLN)</option>'; dropdown=dropdown+' <option value="SEK">Couronne suédoise (SEK)</option>'; dropdown=dropdown+' <option value="SGD">Dollar de Singapour (SGD)</option>'; dropdown=dropdown+' <option value="USD">Dollar des États-Unis (USD)</option>'; 	 	 
	   }else if(lang=='de'){							  	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown=dropdown+' <option value="AED">V.A.E. Dirham (AED)</option>'; dropdown=dropdown+' <option value="AUD">Australischer Dollar (AUD)</option>'; dropdown=dropdown+' <option value="BRL">Brasilianischer Real (BRL)</option>'; dropdown=dropdown+' <option value="CAD">Kanadischer Dollar (CAD)</option>'; dropdown=dropdown+' <option value="CHF">Schweizer Franken (CHF)</option>'; dropdown=dropdown+' <option value="CLP">Chilenischer Peso (CLP)</option>'; dropdown=dropdown+' <option value="CZK">Tschechische Krone (CZK)</option>'; dropdown=dropdown+' <option value="DKK">Dänische Krone (DKK)</option>'; dropdown=dropdown+' <option value="EUR">Euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP" >Britisches Pfund (GBP)</option>'; dropdown=dropdown+' <option value="HUF">Ungarischer Forint (HUF)</option>'; dropdown=dropdown+' <option value="ILS">Israelischer Schekel (ILS)</option>'; dropdown=dropdown+' <option value="INR">Indische Rupie (INR)</option>'; dropdown=dropdown+' <option value="JPY">Japanischer Yen (JPY)</option>'; dropdown=dropdown+' <option value="MXN">Mexikanischer Peso (MXN)</option>'; dropdown=dropdown+' <option value="NOK">Norwegische Krone (NOK</option>'; dropdown=dropdown+' <option value="PLN">Polnischer Zloty (PLN)</option>'; dropdown=dropdown+' <option value="SEK">Schwedische Krone (SEK)</option>'; dropdown=dropdown+' <option value="SGD">Singapur-Dollar (SGD)</option>'; dropdown=dropdown+' <option value="USD">US-Dollar (USD)</option>'; 	 	 
	   }else if(lang=='it'){							  	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown=dropdown+' <option value="AED">Dirham degli EAU (AED)</option>'; dropdown=dropdown+' <option value="AUD">Dollaro australiano (AUD)</option>'; dropdown=dropdown+' <option value="BRL">Real brasiliano (BRL)</option>'; dropdown=dropdown+' <option value="CAD">Dollaro canadese (CAD)</option>'; dropdown=dropdown+' <option value="CHF">Franco svizzero (CHF)</option>'; dropdown=dropdown+' <option value="CLP">Peso cileno (CLP)</option>'; dropdown=dropdown+' <option value="CZK">Corona ceca (CZK)</option>'; dropdown=dropdown+' <option value="DKK">Corona danese (DKK)</option>'; dropdown=dropdown+' <option value="EUR">Euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP" >Sterlina britannica (GBP)</option>'; dropdown=dropdown+' <option value="HUF">Fiorino ungherese (HUF)</option>'; dropdown=dropdown+' <option value="ILS">Nuovo shequel israeliano (ILS)</option>'; dropdown=dropdown+' <option value="INR">Rupia indiana (INR)</option>'; dropdown=dropdown+' <option value="JPY">Yen giapponese (JPY)</option>'; dropdown=dropdown+' <option value="MXN">Peso messicano (MXN)</option>'; dropdown=dropdown+' <option value="NOK">Corona norvegese (NOK)</option>'; dropdown=dropdown+' <option value="PLN">Zloty polacca (PLN)</option>'; dropdown=dropdown+' <option value="SEK">Corona svedese (SEK)</option>'; dropdown=dropdown+' <option value="SGD">Dollaro singaporese (SGD)</option>'; dropdown=dropdown+' <option value="USD">Dollaro statunitense (USD)</option>'; 	 	 
	   }else if(lang=='pl'){							  	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown=dropdown+' <option value="AED">dirham (AED)</option>'; dropdown=dropdown+' <option value="AUD">dolar australijski (AUD)</option>'; dropdown=dropdown+' <option value="BRL">real brazylijski (BRL)</option>'; dropdown=dropdown+' <option value="CAD">dolar kanadyjski (CAD)</option>'; dropdown=dropdown+' <option value="CHF">frank szwajcarski (CHF)</option>'; dropdown=dropdown+' <option value="CLP">peso chilijskie (CLP)</option>'; dropdown=dropdown+' <option value="CZK">korona czeska (CZK)</option>'; dropdown=dropdown+' <option value="DKK">korona du?ska (DKK)</option>'; dropdown=dropdown+' <option value="EUR">euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP" >funt szterling (GBP)</option>'; dropdown=dropdown+' <option value="HUF">forint (HUF)</option>'; dropdown=dropdown+' <option value="ILS">szekel izraelski (ILS)</option>'; dropdown=dropdown+' <option value="INR">rupia indyjska (INR)</option>'; dropdown=dropdown+' <option value="JPY">jen japo?ski (JPY)</option>'; dropdown=dropdown+' <option value="MXN">peso meksyka?skie (MXN)</option>'; dropdown=dropdown+' <option value="NOK">korona norweska (NOK)</option>'; dropdown=dropdown+' <option value="PLN">zloty (PLN)</option>'; dropdown=dropdown+' <option value="SEK">korona szwedzka (SEK)</option>'; dropdown=dropdown+' <option value="SGD">dolar singapurski (SGD)</option>'; dropdown=dropdown+' <option value="USD">dolar ameryka?ski (USD)</option>'; 	 	 
	   }else if(lang=='es'){							  	 
	   dropdown=dropdown+' <option value="SEL"  selected>Select Currency </option>'; dropdown=dropdown+' <option value="AED">Dirham EAU (AED)</option>'; dropdown=dropdown+' <option value="AUD">Dólar australiano (AUD)</option>'; dropdown=dropdown+' <option value="BRL">Real brasileño (BRL)</option>'; dropdown=dropdown+' <option value="CAD">Dólar canadiense (CAD)</option>'; dropdown=dropdown+' <option value="CHF">Franco suizo (CHF)</option>'; dropdown=dropdown+' <option value="CLP">Peso chileno (CLP)</option>'; dropdown=dropdown+' <option value="CZK">Corona checa (CZK)</option>'; dropdown=dropdown+' <option value="DKK">Corona danesa (DKK)</option>'; dropdown=dropdown+' <option value="EUR">Euro (EUR)</option>'; dropdown=dropdown+' <option value="GBP" >Libra esterlina (GBP)</option>'; dropdown=dropdown+' <option value="HUF">Florín húngaro (HUF)</option>'; dropdown=dropdown+' <option value="ILS">Nuevo sheqel israelí (ILS)</option>'; dropdown=dropdown+' <option value="INR">Rupia india (INR)</option>'; dropdown=dropdown+' <option value="JPY">Yen japonés (JPY)</option>'; dropdown=dropdown+' <option value="MXN">Peso mexicano (MXN)</option>'; dropdown=dropdown+' <option value="NOK">Corona noruega (NOK)</option>'; dropdown=dropdown+' <option value="PLN">Zloty polaco (PLN)</option>'; dropdown=dropdown+' <option value="SEK">Corona sueca (SEK)</option>'; dropdown=dropdown+' <option value="SGD">Dólar de Singapur (SGD)</option>'; dropdown=dropdown+' <option value="USD">Dólar estadounidense (USD)</option>'; 	 	 
	   }							  	 
	   		 dropdown=dropdown+' </select>';		 	 
	   document.getElementById('ycccurrencyList').innerHTML=dropdown; 	 	 
	   }							  	 
	   function visiblelang(){ 	 
	   if(document.getElementById("cuurdrop").style.display=="none"){ 	 
	   document.getElementById("cuurdrop").style.display="block"; 	 
	   }else{ 	 
	   document.getElementById("cuurdrop").style.display="none" 	 
	   } 	 
	   } 	 
	   function gup( name ){  	 
	   name = name.replace(/[\[]/,'\\[').replace(/[\]]/,'\\]'); 
	   var regexS = '[\?&]'+name+'=([^&#]*)';  var regex = new RegExp( regexS ); 
	   var results = regex.exec( window.location.href );  	 
	   if( results == null ) {   	 
	   return null; 	 
	   }else{    	 
	   return results[1]; 	 
	   } 	 
	   }	
