package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tc1 {

	public static void main(String args[]) {
		
		Playwright pw = Playwright.create();
//		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Browser browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
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
