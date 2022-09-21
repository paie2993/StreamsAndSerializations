package com.example;

/**
 * This is a class.
 */
public class Greeter {
  /**
   * This is a constructor.
   */
  public Greeter() {
  }

  //TODO: Add javadoc comment
  public String greet(String someone) {
      try {
          return String.format("Hello, %s!", someone);
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return null;
  }

}
