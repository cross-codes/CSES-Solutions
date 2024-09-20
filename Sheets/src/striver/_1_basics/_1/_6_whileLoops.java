package striver._1_basics._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6_whileLoops {
  public static int[] solution(String number) {
    char[] num_arr = number.toCharArray();
    int idx = 0;
    int[] answer = {0, 0};
    while (idx != num_arr.length) {
      if (Character.getNumericValue(num_arr[idx]) % 2 == 0)
        answer[0] += Character.getNumericValue(num_arr[idx]);
      else answer[1] += Character.getNumericValue(num_arr[idx]);
      idx++;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int[] res = solution(bf.readLine());
    System.out.println(res[0] + " " + res[1]);
  }
}
