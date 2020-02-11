package dp;

/**
 * @author gutongxue
 * @date 2020/1/29 16:50
 * 数组给定货币的各种面额，求组成目标钱数aim需要的最少货币数
 **/
public class MinCoins {
    public int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        //初始化结果
        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            //使用k张arr[i]，剩余rest - k * arr[i]
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(next + k, res);
            }
        }
        return res;
    }

    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process(arr, 0, aim);
    }

    /**
     * 递归优化成动态规划
     * @param arr 给定货币面额数组
     * @param aim 给定的钱数
     * @return
     */
    public int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        //初始，最后一行除了dp[N][0]是0，其他都是-1
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i+1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        //返回值
        return dp[0][aim];
    }

    public static void main(String[] args) {
        MinCoins m = new MinCoins();
        int[] arr = {2,3,5};
        System.out.println(m.minCoins1(arr, 20));
        System.out.println(m.minCoins2(arr, 20));
    }
}
