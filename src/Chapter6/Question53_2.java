package Chapter6;

/**
 * @author gutongxue
 * @date 2019/12/5 20:05
 * 求0~n-1中缺失的数字，长度为n-1的递增数组中数字都是唯一的且范围在[0,n-1]
 * 由于缺失数字前面的元素值与下标相同，后面的元素与下标不同，故可利用二分查找
 **/
public class Question53_2 {
    public int getMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        int mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] != mid) {
                if (mid == 0 || numbers[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        Question53_2 question53_2 = new Question53_2();
        System.out.println(question53_2.getMissingNumber(numbers));
    }
}
