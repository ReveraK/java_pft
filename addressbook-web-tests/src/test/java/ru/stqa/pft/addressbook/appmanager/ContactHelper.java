package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void submitContactCreation() {
    click(By.name("submit"));
  }
  public void creationContact(ContactData contactData) {

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
    selectGroup("new_group", contactData.group());
  }
  private void selectComboBox(String name, String value, String xpath){
    click(By.name(name));
    new Select(wd.findElement(By.name(name))).selectByVisibleText(value);
    click(By.xpath(xpath));
  }
  public void selectDate(String name, String value){
    selectComboBox(name, value, "//option[@value='"+ value +"']");
  }
  public void selectGroup(String name, String value){
    selectComboBox(name, value, "//div[@id='content']/form/select[5]/option[2]");
  }
  public void DeleteContact() {
    click(By.xpath("//td/input"));
    click(By.xpath("//input[@value='Delete']"));
    accept();
  }
}
