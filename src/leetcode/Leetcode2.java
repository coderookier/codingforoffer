package leetcode;

import structure.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gutongxue
 * @date 2019/9/18 15:47
 **/
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //用两个队列来把两个链表的值输出，并用一个新队列来存放结果
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }
        //进位
        int c = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int num = queue1.poll() + queue2.poll() + c;
            c = num / 10;
            num %= 10;
            queue.add(num);
        }
        while (!queue1.isEmpty()) {
            int num = queue1.poll() + c;
            c = num / 10;
            num %= 10;
            queue.add(num);
        }
        while (!queue2.isEmpty()) {
            int num = queue2.poll() + c;
            c = num / 10;
            num %= 10;
            queue.add(num);
        }
        if (c > 0) {
            queue.add(c);
        }
        ListNode node = new ListNode(queue.poll());
        ListNode result = new ListNode(-1);
        result.next = node;
        while (!queue.isEmpty()) {
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return result.next;
    }
}
