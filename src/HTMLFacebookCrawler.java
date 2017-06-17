	import java.awt.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Locale;

import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
	import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;
import com.gargoylesoftware.htmlunit.javascript.host.URL;

public class HTMLFacebookCrawler {



	public static boolean login(String email, String password, WebClient webClient) throws Exception { // logins to Facebook
		try {
			HtmlPage loginPage = webClient.getPage("https://en-gb.facebook.com/login/");
			java.util.List<HtmlForm> forms = loginPage.getForms();
			HtmlForm form = forms.get(0);
			HtmlInput userName = form.getInputByName("email");
			userName.setValueAttribute(email);
			HtmlPasswordInput passwd = form.getInputByName("pass");
			passwd.setValueAttribute(password);
			// Thread.sleep(20000);
			HtmlButton loginButton = form.getButtonByName("login");
			HtmlPage homePage = loginButton.click();
			synchronized (homePage) {
				homePage.wait(200); //akla zarar yavaş internette arttır
			}
			return true;
		
		} catch (FailingHttpStatusCodeException e) {
			return false;
			// TODO Auto-generated catch block
		//	logger.info(e.toString());
		} catch (MalformedURLException e) {
			return false;
			// TODO Auto-generated catch block
		//	logger.info(e.toString());
		} catch (IOException e) {
			return false;
			// TODO Auto-generated catch block
			//logger.info(e.toString());
		} 
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		  long startTime = System.currentTimeMillis();
		  long elapsedTime = 0L;
		 // Locale.setDefault(Locale.TURKISH);
		  WebClient webClient = new WebClient();
		  webClient.getOptions().setJavaScriptEnabled(false); //necessary, but don't know why
		  login("example.example578@gmail.com", "B'h^t<i>a&a.b}k{r!m?1", webClient);
		  
		  
			  
								
			//	HtmlPage test = webClient.getPage("https://m.facebook.com/profile.php?id=731533496");
			 // HtmlPage test = webClient.getPage("https://m.facebook.com/profile.php?v=info&lst=100011796008658%3A100012941256728%3A1496958904&id=100012941256728");	
			//	 WebRequest webRequest = new WebRequest(new java.net.URL("https://m.facebook.com/profile.php?id=862110653"));
			  //      webRequest.setCharset("utf-8");
				HtmlPage test = webClient.getPage("https://m.facebook.com/profile.php?id=862110653");
			  //	System.out.println(homePage.asText());
				System.out.println(test.asText());
				// writeToFile(Config.absPath+"Facebook.txt", content);
				System.out.println("\n" + "\n" + "----------New Person---------" + "\n" + "\n");
				
			//	WebRequest webRequest2 = new WebRequest(new java.net.URL("https://m.facebook.com/profile.php?id=100003158983201"));
				HtmlPage test2 = webClient.getPage("https://m.facebook.com/profile.php?id=100003158983201");
				System.out.println(test2.asText());
				
				System.out.println("\n" + "\n" + "----------New Person---------" + "\n" + "\n");
				
			//	WebRequest webRequest3 = new WebRequest(new java.net.URL("https://m.facebook.com/profile.php?id=588994067"));
				HtmlPage test3 = webClient.getPage("https://m.facebook.com/profile.php?id=588994067");
				System.out.println(test3.asText());			
				
				System.out.println("\n" + "\n" + "----------New Person---------" + "\n" + "\n");
				
			//	WebRequest webRequest4 = new WebRequest(new java.net.URL("https://m.facebook.com/profile.php?id=1529961799"));
				HtmlPage test4 = webClient.getPage("https://m.facebook.com/profile.php?id=1529961799");
				System.out.println(test4.asText());			
				
				 elapsedTime = (new Date()).getTime() - startTime;
				 System.out.println("\n"  + elapsedTime + " miliseconds");
		
		  webClient.close();
		 

		  
		  
		  /*
		  WebClient webClient = new WebClient();
		  webClient.getOptions().setJavaScriptEnabled(false);
		  HtmlPage page = webClient.getPage("https://en-gb.facebook.com/login/");
		  HtmlForm form = page.getHtmlElementById("login_form");
		//  HtmlSubmitInput button = (HtmlSubmitInput) form.getInputsByValue("Login").get(0);
		  final HtmlInput usernameInput = form.getInputByName("email");
		//  HtmlTextInput textField = form.getInputByName("email");
		  usernameInput.setValueAttribute("example.exxample578@gmail.com");
		  final HtmlInput userpassInput = form.getInputByName("pass");
		  userpassInput.setValueAttribute("B'h^t<i>a&a.b}k{r!m?1");
		//  HtmlPage page2 = button.click();
		//  HtmlSubmitInput submitBtn = (HtmlSubmitInput)page.getElementById("loginbutton").getFirstChild();//
		//  page = (HtmlPage) submitBtn.click();
		  System.out.println(page.asText());
			HtmlButton loginButton = form.getButtonByName("login");
			HtmlPage homePage = loginButton.click();
			synchronized (homePage) {
				homePage.wait(10000);
			}
			System.out.println(homePage.asText());
			*/
		  

		  
		  
		  
		  
		  /*
		  final WebClient webClient = new WebClient();
		    webClient.setJavaScriptEngine(new JavaScriptEngine(webClient));
		    webClient.getOptions().setJavaScriptEnabled(false);
		    HtmlPage page1 = null;
		    try {
		        page1 = webClient.getPage("http://www.facebook.com");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    final HtmlForm form = page1.getForms().get(0);

		    final HtmlSubmitInput button = (HtmlSubmitInput) form.getInputsByValue("Log In").get(0);
		    final HtmlTextInput textField = form.getInputByName("email");
		    textField.setValueAttribute("test@test.com");
		    final HtmlPasswordInput textField2 = (HtmlPasswordInput) page1.getElementById("pass");
		    textField2.setValueAttribute("password1");
		    try {
		        HtmlPage page2 = button.click();
		        System.out.println(page2.getTitleText());

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    */
		    /*
		     * 
		     *
		     
		  
		  WebClient webClient = new WebClient(BrowserVersion.CHROME);
		  webClient.getOptions().setUseInsecureSSL(true); //ignore ssl certificate
		    webClient.getOptions().setThrowExceptionOnScriptError(false);
		    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		    webClient.getOptions().setJavaScriptEnabled(false);
		  HtmlPage page1 = webClient.getPage("http://www.facebook.com");
		  System.out.println(page1.asText());
		  HtmlForm form = page1.getForms().get(0);
		  HtmlSubmitInput button = (HtmlSubmitInput) form.getInputsByValue("Login").get(0);
		  HtmlTextInput textField = form.getInputByName("email");
		  textField.setValueAttribute("example.example578@gmail.com");
		  HtmlPasswordInput textField2 = form.getInputByName("pass");
		  textField2.setValueAttribute("B'h^t<i>a&a.b}k{r!m?1");
		  HtmlPage page2 = button.click();
		  */
		  
		  /*
		    WebClient webClient = new WebClient(BrowserVersion.CHROME);
		    webClient.getOptions().setUseInsecureSSL(true); //ignore ssl certificate
		    webClient.getOptions().setThrowExceptionOnScriptError(false);
		    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		    String url = "https://m.facebook.com/profile.php?id=731533496";
		  //  String url = "https://m.facebook.com/kurtOGUZ/about?lst=100011796008658%3A731533496%3A1496923490";
		    HtmlPage myPage = webClient.getPage(url);
		    */
		  //  webClient.waitForBackgroundJavaScriptStartingBefore(200);
		    // webClient.waitForBackgroundJavaScript(20000);
		    //do stuff on page ex: myPage.getElementById("main")
		    //myPage.asXml() <- tags and elements
		//    System.out.println(myPage.asText());
		  

		//  final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
	   // webClient.getOptions().setThrowExceptionOnScriptError(false);
	  //  final HtmlPage page = webClient.getPage("http://library.bilkent.edu.tr");
	    
	   /* HtmlElement usrname = page.getElementByName("username");
	    
	    usrname.click();
	    usrname.type("myusername");
	    HtmlElement psswrd = page.getElementByName("password");
	    psswrd.click();
	    psswrd.type("mypassword");
	    HtmlSelect select = (HtmlSelect) page.getElementById("cmbProducts");
	    HtmlOption option = select.getOptionByValue("ITDirect");
	    select.setSelectedAttribute(option, true);
	    HtmlElement signin = page.getElementByName("SignIn");
	    signin.click();
	    */
	   // System.out.println(page);
	    // ((Object) webClient).closeAllWindows();
	  }
	

}
