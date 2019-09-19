package sort;

/**
 * @author gutongxue
 * @date 2019/9/16 15:15
 **/
public class QuickSort {
    /**
     * 随机选择基准，将数组分为两部分
     * 时间复杂度
     * @param data
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] data, int start, int end) {
        if (data == null || data.length <= 0 || start < 0 || end >= data.length) {
            throw new RuntimeException("Invalid Parameters");
        }
        //生成start~end之间的随机数
        int index = (int)(Math.random() * (end - start) + start);
        //将随机选择的这个基准放到数组最后
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                //将这个小的数放到small所指位置
                if (small != index) {
                    swap(data, small, index);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }
    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void quickSort(int[] data, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] data = new int[]{5,2,3,8,6,9,10,1};
        quickSort.quickSort(data, 0, data.length - 1);
        for (int d : data) {
            System.out.println(d);
        }
    }
}
