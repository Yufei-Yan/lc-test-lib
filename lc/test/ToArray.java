/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-02-22 10:05:37 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-02-22 10:19:41
 */
package lc.test;
import lc.verification.Verify;

/**
 * Convert the input string to an array.
 * 
 * @author Yufei Yan
 * @version 0.1.1
 */
public class ToArray {
  public static String[] stringArray(String input) {
    Verify.verifyString(input);

    if (null == input || 0 == input.length()) return new String[0];
    return input.substring(1, input.length() - 1).split(",");
  }

  /**
   * Convert the input string to an integer (primitive) array.
   * Every string must be represented by a number, not "null" or other non-numerical strings.
   * 
   * @param input the input string.
   * @throws NumberFormatException for non-numerical strings.
   * @return an integer (primitive) array containing numbers from the input string.
   */
  public static int[] intArray(String input) throws NumberFormatException {
    String[] segments = ToArray.stringArray(input);
    
    int[] result = new int[segments.length];
    for (int i = 0; i < segments.length; ++i) {
      result[i] = Integer.parseInt(segments[i].trim());
    }

    return result;
  }

  /**
   * Convert the input string to an integer (object) array.
   * 
   * @param input the input string.
   * @return an integer (object) array containing numbers from the input string.
   */
  public static Integer[] integerArray(String input) {
    String[] segments = ToArray.stringArray(input);
    Integer[] result = new Integer[segments.length];

    for (int i = 0; i < result.length; ++i) {
      try {
        result[i] = Integer.parseInt(segments[i]);
      } catch(NumberFormatException e) {
        if (segments[i].equals("null")) result[i] = null;
        else throw e;
      } catch(NullPointerException e) {
        throw e;
      }
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

    String input2 = "[1,2,null,3]";
    Integer[] nums2 = ToArray.integerArray(input2);
    for (Integer x : nums2) {
      if (x == null) System.out.print("null ");
      else System.out.print(x + " ");
    }
    System.out.println();
  }
}