package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    if (creation) {
      selectGroup("new_group", contactData.group());
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
    click(By.name(name));
    new Select(wd.findElement(By.name(name))).selectByVisibleText(value);
  }
  public void selectDate(String name, String value){

    selectComboBox(name, value);
  }
  public void selectGroup(String name, String value){
    selectComboBox(name, value);
  }
  public void Delete() {
    click(By.xpath("//td/input"));
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }
  public void change(int index) {
    //click(By.xpath("//img[@alt='Edit']"));
    wd.findElements(By.name("entry")).get(index).findElements(By.cssSelector("td")).get(7).findElement(By.cssSelector("a")).click();
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
      ContactData contact = new ContactData(id, firstName, lastName);
      contacts.add(contact);
    }
    return contacts;
  }
}
