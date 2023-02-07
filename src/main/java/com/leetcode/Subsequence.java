package com.leetcode;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the
 * remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 */
public class Subsequence
{
  public static void main(String[] args) {

  }

  public boolean isSubsequence(String s, String t) {
    int count=0;
    int len_s = s.length();
    int len_t = t.length();
    if(len_s == 0) return true;
    if(len_t == 0) return false;
    for(int i=0 ; i<len_t ; i++){
      if(s.charAt(count) == t.charAt(i)){
        count++;
        if(count>=len_s){
          return true;
        }
      }
    }
    return false;
  }
}
