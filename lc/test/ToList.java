/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-03 17:11:15 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-05-06 05:41:48
 */
package lc.test;

/**
 * Convert the input string to a linked list.
 * 
 * @author Yufei Yan
 * @version 0.1.1
 */
public class ToList<T extends Comparable<? super T>> {
  private T[] arr;

  /**
   * Constructor: assign the input array for internal use.
   * @param input
   */
  public ToList(T[] input) {
    arr = input;
  }
  /**
   * Convert the input string to a singly integer list.
   * @param input the input string.
   * @return the head of the list.
   */
  public ListNode<T> singlyList() {
    if (null == arr) return null;

    ListNode<T> head = new ListNode<>(arr[0]);
    ListNode<T> temp = head;
    for (int i = 1; i < arr.length; ++i) {
      temp.next = new ListNode<>(arr[i]);
      temp = temp.next;
    }

    return head;
  }

  public static void main(String[] args) {
    String input = "[1, 2, 3]";
    Integer[] arr = ToArray.integerArray(input);

    ToList<Integer> toList = new ToList<>(arr);

    ListNode<Integer> head = toList.singlyList();
    ListNode<Integer> temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}