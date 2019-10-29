package leetcode;

/**
 * @author gutongxue
 * @date 2019/10/29 20:40
 * 给定包含红白蓝三种元素的长度为n的数组，原地按照红、白、蓝进行排序
 * 0、1、2分别代表红白蓝
 **/
public class Leetcode75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        //维护三个指针
        //0区域指针
        int first = 0;
        //2区域指针
        int second = nums.length - 1;
        //滑动指针
        int index = 0;
        while (index <= second){
            //已经完全交换完毕
            if (index > second) {
                break;
            }
            else {
               if (nums[index] == 0) {
                   swap(nums, first, index);
                   first++;
                   index++;
               }
               else if (nums[index] == 2){
                   swap(nums, index, second);
                   second--;
                }
               else {
                   index++;
               }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
