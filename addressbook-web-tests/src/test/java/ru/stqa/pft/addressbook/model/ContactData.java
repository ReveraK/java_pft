package ru.stqa.pft.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public final class ContactData {
  @Expose
  private String firstname;
  @Expose
  private String middlename;
  @Expose
  private String lastname;
  @Expose
  private String nickname;
  @Expose
  private String title;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String telhome;
  @Expose
  private String telmobile;
  @Expose
  private String telwork;
  @Expose
  private String allPhones;
  @Expose
  private String fax;
  @Expose
  private String email;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String allEmail;
  @Expose
  private String bday;
  @Expose
  private String bmonth;
  @Expose
  private String byear;
  @Expose
  private String group;
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private transient File photo;

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }



  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;

  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;

  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;

  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;

  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;

  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;

  }

  public ContactData withTelhome(String telhome) {
    this.telhome = telhome;
    return this;

  }

  public ContactData withTelmobile(String telmobile) {
    this.telmobile = telmobile;
    return this;

  }

  public ContactData withTelwork(String telwork) {
    this.telwork = telwork;
    return this;

  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;

  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }
  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;

  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;

  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;

  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;

  }

  public ContactData withId(int id) {
    this.id = id;
    return this;

  }



  /* public ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                     String company, String address, String telhome, String telmobile, String telwork, String fax,
                     String email, String bday, String bmonth, String byear, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.telhome = telhome;
    this.telmobile = telmobile;
    this.telwork = telwork;
    this.fax = fax;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;

    this.id = Integer.MAX_VALUE;
  }

  public ContactData(int id, String firstname, String lastname){
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;

    this.middlename = null;
    this.nickname = null;
    this.title = null;
    this.company = null;
    this.address = null;
    this.telhome = null;
    this.telmobile = null;
    this.telwork = null;
    this.fax = null;
    this.email = null;
    this.bday = null;
    this.bmonth = null;
    this.byear = null;
    this.group = null;
  }

   */

  public String firstname() {
    return firstname;
  }

  public String middlename() {
    return middlename;
  }

  public String lastname() {
    return lastname;
  }

  public String nickname() {
    return nickname;
  }

  public String title() {
    return title;
  }

  public String company() {
    return company;
  }

  public String address() {
    return address;
  }

  public String telhome() {
    return telhome;
  }

  public String telmobile() {
    return telmobile;
  }

  public String telwork() {
    return telwork;
  }

  public String fax() {
    return fax;
  }

  public String email() {
    return email;
  }
  public String email2() {
    return email2;
  }
  public String email3() {
    return email3;
  }

  public String bday() {
    return bday;
  }

  public String bmonth() {
    return bmonth;
  }

  public String byear() {
    return byear;
  }
  public File photo() {
    return photo;
  }
  public String group() {
    return group;
  }

  public int getId() {
    return id;
  }

  public String allPhones() {
    return allPhones;
  }
  public String allEmail() {
    return allEmail;
  }
  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id=" + id +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, id);
  }
}
