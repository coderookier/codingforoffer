package leetcode;

/**
 * @author gutongxue
 * @date 2019/9/27 15:18
 * 动态规划，dp[][]数组记录到达i,j位置有多少条路径
 **/
public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        //第一行所有值为1
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        //第一列所有值为1
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //其他位置的路径数等于左边的路径数加上面的路径数
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Leetcode62 leetcode62 = new Leetcode62();
        System.out.println(leetcode62.uniquePaths(7, 3));
    }
}
