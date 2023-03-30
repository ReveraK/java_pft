package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    //int before = app.getGroupsHelper().getGroupCount();
    GroupData group = new GroupData("test name", "test", "text");
    app.getGroupsHelper().createGroup(group);
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    //int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);


   /* int max =0;
    for (GroupData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }

    */
   //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
