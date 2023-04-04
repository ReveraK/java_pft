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
      ContactData contactData = new ContactData ().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
              .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
              .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6");
      app.goTo().Home();

    }
  }
  @Test
  public void testContactModification () {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().change(index);
    ContactData contactM = new ContactData ().withFirstname("Elizabeth1").withMiddlename("Alexandra1").withLastname("Mary1").withNickname("Queen")
            .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
            .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6");

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
