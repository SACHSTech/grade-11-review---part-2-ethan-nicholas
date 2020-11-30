// Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {

  // Methods 2 Method
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
    for(intLoop = 0; intLoop < str.length(); intLoop++){
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
    if(!strNumbers.equals("")){
      intResult = intResult + Integer.parseInt(strNumbers);
    }
    return intResult;
  }

// Write a method alphaWord(String filenametxt) such that given the name of a file filenametxt that contains a single word on each line,returns the word that is alphabetically first.

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
    while(strTempWord != null){

      // Compares the current word (strTempWord) to the first word of the file (strResultingWord)
			intAlphaCompare = strResultingWord.compareToIgnoreCase(strTempWord);

      // If intAlphaCompare is positive, then that means strTempWord is before strResultingWord in the alphabet. Then sets that word as the word to return.
      if (intAlphaCompare > 0) {
        strResultingWord = strTempWord;
      }

      // Sets strTempWord as the current word in the file.
      strTempWord = TextFile.readLine();
    }

    TextFile.close();
    return strResultingWord;
  }

// We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger. public int[] notAlone(int[] nums, int val)

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
          nums[intLoop] = Math.max(nums[intLoop - 1], nums[intLoop + 1]);
        }
      }
    }
    return nums;
  }

// Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side. Signature public boolean canBalance(int[] nums)

  // Array 4
  public static boolean canBalance(int[] nums) {

    // Variables
    int intSum;
    int intSum2;
    int intLoop;
    int intLoop2;

    // Initializing Variables
    intSum = 0;
    intSum2 = 0;

    // For loop that sums up all the numbers in the array
    for (intLoop = 0; intLoop < nums.length; intLoop++){
      intSum = intSum + nums[intLoop];
    }

    // For loop that also sums up all the numbers in the array
    for (intLoop2 = 0; intLoop2 < nums.length; intLoop2++){
      intSum2 = intSum2 + nums[intLoop2];

      // While re-summing up all the numbers in the array. During each loop,checks the sum of all numbers in the current loop and compares it with the total sum of the whole array.
      // If the total loop's sums are ever double of the current loop's sums, this means the array can be balanced.
      if ((intSum - intSum2) == intSum2) {
        return true;
        
      // But, if the current loop's sum is ever greater than the total's loops sum - the current loop's sum, this means that the array can never be balanced.
      } else if (intSum2 > (intSum - intSum2)) {
        return false;
      }
    }
    return false;
  }
}
    