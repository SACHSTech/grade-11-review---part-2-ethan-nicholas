package gr11review.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
        // the if statement checks if the following number is a multiple
        // if it is not a multiple of 10 then it is changed to be the previous number
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

    return result;
  }

  public static String pascalTri(int i, int j) throws IOException {

    String strTest="";
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
        pascalOut.println(p[intRows][intColumns]);
      }
    }

    pascalOut.close();

    return strTest;

  }

}