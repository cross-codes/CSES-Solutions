package striver._9_stacksAndQueues._2;

import java.util.Stack;

public class _4_postfixToPrefix {
  static boolean isOperator(char c) {
    switch (c) {
      case '+':
      case '-':
      case '*':
      case '/':
        return true;
    }
    return false;
  }

  static int pref(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  public static String postToPre(String post_exp) {
    // Postfix to Infix
    Stack<String> infix = new Stack<>();
    int n = post_exp.length();

    for (int i = 0; i < n; i++) {
      char c = post_exp.charAt(i);
      if (!isOperator(c)) infix.push(String.valueOf(c));
      else {
        String operand1 = infix.pop();
        String operand2 = infix.pop();
        String temp = "(" + operand2 + c + operand1 + ")";
        infix.push(temp);
      }
    }

    // Infix to prefix
    String infix_exp = infix.pop();
    Stack<Character> stk = new Stack<>();
    n = infix_exp.length();
    char[] infix_arr = new StringBuilder(infix_exp).reverse().toString().toCharArray();
    for (int i = 0; i < n; i++) {
      if (infix_arr[i] == ')') infix_arr[i] = '(';
      else if (infix_arr[i] == '(') infix_arr[i] = ')';
    }

    // Now convert this to postfix and reverse
    infix_exp = String.valueOf(infix_arr);
    StringBuilder result = new StringBuilder("");
    for (int i = 0; i < n; i++) {
      char c = infix_exp.charAt(i);
      if (c == '(') stk.push(c);
      else if (Character.isLetterOrDigit(c)) result.append(c);
      else if (c == ')') {
        while (stk.peek() != '(') result.append(stk.pop());
        stk.pop();
      }
      else {
        while (!stk.isEmpty() && pref(c) <= pref(stk.peek())) {
          result.append(stk.pop());
        }
        stk.push(c);
      }
    }

    while (!stk.isEmpty()) result.append(stk.pop());

    return result.reverse().toString();
  }
}
