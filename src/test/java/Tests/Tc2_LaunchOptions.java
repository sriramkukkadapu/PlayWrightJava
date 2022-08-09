package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tc2_LaunchOptions {

	public static void main(String args[]) {
		
		Playwright pw = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("firefox");
		lp.setHeadless(false);
		
		Browser browser = pw.firefox().launch(lp);
		Page page = browser.newPage();
		page.navigate("https://www.google.co.in");
		
		String title = page.title();
		System.out.println(title);
		
		String url = page.url();
		System.out.println(url);
		
		browser.close();
		pw.close();
	}
}
