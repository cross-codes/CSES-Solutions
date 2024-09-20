package striver._9_stacksAndQueues._2;

import java.util.Stack;

public class _5_postFixToInfix {
  static boolean isOperand(char c) {
    switch (c) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
        return false;
    }
    return true;
  }

  public static String postToInfix(String exp) {
    Stack<String> stk = new Stack<>();
    int n = exp.length();

    for (int i = 0; i < n; i++) {
      char c = exp.charAt(i);
      if (isOperand(c)) stk.push(String.valueOf(c));
      else {
        String operand1 = stk.pop();
        String operand2 = stk.pop();
        String temp = "(" + operand2 + c + operand1 + ")";
        stk.push(temp);
      }
    }

    return stk.peek();
  }
}
