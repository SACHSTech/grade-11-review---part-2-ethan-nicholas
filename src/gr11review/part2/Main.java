package gr11review.part2;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    Scanner Input = new Scanner(System.in);

    // Variables
    String strSelect;
    String str;
    int intSum;

    String filenametxt;
    String strAlphaword;

    int val;
    int intUserInputNum;
    int[] nums;

    boolean blnBalanced;

    // Initializing Variables
    filenametxt = "src/gr11review/part2/words.txt";
    strAlphaword = "";

    System.out.println("Select the program to run: ");
    System.out.println("Options:");
    System.out.println("Methods 2 - 1");
    System.out.println("File IO 2 - 2");
    System.out.println("Array 2 - 3");
    System.out.println("Array 4 - 4");
    System.out.println("Array 6 - 5");
    System.out.println("");
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
      case "3" :
        System.out.print("How many numbers do you want in the array: ");
        intUserInputNum = Input.nextInt();
        nums = new int[intUserInputNum];
        System.out.print("Enter the numbers: ");
        for(int i = 0; i < intUserInputNum; i++){
          nums[i] = Input.nextInt();
        }
        System.out.print("Enter the number you want to change: ");
        val = Integer.parseInt(keyboard.readLine());
        Utility.notAlone(nums, val);
        System.out.println("Changed Array: " + Arrays.toString(nums));
        break;
      case "4" :
        System.out.print("How many numbers do you want in the array: ");
        intUserInputNum = Input.nextInt();
        nums = new int[intUserInputNum];
        System.out.print("Enter the numbers: ");
        for(int i = 0; i < intUserInputNum; i++){
          nums[i] = Input.nextInt();
        }
        blnBalanced = Utility.canBalance(nums);
        System.out.println("Can it be balanced: " + blnBalanced);
        break;
      default :
        System.out.println("That is not an option");
        break;
    }
  }
}