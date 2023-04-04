package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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

    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    app.contact().change(modifyContact.getId());
    ContactData contactM = new ContactData ().withFirstname("Elizabeth1").withMiddlename("Alexandra1").withLastname("Mary1").withNickname("Queen")
            .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
            .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6")
            .withId(modifyContact.getId());

    app.contact().fillContact(contactM, false);
    app.contact().submitContactModification();
    app.goTo().Home();
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contactM)));

  }
}
