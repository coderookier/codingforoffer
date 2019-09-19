package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gutongxue
 * @date 2019/9/19 19:50
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class Leetcode3 {
    /**
     * 解法一、通过两个指针遍历字符串，进行多次重复比较，时间复杂度O(N^2)，空间复杂度也接近O(N^2)，属实有点弟弟
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        //第一个指针用来遍历字符串，第二个指针用于在第一个指针确认位置后移动确定无重复字符的长度
        int first = 0;
        int second;
        int longest = 1;
        while (first < s.length()){
            //记录当前无重复子串的长度
            int num = 0;
            //记录字符和索引映射
            Map<Character, Integer> map = new HashMap<>();
            for (second = first; second < s.length(); second++) {
                if (!map.containsKey(s.charAt(second))) {
                    map.put(s.charAt(second), second);
                    num++;
                }
                else {
                    first = map.get(s.charAt(second)) + 1;
                    break;
                }
            }
            longest = Math.max(num, longest);
            if (second == s.length()) {
                break;
            }
        }
        return longest;
    }
    /**
     * 解法二、采用滑动窗口，窗口HashSet中包含索引在[i,j)的字符
     */
    public int lengthOfLongestSubstring2 (String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int longest = 0, i = 0, j = 0;
        while (i < len && j < len) {
            //窗口中不包含该字符，则加入窗口
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                longest = Math.max(longest, j - i);
            }
            else {
                //如果重复的字符在i,j之间，则会一直删除左右的字符直至将重复的字符删除
                set.remove(s.charAt(i++));
            }
        }
        return longest;
    }
}
