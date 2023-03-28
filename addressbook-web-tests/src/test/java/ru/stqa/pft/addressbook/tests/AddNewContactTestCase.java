package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddNewContactTestCase extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {

    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().fillContact(new ContactData("Elizabeth", "Alexandra", "Mary",
            "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952", "test name"), true);
    app.getContactHelper().submitContactCreation();
  }

}
