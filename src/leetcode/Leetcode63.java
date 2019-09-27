package leetcode;

/**
 * @author gutongxue
 * @date 2019/9/27 15:18
 * 在第62题的基础上，增加障碍物，即有障碍物的点路径条数为0
 **/
public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        //第一行或第一列中第一次遇到障碍物之前到达各点的路径数为1
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int j = 0; j < rows; j++) {
            if (obstacleGrid[j][0] == 1) {
                break;
            }
            dp[j][0] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        Leetcode63 leetcode63 = new Leetcode63();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(leetcode63.uniquePathsWithObstacles(obstacleGrid));
    }
}
