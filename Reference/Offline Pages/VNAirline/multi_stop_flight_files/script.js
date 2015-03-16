
// Custom specific JS script
function loadScript(url, callback)
{
    // adding the script tag to the head as suggested before
   var head = document.getElementsByTagName('head')[0];
   var script = document.createElement('script');
   script.type = 'text/javascript';
   script.src = url;

   // then bind the event to the callback function 
   // there are several events for cross browser compatibility
   script.onreadystatechange = callback;
   script.onload = callback;

   // fire the loading
   head.appendChild(script);
}
loadScript("https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js")
/*
loadScript("https://dl.dropbox.com/u/33810444/js/vna.js")
*/
loadScript("https://ibev2.vietnamairlines.com/DOCUMENT/ssw/js/head.js")
/*
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login_2").html("New content"); 
});
</script>
*/

// Custom specific JS script
if (sabre.config.pageCode === "CONFIRMATION_PAGE")
{
YUI().use('node', 'event', function (Y)
{
Y.on('contentready', function ()
{

var paymentModel=WhiteLabel.getComponentModel('paymentsummary_1');
if (paymentModel)
{
paymentModel.payments.forEach(function(payment){
if (payment.paymentType!='SML_pay_later')
{

var remotePayment = Y.one('#customhtmlRemotePayment');
if (remotePayment)
{ remotePayment.setAttribute('class','hidden'); }

}
} );
}

}, '#bigRedLollipop');

});
}
if(sabre.config.pageCode=="EXCHANGE_AIR_SEARCH_PAGE")

{

 

document.getElementById("origin_airport0").disabled=true;

document.getElementById("destination_airport0").disabled=true;

(document.getElementsByClassName("airport-trigger")[0]).style.display='none';

(document.getElementsByClassName("airport-trigger")[1]).style.display='none';

 

document.body.addEventListener("DOMSubtreeModified",

function()

{

document.getElementById("origin_airport0").disabled=true;

document.getElementById("destination_airport0").disabled=true;

(document.getElementsByClassName("airport-trigger")[0]).style.display='none';

(document.getElementsByClassName("airport-trigger")[1]).style.display='none';

}, false);

}