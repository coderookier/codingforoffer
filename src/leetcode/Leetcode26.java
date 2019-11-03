package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/3 16:15
 * 原地删除重复出现的元素，额外使用O(1)空间
 **/
public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //滑动遍历数组指针
        int index;
        //无重复元素区域指针
        int noDuplicatesIndex = 0;
        for (index = 0; index < nums.length; index++) {
            if (nums[index] != nums[noDuplicatesIndex]) {
                nums[++noDuplicatesIndex] = nums[index];
            }
        }
        int res = noDuplicatesIndex + 1;
        return res;
    }
}
