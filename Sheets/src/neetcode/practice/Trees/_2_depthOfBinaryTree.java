package neetcode.practice.Trees;

import java.util.ArrayDeque;

public class _2_depthOfBinaryTree {

  public record Pair<K, V>(K key, V value) {}

  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public static int maxDepthBFS(TreeNode root) {
    if (root == null) return 0;

    int level = 0;
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.addFirst(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.removeFirst();
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      level++;
    }

    return level;
  }

  public static int maxDepthIterativeDFS(TreeNode root) {
    ArrayDeque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
    int res = 0;

    stack.addLast(new Pair<>(root, 1));
    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> data = stack.removeLast();

      if (data.key() != null) {
        TreeNode node = data.key();
        int depth = data.value();
        res = Math.max(res, depth);
        stack.addLast(new Pair<>(node.left, depth + 1));
        stack.addLast(new Pair<>(node.right, depth + 1));
      }
    }

    return res;
  }
}
