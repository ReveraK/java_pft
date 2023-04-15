package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Converter;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {



  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void submitContactCreation() {
    click(By.name("submit"));
  }
  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.firstname());
    type(By.name("middlename"), contactData.middlename());
    type(By.name("lastname"), contactData.lastname());
    type(By.name("nickname"), contactData.nickname());
    type(By.name("title"), contactData.title());
    type(By.name("company"), contactData.company());
    type(By.name("address"), contactData.address());
    type(By.name("home"), contactData.telhome());
    type(By.name("mobile"), contactData.telmobile());
    type(By.name("work"), contactData.telwork());
    type(By.name("fax"), contactData.fax());
    type(By.name("email"), contactData.email());
    selectDate("bday", contactData.bday());
    selectDate("bmonth", contactData.bmonth());
    type(By.name("byear"), contactData.byear());
    attach(By.name("photo"), contactData.photo());

    if (creation) {
      if (contactData.getGroups().size() > 0){
        Assert.assertTrue(contactData.getGroups().size() == 1);
        selectGroup("new_group", contactData.getGroups().iterator().next().name());
      }
    }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    //if (isElementPresent(By.name("new_group"))) {
      //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
     // selectGroup("new_group", contactData.group());
    //}
  }
  public void create(ContactData contactData) {
    fillContact(contactData, true);
    submitContactCreation();
  }
  private void selectComboBox(String name, String value){
    if (value != null){
      click(By.name(name));
      new Select(wd.findElement(By.name(name))).selectByVisibleText(value);
    }
  }
  private void selectComboBox(String name, int id){
    click(By.name(name));
    new Select(wd.findElement(By.name(name))).selectByValue(Integer.toString(id));
  }
  public void selectDate(String name, String value){
    if (value != null){
      selectComboBox(name, value);
    }
  }
  public void selectGroup(String name, String value){
    selectComboBox(name, value);
  }
  public void Delete() {
    click(By.xpath("//td/input"));
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }
  public void Delete(int id) {
    click(By.id(Integer.toString(id)));
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }
  public void change(int index) {
    //click(By.xpath("//img[@alt='Edit']"));
    //wd.findElements(By.name("entry")).get(index).findElements(By.cssSelector("td")).get(7).findElement(By.cssSelector("a")).click();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      if (id == index){
        element.findElements(By.cssSelector("td")).get(7).findElement(By.cssSelector("a")).click();
        return;
      }
    }
  }

  public void inGroup(int id, GroupData group){
    Assert.assertNotNull(group);
    click(By.id(Integer.toString(id)));
    selectComboBox("to_group", group.getId());
    click(By.name("add"));
  }

  public void removeGroup(int id, GroupData group){
    Assert.assertNotNull(group);
    selectComboBox("group", group.getId());
    click(By.id(Integer.toString(id)));
    click(By.name("remove"));
  }

  public void submitContactModification() {
    click(By.name("update"));

  }




  public boolean isThereContact() {
    return isElementPresent(By.xpath("//td/input"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> elements2 = element.findElements(By.cssSelector("td"));
      String lastName = elements2.get(1).getText();
      String firstName = elements2.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //ContactData contact = new ContactData().withId(id).withFirstname(firstName).withLastname(lastName);
     // ContactData contact = new ContactData(id, firstName, lastName);
      contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> elements2 = element.findElements(By.cssSelector("td"));
      String lastName = elements2.get(1).getText();
      String firstName = elements2.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String allphones = elements2.get(5).getText();
      String allemail = elements2.get(4).getText();
      String address = elements2.get(3).getText();
      //String[] phones = elements2.get(5).getText().split("\n");
      //ContactData contact = new ContactData().withId(id).withFirstname(firstName).withLastname(lastName);
      // ContactData contact = new ContactData(id, firstName, lastName);

      //contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
      //        .withTelhome(phones[0]).withTelmobile(phones[1]).withTelwork(phones[2]));
      contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName).withAllPhones(allphones)
              .withAllEmail(allemail).withAddress(address));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    change(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withTelhome(home).withTelmobile(mobile).withTelwork(work).withEmail(email).withEmail2(email2).withEmail3(email3)
            .withAddress(address);
  }
}
