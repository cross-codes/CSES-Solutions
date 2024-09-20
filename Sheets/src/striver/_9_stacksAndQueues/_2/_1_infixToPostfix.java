package striver._9_stacksAndQueues._2;

import java.util.Stack;

public class _1_infixToPostfix {
  // A function to return precedence
  static int Prec(char ch) {
    switch (ch) {
        // Lowest precedence
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

        // Highest precedence
      case '^':
        return 3;
    }

    // Not an operator
    return -1;
  }

  public static String infixToPostfix(String exp) {
    StringBuilder result = new StringBuilder("");
    Stack<Character> stk = new Stack<>();
    long n = exp.length();

    for (int i = 0; i < n; i++) {
      char c = exp.charAt(i);

      // If c is an operand, add it to output
      if (Character.isLetterOrDigit(c)) result.append(c);

      // If c is '(' push it to the stack
      else if (c == '(') stk.push(c);

      // If c is ')' pop and output from the stack till you
      // encounter the nearest '('
      else if (c == ')') {
        while (stk.peek() != '(') result.append(stk.pop());
        stk.pop(); // Discard the '('
      }

      // If an operator is encountered
      else {
        // Either append all the higher or equal
        // priority characters to the result continually
        // Or push it onto the stack
        while (!stk.isEmpty() && Prec(c) <= Prec(stk.peek())) {
          result.append(stk.pop());
        }
        stk.push(c);
      }
    }

    // Remove whatever is left from the stack
    while (!stk.isEmpty()) {
      result.append(stk.pop());
    }
    return result.toString();
  }
}
