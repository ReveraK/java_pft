package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class DeletionContactTestCase extends TestBase {

  @Test(enabled = false)
  public void testContactDeletionTests() throws Exception {
    app.goTo().gotoHome();
    if (! app.contact().isThereContact()) {
      app.goTo().gotoAddNew();
      ContactData contact = new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name");
      app.contact().createContact(contact);
      app.goTo().gotoHome();


    }
    List<ContactData> before = app.contact().getСontactList();
    before.remove(0);
    app.contact().DeleteContact();
    app.goTo().gotoHome();
    List<ContactData> after = app.contact().getСontactList();
    Assert.assertEquals(before, after);

  }


}


