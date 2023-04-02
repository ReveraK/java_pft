package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
  private String name;
  private String heder;
  private String footer;
  private int id = Integer.MAX_VALUE;


  /*
  public GroupData(String name, String heder, String footer) {

    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.heder = heder;
    this.footer = footer;
  }
  public GroupData(int id, String name, String heder, String footer) {
    this.id = id;
    this.name = name;
    this.heder = heder;
    this.footer = footer;
  }
  */
  public int getId() {
    return id;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeder(String heder) {
    this.heder = heder;
    return this;

  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;

  }

  public GroupData withId(int id) {
    this.id = id;
    return this;

  }
  public String name() {
    return name;
  }

  public String heder() {
    return heder;
  }

  public String footer() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}