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

    String filenametxt;
    String strAlphaword;

    filenametxt = "src/gr11review/part2/words.txt";
    strAlphaword = "";

    System.out.println("Select the program to run: ");
    System.out.println("Options:");
    System.out.println("Methods 2 - 1");
    System.out.println("File IO 2 - 2");
    strSelect = keyboard.readLine();

    switch (strSelect){
      case "1" :
        System.out.print("Give me a string: ");
        str = keyboard.readLine();
        intSum = Utility.sumNumbers(str);
        System.out.println("This is the sum: " + intSum);
        break;
      case "2" :
        strAlphaword = Utility.alphaWord(filenametxt);
        System.out.println("This is the first alphabetical word: " + strAlphaword);
        break;
      default :
        System.out.println("That is not an option");
        break;
    }
  }
}