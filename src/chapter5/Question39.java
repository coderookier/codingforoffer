package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/12 20:35
 * 找出数组中出现次数超过一半的数字,O(n)时间复杂度实现
 * 遍历数组时候保存两个值：1.数组中的一个数字 2.次数
 **/
public class Question39 {
    public int moreThanHalfNum(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new RuntimeException("invalid input parameters");
        }
        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++) {
            //times已经减为0，则将当前下标对应元素赋值给result
            if (times == 0) {
                result = numbers[i];
                times = 1;
            }
            //当前下标对应元素与result中的数字相等
            else if (numbers[i] == result) {
                times++;
            }
            //当前下标对应元素与result中的数字不相等
            else {
                times--;
            }
        }
        //如果出现次数大于数组长度一半，所以最终result的值一定为需要找的元素，需要检查该元素是否出现大于一半的次数
        if (checkMoreThanHalf(numbers, result)) {
            return result;
        }
        else {
            throw new RuntimeException("invalid input parameters");
        }
    }

    private boolean checkMoreThanHalf(int[] numbers, int number) {
        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                times++;
            }
        }
        return times * 2 >= numbers.length;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,2,2,2,5,4,2};
        int[] numbers2 = {1,2,3,5,3,2,7,8};
        Question39 question39 = new Question39();
        System.out.println(question39.moreThanHalfNum(numbers));
        System.out.println(question39.moreThanHalfNum(numbers2));
    }
}
