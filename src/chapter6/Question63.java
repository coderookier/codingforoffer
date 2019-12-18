package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/18 21:14
 * 股票的最大利润
 **/
public class Question63 {
    public int maxDiff(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        //min为遍历到第i天时，前i-1天的最低价格，初始化为第0天
        int min = nums[0];
        //最大利润
        int maxProfit = nums[1] - min;
        //当前的最大利润
        int currentProfit = maxProfit;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i-1] < min) {
                min = nums[i-1];
            }
            currentProfit = nums[i] - min;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Question63 question63 = new Question63();
        int[] nums = {9,11,8,5,7,12,16,14};
        System.out.println(question63.maxDiff(nums));
    }
}
