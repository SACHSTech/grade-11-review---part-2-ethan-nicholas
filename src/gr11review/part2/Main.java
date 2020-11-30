package gr11review.part2;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    // Scanner to allow user to input values into an array.
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

    int n;

    // Initializing Variables
    filenametxt = "src/gr11review/part2/words.txt";
    strAlphaword = "";

    // Asking the user what method they want to run
    System.out.println("Select the program to run: ");
    System.out.println("");
    System.out.println("Options:");
    System.out.println("Methods 2 - 1 (Ethan's Method)");
    System.out.println("File IO 2 - 2 (Ethan's Method)");
    System.out.println("  Array 2 - 3 (Ethan's Method)");
    System.out.println("  Array 4 - 4 (Ethan's Method)");
    System.out.println("  Array 6 - 5 (Ethan's Method)");
    System.out.println("Methods 1 - 6 (Nick's Method)");
    System.out.println("File IO 1 - 7 (Nick's Method)");
    System.out.println("  Array 1 - 8 (Nick's Method)");
    System.out.println("  Array 3 - 9 (Nick's Method)");
    System.out.println("  Array 5 - 10(Nick's Method)");
    System.out.println("");
    strSelect = keyboard.readLine();
    System.out.println("");

    // Switch to show the paths of different user inputs
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
      case "5" :
        System.out.print("Give me an integer: ");
        n = Integer.parseInt(keyboard.readLine());
        Utility.diagonal(n);
        break;
      case "6" :
        System.out.println(Utility.zipZap("zipXzap"));
        break;
      case "7" :
        System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));
        break;
      case "8" :
        int[] num = {10, 1, 9, 20};
        Utility.tenRun(num);
        break;
      case "9" :
        int[] outer = {1,2,4,6};
        int[] inner = {2,4};
        System.out.println(Utility.linearIn(outer, inner));
        break;
      case "10" :
        int i = 3;
        int j = 4;
        Utility.pascalTri(i, j);
        break;
      default :
        System.out.println("That is not an option");
        break;
    }
  }
}
