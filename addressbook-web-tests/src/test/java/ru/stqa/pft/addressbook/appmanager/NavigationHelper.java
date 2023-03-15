package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoPage(String nameButton) {
    click(By.linkText(nameButton));
  }
  public void gotoGroupPage() {
    gotoPage("groups");
  }
  public void gotoAddNew() {
    gotoPage("add new");
  }
}
