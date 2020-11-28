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

  public static int[] tenRun(int[] nums){

    int intLen = nums.length;

    for(int intCount = 0; intCount < intLen - 1; intCount = intCount + 1){
      
      // if the number is a multiple of 10, then it goes to the next if statement
      if(nums[intCount] % 10 == 0){
        // if the next number is not a mutiple of 10
        // then the number becomes the previous number which is a multiple of 10
        if(nums[intCount + 1] % 10 != 0){
          nums[intCount + 1] = nums[intCount];
        }
      }
      
    }

    // displays the array
    for(int intCount2 = 0; intCount2 < intLen; intCount2 = intCount2 + 1){
      System.out.println(nums[intCount2]);
    }

    return nums;

  }

}