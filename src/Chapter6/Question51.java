package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/2 21:04
 * 求数组中的逆序对
 * 归并排序实现
 **/
public class Question51 {
    //逆序数
    private int count;
    //辅助数组
    private int[] copy;

    public int inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        count = 0;
        copy = new int[data.length];
        mergeSort(data, 0, data.length - 1);
        return count;
    }

    private void mergeSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    public void merge(int[] data, int left, int mid, int right) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            copy[k] = data[k];
        }
        for (int k = left; k <= right; k++) {
            //左半边数组已经全部归并到结果中
            if (i > mid) {
                data[k] = copy[j++];
            }
            //右半边数组已经全部归并到结果中
            else if (j > right) {
                data[k] = copy[i++];
            }
            //右半部分元素较小
            else if (copy[j] < copy[i]) {
                data[k] = copy[j++];
                count += (mid - i + 1);
            }
            //左半部分较小
            else {
                data[k] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {
        Question51 question51 = new Question51();
        int[] data = {7, 5, 6, 4};
        System.out.println(question51.inversePairs(data));
    }
}
