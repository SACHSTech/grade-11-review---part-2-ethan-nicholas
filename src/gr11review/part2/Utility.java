package gr11review.part2;

// Ethan's Imports
import java.io.*;
import java.util.*;

// Nicholas's Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Utility {

/* 
* Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. 
* @param str = User input string that will be used for the method
* @return intResult = the sum of the numbers in the String "str"
* @author E.Lai
*/
  // Methods 2
  public static int sumNumbers(String str){

    // Variables
    int intLoop;
    int intLoop2;
    int intResult;
    char chrCharacters;
    String strNumbers;

    // Initializing Variables
    strNumbers = "";
    intResult = 0;

    // For loop that allows the program to count how many characters are in the string
    for (intLoop = 0; intLoop < str.length(); intLoop++) {
      chrCharacters = str.charAt(intLoop);

      // If the next character the program counts is a number, adds the number character to a string
      if (Character.isDigit(chrCharacters)) {
        strNumbers = strNumbers + chrCharacters;

      // If the next character the program counts is not a number, adds the string stored with numbers into intResult. Then the program resets the string.
      } else if (!strNumbers.equals("")) {
        intResult = intResult + Integer.parseInt(strNumbers);
        strNumbers = "";
      }
    }
    
    // If strNumbers still has numbers stored in it by the end of the string, it adds the remaining numbers into intResult.
    if (!strNumbers.equals("")) {
      intResult = intResult + Integer.parseInt(strNumbers);
    }
    return intResult;
  }

/* 
* Write a method alphaWord(String filenametxt) such that given the name of a file filenametxt that contains a single word on each line,returns the word that is alphabetically first. 
* @param filenametxt = Name of the text file that will be analyzed
* @return strResultingWord = Alphabetically sorted word
* @author E.Lai
*/
  // File IO - Read 2 Method
  public static String alphaWord(String filenametxt) throws IOException {
    BufferedReader TextFile = new BufferedReader(new FileReader(filenametxt));

    // Variables
    String strTempWord;
    String strResultingWord;
    int intAlphaCompare;
    
    // Initializing Variables
    strTempWord = TextFile.readLine();
    strResultingWord = TextFile.readLine();

    // While Loop that keeps on looping strTempWord until it becomes null (end of file)
    while (strTempWord != null) {

      // Compares the current word (strTempWord) to the first word of the file (strResultingWord)
			intAlphaCompare = strResultingWord.compareToIgnoreCase(strTempWord);

      // If intAlphaCompare is positive, then that means strTempWord is before strResultingWord in the alphabet. Then sets that word as the word to return.
      if (intAlphaCompare > 0) {
        strResultingWord = strTempWord;
      }

      // Sets strTempWord as the current word in the file.
      strTempWord = TextFile.readLine();
    }

    // Closes text file and returns the word
    TextFile.close();
    return strResultingWord;
  }

/* 
* We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
* @param nums = the integer array that will be analyzed
* @param val = user inputted value that will be changed if the value is present in the array
* @return nums = the changed integer array
* @author E.Lai
*/
  // Array 2 - One Dimensional Method
  public static int[] notAlone(int[] nums, int val){
    
    // Variables
    int intLoop;

    // For loop that counts every cell in the array. Starts at the second cell of the array and ends at the second last cell of the array. So, every element it checks is an "alone" element.
    for (intLoop = 1; intLoop < nums.length - 1; intLoop++) {

      // Checking which number in the array is equal to the selected value
      if (nums[intLoop] == val) {

        // Prevents the program from changing two of the same numbers
        if (nums[intLoop - 1] != nums[intLoop] && nums[intLoop + 1] != nums[intLoop]) {

          // Checks which of the two adjacent numbers are bigger and makes the number selected equal to the bigger adjacent number
          nums[intLoop] = Math.max(nums[intLoop + 1], nums[intLoop - 1]);
        }
      }
    }
    return nums;
  }

/* 
* Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side. Signature public boolean canBalance(int[] nums)
* @param nums = the integer array that will be analyzed
* @return a boolean (true or false)
* @author E.Lai
*/
  // Array 4 - One Dimensional - Two Loops
  public static boolean canBalance(int[] nums) {

    // Variables
    int intSum;
    int intSum2;
    int intLoop;
    int intLoop2;
    int intLoop3;

    // Initializing Variables
    intSum = 0;
    intSum2 = 0;

    // For loop that determines where the divider is placed in the array.
    for (intLoop3 = 0; intLoop3 < nums.length - 1; intLoop3++) {

      // For loop that counts that always counts to the first element of the array. However, the for loop's starting point will slowly get closer to the beginning of the array. Also adds up all those counted values.
      for (intLoop = (nums.length - 2) - intLoop3; intLoop > -1; intLoop--) {
        intSum = intSum + nums[intLoop];
      }

      // For loop that always counts to the last element of the array. However, the for loop's starting point will slowly get closer to the beginning of the array. Also adds up all those counted values.
      for (intLoop2 = (nums.length - 1) - intLoop3; intLoop2 < nums.length; intLoop2++) {
        intSum2 = intSum2 + nums[intLoop2];
      }

      // If statement that detects when the sums of both counts are equal. If they are ever equal, the array can be balanced.
      if (intSum2 == intSum) {
        return true;

      // If statement that detects when the count that goes to the last element of the array is greater than the count that goes to the beginning of the array. If this ever happens, it is impossible for the array to be balanced.
      } else if (intSum2 > intSum) {
        return false;
      }

      // After each divider loop, resets the values of both sums. Therefore, the sums can be re-added.
      intSum = 0;
      intSum2 = 0;
    }

    // Prevents an error in the program.
    return false;
  }

/* 
* Given an integer n, write a method diagonal(int n) that outputs to a text file diagonalOut.txt, a two-dimensional array of size (n×n) populated as follows, with a comma between each number:
* @param n = User inputted value that will affect the size of the array
* @return a changed text file. No variable will be returned to the main file.
* @author E.Lai
*/
  // Array 6 - Two Dimensional
  public static void diagonal(int n) throws IOException {

    // Creating PrintWriter meathod which allows the program to write in a text file
    PrintWriter Writing = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt"));

    // Variables
    int intLoop;
    int intLoop2;

    // Creating 2D Array
    int[][] intArray = new int[n][n];

    // 2 For loops to select every cell of the array. First for loop to count every square in a row. The second for loop to count every column underneath the squares.
    for (intLoop = 0; intLoop < n; intLoop++) {
      for (intLoop2 = 0; intLoop2 < n; intLoop2++) {

        // Fills up the whole array with 0s
        intArray[intLoop][intLoop2] = 0;

        // If statement that checks if the cell is on a diagonal
        if (intLoop2 == (n - intLoop - 1)){
          intArray[intLoop][intLoop2] = 1;

        // If statement that checks if the cell is underneath the diagonal
        } else if (intLoop2 > (n - intLoop - 1)) {
          intArray[intLoop][intLoop2] = 2;
        }
        // Prints out the numbers
        Writing.print(intArray[intLoop][intLoop2]);

        // Prints out the commas
        if (intLoop2 != n-1) {
          Writing.print(",");
        }
      }

      // Prints out the commas in each row
      Writing.println(); 
    }

    // Closes Text File
    Writing.close();
  }

  /**
  * Given a string, looks for a pattern that has a length of 3, starts with "z", and ends with "p"
  * Creates a new string with the middle character between "z" and "p" taken out  
  * 
  * @param str The string that is analyzed for the pattern 
  * @return The new string
  * @author N.Lee
  */
  public static String zipZap(String str){

    // Declares variables
    int intLen;
    String strNewWord = " ";
    
    // Added two spaces to the end of the string which adds two extra indices
    // This allows for the last character to run through the if statement
    str = str + "  ";
    intLen = str.length();
      
    // The for loop runs through the length of the string 
    for (int intCount = 0; intCount < intLen; intCount = intCount + 1) {
      // Looks for the characters "z" and "p"
      // If the pattern is found, "z" is added to the new string and it skips the following character
      if (str.charAt(intCount) == 'z' && str.charAt(intCount + 2) == 'p') {
        strNewWord = strNewWord + "z";
        intCount = intCount + 1;
      }else {
        strNewWord = strNewWord + str.charAt(intCount);
      }
    }

    // Returns the new string
    return strNewWord;
  }

  /**
  * Given the name of a text file with a single word on each line, the longest word is returned 
  * 
  * @param filenametxt The name of the text file
  * @return The longest word found in the text file
  * @author N.Lee
  */
  public static String longestWord(String filenametxt) throws IOException{
    
    // Reads the given text file name
    BufferedReader words = new BufferedReader(new FileReader(filenametxt));

    // Declares variables
    String strWord = " ";
    String strLongestWord = " ";
    int intWord;
    int intLengthLongest;

    // The while loop continues until the end of the text file
    while ((strWord = words.readLine()) != null) {

      // The length of the word is found
      intWord = strWord.length();
      // The length of the longest word is found
      intLengthLongest = strLongestWord.length();

      // Compares the length of the longest word to the word from the file
      if (intWord >= intLengthLongest) {
        // Updates the longest word 
        strLongestWord = strWord;
      }

    }

    // Closes the text file
    words.close();

    // Returns the longest word from the text file
    return strLongestWord;
  }

  /**
  * Given an array, for each multiple of 10, the following numbers are changed to that multiple
  * 
  * @param nums The array with numbers
  * @return The new array with the updated numbers  
  * @author N.Lee
  */
  public static int[] tenRun(int[] nums){
    
    // Declares variable
    int intLen = nums.length;

    // The loop goes through all the elements in the array
    for (int intCount = 0; intCount < intLen - 1; intCount = intCount + 1) {
      // The modulus division finds if the number is a multiple of 10
      if (nums[intCount] % 10 == 0) {
        // The if statement checks if the following number is a multiple of 10
        // If it is not a multiple of 10 then it is changed to be the previous number
        if (nums[intCount + 1] % 10 != 0) {
          nums[intCount + 1] = nums[intCount];
        }
      }
    }

    // Displays the array
    for (int intCount2 = 0; intCount2 < intLen; intCount2 = intCount2 + 1) {
      System.out.print(nums[intCount2] + ", ");
    }

    // Returns the updated array
    return nums;
  }

  /**
  * Given two arrays, checks if all the numbers found in the "innner" array appear in the "outer" array  
  *
  * @param outer The first array
  * @param inner The second array
  * @return A boolean value  
  * @author N.Lee
  */
  public static boolean linearIn(int[] outer, int[] inner){

    // Declares variables
    boolean result = false;
    int intLenOuter = outer.length;
    int intLenInner = inner.length;
    int intTrack = 0;
    int[] check = new int [intLenInner];

    // The loop continues until the length of the inner array is reached
    for (int intCount = 0; intCount < intLenInner; intCount = intCount + 1) {
      // The loop continues to run until the length of the outer array is reached
      for (int intCount2 = 0; intCount2 < intLenOuter; intCount2 = intCount2 + 1) {
        // Compares each number in the inner array to the numbers in the outer array
        // If the numbers match, the check array index will have a value of 1
        if (inner[intCount] == outer[intCount2]) {
          check[intCount] = 1;
        }
      }
    }

    // Checks to see if the value one is present throughout the array
    // If one of the indices has a value of 0, the result is false 
    for (int intCount = 0; intCount < intLenInner; intCount++) {
      if (check[intCount] == 1) {
        intTrack = intTrack + 1;
      }else if (check[intCount] == 0) {
        result = false;
      }
    }

    // Compares the amount of ones found in the array to the length of the inner array
    if (intTrack == intLenInner) {
      result = true;
    }

    // Returns a boolean value
    return result;
  }

  /**
  * Given two values representing the amount of rows and columns, a Pascal's triangle is displayed on a textfile
  *
  * @param i The number of the rows
  * @param j The number of columns
  * @return Nothing is returned, but a text file is created 
  * @author N.Lee
  */
  public static void pascalTri(int i, int j) throws IOException {

    // Declares variable
    int[][] p = new int [i][j];

    // The first row and first column will have the value of 1 
    for (int intColumns = 0; intColumns < j; intColumns++) {
      for (int intRows = 0; intRows < i; intRows++) {
        p[0][intColumns] = 1;
        p[intRows][0] = 1;
      }
    }

    // Finds the value of the other indices in the array
    // The value is found by adding the values of the indices of the one above and to its left
    for (int intColumns = 1; intColumns < j; intColumns++) {
      for (int intRows = 1; intRows < i; intRows++) {
        p[intRows][intColumns] = p[intRows-1][intColumns] + p[intRows][intColumns-1];
      }
    }

    // Allows for the inputting of the values into the text file
    PrintWriter pascalOut = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt", true));

    // Prints out the values of the array into the file
    for (int intRows = 0; intRows < i; intRows++) {
      for (int intColumns = 0; intColumns < j; intColumns++) {
        pascalOut.print(p[intRows][intColumns] + ", ");
        // Allows for the next row to be printed on the next line
        if (intColumns == j - 1) {
          pascalOut.println(" ");
        }
      }
    }

    // Closes text file
    pascalOut.close();
  }
}