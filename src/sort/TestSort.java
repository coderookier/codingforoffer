package sort;

/**
 * @author gutongxue
 * @date 2019/11/16 20:10
 **/
public class TestSort {

    /**
     * 快速排序，最优O(NlogN)，平均为O(NlogN)，最差为O(N^2)
     * 不稳定
     */
    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }
        int start = low, end = high, standard = arr[low];
        while (start < end) {
            while (start < end && arr[end] > standard) {
                end--;
            }
            while (start < end && arr[start] <= standard) {
                start++;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, low, start);
        quickSort(arr, low, start - 1);
        quickSort(arr, start + 1, high);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 归并排序，时间复杂度O(NlogN)，需要O(N)额外空间
     * 稳定
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }
    private void sort(int[] arr, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid, temp);
        sort(arr, mid + 1, high, temp);
        merge(arr, low, mid, high, temp);
    }
    private void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int first = low, second = mid + 1, index = low;
        while (first <= mid && second <= high) {
            if (arr[first] <= arr[second]) {
                temp[index++] = arr[first++];
            }
            else {
                temp[index++] = arr[second++];
            }
        }
        while (first <= mid) {
            temp[index++] = arr[first++];
        }
        while (second <= high) {
            temp[index++] = arr[second++];
        }
        for (index = low; index <= high; index++) {
            arr[index] = temp[index];
        }
    }


    /**
     * 选择排序，时间复杂度O(N^2)，空间复杂度O(1)
     * 不稳定排序
     */
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * 冒泡排序，时间复杂度最优为O(N)，平均和最差为O(N^2)，空间复杂度O(1)
     * 稳定排序
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    /**
     * 插入排序，时间复杂度最优为O(N)，平均和最差为O(N^2)
     * 稳定排序
     */
    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        TestSort testSort = new TestSort();
        int[] nums = {6,237,1,2,222,1212,33,11,2345,9,98,7};
        testSort.bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
