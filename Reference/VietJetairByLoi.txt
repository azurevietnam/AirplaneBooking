using HtmlAgilityPack;
using Microsoft.Web.Services3.Security.Tokens;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Net;
using System.Security.Cryptography.X509Certificates;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.ServiceModel.Dispatcher;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;
using TestService.AuthenticationService;
using TestService.P6CacheController;
using Turnstile.Extensions;

namespace TestService
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
            try
            {
                //var securityElement = SecurityBindingElement.CreateUserNameOverTransportBindingElement();

                //securityElement.AllowInsecureTransport = true; //in case you don't use SSL
                //securityElement.EnableUnsecuredResponse = true; //in case you don't use SSL
                //var encodingElement = new TextMessageEncodingBindingElement(MessageVersion.Soap11, Encoding.UTF8);
                //var transportElement = new HttpTransportBindingElement();
                //var binding = new CustomBinding(securityElement, encodingElement, transportElement);

                //EndpointAddress endpointAddress = new EndpointAddress("http://khonemdcasl15.kiewitplaza.com:8208/p6ws/services/AuthenticationService");

                //WebProxy proxy = new WebProxy("http://euronetproxy.ch.zurich.com/pacfile", true); //http://wps-proxy.zurich.com:8080
                //proxy.Credentials = new NetworkCredential("W995122", "Phuoc1234", "EZCORP");
                //proxy.UseDefaultCredentials = false;
                //WebRequest.DefaultWebProxy = proxy;
                //exportService.ExportProject(project);kiewitplaza


                //AuthenticationServicePortTypeClient authService = new AuthenticationServicePortTypeClient(binding, endpointAddress);
                //AuthenticationServicePortTypeClient authService = new AuthenticationServicePortTypeClient("AuthenticationServiceSOAP12port_http");
                //P6CacheControllerClient p6CacheService = new P6CacheControllerClient("BasicHttpBinding_IP6CacheController");

                //p6CacheService.ClientCredentials.UserName.UserName = "kiewitplaza\\Huy.Tieu";
                //p6CacheService.ClientCredentials.UserName.Password = "P@ssword123";
                //var projects = p6CacheService.GetAllProjects();
                //PasswordDigestBehavior behavior = new PasswordDigestBehavior("Huy.Tieu", "P@ssword123");
                //authService.ClientCredentials.UserName.UserName = "Huy.Tieu";
                //authService.ClientCredentials.UserName.Password = "P@ssword123";
                //p6CacheService.Endpoint.Behaviors.Add(behavior);

                //var response = authService.Login(new Login
                //{
                //    UserName = "Huy.Tieu",
                //    Password = "P@ssword123",
                //    DatabaseInstanceId = 7
                //});

                var encoding = ASCIIEncoding.UTF8;
                var sessionId = "";
                //string postString = "ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListCurrency=VND&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListFareTypes=I&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay1=10&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay2=14&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth1=2015-5&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth2=2015-5&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_ADT=1&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_CHD=0&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_INFANT=0&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24RadioButtonMarketStructure=RoundTrip&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination1=DAD&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin1=SGN&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin3=&ControlGroupSearchView%24ButtonSubmit=&__VIEWSTATE=%2FwEPDwUBMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFJ01lbWJlckxvZ2luU2VhcmNoVmlldyRtZW1iZXJfUmVtZW1iZXJtZSDCMtVG%2F1lYc7dy4fVekQjBMvD5&culture=vi-VN&date_picker=&go-booking=&pageToken=sLkmnwXwAsY%3D&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24fromCS=yes";
                string postStringStep1 = "chkRoundTrip=on&lstOrigAP=SGN&lstDestAP=VII&dlstDepDate_Day=10&dlstDepDate_Month=2015%2F04&dlstRetDate_Day=30&dlstRetDate_Month=2015%2F04&lstCurrency=VND&lstResCurrency=VND&lstDepDateRange=0&lstRetDateRange=0&txtNumAdults=1&txtNumChildren=0&txtNumInfants=0&lstLvlService=1&blnFares=False&txtPromoCode=";
                string postStringStep2 = "__VIEWSTATE=%2FwEPDwULLTE1MzQ1MjI3MzAPZBYCZg9kFg4CCA8QZGQWAGQCCQ8QZGQWAGQCCw8QZGQWAGQCDQ8QZGQWAGQCEQ8QZGQWAGQCEg8QZGQWAGQCEw8QZGQWAGRkDuhQN17CT5ZIydlFFSt%2BWc8NsCA%3D&__VIEWSTATEGENERATOR=BA3C3B49&SesID=&DebugID=29&lstOrigAP=-1&lstDestAP=-1&dlstDepDate_Day=15&dlstDepDate_Month=2015%2F03&lstDepDateRange=0&dlstRetDate_Day=15&dlstRetDate_Month=2015%2F03&lstRetDateRange=0&txtNumAdults=0&txtNumChildren=0&txtNumInfants=0&lstLvlService=1&lstResCurrency=VND&lstCurrency=VND&txtPromoCode=";
                //    
                const string contentType = "application/x-www-form-urlencoded";
                System.Net.ServicePointManager.Expect100Continue = false;

                //ServicePointManager.ServerCertificateValidationCallback += delegate { return true; };

                //string certName = "*.intelisys.ca";
                //X509Store store = new X509Store(StoreName.Root, StoreLocation.CurrentUser);
                //store.Open(OpenFlags.ReadOnly);
                //X509Certificate2Collection certificates = store.Certificates.Find(X509FindType.FindBySubjectName, certName, true);
                //X509Certificate certificate = certificates[0];

                HttpWebRequest webRequest = WebRequest.Create("https://ameliaweb5.intelisys.ca/VietJet/ameliapost.aspx?lang=en") as HttpWebRequest;
                CookieContainer cookies = new CookieContainer();
                //var session = new Cookie("ASP.NET_SessionId", "wx02r54bftfadcuabgkz2xfk", ,);
                //cookies.Add(session);
                webRequest.Method = "POST";
                webRequest.AllowAutoRedirect = false;
                webRequest.ContentType = contentType;
                webRequest.CookieContainer = cookies;
                webRequest.ContentLength = postStringStep1.Length;
                webRequest.UserAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2329.0 Safari/537.36";
                webRequest.Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
                //webRequest.Host = "booknow.jetstar.com";//ameliaweb5.intelisys.ca
                webRequest.Headers.Add("Accept-Encoding", "gzip,deflate");
                webRequest.Host = "ameliaweb5.intelisys.ca";//
                //webRequest.ClientCertificates.Add(certificate);

                StreamWriter requestWriter = new StreamWriter(webRequest.GetRequestStream());
                requestWriter.Write(postStringStep1);
                requestWriter.Close();

                HttpWebResponse httpWebResponse = webRequest.GetResponse() as HttpWebResponse;

                HttpWebRequest webRequestStep2 = WebRequest.Create("https://ameliaweb5.intelisys.ca/VietJet/ameliapost.aspx?lang=en") as HttpWebRequest; ;
                webRequestStep2.Method = "POST";
                webRequestStep2.AllowAutoRedirect = false;
                webRequestStep2.ContentType = contentType;
                webRequestStep2.CookieContainer = cookies;
                webRequestStep2.ContentLength = postStringStep2.Length;
                webRequestStep2.UserAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2329.0 Safari/537.36";
                webRequestStep2.Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
                webRequestStep2.Headers.Add("Accept-Encoding", "gzip,deflate");
                webRequestStep2.Host = "ameliaweb5.intelisys.ca";//
                //webRequestStep2.ClientCertificates.Add(certificate);

                foreach (Cookie cookie in httpWebResponse.Cookies)
                {
                    webRequestStep2.CookieContainer.Add(cookie);
                    if (cookie.Name == "ASP.NET_SessionId")
                        sessionId = cookie.Value;

                    Debug.WriteLine(cookie.Name + " - " + cookie.Value);
                }

                StreamWriter requestWriterStep2 = new StreamWriter(webRequestStep2.GetRequestStream());
                requestWriterStep2.Write(postStringStep2, 0, postStringStep2.Length);
                requestWriterStep2.Close();

                HttpWebResponse httpWebResponseStep2 = webRequestStep2.GetResponse() as HttpWebResponse;
                string location = httpWebResponseStep2.Headers["Location"];

                var responseStream = GetStreamForResponse(httpWebResponseStep2, 10000);
                using (StreamReader reader = new StreamReader(responseStream, encoding))
                {
                    string responseText = reader.ReadToEnd();
                    Debug.WriteLine(responseText);
                }

                var request = WebRequest.Create("https://ameliaweb5.intelisys.ca/VIETJET/TravelOptions.aspx?lang=en&st=pb&sesid=" + sessionId) as HttpWebRequest;
                request.CookieContainer = cookies;
                request.AllowAutoRedirect = false;
                request.Method = "GET";
                request.UserAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2329.0 Safari/537.36";
                request.Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
                request.Headers.Add("Accept-Encoding", "gzip,deflate");
                request.Host = "ameliaweb5.intelisys.ca";//
          
                HttpWebResponse httpWebResponse2 = request.GetResponse() as HttpWebResponse;

                using (var reader = new System.IO.StreamReader(GetStreamForResponse(httpWebResponse2, 10000), encoding))
                {
                    string responseText = reader.ReadToEnd();
                    HtmlDocument doc = new HtmlDocument();
                    doc.LoadHtml(responseText);
                    i = 0;
                    //Debug.WriteLine(responseText);
                }

                //using (var reader = httpWebResponse2.GetResponseStream())
                //{
                //    //string responseText = reader.ReadToEnd();
                //    //Debug.WriteLine(responseText);

                //    XmlDocument doc = new XmlDocument();
                //    doc.Load(reader);
                //    Debug.WriteLine(doc.InnerXml);
                //}

                i = 0;

                //var encoding = ASCIIEncoding.UTF8;

                //string postString = "ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListCurrency=VND&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListFareTypes=I&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay1=10&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay2=14&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth1=2015-5&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth2=2015-5&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_ADT=1&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_CHD=0&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListPassengerType_INFANT=0&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24RadioButtonMarketStructure=RoundTrip&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination1=DAD&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin1=SGN&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin3=&ControlGroupSearchView%24ButtonSubmit=&__VIEWSTATE=%2FwEPDwUBMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFJ01lbWJlckxvZ2luU2VhcmNoVmlldyRtZW1iZXJfUmVtZW1iZXJtZSDCMtVG%2F1lYc7dy4fVekQjBMvD5&culture=vi-VN&date_picker=&go-booking=&pageToken=sLkmnwXwAsY%3D&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24fromCS=yes";
                //const string contentType = "application/x-www-form-urlencoded";
                //System.Net.ServicePointManager.Expect100Continue = false;

                //HttpWebRequest webRequest = WebRequest.Create("http://booknow.jetstar.com/Search.aspx?culture=vi-VN") as HttpWebRequest;
                //CookieContainer cookies = new CookieContainer();
                //webRequest.Method = "POST";
                //webRequest.AllowAutoRedirect = false;
                //webRequest.ContentType = contentType;
                //webRequest.CookieContainer = cookies;
                //webRequest.ContentLength = postString.Length;
                //webRequest.UserAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2329.0 Safari/537.36";
                //webRequest.Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
                //webRequest.Host = "booknow.jetstar.com";
                //StreamWriter requestWriter = new StreamWriter(webRequest.GetRequestStream());
                //requestWriter.Write(postString);
                //requestWriter.Close();

                //HttpWebResponse httpWebResponse = webRequest.GetResponse() as HttpWebResponse;
                //string location = httpWebResponse.Headers["Location"];

                //var request = WebRequest.Create("http://booknow.jetstar.com/" + location) as HttpWebRequest;
                //request.CookieContainer = cookies;
                //request.AllowAutoRedirect = false;

                //request.Method = "POST";

                //StreamWriter requestWriter2 = new StreamWriter(request.GetRequestStream());
                //requestWriter2.Write(postString);
                //requestWriter2.Close();

                //HttpWebResponse httpWebResponse2 = request.GetResponse() as HttpWebResponse;

                //using (var reader = new System.IO.StreamReader(httpWebResponse2.GetResponseStream(), encoding))
                //{
                //    string responseText = reader.ReadToEnd();
                //    HtmlDocument doc = new HtmlDocument();
                //    doc.LoadHtml(responseText);
                //}

                //i = 0;
            }

            catch (WebException wex)
            {
                Debug.WriteLine(wex.InnerException);
            }
            catch (FaultException fex)
            {
                Debug.WriteLine(fex.Message);
            }
            catch (Exception ex)
            {
                Debug.WriteLine(ex.InnerException);
            }

        }

        private static Stream GetStreamForResponse(HttpWebResponse webResponse, int readTimeOut)
        {
            Stream stream;
            switch (webResponse.ContentEncoding.ToUpperInvariant())
            {
                case "GZIP":
                    stream = new GZipStream(webResponse.GetResponseStream(), CompressionMode.Decompress);
                    break;
                case "DEFLATE":
                    stream = new DeflateStream(webResponse.GetResponseStream(), CompressionMode.Decompress);
                    break;

                default:
                    stream = webResponse.GetResponseStream();
                    stream.ReadTimeout = readTimeOut;
                    break;
            }
            return stream;
        }
    }
}
