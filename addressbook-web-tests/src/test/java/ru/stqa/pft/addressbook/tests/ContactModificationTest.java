package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @Test(enabled = false)
  public void testContactModification () {
    app.goTo().gotoHome();
    if (! app.contact().isThereContact()) {
      app.goTo().gotoAddNew();
      app.contact().createContact(new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name"));
      app.goTo().gotoHome();

    }
    List<ContactData> before = app.contact().getСontactList();
    app.contact().changeContact(before.size() - 1);
    ContactData contactM = new ContactData("Kate", "Helen", "",
            " ", "Katherin 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952",  null);
    app.contact().fillContact(contactM, false);
    app.contact().submitContactModification();
    app.goTo().gotoHome();
    List<ContactData> after = app.contact().getСontactList();
    before.remove(before.size() - 1);
    before.add(contactM);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
