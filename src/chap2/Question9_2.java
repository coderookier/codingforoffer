package chap2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gutongxue
 * @date 2019/9/16 9:40
 **/

/**
 * 两个队列实现栈
 */
public class Question9_2 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public Question9_2() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    //栈内压入元素
    public void push(int value) {
        //queue1负责压入数据到栈中,在压入新的数据前，先把queue2中的数据弹出并压入queue1中
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        queue1.add(value);
    }
    //栈内弹出元素
    public int pop() {
        //queue2负责弹出元素，弹出数据前，先将queue1中前size()-1个元素弹出并压入queue2中，剩余最后一个元素弹出即可
        //如果queue1为空，则抛出异常
        if (queue1.isEmpty()) {
            throw new RuntimeException("No Element");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        //需要抛出的元素
        int element = queue1.poll();
        //再将queue2中的元素放回queue1中
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return element;
    }

    public static void main(String[] args) {
        Question9_2 question92 = new Question9_2();
        for (int i = 0; i <= 9; i++) {
            question92.push(i);
        }
        question92.pop();
        question92.pop();
        question92.push(11);
        while (true) {
            System.out.println(question92.pop());
        }
    }
}
