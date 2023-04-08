package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class AddNewContactTestCase extends TestBase {


  @Test
  public void testAddNewContact() throws Exception {
    File photo = new File("src/test/resources/111.png");
    //System.out.println(photo.getAbsolutePath());
    ContactData contactData = new ContactData ().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
            .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
            .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6")
            .withPhoto(photo);


    app.goTo().groupPage();
    app.group().checkGroup(contactData.group());
    app.goTo().Home();
    Contacts before = app.contact().all();
    app.goTo().AddNew();
    app.contact().create(contactData);
    app.goTo().Home();
    Contacts after = app.contact().all();
    //Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //before.sort(byId);
    //after.sort(byId);
    //contactData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    //before.add(contactData);
    assertThat(after, equalTo(
            before.withAdded(contactData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
