package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/19 20:27
 * 数字序列中第n位是什么
 * 序列格式是0123456789101112131415161718192021....
 **/
public class Question44 {
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        //当前所处序列中数字的位数
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            //index在digits位数部分
            if (index < digits * numbers) {
                //确定在digits位数中的位置，从而找到值
                return digitAtIndex(index, digits);
            }
            index -= numbers * digits;
            digits++;
        }
    }

    /**
     * digits位数有多少个
     */
    private int countOfIntegers(int digits) {
        //个位数有10个
        if (digits == 1) {
            return 10;
        }
        else {
            int count = (int) Math.pow(10, digits - 1);
            return 9 * count;
        }
    }

    private int digitAtIndex(int index, int digits) {
        //位于哪个数字之内
        int number = index / digits + beginNumber(digits);
        //确定数的第num位，从右边开始
        int num = digits - index % digits;
        for (int i = 1; i < num; i++) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * digits位数的起始数字
     */
    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int)Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        Question44 question44 = new Question44();
        System.out.println(question44.digitAtIndex(1001));
    }
}
