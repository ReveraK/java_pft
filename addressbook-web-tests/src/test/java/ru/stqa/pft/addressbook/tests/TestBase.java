package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "path_here");
    //System.setProperty("chromedriver.chrome.driver", "path_here");
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
