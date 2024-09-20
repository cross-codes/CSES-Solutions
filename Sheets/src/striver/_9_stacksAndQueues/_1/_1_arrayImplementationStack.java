package striver._9_stacksAndQueues._1;

class MyStack {
  private int top;
  private int arr[] = new int[1000];

  MyStack() {
    top = -1;
  }

  void push(int a) {
    arr[++top] = a;
  }

  int pop() {
    if (top == -1) return -1;
    int ans = arr[top];
    arr[top--] = 0;
    return ans;
  }
}
