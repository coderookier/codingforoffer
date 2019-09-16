package chap2;

/**
 * @author gutongxue
 * @date 2019/9/16 11:14
 **/

/**
 * fibonacci数列的应用
 * 青蛙一次可以上1级或者2级台阶，上n级台阶的有多少中跳法
 */
public class Question10_2 {
    public int jumpNum(int n) {
        if (n <= 2) {
            return n;
        }
        //对于n级台阶，第一次跳1级，则剩余的是n-1级台阶的跳法，第一次跳2级，则剩余的是n-2级台阶的跳法
        int current = 0;
        int preOne = 2;
        int preTwo = 1;
        for (int i = 3; i <= n; i++) {
            current = preOne + preTwo;
            preTwo = preOne;
            preOne = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Question10_2 question102 = new Question10_2();
        System.out.println(question102.jumpNum(10));
    }
}
