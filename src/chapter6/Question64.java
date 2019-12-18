package chapter6;

/**
 * @author gutongxue
 * @date 2019/12/18 21:30
 * 求1+2+...+n
 **/
public class Question64 {
    public int getSum(int n) {
        int sum = n;
        //利用&&的性质，前半部分为false则直接返回，故n <= 0是不进入递归了。
        boolean flag = ((n > 0) && (sum += getSum(n-1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Question64 question64 = new Question64();
        System.out.println(question64.getSum(100));
    }
}
