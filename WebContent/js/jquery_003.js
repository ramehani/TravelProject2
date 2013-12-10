jQuery.extend({
   getUrlVars: function(){
     var vars = [], hash;
     var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
     for(var i = 0; i < hashes.length; i++)
     {
       hash = hashes[i].split('=');
       vars.push(hash[0]);
       vars[hash[0]] = hash[1];
     }
     return vars;
   },
   getUrlVar: function(name){
     return $.getUrlVars()[name];
   }
 });
 var paramArray =  jQuery.getUrlVars();
 var lang = paramArray["language"];

function initOpenCloseLess(){
$("div.opndv").OpenClose(
{
activeClass:"active-block",
opener:"a.btn-less",
slider:"div.block",
effect:"slide",
animSpeed:500
});
}

function initOpenClose(){
	$("div.opndv").OpenClose({
		activeClass:"active-block",
		opener:"a.open-close",
		slider:"div.block",
		effect:"slide",
		animSpeed:500
	});	
}

jQuery.fn.OpenClose = function(_options){
	// default options
	var _options = jQuery.extend({
		activeClass:'active',
		opener:'.opener',
		slider:'.slide',
		animSpeed: 400,
		animStart:false,
		animEnd:false,
		effect:'fade',
		event:'click'
	},_options);

	return this.each(function(){
		// options
		var _holder = jQuery(this);
		var _slideSpeed = _options.animSpeed;
		var _activeClass = _options.activeClass;
		var _opener = jQuery(_options.opener, _holder);
		var _slider = jQuery(_options.slider, _holder);
		var _animStart = _options.animStart;
		var _animEnd = _options.animEnd;
		var _effect = _options.effect;
		var _event = _options.event;
		if(_slider.length) {
			_opener.live(_event,function(){
				//_opener.parents('.combination').find('.btn05a').css({ top:_opener.position().top-19})
				if(!_slider.is(':animated')) {
					if(typeof _animStart === 'function') _animStart();
					if(_holder.hasClass(_activeClass)) {
						_slider[_effect=='fade' ? 'fadeOut' : 'slideUp'](_slideSpeed,function(){
							if(typeof _animEnd === 'function') _animEnd();
						});
						_holder.removeClass(_activeClass);
					} else {
						_holder.addClass(_activeClass);
						_slider[_effect=='fade' ? 'fadeIn' : 'slideDown'](_slideSpeed,function(){
							if(typeof _animEnd === 'function') _animEnd();
						});
					}
				}
				return false;
			});
			if(_holder.hasClass(_activeClass)){_slider.show();}
			else _slider.hide();
		}
	});
}
		
function initImageClick(){
	var a=document.getElementsByTagName("label");
	for(var b=0;b<a.length;b++){
		var c=a[b].getElementsByTagName("img");
		if(c.length>0){
			c[0].onclick=function(){
				this.parentNode.click()
			}
		}
	}
}

function initBrowserDetect(){function d(a){b.className+=" "+a}function c(b){if(a.indexOf(b)!=-1)return true}var a=navigator.userAgent.toLowerCase();var b=document.getElementsByTagName("html")[0];if(c("win"))d("win");else if(c("mac"))d("mac");else if(c("linux")||c("x11"))d("linux");if(c("msie 8.0"))d("ie8");else if(c("msie 7.0"))d("ie7");else if(c("msie 6.0"))d("ie6");else if(c("firefox/2"))d("ff2");else if(c("firefox/3"))d("ff3");else if(c("opera")&&c("version/10"))d("opera10");else if(c("opera/9"))d("opera9");else if(c("safari")&&c("version/3"))d("safari3");else if(c("safari")&&c("version/4"))d("safari4");else if(c("safari")&&c("version/5"))d("safari5");else if(c("chrome"))d("chrome");else if(c("safari"))d("safari2");else if(c("unknown"))d("unknown");if(c("msie"))d("trident");else if(c("applewebkit"))d("webkit");else if(c("gecko"))d("gecko");else if(c("opera"))d("presto")}function initTooltip(){$("ul.photo-list > li").each(function(){function d(){$("ul.photo-list > li").removeClass("active");$("html").unbind("click",d)}var a=$(this);var b=a.find(".frame > a");var c=a.find(".popup");b.click(function(){if(a.hasClass("active")){a.removeClass("active")}else{$("ul.photo-list > li").removeClass("active");a.addClass("active");$("html").click(d)}return false})})}

function initDatePicker(){
/*******
Date Picker Config Options
*********/
var dateCountry = "UK";	//possible options, UK or US - defaults to UK for other settings
var language = "en"; //possible options en,fr,de,es,it,pl
var defaultDate = new Date(); //you can define a start date by entering it in the brackets here


var defaultEndDate = new Date(); //you can define an end date by entering it in the brackets here
var datenumber = daysInMonth(defaultDate.getMonth()+1,defaultDate.getYear())

if( Number(datenumber) == 31)
{
	defaultDate.setDate(document.styleForm.cmbCheckInDate.value);
	defaultDate.setMonth(Number(document.styleForm.cmbCheckInMonth.value)-1);	
	defaultDate.setYear(document.styleForm.cmbCheckInYear.value);
	
	defaultEndDate.setDate(document.styleForm.cmbCheckOutDate.value);	
	defaultEndDate.setMonth(Number(document.styleForm.cmbCheckOutMonth.value)-1);
	defaultEndDate.setYear(document.styleForm.cmbCheckOutYear.value);

}else{
	defaultDate.setYear(document.styleForm.cmbCheckInYear.value);
	defaultDate.setMonth(Number(document.styleForm.cmbCheckInMonth.value)-1);	
	defaultDate.setDate(document.styleForm.cmbCheckInDate.value);
	
	defaultEndDate.setYear(document.styleForm.cmbCheckOutYear.value);
	defaultEndDate.setMonth(Number(document.styleForm.cmbCheckOutMonth.value)-1);
	defaultEndDate.setDate(document.styleForm.cmbCheckOutDate.value);	
}

var img_folder = '../images/'; //please set path to image folder (with a / at the end). Best to put a fully qualified URL
var js_folder = '/html/Ts/js/'; //please set path to folder where js languages are stored. Best to put a fully qualified URL

var today = new Date();
	var todayTime = today.getTime() - 1000*60*60*24*1.3;
	var dateTime = defaultDate.getTime();
	var endDateTime = defaultEndDate.getTime();
	var checkoutClicked = false;
	if(todayTime >= dateTime) {
		dateTime = dateTime + 1000*60*60*24*7;
	}
	defaultDate = new Date(dateTime);
	
	defaultDate = new Date(dateTime);
	//alert(defaultDate.getDay());
	defaultEndDate = new Date(endDateTime);
	/*if(dateCountry == "US") {
		var date_format = "mm/dd/yy";
	} else {*/
		var date_format = "dd/mm/yy";
	//}
	set_from_date();
	jQuery.datepicker.setDefaults(jQuery.datepicker.regional['']);
	jQuery.datepicker.setDefaults(jQuery.datepicker.regional['']);
	var dates = jQuery( "#check-in, #check-out" ).datepicker({
	changeMonth:true,
	changeYear:true,
	firstDay:1,
	dateFormat:date_format,
	numberOfMonths: 2,
	minDate:new Date(),
	//maxDate:"+12m",
	maxDate:"+24m",
	showOn: 'both',
	buttonImage: img_folder+'ico-calendar3.png',
	buttonImageOnly: true,
	showButtonPanel:true,
	beforeShowDay: initDays,
	buttonText:function(e,ui){if(jQuery('#check-in')) "checkin"; else "checkout"; },
	beforeShow: function(e, ui) {
		 jQuery('.ui-datepicker-month').attr('a','123');
	 },
	onSelect: function( selectedDate ) {
		 if (jQuery(this).attr('id') == 'check-in') { 
					//alert('hello');	
			
			var d1=jQuery('#check-in').datepicker("getDate");
			var d2=jQuery('#check-out').datepicker("getDate");
			
			if(d1 >= d2 || checkoutClicked == false) {
				d2 = new Date(d1.getTime() + 1000*60*60*24*1);
				jQuery('#check-out').datepicker('setDate', d2);
				checkoutClicked = false;
			}																										
		
		}  else {
				
			var d1=jQuery('#check-in').datepicker("getDate");
			var d2=jQuery('#check-out').datepicker("getDate");
			checkoutClicked = true;
			//alert(checkoutClicked);
			if(d1 >= d2) {
				d2 = new Date(d1.getTime() + 1000*60*60*24*1);
				jQuery('#check-out').datepicker('setDate', d2);
				alert('Check out date must be after check in date');
				checkoutClicked = false;
			}
		}
	}
 
});
	jQuery('#check-in').datepicker('setDate',defaultDate);
	jQuery('#check-out').datepicker('setDate',defaultEndDate);
	jQuery("#check-in" ).datepicker( "option", "buttonText", 'Check in date' );
	jQuery("#check-out" ).datepicker( "option", "buttonText", 'Check out date' );
	jQuery('#check-in').datepicker("option", jQuery.datepicker.regional[language]);
	jQuery('#check-out').datepicker("option", jQuery.datepicker.regional[language]);
	function initDays(date) {//Highlight weekends
		var state = '';
		if (date.getDay() == 6 || date.getDay() == 0) {
			state = state + ' ui-state-highlight';
			
		}
		var sDate = jQuery('#check-in').datepicker('getDate').getTime();
		console.log(sDate);
		var eDate = jQuery('#check-out').datepicker('getDate').getTime();
		//alert(1);
		var cDate = date.getTime();
		if(cDate == sDate) {
			state = state + ' ui-state-startDate';
		}
		if(cDate == eDate) {
			state = state + ' ui-state-endDate';
		}
		if(cDate > sDate && cDate < eDate) {
			state = state + ' ui-state-midDate';
		}
		return [true, state];
	
	 }
	 
		 function set_from_date(){
		var from_date = new Date();
		var today = new Date();
		if(from_date.getDay() == 5){ 
			jQuery( "#check-in" ).val(today.getDate()+9+"/"+today.getMonth()+"/"+today.getFullYear());
		}else if(from_date.getDay()==6){ 
			jQuery( "#check-in" ).val(today.getDate()+8+"/"+today.getMonth()+"/"+today.getFullYear());
		}else{
		jQuery( "#check-in" ).datepicker("setDate",new Date(today.getTime()+7*24*60*60*1000));
		}
	
	 }
	 initCustomForms();
}


 
// function initSlider(){$("#slider").slider({range:true,min:0,max:150,values:[0,150],slide:function(a,b){$("#slider").parent().find(".label-min").text("£"+b.values[0]);$("#slider").parent().find(".label-max").text("£"+b.values[1])}});$("#slider").parent().find(".label-min").text("£"+$("#slider").slider("values",0));$("#slider").parent().find(".label-max").text("£"+$("#slider").slider("values",1))}
function initScrollTo(){function e(){if(!window.loadOver){window.loadOver=true;var a=$('<div class="overlay"><div class="top"></div><div class="bottom"></div><div class="left"></div><div class="right"></div><img width="236" height="192" src="/html/Ts/Img/layout/modal_square.png"></div>');var b=a.find("img");var e=a.find(".top");var f=a.find(".left");var g=a.find(".right");var h=a.find(".bottom");var i=$(window).width();var j=$(document).height();var k=$("#sidebar .search-block").width();var l=$("#sidebar .search-block").height();var m=$("#sidebar .search-block");var n=m.offset().top;var o=m.offset().left;b.css({position:"absolute",top:n,left:o});if($.browser.msie){b.css({width:k,height:l});$("select").css("visibility","hidden")}else{b.css({width:k,height:l})}e.css({position:"absolute",width:k,height:n,top:0,left:o,backgroundColor:d,opacity:c});f.css({position:"absolute",width:o,height:j,top:0,left:0,backgroundColor:d,opacity:c});g.css({position:"absolute",width:i-(o+k),height:j,top:0,left:o+k,backgroundColor:d,opacity:c});h.css({position:"absolute",width:k,height:j-(n+l),top:n+l,left:o,backgroundColor:d,opacity:c});a.css({position:"absolute",left:0,top:0,width:$(window).width(),height:j,zIndex:1e3}).click(function(){a.remove();window.loadOver=false;$("select").css("visibility","visible")}).appendTo($("body"));
//if($.browser.msie)DD_belatedPNG.fixPng(b.get(0))
}}
var a=$("a.scroll-to");
//var b=300;var c=.3;var d="#000000";
a.click(function(){
clearFilters();
//var a=$($(this).attr("href")).length?$($(this).attr("href")).offset().top:0;$("body, html").animate({scrollTop:a},{duration:b,complete:function(){e()}});return false
})}
function initCardType(){if(jQuery("#cmbCardTypediv").length){if(jQuery("#cmbCardTypediv").val()=="SW"||jQuery("#cmbCardTypediv").val()=="SO"){jQuery("#cmbCardTypediv").parents("form").find('div[title="maestro"]').show()}else{jQuery("#cmbCardTypediv").parents("form").find('div[title="maestro"]').hide()}jQuery("#cmbCardTypediv").change(function(){if(jQuery(this).val()=="SW"||jQuery(this).val()=="SO"){jQuery(this).parents("form").find('div[title="maestro"]').show()}else{jQuery("#cmbCardTypediv").parents("form").find('div[title="maestro"]').hide()}})}}function initRooms(){$("#guests").parents("form").find(".rooms-hold").children().hide();$("#guests").change(function(){var a=$(this).val()*1;$(this).parents("form").find(".rooms-hold").children().hide();$(this).parents("form").find(".rooms-hold").children().filter(":lt("+a+")").show()})}$(function(){/*initOpenClose();initOpenCloseLess();*/initBrowserDetect();initImageClick();initTooltip();$(".main-block").each(
function(){var a=$(this);a.find("a").click(function(){$(".main-block").removeClass("active-block");a.addClass("active-block")});
a.find("div").click(function(){$(".main-block").removeClass("active-block");a.addClass("active-block")}) }
);$("body").myPopup();if(typeof $.datepicker==="object")initDatePicker();
//if(typeof $("#slider").slider==="function")initSlider();
initScrollTo();initCardType();initRooms();initopenMultiple();});$.fn.myPopup=function(a){var a=$.extend({duration:700,linkOpenName:".link-popup",linkCloseName:"a.close, a.btn-close",divFader:"fader",wrapper:"#wrapper"},a);return this.each(function(){function i(b){function p(a){h.fadeOut(300,function(){h.css({left:"-9999px"}).show();if(d)g.css({visibility:"visible"});e.unbind("click");$(window).unbind("resize");if(a)f.hide();else{if(e.attr("href"))i(e.attr("href"));else i(e.attr("title"))}})}h=$(b);var c=h.find(a.linkCloseName);var e=h.find(".link-submit");if(d)g.css({visibility:"hidden"});var j=$("body").width();var k=$(window).width();if(k>j)j=k;var l=$(window).height();var m=$(window).scrollTop();var n=m+l/2-h.outerHeight(true)/2;if(n<0)n=0;var o=$(a.wrapper).height();if($(window).height()>o)o=$(window).height();h.css({top:n,left:j/2-h.outerWidth(true)/2}).hide();f.css({width:j,height:o}).fadeIn(300,function(){h.fadeIn(300)});$(window).resize(function(){j=$("body").width();k=$(window).width();if(k>j)j=k;h.animate({left:j/2-h.outerWidth(true)/2},{queue:false,duration:300});f.css({width:j})});c.click(function(){p(true);return false});e.click(function(){p();return false});f.click(function(){p(true);return false})}var b=$(this);var c=a.duration;var d=$.browser.msie;var e=b.find(a.linkOpenName);var f=$('<div class="'+a.divFader+'"></div>');var g=$(a.wrapper).find("select");var h;$("body").append(f);f.css({position:"absolute",top:"0px",left:"0px",zIndex:999,background:"black",opacity:.7});e.click(function(){if($(this).attr("href"))i($(this).attr("href"));else i($(this).attr("title"));return false})})};

// event handler on DOM ready
	var _activeDrop;
	jQuery(function(){
		jQuery('body').click(hideOptionsClick)
		jQuery(window).resize(hideOptions)
	});
	function hideOptions() {
		if(_activeDrop && _activeDrop.length) {
			_activeDrop.hide();
			_activeDrop = null;
		}
	}
	function hideOptionsClick(e) {
		if(_activeDrop && _activeDrop.length) {
			var f = false;
			jQuery(e.target).parents().each(function(){
				if(this == _activeDrop) f=true;
			});
			if(!f) {
				_activeDrop.hide();
				_activeDrop = null;
			}
		}
	}
	function initCustomForms() {
//	jQuery('select').customSelect();
	//jQuery('input:radio').customRadio();
	//jQuery('input:checkbox').customCheckbox();
}
	



function initopenMultiple(){
	jQuery(".open-multiple, .title3").live("click",function(event){
			var $target = $(event.target);
			if($target.is("a") || $target.is("img")) {
				eventid = (event.target.id).split("_");
				callmultipleroom(eventid[0])
			} else if ($target.is("span")) {
				eventid = $target.next().children().attr("id").split("_");
				callmultipleroom(eventid[0])
			}
			
		});	
	
		jQuery(".open-multiple1, .title3").live("click",function(event){
			var $target = $(event.target);
			if($target.is("a") || $target.is("img") ||$target.is("div")) {
				eventid = (event.target.id).split("_");
				callmultipleroom(eventid[0])
			} else if ($target.is("span")) {
				eventid = $target.next().children().attr("id").split("_");
				callmultipleroom(eventid[0])
			}
			
		});	
		
	jQuery('.close_multiple').click(function(){
		jQuery('.multiple_room_details').css('display','none');
		jQuery('.disablebg').css('display','none');	
		document.getElementById("multiroom-loader").innerHTML = ""; 		
	})
}
function daysInMonth(month,year) {
var dd = new Date(year, month, 0);
return dd.getDate();
} 


$(function(){
var ua = $.browser;
	if ( ua.msie ) {
 		$('.note2,.note').click(function(){
		//alert('athulata nan ava.6666688888..');
		var hgt=$(window).height()+500;
				$(".fader").css({height:hgt});
		});
		
		if ( parseInt($.browser.version) < 8 ) {	
          $("div.choose-lang").click(function () {
          $(".showc").css({"display":"block","position": "absolute","top": "628px","margin-left": "-106px"});
          });
        }
		
	}
	
});

	
