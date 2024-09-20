package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FenwickTree {
  public long[] tree;
  private int N;

  public FenwickTree(int n) throws IOException {
    if (n <= 0) {
      throw new IOException("Illegal array length");
    }
    this.N = n;
    this.tree = new long[n + 1];
  }

  public void update(int pos, long val) {
    for (int i = pos; i <= this.N; i += ((i) & (-i))) this.tree[i] += val;
  }

  public long sum1ToPos(int pos) {
    long res = 0;
    for (int i = pos; i > 0; i -= ((i) & (-i))) res += this.tree[i];

    return res;
  }

  public long rangeSum(int a, int b) {
    return sum1ToPos(b) - sum1ToPos(a - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int n = Integer.parseInt(in.readLine());
    FenwickTree bit = new FenwickTree(n);

    String[] tokens = in.readLine().split(" ");

    for (int i = 0; i < tokens.length; i++) bit.update(i + 1, Integer.parseInt(tokens[i]));

    final StringBuilder sb = new StringBuilder();
    sb.append("Fenwick tree: [");

    for (int i = 1; i < n; i++) sb.append(bit.tree[i]).append(", ");
    sb.append(bit.tree[n]).append("]");

    out.print(sb.toString());
    out.close();
  }
}
