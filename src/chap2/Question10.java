package chap2;

/**
 * @author gutongxue
 * @date 2019/9/16 10:26
 **/

/**
 * 斐波那契数列
 * 采用递归会存在大量重复计算，复杂度为O(2^N)
 */
public class Question10 {
    /**
     * 采用自下往上计算，不会存在重复计算，复杂度为O(N)
     */
    public int fibonacci (int n) {
        if (n <= 1) {
            return n;
        }
        int current = 0;
        int preOne = 1;
        int preTwo = 0;
        for (int i = 2; i <= n; i++) {
            current = preOne + preTwo;
            preTwo = preOne;
            preOne = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Question10 question10 = new Question10();
        System.out.println(question10.fibonacci(22));
    }
}
