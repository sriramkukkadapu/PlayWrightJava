# Official Java docs of Playwright
<a href="https://playwright.dev/java/docs/intro">https://playwright.dev/java/docs/intro</a>


# Command to install browser binaries via command line
We dont have to do this manually because in pom.xml when we use playwright, when we execute test it automatically downloads all the dependencies

```shell
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```
# To Launch actual Chrome browser instead of chromium

```java
		Playwright pw = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");  //firefox
		lp.setHeadless(false);
		
		Browser browser = pw.chromium().launch(lp); //firefox
		Page page = browser.newPage();
		page.navigate("https://www.google.co.in");
```
# Open Playwright inspector
```shell
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen <URL of website>"
```
# Ways to open debugger of playwright
```java
1. Using Run configurations of eclipse set PWDEBUG=1
2. Using page.pause() in the script wherever you want to debug
```



