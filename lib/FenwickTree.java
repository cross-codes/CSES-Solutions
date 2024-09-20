import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FenwickTree {
  public final long[] arr;
  private final long[] tree;
  private final int N;

  public FenwickTree(int n) {
    this.arr = new long[n + 1];
    this.tree = new long[n + 1];
    this.N = n;
  }

  public void add(int k, long x) {
    while (k <= this.N) {
      this.tree[k] += x;
      k += Integer.lowestOneBit(k);
    }
  }

  public long sumq(int k) {
    long s = 0L;
    while (k >= 1) {
      s += this.tree[k];
      k -= Integer.lowestOneBit(k);
    }
    return s;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int n = Integer.parseInt(in.readLine());
    FenwickTree bit = new FenwickTree(n);

    String[] tokens = in.readLine().split(" ");

    for (int i = 0; i < tokens.length; i++) bit.add(i + 1, Integer.parseInt(tokens[i]));

    final StringBuilder sb = new StringBuilder();
    sb.append("Fenwick tree: [");

    for (int i = 1; i < n; i++) sb.append(bit.tree[i]).append(", ");
    sb.append(bit.tree[n]).append("]");

    out.print(sb.toString());
    out.close();
  }
}