package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/17 19:36
 * 数字0,1,2,..,n-1构成一个圆，每次删除圆圈里的第m个数字，求出最后一个数字
 * f(n,m) = [f(n-1,m) + m]%n
 **/
public class Question62 {
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        Question62 question62 = new Question62();
        System.out.println(question62.lastRemaining(5, 3));
    }
}
