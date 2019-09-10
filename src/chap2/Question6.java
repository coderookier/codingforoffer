package chap2;

/**
 * @author gutongxue
 * @date 2019/9/9 21:15
 **/

import structure.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 1.栈
 * 2.递归
 */
public class Question6 {
    /**
     * 方法一、遍历链表各节点，将值依次存入栈中，后将栈输出即可
     * @param node
     */
    public void printListReverse(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        //遍历将链表中数据依次放入栈中
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        //输出栈中数据
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 方法二、递归实现，每访问一个节点，输出其下一个节点再输出自己
     * @param node
     */
    public void printListReverse2(ListNode node) {
        if (node != null) {
            if (node.next != null) {
                printListReverse2(node.next);
            }
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(-1);
        ListNode node = new ListNode(0);
        headNode.next = node;
        for (int i = 1; i <= 9; i++) {
            ListNode nextNode = new ListNode(i);
            node.next = nextNode;
            node = node.next;
        }
        Question6 question6 = new Question6();
        question6.printListReverse(headNode.next);
        question6.printListReverse2(headNode.next);
    }
}
