package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
public class AddNewContactTestCase extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    ContactData contactData = new ContactData("Elizabeth", "Alexandra", "Mary",
            "Queen", "Elizabeth 2", "monarch", "house of Windsor", "123456",
            "9115641235", "654321", "654321", "eliza@gmail.ru", "6",
            "February", "1952", "test name 6");

    app.goTo().groupPage();
    if (!app.group().isCheckGroupe(contactData.group())){
      GroupData group = new GroupData().withName(contactData.group());
      app.group().createGroup(group);
    }

    app.goTo().Home();

    List<ContactData> before = app.contact().list();
    before.add(contactData);

    app.goTo().AddNew();
    app.contact().create(contactData);
    app.goTo().Home();
    List<ContactData> after = app.contact().list();
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    //assertThat(after, equalTo(before));

  }

}
