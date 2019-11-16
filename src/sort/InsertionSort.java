package sort;

/**
 * @author gutongxue
 * @date 2019/11/16 19:55
 * 插入排序，长度为N的数组，平均需要N^2/4比较和N^2/4次交换；最坏需要N^2/2比较和N^2/2次交换；最好需要N-1次比较和0次交换
 * 升序
 * 依次将元素插入到已经排序的数组中，数组的左半部分总是排序的，插入元素后，已排序部分的大于该元素的元素向右移动一位
 * 适用于局部有序的数组
 **/
public class InsertionSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            //将元素a[i]插入到{a[0],a[1],..,a[i-1]}中，采用从右向左遍历
            //有序时需要比较n-1次nums[j]与nums[j-1]，0次交换
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
