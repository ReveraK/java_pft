package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupsHelper().isThereAGroup()){
      app.getGroupsHelper().createGroup(new GroupData("test name", "test", "test"));
      app.getNavigationHelper().gotoGroupPage();
    }
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(before.size() - 1);
    app.getGroupsHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(),"test", "test", "test");
    app.getGroupsHelper().fillGroupForm(group);
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGoPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
