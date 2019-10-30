package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/30 16:49
 * 给定一个非负整数数组，最初位于数组的第一个位置，数组中的元素代表可以跳跃的最大长度，判断能否到达最后一个位置
 **/
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("invalid input parameters");
        }
        if (nums.length == 1) {
            return true;
        }
        //存放各点能否到达结尾
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            //nums[i] == 0时为false不用改动
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        Leetcode55 leetcode55 = new Leetcode55();
        System.out.println(leetcode55.canJump(nums));
        System.out.println(leetcode55.canJump(nums2));
    }
}
