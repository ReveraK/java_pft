package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.concurrent.RecursiveTask;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeGroupContactTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    if (groups.size() == 0){
      GroupData group = new GroupData().withName("group5");
      app.goTo().groupPage();
      app.group().createGroup(group);
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().Home();
      if (app.contact().list().size() == 0) {

        ContactData contactData = new ContactData().withFirstname("Elizabeth").withMiddlename("Alexandra").withLastname("Mary").withNickname("Queen")
                .withTitle("Elizabeth 2").withCompany("monarch").withAddress("house of Windsor").withTelhome("123456").withTelmobile("9115641235")
                .withTelwork("654321").withFax("654321").withEmail("eliza@gmail.ru").withBday("6").withBmonth("February").withByear("1952");

        app.goTo().AddNew();
        app.contact().create(contactData);
        app.goTo().Home();

      }
    }
  }

  @Test
  public void testInGroup() throws Exception{
    ContactData contact = app.db().contacts().iterator().next();
    Groups groups = app.db().groups();
    GroupData before = app.group().getGroupNotContact(groups, contact);
    if (before == null){
      app.goTo().groupPage();
      app.group().createGroup(new GroupData().withName("group6"));
      before = app.db().groups().stream().max((x, y) -> Integer.max(x.getId(), y.getId())).get();
    }
    app.goTo().Home();
    app.contact().inGroup(contact.getId(), before);
    GroupData after = app.db().group(before.getId());
    assertThat(after.getContacts(), equalTo(before.getContacts().withAdded(contact)));
  }

  @Test
  public void testRemoveGroup() throws Exception{
    Groups groups = app.db().groups();
    GroupData before = app.group().getGroupContact(groups);
    ContactData contact;
    if (before == null){
      GroupData group = groups.iterator().next();
      contact = app.db().contacts().iterator().next();
      app.goTo().Home();
      app.contact().inGroup(contact.getId(), group);
      before = app.db().group(group.getId());
    } else {
      contact = before.getContacts().iterator().next();
    }
    app.goTo().Home();
    app.contact().removeGroup(contact.getId(), before);
    GroupData after = app.db().group(before.getId());
    assertThat(after.getContacts(), equalTo(before.getContacts().without(contact)));
  }
}
