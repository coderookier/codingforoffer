package leetcode;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/11/2 16:03
 * 给定链表，返回链表开始入环的第一个节点，无环则返回null
 * 不允许修改链表的值
 **/
public class Leetcode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        /**
         * 1.通过快慢指针判断链表中是否有环
         */
        ListNode node = isCycle(head);
        //没有环
        if (node == null) {
            return null;
        }
        /**
         * 2. 确定环中节点数量
         */
        int num = numOfNode(node);

        /**
         * 快指针先移动num个节点，慢指针开始移动,指针在链表入口中相遇
         */
        ListNode first = head;
        ListNode second = head;
        while (num > 0) {
            first = first.next;
            num--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    private ListNode isCycle(ListNode head) {
        //一次移动1步
        ListNode slow = head.next;
        //一次移动2步
        ListNode fast = null;
        if (slow != null) {
            fast = slow.next;
        }
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        return null;
    }

    private int numOfNode(ListNode node) {
        int num = 1;
        //遍历滑动指针
        ListNode pNode = node;
        while (pNode.next != node) {
            num++;
            pNode = pNode.next;
        }
        return num;
    }
}
