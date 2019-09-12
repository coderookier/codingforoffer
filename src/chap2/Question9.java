package chap2;

/**
 * @author gutongxue
 * @date 2019/9/12 21:23
 **/

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Question9 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Question9() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    //例如压入栈{a,b,c,d}
    public void push(int value) {
        stack1.push(value);
    }
    //弹出元素，即队列头，栈底元素弹出
    public int pop() {
        //当stack2为空时，将stack1中所有元素依次弹出并压入stack2中
        if (stack2.isEmpty()) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        //若stack2仍然为空，则无元素可弹出，抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No element");
        }
        //stack2不为空，则弹出其栈顶元素也即是队列头部元素
        return stack2.pop();
    }

    public static void main(String[] args) {
        Question9 question9 = new Question9();
        for (int i = 0; i <= 9; i++) {
            question9.push(i);
        }
        while (true) {
            System.out.println(question9.pop());
        }
    }
}
