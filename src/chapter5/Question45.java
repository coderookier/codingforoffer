package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gutongxue
 * @date 2019/11/20 14:33
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 **/
public class Question45 {

    public void printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }
        //数组转为字符串数组易于比较
        String[] numberStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberStr[i] = numbers[i] + "";
        }
        Arrays.sort(numberStr, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : numberStr) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Question45 question45 = new Question45();
        int[] numbers = {3,32,321};
        question45.printMinNumber(numbers);
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        return str1.compareTo(str2);
    }
}
