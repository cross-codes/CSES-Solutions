package striver._9_stacksAndQueues._1;

class MyQueue {
  int front, rear;
  int arr[] = new int[100005];

  MyQueue() {
    front = 0;
    rear = 0;
  }

  void push(int x) {
    arr[rear++] = x;
  }

  int pop() {
    if (front == rear) {
      return -1;
    } else {
      int ans = arr[front];
      for (int idx = front; idx < rear - 1; idx++) {
        arr[idx] = arr[idx + 1];
      }
      rear--;
      return ans;
    }
  }
}
