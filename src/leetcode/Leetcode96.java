package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/2 17:05
 **/
public class Leetcode96 {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i-1];
            for (int j = 1; j < i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
