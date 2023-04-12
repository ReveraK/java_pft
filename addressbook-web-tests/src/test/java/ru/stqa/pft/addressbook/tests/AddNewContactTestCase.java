package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class AddNewContactTestCase extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      xstream.allowTypes(new Class[]{ContactData.class});
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  }
  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); //List<ContactData>.class
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  }

  @Test(dataProvider = "validContactsFromJson")
  public void testAddNewContact(ContactData contact) throws Exception {
    //File photo = new File("src/test/resources/111.png");
    //System.out.println(photo.getAbsolutePath());
   // ContactData contactData = new ContactData ().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
    //        .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
    //        .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952").withGroup("test name 6")
     //       .withPhoto(photo);


    app.goTo().groupPage();
    app.group().checkGroup(contact.group());
    app.goTo().Home();
    //Contacts before = app.contact().all();
    Contacts before = app.db().contacts();
    app.goTo().AddNew();
    app.contact().create(contact);
    app.goTo().Home();
    //Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    //Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //before.sort(byId);
    //after.sort(byId);
    //contactData.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    //before.add(contactData);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
