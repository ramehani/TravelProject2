(function(){var f=this;var h=parseFloat("0.06"),k=isNaN(h)||1<h||0>h?0:h;var l=function(a,b){for(var d in a)Object.prototype.hasOwnProperty.call(a,d)&&b.call(null,a[d],d,a)};var m,n,p,q,r=function(){return f.navigator?f.navigator.userAgent:null};q=p=n=m=!1;var s;if(s=r()){var t=f.navigator;m=0==s.lastIndexOf("Opera",0);n=!m&&(-1!=s.indexOf("MSIE")||-1!=s.indexOf("Trident"));p=!m&&-1!=s.indexOf("WebKit");q=!m&&!p&&!n&&"Gecko"==t.product}var u=n,v=q,w=p;var x;if(m&&f.opera){var y=f.opera.version;"function"==typeof y&&y()}else v?x=/rv\:([^\);]+)(\)|;)/:u?x=/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/:w&&(x=/WebKit\/(\S+)/),x&&x.exec(r());var z=function(a){this.b=[];this.a={};for(var b=0,d=arguments.length;b<d;++b)this.a[arguments[b]]=""},B=function(){var a=A,b="317150500 317150501 317150502 317150503 317150504 317150505".split(" "),d;if(d=a.a.hasOwnProperty(1)&&""==a.a[1])d=!(1E-4>Math.random())&&Math.random()<k;d&&(b=b[Math.floor(Math.random()*b.length)],""!=b&&a.a.hasOwnProperty(1)&&(a.a[1]=b))};z.prototype.c=function(a){return this.a.hasOwnProperty(a)?this.a[a]:""};z.prototype.geil=z.prototype.c;
var C=function(){var a=A,b=[];l(a.a,function(a){""!=a&&b.push(a)});return 0<a.b.length&&0<b.length?a.b.join(",")+","+b.join(","):a.b.join(",")+b.join(",")};var A,D="google_conversion_id google_conversion_format google_conversion_type google_conversion_order_id google_conversion_language google_conversion_value google_conversion_domain google_conversion_label google_conversion_color google_disable_viewthrough google_remarketing_only google_remarketing_for_search google_conversion_items google_custom_params google_conversion_date google_conversion_time google_conversion_js_version onload_callback opt_image_generator google_is_call google_conversion_page_url".split(" ");
function E(a){return null!=a?escape(a.toString()):""}function F(a,b){var d=E(b);if(""!=d){var c=E(a);if(""!=c)return"&".concat(c,"=",d)}return""}function H(a){var b=typeof a;return null==a||"object"==b||"function"==b?null:String(a).replace(/,/g,"\\,").replace(/;/g,"\\;").replace(/=/g,"\\=")}
function I(a){var b;if((a=a.google_custom_params)&&"object"==typeof a&&"function"!=typeof a.join){var d=[];for(b in a)if(Object.prototype.hasOwnProperty.call(a,b)){var c=a[b];if(c&&"function"==typeof c.join){for(var e=[],g=0;g<c.length;++g){var G=H(c[g]);null!=G&&e.push(G)}c=0==e.length?null:e.join(",")}else c=H(c);(e=H(b))&&null!=c&&d.push(e+"="+c)}b=d.join(";")}else b="";return""==b?"":"&".concat("data=",encodeURIComponent(b))}
function J(a){return"number"!=typeof a&&"string"!=typeof a?"":E(a.toString())}function K(a){if(!a)return"";a=a.google_conversion_items;if(!a)return"";for(var b=[],d=0,c=a.length;d<c;d++){var e=a[d],g=[];e&&(g.push(J(e.value)),g.push(J(e.quantity)),g.push(J(e.item_id)),g.push(J(e.adwords_grouping)),g.push(J(e.sku)),b.push("("+g.join("*")+")"))}return 0<b.length?"&item="+b.join(""):""}
function L(a,b,d){var c=[];if(a){var e=a.screen;e&&(c.push(F("u_h",e.height)),c.push(F("u_w",e.width)),c.push(F("u_ah",e.availHeight)),c.push(F("u_aw",e.availWidth)),c.push(F("u_cd",e.colorDepth)));a.history&&c.push(F("u_his",a.history.length))}d&&"function"==typeof d.getTimezoneOffset&&c.push(F("u_tz",-d.getTimezoneOffset()));b&&("function"==typeof b.javaEnabled&&c.push(F("u_java",b.javaEnabled())),b.plugins&&c.push(F("u_nplug",b.plugins.length)),b.mimeTypes&&c.push(F("u_nmime",b.mimeTypes.length)));
return c.join("")}function M(a,b,d){var c="";if(b){var c=c+F("ref",null!=b.referrer?b.referrer.toString().substring(0,256):""),e;if(a.top==a)e=0;else if(b=a.location.ancestorOrigins)e=b[b.length-1]==a.location.origin?1:2;else{b=a.top;try{e=!!b.location.href||""===b.location.href}catch(g){e=!1}e=e?1:2}b="";b=d?d:1==e?a.top.location.href:a.location.href;c+=F("url",null!=b?b.toString().substring(0,256):"");c+=F("frm",e)}return c}
function N(a){return a&&a.location&&a.location.protocol&&"https:"==a.location.protocol.toString().toLowerCase()?"https:":"http:"}function O(a){return a.google_remarketing_only?"googleads.g.doubleclick.net":a.google_conversion_domain||"www.googleadservices.com"}
function P(a,b,d,c){var e="/?";"landing"==c.google_conversion_type&&(e="/extclk?");var e=N(a)+"//"+O(c)+"/pagead/"+[c.google_remarketing_only?"viewthroughconversion/":"conversion/",E(c.google_conversion_id),e,"random=",E(c.google_conversion_time)].join(""),g;r:{g=c.google_conversion_language;if(null!=g){g=g.toString();if(2==g.length){g=F("hl",g);break r}if(5==g.length){g=F("hl",g.substring(0,2))+F("gl",g.substring(3,5));break r}}g=""}return e+=[F("cv",c.google_conversion_js_version),F("fst",c.google_conversion_first_time),
F("num",c.google_conversion_snippets),F("fmt",c.google_conversion_format),F("value",c.google_conversion_value),F("label",c.google_conversion_label),F("oid",c.google_conversion_order_id),F("bg",c.google_conversion_color),g,F("guid","ON"),F("disvt",c.google_disable_viewthrough),F("is_call",c.google_is_call),K(c),L(a,b,c.google_conversion_date),M(a,d,c.google_conversion_page_url),I(c),c.google_remarketing_for_search&&!c.google_conversion_domain?"&srr=n":"",F("eid",C())].join("")}
function Q(){var a=R,b=S,d=N(a)+"//www.google.com/ads/user-lists/"+[E(b.google_conversion_id),"/?random=",Math.floor(1E9*Math.random())].join("");return d+=[F("label",b.google_conversion_label),F("fmt","3"),M(a,document,b.google_conversion_page_url)].join("")}
function T(){var a=R,b=navigator,d=document,c=R;3!=c.google_conversion_format||c.google_remarketing_only||c.google_conversion_domain||A&&B();var e=A?A.c(1):"",b=P(a,b,d,c),d=function(a,b,c){return'<img height="'+c+'" width="'+b+'" border="0" alt="" src="'+a+'" />'};return 0==c.google_conversion_format&&null==c.google_conversion_domain?'<a href="'+(N(a)+"//services.google.com/sitestats/"+({ar:1,bg:1,cs:1,da:1,de:1,el:1,en_AU:1,en_US:1,en_GB:1,es:1,et:1,fi:1,fr:1,hi:1,hr:1,hu:1,id:1,is:1,it:1,iw:1,
ja:1,ko:1,lt:1,nl:1,no:1,pl:1,pt_BR:1,pt_PT:1,ro:1,ru:1,sk:1,sl:1,sr:1,sv:1,th:1,tl:1,tr:1,vi:1,zh_CN:1,zh_TW:1}[c.google_conversion_language]?c.google_conversion_language+".html":"en_US.html")+"?cid="+E(c.google_conversion_id))+'" target="_blank">'+d(b,135,27)+"</a>":1<c.google_conversion_snippets||3==c.google_conversion_format?"317150501"==e||"317150502"==e||"317150503"==e||"317150504"==e||"317150505"==e?d(b,1,1)+('<script src="'+b.replace(/(&|\?)fmt=3(&|$)/,"$1fmt=4&adtest=on$2")+'">\x3c/script>'):
d(b,1,1):'<iframe name="google_conversion_frame" title="Google conversion frame" width="'+(2==c.google_conversion_format?200:300)+'" height="'+(2==c.google_conversion_format?26:13)+'" src="'+b+'" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no">'+d(b.replace(/\?random=/,"?frame=0&random="),1,1)+"</iframe>"}function U(){return new Image}
function V(){var a=S,b=Q(),d=U;"function"===typeof a.opt_image_generator&&(d=a.opt_image_generator);a=d();b+=F("async","1");a.src=b;a.onload=function(){}};var R=window;
if(R)if(null!=/[\?&;]google_debug/.exec(document.URL)){var aa=R,W=document.getElementsByTagName("head")[0];W||(W=document.createElement("head"),document.getElementsByTagName("html")[0].insertBefore(W,document.getElementsByTagName("body")[0]));var X=document.createElement("script");X.src=N(window)+"//"+O(aa)+"/pagead/conversion_debug_overlay.js";W.appendChild(X)}else{try{var Y;var Z=R;"landing"==Z.google_conversion_type||!Z.google_conversion_id||Z.google_remarketing_only&&Z.google_disable_viewthrough?Y=
!1:(Z.google_conversion_date=new Date,Z.google_conversion_time=Z.google_conversion_date.getTime(),Z.google_conversion_snippets="number"==typeof Z.google_conversion_snippets&&0<Z.google_conversion_snippets?Z.google_conversion_snippets+1:1,"number"!=typeof Z.google_conversion_first_time&&(Z.google_conversion_first_time=Z.google_conversion_time),Z.google_conversion_js_version="7",0!=Z.google_conversion_format&&1!=Z.google_conversion_format&&2!=Z.google_conversion_format&&3!=Z.google_conversion_format&&
(Z.google_conversion_format=1),A=new z(1),Y=!0);if(Y&&(document.write(T()),R.google_remarketing_for_search&&!R.google_conversion_domain)){var S=R;V()}}catch(ba){}for(var ca=R,$=0;$<D.length;$++)ca[D[$]]=null};})();
