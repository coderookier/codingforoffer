package sort;

/**
 * @author gutongxue
 * @date 2019/11/16 20:10
 **/
public class TestSort {
    public static void main(String[] args) {
        int[] nums = {6,237,1,2,222,1212,33,11,2345,9,98,7};
        //MergeSort.sort(nums);
        QuickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
