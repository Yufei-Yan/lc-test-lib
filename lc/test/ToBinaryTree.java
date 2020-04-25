/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-14 20:14:44 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-03-14 21:37:27
 */
package lc.test;

import lc.verification.Verify;
import java.util.Queue;
import java.util.ArrayDeque;
/**
 * Convert the input string to a binary tree.
 * 
 * @author Yufei Yan
 * @version 0.0.1
 */
public class ToBinaryTree {
  /**
   * Convert the input string a binary tree which has integer values.
   * 
   * @param input the input string.
   * @return the root of the binary tree.
   */
  public static TreeNode intBinaryTree(String input) {
    try {
      Verify.verifyString(input);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to convert the input string to binary tree.");
      System.out.println("null pointer is returned.");
      return null;
    }

    String[] segments = input.substring(1, input.length() - 1).split(",");

    if (segments[0].trim().equals("null")) return null;

    TreeNode root = new TreeNode(Integer.parseInt(segments[0].trim()));
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode cur = null;
    queue.offer(root);

    int len = segments.length;
    int i = 1;

    while (i < len) {
      cur = queue.poll();

      if (!segments[i].trim().equals("null")) {
        cur.left = new TreeNode(Integer.parseInt(segments[i].trim()));
        queue.offer(cur.left);
      }
      ++i;

      if (i < len && !segments[i].trim().equals("null")) {
        cur.right = new TreeNode(Integer.parseInt(segments[i].trim()));
        queue.offer(cur.right);
      }
      ++i;
      
    }

    return root;
  }

  /**
   * Tester.
   * 
   * @param args Commnad line arguments.
   */
  public static void main(String[] args) {
    //String input = "[10,5,15,3,7,null,18]";
    String input = "[10,5,15,3,7,13,18,1,null,6]";

    TreeNode root = ToBinaryTree.intBinaryTree(input);
    if (Verify.verifyBST(root)) {
      TreeNode cur = null;

      Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        cur = queue.poll();

        if (cur != null)  System.out.print(cur.val + " ");

        if (null != cur.left) queue.offer(cur.left);
        if (null != cur.right) queue.offer(cur.right);
      }
      System.out.println();
    }
  }
}