package chap3;

/**
 * @author gutongxue
 * @date 2019/10/6 21:05
 * 输入一个数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 **/
public class Question21 {
    public void recorderOddEven(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        //定义两个指针，分别指向数组头尾
        int pBegin = 0;
        int pEnd = nums.length - 1;
        while (pBegin < pEnd) {
            //向后移动pBegin，直到指向偶数
            while (pBegin < pEnd && (nums[pBegin] & 1) == 1) {
                pBegin++;
            }

            //向前移动pEnd，直到指向奇数
            while (pBegin < pEnd && (nums[pEnd] & 1) == 0) {
                pEnd--;
            }

            //偶奇交换
            if (pBegin < pEnd) {
                int temp = nums[pBegin];
                nums[pBegin] = nums[pEnd];
                nums[pEnd] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Question21 question21 = new Question21();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        question21.recorderOddEven(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
