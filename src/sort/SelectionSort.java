package sort;

/**
 * @author gutongxue
 * @date 2019/11/16 19:34
 * 选择排序，长度为N的数组，需要N^2/2次比较和N次交换
 * 升序
 * 找到数组中最小的元素，将其和数组中的第一个元素交换位置，再在剩下的元素中找到最小的元素与数组中的第二个元素交换位置，
 * 如此往复直至整个数组排序
 **/
public class SelectionSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //最小元素索引位置
            int min = i;
            for (int j = i + 1; j < n; j++) {
                //(n-1) + (n-2) + ... + 1 = n(n-1)/2次比较
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //n次交换
            swap(nums, i, min);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
