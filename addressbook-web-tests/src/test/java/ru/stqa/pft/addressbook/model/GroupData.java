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
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (GroupData) obj;
    return Objects.equals(this.name, that.name) &&
            Objects.equals(this.heder, that.heder) &&
            Objects.equals(this.footer, that.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, heder, footer);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }
}