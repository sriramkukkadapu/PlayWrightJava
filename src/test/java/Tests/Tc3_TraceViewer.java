package Tests;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class Tc3_TraceViewer {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
    	 Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
    		        .setHeadless(false));
    		      BrowserContext context = browser.newContext();
    		      
    		   // Start tracing before creating / navigating a page.
    		      context.tracing().start(new Tracing.StartOptions()
    		    		  .setScreenshots(true)
    		    		  .setSnapshots(true));

    		      
    		      // Open new page
    		      Page page = context.newPage();
    		      // Go to https://academy.naveenautomationlabs.com/
    		      page.navigate("https://academy.naveenautomationlabs.com/");
    		      // Click text=Courses
    		      page.click("text=Courses");
    		      // assert page.url().equals("https://academy.naveenautomationlabs.com/s/store");
    		      // Click text=Login
    		      page.click("text=Login");
    		      page.click("text=Login");
    		      // Click button:has-text("Sign Up")
    		      page.click("button:has-text(\"Sign Up\")");
    		      // Click [placeholder="Name"]
    		      page.click("[placeholder=\"Name\"]");
    		      // Fill [placeholder="Name"]
    		      page.fill("[placeholder=\"Name\"]", "Sriram");
    		      // Press Tab
    		      page.press("[placeholder=\"Name\"]", "Tab");
    		      // Fill [placeholder="Email"]
    		      page.fill("[placeholder=\"Email\"]", "test123@gmail.com");
    		      // Press Tab
    		      page.press("[placeholder=\"Email\"]", "Tab");
    		      // Fill [placeholder="Create Password"]
    		      page.fill("[placeholder=\"Create Password\"]", "test123");
    		      // Click [placeholder="Mobile"]
    		      page.click("[placeholder=\"Mobile\"]");
    		      // Fill [placeholder="Mobile"]
    		      page.fill("[placeholder=\"Mobile\"]", "9060109968");
    		      // Click text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i
    		      page.click("text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i");
    		      // Click #loginFormHtml div [aria-label="Close"]
    		      page.click("#loginFormHtml div [aria-label=\"Close\"]");
    		      
    		      
    		      context.tracing().stop(new Tracing.StopOptions()
    		    		  .setPath(Paths.get("trace.zip")));
    }
  }
}