package chap4;

import java.util.Stack;

/**
 * @author gutongxue
 * @date 2019/10/25 21:43
 * 输入两个整数序列，第一个为栈的压入顺序，判断第二个是否为栈的弹出顺序
 **/
public class Question31 {
    /**
     * 可通过建立辅助栈，按照第一个序列中数字顺序压入栈，按照第二个序列顺序弹出栈
     */
    public boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null) {
            throw new RuntimeException("invalid input");
        }
        if (push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }
        //滑动指针
        int pushIndex = 0;
        int popIndex = 0;
        //辅助栈
        Stack<Integer> stack = new Stack<>();

        while (popIndex < pop.length) {
            //栈顶元素不等于当前弹出序列位置中的元素，则继续按照压入顺序压入数据到栈中
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            if (stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question31 question31 = new Question31();
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(question31.isPopOrder(push, pop1));
        System.out.println(question31.isPopOrder(push, pop2));
    }
}
