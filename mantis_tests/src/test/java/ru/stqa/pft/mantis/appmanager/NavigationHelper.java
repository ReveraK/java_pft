package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }
  public void home() {
    wd.get(app.getProperty("web.baseUrl"));
  }
}
