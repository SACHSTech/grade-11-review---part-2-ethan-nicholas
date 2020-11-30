package gr11review.part2;

import gr11review.part2.Utility.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{

    // Method 1
    System.out.println(Utility.zipZap("zipXzap"));

    // File IO 1
    System.out.println(Utility.longestWord("src/gr11review/part2/words.txt"));

    // Array 1
    int[] num = {10, 1, 9, 20};
    Utility.tenRun(num);

    // Array 3
    int[] outer = {1,2,4,6};
    int[] inner = {2,4};
    System.out.println(Utility.linearIn(outer, inner));

    // Array 5
    int i = 3;
    int j = 4;
    Utility.pascalTri(i, j);

  }
}
