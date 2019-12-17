package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/5 20:27
 * 数组中数值和下标相等的元素
 * 单调递增的数组中每个元素是整数且唯一
 **/
public class Question53_3 {
    public int getNumberSameAsIndex(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == mid) {
                return mid;
            }
            //假设numbers[mid] > mid，则对任意正整数k,numbers[mid] + k > mid + k，又数组递增，所以numbers[mid + k] >= numbers[mid] + k
            else if (numbers[mid] > mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {-3, -1, 1, 3, 5};
        Question53_3 question53_3 = new Question53_3();
        System.out.println(question53_3.getNumberSameAsIndex(numbers));
    }

}
