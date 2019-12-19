package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/19 10:17
 * 构建乘积数组
 **/
public class Question66 {
    public int[] multiplyArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int len = nums.length;
        //array1[i] = nums[0]*nums[1]*...*nums[i-1]
        int[] array1 = new int[len];
        //array2[i] = nums[i+1]*...*nums[n-2]*nums[n-1]
        int[] array2 = new int[len];
        //array[i] = array1[i] * array2[i]
        int[] array = new int[len];

        array1[0] = 1;
        for (int i = 1; i < len; i++) {
            array1[i] = array1[i-1] * nums[i-1];
        }

        array2[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            array2[i] = array2[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            array[i] = array1[i] * array2[i];
        }
        return array;
    }

    public static void main(String[] args) {
        Question66 question66 = new Question66();
        int[] nums = {1,2,3,4,3,5,6};
        int[] array = question66.multiplyArray(nums);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
