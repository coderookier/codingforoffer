package dp;

/**
 * @author gutongxue
 * @date 2020/1/29 14:38
 * 机器人到达指定位置，从递归优化成动态规划
 * 机器人在位置M处，经过K步到达P
 **/
public class RobotWay {
    public int walk(int cur, int rest, int N, int P) {
        //剩余步数为0则完成一次尝试
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        //当前在位置1，则只能移动到2
        if (cur == 1) {
            return walk(2, rest - 1, N, P);
        }
        //当前在位置N，则只能移动到N-1
        if (cur == N) {
            return walk(N-1, rest - 1, N, P);
        }
        //其他位置可同时向左右两个位置尝试
        return walk(cur + 1, rest - 1, N, P) + walk(cur - 1, rest - 1, N, P);
    }

    public int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || P < 1 || P > N || M < 1 || M > N) {
            return 0;
        }
        return walk(M, K, N, P);
    }

    /**
     * 优化成动态规划
     * @param N 总共位置数，1,2,...,N
     * @param M 初始位置
     * @param K 需要移动步数
     * @param P 目标位置
     * @return
     */
    public int ways2(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N) {
            return 0;
        }
        //0~K行，1~N列
        int[][] dp = new int[K+1][N+1];
        //初始化第一行，只有一个位置为1，其他位置为0
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                //最左端依赖第二个位置
                if (j == 1) {
                    dp[i][j] = dp[i-1][2];
                }
                //最右端依赖倒数第二个位置
                else if (j == N) {
                    dp[i][j] = dp[i-1][N-1];
                }
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
        return dp[K][M];
    }

    public static void main(String[] args) {
        RobotWay robotWay = new RobotWay();
        int N = 5, M = 2, K = 3, P = 3;
        System.out.println(robotWay.ways1(5, 2, 3, 3));
        System.out.println(robotWay.ways2(N, M, K, P));
    }
}
