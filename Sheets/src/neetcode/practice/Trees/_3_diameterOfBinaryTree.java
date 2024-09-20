package neetcode.practice.Trees;

import java.util.ArrayDeque;

public class _3_diameterOfBinaryTree {
  public static int diameterOfBinaryTree(TreeNode root) {
    // Left depth, Right depth
    if (root == null) return 0;

    // Left BFS
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    if (root.left != null) queue.addLast(root.left);
    int leftDepth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.removeFirst();
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      leftDepth++;
    }

    // Right BFS
    queue.clear();
    if (root.right != null) queue.addLast(root.right);
    int rightDepth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.removeFirst();
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      rightDepth++;
    }

    return Math.abs(leftDepth - rightDepth - 1);
  }
}
