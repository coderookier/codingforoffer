package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/30 19:36
 * 在55题的基础上，使用最少次数跳跃到最后位置
 **/
public class Leetcode45 {
    public int jump(int[] nums) {
        //记录各点到达最后位置的最小跳跃次数，不能到达则记MAX_VALUE
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        int value;
        for (int i = nums.length - 2; i >= 0; i--) {
            value = Integer.MAX_VALUE;
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            else {
                for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                    if (dp[i + j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    else {
                        value = Math.min(value, dp[i + j] + 1);
                    }
                }
            }
            dp[i] = value;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Leetcode45 leetcode45 = new Leetcode45();
        System.out.println(leetcode45.jump(nums));
    }
}
