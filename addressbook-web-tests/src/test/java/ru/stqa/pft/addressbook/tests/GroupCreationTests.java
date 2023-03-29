package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    int before = app.getGroupsHelper().getGroupCount();

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupsHelper().createGroup(new GroupData("test name", "test", "text"));
    app.getNavigationHelper().gotoGroupPage();

    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }


}
