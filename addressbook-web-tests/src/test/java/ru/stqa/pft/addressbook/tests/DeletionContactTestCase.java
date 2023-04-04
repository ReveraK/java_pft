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
      app.contact().create(new ContactData("Elizabeth", "Alexandra", "Mary",
              "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
              "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
              "February", "1952", "test name"));
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


