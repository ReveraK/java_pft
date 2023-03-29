package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupsHelper().getGroupCount();
    if (!app.getGroupsHelper().isThereAGroup()){
      app.getGroupsHelper().createGroup(new GroupData("test name", "test", "test"));
      app.getNavigationHelper().gotoGroupPage();
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("test name", "test", "text"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGoPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before);

  }
}
