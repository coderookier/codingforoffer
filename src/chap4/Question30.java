package chap4;

import java.util.Stack;

/**
 * @author gutongxue
 * @date 2019/10/25 21:12
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，在该栈中，调用min、push、pop的时间复杂度都是O(1)
 * 定义两个栈，数据栈用来存储数据，辅助栈用来实现时间复杂度为O(1)的min函数
 **/
public class Question30 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Question30() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        dataStack.push(value);
        //比较压入的元素与最小栈的栈顶值，压入两者中的最小值
        if (minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (minStack.isEmpty() || dataStack.isEmpty()) {
            throw new RuntimeException("No Element !");
        }
        dataStack.pop();
        minStack.pop();
    }

    public int min() {
        if (minStack.isEmpty() || dataStack.isEmpty()) {
            throw new RuntimeException("No Element !");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Question30 question30 = new Question30();
        question30.push(3);
        question30.push(9);
        question30.push(2);
        System.out.println(question30.min());
        question30.pop();
        System.out.println(question30.min());
    }
}
