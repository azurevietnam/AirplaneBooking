lpAddMonitorTag();
if(typeof lpMTagConfig!="undefined")lpMTagConfig.getLPVarValue=function(c){if(!lpMTagConfig.varLookup){lpMTagConfig.varLookup={};for(var b=0;b<lpMTagConfig.vars.length;b++){var a=lpMTagConfig.vars[b];a.length>2&&(lpMTagConfig.varLookup[a[1]]={value:a[2],scope:"page"});a.length==2&&(lpMTagConfig.varLookup[a[0]]={value:a[1],scope:"page"})}}return lpMTagConfig.varLookup[c]==null?null:lpMTagConfig.varLookup[c].value};
typeof lpMTagConfig!="undefined"&&function(a){lpMTagConfig.isMobile=!1;if(/android|avantgo|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|e\-|e\/|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\-|2|g)|yas\-|your|zeto|zte\-/i.test(a.substr(0,
4)))lpMTagConfig.isMobile=!0}(navigator.userAgent||navigator.vendor||window.opera);
//DO NOT CHANGE THE BELOW COMMENT
//PLUGINS_LIST=lightBox,simpleDeploy,sendLPVarsFromPage
"undefined" == typeof lpMTagConfig.plugins && (lpMTagConfig.plugins = {});
lpMTagConfig.plugins.lightBox = {
    name: "lightBox",
    config: {
        zIndex: 3E4,
        invZindex: 30100,
        effectTrigger: "showlb=1"
    }
};
lpMTagConfig.plugins.simpleDeploy = {
    name: "simpleDeploy",
    config: {
        varNameCharLimit: 255,
        varValueCharLimit: 255,
        buttons: [{
            name: "chat-sales-flights",
            pid: "lpButtonDIV",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "service-widget-1",
            pid: "lpButtonDivServiceWidget",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "global-header",
            pid: "lpButtonGlobalHeader",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "global-footer",
            pid: "lpButtonGlobalFooter",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "service-contact-us",
            pid: "lpButtonServiceContactUs",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "global-ja-footer",
            pid: "lpButtonGlobalFooterJA",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "service-ja-contact-us",
            pid: "lpButtonServiceContactUsJA",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "chat-sales-pbg",
            pid: "chat-sales-pbg",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "chat-sales-pbg-two",
            pid: "chat-sales-pbg-two",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "chat-sales-pbg-three",
            pid: "chat-sales-pbg-three",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "global-cn-footer",
            pid: "lpButtonGlobalFooterCN",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }, {
            name: "service-cn-contact-us",
            pid: "lpButtonServiceContactUsCN",
            afterStartPage: !0,
            ovr: "lpMTagConfig.db1"
        }]
    }
};
lpMTagConfig.plugins.sendLPVarsFromPage = {
    name: "sendLPVarsFromPage",
    config: {
        lpVarMappings: [{
            name: "PID",
            scope: "page",
            methods: [{
                type: "jsref",
                jsref: "Country_POS"
            }]
        }],
        sendEmptyValues: !1
    }
};
if (typeof(lpMTagConfig.pluginCode)== 'undefined') {lpMTagConfig.pluginCode = {};} // HAS TO BE HERE
lpMTagConfig.pluginCode.lpBasePlugin = {
    // initialize the external configuration parameters - do not change this method - has to be added to every plugin
    init: function() {
        try {
            if (typeof (lpMTagConfig.pluginRef) == 'undefined') { lpMTagConfig.pluginRef = {}; }
            lpMTagConfig.pluginRef[this.name] = this;
            this.log(this.name + ' init', 'DEBUG');
            for (var name in lpMTagConfig.plugins) {
                if (typeof (lpMTagConfig.plugins[name]) == 'object' && lpMTagConfig.plugins[name].name == this.name) {
                    var cfg = lpMTagConfig.plugins[name].config;
                    if (cfg) {
                        for (var prop in cfg) {
                            this[prop] = cfg[prop];
                        }
                    }
                    break;
                }
            }
        }
        catch (e) {
            this.log('Plugin ' + this.name + ' exception in init:' + e, 'ERROR');
        }
    },

    log: function(msg, level) {
        if (typeof(lpMTagDebug)!='undefined' && lpMTagDebug.Display) {
            try {
                lpMTagDebug.Display(msg, level, 'PLUGIN-' + this.name);
            }
            catch (e) { }
        }
		if(typeof(console)!='undefined' && 
		   (typeof(lpMTagConfig.pluginsConsoleDebug)=='undefined' ||  lpMTagConfig.pluginsConsoleDebug==true)){
			console.log(level + ":" + msg);
		}
    }
};

// Initialize the plugin hook arrays if needed
if (typeof (lpMTagConfig.pluginHook) == 'undefined') { lpMTagConfig.pluginHook = {}; }
if (typeof (lpMTagConfig.pluginHook.invite) == 'undefined') { lpMTagConfig.pluginHook.invite = []; }
if (typeof (lpMTagConfig.pluginHook.dynButtons) == 'undefined') { lpMTagConfig.pluginHook.dynButtons = []; }
if(typeof lpMTagConfig.pluginCode=="undefined")lpMTagConfig.pluginCode={};
lpMTagConfig.pluginCode.lightBox={ver:1,name:"lightBox",effectTrigger:"",FadeStart:0,FadeEnd:70,FadePace:5,FadeOnDone:null,FadeLayerID:"lplightbox",zIndex:3E4,invZindex:4E4,bkgColor:"#000",flagCenterDiv:!0,inviteWidth:0,inviteHeight:0,declineOnBackgroundClick:!1,lpVarValuesToInclude:null,inviteNamesToInclude:null,enableLightBox:!0,start:function(){this.log(this.name+" start","DEBUG");if(this.lpVarValuesToInclude!==null){for(var a=!1,b=0;b<this.lpVarValuesToInclude.length;b++){var c=[];switch(this.lpVarValuesToInclude[b].scope){case "page":c=
lpMTagConfig.pageVar;break;case "session":c=lpMTagConfig.sessionVar;break;case "visitor":c=lpMTagConfig.visitorVar}for(var d=0;d<c.length;d++){var e=c[d].split("=");unescape(e[0])==this.lpVarValuesToInclude[b].varname&&(varValue=unescape(e[1]),varValue.match(this.lpVarValuesToInclude[b].regex)&&(a=!0))}}this.enableLightBox=a}},inviteChatStart:function(a){this.log(this.name+" inviteChatStart","DEBUG");this.inviteStart(a);return!0},inviteVoiceStart:function(a){this.log(this.name+" inviteVoiceStart",
"DEBUG");this.inviteStart(a);return!0},inviteStart:function(a){try{var b=eval(a.objName);if(b!==null){if(!this.enableLightBox||!this.isInviteNameEnabled(b)||this.effectTrigger!==""&&b.contentType==2&&b.inviteHTML.indexOf(this.effectTrigger)<0)return!0;this.flagCenterDiv===!0&&this.inviteWidth>0&&this.inviteHeight>0&&this.centerDiv(b,this.inviteWidth,this.inviteHeight);document.getElementById(b.divID).style.zIndex=this.invZindex;var c=this;setTimeout(function(){c.doLightbox(b)},100)}}catch(d){this.log("Plugin "+
this.name+" exception in inviteStart:"+d,"ERROR")}},inviteChatAccept:function(a){this.log(this.name+" inviteChatAccept","DEBUG");this.inviteAccept(a);return!0},inviteVoiceAccept:function(a){this.log(this.name+" inviteVoiceAccept","DEBUG");this.inviteAccept(a);return!0},inviteAccept:function(a){try{a.prevRet?this.closeLightbox():this.log(this.name+" inviteAccept Not Closing the LightBox","DEBUG")}catch(b){this.log("Plugin "+this.name+" exception in inviteAccept:"+b,"ERROR")}},inviteChatDeclined:function(a){this.log(this.name+
" inviteChatDeclined","DEBUG");this.inviteDeclined(a);return!0},inviteVoiceDeclined:function(a){this.log(this.name+" inviteVoiceDeclined","DEBUG");this.inviteDeclined(a);return!0},inviteDeclined:function(){try{this.closeLightbox()}catch(a){this.log("Plugin "+this.name+" exception in inviteDeclined:"+a,"ERROR")}},inviteChatTimeout:function(a){this.log(this.name+" inviteChatTimeout","DEBUG");this.inviteTimeout(a);return!0},inviteVoiceTimeout:function(a){this.log(this.name+" inviteVoiceTimeout","DEBUG");
this.inviteTimeout(a);return!0},inviteTimeout:function(){try{this.closeLightbox()}catch(a){this.log("Plugin "+this.name+" exception in inviteTimeout:"+a,"ERROR")}},doLightbox:function(a){try{this.log(this.name+" doLightbox","DEBUG");var b=this.getPageSize(),c=document.createElement("div");c.id=this.FadeLayerID;c.style.position=typeof(document.addEventListener!="function")?"absolute":"fixed";c.style.left="0px";c.style.top="0px";c.style.width="100%";c.style.height=b[1]+"px";c.style.zIndex=this.zIndex;
c.style.backgroundColor=this.bkgColor;if(this.declineOnBackgroundClick)c.onclick=function(){a.CloseInvite&&a.CloseInvite()};if(document.getElementsByTagName("body")!==null)document.getElementsByTagName("body")[0].style.height="100%",document.getElementsByTagName("body")[0].style.margin="0px",document.getElementsByTagName("body")[0].style.padding="0px";if(document.getElementsByTagName("html")!==null)document.getElementsByTagName("html")[0].style.height="100%";document.getElementsByTagName("body")[0].appendChild(c);
this.Fade()}catch(d){this.log("Plugin "+this.name+" exception in doLightbox:"+d,"ERROR")}},Fade:function(){try{if(this.log(this.name+" Fade","DEBUG"),this.FadePace>0&&this.FadeStart>=this.FadeEnd||this.FadePace<0&&this.FadeStart<=this.FadeEnd)this.FadeOnDone!==null&&this.FadeOnDone();else{var a=document.getElementById(this.FadeLayerID);if(a!==null){a.style.opacity=(this.FadeStart+this.FadePace)/101;a.style.MozOpacity=(this.FadeStart+this.FadePace)/100;a.style.KhtmlOpacity=(this.FadeStart+this.FadePace)/
100;a.style.filter="alpha(opacity="+(this.FadeStart+this.FadePace)+")";this.FadeStart+=this.FadePace;var b=this;setTimeout(function(){b.Fade()},50)}}}catch(c){this.log("Plugin "+this.name+" exception in Fade:"+c,"ERROR")}},closeLightbox:function(){try{this.log(this.name+" closeLightbox","DEBUG"),document.getElementById(this.FadeLayerID)===null?this.log("Did not find FadeLayerID:"+this.FadeLayerID):(this.FadeStart=70,this.FadeEnd=0,this.FadePace=-5,this.FadeOnDone=this.fadeoutDone,this.Fade())}catch(a){this.log("Plugin "+
this.name+" exception in closeLightbox:"+a,"ERROR")}},fadeoutDone:function(){try{this.log(this.name+" fadeoutDone","DEBUG"),this.FadeOnDone=null,this.FadeStart=0,this.FadeEnd=70,this.FadePace=5,document.getElementsByTagName("body")[0].removeChild(document.getElementById(this.FadeLayerID))}catch(a){this.log("Plugin "+this.name+" exception in fadeoutDone:"+a,"ERROR")}},isInviteNameEnabled:function(a){if(this.inviteNamesToInclude){for(var b=0;b<this.inviteNamesToInclude.length;b++)if(this.inviteNamesToInclude[b]==
a.inviteName)return!0;return!1}else return!0},getPageScroll:function(){var a;if(self.pageYOffset)a=self.pageYOffset;else if(document.documentElement&&document.documentElement.scrollTop)a=document.documentElement.scrollTop;else if(document.body)a=document.body.scrollTop;return["",a]},getPageSize:function(){var a,b,c,d;window.innerHeight&&window.scrollMaxY?(a=document.body.scrollWidth,b=window.innerHeight+window.scrollMaxY):document.body.scrollHeight>document.body.offsetHeight?(a=document.body.scrollWidth,
b=document.body.scrollHeight):(a=document.body.offsetWidth,b=document.body.offsetHeight);if(self.innerHeight)c=self.innerWidth,d=self.innerHeight;else if(document.documentElement&&document.documentElement.clientHeight)c=document.documentElement.clientWidth,d=document.documentElement.clientHeight;else if(document.body)c=document.body.clientWidth,d=document.body.clientHeight;return[a<c?c:a,b<d?d:b,c,d]},centerDiv:function(a,b,c){var d=this.getPageSize(),e=this.getPageScroll(),a=a.scroll?(d[3]-35-c)/
2:e[1]+(d[3]-35-c)/2,b=(d[0]-20-b)/2;lpMTagConfig.invitePosY=a<0?"0":Math.round(a);lpMTagConfig.invitePosX=b<0?"0":Math.round(b)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteChatStart",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteChatStart(a)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteChatAccept",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteChatAccept(a)}};
lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteChatDeclined",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteChatDeclined(a)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteChatTimeout",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteChatTimeout(a)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteVoiceStart",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteVoiceStart(a)}};
lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteVoiceAccept",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteVoiceAccept(a)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteVoiceDeclined",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteVoiceDeclined(a)}};lpMTagConfig.pluginHook.invite[lpMTagConfig.pluginHook.invite.length]={name:"inviteVoiceTimeout",src:"lightBox",run:function(a){return lpMTagConfig.pluginCode.lightBox.inviteVoiceTimeout(a)}};
if(typeof lpMTagConfig.pluginCode=="undefined")lpMTagConfig.pluginCode={};
lpMTagConfig.pluginCode.simpleDeploy={ver:1,name:"simpleDeploy",buttonDivMustBePresentOnLoad:!0,defaultButtonDivID:"lpChatButton",sendOrderInfoIfZeroOrEmpty:!1,dontSendIfEmpty:["OrderTotal","OrderNumber"],dontSendIfZero:["OrderTotal","OrderNumber"],sendCookiesIfOrderTotal:!1,buttons:null,scopeOverride:{language:"session"},server:null,varNameCharLimit:50,varValueCharLimit:50,SSOURL:null,inviteChatSSOurl:null,inviteVoiceSSOurl:null,inviteVoiceSingleStepSSOurl:null,defaultInvite:"",isSetup:!1,loop:!0,
varPollInterval:5E3,processVarsTimeout:null,trimSpaces:function(d){return d.replace(/^\s+|\s+$/g,"")},addVar:function(d,c,a){lpMTagConfig.varLookup&&c?lpMTagConfig.varLookup[c]={value:a,scope:d,sent:!1}:c||this.log(this.name+" Added LP variable with a defined name","ERROR")},constructVarsQueryString:function(d){var c="",a;for(a in lpMTagConfig.varLookup)if(!lpMTagConfig.varLookup[a].sent){var b=lpMTagConfig.varLookup[a].value,f=lpMTagConfig.varLookup[a].scope;if(a.indexOf("OrderTotal")!=-1||a.indexOf("OrderNumber")!=
-1){if(this.sendOrderInfoIfZeroOrEmpty&&(b==""||b==0))return;if(!this.sendCookiesIfOrderTotal)lpMTagConfig.sendCookies=!1}for(var g=!0,e=0;e<this.dontSendIfEmpty.length;e++)a.indexOf(this.dontSendIfEmpty[e])!=-1&&b==""&&(g=!1);for(e=0;e<this.dontSendIfZero.length;e++)a.indexOf(this.dontSendIfZero[e])!=-1&&b==0&&(g=!1);if(g)if(b!=null&&f){b=this.trimSpaces(b.toString());a.length>this.varNameCharLimit&&(a=a.substr(0,this.varNameCharLimit));b.length>this.varValueCharLimit&&(b=b.substr(0,this.varValueCharLimit));
g=null;e=a+"="+b;g=typeof encodeURIComponent=="undefined"?escape(a)+"="+escape(b):encodeURIComponent(a)+"="+encodeURIComponent(b);b="P";switch(f){case "page":d&&lpMTagConfig.pageVar.push(g);b="P";break;case "session":d&&lpMTagConfig.sessionVar.push(g);b="S";break;case "visitor":d&&lpMTagConfig.visitorVar.push(g),b="V"}c.length>0&&(c+="&");c+=b+"V!"+e;lpMTagConfig.varLookup[a].sent=!0}else f||this.log("LP variable '"+a+"' does not have a scope defined","ERROR"),b||this.log("LP var '"+a+"' does not have a value defined",
"ERROR")}return c},processVars:function(d){if(!lpMTagConfig.varLookup)lpMTagConfig.varLookup={};if(lpMTagConfig.vars!=null)for(var c=0;c<lpMTagConfig.vars.length;c++){var a=lpMTagConfig.vars[c],b="";a.length>2&&(b=a[0],this.scopeOverride[a[0]]!=null&&(b=this.scopeOverride[a[0]]),this.addVar(b,a[1],a[2]));a.length==2&&(b="page",this.scopeOverride[a[0]]!=null&&(b=this.scopeOverride[a[0]]),this.addVar(b,a[0],a[1]))}d=this.constructVarsQueryString(d);lpMTagConfig.vars=[];if(this.loop){var f=this;this.processVarsTimeout&&
window.clearTimeout(this.processVarsTimeout);this.processVarsTimeout=window.setTimeout(function(){f.processVars(!0)},f.varPollInterval)}return d},start:function(){this.isSetup||this.setup()},setup:function(){this.log(this.name+" setup","DEBUG");this.isSetup=!0;if(typeof lpAddVars=="undefined")lpAddVars=this.addVar;lpMTagConfig.lpTagLoaded=!1;if(typeof lpMTagConfig.lpServer=="undefined")lpMTagConfig.lpServer=this.server!=null?this.server:lpMTagConfig.lpTagSrv;if(typeof lpMTagConfig.pageVar=="undefined")lpMTagConfig.pageVar=
[];if(typeof lpMTagConfig.sessionVar=="undefined")lpMTagConfig.sessionVar=[];if(typeof lpMTagConfig.visitorVar=="undefined")lpMTagConfig.visitorVar=[];if(typeof lpMTagConfig.onLoadCode=="undefined")lpMTagConfig.onLoadCode=[];if(typeof lpMTagConfig.dynButton=="undefined")lpMTagConfig.dynButton=[];if(typeof lpMTagConfig.ifVisitorCode=="undefined")lpMTagConfig.ifVisitorCode=[];if(typeof lpMTagConfig.channels=="undefined"||lpMTagConfig.channels.length==0)lpMTagConfig.channels=["chat"];if(typeof lpMTagConfig.db1==
"undefined")lpMTagConfig.db1={};if(typeof lpMTagConfig.db2=="undefined")lpMTagConfig.db2={};if(this.SSOURL)lpMTagConfig.SSOURL=this.SSOURL;if(this.inviteChatSSOurl)lpMTagConfig.inviteChatSSOurl=this.inviteChatSSOurl;if(this.inviteVoiceSSOurl)lpMTagConfig.inviteVoiceSSOurl=this.inviteVoiceSSOurl;if(this.inviteVoiceSingleStepSSOurl)lpMTagConfig.inviteVoiceSingleStepSSOurl=this.inviteVoiceSingleStepSSOurl;lpMTagConfig.pageLoadTime!=null&&this.addVar("page","pageLoadTime",Math.round(lpMTagConfig.pageLoadTime/
1E3)+" sec",!0);this.processVars(!0);var d=null;typeof lpMTagConfig.getLPVarValue!="undefined"?d=lpMTagConfig.getLPVarValue("unit"):typeof lpUnit!="undefined"&&(d=lpUnit);var c=null;typeof lpMTagConfig.getLPVarValue!="undefined"?c=lpMTagConfig.getLPVarValue("language"):typeof lpLanguage!="undefined"&&(c=lpLanguage);if(this.defaultInvite!=="")lpMTagConfig.defaultInvite=this.defaultInvite;else if(lpMTagConfig.defaultInvite==null){if(d!=null)lpMTagConfig.defaultInvite=lpMTagConfig.channels[0]+"-"+d;
c!=null&&(lpMTagConfig.defaultInvite+="-"+c)}if(this.buttons!=null&&lpMTagConfig.dynButton.length==0)for(var a=0;a<this.buttons.length;a++){lpMTagConfig["db"+(a+1)]==null&&(lpMTagConfig["db"+(a+1)]={});var b={name:this.buttons[a].name,pid:this.buttons[a].pid,afterStartPage:this.buttons[a].afterStartPage,ovr:this.buttons[a].ovr};if(this.buttons[a].SSOURL)b.SSOURL=this.buttons[a].SSOURL;else if(this.SSOURL)b.SSOURL=this.SSOURL;lpMTagConfig.dynButton[lpMTagConfig.dynButton.length]=b}else if(lpMTagConfig.buttonNames==
null&&lpMTagConfig.dynButton.length==0){if(d!=null)for(a=0;a<lpMTagConfig.channels.length;a++){b=lpMTagConfig.channels[a]+"-"+d;c!=null&&(b+="-"+c);lpMTagConfig["db"+(a+1)]==null&&(lpMTagConfig["db"+(a+1)]={});b={name:b,pid:this.buttonDivMustBePresentOnLoad&&document.getElementById(b)!=null?b:this.defaultButtonDivID,afterStartPage:!0,ovr:"lpMTagConfig.db"+(a+1)};if(this.SSOURL)b.SSOURL=this.SSOURL;lpMTagConfig.dynButton[lpMTagConfig.dynButton.length]=b}}else if(lpMTagConfig.buttonNames!=null)for(a=
0;a<lpMTagConfig.buttonNames.length;a++){b=lpMTagConfig.buttonNames[a];lpMTagConfig["db"+(a+1)]==null&&(lpMTagConfig["db"+(a+1)]={});b={name:b,pid:this.buttonDivMustBePresentOnLoad&&document.getElementById(b)!=null?b:this.defaultButtonDivID,afterStartPage:!0,ovr:"lpMTagConfig.db"+(a+1)};if(this.SSOURL)b.SSOURL=this.SSOURL;lpMTagConfig.dynButton[lpMTagConfig.dynButton.length]=b}if(this.buttonDivMustBePresentOnLoad){var f=this;lpMTagConfig.onLoadCode[lpMTagConfig.onLoadCode.length]=function(){if(typeof lpMTagConfig.dynButton!=
"undefined")for(var a=0;a<lpMTagConfig.dynButton.length;a++)typeof lpMTagConfig.dynButton[a].pid!="undefined"&&document.getElementById(lpMTagConfig.dynButton[a].pid)==null&&(f.log("Removing dynButton "+lpMTagConfig.dynButton[a].name,"DEBUG"),lpMTagConfig.dynButton.splice(a,1),a--)}}}};
if(typeof lpMTagConfig.pluginCode=="undefined")lpMTagConfig.pluginCode={};
lpMTagConfig.pluginCode.sendLPVarsFromPage={ver:1,name:"sendLPVarsFromPage",lpVarMappings:[],sendEmptyValues:!1,maxVarNameLength:50,maxVarValueLength:50,pullFromQueryString:!0,doProcessMappings:!0,setup:function(){this.log(this.name+" setup","DEBUG");this.processMappings()},start:function(){this.log(this.name+" start","DEBUG");this.processMappings()},processMappings:function(){if(this.doProcessMappings){this.processQueryString();for(var b=0;b<this.lpVarMappings.length;b++)this.processMapping(this.lpVarMappings[b]);
this.doProcessMappings=!1}},processQueryString:function(){try{if(this.queryStringTable==null)this.queryStringTable={};for(var b=window.location.search.substring(1).split("&"),a=0;a<b.length;a++){var c=b[a].split("=");if(this.pullFromQueryString&&c[0].indexOf("!")>0){var d=c[0].split("!"),e="";d[0]=="PV"?e="page":d[0]=="SV"?e="session":d[0]=="VV"&&(e="variable");e!=""&&c.length==2&&this.addVar(e,d[1],c[1])}c.length>1&&(this.queryStringTable[c[0]]=c[1])}}catch(f){}},getMetaTagTable:function(){if(this.metaTagTable==
null){this.metaTagTable={};for(var b=document.getElementsByTagName("meta"),a=0;a<b.length;a++)b[a].getAttribute("name")!==null&&(this.metaTagTable[b[a].getAttribute("name")]=b[a])}return this.metaTagTable},getCookieTable:function(){if(this.cookieTable==null){this.cookieTable={};for(var b=document.cookie.split(";"),a=0;a<b.length;a++)this.cookieTable[this.trim(b[a].substring(0,b[a].indexOf("=")))]=b[a]}return this.cookieTable},trim:function(b){return b.replace(/^\s+|\s+$/g,"")},addVar:function(b,a,
c){if(lpMTagConfig.vars!=null&&typeof lpMTagConfig.vars=="array")lpMTagConfig.push([b,a,c]);else{if(a.indexOf("OrderTotal")!=-1||a.indexOf("OrderNumber")!=-1)if(c==""||c==0)return;else lpMTagConfig.sendCookies=!1;c=this.trim(c.toString());a.length>this.maxVarNameLength&&(a=a.substr(0,this.maxVarNameLength));c.length>this.maxVarValueLength&&(c=c.substr(0,this.maxVarValueLength));switch(b){case "page":lpMTagConfig.pageVar[lpMTagConfig.pageVar.length]=escape(a)+"="+escape(c);break;case "session":lpMTagConfig.sessionVar[lpMTagConfig.sessionVar.length]=
escape(a)+"="+escape(c);break;case "visitor":lpMTagConfig.visitorVar[lpMTagConfig.visitorVar.length]=escape(a)+"="+escape(c)}}},processMapping:function(b){try{for(var a=b.name,c=b.scope,d=null,e=0;e<b.methods.length;e++)if(d=this.executeMethod(a,b.methods[e]),d!=null&&d!="")break;d!=null?d!=""||this.sendEmptyValues?this.addVar(c,a,d):this.log("Plugin "+this.name+" empty value for variable "+a,"WARN"):this.log("Plugin "+this.name+" null value for variable "+a,"WARN")}catch(f){this.log("Plugin "+this.name+
" exception in processing mapping for variable "+b.name+":"+f,"WARN")}},executeMethod:function(b,a){a.type||this.log("Plugin "+this.name+" no type specified for method for variable "+b,"ERROR");var c;switch(a.type){case "meta":if(a.metaname){var d=this.getMetaTagTable()[a.metaname];d&&d.getAttribute("name")==a.metaname&&(c=d.getAttribute("content"))}else this.log("Plugin "+this.name+" no metaname specified for meta method for variable "+b,"ERROR");break;case "cookie":a.cookiename?(d=this.getCookieTable()[a.cookiename])?
c=this.trim(d.substring(d.indexOf("=")+1)):this.log("Plugin "+this.name+" no cookie with name "+a.cookiename,"WARN"):this.log("Plugin "+this.name+" no cookiename specified for cookie method for variable "+b,"ERROR");break;case "jsref":a.jsref?c=eval(a.jsref):this.log("Plugin "+this.name+" no jsref specified for js method for variable "+b,"ERROR");break;case "regex":if(a.pattern){d="";if(a.elementID!=""&&a.elementID!=null){var e=document.getElementById(a.elementID);e?d=e.innerHTML:this.log("Plugin "+
this.name+" no element found with ID "+a.elementID,"WARN")}else d=document.getElementsByTagName("body")[0].innerHTML;if(d!=null||d!="")a.searchLiteralOnly&&(d=d.replace(/<[^>]*>/g,"").replace(/\s+/g," ")),(d=a.pattern.exec(d))&&d.length>0?c=d[0].replace(a.pattern,a.replace):a.pattern&&this.log("Plugin "+this.name+" no match found for regex "+a.pattern)}else this.log("Plugin "+this.name+" no regex specified for regex method for variable "+b,"ERROR");break;case "func":a.func&&(c=a.func());break;case "query":typeof a.key!=
"undefined"?c=this.queryStringTable[a.key]:this.log("Plugin "+this.name+' No "key" defined for "'+a.type+'" method for variable '+b,"ERROR");break;default:return this.log("Plugin "+this.name+" unrecognized method type "+a.type+" for variable "+b,"ERROR"),null}return a.getValue&&c?a.getValue(c):c}};
if(typeof lpMTagConfig.initPluginSys=="undefined")lpMTagConfig.initPluginSys=function(){try{for(var a in lpMTagConfig.plugins){for(var c in lpMTagConfig.pluginCode.lpBasePlugin)typeof lpMTagConfig.pluginCode[a]!="undefined"&&(lpMTagConfig.pluginCode[a][c]=lpMTagConfig.pluginCode.lpBasePlugin[c]);typeof lpMTagConfig.pluginCode[a].init!="undefined"&&lpMTagConfig.pluginCode[a].init();typeof lpMTagConfig.pluginCode[a].setup=="function"&&lpMTagConfig.pluginCode[a].setup();typeof lpMTagConfig.pluginLoaded!=
"undefined"&&lpMTagConfig.pluginLoaded(lpMTagConfig.pluginCode[a].name)}}catch(j){if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Exceptions in processing pluginRef:"+j,"ERROR","PLUGIN-SYS");else throw j;}a=function(a,b){typeof a[b.name]=="undefined"&&(a[b.name]=function(a,c){return arguments.callee.hooks?lpMTagConfig.runPluginHooks(arguments.callee.hooks,b.name,{objName:a,status:c}):lpMTagConfig.runPluginHooks(lpMTagConfig.pluginHook.dynButtons,b.name,{objName:a,status:c})});
if(!a[b.name].hooks)a[b.name].hooks=[];a[b.name].hooks.push(b)};try{for(c in lpMTagConfig.pluginRef){var f=lpMTagConfig.pluginRef[c];if(typeof f.dbOvrObj!="undefined")for(var g=0;g<f.dbOvrObj.length;g++){var h=eval(f.dbOvrObj[g]);if(h){for(var d=0;d<lpMTagConfig.pluginHook.dynButtons.length;d++)a(h,lpMTagConfig.pluginHook.dynButtons[d]);if(f.dynButtonHooks)for(var i=0;i<f.dynButtonHooks.length;i++)a(h,f.dynButtonHooks[i])}}}}catch(k){if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Exceptions in processing dbOvrObj:"+
k,"ERROR","PLUGIN-SYS");else throw k;}try{for(d=0;d<lpMTagConfig.pluginHook.invite.length;d++)(function(a){var b=lpMTagConfig.pluginHook.invite[a];typeof lpMTagConfig[b.name]=="undefined"&&(lpMTagConfig[b.name]=function(a){return lpMTagConfig.runPluginHooks(lpMTagConfig.pluginHook.invite,b.name,{objName:a})})})(d)}catch(l){if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Exceptions in processing invite hooks:"+l,"ERROR","PLUGIN-SYS");else throw l;}lpMTagConfig.runPluginHooks=
function(a,b,c){try{for(var d=!0,f=0;f<a.length;f++){var g=a[f];if(g.name==b){typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display&&lpMTagDebug.Display("runPluginHooks running:"+b,"DEBUG","PLUGIN-SYS");c.prevRet=d;var h=g.run(c);h===!1&&(d=h)}}}catch(i){if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Exceptions in runPluginHooks:"+i,"ERROR","PLUGIN-SYS");else throw i;}return d};try{for(c in lpMTagConfig.pluginRef)c!="lpBasePlugin"&&typeof lpMTagConfig.pluginRef[c].start!=
"undefined"&&lpMTagConfig.pluginRef[c].start()}catch(m){if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Exceptions in processing start evets:"+m,"ERROR","PLUGIN-SYS");else throw m;}},lpMTagConfig.initPluginSys();else if(typeof e!="undefined")if(typeof lpMTagDebug!="undefined"&&lpMTagDebug.Display)lpMTagDebug.Display("Trying to define and run initPluginSys more than once (Check for multiple mtagconfig.js):"+e,"ERROR","PLUGIN-SYS");else throw e;else typeof lpMTagDebug!=
"undefined"&&lpMTagDebug.Display&&lpMTagDebug.Display("Trying to define and run initPluginSys more than once (Check for multiple mtagconfig.js):","ERROR","PLUGIN-SYS");
