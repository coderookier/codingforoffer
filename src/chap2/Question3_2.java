package chap2;

/**
 * @author gutongxue
 * @date 2019/9/5 14:13
 **/
public class Question3_2 {
    /**
     * 不修改数组找出重复的数字
     *
     * 1.使用O(n)辅助空间，将原数组元素m复制到辅助数组中下标m位置，时间复杂度O(n)
     *
     * 2.二分查找，时间复杂度为O(nlogn)，空间复杂度O(1)，以时间换空间
     */
    public int getDuplication(int[] nums) {
        //无效输入，空
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 1, end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            //start ~ mid出现的次数
            int count = countRange(nums, start, mid);
            if(start == end) {
                //找到重复的数字
                if (count > 1) {
                    return start;
                }
                else {
                    break;
                }
            }
            //start ~ mid出现次数大于区间大小,则重复的数字在start ~ mid之间
            if (count > (mid - start + 1)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     *统计数字start ~ end出现的次数
     */
    private int countRange(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,4,3,2,6,7};
        Question3_2 question32 = new Question3_2();
        System.out.println("重复数字为：" + question32.getDuplication(nums));
    }
}
