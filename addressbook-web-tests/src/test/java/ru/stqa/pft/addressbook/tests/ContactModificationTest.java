package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoHome();
    if (! app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().gotoAddNew();
      app.getContactHelper().createContact(new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name"), true);
      app.getNavigationHelper().gotoHome();

    }
    List<ContactData> before = app.getContactHelper().getСontactList();
    app.getContactHelper().changeContact(before.size() - 1);
    ContactData contactM = new ContactData("Kate", "Helen", "",
            " ", "Katherin 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952",  null);
    app.getContactHelper().fillContact(contactM, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHome();
    List<ContactData> after = app.getContactHelper().getСontactList();
    before.remove(before.size() - 1);
    before.add(contactM);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
