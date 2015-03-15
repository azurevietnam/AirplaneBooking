var d = document;
var l = d.layers;
var op = navigator.userAgent.indexOf('Opera') != -1;
var px = 'px';
function gE(e, f) {
    var t;
    if (l) {
        f = (f) ? f: self;
        var V = f.document.layers;
        if (V[e]) return V[e];
        for (var W = 0; W < V.length;) t = gE(e, V[W++]);
        return t;
    }
    if (d.all) return d.all[e];
    return d.getElementById(e);
}
function sE(e) {
    l ? e.visibility = 'show': e.style.visibility = 'visible';
}
function hE(e) {
    l ? e.visibility = 'hide': e.style.visibility = 'hidden';
}
function sZ(e, z) {
    l ? e.zIndex = z: e.style.zIndex = z;
}
function sX(e, x) {
    l ? e.left = x: op ? e.style.pixelLeft = x: e.style.left = x + px;
}
function sY(e, y) {
    l ? e.top = y: op ? e.style.pixelTop = y: e.style.top = y + px;
}
function sW(e, w) {
    l ? e.clip.width = w: op ? e.style.pixelWidth = w: e.style.width = w + px;
}
function sH(e, h) {
    l ? e.clip.height = h: op ? e.style.pixelHeight = h: e.style.height = h + px;
}
function sC(e, t, r, b, x) {
    l ? (X = e.clip, X.top = t, X.right = r, X.bottom = b, X.left = x) : e.style.clip = 'rect(' + t + px + ' ' + r + px + ' ' + b + px + ' ' + x + px + ')';
}
function wH(e, h) {
    if (l) {
        Y = e.document;
        Y.open();
        Y.write(h);
        Y.close();
    }
    if (e.innerHTML) e.innerHTML = h;
}
var digits = "0123456789";
var whitespace = " \t\n\r";
function isEmpty(s) {
    return ((s == null) || (s.length == 0));
}
function isDigit(c) {
    return ((c >= "0") && (c <= "9"));
}
function isWhitespace(s) {
    var i;
    if (isEmpty(s)) return true;
    for (i = 0; i < s.length; i++) {
        var c = s.charAt(i);
        if (whitespace.indexOf(c) == -1) return false;
    }
    return true;
}
function isInteger(s) {
    var i;
    if (isEmpty(s)) if (isInteger.arguments.length == 1) return false;
    else return (isInteger.arguments[1] == true);
    for (i = 0; i < s.length; i++) {
        var c = s.charAt(i);
        if (!isDigit(c)) return false;
    }
    return true;
}
function isEmail(s) {
    if (isEmpty(s)) if (isEmail.arguments.length == 1) return false;
    else return (isEmail.arguments[1] == true);
    if (isWhitespace(s)) return false;
    var i = 1;
    var sLength = s.length;
    while ((i < sLength) && (s.charAt(i) != "@")) {
        i++
    }
    if ((i >= sLength) || (s.charAt(i) != "@")) return false;
    else i += 2;
    while ((i < sLength) && (s.charAt(i) != ".")) {
        i++
    }
    if ((i >= sLength - 1) || (s.charAt(i) != ".")) return false;
    else return true;
}
function str2dt4(str_datetime) {
    var re_date = /^(\d+)\/(\d+)\/(\d+)$/;
    if (!re_date.exec(str_datetime)) return new Date();
    return (new Date(RegExp.$1, RegExp.$2 - 1, RegExp.$3));
}
function gbValidate(sOrigAptAbbr, sDestAptAbbr, iResMinPax, iResMaxPax, iAgMinPax, iAgMaxPax, iDfltMinPax, iDfltMaxPax, sAlertMinPax, sAlertMaxPax, iNumAdults, iNumChildren) {
    var iTtlPax;
    var iMinPax;
    var iCityPrMinPax;
    var iCityPrMaxPax;
    if (iAgMinPax == "") {
        iAgMinPax = -1;
        iAgMaxPax = -1;
    }
    for (i = 0; i < aDests.length; i++) {
        if (aDests[i]['OrigAbbr'] == sOrigAptAbbr && aDests[i]['Abbr'] == sDestAptAbbr) {
            iCityPrMinPax = aDests[i]['GBMinPax'];
            iCityPrMaxPax = aDests[i]['GBMaxPax'];
        }
    }
    switch (true) {
    case iResMinPax > -1: iMinPax = iResMinPax;
        iMaxPax = iResMaxPax;
        break;
    case iCityPrMinPax > -1: iMinPax = iCityPrMinPax;
        iMaxPax = iCityPrMaxPax;
        break;
    case iAgMinPax > -1: iMinPax = iAgMinPax;
        iMaxPax = iAgMaxPax;
        break;
    default:
        iMinPax = iDfltMinPax;
        iMaxPax = iDfltMaxPax;
        break;
    }
    sAlertMinPax = sAlertMinPax.replace("{subst}", iMinPax);
    sAlertMaxPax = sAlertMaxPax.replace("{subst}", iMaxPax);
    if (iNumAdults != -1) {
        iTtlPax = parseInt(iNumAdults) + parseInt(iNumChildren);
    } else {
        iTtlPax = parseInt(document.forms[0].txtNumAdults.value) + parseInt(document.forms[0].txtNumChildren.value);
    }
    if (iTtlPax < iMinPax) {
        alert(sAlertMinPax);
    } else if ((iMaxPax != -1) && (iTtlPax > iMaxPax)) {
        alert(sAlertMaxPax);
    } else if (iNumAdults != -1) {
        SubmitForm();
    } else {
        SubmitFormVF();
    }
}
function validateGBResPayment(dPaymentAmount, dAmountOwe, dMinimumPercent, sAlertMinPay, sIsGroupBk, sAmtPay) {
    var dMinimumAllowed;
    if (sIsGroupBk == "y" && sAmtPay == "y") {
        dMinimumAllowed = Math.round((dAmountOwe * dMinimumPercent) * 100) / 100;
        if (sAmtPay == "y") {
            dPaymentAmount = parseFloat(document.forms[0].txtTotalAmt.value);
        }
        if (dPaymentAmount < dMinimumAllowed) {
            sAlertMinPay = sAlertMinPay.replace("{subst}", dMinimumAllowed);
            alert(sAlertMinPay);
        } else {
            SubmitForm();
        }
    } else {
        SubmitForm();
    }
}
var arr_months;
var week_days;
var n_weekstart;
var ctrl_day;
var ctrl_month;
var str_styles = "";
var str_dflt_style = ".wke{background:#DBEAF5;text-align:right;font-size:9pt;}" + ".wkd{background:#fff;text-align:right;font-size:9pt;}";
datepicker_init('en');
function show_calendar(str_target, str_datetime) {
    var dt_datetime = (str_datetime == null || str_datetime == "" || str_datetime == "/" ? new Date() : str2dt4(str_datetime));
    var dt_prev_month = new Date(dt_datetime);
    ctrl_day = new String("window.opener.document.getElementById('" + str_target + "_Day')");
    ctrl_month = new String("window.opener.document.getElementById('" + str_target + "_Month')");
    dt_prev_month.setMonth(dt_datetime.getMonth() - 1);
    if (dt_datetime.getMonth() % 12 != (dt_prev_month.getMonth() + 1) % 12) {
        dt_prev_month.setMonth(dt_datetime.getMonth());
        dt_prev_month.setDate(0);
    }
    var dt_next_month = new Date(dt_datetime);
    dt_next_month.setMonth(dt_datetime.getMonth() + 1);
    if ((dt_datetime.getMonth() + 1) % 12 != dt_next_month.getMonth() % 12) dt_next_month.setDate(0);
    var dt_firstday = new Date(dt_datetime);
    dt_firstday.setDate(1);
    dt_firstday.setDate(1 - (7 + dt_firstday.getDay() - n_weekstart) % 7);
    var dt_lastday = new Date(dt_next_month);
    dt_lastday.setDate(0);
    var str_buffer = new String("<html><head><title>Calendar</title>\n" + "<script>\n" + "  var dt_new = new Date('" + dt_datetime + "');\n" + "  var dt_diff=new Date();\n" + "  var i_months = ((12-dt_diff.getMonth()+dt_new.getMonth())%12);\n" + "</script>\n" + "<style>body{background:white;font-family:Tahoma,Helvetica,sans-serif}\n" + "table{padding:0;border-width:1px;width:100%;}\ntd{padding:3px;}" + ".wkd, .wke {color:#ccc;font-size:9pt}\n" + ".wkd a,.wke a{color:#000;}\n" + str_styles + "</style>\n" + "</head>\n" + "<body>\n" + "<table class=\"clsOTable\">\n" + "<tr><td bgcolor=\"#4682B4\">\n" + "<table cellspacing=\"1\" >\n" + "<tr>\n	<td bgcolor=\"#4682B4\"><a href=\"javascript:window.opener.show_calendar('" + str_target + "', '" + dt2dtstr4(dt_prev_month) + "');\">" + "<img src=\"images/prev.gif\" width=\"16\" height=\"16\" border=\"0\"" + " alt=\"previous month\"></a></td>\n" + "	<td bgcolor=\"#4682B4\" colspan=\"5\">" + "<font color=\"white\">" + arr_months[dt_datetime.getMonth()] + " " + dt_datetime.getFullYear() + "</font></td>\n" + "	<td bgcolor=\"#4682B4\" align=\"right\"><a href=\"javascript:window.opener.show_calendar('" + str_target + "', '" + dt2dtstr4(dt_next_month) + "');\">" + "<img src=\"images/next.gif\" width=\"16\" height=\"16\" border=\"0\"" + " alt=\"next month\"></a></td>\n</tr>\n");
    var dt_current_day = new Date(dt_firstday);
    str_buffer += "<tr>\n";
    for (var n = 0; n < 7; n++) str_buffer += "	<td bgcolor=\"#87CEFA\">" + "<font color=\"white\" size=\"2\">" + week_days[(n_weekstart + n) % 7] + "</font></td>\n";
    str_buffer += "</tr>\n";
    while (dt_current_day.getMonth() == dt_datetime.getMonth() || dt_current_day.getMonth() == dt_firstday.getMonth()) {
        str_buffer += "<tr>\n";
        for (var n_current_wday = 0; n_current_wday < 7; n_current_wday++) {
            if (dt_current_day.getDay() == 0 || dt_current_day.getDay() == 6) str_buffer += "	<td class=\"wke\">";
            else str_buffer += "	<td class=\"wkd\">";
            if (dt_current_day.getMonth() == dt_datetime.getMonth()) str_buffer += "<a href=\"javascript:" + setcombos(str_target, dt_current_day) + "(i_months + 1); window.close();\">" + dt_current_day.getDate() + "</a></td>\n";
            else str_buffer += "" + dt_current_day.getDate() + "</td>\n";
            dt_current_day.setDate(dt_current_day.getDate() + 1);
        }
        str_buffer += "</tr>\n";
    }
    str_buffer += "</table>\n" + "</tr>\n</td>\n</table>\n" + "</body>\n" + "</html>\n";
    var vWinCal = window.open("", "Calendar", "width=200,height=250,status=no,resizable=yes,top=200,left=200");
    vWinCal.opener = self;
    vWinCal.focus();
    var calc_doc = vWinCal.document;
    calc_doc.write(str_buffer);
    calc_doc.close();
}
function dt2dtstr4(dt_datetime) {
    return (new String((dt_datetime.getFullYear() + "/" + (dt_datetime.getMonth() + 1) + "/" + dt_datetime.getDate())));
}
function datepicker_init(langcode) {
    switch (langcode) {
    case 'en':
        arr_months = "January,February,March,April,May,June,July,August,September,October,November,December".split(",");
        week_days = "Su,Mo,Tu,We,Th,Fr,Sa".split(",");
        n_weekstart = 6;
        str_styles = str_dflt_style;
        break;
    case 'ar':
        arr_months = "&#1610;&#1606;&#1575;&#1610;&#1585;,&#1601;&#1576;&#1585;&#1575;&#1610;&#1585;,&#1605;&#1575;&#1585;&#1587;,&#1575;&#1576;&#1585;&#1610;&#1604;,&#1605;&#1575;&#1610;&#1608;,&#1610;&#1608;&#1606;&#1610;&#1608;,&#1610;&#1608;&#1604;&#1610;&#1608;,&#1571;&#1594;&#1587;&#1591;&#1587;,&#1587;&#1576;&#1578;&#1605;&#1576;&#1585;,&#1606;&#1608;&#1601;&#1605;&#1576;&#1585;,&#1571;&#1603;&#1578;&#1608;&#1576;&#1585;,&#1583;&#1610;&#1587;&#1605;&#1576;&#1585;".split(",");
        week_days = "Su,Mo,Tu,We,Th,Fr,Sa".split(",");
        n_weekstart = 6;
        str_styles = "\n.clsOTable{direction:rtl;}" + "\n.wke,.wkd{background:white;text-align:right;font-size:9pt;}";
        break;
    default:
        break;
    }
}
function setcombos(str_control, dt_datetime) {
    return ctrl_day + ".selectedIndex=" + dt_datetime.getDate() + ";" + ctrl_month + ".selectedIndex=";
}
function changeDates(dp, rt) {
    var dm = gE(dp + "_Month");
    var rm = gE(rt + "_Month");
    var dln = dm.value.length;
    var mth = dm.value.substring(dln - 2, dln);
    rm.selectedIndex = dm.selectedIndex;
    var day = parseInt(gE(dp + "_Day").value, 10) + 3;
    var d = new Date(dm.value + "/" + day);
    gE(rt + "_Day").selectedIndex = d.getDate() - 1;
    if (d.getMonth() + 1 > parseInt(mth, 10)) {
        rm.selectedIndex += 1;
    }
}
var waitwin = null;
var gPopupMask = null;
var gPopupContainer = null;
var gPopFrame = null;
var gReturnFunc;
var gPopupIsShown = false;
var gDefaultPage = null;
var gHideSelects = false;
var gReturnVal = null;
var gTabIndexes = new Array();
var gTabbableTags = new Array("A", "BUTTON", "TEXTAREA", "INPUT", "IFRAME");

// This function will parse out all query param variables
// in the url and put them in a an associative array
// NOTE: This function is only used for the initPopUp() function for now.
function getURLParams() {
	var params = [], hash;
	var hashes = window.location.href.slice( window.location.href.indexOf('?') + 1).split('&');
	for (var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		params.push(hash[0]);
		params[hash[0]] = hash[1];
	}
	return params;
}

function showPopWin() 
{
	$('body').addClass("loading");
}

function hidePopup() 
{
	$('body').removeClass("loading");
}

function initPopUp() {
	var theLang = (getURLParams()['lang']!=undefined) ? getURLParams()['lang'] : 'en';
    theBody = document.getElementsByTagName('BODY')[0];
    popmask = document.createElement('div');
    popmask.id = 'popupMask';
    popcont = document.createElement('div');
    popcont.id = 'popupContainer';
    popcont.innerHTML = '' + '<div id="popupOuter">' + '<div id="popupInner">' + '<iframe src="' + gDefaultPage + '?lang=' + theLang + '" style="width:100%;height:100%;" scrolling="auto" frameborder="0" allowtransparency="true" id="popupFrame" name="popupFrame" width="100%" height="100%"></iframe>' + '</div>' + '</div>';
    theBody.appendChild(popmask);
    theBody.appendChild(popcont);
    gPopupMask = document.getElementById("popupMask");
    gPopupContainer = document.getElementById("popupContainer");
    gPopFrame = document.getElementById("popupFrame");
    var brsVersion = parseInt(window.navigator.appVersion.charAt(0), 10);
    if (brsVersion <= 6 && window.navigator.userAgent.indexOf("MSIE") > -1) {
        gHideSelects = true;
    }
}

function popWin(url, width, height) 
{
	if (document.getElementById("popupFrame") == null){
		initPopUp()
	}
	
	gPopFrame.src = url;
	document.getElementById("popupFrame").style.display = "block";
	gPopupContainer.style.display = "block";
	gPopupIsShown = true;
	disableTabIndexes();
	gPopupMask.style.display = "block";
	centerPopWin(width, height);
	gPopupContainer.style.width = width + "px";
	gPopupContainer.style.height = height + "px";
	setMaskSize();	
	gPopFrame.style.width = (width) + "px";
	gPopFrame.style.height = (height) + "px";
	
	if (gHideSelects == true) 
	{
		hideSelectBoxes();
	}

}

function setMaskSize() {
    var theBody = document.getElementsByTagName("BODY")[0];
    var fullHeight = getViewportHeight();
    var fullWidth = getViewportWidth();
    if (fullHeight > theBody.scrollHeight) {
        popHeight = fullHeight;
    } else {
        popHeight = theBody.scrollHeight;
    }
    if (fullWidth > theBody.scrollWidth) {
        popWidth = fullWidth;
    } else {
        popWidth = theBody.scrollWidth;
    }
    gPopupMask.style.height = popHeight + "px";
    gPopupMask.style.width = popWidth + "px";
}

function centerPopWin(width, height) {
    if (gPopupIsShown == true) {
        if (width == null || isNaN(width)) {
            width = gPopupContainer.offsetWidth;
        }
        if (height == null) {
            height = gPopupContainer.offsetHeight;
        }
        var theBody = document.getElementsByTagName("BODY")[0];
        var scTop = parseInt(getScrollTop(), 10);
        var scLeft = parseInt(theBody.scrollLeft, 10);
        setMaskSize();
        var titleBarHeight = 0;
        var fullHeight = getViewportHeight();
        var fullWidth = getViewportWidth();
        gPopupContainer.style.top = (scTop + ((fullHeight - (height + titleBarHeight)) / 2)) + "px";
        gPopupContainer.style.left = (scLeft + ((fullWidth - width) / 2)) + "px";
    }
}

function setPopTitle() {
    if (window.frames["popupFrame"].document.title == null || window.frames["popupFrame"].document.title == '') {
        window.setTimeout("setPopTitle();", 10);
    } else {
        document.getElementById("popupTitle").innerHTML = window.frames["popupFrame"].document.title;
    }
}

function disableTabIndexes() {
    if (document.all) {
        var i = 0;
        for (var j = 0; j < gTabbableTags.length; j++) {
            var tagElements = document.getElementsByTagName(gTabbableTags[j]);
            for (var k = 0; k < tagElements.length; k++) {
                gTabIndexes[i] = tagElements[k].tabIndex;
                tagElements[k].tabIndex = "-1";
                i++;
            }
        }
    }
}

function addEvent(obj, evType, fn) {
    if (obj.addEventListener) {
        obj.addEventListener(evType, fn, false);
        return true;
    } else if (obj.attachEvent) {
        var r = obj.attachEvent("on" + evType, fn);
        return r;
    } else {
        return false;
    }
}
function removeEvent(obj, evType, fn, useCapture) {
    if (obj.removeEventListener) {
        obj.removeEventListener(evType, fn, useCapture);
        return true;
    } else if (obj.detachEvent) {
        var r = obj.detachEvent("on" + evType, fn);
        return r;
    } else {
        alert("Handler could not be removed");
    }
}
function getViewportHeight() {
    if (window.innerHeight != window.undefined) return window.innerHeight;
    if (document.compatMode == 'CSS1Compat') return document.documentElement.clientHeight;
    if (document.body) return document.body.clientHeight;
    return window.undefined;
}
function getViewportWidth() {
    var offset = 17;
    var width = null;
    if (window.innerWidth != window.undefined) return window.innerWidth;
    if (document.compatMode == 'CSS1Compat') return document.documentElement.clientWidth;
    if (document.body) return document.body.clientWidth;
}
function getScrollTop() {
    if (self.pageYOffset) {
        return self.pageYOffset;
    } else if (document.documentElement && document.documentElement.scrollTop) {
        return document.documentElement.scrollTop;
    } else if (document.body) {
        return document.body.scrollTop;
    }
}
function getScrollLeft() {
    if (self.pageXOffset) {
        return self.pageXOffset;
    } else if (document.documentElement && document.documentElement.scrollLeft) {
        return document.documentElement.scrollLeft;
    } else if (document.body) {
        return document.body.scrollLeft;
    }
}
function hideSelectBoxes() {
    for (var i = 0; i < document.forms.length; i++) {
        for (var e = 0; e < document.forms[i].length; e++) {
            if (document.forms[i].elements[e].tagName == "SELECT") {
                document.forms[i].elements[e].style.visibility = "hidden";
            }
        }
    }
}
function pop(params) {
    showPopWin();
}
function unpop() {}
function chkVerisign(url) {
    sealWin = window.open(url, 'win', 'toolbar=0,location=0,directories=0,status=1,menubar=1,scrollbars=1,resizable=1,width=500,height=450');
    self.name = 'mainWin';
}
function terms(params) {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 600,
    popH = 550;
    var leftPos = (w - popW) / 2,
    topPos = (h - popH) / 2;
    var url = params;
    waitwin = window.open(url, '_wait', 'toolbar=no,location=no,menubar=no,status=no,scrollbars=1,' + 'width=' + popW + ',height=' + popH + ',top=' + topPos + ',left=' + leftPos);
}
function showCharges() {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 640;
    var popH = 400;
    var popH;
    var leftPos = (w - popW) / 2,
    topPos = h / 5;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    chargeWindow = window.open('ViewCharges.aspx', 'chargeWindow', 'location=no,toolbar=no,status=no,resizable=no,scrollbars=yes,' + dimensions);
    chargeWindow.focus();
}
function selectPaxNumber() {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 580;
    var popH = 200;
    var leftPos = (w - popW) / 2,
    topPos = (h - popH) / 2;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    addPaxNumWindow = window.open('AddPaxPrompt.aspx', 'addPaxNumWindow', 'toolbar=no,status=no,scrollbars=no,resizable=no,' + dimensions);
    addPaxNumWindow.focus();
}
function unloadPaxNumber() {
    addPaxNumWindow = window.open('AddPaxPrompt.aspx', 'addPaxNumWindow');
    if (addPaxNumWindow != null && addPaxNumWindow.open) addPaxNumWindow.close();
}
function openEmailPage(url) {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 550;
    var popH = 300;
    var popH;
    var leftPos = (w - popW) / 2,
    topPos = h / 5;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    emailWindow = window.open(url, 'emailWindow', 'location=no,toolbar=no,status=no,resizable=no,scrollbars=yes,' + dimensions);
    emailWindow.focus();
}
function openEmailConfirmPage(url) {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 650;
    var popH = 500;
    var popH;
    var leftPos = (w - popW) / 2,
    topPos = h / 5;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    emailWindow = window.open(url, 'emailConfirmWindow', 'location=no,toolbar=no,status=no,resizable=no,scrollbars=yes,' + dimensions);
    emailWindow.focus();
}
function unloadConfirmWindow() {
    emailConfirmWindow = window.open('EWConfirmEditItin.aspx', 'emailConfirmWindow');
    if (emailConfirmWindow != null && emailConfirmWindow.open) emailConfirmWindow.close();
}
function hidePopWin(callReturnFunc) {
    gPopupIsShown = false;
    var theBody = document.getElementsByTagName("BODY")[0];
    theBody.style.overflow = "";
    if (gPopupMask == null) {
        return;
    }
    gPopupMask.style.display = "none";
    gPopupContainer.style.display = "none";
    gPopFrame.src = gDefaultPage;
}
function imgchng(name, src) {
    document[name].src = src;
}
function popbill(pop) {
    var i;
    if (pop) {
        document.forms[0].txtCardholder.value = p1fn + ' ' + p1ln;
        document.forms[0].txtAddr1.value = p1a1;
        document.forms[0].txtCity.value = p1ct;
        document.forms[0].txtPhone.value = p1ph;
        
        $('#lstCtry option[value="' + p1cn + '"]').attr('selected', true);
        $('#lstCtry').trigger('change');

        $('#lstProv option[value="' + p1pr + '"]').attr('selected', true);
        $('#lstProv').trigger('change');
    } else {
        document.forms[0].txtCardholder.value = '';
        document.forms[0].txtAddr1.value = '';
        document.forms[0].txtCity.value = '';
        document.forms[0].txtPhone.value = '';
        document.forms[0].lstProv.selectedIndex = 0;
        document.forms[0].lstCtry.selectedIndex = 0;
        document.forms[0].txtPCode.value = '';
    }
}
var shopDetails_window;
function DisplayShopDetails(sSSRName, sSSRDesc, sSSRPrice) {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    if (window_available()) {
        shopDetails_window.close();
    }
    var popW = 520;
    var popH = 300;
    var popH;
    var leftPos = (w - popW) / 2,
    topPos = h / 5;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    shopDetails_window = window.open("", 'shopDetails_window', 'location=no,toolbar=no,status=no,resizable=no,scrollbars=yes,' + dimensions);
    shopDetails_window.document.writeln('<html>');
    shopDetails_window.document.writeln('<link rel="stylesheet" href="styles/resstyles.css" type="text/css">');
    shopDetails_window.document.writeln('<head>');
    shopDetails_window.document.writeln('<title>');
    shopDetails_window.document.writeln('<\/title>');
    shopDetails_window.document.writeln('<\/head>');
    shopDetails_window.document.writeln('<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">');
    shopDetails_window.document.writeln('<table>');
    shopDetails_window.document.writeln('<tr>');
    shopDetails_window.document.writeln('<td class=tdShopDetsHdr align=left>');
    shopDetails_window.document.writeln(sSSRName);
    shopDetails_window.document.writeln('<\/td>');
    shopDetails_window.document.writeln('<\/tr>');
    shopDetails_window.document.writeln('<tr>');
    shopDetails_window.document.writeln('<td class=tdShopDetsDesc align=left>');
    shopDetails_window.document.writeln(sSSRDesc);
    shopDetails_window.document.writeln('<\/td>');
    shopDetails_window.document.writeln('<\/tr>');
    shopDetails_window.document.writeln('<tr>');
    shopDetails_window.document.writeln('<td class=tdShopDetsDesc align=left>');
    shopDetails_window.document.writeln(sSSRDesc);
    shopDetails_window.document.writeln('<\/td>');
    shopDetails_window.document.writeln('<\/tr>');
    shopDetails_window.document.writeln('<\/table>');
    shopDetails_window.document.writeln('</html>');
}
function window_available() {
    if (!shopDetails_window) {
        return false;
    } else if (shopDetails_window.closed) {
        return false;
    } else {
        return true;
    }
}
function paxsearch(pax) {
    var searchwin;
    var query;
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 850,
    popH = 400;
    var leftPos = (w - popW) / 2,
    topPos = (h - popH) / 2;
    if (pax==1) {
        query = '&pax=' + pax + '&paxid=' + document.forms[0].elements['hidPax' + pax + '_Search'].value + '&fname=' + document.forms[0].elements['txtPax' + pax + '_FName'].value + '&lname=' + document.forms[0].elements['txtPax' + pax + '_LName'].value;
        query = query + '&phone1=' + document.forms[0].elements['txtPax' + pax + '_Phone1'].value + '&phone2=' + document.forms[0].elements['txtPax' + pax + '_Phone2'].value;
    } else {
        query = '&pax=' + pax + '&paxid=' + document.forms[0].elements['hidPax' + pax + '_Search'].value + '&fname=' + document.forms[0].elements['txtPax' + pax + '_FName'].value + '&lname=' + document.forms[0].elements['txtPax' + pax + '_LName'].value;
        query = query + '&phone1=' + document.forms[0].elements['txtPax' + pax + '_Phone1'].value;
    }
    if (document.forms[0].elements['txtPax' + pax + '_LoyaltyProgram'] != null) {
    	query = query + '&aeroplan=' + document.forms[0].elements['txtPax' + pax + '_LoyaltyProgram'].value;
    }
	
    searchwin = window.open('searchpax.aspx' + location.href.substr(location.href.indexOf('?')) + query, '_paxsearch', 'location=no,toolbar=no,status=yes,scrollbars=yes,resizable=no,' + 'width=' + popW + ',height=' + popH + ',top=' + topPos + ',left=' + leftPos);
}
function paxsearchadd(pax) {
    var searchwin;
    var query;
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 850,
    popH = 400;
    var leftPos = (w - popW) / 2,
    topPos = (h - popH) / 2;
    query = '&pax=' + pax + '&paxid=' + document.forms[0].elements['hidPax' + pax + '_Search'].value + '&fname=' + document.forms[0].elements['txtPaxNew' + pax + '_FName'].value + '&lname=' + document.forms[0].elements['txtPaxNew' + pax + '_LName'].value;
    query = query + '&phone1=' + document.forms[0].elements['txtPaxNew' + pax + '_Phone1'].value;
	
	if (document.forms[0].elements['txtPax' + pax + '_LoyaltyProgram'] != null) {
	    query = query + '&aeroplan=' + document.forms[0].elements['txtPax' + pax + '_LoyaltyProgram'].value;
	}
	
    searchwin = window.open('searchpax.aspx' + location.href.substr(location.href.indexOf('?')) + query, '_paxsearchadd', 'location=no,toolbar=no,status=yes,scrollbars=yes,resizable=no,' + 'width=' + popW + ',height=' + popH + ',top=' + topPos + ',left=' + leftPos);
}
function DisplayCityPairs(sQTName, sIdent) {
    var sHeader = "<h2>Valid City Pairs</h2>";
    var sHTML = "<table width='100%'><tr><td colspan='2'>" + sQTName + " - <a href='javascript:HideCityPairs();'>Hide</a></td></tr>";
    var sFooter = "</table>";
    var sItems = "<tr><th width='50%'>From</th><th>To</th></tr>";
    var i;
    for (i = 0; i < aQuickTickets[sIdent].length; ++i) {
        var sDepApt;
        var sArvApt;
        sDepApt = aQuickTickets[sIdent][i].slice(0, 1);
        sArvApt = aQuickTickets[sIdent][i].slice(1);
        sItems = sItems + "<tr><td align='center'>" + sDepApt + "</td><td align='center'>" + sArvApt + "</td></tr>";
    }
    sHTML = sHeader + sHTML + sItems + sFooter;
    document.getElementById("QTCityPairs").innerHTML = sHTML;
}
function HideCityPairs() {
    document.getElementById("QTCityPairs").innerHTML = "";
}
function toORChk(dFC, dOR, dr) {
    var rAR,
    rFC,
    rOR;
    if ((dr == 'd') && (document.forms[0].elements['gridTravelOptRet'] != undefined)) {
        if (document.forms[0].elements['gridTravelOptRet'].length == undefined) {
            rAR = document.forms[0].elements['gridTravelOptRet'].value.split(',');
            rFC = rAR[1];
            rOR = rAR[2];
            //toORDis(document.forms[0].elements['gridTravelOptRet'], dFC, dOR, rFC, rOR);
        } else {
            for (i = 0; i < document.forms[0].elements['gridTravelOptRet'].length; i++) {
                rAR = document.forms[0].elements['gridTravelOptRet'][i].value.split(',');
                rFC = rAR[1];
                rOR = rAR[2];
                //toORDis(document.forms[0].elements['gridTravelOptRet'][i], dFC, dOR, rFC, rOR);
            }
        }
    }
}
function toORDis(elem, dFC, dOR, rFC, rOR) {
    elem.disabled = (dOR != rOR);
    if (dOR == 'R') {
        elem.disabled = (dFC != rFC);
    }
    if (elem.disabled == true) {
        elem.checked = false;
    }
}
function getMonthName(iMonth) {
    switch (iMonth) {
    case "01":
        return "January";
        break;
    case "02":
        return "February";
        break;
    case "03":
        return "March";
        break;
    case "04":
        return "April";
        break;
    case "05":
        return "May";
        break;
    case "06":
        return "June";
        break;
    case "07":
        return "July";
        break;
    case "08":
        return "August";
        break;
    case "09":
        return "September";
        break;
    case "10":
        return "October";
        break;
    case "11":
        return "November";
        break;
    case "12":
        return "December";
        break;
    }
}
function setTheDate(selected_dep_date) {
    var depYear = selected_dep_date.getFullYear().toString();
    var depDay = selected_dep_date.getDate().toString();
    var tmpdepMonth = selected_dep_date.getMonth();
    tmpdepMonth = tmpdepMonth + 1;
    var depMonth = tmpdepMonth.toString();
    if (depDay.length < 2) {
        depDay = "0" + depDay;
    }
    if (depMonth.length < 2) {
        depMonth = "0" + depMonth;
    }
    for (i = 0; i < document.getElementById('dlstDepDate_Day').length; i++) {
        if (document.getElementById('dlstDepDate_Day').options[i].value == depDay) {
            document.getElementById('dlstDepDate_Day').selectedIndex = i
        }
    }
    var yearMonth = depYear + "/" + depMonth;
    for (i = 0; i < document.getElementById('dlstDepDate_Month').length; i++) {
        if (document.getElementById('dlstDepDate_Month').options[i].value == yearMonth) {
            document.getElementById('dlstDepDate_Month').selectedIndex = i
        }
    }
}
function setTheDates(selected_dep_date, selected_ret_date) {
    var depYear = selected_dep_date.getFullYear().toString();
    var depDay = selected_dep_date.getDate().toString();
    var tmpdepMonth = selected_dep_date.getMonth();
    tmpdepMonth = tmpdepMonth + 1;
    var depMonth = tmpdepMonth.toString();
    if (depDay.length < 2) {
        depDay = "0" + depDay;
    }
    if (depMonth.length < 2) {
        depMonth = "0" + depMonth;
    }
    for (i = 0; i < document.getElementById('dlstDepDate_Day').length; i++) {
        if (document.getElementById('dlstDepDate_Day').options[i].value == depDay) {
            document.getElementById('dlstDepDate_Day').selectedIndex = i;
        }
    }
    var yearMonth = depYear + "/" + depMonth;
    for (i = 0; i < document.getElementById('dlstDepDate_Month').length; i++) {
        if (document.getElementById('dlstDepDate_Month').options[i].value == yearMonth) {
            document.getElementById('dlstDepDate_Month').selectedIndex = i;
        }
    }
    var retYear = selected_ret_date.getFullYear().toString();
    var retDay = selected_ret_date.getDate().toString();
    var tmpretMonth = selected_ret_date.getMonth();
    tmpretMonth = tmpretMonth + 1;
    var retMonth = tmpretMonth.toString();
    if (retDay.length < 2) {
        retDay = "0" + retDay;
    }
    if (retMonth.length < 2) {
        retMonth = "0" + retMonth;
    }
    for (i = 0; i < document.getElementById('dlstRetDate_Day').length; i++) {
        if (document.getElementById('dlstRetDate_Day').options[i].value == retDay) {
            document.getElementById('dlstRetDate_Day').selectedIndex = i;
        }
    }
    var yearMonthRet = retYear + "/" + retMonth;
    for (x = 0; x < document.getElementById('dlstRetDate_Month').length; x++) {
        if (document.getElementById('dlstRetDate_Month').options[x].value == yearMonthRet) {
            document.getElementById('dlstRetDate_Month').selectedIndex = x;
        }
    }
}
function setTheDatesMulti(dep1_index, selected_dep1_date, dep2_index, selected_dep2_date) {
    var dep1Year = selected_dep1_date.getFullYear().toString();
    var dep1Day = selected_dep1_date.getDate().toString();
    var tmpdep1Month = selected_dep1_date.getMonth();
    tmpdep1Month = tmpdep1Month + 1;
    var dep1Month = tmpdep1Month.toString();
    if (dep1Day.length < 2) {
        dep1Day = "0" + dep1Day;
    }
    if (dep1Month.length < 2) {
        dep1Month = "0" + dep1Month;
    }
    for (i = 0; i < document.getElementById('dlstDepDate' + dep1_index + '_Day').length; i++) {
        if (document.getElementById('dlstDepDate' + dep1_index + '_Day').options[i].value == dep1Day) {
            document.getElementById('dlstDepDate' + dep1_index + '_Day').selectedIndex = i;
        }
    }
    var yearMonthDep1 = dep1Year + "/" + dep1Month;
    for (i = 0; i < document.getElementById('dlstDepDate' + dep1_index + '_Month').length; i++) {
        if (document.getElementById('dlstDepDate' + dep1_index + '_Month').options[i].value == yearMonthDep1) {
            document.getElementById('dlstDepDate' + dep1_index + '_Month').selectedIndex = i;
        }
    }
    var dep2Year = selected_dep2_date.getFullYear().toString();
    var dep2Day = selected_dep2_date.getDate().toString();
    var tmpdep2Month = selected_dep2_date.getMonth();
    tmpdep2Month = tmpdep2Month + 1;
    var dep2Month = tmpdep2Month.toString();
    if (dep2Day.length < 2) {
        dep2Day = "0" + dep2Day;
    }
    if (dep2Month.length < 2) {
        dep2Month = "0" + dep2Month;
    }
    for (i = 0; i < document.getElementById('dlstDepDate' + dep2_index + '_Day').length; i++) {
        if (document.getElementById('dlstDepDate' + dep2_index + '_Day').options[i].value == dep2Day) {
            document.getElementById('dlstDepDate' + dep2_index + '_Day').selectedIndex = i;
        }
    }
    var yearMonthDep2 = dep2Year + "/" + dep2Month;
    for (i = 0; i < document.getElementById('dlstDepDate' + dep2_index + '_Month').length; i++) {
        if (document.getElementById('dlstDepDate' + dep2_index + '_Month').options[i].value == yearMonthDep2) {
            document.getElementById('dlstDepDate' + dep2_index + '_Month').selectedIndex = i;
        }
    }
}
function setDatesJQ() {
    var sDep = document.getElementById("departure").value;
    var sRet = document.getElementById("arrival").value;
    var selected_dep_date = new Date(sDep);
    var selected_ret_date = new Date(sRet);
    setTheDates(selected_dep_date, selected_ret_date);
}
function setDatesJQMulti() {
    var dep1 = document.getElementById("departure1").value;
    var dep2 = document.getElementById("departure2").value;
    var selected_dep1_date = new Date(dep1);
    var selected_dep2_date = new Date(dep2);
    setTheDatesMulti(1, selected_dep1_date, 2, selected_dep2_date);

    dep1 = document.getElementById("departure3").value;
    dep2 = document.getElementById("departure4").value;
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(3, selected_dep1_date, 4, selected_dep2_date);

    dep1 = document.getElementById("departure5").value;
    dep2 = document.getElementById("departure6").value;
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(5, selected_dep1_date, 6, selected_dep2_date);

    dep1 = document.getElementById("departure7").value;
    dep2 = document.getElementById("departure8").value;
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(7, selected_dep1_date, 8, selected_dep2_date);

    dep1 = document.getElementById("departure9").value;
    dep2 = document.getElementById("departure10").value;
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(9, selected_dep1_date, 10, selected_dep2_date);
}
function setDate() {
    var sDep = document.getElementById("departure").value;
    var selected_dep_date = new Date(sDep);
    setTheDate(selected_dep_date);
}
function setDates() {
    var myMonths = new Array("n", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    var sDep = document.getElementById("departure1").value;
    var sRet = document.getElementById("departure2").value;
    var depSplit = sDep.split("/");
    var sDepMnth = getMonthName(depSplit[1]);
    var retSplit = sRet.split("/");
    var sRetMnth = getMonthName(retSplit[1]);
    sDep = depSplit[0] + " " + sDepMnth + " " + depSplit[2];
    sRet = retSplit[0] + " " + sRetMnth + " " + retSplit[2];
    var selected_dep_date = new Date(sDep);
    var selected_ret_date = new Date(sRet);
    setTheDates(selected_dep_date, selected_ret_date);
}
function setDatesMulti() {
    var myMonths = new Array("n", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    var dep1 = document.getElementById("departure1").value;
    var dep2 = document.getElementById("departure2").value;
    var dep1Split = dep1.split("/");
    var dep1Mnth = getMonthName(dep1Split[1]);
    var dep2Split = dep2.split("/");
    var dep2Mnth = getMonthName(dep2Split[1]);
    dep1 = dep1Split[0] + " " + dep1Mnth + " " + dep1Split[2];
    dep2 = dep2Split[0] + " " + dep2Mnth + " " + dep2Split[2];
    var selected_dep1_date = new Date(dep1);
    var selected_dep2_date = new Date(dep2);
    setTheDatesMulti(1, selected_dep1_date, 2, selected_dep2_date);

    dep1 = document.getElementById("departure3").value;
    dep2 = document.getElementById("departure4").value;
    dep1Split = dep1.split("/");
    dep1Mnth = getMonthName(dep1Split[1]);
    dep2Split = dep2.split("/");
    dep2Mnth = getMonthName(dep2Split[1]);
    dep1 = dep1Split[0] + " " + dep1Mnth + " " + dep1Split[2];
    dep2 = dep2Split[0] + " " + dep2Mnth + " " + dep2Split[2];
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(3, selected_dep1_date, 4, selected_dep2_date);

    dep1 = document.getElementById("departure5").value;
    dep2 = document.getElementById("departure6").value;
    dep1Split = dep1.split("/");
    dep1Mnth = getMonthName(dep1Split[1]);
    dep2Split = dep2.split("/");
    dep2Mnth = getMonthName(dep2Split[1]);
    dep1 = dep1Split[0] + " " + dep1Mnth + " " + dep1Split[2];
    dep2 = dep2Split[0] + " " + dep2Mnth + " " + dep2Split[2];
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(5, selected_dep1_date, 6, selected_dep2_date);

    dep1 = document.getElementById("departure7").value;
    dep2 = document.getElementById("departure8").value;
    dep1Split = dep1.split("/");
    dep1Mnth = getMonthName(dep1Split[1]);
    dep2Split = dep2.split("/");
    dep2Mnth = getMonthName(dep2Split[1]);
    dep1 = dep1Split[0] + " " + dep1Mnth + " " + dep1Split[2];
    dep2 = dep2Split[0] + " " + dep2Mnth + " " + dep2Split[2];
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(7, selected_dep1_date, 8, selected_dep2_date);

    dep1 = document.getElementById("departure9").value;
    dep2 = document.getElementById("departure10").value;
    dep1Split = dep1.split("/");
    dep1Mnth = getMonthName(dep1Split[1]);
    dep2Split = dep2.split("/");
    dep2Mnth = getMonthName(dep2Split[1]);
    dep1 = dep1Split[0] + " " + dep1Mnth + " " + dep1Split[2];
    dep2 = dep2Split[0] + " " + dep2Mnth + " " + dep2Split[2];
    selected_dep1_date = new Date(dep1);
    selected_dep2_date = new Date(dep2);
    setTheDatesMulti(9, selected_dep1_date, 10, selected_dep2_date);
}
function fillText(sValue, sControl) {
    document.getElementById(sControl).value = sValue;
}
var curLegID = "";
function selectLeg(iLeg) {
    clearChecks();
    var cName = "gridEditSegments" + iLeg.toString();
    var radName = "radbtn" + iLeg;
    curLegID = radName;
    document.getElementById(cName).checked = true;
    document.getElementById(radName).src = "images/checked.png";
}
function clearChecks() {
    var x = 1;
    var stop = false;
    while (stop != true) {
        var radName = "radbtn" + x;
        var radNameCANX = "radbtn" + x + "CANX";
        if (document.getElementById(radName) != null) {
            document.getElementById(radName).src = "images/unchecked.png";
        } else if (document.getElementById(radNameCANX) != null) {
            document.getElementById(radNameCANX).src = "images/unchecked.png";
        } else {
            stop = true;
        }
        x = x + 1;
    }
    if (document.getElementById("gridEditSegmentsCancelledLeg") != null) {
        document.getElementById("radbtnCancelledLeg").src = "images/unchecked.png";
    }
}
function checkLeg() {
    if (curLegID.indexOf("CANX") < 0) {
        return true;
    } else {
        return false;
    }
}
function selectLegEW(iLeg) {
    clearChecksEW();
    var radName = "radbtn" + iLeg;
    document.getElementById(radName).src = "images/checked.png";
}
function clearChecksEW() {
    var x = 1;
    var stop = false;
    while (stop == false) {
        var radName = "radbtn" + x;
        if (document.getElementById(radName) != null) {
            document.getElementById(radName).src = "images/unchecked.png";
            x++;
        } else {
            stop = true;
        }
    }
}
function openPasswordReminderPage(url) {
    var w,
    h;
    if (document.all || document.layers) {
        w = screen.availWidth;
        h = screen.availHeight;
    } else {
        w = screen.width;
        h = screen.height;
    }
    var popW = 520;
    var popH = 300;
    var popH;
    var leftPos = (w - popW) / 2,
    topPos = h / 5;
    var dimensions = "width=" + popW + ", height=" + popH + ",top=" + topPos + ",left=" + leftPos;
    emailWindow = window.open(url, 'emailPasswordWindow', 'location=no,toolbar=no,status=no,resizable=no,scrollbars=yes,' + dimensions);
    emailWindow.focus();
}
// this function is used for currency formatting for the front end (like travel options for example)
function addCommas(str) {
   	str += '';
    str = str.replace(/,/g, '');
   	v = str.split('.');
   	v1 = v[0];
   	v2 = v.length > 1 ? '.' + v[1] : '';
   	var rgx = /(\d+)(\d{3})/;
   	while (rgx.test(v1)) {
   		v1 = v1.replace(rgx, '$1' + ',' + '$2');
   	}
   	return v1 + v2;
}
// used to find out if number contains a '.' and fixes the float to 2
function checkIfFloat(value) {
    if (value.toString().indexOf('.', 0) > -1) {
        return parseFloat(value).toFixed(2);
    }
    else {
        return value;
    }
}