// Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

package gr11review.part2;
import java.io.FileReader;

public class Utility {
  public static int Sum(String strString){

    int intLoop;
    int intResult;
    char chrCharacters;
    String strNumbers;

    strNumbers = "";
    intResult = 0;

    for(intLoop = 0; intLoop < strString.length(); intLoop++){
      chrCharacters = strString.charAt(intLoop);
      if (Character.isDigit(chrCharacters)) {
        strNumbers = strNumbers + chrCharacters;
      } else if (!Character.isDigit(chrCharacters)) {
        strNumbers = "";
      }
    }
    if (!strNumbers.equals("")){
      intResult = intResult + Integer.parseInt(strNumbers);
    }
    return intResult;
  }
}

 //       strSum += chrCharacters;
 //     } else if (!strSum.equals("")) {
 //       intResult += Integer.parseInt(strSum);
 //       strSum = "";
 //     }
 //   }
 //   if (!strSum.equals("")) {
 //     intResult += Integer.parseInt(strSum);
 //   } 

