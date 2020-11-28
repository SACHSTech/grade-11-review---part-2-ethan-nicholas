package gr11review.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Utility {
  public static String zipZap(String str){

    int intLen;
    String strNewWord = " ";
    
    // Added two spaces to the end of the string which adds two extra indices
    str = str + "  ";
    intLen = str.length();
      
    for(int intCount = 0; intCount < intLen; intCount = intCount + 1){
      if(str.charAt(intCount) == 'z' && str.charAt(intCount + 2) == 'p'){
        strNewWord = strNewWord + "z";
        intCount = intCount + 1;
      }else{
        strNewWord = strNewWord + str.charAt(intCount);
      }
    }

    return strNewWord;

  }

  public static String longestWord(String filenametxt) throws IOException{
    
    BufferedReader words = new BufferedReader(new FileReader(filenametxt));

    String strWord = " ";
    String strLongestWord = " ";
    int intWord;
    int LengthofLongest;

    while((strWord=words.readLine()) != null){

      intWord = strWord.length();
      LengthofLongest = strLongestWord.length();

      if(intWord >= LengthofLongest){
        strLongestWord = strWord;
      }

    }

    words.close();
    return strLongestWord;
  }

}