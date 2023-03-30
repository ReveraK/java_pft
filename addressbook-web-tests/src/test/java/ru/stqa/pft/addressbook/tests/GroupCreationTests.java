package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    //int before = app.getGroupsHelper().getGroupCount();
    app.getGroupsHelper().createGroup(new GroupData("test name", "test", "text"));
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    //int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);
  }


}
