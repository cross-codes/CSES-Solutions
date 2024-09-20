package striver._9_stacksAndQueues._2;

import java.util.Stack;

public class _3_prefixToPostfix {
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

  public static String preToPost(String pre_exp) {
    // Prefix to Infix
    Stack<String> infix = new Stack<>();
    int n = pre_exp.length();
    for (int i = n - 1; i > -1; i--) {
      char c = pre_exp.charAt(i);
      if (!isOp(c)) infix.push(String.valueOf(c));
      else {
        String operand1 = infix.pop();
        String operand2 = infix.pop();
        String res = "(" + operand1 + String.valueOf(c) + operand2 + ")";
        infix.push(res);
      }
    }
    String infix_exp = infix.pop();
    n = infix_exp.length();

    // Infix to Postfix
    StringBuilder result = new StringBuilder("");
    Stack<Character> symbols = new Stack<>();
    for (int i = 0; i < n; i++) {
      char c = infix_exp.charAt(i);
      if (c == '(') symbols.push(c);
      else if (Character.isLetterOrDigit(c)) result.append(c);
      else if (c == ')') {
        while (symbols.peek() != '(') result.append(symbols.pop());
        symbols.pop();
      } else {
        // Operator
        int pref = pref(c);
        while (!symbols.isEmpty() && pref <= pref(symbols.peek())) {
          result.append(symbols.pop());
        }
        symbols.push(c);
      }
    }

    while (!symbols.isEmpty()) result.append(symbols.pop());

    return result.toString();
  }
}
