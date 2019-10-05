package chap3;

/**
 * @author gutongxue
 * @date 2019/10/5 14:28
 * 求数值的整数次方
 * 注意底数为0或指数小于1的情况
 **/
public class Question16 {
    public double power(double base, int exponent) {

        //无效输入
        if (base == 0.0 && exponent <= 0) {
            throw new RuntimeException("Invalid Input!");
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * 使用递归
     */
    private double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        //指数为奇数，需要再乘一次底数，用位于运算速度比求雨或乘除速度快
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        System.out.println(question16.power(2, 3));
        System.out.println(question16.power(3,3));
        System.out.println(question16.power(0, 0));
    }
}
