package chap2;

/**
 * @author gutongxue
 * @date 2019/9/26 19:29
 * 位运算
 * 注意: int位运算首先要进行模32运算再移位，即1<<33等于1<<1
 **/
public class Question15 {

    /**
     * 求整数n二进制表示中1的个数
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        //flag需要移动的位数
        int num = 0;
        while (num <= 31) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
            num++;
        }
        return count;
    }

    /**
     * 把一个整数减一，都是把最右边的1变成0，如果它右边还有0，则所有0都变成1，而它左边的所有位保持不变
     * 把一个整数减一，再和原整数做与运算，会把该整数最右边的1变成0。那么一个整数的二进制表示中有多少个1就可以进行多少次这样的运算
     * @param n
     * @return
     */
    public int NumberOf1_solution2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Question15 question15 = new Question15();
        System.out.println(question15.NumberOf1(-100));
        System.out.println(question15.NumberOf1_solution2(-100));
    }
}
