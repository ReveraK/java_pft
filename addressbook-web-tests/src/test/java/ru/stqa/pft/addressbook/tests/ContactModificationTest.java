package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoHome();
    app.getContactHelper().changeContact();
    app.getContactHelper().modificationContact(new ContactData("Kate", "Helen", " ",
            " ", "Katherin 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952",  null));
    app.getContactHelper().submitContactModification();

  }
}
