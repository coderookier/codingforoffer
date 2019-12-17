package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/5 19:43
 * 查找数字在排序数组中出现的次数
 * 通过二分查找分别找到第一次出现的下标和最后一次出现的下标
 * 复杂度O(logN)
 **/
public class Question53 {
    /**
     * 寻找第一个
     */
    public int getFirstK(int[] data, int k) {
        if (data == null || data.length <= 0) {
            return -1;
        }
        int left = 0, right = data.length - 1;
        int mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (data[mid] > k) {
                left = mid + 1;
            }
            else if (data[mid] < k) {
                right = mid - 1;
            }
            else {
                //如果前一个数也是k，那么第一个k必然还在前半部分
                if (mid >= 1 && data[mid - 1] == k) {
                    right = mid - 1;
                }
                else {
                    return mid;
                }
             }
        }
        return -1;
    }
    /**
     * 寻找最后一个
     */
    public int getLastK(int[] data, int k) {
        if (data == null || data.length <= 0) {
            return -1;
        }
        int left = 0, right = data.length - 1;
        int mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (data[mid] > k) {
                left = mid + 1;
            }
            else if (data[mid] < k) {
                right = mid - 1;
            }
            else {
                //如果后一个数也是k，那么第一个k必然还在后半部分
                if ((mid + 1) < data.length && data[mid + 1] == k) {
                    left = mid + 1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
    public int getNumberOfK(int[] data, int k) {
        int number = 0;
        int first = getFirstK(data, k);
        int last = getLastK(data, k);
        if (first > -1 && last > -1) {
            number = last - first + 1;
        }
        return number;
    }

    public static void main(String[] args) {
        Question53 question53 = new Question53();
        int[] data = {1,2,2,2,2,2,3,8};
        int k = 2;
        System.out.println("first: " + question53.getFirstK(data, k));
        System.out.println("last: " + question53.getLastK(data, k));
        System.out.println("times: " + question53.getNumberOfK(data, k));
    }
}
