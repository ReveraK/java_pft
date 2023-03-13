package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

  WebDriver wd;
  private NavigationHelper navigationHelper;
  private GroupsHelper groupsHelper;
  private SessionHelper sessionHelper;

  public void init() {
    //new GroupsHelper();
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    //wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //js = (JavascriptExecutor) wd;
    wd.get("http://localhost/addressbook/group.php");
    groupsHelper = new GroupsHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  //public void login(String username, String password) {
   // wd.findElement(By.name("user")).clear();
   // wd.findElement(By.name("user")).sendKeys(username);
  //  wd.findElement(By.name("pass")).click();
   // wd.findElement(By.name("pass")).clear();
   // wd.findElement(By.name("pass")).sendKeys(password);
   // wd.findElement(By.xpath("//input[@value='Login']")).click();
  //}

  public void stop() {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
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
}
