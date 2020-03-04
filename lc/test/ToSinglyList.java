/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-03 17:11:15 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-03-03 17:22:22
 */
package lc.test;

public class ToSinglyList {

  /**
   * Convert the input string to a singly integer list.
   * @param input the input string.
   * @return the head of the list.
   */
  public static ListNode intList(String input) {
    if (null == input) throw new IllegalArgumentException();

    String[] segments = input.substring(1, input.length() - 1).split(",");

    ListNode head = new ListNode(Integer.parseInt(segments[0].trim()));
    ListNode temp = head;
    for (int i = 1; i < segments.length; ++i) {
      temp.next = new ListNode(Integer.parseInt(segments[i].trim()));
      temp = temp.next;
    }

    return head;
  }

  public static void main(String[] args) {
    String input = "[1, 2, 3]";

    ListNode head = ToSinglyList.intList(input);
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}