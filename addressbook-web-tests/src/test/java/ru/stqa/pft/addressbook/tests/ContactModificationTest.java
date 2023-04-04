package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().Home();
    if (app.contact().list().size() == 0) {
      app.goTo().AddNew();
      app.contact().create(new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name"));
      app.goTo().Home();

    }
  }
  @Test
  public void testContactModification () {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().change(index);
    ContactData contactM = new ContactData("Kate", "Helen", "",
            " ", "Katherin 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952",  null);

    app.contact().fillContact(contactM, false);
    app.contact().submitContactModification();
    app.goTo().Home();
    List<ContactData> after = app.contact().list();
    before.remove(index);
    before.add(contactM);

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
