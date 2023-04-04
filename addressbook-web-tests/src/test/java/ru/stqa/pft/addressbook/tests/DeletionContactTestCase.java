package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class DeletionContactTestCase extends TestBase {
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
  public void testContactDeletionTests() throws Exception {
    List<ContactData> before = app.contact().list();
    before.remove(0);
    app.contact().Delete();
    app.goTo().Home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before, after);

  }


}


