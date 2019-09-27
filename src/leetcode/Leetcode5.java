package leetcode;

/**
 * @author gutongxue
 * @date 2019/9/27 10:29
 * 给定字符串的最长回文子串
 **/
public class Leetcode5 {
    /**
     *动态规划
     * dp[][]数组为字符串索引i,j之间是否为回文子串，并与当前已知的最长回文子串比较长度
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        //记录索引i,j之间的子串是否是回文串
        boolean[][] dp = new boolean[len][len];
        //当前的最长回文子串
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //i,j两处的字符相等，并且子串i+1,j-1是回文子串，则i,j子串也是回文子串
                if (s.charAt(i) == s.charAt(j) && ( j - i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res = (j - i + 1) > res.length() ? s.substring(i, j + 1) : res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome(""));
        System.out.println(leetcode5.longestPalindrome("babad"));
    }
}
