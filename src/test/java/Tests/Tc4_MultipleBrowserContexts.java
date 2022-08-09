package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tc4_MultipleBrowserContexts {

	public static void main(String args[]) {
		
		Playwright pw = Playwright.create();
		Browser browser= pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bc1 = browser.newContext();
		Page p1=bc1.newPage();
		p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		p1.fill("#Form_submitForm_Name", "Sriram" );
		System.out.println(p1.title());
		
		BrowserContext bc2 = browser.newContext();
		Page p2=bc2.newPage();
		p2.navigate("http://automationpractice.com");
		p2.fill("#search_query_top", "shirts" );
		System.out.println(p2.title());
		
		BrowserContext bc3 = browser.newContext();
		Page p3=bc3.newPage();
		p3.navigate("http://www.google.co.in");
//		p3.fill("#search_query_top", "shirts" );
		System.out.println(p3.title());
		
		browser.close();
		pw.close();
	}
}
