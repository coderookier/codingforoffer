package chap3;

/**
 * @author gutongxue
 * @date 2019/10/5 15:32
 * 输入数字n，顺序打印从1到最大的n位十进制数
 * 由于不知n的范围，因此在字符串上模拟数字加法并且打印数字
 **/
public class Question17 {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        //用数组存储数字各位上的数字
        int[] number = new int[n];
        while (!increment(number, n)) {
            printNumber(number, n);
        }
    }

    /**
     * 在表示数字的字符串上加1并判断是否出界
     */
    private boolean increment(int[] number, int n) {
        boolean isOverflow = false;
        //进位
        int nTakeOver = 0;
        for (int i = n - 1; i >= 0; i--) {
            int nSum = number[i] + nTakeOver;
            if (i == n - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                }
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = nSum;
                }
            }
            else {
                number[i] = nSum;
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印字符串表示的数字
     * 注意：前面的初始0不应该被打印出来
     */
    private void printNumber(int[] number, int n) {
        boolean isBeginning0 = true;
        String str = "";
        for (int i = 0; i < n; i++) {
            if (isBeginning0 && number[i] != 0) {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                str += number[i];
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        question17.print1ToMaxOfNDigits(3);
    }
}
