package neetcode.practice.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
  // Approach: Keep a track of only the middle element(s)
  private PriorityQueue<Integer> present;
  private PriorityQueue<Integer> future;
  private PriorityQueue<Integer> past;

  public MedianFinder() {
    this.present = new PriorityQueue<>();
    this.future = new PriorityQueue<>();
    this.past = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    // If you are in the first two steps of the process
    if (this.future.isEmpty() && this.past.isEmpty() && this.present.size() < 2)
      this.present.add(num);
    // For any future steps
    else if (this.present.size() == 2) {
      // Preliminary: If future and past are empty
      if (this.past.isEmpty() && this.future.isEmpty()) {
        int val1 = this.present.poll();
        int val2 = this.present.poll();
        if (num < val1) {
          this.past.add(num);
          this.present.add(val1);
          this.future.add(val2);
        } else if (num > val2) {
          this.past.add(val1);
          this.present.add(val2);
          this.future.add(num);
        } else {
          this.past.add(val1);
          this.present.add(num);
          this.future.add(val2);
        }
      } else {
        // If there are two elements in the median queue
        // The size must now reduce to one
        if (num < this.past.peek()) {
          this.past.add(num);
          int val = this.present.poll();
          this.future.add(this.present.poll());
          this.present.add(val);
        } else if (num > this.future.peek()) {
          this.future.add(num);
          this.past.add(this.present.poll());
        } else {
          int val1 = this.present.poll();
          int val2 = this.present.poll();
          if (num < val1) {
            this.past.add(num);
            this.present.add(val1);
            this.future.add(val2);
          } else if (num > val2) {
            this.past.add(val1);
            this.present.add(val2);
            this.future.add(num);
          } else {
            this.past.add(val1);
            this.present.add(num);
            this.future.add(val2);
          }
        }
      }
    } else {
      // There is only one element in the median queue
      if (num < this.past.peek()) {
        this.present.add(this.past.poll());
        this.past.add(num);
      } else if (num > this.future.peek()) {
        this.present.add(this.future.poll());
        this.future.add(num);
      } else this.present.add(num);
    }
  }

  public double findMedian() {
    double ans = -1.0;
    if (this.present.size() == 1) ans = this.present.peek();
    else {
      int num1 = this.present.poll();
      int num2 = this.present.poll();
      ans = (num1 + num2) / 2.0;
      this.present.add(num1);
      this.present.add(num2);
    }
    return ans;
  }
}
