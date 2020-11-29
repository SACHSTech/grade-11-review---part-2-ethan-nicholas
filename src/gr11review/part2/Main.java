package gr11review.part2;

import java.io.*;
import java.util.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    // Variables
    String strSelect;
    String str;
    int intSum;

    System.out.println("Select the program to run: ");
    System.out.println("Options: Methods 2, ");
    strSelect = keyboard.readLine();

    switch (strSelect){
      case "Methods 2" :
        System.out.print("Give me a string: ");
        str = keyboard.readLine();
        intSum = Utility.sumNumbers(str);
        System.out.println("This is the sum: " + intSum);
        break;
      case "File IO 2" :
        System.out.print("Give me a string: ");
        str = keyboard.readLine();
        intSum = Utility.sumNumbers(str);
        System.out.println("This is the sum: " + intSum);
      default :
        System.out.println("That is not an option");
        break;
    }
  }
}