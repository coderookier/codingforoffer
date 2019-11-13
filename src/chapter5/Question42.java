package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/13 21:46
 * 求连续数组的最大和
 **/
public class Question42 {
    /**
     * 解法一：遍历数组直接记录
     * @param nums
     * @return
     */
    public int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("invalid input");
        }
        //当前子数组和
        int nCurrentSum = 0;
        //子数组最大和
        int GreatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nCurrentSum <= 0) {
                nCurrentSum = nums[i];
            }
            else {
                nCurrentSum += nums[i];
            }
            if (nCurrentSum > GreatestSum) {
                GreatestSum = nCurrentSum;
            }
        }
        return GreatestSum;
    }


    /**
     * 解法二：动态规划
     */
    public int findGreatestSumOfSubArray2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("invalid input");
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            }
            else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = max >= dp[i] ? max : dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Question42 question42 = new Question42();
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        System.out.println(question42.findGreatestSumOfSubArray(nums));
        System.out.println(question42.findGreatestSumOfSubArray2(nums));
    }
}
