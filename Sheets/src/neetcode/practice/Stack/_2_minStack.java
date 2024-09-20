package neetcode.practice.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

  private Deque<Integer> stack = new ArrayDeque<>();
  private Deque<Integer> minStack = new ArrayDeque<>();

  public MinStack() {
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty()) minStack.push(val);
    else if (val <= minStack.peek()) minStack.push(val);
  }

  public void pop() {
    int val = stack.pop();
    if (val == minStack.peek()) minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
