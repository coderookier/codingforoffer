package chap2;

/**
 * @author gutongxue
 * @date 2019/9/16 15:56
 **/

/**
 * 旋转数组中的最小数字
 * 二分法
 */
public class Question11 {
    public int getMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("输入异常");
        }
        int left = 0;
        int right = nums.length - 1;
        //将mid初始化为left，防止出现数组为有序的情况
        int mid = left;
        while (nums[left] >= nums[right]) {
            //找到最小
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            //特殊情况，如{1,0,1,1,1}，只能进行顺序查找
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return orderQuery(nums, left, right);
            }
            //位于左半部分
            if (nums[mid] >= nums[left]) {
                left = mid;
            }
            //位于右半部分
            else if (nums[mid] <= nums[right]) {
                right = mid;
            }

        }
        return nums[mid];
    }
    private int orderQuery(int[] nums, int left, int right) {
        int min = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Question11 question11 = new Question11();
        int[] nums = new int[] {3,4,5,0,1,2,3};
        System.out.println(question11.getMin(nums));
        int[] nums2 = new int[] {1,0,1,1,1};
        System.out.println(question11.getMin(nums2));
    }
}
