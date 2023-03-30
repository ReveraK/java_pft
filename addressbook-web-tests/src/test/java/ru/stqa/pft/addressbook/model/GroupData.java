package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
  private final String name;
  private final String heder;
  private final String footer;

  public GroupData(String name, String heder, String footer) {
    this.name = name;
    this.heder = heder;
    this.footer = footer;
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