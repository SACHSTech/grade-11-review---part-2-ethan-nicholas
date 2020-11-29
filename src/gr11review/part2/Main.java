package gr11review.part2;

import gr11review.part2.Utility.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{

    //System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));

    //int[] num = {2,10,3,4,20,5};
    //System.out.println(Utility.tenRun(num));

    int[] outer = {1,2,4,6};
    int[] inner = {2,4};
    System.out.println(Utility.linearIn(outer, inner));

  
  }
}
