package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {
    int before = app.getGroupsHelper().getGroupCount();
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupsHelper().isThereAGroup()){
      app.getGroupsHelper().createGroup(new GroupData("test name", "test", "test"));
      app.getNavigationHelper().gotoGroupPage();
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroups();
    app.getGroupsHelper().returnToGoPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }
}
