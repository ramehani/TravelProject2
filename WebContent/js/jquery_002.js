function addPrice(st,ed){
				stPrice = st; 
				edPrice = ed;
				}
			
function callFilters(){
		addFiltersFromUrl();
		if(isNaN(stPrice)){
			stPrice = 0; 
			edPrice = 300;
		}			
		}		
			
$(document).ready(function (){
	callFilters();
	$("#slider").slider({
		range:true,
		min:0,
		max:1000,
		values:[stPrice,edPrice],
		slide:function(a,b){
			$("#slider").parent().find(".label-min").text("$"+""+b.values[0]);
			$("#slider").parent().find(".label-max").text("$"+""+b.values[1])
			},
		stop: function(event, ui) {
		slider(jQuery("#slider").slider( "values", 0 ),jQuery("#slider").slider( "values", 1 ))
		}
	});
	//$("#slider").parent().find(".label-min").text(String.fromCharCode(163)+""+$("#slider").slider("values",0));
	//$("#slider").parent().find(".label-max").text(String.fromCharCode(163)+""+$("#slider").slider("values",1))
	$("#slider").parent().find(".label-min").text("$"+""+$("#slider").slider("values",0));
	$("#slider").parent().find(".label-max").text("$"+""+$("#slider").slider("values",1))
});
