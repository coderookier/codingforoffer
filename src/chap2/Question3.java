package chap2;

/**
 * @author gutongxue
 * @date 2019/9/5 17:07
 **/
public class Question3 {
    /**
     * 找出数组中重复的数字
     *
     * 1.排序数组，然后顺序扫描，时间复杂度O(nlogn)
     *
     * 2.哈希表，时间复杂度O(n),空间复杂度O(n)
     *
     * 3.下标与本身值比较，时间复杂度O(n)，空间复杂度O(1)
     */
    public int duplicate (int[] nums) {
        //无效输入，空
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        //无效输入,长度n的数组包含0~n-1之外的数字
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return -1;
            }
        }
        //顺序扫描数组中每个数字进行调整
        for (int i = 0; i < nums.length; i++) {
            //位置i上的元素nums[i]不等于i
            while (nums[i] != i) {
                //如果nums[i]等于nums[i]上的元素num[nums[i]],该元素即为重复元素
                //该元素在i和nums[i]上都出现了
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //如果nums[i]与nums[i]位置上元素不相等，则将该元素放回nums[i]位置上
                else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        Question3 question3 = new Question3();
        System.out.println("重复元素为：" + question3.duplicate(nums));
    }
}
