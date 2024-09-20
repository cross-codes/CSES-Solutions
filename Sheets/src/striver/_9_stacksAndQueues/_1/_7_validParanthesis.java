package striver._9_stacksAndQueues._1;

import java.util.Stack;

public class _7_validParanthesis {
  public static boolean isValid(String s) {
    Stack<Character> balance = new Stack<>();
    int n = s.length();
    for (int idx = 0; idx < n; idx++) {
      char c = s.charAt(idx);
      if (c == '[' || c == '(' || c == '{') {
        balance.push(c);
      } else {
        if (balance.isEmpty()) return false;
        else if (c == ']') {
          if (balance.peek() == '[') balance.pop();
          else return false;
        } else if (c == ')') {
          if (balance.peek() == '(') balance.pop();
          else return false;
        } else if (c == '}') {
          if (balance.peek() == '{') balance.pop();
          else return false;
        } else return false;
      }
    }
    if (!balance.isEmpty()) return false;
    return true;
  }
}
