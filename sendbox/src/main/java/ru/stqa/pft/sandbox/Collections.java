package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Pyton";
    langs[3] = "PHP";

   // List<String> languages = new ArrayList<String>();
    //languages.add("java");
    //languages.add("java1");
    //languages.add("java2");

    List<String> languages = Arrays.asList("java11", "java21" );
    for (String l : languages ){
      System.out.println("Я хочу выучить " + l);
    }

  }
}
