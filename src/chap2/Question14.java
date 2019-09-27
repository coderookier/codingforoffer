package chap2;

/**
 * @author gutongxue
 * @date 2019/9/25 20:27
 * 1.动态规划，剪绳子问题
 **/
public class Question14 {
    /**
     * 分解成最小问题，即绳子长度为2时，只能剪成两个长度为1的绳子
     */
    public int maxProductAfterCutting_solution1(int length) {
        //长度小于2时，0*length
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //存放子问题的解,索引小于3时不是子问题解，是用于计算的解
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            //分解成子问题，求出子问题最大值
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        max = products[length];
        return max;
    }

    /**
     *贪婪算法，按照既定策略来剪绳子，当length >= 5时，尽可能多的剪长度为3的绳子，当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
     */
    public int maxProductAfterCutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        //尽可能地剪去长度为3的绳子段
        int timesOf3 = length / 3;
        //剩下长度为4时，不能剪去3，剪成两段2
        if (length - 3 * timesOf3 == 1) {
            timesOf3 --;
        }
        int timesOf2 = (length - 3 * timesOf3) / 2;
        int max = (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
        return max;
    }


    public static void main(String[] args) {
        Question14 question14 = new Question14();
        System.out.println(question14.maxProductAfterCutting_solution1(8));
        System.out.println(question14.maxProductAfterCutting_solution2(8));
    }
}
