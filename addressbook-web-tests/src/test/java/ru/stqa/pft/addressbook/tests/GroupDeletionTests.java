package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;


public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    /*app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.group().createGroup(new GroupData().withName("test1"));
      app.goTo().groupPage();
    }

     */

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().createGroup(new GroupData().withName("test1"));
      app.goTo().groupPage();
    }
  }
  @Test
  public void testGroupDeletion() throws Exception {
    //Groups before = app.group().all();
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().сount(), equalTo(before.size() - 1));
    //Groups after = app.group().all();
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));

  }


}
