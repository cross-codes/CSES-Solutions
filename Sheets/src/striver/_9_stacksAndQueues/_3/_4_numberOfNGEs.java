package striver._9_stacksAndQueues._3;

public class _4_numberOfNGEs {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    int[] ans = new int[queries];
    for (int idx = 0; idx < queries; idx++) {
      int num = arr[indices[idx]];
      int count = 0;
      for (int i = indices[idx]; i < N; i++) {
        if (num < arr[i]) {
          count++;
        }
      }
      ans[idx] = count;
    }
    return ans;
  }
}
