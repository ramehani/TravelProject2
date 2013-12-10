function closeMe() {
    self.close()
}
function windoPopNew(link){	
	window.open((link).replace('#',''));
}
function ForwardPage(cultureName) {
    var A = "forward";
    var B = "width=480,height=320";
    var C = "/Pages/Forward.htm?link=" + location;
    if (cultureName != undefined && cultureName != "en" && cultureName != "undefined") {
        C = "/Pages/Forward_" + cultureName + ".htm?link=" + location;
    }
    open(C, A, B)
};
var _id = 'lang-select';
var _innerEl = 'ul';
var _className = 'active';
var _hide = true;
var _menu;
var _nodes;

function initMenu(){
	_menu=document.getElementById(_id);
	if(_menu){
		_nodes=_menu.getElementsByTagName('a');
		_nodes2=_menu.getElementsByTagName('ul');
		for(t=0; t<_nodes2.length; t++){
			if(_nodes2[t].addEventListener)
			{
			_nodes2[t].addEventListener('mouseout',function (e) {
					if (!e) var e = window.event;
					var tg = (window.event) ? e.srcElement : e.target;
					if (tg.nodeName != 'UL') return;
					var reltg = (e.relatedTarget) ? e.relatedTarget : e.toElement;
					while (reltg != tg && reltg.nodeName != 'BODY')
						reltg= reltg.parentNode
					if (reltg== tg) return;
					this.parentNode.setAttribute("class",'')
					this.parentNode.lastChild.setAttribute("class",'choose-lang  hidec')
					//this.style.display="none";
			},true);
			}else{
			_nodes2[t].attachEvent('mouseout',function (e) {
					if (!e) var e = window.event;
					var tg = (window.event) ? e.srcElement : e.target;
					if (tg.nodeName != 'UL') return;
					var reltg = (e.relatedTarget) ? e.relatedTarget : e.toElement;
					while (reltg != tg && reltg.nodeName != 'BODY')
						reltg= reltg.parentNode
					if (reltg== tg) return;
					this.parentNode.setAttribute("class",'')
					this.parentNode.lastChild.setAttribute("class",'choose-lang  hidec')
					//this.style.display="none";
				});
			}
			}
		for(var i=0;i<_nodes.length;i++){
			if(_nodes[i].parentNode.parentNode.getElementsByTagName(_innerEl)[0]){
				_nodes[i].onclick=function(){
					if(this.parentNode.parentNode.className.indexOf(_className)!=-1){
						this.parentNode.parentNode.className=this.parentNode.parentNode.className.replace(_className,"");
						if(this.parentNode.className != "choose-lang2")
						this.parentNode.parentNode.lastChild.className = 'choose-lang  hidec'
						}else{
						if(_hide)hideLevels(this,_menu);
							this.parentNode.parentNode.className+=' '+_className;
							if(this.parentNode.className != "choose-lang2")
							this.parentNode.parentNode.lastChild.className ='choose-lang  showc'
						}
						return false;
					}
				}
			}
		}
}


function hideLevels(_this) {
    var _lis = _menu.getElementsByTagName('li');
    for (var i = 0; i < _lis.length; i++) {
        var _f = false;
        var _a = _lis[i].getElementsByTagName('a');
        for (var j = 0; j < _a.length; j++) {
            if (_a[j] == _this) _f = true;
        }
        if (!_f) _lis[i].className = _lis[i].className.replace(_className, "");
    }
}

if (window.addEventListener) {
    window.addEventListener("load", initMenu, false);
} else if (window.attachEvent) {
    window.attachEvent("onload", initMenu);
}

function CreateBookmarkLink(cultureName) {
    var myS = new String('Sample String');
    var B = document.title;
    var A = location.href;
    if (window.sidebar) {
        window.sidebar.addPanel(B, A, "");
    } else {
        if (window.external) {
            if (navigator.appName == "Netscape") {
                if (cultureName != undefined && cultureName != "undefined") {
                    if (cultureName == "en") {
                        alert("Unable to bookmark. Please bookmark the site manually.");
                    } else if (cultureName == "es") {
                        alert("No hemos podido establecer un marcador para www.travelstay.com. Por favor configurar manualmente un marcador.");
                    } else if (cultureName == "de") {
                        alert("Wir könnten einen Lesezeichen für www.travelstay.com nicht einrichten. Bitte richten Sie einen Lesezeichen manuell ein.");
                    } else if (cultureName == "fr") {
                        alert("Nous n'avons pas pu créer un signet pour www.travelstay.com. S'il vous plaît configurer manuellement un signet.");
                    } else if (cultureName == "it") {
                        alert("Non siamo riusciti a creare un preferito per www.travelstay.com. Si prega di impostare manualmente un preferito.");
                    } else if (cultureName == "pl") {
                        alert("Nie mozna dodac www.travelstay.com jako zakladki. Prosze zaznaczyc manulanie.");
                    } else {
                        alert("Unable to bookmark. Please bookmark the site manually.");
                    }
                } else {
                    alert("Unable to bookmark. Please bookmark the site manually.");
                }
            } else {
                window.external.AddFavorite(A, B);
            }
        } else {
            if (window.opera && window.print) {
                return true
            }
        }
    } 
};







/*
 
var _atd = "http://www.addthis.com/",
    _atr = "http://s7.addthis.com/",
    _euc = encodeURIComponent,
    _atu = "undefined",
    _ath = "",
    _atc = {
        sec: _atr.indexOf("https") === 0,
        ver: 200,
        enote: "",
        cwait: 500,
        samp: 0.01,
        vamp: 1,
        addr: 0.2,
        addt: 1,
        xfl: !! window.addthis_disable_flash
    };
try {
    _ath = document.location.hostname
} catch (e) {}
if (typeof (addthis_conf) === _atu) {
    var addthis_conf = {}
}
for (i in addthis_conf) {
    _atc[i] = addthis_conf[i]
}
if (typeof (_ate) === _atu) {
    (function () {
        var B = navigator.userAgent.toLowerCase(),
            K = document,
            P = window,
            F = P.addEventListener,
            C = P.attachEvent,
            H = K.location,
            M = {
                win: /windows/.test(B),
                chr: /chrome/.test(B),
                saf: (/webkit/.test(B)) && !(/chrome/.test(B)),
                opr: /opera/.test(B),
                msi: (/msie/.test(B)) && (!/opera/.test(B)),
                ie6: /msie 6.0/.test(B)
            },
            I = {
                isBound: false,
                isReady: false,
                readyList: [],
                onReady: function () {
                    if (!I.isReady) {
                        I.isReady = true;
                        var R = I.readyList;
                        for (var S = 0; S < R.length; S++) {
                            R[S].call(window, [])
                        }
                        I.readyList = []
                    }
                },
                addLoad: function (S) {
                    var R = P.onload;
                    if (typeof P.onload != "function") {
                        P.onload = S
                    } else {
                        P.onload = function () {
                            if (R) {
                                R()
                            }
                            S()
                        }
                    }
                },
                bindReady: function () {
                    if (A.isBound) {
                        return
                    }
                    A.isBound = true;
                    if (K.addEventListener && !M.opr) {
                        K.addEventListener("DOMContentLoaded", A.onReady, false)
                    }
                    if (M.msi && window == top) {
                        (function () {
                            if (A.isReady) {
                                return
                            }
                            try {
                                K.documentElement.doScroll("left")
                            } catch (S) {
                                setTimeout(arguments.callee, 0);
                                return
                            }
                            A.onReady()
                        })()
                    }
                    if (M.opr) {
                        K.addEventListener("DOMContentLoaded", function () {
                            if (A.isReady) {
                                return
                            }
                            for (var S = 0; S < K.styleSheets.length; S++) {
                                if (K.styleSheets[S].disabled) {
                                    setTimeout(arguments.callee, 0);
                                    return
                                }
                            }
                            A.onReady()
                        }, false)
                    }
                    if (M.saf) {
                        var R;
                        (function () {
                            if (A.isReady) {
                                return
                            }
                            if (K.readyState != "loaded" && K.readyState != "complete") {
                                setTimeout(arguments.callee, 0);
                                return
                            }
                            if (R === undefined) {
                                var U = K.getElementsByTagName("link");
                                for (var S = 0; S < U.length; S++) {
                                    if (U[S].getAttribute("rel") == "stylesheet") {
                                        R++
                                    }
                                }
                                var T = K.getElementsByTagName("style");
                                R += T.length
                            }
                            if (K.styleSheets.length != R) {
                                setTimeout(arguments.callee, 0);
                                return
                            }
                            A.onReady()
                        })()
                    }
                    A.addLoad(A.onReady)
                },
                append: function (R, S) {
                    A.bindReady();
                    if (A.isReady) {
                        R.call(window, [])
                    } else {
                        A.readyList.push(function () {
                            return R.call(window, [])
                        })
                    }
                }
            },
            A = I,
            E = {
                rev: "$Rev: 59117 $",
                ab: "-",
                bro: M,
                clck: 1,
                show: 1,
                dl: H,
                samp: _atc.samp - Math.random(),
                vamp: _atc.vamp - Math.random(),
                scnt: 1,
                seq: 1,
                inst: 1,
                wait: 500,
                tmo: null,
                cvt: [],
                svt: [],
                sttm: new Date().getTime(),
                max: 268435455,
                pix: "tev",
                sid: 0,
                sub: typeof (at_sub) !== _atu,
                uid: null,
                swf: "",
                evu: "http://e1.clearspring.com/at/",
                mun: function (T) {
                    var R = 291;
                    if (T) {
                        for (var S = 0; S < T.length; S++) {
                            R = (R * (T.charCodeAt(S) + S) + 3) & 1048575
                        }
                    }
                    return (R & 16777215).toString(32)
                },
                off: function () {
                    return Math.floor((new Date().getTime() - E.sttm) / 100).toString(16)
                },
                ran: function () {
                    return Math.floor(Math.random() * 4294967295).toString(36)
                },
                cst: function (R) {
                    return "CXNID=2000001.521545608054043907" + (R || 2) + "NXC"
                },
                img: function (R, S) {
                    if (typeof (at_sub) === _atu) {
                        new Image().src = _atr + "live/t00/" + R + ".gif?" + E.ran() + "&" + E.cst(S)
                    }
                },
                cuid: function () {
                    return (E.sttm & E.max).toString(16) + (Math.floor(Math.random() * E.max)).toString(16)
                },
                ssid: function () {
                    if (E.sid === 0) {
                        E.sid = E.cuid()
                    }
                    return E.sid
                },
                sev: function (S, R) {
                    E.pix = "sev-" + (typeof (S) !== "number" ? _euc(S) : S);
                    E.svt.push(S + ";" + E.off());
                    if (R === 1) {
                        E.xmi(true)
                    } else {
                        E.sxm(true)
                    }
                },
                cev: function (S, R) {
                    E.pix = "cev-" + _euc(S);
                    E.cvt.push(_euc(S) + "=" + _euc(R) + ";" + E.off());
                    E.sxm(true)
                },
                sxm: function (R) {
                    if (E.tmo !== null) {
                        clearTimeout(E.tmo)
                    }
                    if (R) {
                        E.tmo = E.sto("_ate.xmi(false)", E.wait)
                    }
                },
                sto: function (S, R) {
                    return setTimeout(S, R)
                },
                sta: function () {
                    var R = E;
                    return "AT-" + (typeof (addthis_pub) !== _atu ? _euc(addthis_pub) : "unknown") + "/-/" + R.ab + "/" + R.ssid() + "/" + (R.seq++) + (R.uid !== null ? "/" + R.uid : "")
                },
                xmi: function (V) {
                    var R = E,
                        U = R.dl ? R.dl.hostname : "";
                    if (!R.uid) {
                        R.dck("X" + R.cuid())
                    }
                    if (R.cvt.length + R.svt.length > 0) {
                        R.sxm(false);
                        if (R.seq === 1) {
                            R.cev("pin", R.inst)
                        }
                        var S = R.evu + R.pix + "-" + R.ran() + ".png?ev=" + E.sta() + "&se=" + R.svt.join(",") + "&ce=" + R.cvt.join(",");
                        R.cvt = [];
                        R.svt = [];
                        if (_atc.xtr || U.indexOf(".gov") > -1 || U.indexOf(".mil") > -1) {
                            _atc.xtr = 1;
                            return
                        }
                        if (V) {
                            var W = document,
                                T = W.ce("iframe");
                            T.id = "_atf";
                            T.src = S;
                            E.opp(T.style);
                            W.body.appendChild(T);
                            T = W.getElementById("_atf")
                        } else {
                            new Image().src = S
                        }
                    }
                },
                loc: function () {
                    try {
                        var R = window.location;
                        return (R.protocol.indexOf("file") === 0 || R.hostname.indexOf("localhost") != -1)
                    } catch (S) {}
                    return false
                },
                opp: function (R) {
                    R.width = "1px";
                    R.height = "1px";
                    R.position = "absolute";
                    R.zIndex = 100000
                },
                pub: function () {
                    return typeof (addthis_pub) !== _atu ? _euc(addthis_pub) : ""
                },
                lad: function (R) {
                    E.plo.push(R)
                },
                plo: [],
                jlo: function () {
                    try {
                        var V = document,
                            T = (window.addthis_language || (E.bro.msi ? navigator.userLanguage : navigator.language));
                        if (T && (T.toLowerCase()).indexOf("en") !== 0 && !E.pll) {
                            var U = V.ce("script");
                            U.src = _atr + "static/r05/lang02.js";
                            V.gn("head")[0].appendChild(U);
                            E.pll = U
                        }
                        if (!E.pld) {
                            var R = V.ce("script");
                            R.src = _atr + "static/r05/menu15.js";
                            V.gn("head")[0].appendChild(R);
                            E.pld = R
                        }
                    } catch (S) {}
                },
                lod: function (h) {
                    try {
                        var d = E,
                            g = 0,
                            X = h === 1,
                            U = K.referer || K.referrer,
                            R = H ? H.href : null,
                            V = R ? R.indexOf("sms_ss") : -1;
                        if (!X) {
                            if (d.samp >= 0 && !d.sub) {
                                d.sev("20");
                                d.cev("plo", Math.round(1 / _atc.samp));
                                if (U) {
                                    d.cev("pre", U);
                                    g = 1
                                }
                            }
                            if (V > -1) {
                                var T = R.substr(V),
                                    W = T.indexOf("&");
                                if (W > -1) {
                                    T = T.substr(0, W)
                                }
                                T = (T.split("="))[1];
                                if (d.vamp >= 0 && !d.sub && T.length) {
                                    d.cev("plv", Math.round(1 / _atc.vamp));
                                    d.cev("rsc", T)
                                }
                            }
                            d.img(_atc.ver + "lo", "2")
                        }
                        if (d.plo.length > 0) {
                            d.jlo()
                        }
                        if (E.samp >= 0) {
                            try {
                                var b = K.gn("a");
                                if (b) {
                                    for (var c in b) {
                                        c = b[c];
                                        if (c.toString().indexOf("/bookmark.php") > 0 && !c.onmouseover) {
                                            c.onmouseover = function () {
                                                return addthis_open(this, "", "", "")
                                            };
                                            c.onmouseout = function () {
                                                addthis_close()
                                            }
                                        }
                                    }
                                }
                            } catch (Z) {}
                        }
                        if (!_atc.xfl && !(d.loc()) && (X || d.uid === null) && d.swf) {
                            var Y = function (f, k, a) {
                                    var j = K.createElement("param");
                                    j.name = k;
                                    j.value = a;
                                    f.appendChild(j)
                                };
                            var S = K.createElement("object");
                            d.opp(S.style);
                            S.id = "atff";
                            if (M.msi) {
                                S.classid = "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000";
                                Y(S, "movie", d.swf)
                            } else {
                                S.data = d.swf;
                                S.quality = "high";
                                S.type = "application/x-shockwave-flash"
                            }
                            Y(S, "wmode", "transparent");
                            Y(S, "allowScriptAccess", "always");
                            K.body.insertBefore(S, K.body.firstChild);
                            if (M.msi) {
                                S.outerHTML += " "
                            }
                        }
                    } catch (Z) {}
                },
                unl: function () {
                    var R = E;
                    if (R.samp >= 0 && !R.sub) {
                        R.sev("21", 1);
                        R.cev("pun", 1 / _atc.samp)
                    }
                    return true
                },
                dck: function (U) {
                    E.uid = U;
                    var S = E.dl ? E.dl.hostname : "";
                    if (S.indexOf(".gov") > -1 || S.indexOf(".mil") > -1) {
                        _atc.xtr = 1;
                        return
                    }
                    var T = E.pub(),
                        R = "dodpubweb,usarmymedia,usagov,disamil,education,gobiernousa,loc_webservices,massgov,govgab1".split(",");
                    for (G in R) {
                        if (T == R[G]) {
                            return
                        }
                    }
                    if (!_atc.xck) {
                        document.cookie = "_csuid=" + U + "; expires=Wed, 04 Oct 2000 03:19:53 GMT; path=/"
                    }
                },
                fcl: null,
                asetup: function (R) {
                    var S = E;
                    try {
                        if (R !== null && R !== _atu) {
                            S.dck(R)
                        }
                        if (S.fcl) {
                            S.fcl()
                        }
                    } catch (T) {}
                    return R
                },
                ao: function (R, U, T, S) {
                    E.lad(["open", R, U, T, S]);
                    E.jlo();
                    return false
                },
                ac: function () {},
                as: function (R) {
                    E.lad(["send", R]);
                    E.jlo()
                }
            },
            O = E;
        P._ate = O;
        P._adr = A;
        K.ce = K.createElement;
        K.gn = K.getElementsByTagName;
        A.bindReady();
        if (F) {
            F("unload", O.unl, false)
        } else {
            if (C) {
                C("onunload", O.unl)
            } else {
                P.onunload = O.unl
            }
        }
        A.append(O.lod);
        if (K.cookie) {
            var Q = K.cookie.split(";");
            for (var G = 0; G < Q.length; G++) {
                var L = Q[G],
                    N = L.indexOf("_csuid=");
                if (N >= 0) {
                    E.uid = L.substring(N + 7)
                }
            }
        }
        try {
            var D = K.ce("link");
            D.rel = "stylesheet";
            D.type = "text/css";
            D.href = _atr + "static/r05/widget07.css";
            D.media = "all";
            K.gn("head")[0].appendChild(D)
        } catch (J) {}
    })();

    function addthis_to(A) {
        return addthis_sendto(A)
    }
    function addthis_onmouseover(D, E, A, G, F, C, B) {
        if (F) {
            addthis_pub = F
        }
        if (C) {
            addthis_language = C
        }
        addthis_content = B || "";
        return addthis_open(D, "share", A, G)
    }
    function addthis_onmouseout() {
        addthis_close()
    }
    function addthis_open(A, D, C, B) {
        return _ate.ao(A, D, C, B)
    }
    function addthis_close() {
        _ate.ac()
    }
    function addthis_invoke(E, C, D, F) {
        addthis_pub = F || _ate.pub();
        addthis_url = (C || B.addthis_url);
        addthis_title = (D || B.addthis_title);
        var B = window,
            G = addthis_url.toLowerCase(),
            A = addthis_title.toLowerCase();
        if (G === "" || G === "[url]") {
            addthis_url = location.href
        }
        if (A === "" || A === "[title]") {
            addthis_title = document.title
        }
        _ate.as(E);
        return false
    }
    function addthis_sendto(A) {
        _ate.as(A);
        return false
    }
} else {
    _ate.inst++
}
try {
    if (_atc.ver === 120) {
        function x(v, n) {
            return eval("(" + v + "=(typeof " + v + " === '" + _atu + "' ? '" + (n || "") + "' : " + v + "))")
        }
        var r = "atb" + _ate.cuid();
        document.write('<span id="' + r + '"></span>');
        _ate.lad(["span", r, x("addthis_url", ""), x("addthis_title", "")])
    }
    if (window.addthis_clickout) {
        _ate.lad(["cout"])
    }
} catch (e) {};
 */