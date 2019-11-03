package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/3 19:57
 * 寻找旋转排序数组中的最小值，数组中可逆存在重复元素
 **/
public class Leetcode154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("invalid input parameters");
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while (nums[left] >= nums[right]) {
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = left + (right -left) / 2;
            //此种情况下只能顺序查找
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return searchByOrder(nums);
            }
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else if (nums[right] >= nums[mid]) {
                right = mid;
            }
        }
        return nums[mid];
    }
    private int searchByOrder(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
