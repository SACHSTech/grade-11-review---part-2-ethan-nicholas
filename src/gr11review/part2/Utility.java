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

// Write a method alphaWord(String filenametxt) such that given the name of a file filenametxt that contains a single word on each line, returns the word that is alphabetically first.

  // File IO - Read 2
  public static String alphaWord(String filenametxt) throws IOException {
    BufferedReader TextFile = new BufferedReader(new FileReader(filenametxt));

    String strTempWord;
    String strResultingWord;
    int intAlphaCompare;
    
    strResultingWord = null;
    strTempWord = TextFile.readLine();
    strResultingWord = strTempWord;

    while(strTempWord != null){
			intAlphaCompare = strResultingWord.compareToIgnoreCase(strTempWord);
      if (intAlphaCompare > 0) {
        strResultingWord = strTempWord;
      }
      strTempWord = TextFile.readLine();
    }

    TextFile.close();
    return strResultingWord;
  }
}
