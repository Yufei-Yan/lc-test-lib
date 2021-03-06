/*
 * @Author: Yufei Yan (yanyufei11111@163.com) 
 * @Date: 2020-03-14 20:21:30 
 * @Last Modified by: Yufei Yan
 * @Last Modified time: 2020-03-14 21:13:44
 */
package lc.verification;

import lc.test.TreeNode;
/**
 * Class to make sure the input string is legal.
 * 
 * @author Yufei Yan
 * @version 0.1.1
 */
public class Verify {

  /**
   * To verify the input string.
   * Throws corresponding error messages for references.
   * 
   * @param s the input string.
   */
  public static void verifyString(String s) {
    if (null == s) 
      throw new IllegalArgumentException("The input string is null!");

    if (0 == s.length()) 
      throw new IllegalArgumentException("The input string is empty!");

    if ('[' != s.trim().charAt(0) || ']' != s.trim().charAt(s.trim().length() - 1))
      throw new IllegalArgumentException("The input string has to start with \"[\" and end with \"]\"");
  }

  /**
   * To verify the input string to be converted to a 2D array.
   * 
   * @param s the input string.
   */
  public static void verify2DString(String s) {
    Verify.verifyString(s);

    int left = 0;
    int right = 0;
    char[] ch = s.toCharArray();

    for (int i = 0; i < ch.length; ++i) {
      if (ch[i] == '[') ++left;
      else if (ch[i] == ']') ++right;

      if (right > left) throw new IllegalArgumentException("The input string has illegal matching brackets");
    }
  }

  // public static boolean verifyBST(TreeNode root) {
  //   return new Verify().verifyBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  // }

  // private boolean verifyBST(TreeNode root, int min, int max) {
  //   if (null == root) return true;

  //   if (root.val <= min || root.val >= max) return false;

  //   return verifyBST(root.left, min, root.val) && verifyBST(root.right, root.val, max);
  // }

  public static void main(String[] args) {
    String test1 = null;
    String test2 = "";
    String test3 = "123";
    String test4 = "[12]";
    
    try {
      Verify.verifyString(test1);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      Verify.verifyString(test2);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      Verify.verifyString(test3);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      Verify.verifyString(test4);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    String test5 = "[[1,2,3],[4,5,6]]";
    String test6 = "[]1,2,3],[4,5,6]]";
    try {
      Verify.verify2DString(test5);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      Verify.verify2DString(test6);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}