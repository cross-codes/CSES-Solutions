package striver._9_stacksAndQueues._1;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
  Queue<Integer> queue1 = new LinkedList<>();
  Queue<Integer> queue2 = new LinkedList<>();

  public MyStack() {}

  public void push(int x) {
    // Newly added element always in the front of queue1
    while (!queue1.isEmpty()) queue2.offer(queue1.poll());
    queue1.offer(x);
    while (!queue2.isEmpty()) queue1.offer(queue2.poll());
  }

  public int pop() {
    // Take out the first element (which is the latest pushed element)
    return queue1.poll();
  }

  public int top() {
    // Return the first element (which is the latest pushed element)
    return queue1.peek();
  }

  public boolean empty() {
    return queue1.isEmpty();
  }
}
