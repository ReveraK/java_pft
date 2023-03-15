package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  public WebDriver wd;
  private NavigationHelper navigationHelper;
  private GroupsHelper groupsHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;

  public void init() {
    //wd = new ChromeDriver();
    //wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupsHelper = new GroupsHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);

    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }



  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupsHelper getGroupsHelper() {
    return groupsHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {return contactHelper; }
}
