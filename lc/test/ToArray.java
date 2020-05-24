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
   * Convert the input string to a 2D character array.
   * 
   * @param input the input string.
   * @return a 2D character array
   */
  public static char[][] twoDCharArray(String input) {
    return null;
  }

  public static int[][] twoDIntArray(String input) throws NumberFormatException {
    Verify.verify2DString(input);

    String s = input.substring(1, input.length() - 1) + ",";
    String reg = "], *";
    String[] segments = s.split(reg);

    String[][] subSegments = new String[segments.length][];
    for (int i = 0; i < segments.length; ++i) {
      subSegments[i] = segments[i].substring(1, segments[i].length()).split(",");
    }

    int[][] result = new int[segments.length][];
    for (int i = 0; i < subSegments.length; ++i) {
      result[i] = new int[subSegments[i].length];
      for (int j = 0; j < subSegments[i].length; ++j) {
        result[i][j] = Integer.parseInt(subSegments[i][j].trim());
        System.out.print(subSegments[i][j] + ":" + result[i][j] + ", ");
      }
      System.out.println();
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

    String input3 = "[[1,2,3], [4,5,6]]";
    int[][] nums3 = ToArray.twoDIntArray(input3);
    for (int i = 0; i < nums3.length; ++i) {
      for (int j = 0; j < nums3[i].length; ++j) {
        System.out.print(nums3[i][j] + ", ");
      }
      System.out.println();
    }
  }
}