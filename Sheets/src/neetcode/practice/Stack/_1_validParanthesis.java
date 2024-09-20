package neetcode.practice.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1_validParanthesis {
  public static boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') stack.push(c);
      else {
        if (stack.isEmpty()) return false;
        char top = stack.peek();

        switch (c) {
          case ')':
            if (top == '(') stack.pop();
            else return false;
            break;

          case ']':
            if (top == '[') stack.pop();
            else return false;
            break;

          case '}':
            if (top == '{') stack.pop();
            else return false;
            break;

          default:
            return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
