package neetcode.practice.Stack;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class _3_reversePolishNotation {
  public static int evalRPN(String[] tokens) throws IOException {
    Deque<String> stack = new ArrayDeque<>();

    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int operand1 = Integer.valueOf(stack.pop());
        int operand2 = Integer.valueOf(stack.pop());
        switch (token) {
          case "+":
            stack.push(String.valueOf(operand1 + operand2));
            break;
          case "-":
            stack.push(String.valueOf(operand2 - operand1));
            break;
          case "*":
            stack.push(String.valueOf(operand2 * operand1));
            break;
          case "/":
            stack.push(String.valueOf(operand2 / operand1));
            break;

          default:
            throw new IOException();
        }
      } else stack.push(token);
    }

    return Integer.valueOf(stack.peek());
  }

  public static void main(String[] args) throws IOException {
    String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
    System.out.println(evalRPN(tokens));
  }
}
