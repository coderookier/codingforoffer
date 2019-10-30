package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/30 20:35
 * 搜索旋转排序数组
 **/
public class Leetcode33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序，如2,3,4,5,6,7,1
            if (nums[low] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //后半部分有序，如7,1,2,3,4,5,6
            else {
                //target在后半部分
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int target = 5;
        Leetcode33 leetcode33 = new Leetcode33();
        System.out.println(leetcode33.search(nums, target));
    }
}
