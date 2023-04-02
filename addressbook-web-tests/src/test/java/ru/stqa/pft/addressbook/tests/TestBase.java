package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(Browser.FIREFOX.browserName());

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "path_here");
    //System.setProperty("chromedriver.chrome.driver", "path_here");
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
