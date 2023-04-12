package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().createGroup(new GroupData().withName("test1"));
      app.goTo().groupPage();
    }
  }
  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId()).withName("test").withFooter("test").withHeader("test");
    app.group().modifyGroup(group);
    assertThat(app.group().сount(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifyGroup).withAdded(group))) ;

  }


}
