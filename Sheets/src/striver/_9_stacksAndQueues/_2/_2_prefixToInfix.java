package striver._9_stacksAndQueues._2;

import java.util.Stack;

public class _2_prefixToInfix {
  // Function to check if the character is an operator
  static boolean isOp(char c) {
    switch (c) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
        return true;
    }
    return false;
  }

  public static String preToInfix(String pre_exp) {
    Stack<String> stk = new Stack<>();
    int n = pre_exp.length();

    for (int i = n - 1; i >= 0; i--) {
      char c = pre_exp.charAt(i);

      if (isOp(c)) {
        String operand1 = stk.pop();
        String operand2 = stk.pop();

        String temp = "(" + operand1 + c + operand2 + ")";
        stk.push(temp);
      } else {
        stk.push(String.valueOf(c));
      }
    }

    return stk.pop();
  }
}
