package striver._9_stacksAndQueues._1;

import java.util.Stack;

class MinStack {
  private Stack<Long> stk;
  private Stack<Long> stkMin;

  public MinStack() {
    stk = new Stack<>();
    stkMin = new Stack<>();
  }

  public void push(long val) {
    stk.push((long) val);
    if (!stkMin.isEmpty()) {
      stkMin.push(Math.min(val, stkMin.peek()));
    } else {
      stkMin.push(val);
    }
  }

  public void pop() {
    stk.pop();
    stkMin.pop();
  }

  public long top() {
    return stk.peek();
  }

  public long getMin() {
    return stkMin.peek();
  }
}
