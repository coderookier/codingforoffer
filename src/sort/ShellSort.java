package sort;

/**
 * @author gutongxue
 * @date 2019/11/16 20:14
 * 希尔排序，改进插入排序，使数组中任意间隔为h的元素都是有序的
 * h由大到小变化，当h为1时，数组排序
 **/
public class ShellSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //将数组变为h有序数组，当h变为1时，数组排序完成
            for (int i = h; i < n; i++) {
                //将a[i]插入到{..,a[i-2*h],a[i-h]}中，采用从右到左遍历
                for (int j = i; j >= h && nums[j] < nums[j - h]; j-=h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
