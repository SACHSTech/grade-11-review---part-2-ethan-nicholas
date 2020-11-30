package gr11review.part2;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import gr11review.part2.Utility.*;

public class Main {

  public static void main(String[] args) throws IOException {
    
     // Method 1 - Nicholas Lee
    System.out.println(Utility.zipZap("zipXzap"));

    // File IO 1 - Nicholas Lee
    System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));

    // Array 1 - Nicholas Lee
    int[] num = {10, 1, 9, 20};
    Utility.tenRun(num);

    // Array 3 - Nicholas Lee
    int[] outer = {1,2,4,6};
    int[] inner = {2,4};
    System.out.println(Utility.linearIn(outer, inner));

    // Array 5 - Nicholas Lee
    int i = 3;
    int j = 4;
    Utility.pascalTri(i, j);
  }
}
