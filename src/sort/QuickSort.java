package sort;

/**
 * @author gutongxue
 * @date 2019/9/16 15:15
 * 快速排序是一种分治的排序算法，其与归并排序是互补的，所有子数组有序后整个数组自然有序
 * 长度为N的数组进行快速排序的时间复杂度为1.39O(NlogN)
 * 快速排序最多需要进行N^2/2次比较，随机打乱数组能够防止这种情况
 **/
public class QuickSort {
    /**
     * 快速排序
     */
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        //打乱数组
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 打乱数组
     */
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //将a[i]与a[i,..,N-1]中任意一个元素交换
            int r = i + (int)(Math.random() * (N - i));
            swap(a, i, r);
        }
    }

    private static void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    /**
     * 快速排序的切分
     */
    public static int partition(int[] a, int low, int high) {
        //左右扫描指针
        int i = low, j = high + 1;
        //切分元素
        int v = a[low];
        while (true) {
            //检查扫描是否结束并交换元素
            while (a[++i] < v) {
                if (i == high) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //交换元素
            swap(a, i, j);
        }
        //将切分元素v = a[j]放入正确位置
        swap(a, low, j);
        //根据j将数组分为两部分，分别再进行快速排序
        return j;
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
