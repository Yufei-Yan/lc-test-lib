/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-14 20:14:44 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-05-06 05:29:18
 */
package lc.test;

import java.util.Queue;
import java.util.ArrayDeque;
/**
 * Convert the input string to a binary tree.
 * 
 * @author Yufei Yan
 * @version 0.1.1
 */
public class ToBinaryTree<T extends Comparable<? super T>> {
  private T[] arr;

  public ToBinaryTree(T[] input) {
    arr = input;
  }
  /**
   * Convert the input string a binary tree which has integer values.
   * 
   * @param input the input string.
   * @return the root of the binary tree.
   */
  public TreeNode<T> binaryTree() {
    if (null == arr || 0 == arr.length) return null;

    TreeNode<T> root = new TreeNode<>(arr[0]);
    Queue<TreeNode<T>> queue = new ArrayDeque<>();
    TreeNode<T> cur = null;
    queue.offer(root);
    
    int len = arr.length;
    int i = 1;
    while (i < len) {
      cur = queue.poll();
      if (arr[i] != null) {
        cur.left = new TreeNode<>(arr[i]);
        queue.offer(cur.left);
      }
      ++i;

      if (i < len && arr[i] != null) {
        cur.right = new TreeNode<>(arr[i]);
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
    Integer[] arr = ToArray.integerArray(input);

    ToBinaryTree<Integer> toBT = new ToBinaryTree<>(arr);
    TreeNode<Integer> root = toBT.binaryTree();

    // level order traversal to show all nodes
    TreeNode<Integer> cur = null;
    Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      cur = queue.poll();
      System.out.print(cur.val + " ");
      if (null != cur.left) queue.offer(cur.left);
      if (null != cur.right) queue.offer(cur.right);
    }
    System.out.println();
  }
}