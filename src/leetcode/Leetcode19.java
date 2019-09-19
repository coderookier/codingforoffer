package leetcode;

import structure.ListNode;

/**
 * @author gutongxue
 * @date 2019/9/19 20:48
 * 删除链表的倒数第N个节点
 **/
public class Leetcode19 {
    /**
     *采用快慢指针，快指针先移动n步，慢指针再开始移动，则当快指针指到链表尾时，慢指针指向需要删除的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 1; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        Leetcode19 leetcode19 = new Leetcode19();
        ListNode node = leetcode19.removeNthFromEnd(head, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
