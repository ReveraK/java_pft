package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  private WebDriver wd;
  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftpHelper;
  private MailHelper mailHelper;
  private DbHelper dbHelper;
  private UserHelper userHelper;
  private NavigationHelper navigationHelper;
  private SoapHelper soapHelper;
  private RestHelper restHelper;

  public ApplicationManager(String browser) {
    properties = new Properties();
    this.browser = browser;

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void stop() {
    if (wd != null){
      wd.quit();
    }
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null){
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public UserHelper user() {
    if (userHelper == null){
      userHelper = new UserHelper(this);
    }
    return userHelper;
  }

  public MailHelper mail() {
    if (mailHelper == null){
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }

  public NavigationHelper navigation() {
    if (navigationHelper == null){
      navigationHelper = new NavigationHelper(this);
    }
    return navigationHelper;
  }

  public SoapHelper soap() {
    if (soapHelper == null){
      soapHelper = new SoapHelper(this);
    }
    return soapHelper;
  }

  public RestHelper rest() {
    if (restHelper == null){
      restHelper = new RestHelper(this);
    }
    return restHelper;
  }

  public WebDriver getDriver() {
    if (wd == null){
      if (browser.equals(Browser.FIREFOX.browserName())) {
        wd = new FirefoxDriver();
      } else if (browser.equals(Browser.CHROME.browserName())) {
        System.setProperty("chromedriver.chrome.driver", "path_here");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        //wd = new ChromeDriver();
      } else if (browser.equals(Browser.IE.browserName())) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

  public FtpHelper ftp(){
    if (ftpHelper == null){
      ftpHelper = new FtpHelper(this);
    }
    return ftpHelper;
  }

  public DbHelper db() {
    if (dbHelper == null){
      dbHelper = new DbHelper();
    }
    return dbHelper;
  }
}
