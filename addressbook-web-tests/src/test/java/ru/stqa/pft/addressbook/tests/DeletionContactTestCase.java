package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class DeletionContactTestCase extends TestBase {

  @Test
  public void testContactDeletionTests() throws Exception {
    app.getNavigationHelper().gotoHome();
    if (! app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().gotoAddNew();
      ContactData contact = new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name");
      app.getContactHelper().createContact(contact, true);
      app.getNavigationHelper().gotoHome();


    }
    List<ContactData> before = app.getContactHelper().getСontactList();
    before.remove(0);
    app.getContactHelper().DeleteContact();
    app.getNavigationHelper().gotoHome();
    List<ContactData> after = app.getContactHelper().getСontactList();
    Assert.assertEquals(before, after);

  }


}


