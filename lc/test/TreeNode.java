/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-05-06 05:27:22 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-05-06 05:27:51
 */
package lc.test;

/**
 * Definition for a binary tree node.
 * Adopted from leetcode.
 * 
 * @author Yufei Yan
 * @version 0.1.1
 */
public class TreeNode<T> {
  public T val;
  public TreeNode<T> left;
  public TreeNode<T> right;

  /**
   * Constructor.
   * 
   * @param x input integer value
   */
  public TreeNode(T x) {val = x;}
}