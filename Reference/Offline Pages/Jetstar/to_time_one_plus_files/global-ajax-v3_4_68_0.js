var globalAjax=(function(){var timeoutInterval,timeoutExpired;return{init:function(){if(window.console==undefined){window.console={log:function(){}}}this.logOut()},logOut:function(){$(".signout-button").click(function(){$.ajax({url:"MemberLogin2Ajax.aspx",dataType:"json",data:{action:"logout"},beforeSend:function(XMLHttpRequest,settings){},success:function(data){window.location.reload()}});return false});$(".form-login-notyou a.logout-link").click(function(){var exp=new Date();exp.setTime(exp.getTime()-1);var _domain=".jetstar.com";var domainAndPath="domain="+_domain+"; path=/";if(window.location.hostname=="localhost"){domainAndPath="path=/Website"}document.cookie="jqcds=;expires="+exp.toUTCString()+";"+domainAndPath;window.location.reload();return false})},timeoutWarning:function(){if($("#timeout-warning").length>0){clearTimeout(timeoutInterval);timeoutInterval=setTimeout(function(){$("#timeout-warning").slideDown();jetstarGATracking.trackSessionTimeOutAlert();timeoutExpired=setTimeout(function(){window.location.href="SessionExpired.aspx"},120000)},450000);$("#timeout-warning a").one("click",function(){$(this).parent().parent().slideUp();globalAjax.keepSessionAlive();return false})}},keepSessionAlive:function(){$.post("KeepSessionAlive.aspx",null,function(){$("#timeout-warning").slideUp();globalAjax.timeoutWarning();clearTimeout(timeoutExpired)})}}})();$(document).ready(function(){globalAjax.init()});