package sort;

/**
 * @author gutongxue
 * @date 2019/10/15 17:06
 * 重复比较相邻的元素，如果第一个数比第二个大，则交换位置，最开始从第一对一直交换到最后一对，一趟排序后则最大数存在在最后位置。对于未排序的部分重复上述交换操作。
 * 手写冒泡排序，需要进行优化，即最佳情况（原数组已经排序）时时间复杂度为O(N)
 **/
public class BubbleSort {
    public void bubbleSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        //用来判断是否需要进行下一轮交换
        boolean didSort = false;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                //4,5,7,3,2 --> 4,5,3,7,2 --> 4,5,3,2,7
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    didSort = true;
                }
            }
            if (!didSort) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] data = {2,5,1,99,0,12,46,7};
        bubbleSort.bubbleSort(data);
        for (int num : data) {
            System.out.println(num);
        }
    }
}
