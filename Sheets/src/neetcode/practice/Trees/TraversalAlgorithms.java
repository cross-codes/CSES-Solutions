package neetcode.practice.Trees;

import java.util.ArrayDeque;
import java.util.Deque;

// For animations, refer to: https://builtin.com/software-engineering-perspectives/tree-traversal
public class TraversalAlgorithms {
  class DFS {
    // 1. Go to the left sub tree
    // 2. Visit node
    // 3. Go to the right sub tree
    public void inOrderTraversal(TreeNode root) {
      if (root != null) {
        inOrderTraversal(root.left);
        System.out.println(root.val + " ");
        inOrderTraversal(root.right);
      }
    }

    // 1. Visit node
    // 2. Go to the left sub tree
    // 3. Go to the right sub tree
    public void preOrderTraversal(TreeNode root) {
      if (root != null) {
        System.out.println(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
      }
    }

    // 1. Go to the left sub tree
    // 2. Go to the right sub tree
    // 3. Visit the node
    public void postOrderTraversal(TreeNode root) {
      if (root != null) {
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val + " ");
      }
    }
  }

  class BFS {
    // After visiting a node, put left and right children to a queue sequentially
    public void levelOrderTraversal(TreeNode root) {
      if (root == null) return;

      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        TreeNode node = queue.remove();
        System.out.println(node.val + " ");

        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
  }
}
