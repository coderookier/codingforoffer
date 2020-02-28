package sort;

/**
 * @author gutongxue
 * @date 2020/2/27 16:24
 **/
public class SortSummary {

    /**
     * 快速排序，最优时间复杂度为O(NlogN)，最坏为O(N^2)，平均情况为O(NlogN)，空间复杂度为O(logN)
     * 需会推导最优和最差时的复杂度
     * 不稳定排序
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
     * 归并排序，最优，最差，平均情况下时间复杂度都为O(NlogN)，空间复杂度为O(N)
     * 推导时间复杂度与快速排序最优时类似
     * 稳定排序
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //用于存储排序后的结果
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    private void sort(int[] arr, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, temp, low, mid);
        sort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high);
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        //三个指针分别表示遍历第一个子数组指针，遍历第二个子数组指针，移动存放排序后的元素
        int first = low, second = mid + 1, index = low;
        while (first <= mid && second <= high) {
            if (arr[first] <= arr[second]) {
                temp[index++] = arr[first++];
            } else {
                temp[index++] = arr[second++];
            }
        }
        //未排序完的数组直接将剩余元素添加到temp中
        while (first <= mid) {
            temp[index++] = arr[first++];
        }
        while (second <= high) {
            temp[index++] = arr[second++];
        }
        //将排序完成的这部分赋给arr，供arr继续进行下轮排序
        for (index = low; index <= high; index++) {
            arr[index] = temp[index];
        }
    }


    /**
     * 冒泡排序。时间复杂度最优为O(N)，平均和最差为O(N^2)，空间复杂度为O(1)
     * 明确最优时间复杂度为O(N)
     * 稳定排序
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //此标识确保最优时复杂度为O(N)
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


    /**
     * 选择排序，时间复杂度为O(N^2)，空间复杂度为O(1)
     * 不稳定排序
     */
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //最小值对应的下标
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * 计数排序，时间复杂度为O(N + MAX-MIN + 1)，空间复杂度为O(MAX-MIN+1)
     * 适合数据比较集中的例子，如员工年龄排序，高考分数排名等，根据最大值与最小值的差建立一个数组，遍历数据，每出现一次将数组中对应下标位置元素+1
     * 遍历辅助数组，每个位置的元素修改为与之前位置所有位置的累加结果
     */

    /**
     * 基数排序，时间复杂度为O(N*K)，空间复杂度为O(N+K)，将整数按照位数分割成不同的数字，高位空缺则补零，每个位值使用计数排序，从最低位开始依次排序
     */

    /**
     * 桶排序，将给定数据分成不同区间，划分到有限数量的桶子中，是对计数排序的改进，弱化了对于数据不是连续增长时对空间的浪费
     * 应用在例如找到40亿个数中的中位数
     */



    public static void main(String[] args) {
        SortSummary sortSummary = new SortSummary();
        int[] arr = {2,4,1,8,4,3,6};
        sortSummary.selectSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
