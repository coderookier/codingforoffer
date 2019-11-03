package leetcode;

/**
 * @author gutongxue
 * @date 2019/11/3 19:31
 * 寻找旋转排序数组中的最小值，假设不存在重复元素
 **/
public class Leetcode153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("invalid input parameters");
        }
        //在前升序部分的指针
        int left = 0;
        //在后升序部分的指针
        int right = nums.length - 1;
        int mid = left;
        while (nums[left] > nums[right]) {
            //right位置元素为最小值
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            //中间值位于前半部分
            if (nums[mid] > nums[left]) {
                left = mid;
            }
            //中间值位于后半部分
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[mid];
    }
}
