package chapter5;

/**
 * @author gutongxue
 * @date 2019/11/19 19:32
 * 整数1~n中1出现的次数
 * 分别计算个位，十位，百位...最高位上1出现的次数求和即可
 **/
public class Question43 {
    public int NumberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }

        //i = 1, 10, 100,...分别对应个位，十位，百位...上1出现的次数
        int i = 1;
        //1出现的次数
        int count = 0;
        int k;
        for (; i <= n; i *= 10) {
            count += n / (i * 10) * i;
            //不能写成count += n / 10;
            k = n % (10 * i);
            if (k > 2 * i - 1) {
                count += i;
            }
            else if (k >= i && k <= 2 * i - 1) {
                count += k - i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question43 question43 = new Question43();
        int n = 12;
        System.out.println(question43.NumberOf1Between1AndN(n));
    }
}
