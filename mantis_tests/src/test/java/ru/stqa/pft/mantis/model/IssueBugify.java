package ru.stqa.pft.mantis.model;

public class IssueBugify {

  private int id;
  private String subject;
  private String description;

  private String state_name;

  public IssueBugify withId(int id) {
    this.id = id;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public IssueBugify withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public IssueBugify withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getState() {
    return state_name;
  }
}
