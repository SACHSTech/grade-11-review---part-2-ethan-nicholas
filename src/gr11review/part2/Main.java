package gr11review.part2;

import java.io.*;
import java.util.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    
    String str;
    int intSum;
    System.out.println("Methods 2");
    System.out.print("Give me a string: ");
    str = keyboard.readLine();
    intSum = Utility.sumNumbers(str);
    System.out.println("This is the sum: " + intSum);

  }
}