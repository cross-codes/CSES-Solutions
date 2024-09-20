package striver._1_basics._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_inputOutput {
  public static int solution(char input) throws IOException {
    int ascii_val = (int) input;

    if (ascii_val >= 65 && ascii_val <= 90) {
      return 1;
    } else if (ascii_val >= 97 && ascii_val <= 122) {
      return 0;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(in);

    char input = bf.readLine().charAt(0);
    System.out.println(solution(input));
  }
}
