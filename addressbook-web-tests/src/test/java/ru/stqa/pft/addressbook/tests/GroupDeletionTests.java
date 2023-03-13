package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase {
  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().deleteSelectedGroups();
    app.getGroupsHelper().returnToGoPage();

  }


}
