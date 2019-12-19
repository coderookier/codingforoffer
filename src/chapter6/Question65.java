package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/18 21:39
 * 不用加减乘除做加法
 * 只能用位运算了
 **/
public class Question65 {
    public int add(int num1, int num2) {
        //sum为各位相加不计进位的结果，即按位异或
        //carry为进位信息，即按位与后左移一位
        int sum, carry;
        sum = num1 ^ num2;
        carry = (num1 & num2) << 1;
        //两者相加即为两数之和
        sum += carry;
        return sum;
    }

    public static void main(String[] args) {
        Question65 question65 = new Question65();
        System.out.println(question65.add(12, 36));
    }
}
