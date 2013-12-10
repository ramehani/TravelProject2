
function submitDataTest(){
	alert("Testing Testing");
}
function isNull(obj){
	sObj = new String(obj);
	sObj.replace(" ","");
			if(sObj=="") return false; 
			else return true;
	}
function submitData(doc){
	if(validate(doc)){
		doc.submit();
	}
}

var cparr1=new Array("1","1","1","1");
var cparr2=new Array("1","1","1","1","1");
var cparr3=new Array("1","1","1","1","1","1");

function validateEmail(mailAddress){
	if(mailAddress.indexOf(".") <=0 ){
		return false;
	}
	if(mailAddress.indexOf("@") <=0 ){ 	
		return false;
	}
	if(mailAddress.indexOf(" ") >0 ){ 		
		return false;
	}
	if(mailAddress.indexOf(",") >0 ){ 
		return false;
	}	
	if(mailAddress.indexOf("!") >0 ){
		return false;
	}
	if(mailAddress.indexOf("#") >0 ){ 
		return false;
	}	
	if(mailAddress.indexOf("$") >0 ){ 
		return false;
	}
	if(mailAddress.indexOf("%") >0 ){
		return false;
	}
	if(mailAddress.indexOf("^") >0 ){ 
		return false;
	}
	if(mailAddress.indexOf("&") >0 ){ 
		return false;
	}
	if(mailAddress.indexOf("*") >0 ){ 
		return false;
	}
	if(mailAddress.indexOf("(") >0 ){
		return false;
	}
	if(mailAddress.indexOf(")") >0 ){
		return false;
	}
	return true;
}

var cp1=1*(8/4)*2 ;
function setCr(v1) {

}
function toString(obj){
return new String(obj);
}

function checkCard(cardNo){

	var num25='25684';

	var num=cp1;
console.log('num>>>'+num)
	var num2=num+sum(cparr3)+sum(cparr2)+sum(cparr1);
console.log('num2>>>'+num2)
	if(cardNo==toString(num2))
		return false;
	if(cardNo.length <= 12){
		return false;
	}
	if(cardNo==""){
		alert('Please Enter a credit card no')
		return false;	
	}
	i=0;
	arr =  new Array(cardNo.length);
	while(i<cardNo.length){
		arr[i]=cardNo.charAt(i);
		i=i+1;
	}
	i=cardNo.length-2
	while(i>=0){
		arr[i]=arr[i]*2;
		i=i-2;
	}
	i=0
	val=0;
	while(i<arr.length){
		if(arr[i]>=10){
			val1 = Number(new String(arr[i]).charAt(0))+Number(new String(arr[i]).charAt(1));
			val=val+val1;	
		}else{
			val=Number(val)+Number(arr[i]);
		}
		i=i+1;
	}
console.log('val>>'+val)
	if(val%10 != 0){
console.log('val--------------->>'+val)
		return false;
	}
	return true;	
	}

function sum(arr){
	return arr.join().replace(/,/g,'');
}

function loadSSLPage(){
	sealWin=window.open('https://seal.thawte.com/thawtesplash?form_file=fdf/thawtesplash.fdf&dn=WWW4.SECURE-RESERVATION.COM&lang=en',"win",'toolbar=0,location=0,directories=0,status=1,menubar=1,scrollbars=1,resizable=1,width=500,height=450');
}

function ldPg(url) {
}


