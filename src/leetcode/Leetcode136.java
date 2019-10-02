package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/2 16:24
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次，找出那个只出现一次的元素
 **/
public class Leetcode136 {
    /**
     * 所有元素异或，则结果为只出现一次的元素
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode136 leetcode136 = new Leetcode136();
        int[] nums = {4,1,2,1,2};
        System.out.println(leetcode136.singleNumber(nums));
    }
}
