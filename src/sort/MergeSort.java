package sort;

/**
 * @author gutongxue
 * @date 2019/11/22 20:21
 * 归并排序，任意长度为N的数组排序所需时间和NlogN成正比，额外所需空间也与N成正比
 * 长度为N的任意数组，自顶而下的归并排序需要(1/2)NlogN至NlogN比较，最多访问数组6NlogN次
 **/
public class MergeSort {
    //归并所需的辅助数组
    private static int[] aux;

    public static void sort(int[] a) {
        //一次性分配全局辅助数组空间
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 对数组a[low..high]进行自上而下的归并排序
     * 自上而下实现元素合并，从2到4个元素有序递增
     */
    private static void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }


    /**
     * 原地归并两个有序数组的方法
     */
    public static void merge(int[] a, int low, int mid, int high) {
        //将数组a[low..mid]与a[mid+1..high]归并
        int i = low, j = mid + 1;
        //将a[low..high]复制到aux[low..high]
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        //将数组归并保存到a[low..high]
        for (int k = low; k <= high; k++) {
            //左半边数组已经全部归并到结果中
            if (i > mid) {
                a[k] = aux[j++];
            }
            //右半边数组已经全部归并到结果中
            else if (j > high) {
                a[k] = aux[i++];
            }
            //右半部分元素较小
            else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            }
            //左半部分较小
            else {
                a[k] = aux[i++];
            }
        }
    }
}
