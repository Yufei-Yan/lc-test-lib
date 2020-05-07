/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-03 17:07:27 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-05-06 05:39:23
 */
package lc.test;

/**
 * Definition for singly-linked list.
 * Adopted from leetcode.
 * 
 * @author Yufei Yan
 * @version 0.0.1
 */
public class ListNode<T> {
  public T val;
  public ListNode<T> next;
  public ListNode<T> prev;
  
  /**
   * Constructor.
   * @param x input integer value
   */
  public ListNode(T x) {val = x;}
}