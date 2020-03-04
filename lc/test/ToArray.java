/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-02-22 10:05:37 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-02-22 10:19:41
 */
package lc.test;

/**
 * Convert the input string to an array.
 * 
 * @author Yufei Yan
 * @version 0.0.1
 */
public class ToArray {

  /**
   * Convert the input string to an integer array.
   * 
   * @param input the input string.
   * @return an integer array containing numbers from the input string.
   */
  public static int[] intArray(String input) {
    if (null == input) throw new IllegalArgumentException();
    
    String[] segments = input.substring(1, input.length() - 1).split(",");
    
    int[] result = new int[segments.length];
    for (int i = 0; i < segments.length; ++i) {
      result[i] = Integer.parseInt(segments[i].trim());
    }

    return result;
  }

  public static void main(String[] args) {
    String input = "[1, 2, 3]";

    int[] nums = ToArray.intArray(input);
    for (int x : nums) {
      System.out.print(x + " ");
    }
    System.out.println();
  }
}