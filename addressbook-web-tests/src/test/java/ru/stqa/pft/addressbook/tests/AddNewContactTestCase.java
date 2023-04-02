package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTestCase extends TestBase {

  @Test(enabled = false)
  public void testAddNewContact() throws Exception {

    app.goTo().gotoHome();
    ContactData contactData = new ContactData("Elizabeth", "Alexandra", "Mary",
            "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952", "test name");

    List<ContactData> before = app.contact().getСontactList();
    before.add(contactData);

    app.goTo().gotoAddNew();
    app.contact().createContact(contactData);
    app.goTo().gotoHome();
    List<ContactData> after = app.contact().getСontactList();
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
