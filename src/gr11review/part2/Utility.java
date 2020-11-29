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
    // This allows for the last character to run through the loop
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

  public static int[] tenRun(int[] nums){

    int intLen = nums.length;

    for(int intCount = 0; intCount < intLen - 1; intCount = intCount + 1){
      
      // if the number is a multiple of 10, then it goes to the next if statement
      if(nums[intCount] % 10 == 0){
        // the if statement checks if the following number is a multiple
        // if it is not a multiple of 10 then it is changed to be the previous number
        if(nums[intCount + 1] % 10 != 0){
          nums[intCount + 1] = nums[intCount];
        }
      }
    }

    // displays the array
    for(int intCount2 = 0; intCount2 < intLen; intCount2 = intCount2 + 1){
      System.out.print(nums[intCount2] + ", ");
    }

    return nums;
  }

  public static boolean linearIn(int[] outer, int[] inner){
    boolean result = false;
    int intLen = outer.length;
    int intLen2 = inner.length;
    int intTrack = 0;

    for(int intCount = 0; intCount < intLen; intCount = intCount + 1){
      // the loop compares each number in the outer array to the number(s) in the inner array
      for(int intCount2 = 0; intCount2 < intLen2; intCount2 = intCount2 + 1){
        if(inner[intCount2] == outer[intCount]){
          intTrack = intTrack + 1;
        }
      }
    }

    if(intTrack >= intLen2){
      result = true;
    }else{
      result = false;
    }

    System.out.println(" ");
    return result;
  }

  public static String pascalTri(int i, int j) throws IOException {

    String strEmpty="";
    int[][] p = new int [i][j];

    for(int intColumns = 0; intColumns < j; intColumns++){
      for(int intRows = 0; intRows < i; intRows++){
        p[0][intColumns] = 1;
        p[intRows][0] = 1;
      }
    }

    for(int intColumns = 1; intColumns < j; intColumns++){
      for(int intRows = 1; intRows < i; intRows++){
        p[intRows][intColumns] = p[intRows-1][intColumns] + p[intRows][intColumns-1];
      }
    }

    PrintWriter pascalOut = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt", true));

    for(int intRows = 0; intRows < i; intRows++){
      for(int intColumns = 0; intColumns < j; intColumns++){
        pascalOut.print(p[intRows][intColumns] + ", ");
        if(intColumns == j-1){
          pascalOut.println(" ");
        }
      }
    }

    pascalOut.close();

    return strEmpty;

  }

}