package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().Home();
    if (app.db().contacts().size() == 0) {
      if (app.contact().list().size() == 0) {
        ContactData contactData = new ContactData().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
                .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
                .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952");

//        app.goTo().groupPage();
//        app.group().checkGroup(contactData.group());

        app.goTo().AddNew();
        app.contact().create(contactData);
        app.goTo().Home();

      }
    }
  }
  @Test
  public void testContactPhone() {

    app.goTo().Home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
   // assertThat(contact.telhome(), equalTo(cleaned(contactInfoFromEditForm.telhome())));
   // assertThat(contact.telmobile(), equalTo(cleaned(contactInfoFromEditForm.telmobile())));
   // assertThat(contact.telwork(), equalTo(cleaned(contactInfoFromEditForm.telwork())));
    assertThat(contact.allPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.allEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.address(), equalTo(contactInfoFromEditForm.address().trim()));
  }

  private String  mergeEmails(ContactData contact) {
    return Arrays.asList(contact.email(),contact.email2(),contact.email3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.telhome(),contact.telmobile(),contact.telwork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
