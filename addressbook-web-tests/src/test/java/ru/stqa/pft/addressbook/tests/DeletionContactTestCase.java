package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class DeletionContactTestCase extends TestBase {

  @Test
  public void testGroupDeletionTests() throws Exception {
    app.getNavigationHelper().gotoHome();
    app.getContactHelper().DeleteContact();
  }


}
