package neetcode.practice.Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1_invertBinaryTree {
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      TreeNode temp = node.right;
      node.right = node.left;
      node.left = temp;

      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }

    return root;
  }
}
