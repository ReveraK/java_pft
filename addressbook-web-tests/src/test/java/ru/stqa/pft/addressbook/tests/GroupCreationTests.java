package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new  Object[] {new GroupData().withName("test1").withHeder("header1").withFooter("footer1")});
    list.add(new  Object[] {new GroupData().withName("test2").withHeder("header2").withFooter("footer2")});
    list.add(new  Object[] {new GroupData().withName("test3").withHeder("header3").withFooter("footer3")});

    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {

     // GroupData group = new GroupData().withName(name).withHeder(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().createGroup(group);
      app.goTo().groupPage();
      Groups after = app.group().all();
      assertThat(app.group().сount(), equalTo(before.size() + 1));
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    //before.add(group);
   // Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
   // before.sort(byId);
   // after.sort(byId);

  }
  @Test
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test'");
    app.group().createGroup(group);
    app.goTo().groupPage();
    Groups after = app.group().all();
    assertThat(app.group().сount(), equalTo(before.size()));
    assertThat(after, equalTo(before));
  }

}
