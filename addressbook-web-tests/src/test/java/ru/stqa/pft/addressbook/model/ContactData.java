package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public final class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String telhome;
  private final String telmobile;
  private final String telwork;
  private final String fax;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String group;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String title,
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
  }

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

  public String bday() {
    return bday;
  }

  public String bmonth() {
    return bmonth;
  }

  public String byear() {
    return byear;
  }

  public String group() {
    return group;
  }
}