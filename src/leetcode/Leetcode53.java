package leetcode;

/**
 * @author gutongxue
 * @date 2019/9/27 14:37
 * 求出给定整数数组的具有最大和的连续子数组，并返回其最大和
 * 动态规划
 **/
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            //前i-1项的和为非正数，则对新的和没有增益作用
            if (sum <= 0) {
                sum = nums[i];
            }
            //前i-1项的和为正数
            else {
                sum += nums[i];
            }
            //新的和与当前已知的最大值比较
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leetcode53.maxSubArray(nums));
    }
}
