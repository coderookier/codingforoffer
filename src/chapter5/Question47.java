package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/20 15:46
 * 从棋盘左上角按照规则走到右下角能够拿到最大礼物的价值
 **/
public class Question47 {
    public int getMaxValue(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = values[0][0];
        //先确定第一列和第一行的值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + values[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + values[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        int[][] values = {{1,10,3,8}, {12,2,9,6}, {5,7,4,11}, {3,7,16,5}};
        System.out.println(question47.getMaxValue(values));
    }
}
