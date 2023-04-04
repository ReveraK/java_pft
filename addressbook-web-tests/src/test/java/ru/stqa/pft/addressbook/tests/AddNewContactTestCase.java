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
    ContactData contactData = new ContactData ().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
            .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
            .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6");


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
