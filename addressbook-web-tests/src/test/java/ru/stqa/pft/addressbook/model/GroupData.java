package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
  private final String name;
  private final String heder;
  private final String footer;

  public void setId(int id) {
    this.id = id;
  }

  private int id;



  public GroupData(String name, String heder, String footer) {
    this.id = 0;
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
  public int getId() {
    return id;
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
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }
}