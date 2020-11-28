package gr11review.part2;

import java.io.*;
import java.util.*;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    
    String strString;
    int intSum;
    
    System.out.print("Give me a string: ");
    strString = keyboard.readLine();
    intSum = Utility.Sum(strString);
    System.out.println("This is the sum: " + intSum);
  }
}