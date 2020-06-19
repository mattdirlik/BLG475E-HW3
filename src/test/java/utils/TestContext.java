package utils;

import configs.InternalProps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestContext
{
    private InternalProps internalProps;
    private Browser browser;

    public TestContext()
    {
        this.internalProps = new InternalProps();
    }

    
    public Browser doCreateBrowser()
    {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        // initialize webdriver
        WebDriver driver = new ChromeDriver();

        //Assign browser variable in Context
        this.browser = new Browser(this, driver);

        return browser;
    }
    
    public Browser doCreateBrowserWithProfile()
    {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Matthew Dirlik/AppData/Local/Google/Chrome/User Data");
        //adds my user profile to Chrome to keep the session logged in
        
        
        WebDriver driver = new ChromeDriver(options);       
        this.browser = new Browser(this, driver);
        return browser;
    }

    //Getters and Setters


    public InternalProps getInternalProps()
    {
        return internalProps;
    }

    public void setInternalProps(InternalProps internalProps)
    {
        this.internalProps = internalProps;
    }

    public Browser getBrowser()
    {
        return browser;
    }

    public void setBrowser(Browser browser)
    {
        this.browser = browser;
    }
}
