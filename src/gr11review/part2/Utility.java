package gr11review.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Utility {

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