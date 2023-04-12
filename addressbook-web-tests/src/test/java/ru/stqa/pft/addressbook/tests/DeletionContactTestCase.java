package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class DeletionContactTestCase extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().Home();
    if (app.db().contacts().size() == 0) {
      if (app.contact().list().size() == 0) {
        ContactData contactData = new ContactData().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
                .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
                .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6");

        app.goTo().groupPage();
        app.group().checkGroup(contactData.group());

        app.goTo().AddNew();
        app.contact().create(contactData);
        app.goTo().Home();

      }
    }
  }
  @Test
  public void testContactDeletionTests() throws Exception {
    Contacts before = app.db().contacts();;
    ContactData delContact = before.iterator().next();
    before.remove(delContact);
    app.contact().Delete(delContact.getId());
    app.goTo().Home();
    Contacts after = app.db().contacts();;
    assertThat(after, equalTo(before.without(delContact)));


  }


}


