package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
  @Expose
  private String name;
  @Expose
  private String header;
  @Expose
  private String footer;
  @XStreamOmitField
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

  public GroupData withHeader(String header) {
    this.header = header;
    return this;

  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;

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

  public GroupData withId(int id) {
    this.id = id;
    return this;

  }
  public String name() {
    return name;
  }

  public String header() {
    return header;
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

}